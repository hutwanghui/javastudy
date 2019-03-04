package com.kk.javabasic.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by hutwanghui on 2018/10/24.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class HuToolConvert {
    public static void main(String[] args) {
        int a = 1;
        String aToStr = Convert.toStr(a);
        String[] b = {"1", "2", "3", "4"};
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
        long[] c = {1, 2, 3, 4, 5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        String time = "2017-05-06";
        Date value = Convert.toDate(time);
        System.out.println(value);
        Object[] arr = {"a", "你", "好", "", 1};
        List<?> list = Convert.convert(List.class, arr);
        //从4.1.11开始可以这么用
        List<?> list2 = Convert.toList(arr);
        System.out.println(list);
        System.out.println(list2);
        //十六进制转换
        String strToHex = Convert.toHex("我是String", CharsetUtil.CHARSET_UTF_8);
        System.out.println(strToHex);
        String hexToStr = Convert.hexToStr(strToHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(hexToStr);
        //Unicode转换
        String strToUnicode = Convert.strToUnicode("我是String");
        System.out.println(strToUnicode);
        String UnicodeToStr = Convert.unicodeToStr(strToUnicode);
        System.out.println(UnicodeToStr);
        //编码转换
        String s = "我不是乱码";
        String sToMix = Convert.convertCharset(s, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        System.out.println("转换成IOS的编码：" + sToMix);
        String MixTos = Convert.convertCharset(sToMix, CharsetUtil.ISO_8859_1, CharsetUtil.UTF_8);
        System.out.println("转换回来：" + MixTos);
    }
}
