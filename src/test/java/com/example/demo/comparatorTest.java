package com.example.demo;

import com.example.demo.model.student;
import com.example.demo.utils.printUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName：com.example.demo
 * class：comparatorTest
 * describe：内部比较器comparator测试类
 * author：mahao
 * time：17:04-2019/8/16
 * modify by:请输入修改人
 * modify time：请输入修改时间
 * version：V1.0
 */
public class comparatorTest {
    //创建测试数组
    private List<student> students = Lists.newArrayList();

    //创建内部比较器对象--降序
    Comparator<student> studentComparator_desc = new Comparator<student>() {
        @Override
        public int compare(student o1, student o2) {
            // 入参o1:可以理解为排序队列中的后一个对象,即比较对象
            // 入参o2:理解为排序队列的前一个对象,即被比较对象
            if(o1.getAge() > o2.getAge()){
                return -1;
            }else if(o1.getAge() < o2.getAge()){
                //解读:如果后一个对象小于前一个对象,那么符合我们的目标排序规则,则返回1
                //因此我们可以想象一下,前大后小的序列是降序序列,以此我们可以理解升序序列
                return 1;
            }else {
                return 0;
            }
        }

    };


    //创建内部比较器对象--升序
    Comparator<student> studentComparator_asc = new Comparator<student>() {
        @Override
        public int compare(student o1, student o2) {
            // 入参o1:可以理解为排序队列中的后一个对象,即比较对象
            // 入参o2:理解为排序队列的前一个对象,即被比较对象
            if(o1.getAge() > o2.getAge()){
                //解读:如果后一个对象大于前一个对象,那么符合我们的目标排序规则,则返回1
                //因此我们可以想象一下,前小后大的序列是升序序列,以此我们可以理解降序序列
                return 1;
            }else if(o1.getAge() < o2.getAge()){
                return -1;
            }else {
                return 0;
            }
        }

    };


    //创建内部比较器对象--升序
    Comparator<student> studentComparator_grade_asc = new Comparator<student>() {
        @Override
        public int compare(student o1, student o2) {
            // 入参o1:可以理解为排序队列中的后一个对象,即比较对象
            // 入参o2:理解为排序队列的前一个对象,即被比较对象
            if(o1.getGrade() > o2.getGrade()){
                //解读:如果后一个对象大于前一个对象,那么符合我们的目标排序规则,则返回1
                //因此我们可以想象一下,前小后大的序列是升序序列,以此我们可以理解降序序列
                return 1;
            }else if(o1.getGrade() < o2.getGrade()){
                return -1;
            }else {
                return 0;
            }
        }

    };

    /**
    * @Description 普通排序方法
    * @Author mahao
    * @Date 17:11-2019/8/16
    * @param
    * @return
    **/
    @Test
    public void publicSortMethod(){
        //初始化测试数组
        students.add(student.builder().age(10).build());
        students.add(student.builder().age(30).build());
        students.add(student.builder().age(50).build());
        students.add(student.builder().age(10).build());
        students.add(student.builder().age(20).build());
        students.add(student.builder().age(40).build());
        students.add(student.builder().age(60).build());

        //排序前
        printUtil.printList(students);

        //排序--通过集合工具类Collections(既是student类已经默认实现comprartable比较器接口,并实现升序,这里也会按照降序比较器排序)
        //Collections.sort(students,studentComparator);

        //排序--通过集合工具类Arrays
        //Arrays.sort();

        //排序--通过stream(既是student类已经默认实现comprartable比较器接口,并实现升序,这里也会按照降序比较器排序)
        students = students.stream().sorted(studentComparator_desc).collect(Collectors.toList());

        //排序--通过stream(当前比较器的反向顺序)
        //students = students.stream().sorted(studentComparator_desc.reversed()).collect(Collectors.toList());

        //排序后
        printUtil.printList(students);
    }


    /**
    * @Description 排序+排重方法
    * @Author mahao
    * @Date 17:54-2019/8/16
    * @param
    * @return
    **/
    @Test
    public void distinctSortMethod(){
        //初始化测试数组
        students.add(student.builder().age(10).build());
        students.add(student.builder().age(30).build());
        students.add(student.builder().age(50).build());
        students.add(student.builder().age(10).build());
        students.add(student.builder().age(20).build());
        students.add(student.builder().age(40).build());
        students.add(student.builder().age(60).build());

        //排序前
        printUtil.printList(students);

        //排序和排重--通过stream(因为比较器中已经定义两对象相等的情况即return 0,因此可以直接直用distinct())
        students = students.stream().sorted(studentComparator_desc).distinct().collect(Collectors.toList());

        //排序后
        printUtil.printList(students);
    }

    /**
     * @Description 多种比较器结合的排序方式
     * @Author mahao
     * @Date 17:54-2019/8/16
     * @param
     * @return
     **/
    @Test
    public void multipleSortMethod(){
        //初始化测试数组
        students.add(student.builder().age(10).grade(200).build());
        students.add(student.builder().age(30).build());
        students.add(student.builder().age(50).build());
        students.add(student.builder().age(10).build());
        students.add(student.builder().age(20).grade(500).build());
        students.add(student.builder().age(40).build());
        students.add(student.builder().age(60).build());

        //排序前
        printUtil.printList(students);

        //排序多比较器--通过stream(这里只是简单距离升序,降序,实际业务中应该是根据不同属性进行不同排序)
        //students = students.stream().sorted(studentComparator_desc).sorted(studentComparator_asc).collect(Collectors.toList());

        //排序多比较器--针对相等情况下使用另一种比较器(年龄相等按照分数升序排序)
        students = students.stream().sorted(studentComparator_desc.thenComparing(studentComparator_grade_asc)).collect(Collectors.toList());

        //排序后
        printUtil.printList(students);
    }
}
