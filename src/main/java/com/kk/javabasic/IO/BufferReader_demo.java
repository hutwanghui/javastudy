package com.kk.javabasic.IO;

import java.io.*;
import java.util.HashMap;

/**
 * Created by hutwanghui on 2019/3/4.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class BufferReader_demo {
    public static String file_path = "";

    public static HashMap<Integer, String> readCSVFile(String file_path) throws IOException {

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(file_path));
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] values = line.split(",");
                hashMap.put(Integer.valueOf(values[0]), values[1]);
                System.out.printf("读取到的数据: {%s} , {%s} \n", values[0], values[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bfr.close();
        }
        return hashMap;
    }

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> hashMap = BufferReader_demo.readCSVFile("F:\\tmp\\bufferedreader.csv");
        System.out.println(hashMap.toString());
    }
}
