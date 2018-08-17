package com.kk.algorithm.array;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 题目：之字打印
 * 思路：对角线打印，同时移动，x,y定向移动触底转弯
 */
public class printMertix_zhi {
    public static void printZhi(int[][] chars, int row1, int col1, int row2, int col2, boolean isUp) {
        //boolean用于区分是从右上往左下打印还是从左下向右上打印
        if (isUp) {
            //向上打印
            while (row2 != row1 - 1) {
                System.out.print(chars[row2--][col2++] + " ");
            }
        } else {
            //向下打印
            while (row1 != row2 + 1) {
                System.out.print(chars[row1++][col1--] + " ");
            }

        }
    }

    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        int endRow = arrays.length - 1;
        int endCol = arrays[0].length - 1;
        boolean isUp = false;
        //因为两个点是同步的，所以只要当row1点走到终点出界了就打印完成了
        while (row1 != endRow + 1) {
            printZhi(arrays, row1, col1, row2, col2, isUp);
            //当触最右边的时候row+1
            row1 = col1 == endCol ? row1 + 1 : row1;
            col1 = col1 == endCol ? col1 : col1 + 1;
            col2 = row2 == endRow ? col2 + 1 : col2;
            row2 = row2 == endRow ? row2 : row2 + 1;
            isUp = !isUp;
        }
    }
}
