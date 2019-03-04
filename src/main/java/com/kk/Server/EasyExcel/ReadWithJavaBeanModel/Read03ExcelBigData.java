package com.kk.Server.EasyExcel.ReadWithJavaBeanModel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.kk.Server.EasyExcel.ExcelListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by hutwanghui on 2019/1/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Read03ExcelBigData {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("F:\\tmp\\excel\\湖南工业大学2017-2018学年校级奖学金及评优评先银行卡账号采集表(学院收集1).xls");
            ExcelListener excelListener = new ExcelListener();
            EasyExcelFactory.readBySax(inputStream, new Sheet(2, 1,Student.class), excelListener);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
