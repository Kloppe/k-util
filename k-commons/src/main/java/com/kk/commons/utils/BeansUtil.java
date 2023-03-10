package com.kk.commons.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 */
public class BeansUtil {

    public BeansUtil() {
    }

    /**
     * list对象转换
     *
     * @param fs
     * @param function
     * @return
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
     * @param list
     * @param clazz
     * @param <T>
     * @param <F>
     * @return
     */
    public static <T, F> List<F> copyList(List<T> list, Class<F> clazz) {
        return list.stream().map(t -> copyProperties(t, clazz)).collect(Collectors.toList());
    }


    public static <F, T> List<T> transformListFilterNull(Collection<F> fs, Function<F, T> function) {
        return filterNull(transformList(fs, function));
    }

    public static <T> List<T> filterNull(Collection<T> source) {
        return (List)source.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static <F, K, V> Map<K, V> transformMap(Collection<F> fs, Function<? super F, K> keyFunction, Function<? super F, V> valueFunction) {
        HashMap<K, V> newHashMap = Maps.newHashMap();
        fs.forEach((x) -> {
            newHashMap.put(keyFunction.apply(x), valueFunction.apply(x));
        });
        return newHashMap;
    }

    public static <F, T> Set<T> transformSet(Collection<F> fs, Function<F, T> function) {
        return (Set)(CollectionUtils.isEmpty(fs) ? Sets.newHashSet() : (Set)fs.stream().map(function).collect(Collectors.toSet()));
    }

    public static <F, T> List<T> transformList(Collection<F> fs, Class<T> c) {
        return (List)(CollectionUtils.isEmpty(fs) ? Lists.newArrayList() : (List)fs.stream().map((x) -> {
            return copyProperties(x, c);
        }).collect(Collectors.toList()));
    }

    public static <F, T> List<T> transformListByJSON(Collection<F> fromCollection, Class<T> toClass) {
        return transformList(fromCollection, (x) -> {
            return transformByJSON(x, toClass);
        });
    }

    public static <F, T> T transformByJSON(F from, Class<T> toClass) {
        return JSON.parseObject(JSON.toJSONString(from), toClass);
    }


    public static <T, E> E copyProperties(T source, Class<E> target, String[] ignoreProperties) {
        try {
            if (null == source) {
                return null;
            } else {
                E e = target.newInstance();
                BeanUtils.copyProperties(source, e, ignoreProperties);
                return e;
            }
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public static <T, E> E deepCopyProperties(T source, Class<E> target) {
        try {
            if (null == source) {
                return null;
            } else {
                ModelMapper mapper = new ModelMapper();
                mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
                return mapper.map(source, target);
            }
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T, E> List<E> deepCopyProperties(List<T> source, Class<E> target) {
        try {
            if (CollectionUtils.isEmpty(source)) {
                return Lists.newArrayList();
            } else {
                List<E> result = Lists.newArrayListWithCapacity(source.size());
                ModelMapper mapper = new ModelMapper();
                source.forEach((x) -> {
                    result.add(mapper.map(x, target));
                });
                return result;
            }
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public static <T> T map2Bean(Map<String, Object> map, Class<T> c) {
        try {
            T obj = c.newInstance();
            org.apache.commons.beanutils.BeanUtils.populate(obj, map);
            return obj;
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> Map<String, Object> bean2Map(T t) {
        try {
            return PropertyUtils.describe(t);
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public static <T> List<T> setToList(Set<T> set) {
        return new ArrayList(set);
    }


}
