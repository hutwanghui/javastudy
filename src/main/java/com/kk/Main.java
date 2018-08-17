package com.kk;

import java.util.*;

import static java.lang.Math.ceil;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> lenArr = new ArrayList<Integer>();
        List<Integer> dArr = new ArrayList<Integer>();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            lenArr.add(sc.nextInt());
            maxLen = Math.max(maxLen, lenArr.get(i));
        }
        for (int j = 0; j < n; j++) {
            dArr.add(sc.nextInt());
        }

        int result = core(lenArr, dArr, maxLen);
        System.out.println(result);
    }

    public static int core(List<Integer> lenArr, List<Integer> dArr, int maxLen) {
        int result = 0;
        int count = 0;
        for (int k = 0; k < lenArr.size(); k++) {
            if (lenArr.get(k) == maxLen) {
                result += lenArr.get(k);
                lenArr.remove(k);
                dArr.remove(k);
            }
        }
        lenArr.sort((i, j) -> j - i);
        dArr.sort((i, j) -> j - i);
        maxLen = dArr.get(0);
        for (int x = 0; x < dArr.size(); x++) {
            if (dArr.get(x) == maxLen) {
                count++;
            }
        }
        if (count > dArr.size() / 2) {
            return result + core(lenArr, dArr, maxLen);
        } else if (count == dArr.size() / 2) {
            return result + dArr.get(dArr.get(dArr.size() - 1));
        } else {
            return result;
        }
    }

}