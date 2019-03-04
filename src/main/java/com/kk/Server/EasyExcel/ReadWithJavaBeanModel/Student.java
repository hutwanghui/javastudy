package com.kk.Server.EasyExcel.ReadWithJavaBeanModel;

import com.alibaba.excel.annotation.ExcelColumnNum;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by hutwanghui on 2019/1/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseRowModel {
    @ExcelColumnNum(1)
    private String userId;
    @ExcelColumnNum(2)
    private String academyName;
    @ExcelColumnNum(3)
    private String awardName;
    @ExcelColumnNum(4)
    private String className;
    @ExcelColumnNum(5)
    private String studentId;
    @ExcelColumnNum(6)
    private String studentName;
    @ExcelColumnNum(7)
    private Integer sum;
    @ExcelColumnNum(8)
    private String bankNumber;
    @ExcelColumnNum(9)
    private String phoneNumber;

}
