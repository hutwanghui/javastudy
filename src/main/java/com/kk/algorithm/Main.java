package com.kk.algorithm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long k = sc.nextInt();
        long index = 0L;
        if (k == 0L) {
            index = n * n;
        }
        for (long y = k + 1; y <= n; y++) {
            index += (n / y) * (y - k) + Math.max(0, n % y - k + 1);
        }
        System.out.println(index);
    }
}