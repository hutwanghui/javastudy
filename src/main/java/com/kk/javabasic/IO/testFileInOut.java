package com.kk.javabasic.IO;

import java.io.*;

/**
 * Created by hutwanghui on 2018/9/24.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class testFileInOut {
    public static void main(String[] args) throws IOException {
        File file = new File("D://91.csv");
        File file_out = new File("D://911copy.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file_out);
        InputStreamReader inputStreamReader = new InputStreamReader(fis);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
        byte[] bytes = new byte[1024];
        String line = new String();
        try {
            int length = 0;
            BufferedReader br = new BufferedReader(inputStreamReader);
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                outputStreamWriter.write(strings[2]);
                outputStreamWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
            fos.close();
        }
    }
}
