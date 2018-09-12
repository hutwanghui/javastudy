package com.kk.algorithm.DynamicProgramming;

/**
 * Created by hutwanghui on 2018/8/26.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class RunGrid {
    public static int[][] f(int[][] gird) {
        int[][] runArr = new int[gird.length][gird[0].length];
        runArr[0][0] = gird[0][0];
        for (int i = 1; i < gird[0].length; i++) {
            runArr[0][i] = gird[0][i] + runArr[0][i - 1];

        }
        for (int i = 1; i < gird.length; i++) {
            runArr[i][0] = gird[i][0] + runArr[i - 1][0];
        }
        for (int j = 1; j < gird.length; j++) {
            for (int k = 1; k < gird[0].length; k++) {
                int temp = Math.min(runArr[j - 1][k],runArr[j][k-1]);
                runArr[j][k] = Math.min(temp + gird[j][k], temp + gird[j][k]);
            }
        }
        return runArr;
    }

    public static void main(String[] args) {
        int[][] gird = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int[][] runArr = f(gird);
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; j++) {
                System.out.print(gird[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("==============");
        for (int i = 0; i < runArr.length; i++) {
            for (int j = 0; j < runArr[0].length; j++) {
                System.out.print(runArr[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
