package com.kk.Server.EasyExcel.ReadWithNoModel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.kk.Server.EasyExcel.ExcelListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by hutwanghui on 2019/1/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Read07ExcelBigData {
    public static void main(String[] args) throws FileNotFoundException {
        ExcelListener excelListener = new ExcelListener();
        InputStream inputStream = new FileInputStream("F:\\tmp\\excel\\湖南工业大学2017-2018学年校级奖学金及评优评先银行卡账号采集表(学院收集1).xlsx");
        EasyExcelFactory.readBySax(inputStream, new Sheet(1, 2), excelListener);

    }
}
