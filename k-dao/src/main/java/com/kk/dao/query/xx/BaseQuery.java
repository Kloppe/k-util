package com.kk.dao.query.xx;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * BaseQuery
 *
 * @author juejin
 * @datetime 2023/2/22
 */

@Data
@Accessors(chain = true)
public abstract class BaseQuery {

    private long pageNo;

    private long pageSize;

    public long getOffset(){
        return (getPageNo() - 1) * getPageSize();
    }
}