package com.kk.commons.utils;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * PageResult
 *
 * @author juejin
 * @datetime 2023/3/8
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -3499923395473674738L;
    private long total;
    private List<T> rows;

    public static <F, T> PageResult<T> transform(PageResult<F> f, Function<F, T> function) {
        PageResult<T> pvr = new PageResult();
        pvr.setTotal(f.getTotal());
        if (CollectionUtils.isNotEmpty(f.getRows())) {
            pvr.setRows((List)f.getRows().stream().map(function).collect(Collectors.toList()));
        } else {
            pvr.setRows(Lists.newArrayList());
        }

        return pvr;
    }

    public static <F, T> PageResult<T> transform(PageResult<F> f, Class<T> targetClass) {
        PageResult<T> pvr = new PageResult();
        pvr.setTotal(f.getTotal());
        if (CollectionUtils.isNotEmpty(f.getRows())) {
            pvr.setRows(BeansUtil.transformList(f.getRows(), targetClass));
        } else {
            pvr.setRows(Lists.newArrayList());
        }

        return pvr;
    }

    public static <T> PageResult<T> pageResult(long total, List<T> rows) {
        return new PageResult(total, rows);
    }

    public static <T> PageResult<T> pageEmptyResult() {
        return pageResult(0L, Lists.newArrayList());
    }

    public long getTotal() {
        return this.total;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult(total=" + this.getTotal() + ", rows=" + this.getRows() + ")";
    }

    public PageResult() {
    }

    @ConstructorProperties({"total", "rows"})
    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}