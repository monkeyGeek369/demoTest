package com.example.demo.compare;

import com.example.demo.model.Student;
import com.example.demo.utils.printUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

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
     * @param
     * @return
     * @Description 复杂对象排序-比较器排序测试方法
     * @Author mahao
     * @Date 17:02-2019/8/16
     **/
    @Test
    public void studentSortByAge() {
        List<Student> Students = Lists.newArrayList();

        Students.add(Student.builder().age(10).build());
        Students.add(Student.builder().age(30).build());
        Students.add(Student.builder().age(50).build());
        Students.add(Student.builder().age(20).build());
        Students.add(Student.builder().age(40).build());
        Students.add(Student.builder().age(60).build());

        //排序前
        printUtil.printList(Students);

        //排序--通过集合工具类Collections(底层是利用二分法实现的排序)
        Collections.sort(Students);

        //排序--通过stream
        //Students = Students.stream().sorted().collect(Collectors.toList());

        //排序后
        printUtil.printList(Students);

    }

    /**
     * @return
     * @Description 简单对象排序
     * @Author mahao
     * @Date 23:08-2020/4/8
     * @Param
     **/
    @Test
    public void integerSort() {
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
