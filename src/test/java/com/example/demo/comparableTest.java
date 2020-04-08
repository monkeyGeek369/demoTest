package com.example.demo;

import com.example.demo.model.student;
import com.example.demo.utils.printUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName：com.example.demo
 * class：comparableTest
 * describe：比较器接口测试类
 * author：mahao
 * time：16:30-2019/8/16
 * modify by:请输入修改人
 * modify time：请输入修改时间
 * version：V1.0
 */
public class comparableTest {


    /**
    * @Description 复杂对象排序-比较器排序测试方法
    * @Author mahao
    * @Date 17:02-2019/8/16
    * @param
    * @return
    **/
    @Test
    public void studentSortByAge(){
        List<student> students = Lists.newArrayList();

        students.add(student.builder().age(10).build());
        students.add(student.builder().age(30).build());
        students.add(student.builder().age(50).build());
        students.add(student.builder().age(20).build());
        students.add(student.builder().age(40).build());
        students.add(student.builder().age(60).build());

        //排序前
        printUtil.printList(students);

        //排序--通过集合工具类Collections(底层是利用二分法实现的排序)
        Collections.sort(students);

        //排序--通过stream
        //students = students.stream().sorted().collect(Collectors.toList());

        //排序后
        printUtil.printList(students);

    }

    /**
    * @Description 简单对象排序
    * @Author mahao
    * @Date 23:08-2020/4/8
    * @Param
    * @return
    **/
    @Test
    public void integerSort(){
        List<Integer> integers = Lists.newArrayList();
        integers.add(5);
        integers.add(6);
        integers.add(1);
        integers.add(3);
        integers.add(4);
        integers.add(9);

        //排序前
        printUtil.printList(integers);

        //排序--通过集合工具类Arrays
        Collections.sort(integers);

        //排序后
        printUtil.printList(integers);
    }
}
