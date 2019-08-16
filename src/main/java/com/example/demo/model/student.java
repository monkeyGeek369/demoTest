package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName：com.example.demo.model
 * class：student
 * describe：用户测试比较器的学生类对象
 * author：mahao
 * time：16:36-2019/8/16
 * modify by:请输入修改人
 * modify time：请输入修改时间
 * version：V1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class student implements Comparable<student>{

    int age;

    int grade;

    //重写默认比较器---升序
    @Override
    public int compareTo(student o){
        // 入参o:可以理解为排序队列中的前一个对象,即被比较对象
        // this:理解为排序队列的后一个对象,即比较对象
        if(o.getAge() > this.getAge()){
            return -1;
        }else if(o.getAge() < this.getAge()){
            //解读:如果前一个对象小于后一个对象,那么符合我们的目标排序规则,则返回1
            //因此我们可以想象一下,前小后大的序列是升序序列,以此我们可以理解降序序列
            return 1;
        }else {
            return 0;
        }
    }
}
