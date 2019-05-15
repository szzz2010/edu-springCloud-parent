package com.haohao.util.paramAndDto;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: PageParam
 * @Description: 后台分页参数
 * @author: fengxiaowei
 * @date: 2018年3月12日 下午5:16:23
 */
public class PageParam {
    /**
     * 页码
     */
    private Integer page = 1;
    /**
     * 每页条数
     */
    private Integer limit = 10;

    public Integer getLimit() {
        return limit;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    private String order;

    public PageParam() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getRow() {
        return (page - 1) * limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder() {
        this.order = order;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
