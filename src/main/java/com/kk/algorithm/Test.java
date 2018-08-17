package com.kk.algorithm;

import java.util.*;
public class Test{
    /*public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] job = new int[N][2];
        for(int i = 0 ;i < N ;i++){
            job[i][0] = sc.nextInt();
            job[i][1] = sc.nextInt();
        }
        Arrays.sort(job,(e1,e2)-> (int) (e1[0] - e2[0]));
        for(int i = 1;i < job.length;i++){
            job[i][1] = Math.max(job[i-1][1],job[i][1]);
        }
        TreeMap<Integer,Integer> treemap = new TreeMap<Integer,Integer> ();
        for(int i=0 ; i< job.length;i++){
            treemap.put(job[i][0],job[i][1]);
        }
        for (int i = 0; i < M; i++) {
            int ability = sc.nextInt();
            Integer index = treemap.floorKey(ability);
            if (index != null) {
                System.out.println(treemap.get(index));
            } else {
                System.out.println(0);
            }
        }
    }*/
    static int a;
    int b;
    static int c;

    public int aMethod() {
        a++;
        return a;
    }

    public int bMethod() {
        b++;
        return b;
    }

    public static int cMethod() {
        c++;
        return c;
    }

    public static void main(String args[]) {
        Test test1 = new Test();
        test1.aMethod();
        System.out.println(test1.aMethod());
        Test test2 = new Test();
        test2.bMethod();
        System.out.println(test2.bMethod());
        Test test3 = new Test();
        test3.cMethod();
        System.out.println(test3.cMethod());
        String str=null;
        str.concat("abc");
        str.concat("123");
        System.out.println(str);
    }
}