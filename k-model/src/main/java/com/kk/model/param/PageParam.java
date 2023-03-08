package com.kk.model.param;

import java.util.function.Function;

/**
 * PagerParam
 *
 * @author juejin
 * @datetime 2023/3/8
 */
public class PageParam <T> extends BaseParam {
    private static final long serialVersionUID = 9019529746748339608L;
    private Integer pageIndex = 1;
    private Integer pageSize = 50;
    private Integer startIndex = 1;
    private Integer offset;
    private boolean pageable;
    private T params;

    public PageParam() {
        this.offset = this.pageSize;
        this.pageable = true;
    }

    public PageParam(Integer pageIndex, Integer pageSize) {
        this.offset = this.pageSize;
        this.pageable = true;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Integer getStartIndex() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }

    public static <F, T> PageParam<T> transform(PageParam<F> source, Function<F, T> function) {
        PageParam<T> target = new PageParam();
        target.setOffset(source.getOffset());
        target.setPageIndex(source.getPageIndex());
        target.setPageSize(source.getPageSize());
        if (null != source.getParams()) {
            target.setParams(function.apply(source.getParams()));
        }

        target.setStartIndex(source.getStartIndex());
        target.setPageable(source.isPageable());
        return target;
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public boolean isPageable() {
        return this.pageable;
    }

    public T getParams() {
        return this.params;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setPageable(boolean pageable) {
        this.pageable = pageable;
    }

    public void setParams(T params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "PageParam(pageIndex=" + this.getPageIndex() + ", pageSize=" + this.getPageSize() + ", startIndex=" + this.getStartIndex() + ", offset=" + this.getOffset() + ", pageable=" + this.isPageable() + ", params=" + this.getParams() + ")";
    }
}