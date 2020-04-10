package com.example.demo.compare;

import com.example.demo.model.Student;
import com.example.demo.utils.printUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Collections;
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
    private List<Student> Students = Lists.newArrayList();

    //创建内部比较器对象--降序
    Comparator<Student> studentComparator_desc = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            // 入参o1:可以理解为排序队列中的后一个对象,即比较对象
            // 入参o2:理解为排序队列的前一个对象,即被比较对象
            if (o1.getAge() > o2.getAge()) {
                return -1;
            } else if (o1.getAge() < o2.getAge()) {
                //解读:如果后一个对象小于前一个对象,那么符合我们的目标排序规则,则返回1
                //因此我们可以想象一下,前大后小的序列是降序序列,以此我们可以理解升序序列
                return 1;
            } else {
                return 0;
            }
        }

    };


    //创建内部比较器对象--升序
    Comparator<Student> studentComparator_asc = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            // 入参o1:可以理解为排序队列中的后一个对象,即比较对象
            // 入参o2:理解为排序队列的前一个对象,即被比较对象
            if (o1.getAge() > o2.getAge()) {
                //解读:如果后一个对象大于前一个对象,那么符合我们的目标排序规则,则返回1
                //因此我们可以想象一下,前小后大的序列是升序序列,以此我们可以理解降序序列
                return 1;
            } else if (o1.getAge() < o2.getAge()) {
                return -1;
            } else {
                return 0;
            }
        }

    };


    //创建内部比较器对象--升序
    Comparator<Student> studentComparator_grade_asc = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            // 入参o1:可以理解为排序队列中的后一个对象,即比较对象
            // 入参o2:理解为排序队列的前一个对象,即被比较对象
            if (o1.getGrade() > o2.getGrade()) {
                //解读:如果后一个对象大于前一个对象,那么符合我们的目标排序规则,则返回1
                //因此我们可以想象一下,前小后大的序列是升序序列,以此我们可以理解降序序列
                return 1;
            } else if (o1.getGrade() < o2.getGrade()) {
                return -1;
            } else {
                return 0;
            }
        }

    };
    //创建内部比较器对象--降序
    Comparator<Integer> studentComparator_grade_desc = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            // 入参o1:可以理解为排序队列中的后一个对象,即比较对象
            // 入参o2:理解为排序队列的前一个对象,即被比较对象
            if (o1 < o2) {
                //解读:如果后一个对象大于前一个对象,那么符合我们的目标排序规则,则返回1
                //因此我们可以想象一下,前小后大的序列是升序序列,以此我们可以理解降序序列
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        }

    };

    /**
     * @param
     * @return
     * @Description 普通排序方法
     * @Author mahao
     * @Date 17:11-2019/8/16
     **/
    @Test
    public void publicSortMethod() {
        //初始化测试数组
        Students.add(Student.builder().age(10).build());
        Students.add(Student.builder().age(30).build());
        Students.add(Student.builder().age(50).build());
        Students.add(Student.builder().age(10).build());
        Students.add(Student.builder().age(20).build());
        Students.add(Student.builder().age(40).build());
        Students.add(Student.builder().age(60).build());

        //排序前
        printUtil.printList(Students);

        //排序--通过集合工具类Collections(既是student类已经默认实现comprartable比较器接口,并实现升序,这里也会按照降序比较器排序)
        //Collections.sort(Students,studentComparator);

        //排序--通过集合工具类Arrays
        //Arrays.sort();

        //排序--通过stream(既是student类已经默认实现comprartable比较器接口,并实现升序,这里也会按照降序比较器排序)
        Students = Students.stream().sorted(studentComparator_desc).collect(Collectors.toList());

        //排序--通过stream(当前比较器的反向顺序)
        //Students = Students.stream().sorted(studentComparator_desc.reversed()).collect(Collectors.toList());

        //排序和排重--通过stream(因为比较器中已经定义两对象相等的情况即return 0,因此可以直接直用distinct())
        //Students = Students.stream().sorted(studentComparator_desc).distinct().collect(Collectors.toList());

        //排序多比较器--通过stream(这里只是简单举例升序,降序,实际业务中应该是根据不同属性进行不同排序)
        //Students = Students.stream().sorted(studentComparator_desc).sorted(studentComparator_asc).collect(Collectors.toList());

        //排序后
        printUtil.printList(Students);
    }


    /**
     * @param
     * @return
     * @Description comparator的高级用法
     * @Author mahao
     * @Date 17:54-2019/8/16
     **/
    @Test
    public void otherSortMethod() {
        //初始化测试数组
        Students.add(Student.builder().age(10).grade(200).build());
        Students.add(Student.builder().age(30).build());
        Students.add(Student.builder().age(50).build());
        Students.add(Student.builder().age(10).build());
        Students.add(Student.builder().age(20).grade(500).build());
        Students.add(Student.builder().age(40).build());
        Students.add(Student.builder().age(60).build());

        //排序前
        printUtil.printList(Students);

        //1.thenComparing用法--针对相等情况下使用另一种比较器(年龄相等按照分数升序排序)
        //Students = Students.stream().sorted(studentComparator_desc.thenComparing(studentComparator_grade_asc)).collect(Collectors.toList());
        //直接利用grade排序
        //Students.sort(studentComparator_desc.thenComparing(e->e.getGrade()));
        //利用grade指定比较器排序,注意指定的比较器不在是student对象
        //Students.sort(studentComparator_desc.thenComparing(e -> e.getGrade(), studentComparator_grade_desc));

        //2.thenComparingInt实现对int对象的比较,入参为函数表达式
        //Students.sort(studentComparator_desc.thenComparingInt(e -> e.getGrade()));

        //3.reversed用法--反向比较器
        //Students.sort(studentComparator_desc.reversed());

        //4.naturalOrder用法-按照自然顺序排序(本例中按照age升序排序)
        //Students.sort(Comparator.naturalOrder());

        //5.reverseOrder用法-按照反自然顺序排序(本例中按照age降序排序)
        //Students.sort(Comparator.reverseOrder());

        //6.nullsFirst与nullsLast用法-解决如果排序的字段为null的情况下这条记录怎么排序的问题。nullsFirst是说将null记录排在最前面，而nullsLast是说将null记录排序在最后面。
        //Students.sort(Comparator.nullsLast(studentComparator_desc));

        //7.comparing用法-直接指定用于定义比较规则的比较器对象或者函数
        //Students.sort(Comparator.comparing(e -> e.getAge()));
        //Students.sort(Comparator.comparing(e -> e.getGrade(), studentComparator_grade_desc));
        Students.sort(Comparator.comparingInt(e -> e.getAge()));

        //排序后
        printUtil.printList(Students);
    }

    @Test
    public void sortMethod() {
        //初始化测试数组
        Students.add(Student.builder().age(10).build());
        Students.add(Student.builder().age(30).build());
        Students.add(Student.builder().age(50).build());
        Students.add(Student.builder().age(10).build());
        Students.add(Student.builder().age(20).build());
        Students.add(Student.builder().age(40).build());
        Students.add(Student.builder().age(60).build());

        //Comparable实践
        //1.借助student类中实现的Comparable接口完成排序
        //Collections.sort(Students);
        //Students = Students.stream().sorted();

        //Comparator实践
        //1.匿名内部类实现排序
        Collections.sort(Students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 入参o:可以理解为排序队列中的前一个对象,即被比较对象
                // this:理解为排序队列的后一个对象,即比较对象
                if (o1.getAge() > o2.getAge()) {
                    return -1;
                } else if (o1.getAge() < o2.getAge()) {
                    //解读:如果前一个对象小于后一个对象,那么符合我们的目标排序规则,则返回1
                    //因此我们可以想象一下,前小后大的序列是升序序列,以此我们可以理解降序序列
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        //2.借助stream的sort
        //根据年龄排序
        Students = Students.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        //根据年龄排序-反序
        Students = Students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        //先根据年龄排序-如果遇到相等则再根据分数排序
        Students = Students.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getGrade)).collect(Collectors.toList());

    }
}
