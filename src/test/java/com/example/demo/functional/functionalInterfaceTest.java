package com.example.demo.functional;

import com.example.demo.inter.functionalString;
import com.example.demo.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * packageName：com.example.demo.functional
 * class：functionalInterfaceTest
 * describe：函数式接口测试
 * author：mahao
 * time：21:57-2020/4/15
 * modify by:请输入修改人
 * modify time：请输入修改时间
 * version：V1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class functionalInterfaceTest {

    @Test
    public void studentTest() {
        Student student = new Student(2, 6);

        functionalString<Student> functionalString = s -> "年龄:" + s.getAge() + ",年级:" + s.getGrade();

        String ret = functionalString.execute(student);
        System.out.println(ret);
    }

}
