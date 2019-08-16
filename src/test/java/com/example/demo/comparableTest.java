package com.example.demo;

import com.example.demo.model.student;
import com.example.demo.utils.printUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

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

    private List<student> students = Lists.newArrayList();

    /**
    * @Description 比较器排序测试方法
    * @Author mahao
    * @Date 17:02-2019/8/16
    * @param
    * @return
    **/
    @Test
    public void studentSortByAge(){
        students.add(student.builder().age(10).build());
        students.add(student.builder().age(30).build());
        students.add(student.builder().age(50).build());
        students.add(student.builder().age(20).build());
        students.add(student.builder().age(40).build());
        students.add(student.builder().age(60).build());

        //排序前
        printUtil.printList(students);

        //排序--通过集合工具类Collections
        //Collections.sort(students);

        //排序--通过集合工具类Arrays
        //Arrays.sort();

        //排序--通过stream
        students = students.stream().sorted().collect(Collectors.toList());

        //排序后
        printUtil.printList(students);

    }

}
