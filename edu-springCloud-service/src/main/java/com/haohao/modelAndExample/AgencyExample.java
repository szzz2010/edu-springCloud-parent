package com.haohao.modelAndExample;

import java.util.ArrayList;
import java.util.List;

public class AgencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public AgencyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        clearPage();
    }

    public void setPage(boolean page) {
        this.page = page;
    }

    public boolean isPage() {
        return page;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int isOffset() {
        return offset;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int isCount() {
        return count;
    }

    public void startPage(int offset, int count) {
        page = true;
        this.offset = offset;
        this.count = count;
    }

    public void clearPage() {
        page = false;
        offset = 0;
        count = 0;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNull() {
            addCriterion("source_name is null");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNotNull() {
            addCriterion("source_name is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNameEqualTo(String value) {
            addCriterion("source_name =", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotEqualTo(String value) {
            addCriterion("source_name <>", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThan(String value) {
            addCriterion("source_name >", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("source_name >=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThan(String value) {
            addCriterion("source_name <", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThanOrEqualTo(String value) {
            addCriterion("source_name <=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLike(String value) {
            addCriterion("source_name like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotLike(String value) {
            addCriterion("source_name not like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameIn(List<String> values) {
            addCriterion("source_name in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotIn(List<String> values) {
            addCriterion("source_name not in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameBetween(String value1, String value2) {
            addCriterion("source_name between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotBetween(String value1, String value2) {
            addCriterion("source_name not between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andMd5KeyIsNull() {
            addCriterion("md5_key is null");
            return (Criteria) this;
        }

        public Criteria andMd5KeyIsNotNull() {
            addCriterion("md5_key is not null");
            return (Criteria) this;
        }

        public Criteria andMd5KeyEqualTo(String value) {
            addCriterion("md5_key =", value, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyNotEqualTo(String value) {
            addCriterion("md5_key <>", value, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyGreaterThan(String value) {
            addCriterion("md5_key >", value, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyGreaterThanOrEqualTo(String value) {
            addCriterion("md5_key >=", value, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyLessThan(String value) {
            addCriterion("md5_key <", value, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyLessThanOrEqualTo(String value) {
            addCriterion("md5_key <=", value, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyLike(String value) {
            addCriterion("md5_key like", value, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyNotLike(String value) {
            addCriterion("md5_key not like", value, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyIn(List<String> values) {
            addCriterion("md5_key in", values, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyNotIn(List<String> values) {
            addCriterion("md5_key not in", values, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyBetween(String value1, String value2) {
            addCriterion("md5_key between", value1, value2, "md5Key");
            return (Criteria) this;
        }

        public Criteria andMd5KeyNotBetween(String value1, String value2) {
            addCriterion("md5_key not between", value1, value2, "md5Key");
            return (Criteria) this;
        }

        public Criteria andAesKeyIsNull() {
            addCriterion("aes_key is null");
            return (Criteria) this;
        }

        public Criteria andAesKeyIsNotNull() {
            addCriterion("aes_key is not null");
            return (Criteria) this;
        }

        public Criteria andAesKeyEqualTo(String value) {
            addCriterion("aes_key =", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyNotEqualTo(String value) {
            addCriterion("aes_key <>", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyGreaterThan(String value) {
            addCriterion("aes_key >", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyGreaterThanOrEqualTo(String value) {
            addCriterion("aes_key >=", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyLessThan(String value) {
            addCriterion("aes_key <", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyLessThanOrEqualTo(String value) {
            addCriterion("aes_key <=", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyLike(String value) {
            addCriterion("aes_key like", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyNotLike(String value) {
            addCriterion("aes_key not like", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyIn(List<String> values) {
            addCriterion("aes_key in", values, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyNotIn(List<String> values) {
            addCriterion("aes_key not in", values, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyBetween(String value1, String value2) {
            addCriterion("aes_key between", value1, value2, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyNotBetween(String value1, String value2) {
            addCriterion("aes_key not between", value1, value2, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableIsNull() {
            addCriterion("agency_enable is null");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableIsNotNull() {
            addCriterion("agency_enable is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableEqualTo(Integer value) {
            addCriterion("agency_enable =", value, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableNotEqualTo(Integer value) {
            addCriterion("agency_enable <>", value, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableGreaterThan(Integer value) {
            addCriterion("agency_enable >", value, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("agency_enable >=", value, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableLessThan(Integer value) {
            addCriterion("agency_enable <", value, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableLessThanOrEqualTo(Integer value) {
            addCriterion("agency_enable <=", value, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableIn(List<Integer> values) {
            addCriterion("agency_enable in", values, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableNotIn(List<Integer> values) {
            addCriterion("agency_enable not in", values, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableBetween(Integer value1, Integer value2) {
            addCriterion("agency_enable between", value1, value2, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andAgencyEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("agency_enable not between", value1, value2, "agencyEnable");
            return (Criteria) this;
        }

        public Criteria andRiskUrlIsNull() {
            addCriterion("risk_url is null");
            return (Criteria) this;
        }

        public Criteria andRiskUrlIsNotNull() {
            addCriterion("risk_url is not null");
            return (Criteria) this;
        }

        public Criteria andRiskUrlEqualTo(String value) {
            addCriterion("risk_url =", value, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlNotEqualTo(String value) {
            addCriterion("risk_url <>", value, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlGreaterThan(String value) {
            addCriterion("risk_url >", value, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlGreaterThanOrEqualTo(String value) {
            addCriterion("risk_url >=", value, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlLessThan(String value) {
            addCriterion("risk_url <", value, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlLessThanOrEqualTo(String value) {
            addCriterion("risk_url <=", value, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlLike(String value) {
            addCriterion("risk_url like", value, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlNotLike(String value) {
            addCriterion("risk_url not like", value, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlIn(List<String> values) {
            addCriterion("risk_url in", values, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlNotIn(List<String> values) {
            addCriterion("risk_url not in", values, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlBetween(String value1, String value2) {
            addCriterion("risk_url between", value1, value2, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andRiskUrlNotBetween(String value1, String value2) {
            addCriterion("risk_url not between", value1, value2, "riskUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}