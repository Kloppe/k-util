package com.ggj.category.property.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;

/**
 * @author wubh created at:2017年6月28日 上午10:01:42
 */
public class BeansUtil {

    /**
     * list对象转换
     *
     * @param fs
     * @param function
     * @return
     * @author wbh created at:2017年6月28日 上午10:01:48
     */
    public static <F, T> List<T> transformList(Collection<F> fs, Function<F, T> function) {
        if (CollectionUtils.isEmpty(fs)) {
            return Lists.newArrayList();
        }
        return fs.stream().map(function).collect(Collectors.toList());
    }

    /**
     * 参数拷贝
     *
     * @param source
     * @param target
     * @return
     * @author wbh created at:2017年6月28日 上午10:05:01
     */
    public static <T, E> E copyProperties(T source, Class<E> target) {
        try {
            if (null == source) {
                return null;
            }
            E e = target.newInstance();
            BeanUtils.copyProperties(source, e, (String[]) null);
            return e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 确保Collection成员属性值正确拷贝
     *
     * @param source
     * @param target
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T, E> E deepCopyProperties(T source, Class<E> target) {
        try {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return mapper.map(source, target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 确保Collection成员属性值正确拷贝
     *
     * @param source
     * @param target
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T, E> List<E> deepCopyProperties(List<T> source, Class<E> target) {
        try {
            if (CollectionUtils.isEmpty(source)) {
                return Lists.newArrayList();
            }
            List<E> result = Lists.newArrayListWithCapacity(source.size());
            ModelMapper mapper = new ModelMapper();
            source.forEach(x -> result.add(mapper.map(x, target)));
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param list
     * @param clazz
     * @param <T>
     * @param <F>
     * @return
     */
    public static <T, F> List<F> copyList(List<T> list, Class<F> clazz) {
        return list.stream().map(t -> copyProperties(t, clazz)).collect(Collectors.toList());
    }

}
