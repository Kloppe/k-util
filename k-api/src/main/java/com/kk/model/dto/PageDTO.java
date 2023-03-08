package com.kk.model.dto;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * PageDTO
 *
 * @author juejin
 * @datetime 2023/3/8
 */
public class PageDTO<T> extends BaseDTO {
    private static final long serialVersionUID = 870974515246133710L;
    private long total;
    private List<T> rows;

    public PageDTO() {
    }

    public PageDTO(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public static <F, T> PageDTO<T> transform(PageDTO<F> f, Function<F, T> function) {
        PageDTO<T> pvr = new PageDTO();
        pvr.setTotal(f.getTotal());
        if (CollectionUtils.isNotEmpty(f.getRows())) {
            pvr.setRows((List)f.getRows().stream().map(function).collect(Collectors.toList()));
        } else {
            pvr.setRows(new ArrayList());
        }

        return pvr;
    }

    public static <T> PageDTO<T> pageDTO(long total, List<T> rows) {
        return new PageDTO(total, rows);
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(this.rows);
    }

    public static <T> PageDTO<T> pageEmptyResult() {
        return pageDTO(0L, new ArrayList());
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

    public String toString() {
        return "PageDTO(total=" + this.getTotal() + ", rows=" + this.getRows() + ")";
    }

}