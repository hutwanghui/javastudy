package com.kk.javabasic.Thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入锁，jdk1.5新增，能达到和synchronized相同的小果果，并且多了嗅探锁定，多路分支通知的功能，
 * 比synchronized灵活
 * 如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。读不会被锁（读01交替）
 * 如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁。（不交替）
 */
public class MyReentrantReadWriteLock {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final MyReentrantReadWriteLock test = new MyReentrantReadWriteLock();
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    test.get(Thread.currentThread());
                    test.set(Thread.currentThread());
                }

                ;
            }.start();
        }



    }

    /**
     * 读操作，用读锁
     *
     * @param thread
     */
    public void get(Thread thread) {
        //protected ReadLock(ReentrantReadWriteLock lock) {
        //        sync = lock.sync;
        //     }
        //public void lock() {
        //        sync.acquireShared(1);
        //     }
//        public final void acquireShared(int arg) {
//            if (tryAcquireShared(arg) < 0)
//                doAcquireShared(arg);
//        }
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            for (int i = 1; i < 5; i++) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }

    /**
     * 写操作：用写锁
     */
    public void set(Thread thread) {
//        protected WriteLock(ReentrantReadWriteLock lock) {
//            sync = lock.sync;
//        }
//        public void lock() {
//            sync.acquire(1);
//        }
//        public final void acquire(int arg) {
//            if (!tryAcquire(arg) &&
//                    acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
//                selfInterrupt();
//        }
        rwl.writeLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行写操作");
            }
            System.out.println(thread.getName() + "写操作完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }

}
