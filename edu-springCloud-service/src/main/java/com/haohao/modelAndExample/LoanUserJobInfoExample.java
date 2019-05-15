package com.haohao.modelAndExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanUserJobInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public LoanUserJobInfoExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIsNull() {
            addCriterion("company_property is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIsNotNull() {
            addCriterion("company_property is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyEqualTo(String value) {
            addCriterion("company_property =", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotEqualTo(String value) {
            addCriterion("company_property <>", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyGreaterThan(String value) {
            addCriterion("company_property >", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("company_property >=", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLessThan(String value) {
            addCriterion("company_property <", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLessThanOrEqualTo(String value) {
            addCriterion("company_property <=", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLike(String value) {
            addCriterion("company_property like", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotLike(String value) {
            addCriterion("company_property not like", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIn(List<String> values) {
            addCriterion("company_property in", values, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotIn(List<String> values) {
            addCriterion("company_property not in", values, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyBetween(String value1, String value2) {
            addCriterion("company_property between", value1, value2, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotBetween(String value1, String value2) {
            addCriterion("company_property not between", value1, value2, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andFixedLineIsNull() {
            addCriterion("fixed_line is null");
            return (Criteria) this;
        }

        public Criteria andFixedLineIsNotNull() {
            addCriterion("fixed_line is not null");
            return (Criteria) this;
        }

        public Criteria andFixedLineEqualTo(String value) {
            addCriterion("fixed_line =", value, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineNotEqualTo(String value) {
            addCriterion("fixed_line <>", value, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineGreaterThan(String value) {
            addCriterion("fixed_line >", value, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_line >=", value, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineLessThan(String value) {
            addCriterion("fixed_line <", value, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineLessThanOrEqualTo(String value) {
            addCriterion("fixed_line <=", value, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineLike(String value) {
            addCriterion("fixed_line like", value, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineNotLike(String value) {
            addCriterion("fixed_line not like", value, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineIn(List<String> values) {
            addCriterion("fixed_line in", values, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineNotIn(List<String> values) {
            addCriterion("fixed_line not in", values, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineBetween(String value1, String value2) {
            addCriterion("fixed_line between", value1, value2, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andFixedLineNotBetween(String value1, String value2) {
            addCriterion("fixed_line not between", value1, value2, "fixedLine");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNull() {
            addCriterion("company_addr is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNotNull() {
            addCriterion("company_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrEqualTo(String value) {
            addCriterion("company_addr =", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotEqualTo(String value) {
            addCriterion("company_addr <>", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThan(String value) {
            addCriterion("company_addr >", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThanOrEqualTo(String value) {
            addCriterion("company_addr >=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThan(String value) {
            addCriterion("company_addr <", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThanOrEqualTo(String value) {
            addCriterion("company_addr <=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLike(String value) {
            addCriterion("company_addr like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotLike(String value) {
            addCriterion("company_addr not like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIn(List<String> values) {
            addCriterion("company_addr in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotIn(List<String> values) {
            addCriterion("company_addr not in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrBetween(String value1, String value2) {
            addCriterion("company_addr between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotBetween(String value1, String value2) {
            addCriterion("company_addr not between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("start_date like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("start_date not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andDutyJobIsNull() {
            addCriterion("duty_job is null");
            return (Criteria) this;
        }

        public Criteria andDutyJobIsNotNull() {
            addCriterion("duty_job is not null");
            return (Criteria) this;
        }

        public Criteria andDutyJobEqualTo(String value) {
            addCriterion("duty_job =", value, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobNotEqualTo(String value) {
            addCriterion("duty_job <>", value, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobGreaterThan(String value) {
            addCriterion("duty_job >", value, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobGreaterThanOrEqualTo(String value) {
            addCriterion("duty_job >=", value, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobLessThan(String value) {
            addCriterion("duty_job <", value, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobLessThanOrEqualTo(String value) {
            addCriterion("duty_job <=", value, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobLike(String value) {
            addCriterion("duty_job like", value, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobNotLike(String value) {
            addCriterion("duty_job not like", value, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobIn(List<String> values) {
            addCriterion("duty_job in", values, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobNotIn(List<String> values) {
            addCriterion("duty_job not in", values, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobBetween(String value1, String value2) {
            addCriterion("duty_job between", value1, value2, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andDutyJobNotBetween(String value1, String value2) {
            addCriterion("duty_job not between", value1, value2, "dutyJob");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeIsNull() {
            addCriterion("monthly_income is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeIsNotNull() {
            addCriterion("monthly_income is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeEqualTo(BigDecimal value) {
            addCriterion("monthly_income =", value, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeNotEqualTo(BigDecimal value) {
            addCriterion("monthly_income <>", value, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeGreaterThan(BigDecimal value) {
            addCriterion("monthly_income >", value, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_income >=", value, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeLessThan(BigDecimal value) {
            addCriterion("monthly_income <", value, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_income <=", value, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeIn(List<BigDecimal> values) {
            addCriterion("monthly_income in", values, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeNotIn(List<BigDecimal> values) {
            addCriterion("monthly_income not in", values, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_income between", value1, value2, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andMonthlyIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_income not between", value1, value2, "monthlyIncome");
            return (Criteria) this;
        }

        public Criteria andHireTypeIsNull() {
            addCriterion("hire_type is null");
            return (Criteria) this;
        }

        public Criteria andHireTypeIsNotNull() {
            addCriterion("hire_type is not null");
            return (Criteria) this;
        }

        public Criteria andHireTypeEqualTo(String value) {
            addCriterion("hire_type =", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeNotEqualTo(String value) {
            addCriterion("hire_type <>", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeGreaterThan(String value) {
            addCriterion("hire_type >", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hire_type >=", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeLessThan(String value) {
            addCriterion("hire_type <", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeLessThanOrEqualTo(String value) {
            addCriterion("hire_type <=", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeLike(String value) {
            addCriterion("hire_type like", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeNotLike(String value) {
            addCriterion("hire_type not like", value, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeIn(List<String> values) {
            addCriterion("hire_type in", values, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeNotIn(List<String> values) {
            addCriterion("hire_type not in", values, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeBetween(String value1, String value2) {
            addCriterion("hire_type between", value1, value2, "hireType");
            return (Criteria) this;
        }

        public Criteria andHireTypeNotBetween(String value1, String value2) {
            addCriterion("hire_type not between", value1, value2, "hireType");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoIsNull() {
            addCriterion("business_info is null");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoIsNotNull() {
            addCriterion("business_info is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoEqualTo(String value) {
            addCriterion("business_info =", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoNotEqualTo(String value) {
            addCriterion("business_info <>", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoGreaterThan(String value) {
            addCriterion("business_info >", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoGreaterThanOrEqualTo(String value) {
            addCriterion("business_info >=", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoLessThan(String value) {
            addCriterion("business_info <", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoLessThanOrEqualTo(String value) {
            addCriterion("business_info <=", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoLike(String value) {
            addCriterion("business_info like", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoNotLike(String value) {
            addCriterion("business_info not like", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoIn(List<String> values) {
            addCriterion("business_info in", values, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoNotIn(List<String> values) {
            addCriterion("business_info not in", values, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoBetween(String value1, String value2) {
            addCriterion("business_info between", value1, value2, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoNotBetween(String value1, String value2) {
            addCriterion("business_info not between", value1, value2, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleIsNull() {
            addCriterion("company_scale is null");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleIsNotNull() {
            addCriterion("company_scale is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleEqualTo(String value) {
            addCriterion("company_scale =", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleNotEqualTo(String value) {
            addCriterion("company_scale <>", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleGreaterThan(String value) {
            addCriterion("company_scale >", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleGreaterThanOrEqualTo(String value) {
            addCriterion("company_scale >=", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleLessThan(String value) {
            addCriterion("company_scale <", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleLessThanOrEqualTo(String value) {
            addCriterion("company_scale <=", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleLike(String value) {
            addCriterion("company_scale like", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleNotLike(String value) {
            addCriterion("company_scale not like", value, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleIn(List<String> values) {
            addCriterion("company_scale in", values, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleNotIn(List<String> values) {
            addCriterion("company_scale not in", values, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleBetween(String value1, String value2) {
            addCriterion("company_scale between", value1, value2, "companyScale");
            return (Criteria) this;
        }

        public Criteria andCompanyScaleNotBetween(String value1, String value2) {
            addCriterion("company_scale not between", value1, value2, "companyScale");
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