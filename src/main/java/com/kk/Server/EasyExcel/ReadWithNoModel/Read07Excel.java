package com.kk.Server.EasyExcel.ReadWithNoModel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by hutwanghui on 2019/1/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * 读07版小于1000行数据返回List<List>
 */
public class Read07Excel {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("F:\\tmp\\excel\\ExcelWithNoModel.xlsx");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        inputStream.close();
        System.out.println(data);
    }
}
