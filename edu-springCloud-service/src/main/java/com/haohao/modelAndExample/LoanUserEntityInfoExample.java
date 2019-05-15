package com.haohao.modelAndExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanUserEntityInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public LoanUserEntityInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameIsNull() {
            addCriterion("biz_entity_name is null");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameIsNotNull() {
            addCriterion("biz_entity_name is not null");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameEqualTo(String value) {
            addCriterion("biz_entity_name =", value, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameNotEqualTo(String value) {
            addCriterion("biz_entity_name <>", value, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameGreaterThan(String value) {
            addCriterion("biz_entity_name >", value, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameGreaterThanOrEqualTo(String value) {
            addCriterion("biz_entity_name >=", value, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameLessThan(String value) {
            addCriterion("biz_entity_name <", value, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameLessThanOrEqualTo(String value) {
            addCriterion("biz_entity_name <=", value, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameLike(String value) {
            addCriterion("biz_entity_name like", value, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameNotLike(String value) {
            addCriterion("biz_entity_name not like", value, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameIn(List<String> values) {
            addCriterion("biz_entity_name in", values, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameNotIn(List<String> values) {
            addCriterion("biz_entity_name not in", values, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameBetween(String value1, String value2) {
            addCriterion("biz_entity_name between", value1, value2, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntityNameNotBetween(String value1, String value2) {
            addCriterion("biz_entity_name not between", value1, value2, "bizEntityName");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeIsNull() {
            addCriterion("biz_entiry_type is null");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeIsNotNull() {
            addCriterion("biz_entiry_type is not null");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeEqualTo(String value) {
            addCriterion("biz_entiry_type =", value, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeNotEqualTo(String value) {
            addCriterion("biz_entiry_type <>", value, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeGreaterThan(String value) {
            addCriterion("biz_entiry_type >", value, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("biz_entiry_type >=", value, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeLessThan(String value) {
            addCriterion("biz_entiry_type <", value, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeLessThanOrEqualTo(String value) {
            addCriterion("biz_entiry_type <=", value, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeLike(String value) {
            addCriterion("biz_entiry_type like", value, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeNotLike(String value) {
            addCriterion("biz_entiry_type not like", value, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeIn(List<String> values) {
            addCriterion("biz_entiry_type in", values, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeNotIn(List<String> values) {
            addCriterion("biz_entiry_type not in", values, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeBetween(String value1, String value2) {
            addCriterion("biz_entiry_type between", value1, value2, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andBizEntiryTypeNotBetween(String value1, String value2) {
            addCriterion("biz_entiry_type not between", value1, value2, "bizEntiryType");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtIsNull() {
            addCriterion("register_amt is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtIsNotNull() {
            addCriterion("register_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtEqualTo(BigDecimal value) {
            addCriterion("register_amt =", value, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtNotEqualTo(BigDecimal value) {
            addCriterion("register_amt <>", value, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtGreaterThan(BigDecimal value) {
            addCriterion("register_amt >", value, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("register_amt >=", value, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtLessThan(BigDecimal value) {
            addCriterion("register_amt <", value, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("register_amt <=", value, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtIn(List<BigDecimal> values) {
            addCriterion("register_amt in", values, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtNotIn(List<BigDecimal> values) {
            addCriterion("register_amt not in", values, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("register_amt between", value1, value2, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andRegisterAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("register_amt not between", value1, value2, "registerAmt");
            return (Criteria) this;
        }

        public Criteria andFoundedDateIsNull() {
            addCriterion("founded_date is null");
            return (Criteria) this;
        }

        public Criteria andFoundedDateIsNotNull() {
            addCriterion("founded_date is not null");
            return (Criteria) this;
        }

        public Criteria andFoundedDateEqualTo(String value) {
            addCriterion("founded_date =", value, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateNotEqualTo(String value) {
            addCriterion("founded_date <>", value, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateGreaterThan(String value) {
            addCriterion("founded_date >", value, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateGreaterThanOrEqualTo(String value) {
            addCriterion("founded_date >=", value, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateLessThan(String value) {
            addCriterion("founded_date <", value, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateLessThanOrEqualTo(String value) {
            addCriterion("founded_date <=", value, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateLike(String value) {
            addCriterion("founded_date like", value, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateNotLike(String value) {
            addCriterion("founded_date not like", value, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateIn(List<String> values) {
            addCriterion("founded_date in", values, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateNotIn(List<String> values) {
            addCriterion("founded_date not in", values, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateBetween(String value1, String value2) {
            addCriterion("founded_date between", value1, value2, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andFoundedDateNotBetween(String value1, String value2) {
            addCriterion("founded_date not between", value1, value2, "foundedDate");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrIsNull() {
            addCriterion("register_addr is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrIsNotNull() {
            addCriterion("register_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrEqualTo(String value) {
            addCriterion("register_addr =", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrNotEqualTo(String value) {
            addCriterion("register_addr <>", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrGreaterThan(String value) {
            addCriterion("register_addr >", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrGreaterThanOrEqualTo(String value) {
            addCriterion("register_addr >=", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrLessThan(String value) {
            addCriterion("register_addr <", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrLessThanOrEqualTo(String value) {
            addCriterion("register_addr <=", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrLike(String value) {
            addCriterion("register_addr like", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrNotLike(String value) {
            addCriterion("register_addr not like", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrIn(List<String> values) {
            addCriterion("register_addr in", values, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrNotIn(List<String> values) {
            addCriterion("register_addr not in", values, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrBetween(String value1, String value2) {
            addCriterion("register_addr between", value1, value2, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrNotBetween(String value1, String value2) {
            addCriterion("register_addr not between", value1, value2, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioIsNull() {
            addCriterion("sgiare_ratio is null");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioIsNotNull() {
            addCriterion("sgiare_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioEqualTo(String value) {
            addCriterion("sgiare_ratio =", value, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioNotEqualTo(String value) {
            addCriterion("sgiare_ratio <>", value, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioGreaterThan(String value) {
            addCriterion("sgiare_ratio >", value, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioGreaterThanOrEqualTo(String value) {
            addCriterion("sgiare_ratio >=", value, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioLessThan(String value) {
            addCriterion("sgiare_ratio <", value, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioLessThanOrEqualTo(String value) {
            addCriterion("sgiare_ratio <=", value, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioLike(String value) {
            addCriterion("sgiare_ratio like", value, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioNotLike(String value) {
            addCriterion("sgiare_ratio not like", value, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioIn(List<String> values) {
            addCriterion("sgiare_ratio in", values, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioNotIn(List<String> values) {
            addCriterion("sgiare_ratio not in", values, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioBetween(String value1, String value2) {
            addCriterion("sgiare_ratio between", value1, value2, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andSgiareRatioNotBetween(String value1, String value2) {
            addCriterion("sgiare_ratio not between", value1, value2, "sgiareRatio");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumIsNull() {
            addCriterion("employee_num is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumIsNotNull() {
            addCriterion("employee_num is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumEqualTo(String value) {
            addCriterion("employee_num =", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumNotEqualTo(String value) {
            addCriterion("employee_num <>", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumGreaterThan(String value) {
            addCriterion("employee_num >", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumGreaterThanOrEqualTo(String value) {
            addCriterion("employee_num >=", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumLessThan(String value) {
            addCriterion("employee_num <", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumLessThanOrEqualTo(String value) {
            addCriterion("employee_num <=", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumLike(String value) {
            addCriterion("employee_num like", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumNotLike(String value) {
            addCriterion("employee_num not like", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumIn(List<String> values) {
            addCriterion("employee_num in", values, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumNotIn(List<String> values) {
            addCriterion("employee_num not in", values, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumBetween(String value1, String value2) {
            addCriterion("employee_num between", value1, value2, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumNotBetween(String value1, String value2) {
            addCriterion("employee_num not between", value1, value2, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryIsNull() {
            addCriterion("my_company_industry is null");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryIsNotNull() {
            addCriterion("my_company_industry is not null");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryEqualTo(String value) {
            addCriterion("my_company_industry =", value, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryNotEqualTo(String value) {
            addCriterion("my_company_industry <>", value, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryGreaterThan(String value) {
            addCriterion("my_company_industry >", value, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("my_company_industry >=", value, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryLessThan(String value) {
            addCriterion("my_company_industry <", value, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryLessThanOrEqualTo(String value) {
            addCriterion("my_company_industry <=", value, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryLike(String value) {
            addCriterion("my_company_industry like", value, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryNotLike(String value) {
            addCriterion("my_company_industry not like", value, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryIn(List<String> values) {
            addCriterion("my_company_industry in", values, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryNotIn(List<String> values) {
            addCriterion("my_company_industry not in", values, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryBetween(String value1, String value2) {
            addCriterion("my_company_industry between", value1, value2, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andMyCompanyIndustryNotBetween(String value1, String value2) {
            addCriterion("my_company_industry not between", value1, value2, "myCompanyIndustry");
            return (Criteria) this;
        }

        public Criteria andComAddrIsNull() {
            addCriterion("com_addr is null");
            return (Criteria) this;
        }

        public Criteria andComAddrIsNotNull() {
            addCriterion("com_addr is not null");
            return (Criteria) this;
        }

        public Criteria andComAddrEqualTo(String value) {
            addCriterion("com_addr =", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrNotEqualTo(String value) {
            addCriterion("com_addr <>", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrGreaterThan(String value) {
            addCriterion("com_addr >", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrGreaterThanOrEqualTo(String value) {
            addCriterion("com_addr >=", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrLessThan(String value) {
            addCriterion("com_addr <", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrLessThanOrEqualTo(String value) {
            addCriterion("com_addr <=", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrLike(String value) {
            addCriterion("com_addr like", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrNotLike(String value) {
            addCriterion("com_addr not like", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrIn(List<String> values) {
            addCriterion("com_addr in", values, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrNotIn(List<String> values) {
            addCriterion("com_addr not in", values, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrBetween(String value1, String value2) {
            addCriterion("com_addr between", value1, value2, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrNotBetween(String value1, String value2) {
            addCriterion("com_addr not between", value1, value2, "comAddr");
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