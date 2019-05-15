package com.haohao.modelAndExample;

public class Agency {
    /**
     *   机构编码
     */
    private String source;

    /**
     *   机构名称
     */
    private String sourceName;

    /**
     *   协议版本
     */
    private String version;

    /**
     *   md5签名串
     */
    private String md5Key;

    /**
     *   aeskey
     */
    private String aesKey;

    /**
     *   机构可用状态（0可用 1禁用）
     */
    private Integer agencyEnable;

    /**
     *   风控路径
     */
    private String riskUrl;

    /**
     *   添加时间
     */
    private Long createTime;

    /**
     *   修改时间
     */
    private Long updateTime;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key == null ? null : md5Key.trim();
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey == null ? null : aesKey.trim();
    }

    public Integer getAgencyEnable() {
        return agencyEnable;
    }

    public void setAgencyEnable(Integer agencyEnable) {
        this.agencyEnable = agencyEnable;
    }

    public String getRiskUrl() {
        return riskUrl;
    }

    public void setRiskUrl(String riskUrl) {
        this.riskUrl = riskUrl == null ? null : riskUrl.trim();
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