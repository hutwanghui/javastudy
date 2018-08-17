package com.kk.algorithm.array;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 题目：转圈打印
 * 思路：每打印完一圈后，让左上角坐标(row1++,col++),右下角坐标(row2--,col--)，使得打印圈缩小
 */
public class printMertix_quan {
    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int row1 = 0;
        int col1 = 0;
        int row2 = arrays.length - 1;
        int col2 = arrays[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            printMertix(arrays, row1++, col1++, row2--, col2--);
        }
    }

    public static void printMertix(int[][] chars, int row1, int col1, int row2, int col2) {
        if (row1 == row2) {
            for (int i = 0; i < col2; i++) {
                System.out.print(chars[row1][col1++] + " ");
            }
        } else if (col1 == col2) {
            for (int i = 0; i < row2; i++) {
                System.out.print(chars[row1++][col1] + " ");
            }
        } else {
            int currentRow = row1;
            int currentCol = col1;
            while (currentCol != col2) {
                System.out.print(chars[row1][currentCol] + " ");
                currentCol++;
            }
            while (currentRow != row2) {
                System.out.print(chars[currentRow][col2] + " ");
                currentRow++;
            }
            while (currentCol != col1) {
                System.out.print(chars[row2][currentCol] + " ");
                currentCol--;
            }
            while (currentRow != row1) {
                System.out.print(chars[currentRow][col1] + " ");
                currentRow--;
            }
        }
    }
}
