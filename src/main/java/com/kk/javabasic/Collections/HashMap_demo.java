package com.kk.javabasic.Collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class HashMap_demo {
    static File filea = new File("search.txt");
    static File fileb = new File("search2.txt");

    static HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bra = new BufferedReader(new FileReader(filea));
        Scanner sa = new Scanner(bra);

        while (sa.hasNextLine()) {
            String line = sa.nextLine();
            String name = line.split(",")[1];
            if (hashmap.containsKey(name))
                hashmap.put(name, hashmap.get(name) + 1);
            else
                hashmap.put(name, 1);
        }


        BufferedReader brb = new BufferedReader(new FileReader(fileb));
        Scanner sb = new Scanner(brb);


        HashMap hashMapb = new HashMap();
        while (sb.hasNextLine()) {
            String name = sb.nextLine().split(",")[1];
            if (hashmap.containsKey(name)) {
                hashMapb.put(name, 1);
            }
        }
        System.out.println(hashMapb.toString());

        System.out.println("::::::::::::::::::::");

        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();

            System.out.println(key.toString() + " " + val.toString());
        }


    }
}
