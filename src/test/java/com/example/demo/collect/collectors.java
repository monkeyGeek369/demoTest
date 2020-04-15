package com.example.demo.collect;

import org.junit.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * packageName：com.example.demo.collect
 * class：collectors
 * describe：Collectors工具类详解
 * author：mahao
 * time：21:22-2020/4/10
 * modify by:请输入修改人
 * modify time：请输入修改时间
 * version：V1.0
 */
public class collectors {

    @Test
    public void toCollection() {
        HashSet<Integer> hashSet = Stream.of(1, 2, 4, 5).collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);
    }
}
