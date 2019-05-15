package com.haohao.util.paramAndDto;

import java.util.List;

/**
 * <p>
 * Description：分页类
 * </p>
 *
 * @author zhangqiang
 * @version v1.0 Copyright (c) 2017 haohao
 * @date 2017年2月28日 上午9:56:30
 */
public class Pager<T> {
    private int page = 1;// 默认起始页
    private int pageSize = 10;// 默认每页条数
    private int totalCount;// 总条数
    private List<T> records;// 记录

    public Pager() {
    }

    public Pager(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Pager build(List<T> records, int totalCount) {
        setRecords(records);
        setTotalCount(totalCount);
        return this;
    }

    public static <T> Pager<T> build(int page, int pageSize, List<T> records, int totalCount) {
        return new Pager<T>(page, pageSize).build(records, totalCount);
    }

    public int getRowStartIndex() {
        return (this.page - 1) * this.pageSize;
    }

    public void setPage(int page) {
        this.page = page > 0 ? page : 1;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize > 0 ? pageSize : 10;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return (totalCount % pageSize) > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
