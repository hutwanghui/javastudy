package com.kk.Server.EasyExcel.ReadWithNoModel;

import cn.hutool.poi.excel.sax.Excel03SaxReader;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by hutwanghui on 2019/1/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Read03Excel {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("F:\\tmp\\excel\\ExcelWithNoModel.xls");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        inputStream.close();
        System.out.println(data);
    }
}
