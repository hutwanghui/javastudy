package com.kk.javabasic.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ClassUtil;
import com.kk.javabasic.util.resource.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by hutwanghui on 2018/10/25.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

public class HutoolClassUtil {
    public static void main(String[] args) {
        Class c = ClassUtil.getClass(Student.class);
        Method[] methods = ClassUtil.getPublicMethods(Student.class);
        Arrays.stream(methods).forEach(s -> {
            System.out.println(s.getName());
        });

        Set<Class<?>> s = ClassUtil.scanPackage("com.kk.javabasic");
        List<?> list = Convert.toList(s);
        list.stream().forEach(cl -> {
            System.out.println(cl);
        });
    }
}
