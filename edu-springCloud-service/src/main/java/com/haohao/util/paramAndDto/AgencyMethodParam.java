package com.haohao.util.paramAndDto;

public class AgencyMethodParam extends PageParam{

	 /**
     *   主键
     */
    private Integer id;

    /**
     *   机构编码
     */
    private String source;

    /**
     *   方法名
     */
    private String method;

    /**
     *   方法注释
     */
    private String methodComment;

    /**
     *   方法路径
     */
    private String url;

    /**
     *   方法可用状态（0可用 1禁用）
     */
    private Integer methodEnable;

    /**
     *   添加时间
     */
    private Long createTime;

    /**
     *   修改时间
     */
    private Long updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getMethodComment() {
        return methodComment;
    }

    public void setMethodComment(String methodComment) {
        this.methodComment = methodComment == null ? null : methodComment.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getMethodEnable() {
        return methodEnable;
    }

    public void setMethodEnable(Integer methodEnable) {
        this.methodEnable = methodEnable;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
