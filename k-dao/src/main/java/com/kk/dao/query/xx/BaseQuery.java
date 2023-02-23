package com.kk.dao.mapper.xx;

/**
 * BaseQuery
 *
 * @author juejin
 * @datetime 2023/2/22
 */

public abstract class BaseQuery {

    private long pageNo;

    private long pageSize;

    private long offset;


    public long getOffset(){
        return ( - 1) * pageSize;
    }
}