package com.kk.rest;

import lombok.Data;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * CopyTest
 *
 * @author juejin
 * @datetime 2023/3/8
 */
public class CopyTest {

    @Test
    public void copyTest() {

        Apple source = new Apple();
        source.setType("0");
        List<Color> list = Lists.newArrayList(new Color("1"), new Color("2"));
        source.setColorList(list);

        Copy copy = new Copy();
        BeanUtils.copyProperties(source,copy, Copy.class); // 浅拷贝

        System.out.println(copy);// Copy{type='0', colorList=[Color{color='1'}, Color{color='2'}]}

        // 修改 source 的list属性 copy属性也会改
        list.add(new Color("3"));
        System.out.println(copy);
    }

    @Test
    public void deepCopyTest() {

        Apple source = new Apple();
        source.setType("0");
        List<Color> list = Lists.newArrayList(new Color("1"), new Color("2"));
        source.setColorList(list);

        Copy copy = new Copy();

        //copy = BeansUtil.deepCopyProperties(source,Copy.class); // 浅拷贝
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
         mapper.map(source, copy);

        System.out.println(copy);// Copy{type='0', colorList=[Color{color='1'}, Color{color='2'}]}

        // 修改 source 的list属性 copy属性不会改
        list.add(new Color("3"));
        System.out.println(copy);

    }
}


@Data
class Apple{

    private String type;

    private List<Color> colorList;

    @Override
    public String toString() {
        return "Apple{" +
                "type='" + type + '\'' +
                ", colorList=" + colorList +
                '}';
    }
}

@Data
class Color {
    private String color;

    public Color(){}

    public Color(String color) {
        this.color = color;
    }
}

@Data
class Copy{

    private String type;

    private List<Color> colorList;

    @Override
    public String toString() {
        return "Copy{" +
                "type='" + type + '\'' +
                ", colorList=" + colorList +
                '}';
    }
}