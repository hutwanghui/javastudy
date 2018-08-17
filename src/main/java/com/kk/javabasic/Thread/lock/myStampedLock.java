package com.kk.javabasic.Thread.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by hutwanghui on 2018/8/9.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 读写锁虽然分离了读和写的功能,使得读与读之间可以完全并发,但是读和写之间依然是冲突的,
 * 读锁会完全阻塞写锁,它使用的依然是悲观的锁策略.如果有大量的读线程,他也有可能引起写线程的饥饿
 * StampedLock则提供了一种乐观的读策略,读写之间不会阻塞对方，但是写和写之间还是阻塞的
 * 控制锁有三种模式（写，读，乐观读）
 */
public class myStampedLock {
    //java 8引入的新读写锁，采用乐观枷锁的方式
    private static StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) {
        ReadAndWriteService readAndWriteService = new ReadAndWriteService();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                readAndWriteService.read();
                readAndWriteService.write();
            }).start();
        }
    }

    public static class ReadAndWriteService {
        public void read() {
            // tryOptimisticRead方法尝试一个乐观读，返回一个邮戳，作为这一次锁获取的凭证
            // 票据，数字0表示没有写锁被授权访问
            long stamp = stampedLock.tryOptimisticRead();
            //看是否在刚才这段时间是否有写操作发生？然后你可以决定是否需要再试一次 或升级锁或放弃。
            if (!stampedLock.validate(stamp)) {

            }

            //与ReentrantReadWriteLock的不同就在于，这个读锁也是悲观的，但是可以改造
            long stampTime = stampedLock.readLock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "正在读取。。。。。");
                }
            } catch (Exception e) {

            } finally {
                stampedLock.unlockRead(stampTime);
            }
        }

        public void write() {
            //直接使用就是，排他写锁
            long stampTime = stampedLock.writeLock();
            try {
                for (int i = 0; i < 5; i++) {

                    System.out.println(Thread.currentThread().getName() + "正在写入。。。。。");
                }
            } catch (Exception e) {

            } finally {
                stampedLock.unlockWrite(stampTime);
            }
        }
    }
}
