package com.example.demo.other;

import com.example.demo.model.Student;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * packageName：com.example.demo.other
 * class：OptionalTest
 * describe：optional类测试
 * author：mahao
 * time：21:25-2020/6/16
 * modify by:请输入修改人
 * modify time：请输入修改时间
 * version：V1.0
 */
public class OptionalTest {

    @Test
    public void ifPresentTest() {
        Student student = new Student(20, 90);

        //如果value(值)不为空则通过lambda处理值,否则不进行任何处理
        Optional<Student> optionalStudent = Optional.of(student);
        optionalStudent.ifPresent(item -> {
            int grade = item.getAge() > 20 ? item.getGrade() + 5 : item.getGrade() - 1;
            item.setGrade(grade);
        });
        System.out.println(optionalStudent);
    }

    @Test
    public void filterTest() {
        Student student = new Student(20, 90);

        //如果value(值)不为空则可实现过滤,否则返回原Optional
        Optional<Student> optionalStudent = Optional.of(student).filter(item -> item.getGrade() > 90);
        System.out.println(optionalStudent);
    }

    @Test
    public void mapTest() {
        Student student = new Student(20, 90);

        //如果value(值)不为空则可借助lambda表达式实现map处理,否则返回Optional.empty
        Optional<Student> optionalStudent = Optional.of(student).map(item -> new Student(item.getGrade(), item.getAge()));
        System.out.println(optionalStudent);
    }

    @Test
    public void flatMapTest() {
        Student student = new Student(20, 90);

        //flatMap的返回结果需要自行封装成Optional,如果value为空则返回Optional.empty
        //Optional<Student> optionalStudent = Optional.of(student).flatMap(item -> Optional.of(new Student(item.getGrade(), item.getAge())));
        //System.out.println(optionalStudent);

        Student student2 = new Student(22, 92);
        Student student3 = new Student(23, 93);
        List<Student> students = Lists.newArrayList();
        students.add(student);
        students.add(student2);
        students.add(student3);

        Optional<List<Student>> optionalStudent = Optional.of(students).flatMap(item -> Optional.of(this.flatMapTest2(item)));
        System.out.println("结果输出");
        System.out.println(optionalStudent);
    }

    public List<Student> flatMapTest2(List<Student> students) {
        System.out.println("flatMapTest2输出");
        System.out.println(students);
        return students;
    }

    @Test
    public void orElseThrowTest() {
        Student student = null;
        //如果容器值存在则返回容器值,否则将根据lambda表达式抛出异常对象
        try {
            //Student optionalStudent = Optional.ofNullable(student).orElseThrow(IllegalStateException::new);
            //Student optionalStudent = Optional.ofNullable(student).orElseThrow(Exception::new);
            Student optionalStudent = Optional.ofNullable(student).orElseThrow(() -> new Exception("错误"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
