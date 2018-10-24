package com.kk.algorithm.search;

import java.util.Arrays;

/**
 * Created by hutwanghui on 2018/8/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class binarySearch {
    //二分查找没有重复元素的有序集合
    public static int search_noRe(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            if (key == arr[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }
        }
        return -1;
    }

    //二分查找含有重复元素的有序集合，且返回第一个找到的
    //思路相对第一个就是相等继续搜索，直到全部搜索完，最后比较left是否合法
    public static int search_ReFindOne(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int lastFind = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= key) {
                if (arr[mid] == key) {
                    lastFind = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < arr.length && arr[left] == key) {
            return left;
        } else {
            return lastFind;
        }
    }


    public static int search_DgFindOne(int[] arr, int key, int left, int right) {
        int lasfFind = -1;
        int mid = left + (right - left) / 2;
        if (left > right) {
            return -1;
        }
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return search_DgFindOne(arr, key, left, mid - 1);
        } else {
            return search_DgFindOne(arr, key, mid + 1, right);
        }
    }

    public static int quickSortOneTime(int[] a, int i, int j)//一趟快速排序
    {
        int high,low,key;
        high = j;
        low = i;
        key = a[low];
        while(low < high)
        {
            while(key <= a[high] && low < high)
            {
                high--;
            }

            if( low < high)
            {
                a[low] = a[high];
                low++;
            }
            while(key >= a[low] && low < high)
            {
                low++;
            }
            if( low < high)
            {
                a[high] = a[low];
                high--;
            }
        }
        a[high] = key;
        return high;

    }


    public static void twoDepart(int[] a,int i,int j, int values)
    {
        int mid = quickSortOneTime(a,i,j);
        System.out.println("mid = " + mid + " i = "+i+" j = " + j);
        System.out.println(i < j);
        if(i < j)
        {
            if(a[mid] == values)
            {   System.out.println("ok, keyword is at " +mid );

            }
            else if(a[mid] < values )
            {
                i = mid +1;
                twoDepart(a,i,j,values);
            }
            else if(a[mid] > values)
            {
                j = mid -1;
                twoDepart(a,i,j,values);
            }
        }
        else if(i==j && a[mid] != values )
        {
            System.out.println("It doesn't exists");
        }
        else System.out.println("Finalily we find the keyword is at   " + mid );

    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10};
        int result = search_noRe(arr, 5);
        System.out.println(result);
        int[] arr2 = new int[]{1, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        int result2 = search_ReFindOne(arr2, 3);
        System.out.println(result2);
        int[] arr3 = new int[]{1, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9};
        int result3 = search_DgFindOne(arr3, 3, 0, arr3.length - 1);
        System.out.println(result3);
        int[] a = new int[] {1,4,9,3,24,21,6,9,9,7,6,5,3};
        int values = 4;
        int result4 = search_DgFindOne(a, 4, 0, a.length - 1);
        System.out.println(result4);
        twoDepart(a,0,a.length-1,values);

    }
}


