package com.kk.Server.EasyExcel.WriteWithNoModel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.kk.Server.EasyExcel.ReadWithJavaBeanModel.Student;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hutwanghui on 2019/1/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Write03Excel {
    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("F://tmp/excel/Write03Excel.xls");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个sheet");
        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0, 10000);
        columnWidth.put(1, 40000);
        columnWidth.put(2, 10000);
        columnWidth.put(3, 10000);
        sheet1.setColumnWidthMap(columnWidth);
        sheet1.setHead(createTestListStringHead());
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(createTestListObject(), sheet1);

        //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
        Sheet sheet2 = new Sheet(2, 3, Student.class, "第二个sheet", null);
        sheet2.setTableStyle(createTableStyle());
        writer.write(createTestListJavaMode(), sheet2);

        //写第三个sheet包含多个table情况
        Sheet sheet3 = new Sheet(3, 0);
        sheet3.setSheetName("第三个sheet");
        Table table1 = new Table(1);
        table1.setHead(createTestListStringHead());
        writer.write1(createTestListObject(), sheet3, table1);

        //写sheet2  模型上打有表头的注解
        Table table2 = new Table(2);
        table2.setTableStyle(createTableStyle());
        table2.setClazz(Student.class);
        writer.write(createTestListJavaMode(), sheet3, table2);

        //关闭资源
        writer.finish();
        out.close();
    }

    private static List<? extends BaseRowModel> createTestListJavaMode() {
        return Arrays.asList(new Student("1", "计算机学院", "三号学生", "计算机1502", "15408100209", "XX", 10000, "1234test", "1800023321231"));
    }

    private static TableStyle createTableStyle() {
        TableStyle tableStyle = new TableStyle();
        tableStyle.setTableContentBackGroundColor(IndexedColors.BLUE);
        return tableStyle;
    }

    private static List<List<Object>> createTestListObject() {
        return Arrays.asList(Arrays.asList("1", "计算机学院", "三号学生", "计算机1502", "15408100209", "XX", 10000, "1234test", "1800023321231"));
    }

    private static List<List<String>> createTestListStringHead() {
        return Arrays.asList(Arrays.asList("标题1"), Arrays.asList("标题2"));
    }
}
