package com.example.demo.utils;

import java.util.Iterator;
import java.util.List;

/**
 * packageName：com.example.demo.utils
 * class：printUtil
 * describe：测试方法输出工具类
 * author：mahao
 * time：16:59-2019/8/16
 * modify by:请输入修改人
 * modify time：请输入修改时间
 * version：V1.0
 */
public class printUtil {

    /**
    * @Description List输出类方法
    * @Author mahao
    * @Date 17:02-2019/8/16
    * @param list
    * @return
    **/
    public static <T> void printList(List<T> list){
        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
        System.out.print("\n");
    }
}
