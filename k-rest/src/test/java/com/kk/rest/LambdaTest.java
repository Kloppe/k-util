package com.kk.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LambaTest
 *
 * @author juejin
 * @datetime 2023/3/10
 */
public class LambdaTest {


    @Test
    public void lTest() {
        // stream  parallelStream stream 只执行两次循环，parallelStream 循环都执行了
       List<String> result = Item.builtItem().stream()
                .filter(e -> {
                    System.out.println(e.getName());
                    return e.getName().contains("a");
                }).map(e -> {
                    System.out.println(e.getName());
                    return e.getName();
                }).limit(2).collect(Collectors.toList());
        System.out.println(result);

        // map ? super Item,  参数可以是Item 活着 Item的父类
        List<Integer> list = Item.builtItem().stream().map(LambdaTest::objectToInt).collect(Collectors.toList());
        System.out.println(list);
    }

    public static int objectToInt(Object o) {
        if (o instanceof Item) {
            Item i = (Item) o;
            return i.getName().length();
        }
        return 0;
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Item {
    private String name;
    private int age;

    public static List<Item> builtItem(){
        List<Item> list = new ArrayList<>();
        list.add(new Item("a", 10));
        list.add(new Item("a1", 20));
        list.add(new Item("a2", 30));
        list.add(new Item("b", 40));
        list.add(new Item("b3", 40));
        list.add(new Item("f", 60));
        list.add(new Item("g", 70));
        list.add(new Item("h", 40));
        return list;
    }
}