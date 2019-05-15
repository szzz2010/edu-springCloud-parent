package com.haohao.modelAndExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AcCompanyOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public AcCompanyOrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andLoanNumberIsNull() {
            addCriterion("loan_number is null");
            return (Criteria) this;
        }

        public Criteria andLoanNumberIsNotNull() {
            addCriterion("loan_number is not null");
            return (Criteria) this;
        }

        public Criteria andLoanNumberEqualTo(String value) {
            addCriterion("loan_number =", value, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberNotEqualTo(String value) {
            addCriterion("loan_number <>", value, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberGreaterThan(String value) {
            addCriterion("loan_number >", value, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberGreaterThanOrEqualTo(String value) {
            addCriterion("loan_number >=", value, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberLessThan(String value) {
            addCriterion("loan_number <", value, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberLessThanOrEqualTo(String value) {
            addCriterion("loan_number <=", value, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberLike(String value) {
            addCriterion("loan_number like", value, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberNotLike(String value) {
            addCriterion("loan_number not like", value, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberIn(List<String> values) {
            addCriterion("loan_number in", values, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberNotIn(List<String> values) {
            addCriterion("loan_number not in", values, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberBetween(String value1, String value2) {
            addCriterion("loan_number between", value1, value2, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanNumberNotBetween(String value1, String value2) {
            addCriterion("loan_number not between", value1, value2, "loanNumber");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameIsNull() {
            addCriterion("loan_company_name is null");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameIsNotNull() {
            addCriterion("loan_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameEqualTo(String value) {
            addCriterion("loan_company_name =", value, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameNotEqualTo(String value) {
            addCriterion("loan_company_name <>", value, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameGreaterThan(String value) {
            addCriterion("loan_company_name >", value, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("loan_company_name >=", value, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameLessThan(String value) {
            addCriterion("loan_company_name <", value, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("loan_company_name <=", value, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameLike(String value) {
            addCriterion("loan_company_name like", value, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameNotLike(String value) {
            addCriterion("loan_company_name not like", value, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameIn(List<String> values) {
            addCriterion("loan_company_name in", values, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameNotIn(List<String> values) {
            addCriterion("loan_company_name not in", values, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameBetween(String value1, String value2) {
            addCriterion("loan_company_name between", value1, value2, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyNameNotBetween(String value1, String value2) {
            addCriterion("loan_company_name not between", value1, value2, "loanCompanyName");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardIsNull() {
            addCriterion("loan_company_id_card is null");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardIsNotNull() {
            addCriterion("loan_company_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardEqualTo(String value) {
            addCriterion("loan_company_id_card =", value, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardNotEqualTo(String value) {
            addCriterion("loan_company_id_card <>", value, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardGreaterThan(String value) {
            addCriterion("loan_company_id_card >", value, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("loan_company_id_card >=", value, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardLessThan(String value) {
            addCriterion("loan_company_id_card <", value, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardLessThanOrEqualTo(String value) {
            addCriterion("loan_company_id_card <=", value, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardLike(String value) {
            addCriterion("loan_company_id_card like", value, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardNotLike(String value) {
            addCriterion("loan_company_id_card not like", value, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardIn(List<String> values) {
            addCriterion("loan_company_id_card in", values, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardNotIn(List<String> values) {
            addCriterion("loan_company_id_card not in", values, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardBetween(String value1, String value2) {
            addCriterion("loan_company_id_card between", value1, value2, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyIdCardNotBetween(String value1, String value2) {
            addCriterion("loan_company_id_card not between", value1, value2, "loanCompanyIdCard");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileIsNull() {
            addCriterion("loan_company_mobile is null");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileIsNotNull() {
            addCriterion("loan_company_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileEqualTo(String value) {
            addCriterion("loan_company_mobile =", value, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileNotEqualTo(String value) {
            addCriterion("loan_company_mobile <>", value, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileGreaterThan(String value) {
            addCriterion("loan_company_mobile >", value, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileGreaterThanOrEqualTo(String value) {
            addCriterion("loan_company_mobile >=", value, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileLessThan(String value) {
            addCriterion("loan_company_mobile <", value, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileLessThanOrEqualTo(String value) {
            addCriterion("loan_company_mobile <=", value, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileLike(String value) {
            addCriterion("loan_company_mobile like", value, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileNotLike(String value) {
            addCriterion("loan_company_mobile not like", value, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileIn(List<String> values) {
            addCriterion("loan_company_mobile in", values, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileNotIn(List<String> values) {
            addCriterion("loan_company_mobile not in", values, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileBetween(String value1, String value2) {
            addCriterion("loan_company_mobile between", value1, value2, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanCompanyMobileNotBetween(String value1, String value2) {
            addCriterion("loan_company_mobile not between", value1, value2, "loanCompanyMobile");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdIsNull() {
            addCriterion("loan_agency_id is null");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdIsNotNull() {
            addCriterion("loan_agency_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdEqualTo(String value) {
            addCriterion("loan_agency_id =", value, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdNotEqualTo(String value) {
            addCriterion("loan_agency_id <>", value, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdGreaterThan(String value) {
            addCriterion("loan_agency_id >", value, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdGreaterThanOrEqualTo(String value) {
            addCriterion("loan_agency_id >=", value, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdLessThan(String value) {
            addCriterion("loan_agency_id <", value, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdLessThanOrEqualTo(String value) {
            addCriterion("loan_agency_id <=", value, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdLike(String value) {
            addCriterion("loan_agency_id like", value, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdNotLike(String value) {
            addCriterion("loan_agency_id not like", value, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdIn(List<String> values) {
            addCriterion("loan_agency_id in", values, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdNotIn(List<String> values) {
            addCriterion("loan_agency_id not in", values, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdBetween(String value1, String value2) {
            addCriterion("loan_agency_id between", value1, value2, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyIdNotBetween(String value1, String value2) {
            addCriterion("loan_agency_id not between", value1, value2, "loanAgencyId");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeIsNull() {
            addCriterion("loan_agency_code is null");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeIsNotNull() {
            addCriterion("loan_agency_code is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeEqualTo(String value) {
            addCriterion("loan_agency_code =", value, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeNotEqualTo(String value) {
            addCriterion("loan_agency_code <>", value, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeGreaterThan(String value) {
            addCriterion("loan_agency_code >", value, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_agency_code >=", value, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeLessThan(String value) {
            addCriterion("loan_agency_code <", value, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeLessThanOrEqualTo(String value) {
            addCriterion("loan_agency_code <=", value, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeLike(String value) {
            addCriterion("loan_agency_code like", value, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeNotLike(String value) {
            addCriterion("loan_agency_code not like", value, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeIn(List<String> values) {
            addCriterion("loan_agency_code in", values, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeNotIn(List<String> values) {
            addCriterion("loan_agency_code not in", values, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeBetween(String value1, String value2) {
            addCriterion("loan_agency_code between", value1, value2, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyCodeNotBetween(String value1, String value2) {
            addCriterion("loan_agency_code not between", value1, value2, "loanAgencyCode");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameIsNull() {
            addCriterion("loan_agency_name is null");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameIsNotNull() {
            addCriterion("loan_agency_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameEqualTo(String value) {
            addCriterion("loan_agency_name =", value, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameNotEqualTo(String value) {
            addCriterion("loan_agency_name <>", value, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameGreaterThan(String value) {
            addCriterion("loan_agency_name >", value, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("loan_agency_name >=", value, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameLessThan(String value) {
            addCriterion("loan_agency_name <", value, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameLessThanOrEqualTo(String value) {
            addCriterion("loan_agency_name <=", value, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameLike(String value) {
            addCriterion("loan_agency_name like", value, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameNotLike(String value) {
            addCriterion("loan_agency_name not like", value, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameIn(List<String> values) {
            addCriterion("loan_agency_name in", values, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameNotIn(List<String> values) {
            addCriterion("loan_agency_name not in", values, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameBetween(String value1, String value2) {
            addCriterion("loan_agency_name between", value1, value2, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanAgencyNameNotBetween(String value1, String value2) {
            addCriterion("loan_agency_name not between", value1, value2, "loanAgencyName");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtIsNull() {
            addCriterion("loan_contract_amt is null");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtIsNotNull() {
            addCriterion("loan_contract_amt is not null");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtEqualTo(BigDecimal value) {
            addCriterion("loan_contract_amt =", value, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtNotEqualTo(BigDecimal value) {
            addCriterion("loan_contract_amt <>", value, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtGreaterThan(BigDecimal value) {
            addCriterion("loan_contract_amt >", value, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_contract_amt >=", value, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtLessThan(BigDecimal value) {
            addCriterion("loan_contract_amt <", value, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_contract_amt <=", value, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtIn(List<BigDecimal> values) {
            addCriterion("loan_contract_amt in", values, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtNotIn(List<BigDecimal> values) {
            addCriterion("loan_contract_amt not in", values, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_contract_amt between", value1, value2, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanContractAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_contract_amt not between", value1, value2, "loanContractAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNull() {
            addCriterion("loan_amt is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNotNull() {
            addCriterion("loan_amt is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtEqualTo(BigDecimal value) {
            addCriterion("loan_amt =", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotEqualTo(BigDecimal value) {
            addCriterion("loan_amt <>", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThan(BigDecimal value) {
            addCriterion("loan_amt >", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amt >=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThan(BigDecimal value) {
            addCriterion("loan_amt <", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amt <=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIn(List<BigDecimal> values) {
            addCriterion("loan_amt in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotIn(List<BigDecimal> values) {
            addCriterion("loan_amt not in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amt between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amt not between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateIsNull() {
            addCriterion("loan_year_interest_rate is null");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateIsNotNull() {
            addCriterion("loan_year_interest_rate is not null");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateEqualTo(BigDecimal value) {
            addCriterion("loan_year_interest_rate =", value, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateNotEqualTo(BigDecimal value) {
            addCriterion("loan_year_interest_rate <>", value, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateGreaterThan(BigDecimal value) {
            addCriterion("loan_year_interest_rate >", value, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_year_interest_rate >=", value, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateLessThan(BigDecimal value) {
            addCriterion("loan_year_interest_rate <", value, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_year_interest_rate <=", value, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateIn(List<BigDecimal> values) {
            addCriterion("loan_year_interest_rate in", values, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateNotIn(List<BigDecimal> values) {
            addCriterion("loan_year_interest_rate not in", values, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_year_interest_rate between", value1, value2, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanYearInterestRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_year_interest_rate not between", value1, value2, "loanYearInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeIsNull() {
            addCriterion("loan_apply_time is null");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeIsNotNull() {
            addCriterion("loan_apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeEqualTo(Date value) {
            addCriterion("loan_apply_time =", value, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeNotEqualTo(Date value) {
            addCriterion("loan_apply_time <>", value, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeGreaterThan(Date value) {
            addCriterion("loan_apply_time >", value, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loan_apply_time >=", value, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeLessThan(Date value) {
            addCriterion("loan_apply_time <", value, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("loan_apply_time <=", value, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeIn(List<Date> values) {
            addCriterion("loan_apply_time in", values, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeNotIn(List<Date> values) {
            addCriterion("loan_apply_time not in", values, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeBetween(Date value1, Date value2) {
            addCriterion("loan_apply_time between", value1, value2, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("loan_apply_time not between", value1, value2, "loanApplyTime");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtIsNull() {
            addCriterion("loan_consult_amt is null");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtIsNotNull() {
            addCriterion("loan_consult_amt is not null");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtEqualTo(BigDecimal value) {
            addCriterion("loan_consult_amt =", value, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtNotEqualTo(BigDecimal value) {
            addCriterion("loan_consult_amt <>", value, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtGreaterThan(BigDecimal value) {
            addCriterion("loan_consult_amt >", value, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_consult_amt >=", value, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtLessThan(BigDecimal value) {
            addCriterion("loan_consult_amt <", value, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_consult_amt <=", value, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtIn(List<BigDecimal> values) {
            addCriterion("loan_consult_amt in", values, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtNotIn(List<BigDecimal> values) {
            addCriterion("loan_consult_amt not in", values, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_consult_amt between", value1, value2, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanConsultAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_consult_amt not between", value1, value2, "loanConsultAmt");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeIsNull() {
            addCriterion("loan_product_type is null");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeIsNotNull() {
            addCriterion("loan_product_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeEqualTo(Integer value) {
            addCriterion("loan_product_type =", value, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeNotEqualTo(Integer value) {
            addCriterion("loan_product_type <>", value, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeGreaterThan(Integer value) {
            addCriterion("loan_product_type >", value, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_product_type >=", value, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeLessThan(Integer value) {
            addCriterion("loan_product_type <", value, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeLessThanOrEqualTo(Integer value) {
            addCriterion("loan_product_type <=", value, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeIn(List<Integer> values) {
            addCriterion("loan_product_type in", values, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeNotIn(List<Integer> values) {
            addCriterion("loan_product_type not in", values, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeBetween(Integer value1, Integer value2) {
            addCriterion("loan_product_type between", value1, value2, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanProductTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_product_type not between", value1, value2, "loanProductType");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaIsNull() {
            addCriterion("loan_give_quota is null");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaIsNotNull() {
            addCriterion("loan_give_quota is not null");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaEqualTo(BigDecimal value) {
            addCriterion("loan_give_quota =", value, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaNotEqualTo(BigDecimal value) {
            addCriterion("loan_give_quota <>", value, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaGreaterThan(BigDecimal value) {
            addCriterion("loan_give_quota >", value, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_give_quota >=", value, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaLessThan(BigDecimal value) {
            addCriterion("loan_give_quota <", value, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_give_quota <=", value, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaIn(List<BigDecimal> values) {
            addCriterion("loan_give_quota in", values, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaNotIn(List<BigDecimal> values) {
            addCriterion("loan_give_quota not in", values, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_give_quota between", value1, value2, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanGiveQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_give_quota not between", value1, value2, "loanGiveQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaIsNull() {
            addCriterion("loan_surplus_quota is null");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaIsNotNull() {
            addCriterion("loan_surplus_quota is not null");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaEqualTo(BigDecimal value) {
            addCriterion("loan_surplus_quota =", value, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaNotEqualTo(BigDecimal value) {
            addCriterion("loan_surplus_quota <>", value, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaGreaterThan(BigDecimal value) {
            addCriterion("loan_surplus_quota >", value, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_surplus_quota >=", value, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaLessThan(BigDecimal value) {
            addCriterion("loan_surplus_quota <", value, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_surplus_quota <=", value, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaIn(List<BigDecimal> values) {
            addCriterion("loan_surplus_quota in", values, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaNotIn(List<BigDecimal> values) {
            addCriterion("loan_surplus_quota not in", values, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_surplus_quota between", value1, value2, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanSurplusQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_surplus_quota not between", value1, value2, "loanSurplusQuota");
            return (Criteria) this;
        }

        public Criteria andLoanTitleIsNull() {
            addCriterion("loan_title is null");
            return (Criteria) this;
        }

        public Criteria andLoanTitleIsNotNull() {
            addCriterion("loan_title is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTitleEqualTo(String value) {
            addCriterion("loan_title =", value, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleNotEqualTo(String value) {
            addCriterion("loan_title <>", value, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleGreaterThan(String value) {
            addCriterion("loan_title >", value, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleGreaterThanOrEqualTo(String value) {
            addCriterion("loan_title >=", value, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleLessThan(String value) {
            addCriterion("loan_title <", value, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleLessThanOrEqualTo(String value) {
            addCriterion("loan_title <=", value, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleLike(String value) {
            addCriterion("loan_title like", value, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleNotLike(String value) {
            addCriterion("loan_title not like", value, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleIn(List<String> values) {
            addCriterion("loan_title in", values, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleNotIn(List<String> values) {
            addCriterion("loan_title not in", values, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleBetween(String value1, String value2) {
            addCriterion("loan_title between", value1, value2, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanTitleNotBetween(String value1, String value2) {
            addCriterion("loan_title not between", value1, value2, "loanTitle");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeIsNull() {
            addCriterion("loan_purpose is null");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeIsNotNull() {
            addCriterion("loan_purpose is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeEqualTo(Integer value) {
            addCriterion("loan_purpose =", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeNotEqualTo(Integer value) {
            addCriterion("loan_purpose <>", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeGreaterThan(Integer value) {
            addCriterion("loan_purpose >", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_purpose >=", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeLessThan(Integer value) {
            addCriterion("loan_purpose <", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeLessThanOrEqualTo(Integer value) {
            addCriterion("loan_purpose <=", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeIn(List<Integer> values) {
            addCriterion("loan_purpose in", values, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeNotIn(List<Integer> values) {
            addCriterion("loan_purpose not in", values, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeBetween(Integer value1, Integer value2) {
            addCriterion("loan_purpose between", value1, value2, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_purpose not between", value1, value2, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanTermsIsNull() {
            addCriterion("loan_terms is null");
            return (Criteria) this;
        }

        public Criteria andLoanTermsIsNotNull() {
            addCriterion("loan_terms is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTermsEqualTo(Integer value) {
            addCriterion("loan_terms =", value, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsNotEqualTo(Integer value) {
            addCriterion("loan_terms <>", value, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsGreaterThan(Integer value) {
            addCriterion("loan_terms >", value, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_terms >=", value, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsLessThan(Integer value) {
            addCriterion("loan_terms <", value, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsLessThanOrEqualTo(Integer value) {
            addCriterion("loan_terms <=", value, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsIn(List<Integer> values) {
            addCriterion("loan_terms in", values, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsNotIn(List<Integer> values) {
            addCriterion("loan_terms not in", values, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsBetween(Integer value1, Integer value2) {
            addCriterion("loan_terms between", value1, value2, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanTermsNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_terms not between", value1, value2, "loanTerms");
            return (Criteria) this;
        }

        public Criteria andLoanNatureIsNull() {
            addCriterion("loan_nature is null");
            return (Criteria) this;
        }

        public Criteria andLoanNatureIsNotNull() {
            addCriterion("loan_nature is not null");
            return (Criteria) this;
        }

        public Criteria andLoanNatureEqualTo(Integer value) {
            addCriterion("loan_nature =", value, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureNotEqualTo(Integer value) {
            addCriterion("loan_nature <>", value, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureGreaterThan(Integer value) {
            addCriterion("loan_nature >", value, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_nature >=", value, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureLessThan(Integer value) {
            addCriterion("loan_nature <", value, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureLessThanOrEqualTo(Integer value) {
            addCriterion("loan_nature <=", value, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureIn(List<Integer> values) {
            addCriterion("loan_nature in", values, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureNotIn(List<Integer> values) {
            addCriterion("loan_nature not in", values, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureBetween(Integer value1, Integer value2) {
            addCriterion("loan_nature between", value1, value2, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_nature not between", value1, value2, "loanNature");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateIsNull() {
            addCriterion("loan_interest_rate is null");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateIsNotNull() {
            addCriterion("loan_interest_rate is not null");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateEqualTo(BigDecimal value) {
            addCriterion("loan_interest_rate =", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateNotEqualTo(BigDecimal value) {
            addCriterion("loan_interest_rate <>", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateGreaterThan(BigDecimal value) {
            addCriterion("loan_interest_rate >", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_interest_rate >=", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateLessThan(BigDecimal value) {
            addCriterion("loan_interest_rate <", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_interest_rate <=", value, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateIn(List<BigDecimal> values) {
            addCriterion("loan_interest_rate in", values, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateNotIn(List<BigDecimal> values) {
            addCriterion("loan_interest_rate not in", values, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_interest_rate between", value1, value2, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanInterestRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_interest_rate not between", value1, value2, "loanInterestRate");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtIsNull() {
            addCriterion("loan_risk_amt is null");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtIsNotNull() {
            addCriterion("loan_risk_amt is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtEqualTo(BigDecimal value) {
            addCriterion("loan_risk_amt =", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtNotEqualTo(BigDecimal value) {
            addCriterion("loan_risk_amt <>", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtGreaterThan(BigDecimal value) {
            addCriterion("loan_risk_amt >", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_risk_amt >=", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtLessThan(BigDecimal value) {
            addCriterion("loan_risk_amt <", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_risk_amt <=", value, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtIn(List<BigDecimal> values) {
            addCriterion("loan_risk_amt in", values, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtNotIn(List<BigDecimal> values) {
            addCriterion("loan_risk_amt not in", values, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_risk_amt between", value1, value2, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_risk_amt not between", value1, value2, "loanRiskAmt");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelIsNull() {
            addCriterion("loan_risk_level is null");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelIsNotNull() {
            addCriterion("loan_risk_level is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelEqualTo(String value) {
            addCriterion("loan_risk_level =", value, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelNotEqualTo(String value) {
            addCriterion("loan_risk_level <>", value, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelGreaterThan(String value) {
            addCriterion("loan_risk_level >", value, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelGreaterThanOrEqualTo(String value) {
            addCriterion("loan_risk_level >=", value, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelLessThan(String value) {
            addCriterion("loan_risk_level <", value, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelLessThanOrEqualTo(String value) {
            addCriterion("loan_risk_level <=", value, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelLike(String value) {
            addCriterion("loan_risk_level like", value, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelNotLike(String value) {
            addCriterion("loan_risk_level not like", value, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelIn(List<String> values) {
            addCriterion("loan_risk_level in", values, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelNotIn(List<String> values) {
            addCriterion("loan_risk_level not in", values, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelBetween(String value1, String value2) {
            addCriterion("loan_risk_level between", value1, value2, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskLevelNotBetween(String value1, String value2) {
            addCriterion("loan_risk_level not between", value1, value2, "loanRiskLevel");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceIsNull() {
            addCriterion("loan_risk_advice is null");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceIsNotNull() {
            addCriterion("loan_risk_advice is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceEqualTo(String value) {
            addCriterion("loan_risk_advice =", value, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceNotEqualTo(String value) {
            addCriterion("loan_risk_advice <>", value, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceGreaterThan(String value) {
            addCriterion("loan_risk_advice >", value, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("loan_risk_advice >=", value, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceLessThan(String value) {
            addCriterion("loan_risk_advice <", value, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceLessThanOrEqualTo(String value) {
            addCriterion("loan_risk_advice <=", value, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceLike(String value) {
            addCriterion("loan_risk_advice like", value, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceNotLike(String value) {
            addCriterion("loan_risk_advice not like", value, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceIn(List<String> values) {
            addCriterion("loan_risk_advice in", values, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceNotIn(List<String> values) {
            addCriterion("loan_risk_advice not in", values, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceBetween(String value1, String value2) {
            addCriterion("loan_risk_advice between", value1, value2, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanRiskAdviceNotBetween(String value1, String value2) {
            addCriterion("loan_risk_advice not between", value1, value2, "loanRiskAdvice");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateIsNull() {
            addCriterion("loan_discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateIsNotNull() {
            addCriterion("loan_discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateEqualTo(BigDecimal value) {
            addCriterion("loan_discount_rate =", value, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateNotEqualTo(BigDecimal value) {
            addCriterion("loan_discount_rate <>", value, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateGreaterThan(BigDecimal value) {
            addCriterion("loan_discount_rate >", value, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_discount_rate >=", value, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateLessThan(BigDecimal value) {
            addCriterion("loan_discount_rate <", value, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_discount_rate <=", value, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateIn(List<BigDecimal> values) {
            addCriterion("loan_discount_rate in", values, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateNotIn(List<BigDecimal> values) {
            addCriterion("loan_discount_rate not in", values, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_discount_rate between", value1, value2, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanDiscountRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_discount_rate not between", value1, value2, "loanDiscountRate");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeIsNull() {
            addCriterion("loan_success_time is null");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeIsNotNull() {
            addCriterion("loan_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeEqualTo(Date value) {
            addCriterion("loan_success_time =", value, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeNotEqualTo(Date value) {
            addCriterion("loan_success_time <>", value, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeGreaterThan(Date value) {
            addCriterion("loan_success_time >", value, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loan_success_time >=", value, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeLessThan(Date value) {
            addCriterion("loan_success_time <", value, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("loan_success_time <=", value, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeIn(List<Date> values) {
            addCriterion("loan_success_time in", values, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeNotIn(List<Date> values) {
            addCriterion("loan_success_time not in", values, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeBetween(Date value1, Date value2) {
            addCriterion("loan_success_time between", value1, value2, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanSuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("loan_success_time not between", value1, value2, "loanSuccessTime");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseIsNull() {
            addCriterion("loan_fund_use is null");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseIsNotNull() {
            addCriterion("loan_fund_use is not null");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseEqualTo(String value) {
            addCriterion("loan_fund_use =", value, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseNotEqualTo(String value) {
            addCriterion("loan_fund_use <>", value, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseGreaterThan(String value) {
            addCriterion("loan_fund_use >", value, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseGreaterThanOrEqualTo(String value) {
            addCriterion("loan_fund_use >=", value, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseLessThan(String value) {
            addCriterion("loan_fund_use <", value, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseLessThanOrEqualTo(String value) {
            addCriterion("loan_fund_use <=", value, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseLike(String value) {
            addCriterion("loan_fund_use like", value, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseNotLike(String value) {
            addCriterion("loan_fund_use not like", value, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseIn(List<String> values) {
            addCriterion("loan_fund_use in", values, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseNotIn(List<String> values) {
            addCriterion("loan_fund_use not in", values, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseBetween(String value1, String value2) {
            addCriterion("loan_fund_use between", value1, value2, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andLoanFundUseNotBetween(String value1, String value2) {
            addCriterion("loan_fund_use not between", value1, value2, "loanFundUse");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountIsNull() {
            addCriterion("repay_month_amount is null");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountIsNotNull() {
            addCriterion("repay_month_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountEqualTo(BigDecimal value) {
            addCriterion("repay_month_amount =", value, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountNotEqualTo(BigDecimal value) {
            addCriterion("repay_month_amount <>", value, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountGreaterThan(BigDecimal value) {
            addCriterion("repay_month_amount >", value, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_month_amount >=", value, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountLessThan(BigDecimal value) {
            addCriterion("repay_month_amount <", value, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_month_amount <=", value, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountIn(List<BigDecimal> values) {
            addCriterion("repay_month_amount in", values, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountNotIn(List<BigDecimal> values) {
            addCriterion("repay_month_amount not in", values, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_month_amount between", value1, value2, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_month_amount not between", value1, value2, "repayMonthAmount");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalIsNull() {
            addCriterion("repay_month_principal is null");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalIsNotNull() {
            addCriterion("repay_month_principal is not null");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalEqualTo(BigDecimal value) {
            addCriterion("repay_month_principal =", value, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalNotEqualTo(BigDecimal value) {
            addCriterion("repay_month_principal <>", value, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalGreaterThan(BigDecimal value) {
            addCriterion("repay_month_principal >", value, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_month_principal >=", value, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalLessThan(BigDecimal value) {
            addCriterion("repay_month_principal <", value, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_month_principal <=", value, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalIn(List<BigDecimal> values) {
            addCriterion("repay_month_principal in", values, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalNotIn(List<BigDecimal> values) {
            addCriterion("repay_month_principal not in", values, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_month_principal between", value1, value2, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayMonthPrincipalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_month_principal not between", value1, value2, "repayMonthPrincipal");
            return (Criteria) this;
        }

        public Criteria andRepayTypeIsNull() {
            addCriterion("repay_type is null");
            return (Criteria) this;
        }

        public Criteria andRepayTypeIsNotNull() {
            addCriterion("repay_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepayTypeEqualTo(String value) {
            addCriterion("repay_type =", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeNotEqualTo(String value) {
            addCriterion("repay_type <>", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeGreaterThan(String value) {
            addCriterion("repay_type >", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("repay_type >=", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeLessThan(String value) {
            addCriterion("repay_type <", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeLessThanOrEqualTo(String value) {
            addCriterion("repay_type <=", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeLike(String value) {
            addCriterion("repay_type like", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeNotLike(String value) {
            addCriterion("repay_type not like", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeIn(List<String> values) {
            addCriterion("repay_type in", values, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeNotIn(List<String> values) {
            addCriterion("repay_type not in", values, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeBetween(String value1, String value2) {
            addCriterion("repay_type between", value1, value2, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeNotBetween(String value1, String value2) {
            addCriterion("repay_type not between", value1, value2, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeIsNull() {
            addCriterion("repay_expiry_time is null");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeIsNotNull() {
            addCriterion("repay_expiry_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeEqualTo(Date value) {
            addCriterionForJDBCTime("repay_expiry_time =", value, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("repay_expiry_time <>", value, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("repay_expiry_time >", value, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("repay_expiry_time >=", value, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeLessThan(Date value) {
            addCriterionForJDBCTime("repay_expiry_time <", value, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("repay_expiry_time <=", value, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeIn(List<Date> values) {
            addCriterionForJDBCTime("repay_expiry_time in", values, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("repay_expiry_time not in", values, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("repay_expiry_time between", value1, value2, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayExpiryTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("repay_expiry_time not between", value1, value2, "repayExpiryTime");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodIsNull() {
            addCriterion("repay_period is null");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodIsNotNull() {
            addCriterion("repay_period is not null");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodEqualTo(Integer value) {
            addCriterion("repay_period =", value, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodNotEqualTo(Integer value) {
            addCriterion("repay_period <>", value, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodGreaterThan(Integer value) {
            addCriterion("repay_period >", value, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("repay_period >=", value, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodLessThan(Integer value) {
            addCriterion("repay_period <", value, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("repay_period <=", value, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodIn(List<Integer> values) {
            addCriterion("repay_period in", values, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodNotIn(List<Integer> values) {
            addCriterion("repay_period not in", values, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodBetween(Integer value1, Integer value2) {
            addCriterion("repay_period between", value1, value2, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("repay_period not between", value1, value2, "repayPeriod");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateIsNull() {
            addCriterion("repay_month_date is null");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateIsNotNull() {
            addCriterion("repay_month_date is not null");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateEqualTo(Integer value) {
            addCriterion("repay_month_date =", value, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateNotEqualTo(Integer value) {
            addCriterion("repay_month_date <>", value, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateGreaterThan(Integer value) {
            addCriterion("repay_month_date >", value, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("repay_month_date >=", value, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateLessThan(Integer value) {
            addCriterion("repay_month_date <", value, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateLessThanOrEqualTo(Integer value) {
            addCriterion("repay_month_date <=", value, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateIn(List<Integer> values) {
            addCriterion("repay_month_date in", values, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateNotIn(List<Integer> values) {
            addCriterion("repay_month_date not in", values, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateBetween(Integer value1, Integer value2) {
            addCriterion("repay_month_date between", value1, value2, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayMonthDateNotBetween(Integer value1, Integer value2) {
            addCriterion("repay_month_date not between", value1, value2, "repayMonthDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateIsNull() {
            addCriterion("repay_first_date is null");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateIsNotNull() {
            addCriterion("repay_first_date is not null");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateEqualTo(Date value) {
            addCriterionForJDBCDate("repay_first_date =", value, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("repay_first_date <>", value, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateGreaterThan(Date value) {
            addCriterionForJDBCDate("repay_first_date >", value, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("repay_first_date >=", value, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateLessThan(Date value) {
            addCriterionForJDBCDate("repay_first_date <", value, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("repay_first_date <=", value, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateIn(List<Date> values) {
            addCriterionForJDBCDate("repay_first_date in", values, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("repay_first_date not in", values, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("repay_first_date between", value1, value2, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayFirstDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("repay_first_date not between", value1, value2, "repayFirstDate");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusIsNull() {
            addCriterion("repay_period_surplus is null");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusIsNotNull() {
            addCriterion("repay_period_surplus is not null");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusEqualTo(Integer value) {
            addCriterion("repay_period_surplus =", value, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusNotEqualTo(Integer value) {
            addCriterion("repay_period_surplus <>", value, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusGreaterThan(Integer value) {
            addCriterion("repay_period_surplus >", value, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusGreaterThanOrEqualTo(Integer value) {
            addCriterion("repay_period_surplus >=", value, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusLessThan(Integer value) {
            addCriterion("repay_period_surplus <", value, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusLessThanOrEqualTo(Integer value) {
            addCriterion("repay_period_surplus <=", value, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusIn(List<Integer> values) {
            addCriterion("repay_period_surplus in", values, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusNotIn(List<Integer> values) {
            addCriterion("repay_period_surplus not in", values, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusBetween(Integer value1, Integer value2) {
            addCriterion("repay_period_surplus between", value1, value2, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayPeriodSurplusNotBetween(Integer value1, Integer value2) {
            addCriterion("repay_period_surplus not between", value1, value2, "repayPeriodSurplus");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleIsNull() {
            addCriterion("repay_is_settle is null");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleIsNotNull() {
            addCriterion("repay_is_settle is not null");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleEqualTo(Integer value) {
            addCriterion("repay_is_settle =", value, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleNotEqualTo(Integer value) {
            addCriterion("repay_is_settle <>", value, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleGreaterThan(Integer value) {
            addCriterion("repay_is_settle >", value, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleGreaterThanOrEqualTo(Integer value) {
            addCriterion("repay_is_settle >=", value, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleLessThan(Integer value) {
            addCriterion("repay_is_settle <", value, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleLessThanOrEqualTo(Integer value) {
            addCriterion("repay_is_settle <=", value, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleIn(List<Integer> values) {
            addCriterion("repay_is_settle in", values, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleNotIn(List<Integer> values) {
            addCriterion("repay_is_settle not in", values, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleBetween(Integer value1, Integer value2) {
            addCriterion("repay_is_settle between", value1, value2, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andRepayIsSettleNotBetween(Integer value1, Integer value2) {
            addCriterion("repay_is_settle not between", value1, value2, "repayIsSettle");
            return (Criteria) this;
        }

        public Criteria andBankNumIsNull() {
            addCriterion("bank_num is null");
            return (Criteria) this;
        }

        public Criteria andBankNumIsNotNull() {
            addCriterion("bank_num is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumEqualTo(String value) {
            addCriterion("bank_num =", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotEqualTo(String value) {
            addCriterion("bank_num <>", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumGreaterThan(String value) {
            addCriterion("bank_num >", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumGreaterThanOrEqualTo(String value) {
            addCriterion("bank_num >=", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLessThan(String value) {
            addCriterion("bank_num <", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLessThanOrEqualTo(String value) {
            addCriterion("bank_num <=", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLike(String value) {
            addCriterion("bank_num like", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotLike(String value) {
            addCriterion("bank_num not like", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumIn(List<String> values) {
            addCriterion("bank_num in", values, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotIn(List<String> values) {
            addCriterion("bank_num not in", values, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumBetween(String value1, String value2) {
            addCriterion("bank_num between", value1, value2, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotBetween(String value1, String value2) {
            addCriterion("bank_num not between", value1, value2, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNull() {
            addCriterion("bank_card_no is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNotNull() {
            addCriterion("bank_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoEqualTo(String value) {
            addCriterion("bank_card_no =", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotEqualTo(String value) {
            addCriterion("bank_card_no <>", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThan(String value) {
            addCriterion("bank_card_no >", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_no >=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThan(String value) {
            addCriterion("bank_card_no <", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThanOrEqualTo(String value) {
            addCriterion("bank_card_no <=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLike(String value) {
            addCriterion("bank_card_no like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotLike(String value) {
            addCriterion("bank_card_no not like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIn(List<String> values) {
            addCriterion("bank_card_no in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotIn(List<String> values) {
            addCriterion("bank_card_no not in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoBetween(String value1, String value2) {
            addCriterion("bank_card_no between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotBetween(String value1, String value2) {
            addCriterion("bank_card_no not between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankMobileIsNull() {
            addCriterion("bank_mobile is null");
            return (Criteria) this;
        }

        public Criteria andBankMobileIsNotNull() {
            addCriterion("bank_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andBankMobileEqualTo(String value) {
            addCriterion("bank_mobile =", value, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileNotEqualTo(String value) {
            addCriterion("bank_mobile <>", value, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileGreaterThan(String value) {
            addCriterion("bank_mobile >", value, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileGreaterThanOrEqualTo(String value) {
            addCriterion("bank_mobile >=", value, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileLessThan(String value) {
            addCriterion("bank_mobile <", value, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileLessThanOrEqualTo(String value) {
            addCriterion("bank_mobile <=", value, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileLike(String value) {
            addCriterion("bank_mobile like", value, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileNotLike(String value) {
            addCriterion("bank_mobile not like", value, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileIn(List<String> values) {
            addCriterion("bank_mobile in", values, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileNotIn(List<String> values) {
            addCriterion("bank_mobile not in", values, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileBetween(String value1, String value2) {
            addCriterion("bank_mobile between", value1, value2, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankMobileNotBetween(String value1, String value2) {
            addCriterion("bank_mobile not between", value1, value2, "bankMobile");
            return (Criteria) this;
        }

        public Criteria andBankProvinceIsNull() {
            addCriterion("bank_province is null");
            return (Criteria) this;
        }

        public Criteria andBankProvinceIsNotNull() {
            addCriterion("bank_province is not null");
            return (Criteria) this;
        }

        public Criteria andBankProvinceEqualTo(String value) {
            addCriterion("bank_province =", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceNotEqualTo(String value) {
            addCriterion("bank_province <>", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceGreaterThan(String value) {
            addCriterion("bank_province >", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("bank_province >=", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceLessThan(String value) {
            addCriterion("bank_province <", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceLessThanOrEqualTo(String value) {
            addCriterion("bank_province <=", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceLike(String value) {
            addCriterion("bank_province like", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceNotLike(String value) {
            addCriterion("bank_province not like", value, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceIn(List<String> values) {
            addCriterion("bank_province in", values, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceNotIn(List<String> values) {
            addCriterion("bank_province not in", values, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceBetween(String value1, String value2) {
            addCriterion("bank_province between", value1, value2, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankProvinceNotBetween(String value1, String value2) {
            addCriterion("bank_province not between", value1, value2, "bankProvince");
            return (Criteria) this;
        }

        public Criteria andBankCityIsNull() {
            addCriterion("bank_city is null");
            return (Criteria) this;
        }

        public Criteria andBankCityIsNotNull() {
            addCriterion("bank_city is not null");
            return (Criteria) this;
        }

        public Criteria andBankCityEqualTo(String value) {
            addCriterion("bank_city =", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityNotEqualTo(String value) {
            addCriterion("bank_city <>", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityGreaterThan(String value) {
            addCriterion("bank_city >", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityGreaterThanOrEqualTo(String value) {
            addCriterion("bank_city >=", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityLessThan(String value) {
            addCriterion("bank_city <", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityLessThanOrEqualTo(String value) {
            addCriterion("bank_city <=", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityLike(String value) {
            addCriterion("bank_city like", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityNotLike(String value) {
            addCriterion("bank_city not like", value, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityIn(List<String> values) {
            addCriterion("bank_city in", values, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityNotIn(List<String> values) {
            addCriterion("bank_city not in", values, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityBetween(String value1, String value2) {
            addCriterion("bank_city between", value1, value2, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankCityNotBetween(String value1, String value2) {
            addCriterion("bank_city not between", value1, value2, "bankCity");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameIsNull() {
            addCriterion("bank_branch_name is null");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameIsNotNull() {
            addCriterion("bank_branch_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameEqualTo(String value) {
            addCriterion("bank_branch_name =", value, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameNotEqualTo(String value) {
            addCriterion("bank_branch_name <>", value, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameGreaterThan(String value) {
            addCriterion("bank_branch_name >", value, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_branch_name >=", value, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameLessThan(String value) {
            addCriterion("bank_branch_name <", value, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameLessThanOrEqualTo(String value) {
            addCriterion("bank_branch_name <=", value, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameLike(String value) {
            addCriterion("bank_branch_name like", value, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameNotLike(String value) {
            addCriterion("bank_branch_name not like", value, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameIn(List<String> values) {
            addCriterion("bank_branch_name in", values, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameNotIn(List<String> values) {
            addCriterion("bank_branch_name not in", values, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameBetween(String value1, String value2) {
            addCriterion("bank_branch_name between", value1, value2, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andBankBranchNameNotBetween(String value1, String value2) {
            addCriterion("bank_branch_name not between", value1, value2, "bankBranchName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNull() {
            addCriterion("legal_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNotNull() {
            addCriterion("legal_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalNameEqualTo(String value) {
            addCriterion("legal_name =", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotEqualTo(String value) {
            addCriterion("legal_name <>", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThan(String value) {
            addCriterion("legal_name >", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_name >=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThan(String value) {
            addCriterion("legal_name <", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThanOrEqualTo(String value) {
            addCriterion("legal_name <=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLike(String value) {
            addCriterion("legal_name like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotLike(String value) {
            addCriterion("legal_name not like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIn(List<String> values) {
            addCriterion("legal_name in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotIn(List<String> values) {
            addCriterion("legal_name not in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameBetween(String value1, String value2) {
            addCriterion("legal_name between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotBetween(String value1, String value2) {
            addCriterion("legal_name not between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardIsNull() {
            addCriterion("legal_id_card is null");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardIsNotNull() {
            addCriterion("legal_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardEqualTo(String value) {
            addCriterion("legal_id_card =", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardNotEqualTo(String value) {
            addCriterion("legal_id_card <>", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardGreaterThan(String value) {
            addCriterion("legal_id_card >", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("legal_id_card >=", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardLessThan(String value) {
            addCriterion("legal_id_card <", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardLessThanOrEqualTo(String value) {
            addCriterion("legal_id_card <=", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardLike(String value) {
            addCriterion("legal_id_card like", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardNotLike(String value) {
            addCriterion("legal_id_card not like", value, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardIn(List<String> values) {
            addCriterion("legal_id_card in", values, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardNotIn(List<String> values) {
            addCriterion("legal_id_card not in", values, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardBetween(String value1, String value2) {
            addCriterion("legal_id_card between", value1, value2, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalIdCardNotBetween(String value1, String value2) {
            addCriterion("legal_id_card not between", value1, value2, "legalIdCard");
            return (Criteria) this;
        }

        public Criteria andLegalMobileIsNull() {
            addCriterion("legal_mobile is null");
            return (Criteria) this;
        }

        public Criteria andLegalMobileIsNotNull() {
            addCriterion("legal_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andLegalMobileEqualTo(String value) {
            addCriterion("legal_mobile =", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileNotEqualTo(String value) {
            addCriterion("legal_mobile <>", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileGreaterThan(String value) {
            addCriterion("legal_mobile >", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileGreaterThanOrEqualTo(String value) {
            addCriterion("legal_mobile >=", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileLessThan(String value) {
            addCriterion("legal_mobile <", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileLessThanOrEqualTo(String value) {
            addCriterion("legal_mobile <=", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileLike(String value) {
            addCriterion("legal_mobile like", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileNotLike(String value) {
            addCriterion("legal_mobile not like", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileIn(List<String> values) {
            addCriterion("legal_mobile in", values, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileNotIn(List<String> values) {
            addCriterion("legal_mobile not in", values, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileBetween(String value1, String value2) {
            addCriterion("legal_mobile between", value1, value2, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileNotBetween(String value1, String value2) {
            addCriterion("legal_mobile not between", value1, value2, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceIsNull() {
            addCriterion("legal_card_face is null");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceIsNotNull() {
            addCriterion("legal_card_face is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceEqualTo(String value) {
            addCriterion("legal_card_face =", value, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceNotEqualTo(String value) {
            addCriterion("legal_card_face <>", value, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceGreaterThan(String value) {
            addCriterion("legal_card_face >", value, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceGreaterThanOrEqualTo(String value) {
            addCriterion("legal_card_face >=", value, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceLessThan(String value) {
            addCriterion("legal_card_face <", value, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceLessThanOrEqualTo(String value) {
            addCriterion("legal_card_face <=", value, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceLike(String value) {
            addCriterion("legal_card_face like", value, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceNotLike(String value) {
            addCriterion("legal_card_face not like", value, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceIn(List<String> values) {
            addCriterion("legal_card_face in", values, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceNotIn(List<String> values) {
            addCriterion("legal_card_face not in", values, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceBetween(String value1, String value2) {
            addCriterion("legal_card_face between", value1, value2, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardFaceNotBetween(String value1, String value2) {
            addCriterion("legal_card_face not between", value1, value2, "legalCardFace");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackIsNull() {
            addCriterion("legal_card_back is null");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackIsNotNull() {
            addCriterion("legal_card_back is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackEqualTo(String value) {
            addCriterion("legal_card_back =", value, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackNotEqualTo(String value) {
            addCriterion("legal_card_back <>", value, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackGreaterThan(String value) {
            addCriterion("legal_card_back >", value, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackGreaterThanOrEqualTo(String value) {
            addCriterion("legal_card_back >=", value, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackLessThan(String value) {
            addCriterion("legal_card_back <", value, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackLessThanOrEqualTo(String value) {
            addCriterion("legal_card_back <=", value, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackLike(String value) {
            addCriterion("legal_card_back like", value, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackNotLike(String value) {
            addCriterion("legal_card_back not like", value, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackIn(List<String> values) {
            addCriterion("legal_card_back in", values, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackNotIn(List<String> values) {
            addCriterion("legal_card_back not in", values, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackBetween(String value1, String value2) {
            addCriterion("legal_card_back between", value1, value2, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andLegalCardBackNotBetween(String value1, String value2) {
            addCriterion("legal_card_back not between", value1, value2, "legalCardBack");
            return (Criteria) this;
        }

        public Criteria andHandleNameIsNull() {
            addCriterion("handle_name is null");
            return (Criteria) this;
        }

        public Criteria andHandleNameIsNotNull() {
            addCriterion("handle_name is not null");
            return (Criteria) this;
        }

        public Criteria andHandleNameEqualTo(String value) {
            addCriterion("handle_name =", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameNotEqualTo(String value) {
            addCriterion("handle_name <>", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameGreaterThan(String value) {
            addCriterion("handle_name >", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameGreaterThanOrEqualTo(String value) {
            addCriterion("handle_name >=", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameLessThan(String value) {
            addCriterion("handle_name <", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameLessThanOrEqualTo(String value) {
            addCriterion("handle_name <=", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameLike(String value) {
            addCriterion("handle_name like", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameNotLike(String value) {
            addCriterion("handle_name not like", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameIn(List<String> values) {
            addCriterion("handle_name in", values, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameNotIn(List<String> values) {
            addCriterion("handle_name not in", values, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameBetween(String value1, String value2) {
            addCriterion("handle_name between", value1, value2, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameNotBetween(String value1, String value2) {
            addCriterion("handle_name not between", value1, value2, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardIsNull() {
            addCriterion("handle_id_card is null");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardIsNotNull() {
            addCriterion("handle_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardEqualTo(String value) {
            addCriterion("handle_id_card =", value, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardNotEqualTo(String value) {
            addCriterion("handle_id_card <>", value, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardGreaterThan(String value) {
            addCriterion("handle_id_card >", value, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("handle_id_card >=", value, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardLessThan(String value) {
            addCriterion("handle_id_card <", value, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardLessThanOrEqualTo(String value) {
            addCriterion("handle_id_card <=", value, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardLike(String value) {
            addCriterion("handle_id_card like", value, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardNotLike(String value) {
            addCriterion("handle_id_card not like", value, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardIn(List<String> values) {
            addCriterion("handle_id_card in", values, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardNotIn(List<String> values) {
            addCriterion("handle_id_card not in", values, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardBetween(String value1, String value2) {
            addCriterion("handle_id_card between", value1, value2, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleIdCardNotBetween(String value1, String value2) {
            addCriterion("handle_id_card not between", value1, value2, "handleIdCard");
            return (Criteria) this;
        }

        public Criteria andHandleMobileIsNull() {
            addCriterion("handle_mobile is null");
            return (Criteria) this;
        }

        public Criteria andHandleMobileIsNotNull() {
            addCriterion("handle_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andHandleMobileEqualTo(String value) {
            addCriterion("handle_mobile =", value, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileNotEqualTo(String value) {
            addCriterion("handle_mobile <>", value, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileGreaterThan(String value) {
            addCriterion("handle_mobile >", value, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileGreaterThanOrEqualTo(String value) {
            addCriterion("handle_mobile >=", value, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileLessThan(String value) {
            addCriterion("handle_mobile <", value, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileLessThanOrEqualTo(String value) {
            addCriterion("handle_mobile <=", value, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileLike(String value) {
            addCriterion("handle_mobile like", value, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileNotLike(String value) {
            addCriterion("handle_mobile not like", value, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileIn(List<String> values) {
            addCriterion("handle_mobile in", values, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileNotIn(List<String> values) {
            addCriterion("handle_mobile not in", values, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileBetween(String value1, String value2) {
            addCriterion("handle_mobile between", value1, value2, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleMobileNotBetween(String value1, String value2) {
            addCriterion("handle_mobile not between", value1, value2, "handleMobile");
            return (Criteria) this;
        }

        public Criteria andHandleDutyIsNull() {
            addCriterion("handle_duty is null");
            return (Criteria) this;
        }

        public Criteria andHandleDutyIsNotNull() {
            addCriterion("handle_duty is not null");
            return (Criteria) this;
        }

        public Criteria andHandleDutyEqualTo(String value) {
            addCriterion("handle_duty =", value, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyNotEqualTo(String value) {
            addCriterion("handle_duty <>", value, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyGreaterThan(String value) {
            addCriterion("handle_duty >", value, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyGreaterThanOrEqualTo(String value) {
            addCriterion("handle_duty >=", value, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyLessThan(String value) {
            addCriterion("handle_duty <", value, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyLessThanOrEqualTo(String value) {
            addCriterion("handle_duty <=", value, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyLike(String value) {
            addCriterion("handle_duty like", value, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyNotLike(String value) {
            addCriterion("handle_duty not like", value, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyIn(List<String> values) {
            addCriterion("handle_duty in", values, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyNotIn(List<String> values) {
            addCriterion("handle_duty not in", values, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyBetween(String value1, String value2) {
            addCriterion("handle_duty between", value1, value2, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andHandleDutyNotBetween(String value1, String value2) {
            addCriterion("handle_duty not between", value1, value2, "handleDuty");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardIsNull() {
            addCriterion("company_assure_id_card is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardIsNotNull() {
            addCriterion("company_assure_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardEqualTo(String value) {
            addCriterion("company_assure_id_card =", value, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardNotEqualTo(String value) {
            addCriterion("company_assure_id_card <>", value, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardGreaterThan(String value) {
            addCriterion("company_assure_id_card >", value, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("company_assure_id_card >=", value, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardLessThan(String value) {
            addCriterion("company_assure_id_card <", value, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardLessThanOrEqualTo(String value) {
            addCriterion("company_assure_id_card <=", value, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardLike(String value) {
            addCriterion("company_assure_id_card like", value, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardNotLike(String value) {
            addCriterion("company_assure_id_card not like", value, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardIn(List<String> values) {
            addCriterion("company_assure_id_card in", values, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardNotIn(List<String> values) {
            addCriterion("company_assure_id_card not in", values, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardBetween(String value1, String value2) {
            addCriterion("company_assure_id_card between", value1, value2, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureIdCardNotBetween(String value1, String value2) {
            addCriterion("company_assure_id_card not between", value1, value2, "companyAssureIdCard");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameIsNull() {
            addCriterion("company_assure_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameIsNotNull() {
            addCriterion("company_assure_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameEqualTo(String value) {
            addCriterion("company_assure_name =", value, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameNotEqualTo(String value) {
            addCriterion("company_assure_name <>", value, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameGreaterThan(String value) {
            addCriterion("company_assure_name >", value, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_assure_name >=", value, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameLessThan(String value) {
            addCriterion("company_assure_name <", value, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameLessThanOrEqualTo(String value) {
            addCriterion("company_assure_name <=", value, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameLike(String value) {
            addCriterion("company_assure_name like", value, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameNotLike(String value) {
            addCriterion("company_assure_name not like", value, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameIn(List<String> values) {
            addCriterion("company_assure_name in", values, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameNotIn(List<String> values) {
            addCriterion("company_assure_name not in", values, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameBetween(String value1, String value2) {
            addCriterion("company_assure_name between", value1, value2, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyAssureNameNotBetween(String value1, String value2) {
            addCriterion("company_assure_name not between", value1, value2, "companyAssureName");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankIsNull() {
            addCriterion("company_risk_rank is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankIsNotNull() {
            addCriterion("company_risk_rank is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankEqualTo(String value) {
            addCriterion("company_risk_rank =", value, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankNotEqualTo(String value) {
            addCriterion("company_risk_rank <>", value, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankGreaterThan(String value) {
            addCriterion("company_risk_rank >", value, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankGreaterThanOrEqualTo(String value) {
            addCriterion("company_risk_rank >=", value, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankLessThan(String value) {
            addCriterion("company_risk_rank <", value, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankLessThanOrEqualTo(String value) {
            addCriterion("company_risk_rank <=", value, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankLike(String value) {
            addCriterion("company_risk_rank like", value, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankNotLike(String value) {
            addCriterion("company_risk_rank not like", value, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankIn(List<String> values) {
            addCriterion("company_risk_rank in", values, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankNotIn(List<String> values) {
            addCriterion("company_risk_rank not in", values, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankBetween(String value1, String value2) {
            addCriterion("company_risk_rank between", value1, value2, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyRiskRankNotBetween(String value1, String value2) {
            addCriterion("company_risk_rank not between", value1, value2, "companyRiskRank");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNull() {
            addCriterion("company_nature is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNotNull() {
            addCriterion("company_nature is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureEqualTo(Integer value) {
            addCriterion("company_nature =", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotEqualTo(Integer value) {
            addCriterion("company_nature <>", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThan(Integer value) {
            addCriterion("company_nature >", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_nature >=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThan(Integer value) {
            addCriterion("company_nature <", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThanOrEqualTo(Integer value) {
            addCriterion("company_nature <=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIn(List<Integer> values) {
            addCriterion("company_nature in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotIn(List<Integer> values) {
            addCriterion("company_nature not in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureBetween(Integer value1, Integer value2) {
            addCriterion("company_nature between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("company_nature not between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceIsNull() {
            addCriterion("company_refer_province is null");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceIsNotNull() {
            addCriterion("company_refer_province is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceEqualTo(String value) {
            addCriterion("company_refer_province =", value, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceNotEqualTo(String value) {
            addCriterion("company_refer_province <>", value, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceGreaterThan(String value) {
            addCriterion("company_refer_province >", value, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("company_refer_province >=", value, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceLessThan(String value) {
            addCriterion("company_refer_province <", value, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceLessThanOrEqualTo(String value) {
            addCriterion("company_refer_province <=", value, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceLike(String value) {
            addCriterion("company_refer_province like", value, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceNotLike(String value) {
            addCriterion("company_refer_province not like", value, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceIn(List<String> values) {
            addCriterion("company_refer_province in", values, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceNotIn(List<String> values) {
            addCriterion("company_refer_province not in", values, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceBetween(String value1, String value2) {
            addCriterion("company_refer_province between", value1, value2, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferProvinceNotBetween(String value1, String value2) {
            addCriterion("company_refer_province not between", value1, value2, "companyReferProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityIsNull() {
            addCriterion("company_refer_city is null");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityIsNotNull() {
            addCriterion("company_refer_city is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityEqualTo(String value) {
            addCriterion("company_refer_city =", value, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityNotEqualTo(String value) {
            addCriterion("company_refer_city <>", value, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityGreaterThan(String value) {
            addCriterion("company_refer_city >", value, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityGreaterThanOrEqualTo(String value) {
            addCriterion("company_refer_city >=", value, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityLessThan(String value) {
            addCriterion("company_refer_city <", value, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityLessThanOrEqualTo(String value) {
            addCriterion("company_refer_city <=", value, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityLike(String value) {
            addCriterion("company_refer_city like", value, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityNotLike(String value) {
            addCriterion("company_refer_city not like", value, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityIn(List<String> values) {
            addCriterion("company_refer_city in", values, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityNotIn(List<String> values) {
            addCriterion("company_refer_city not in", values, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityBetween(String value1, String value2) {
            addCriterion("company_refer_city between", value1, value2, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyReferCityNotBetween(String value1, String value2) {
            addCriterion("company_refer_city not between", value1, value2, "companyReferCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceIsNull() {
            addCriterion("company_place_province is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceIsNotNull() {
            addCriterion("company_place_province is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceEqualTo(String value) {
            addCriterion("company_place_province =", value, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceNotEqualTo(String value) {
            addCriterion("company_place_province <>", value, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceGreaterThan(String value) {
            addCriterion("company_place_province >", value, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("company_place_province >=", value, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceLessThan(String value) {
            addCriterion("company_place_province <", value, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceLessThanOrEqualTo(String value) {
            addCriterion("company_place_province <=", value, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceLike(String value) {
            addCriterion("company_place_province like", value, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceNotLike(String value) {
            addCriterion("company_place_province not like", value, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceIn(List<String> values) {
            addCriterion("company_place_province in", values, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceNotIn(List<String> values) {
            addCriterion("company_place_province not in", values, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceBetween(String value1, String value2) {
            addCriterion("company_place_province between", value1, value2, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceProvinceNotBetween(String value1, String value2) {
            addCriterion("company_place_province not between", value1, value2, "companyPlaceProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityIsNull() {
            addCriterion("company_place_city is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityIsNotNull() {
            addCriterion("company_place_city is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityEqualTo(String value) {
            addCriterion("company_place_city =", value, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityNotEqualTo(String value) {
            addCriterion("company_place_city <>", value, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityGreaterThan(String value) {
            addCriterion("company_place_city >", value, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityGreaterThanOrEqualTo(String value) {
            addCriterion("company_place_city >=", value, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityLessThan(String value) {
            addCriterion("company_place_city <", value, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityLessThanOrEqualTo(String value) {
            addCriterion("company_place_city <=", value, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityLike(String value) {
            addCriterion("company_place_city like", value, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityNotLike(String value) {
            addCriterion("company_place_city not like", value, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityIn(List<String> values) {
            addCriterion("company_place_city in", values, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityNotIn(List<String> values) {
            addCriterion("company_place_city not in", values, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityBetween(String value1, String value2) {
            addCriterion("company_place_city between", value1, value2, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPlaceCityNotBetween(String value1, String value2) {
            addCriterion("company_place_city not between", value1, value2, "companyPlaceCity");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateIsNull() {
            addCriterion("company_create_date is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateIsNotNull() {
            addCriterion("company_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("company_create_date =", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("company_create_date <>", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("company_create_date >", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("company_create_date >=", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("company_create_date <", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("company_create_date <=", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("company_create_date in", values, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("company_create_date not in", values, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("company_create_date between", value1, value2, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("company_create_date not between", value1, value2, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryIsNull() {
            addCriterion("company_industry is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryIsNotNull() {
            addCriterion("company_industry is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryEqualTo(String value) {
            addCriterion("company_industry =", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryNotEqualTo(String value) {
            addCriterion("company_industry <>", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryGreaterThan(String value) {
            addCriterion("company_industry >", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("company_industry >=", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryLessThan(String value) {
            addCriterion("company_industry <", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryLessThanOrEqualTo(String value) {
            addCriterion("company_industry <=", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryLike(String value) {
            addCriterion("company_industry like", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryNotLike(String value) {
            addCriterion("company_industry not like", value, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryIn(List<String> values) {
            addCriterion("company_industry in", values, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryNotIn(List<String> values) {
            addCriterion("company_industry not in", values, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryBetween(String value1, String value2) {
            addCriterion("company_industry between", value1, value2, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyIndustryNotBetween(String value1, String value2) {
            addCriterion("company_industry not between", value1, value2, "companyIndustry");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusIsNull() {
            addCriterion("company_operate_status is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusIsNotNull() {
            addCriterion("company_operate_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusEqualTo(String value) {
            addCriterion("company_operate_status =", value, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusNotEqualTo(String value) {
            addCriterion("company_operate_status <>", value, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusGreaterThan(String value) {
            addCriterion("company_operate_status >", value, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusGreaterThanOrEqualTo(String value) {
            addCriterion("company_operate_status >=", value, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusLessThan(String value) {
            addCriterion("company_operate_status <", value, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusLessThanOrEqualTo(String value) {
            addCriterion("company_operate_status <=", value, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusLike(String value) {
            addCriterion("company_operate_status like", value, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusNotLike(String value) {
            addCriterion("company_operate_status not like", value, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusIn(List<String> values) {
            addCriterion("company_operate_status in", values, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusNotIn(List<String> values) {
            addCriterion("company_operate_status not in", values, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusBetween(String value1, String value2) {
            addCriterion("company_operate_status between", value1, value2, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStatusNotBetween(String value1, String value2) {
            addCriterion("company_operate_status not between", value1, value2, "companyOperateStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeIsNull() {
            addCriterion("company_year_income is null");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeIsNotNull() {
            addCriterion("company_year_income is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeEqualTo(BigDecimal value) {
            addCriterion("company_year_income =", value, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeNotEqualTo(BigDecimal value) {
            addCriterion("company_year_income <>", value, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeGreaterThan(BigDecimal value) {
            addCriterion("company_year_income >", value, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("company_year_income >=", value, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeLessThan(BigDecimal value) {
            addCriterion("company_year_income <", value, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("company_year_income <=", value, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeIn(List<BigDecimal> values) {
            addCriterion("company_year_income in", values, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeNotIn(List<BigDecimal> values) {
            addCriterion("company_year_income not in", values, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_year_income between", value1, value2, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyYearIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_year_income not between", value1, value2, "companyYearIncome");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountIsNull() {
            addCriterion("company_debt_amount is null");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountIsNotNull() {
            addCriterion("company_debt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountEqualTo(BigDecimal value) {
            addCriterion("company_debt_amount =", value, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountNotEqualTo(BigDecimal value) {
            addCriterion("company_debt_amount <>", value, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountGreaterThan(BigDecimal value) {
            addCriterion("company_debt_amount >", value, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("company_debt_amount >=", value, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountLessThan(BigDecimal value) {
            addCriterion("company_debt_amount <", value, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("company_debt_amount <=", value, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountIn(List<BigDecimal> values) {
            addCriterion("company_debt_amount in", values, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountNotIn(List<BigDecimal> values) {
            addCriterion("company_debt_amount not in", values, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_debt_amount between", value1, value2, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyDebtAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_debt_amount not between", value1, value2, "companyDebtAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateIsNull() {
            addCriterion("company_operate_start_date is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateIsNotNull() {
            addCriterion("company_operate_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("company_operate_start_date =", value, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("company_operate_start_date <>", value, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("company_operate_start_date >", value, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("company_operate_start_date >=", value, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateLessThan(Date value) {
            addCriterionForJDBCDate("company_operate_start_date <", value, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("company_operate_start_date <=", value, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("company_operate_start_date in", values, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("company_operate_start_date not in", values, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("company_operate_start_date between", value1, value2, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("company_operate_start_date not between", value1, value2, "companyOperateStartDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateIsNull() {
            addCriterion("company_operate_end_date is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateIsNotNull() {
            addCriterion("company_operate_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("company_operate_end_date =", value, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("company_operate_end_date <>", value, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("company_operate_end_date >", value, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("company_operate_end_date >=", value, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateLessThan(Date value) {
            addCriterionForJDBCDate("company_operate_end_date <", value, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("company_operate_end_date <=", value, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("company_operate_end_date in", values, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("company_operate_end_date not in", values, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("company_operate_end_date between", value1, value2, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("company_operate_end_date not between", value1, value2, "companyOperateEndDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountIsNull() {
            addCriterion("company_register_amount is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountIsNotNull() {
            addCriterion("company_register_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountEqualTo(BigDecimal value) {
            addCriterion("company_register_amount =", value, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountNotEqualTo(BigDecimal value) {
            addCriterion("company_register_amount <>", value, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountGreaterThan(BigDecimal value) {
            addCriterion("company_register_amount >", value, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("company_register_amount >=", value, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountLessThan(BigDecimal value) {
            addCriterion("company_register_amount <", value, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("company_register_amount <=", value, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountIn(List<BigDecimal> values) {
            addCriterion("company_register_amount in", values, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountNotIn(List<BigDecimal> values) {
            addCriterion("company_register_amount not in", values, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_register_amount between", value1, value2, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_register_amount not between", value1, value2, "companyRegisterAmount");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganIsNull() {
            addCriterion("company_register_organ is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganIsNotNull() {
            addCriterion("company_register_organ is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganEqualTo(String value) {
            addCriterion("company_register_organ =", value, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganNotEqualTo(String value) {
            addCriterion("company_register_organ <>", value, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganGreaterThan(String value) {
            addCriterion("company_register_organ >", value, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganGreaterThanOrEqualTo(String value) {
            addCriterion("company_register_organ >=", value, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganLessThan(String value) {
            addCriterion("company_register_organ <", value, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganLessThanOrEqualTo(String value) {
            addCriterion("company_register_organ <=", value, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganLike(String value) {
            addCriterion("company_register_organ like", value, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganNotLike(String value) {
            addCriterion("company_register_organ not like", value, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganIn(List<String> values) {
            addCriterion("company_register_organ in", values, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganNotIn(List<String> values) {
            addCriterion("company_register_organ not in", values, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganBetween(String value1, String value2) {
            addCriterion("company_register_organ between", value1, value2, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterOrganNotBetween(String value1, String value2) {
            addCriterion("company_register_organ not between", value1, value2, "companyRegisterOrgan");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeIsNull() {
            addCriterion("company_operate_range is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeIsNotNull() {
            addCriterion("company_operate_range is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeEqualTo(String value) {
            addCriterion("company_operate_range =", value, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeNotEqualTo(String value) {
            addCriterion("company_operate_range <>", value, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeGreaterThan(String value) {
            addCriterion("company_operate_range >", value, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeGreaterThanOrEqualTo(String value) {
            addCriterion("company_operate_range >=", value, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeLessThan(String value) {
            addCriterion("company_operate_range <", value, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeLessThanOrEqualTo(String value) {
            addCriterion("company_operate_range <=", value, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeLike(String value) {
            addCriterion("company_operate_range like", value, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeNotLike(String value) {
            addCriterion("company_operate_range not like", value, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeIn(List<String> values) {
            addCriterion("company_operate_range in", values, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeNotIn(List<String> values) {
            addCriterion("company_operate_range not in", values, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeBetween(String value1, String value2) {
            addCriterion("company_operate_range between", value1, value2, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateRangeNotBetween(String value1, String value2) {
            addCriterion("company_operate_range not between", value1, value2, "companyOperateRange");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateIsNull() {
            addCriterion("company_operate_finance_state is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateIsNotNull() {
            addCriterion("company_operate_finance_state is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateEqualTo(String value) {
            addCriterion("company_operate_finance_state =", value, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateNotEqualTo(String value) {
            addCriterion("company_operate_finance_state <>", value, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateGreaterThan(String value) {
            addCriterion("company_operate_finance_state >", value, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateGreaterThanOrEqualTo(String value) {
            addCriterion("company_operate_finance_state >=", value, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateLessThan(String value) {
            addCriterion("company_operate_finance_state <", value, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateLessThanOrEqualTo(String value) {
            addCriterion("company_operate_finance_state <=", value, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateLike(String value) {
            addCriterion("company_operate_finance_state like", value, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateNotLike(String value) {
            addCriterion("company_operate_finance_state not like", value, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateIn(List<String> values) {
            addCriterion("company_operate_finance_state in", values, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateNotIn(List<String> values) {
            addCriterion("company_operate_finance_state not in", values, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateBetween(String value1, String value2) {
            addCriterion("company_operate_finance_state between", value1, value2, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyOperateFinanceStateNotBetween(String value1, String value2) {
            addCriterion("company_operate_finance_state not between", value1, value2, "companyOperateFinanceState");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeIsNull() {
            addCriterion("company_repay_ability_change is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeIsNotNull() {
            addCriterion("company_repay_ability_change is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeEqualTo(String value) {
            addCriterion("company_repay_ability_change =", value, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeNotEqualTo(String value) {
            addCriterion("company_repay_ability_change <>", value, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeGreaterThan(String value) {
            addCriterion("company_repay_ability_change >", value, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeGreaterThanOrEqualTo(String value) {
            addCriterion("company_repay_ability_change >=", value, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeLessThan(String value) {
            addCriterion("company_repay_ability_change <", value, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeLessThanOrEqualTo(String value) {
            addCriterion("company_repay_ability_change <=", value, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeLike(String value) {
            addCriterion("company_repay_ability_change like", value, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeNotLike(String value) {
            addCriterion("company_repay_ability_change not like", value, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeIn(List<String> values) {
            addCriterion("company_repay_ability_change in", values, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeNotIn(List<String> values) {
            addCriterion("company_repay_ability_change not in", values, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeBetween(String value1, String value2) {
            addCriterion("company_repay_ability_change between", value1, value2, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyRepayAbilityChangeNotBetween(String value1, String value2) {
            addCriterion("company_repay_ability_change not between", value1, value2, "companyRepayAbilityChange");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusIsNull() {
            addCriterion("company_overdue_status is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusIsNotNull() {
            addCriterion("company_overdue_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusEqualTo(Integer value) {
            addCriterion("company_overdue_status =", value, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusNotEqualTo(Integer value) {
            addCriterion("company_overdue_status <>", value, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusGreaterThan(Integer value) {
            addCriterion("company_overdue_status >", value, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_overdue_status >=", value, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusLessThan(Integer value) {
            addCriterion("company_overdue_status <", value, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusLessThanOrEqualTo(Integer value) {
            addCriterion("company_overdue_status <=", value, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusIn(List<Integer> values) {
            addCriterion("company_overdue_status in", values, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusNotIn(List<Integer> values) {
            addCriterion("company_overdue_status not in", values, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusBetween(Integer value1, Integer value2) {
            addCriterion("company_overdue_status between", value1, value2, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyOverdueStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("company_overdue_status not between", value1, value2, "companyOverdueStatus");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveIsNull() {
            addCriterion("company_is_involve is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveIsNotNull() {
            addCriterion("company_is_involve is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveEqualTo(Integer value) {
            addCriterion("company_is_involve =", value, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveNotEqualTo(Integer value) {
            addCriterion("company_is_involve <>", value, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveGreaterThan(Integer value) {
            addCriterion("company_is_involve >", value, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_is_involve >=", value, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveLessThan(Integer value) {
            addCriterion("company_is_involve <", value, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveLessThanOrEqualTo(Integer value) {
            addCriterion("company_is_involve <=", value, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveIn(List<Integer> values) {
            addCriterion("company_is_involve in", values, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveNotIn(List<Integer> values) {
            addCriterion("company_is_involve not in", values, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveBetween(Integer value1, Integer value2) {
            addCriterion("company_is_involve between", value1, value2, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsInvolveNotBetween(Integer value1, Integer value2) {
            addCriterion("company_is_involve not between", value1, value2, "companyIsInvolve");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyIsNull() {
            addCriterion("company_is_administrative_penalty is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyIsNotNull() {
            addCriterion("company_is_administrative_penalty is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyEqualTo(Integer value) {
            addCriterion("company_is_administrative_penalty =", value, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyNotEqualTo(Integer value) {
            addCriterion("company_is_administrative_penalty <>", value, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyGreaterThan(Integer value) {
            addCriterion("company_is_administrative_penalty >", value, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_is_administrative_penalty >=", value, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyLessThan(Integer value) {
            addCriterion("company_is_administrative_penalty <", value, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyLessThanOrEqualTo(Integer value) {
            addCriterion("company_is_administrative_penalty <=", value, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyIn(List<Integer> values) {
            addCriterion("company_is_administrative_penalty in", values, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyNotIn(List<Integer> values) {
            addCriterion("company_is_administrative_penalty not in", values, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyBetween(Integer value1, Integer value2) {
            addCriterion("company_is_administrative_penalty between", value1, value2, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andCompanyIsAdministrativePenaltyNotBetween(Integer value1, Integer value2) {
            addCriterion("company_is_administrative_penalty not between", value1, value2, "companyIsAdministrativePenalty");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardIsNull() {
            addCriterion("file_is_upload_corporation_card is null");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardIsNotNull() {
            addCriterion("file_is_upload_corporation_card is not null");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardEqualTo(Integer value) {
            addCriterion("file_is_upload_corporation_card =", value, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardNotEqualTo(Integer value) {
            addCriterion("file_is_upload_corporation_card <>", value, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardGreaterThan(Integer value) {
            addCriterion("file_is_upload_corporation_card >", value, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_is_upload_corporation_card >=", value, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardLessThan(Integer value) {
            addCriterion("file_is_upload_corporation_card <", value, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardLessThanOrEqualTo(Integer value) {
            addCriterion("file_is_upload_corporation_card <=", value, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardIn(List<Integer> values) {
            addCriterion("file_is_upload_corporation_card in", values, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardNotIn(List<Integer> values) {
            addCriterion("file_is_upload_corporation_card not in", values, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardBetween(Integer value1, Integer value2) {
            addCriterion("file_is_upload_corporation_card between", value1, value2, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCorporationCardNotBetween(Integer value1, Integer value2) {
            addCriterion("file_is_upload_corporation_card not between", value1, value2, "fileIsUploadCorporationCard");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementIsNull() {
            addCriterion("file_is_upload_finance_statement is null");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementIsNotNull() {
            addCriterion("file_is_upload_finance_statement is not null");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementEqualTo(Integer value) {
            addCriterion("file_is_upload_finance_statement =", value, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementNotEqualTo(Integer value) {
            addCriterion("file_is_upload_finance_statement <>", value, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementGreaterThan(Integer value) {
            addCriterion("file_is_upload_finance_statement >", value, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_is_upload_finance_statement >=", value, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementLessThan(Integer value) {
            addCriterion("file_is_upload_finance_statement <", value, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementLessThanOrEqualTo(Integer value) {
            addCriterion("file_is_upload_finance_statement <=", value, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementIn(List<Integer> values) {
            addCriterion("file_is_upload_finance_statement in", values, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementNotIn(List<Integer> values) {
            addCriterion("file_is_upload_finance_statement not in", values, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementBetween(Integer value1, Integer value2) {
            addCriterion("file_is_upload_finance_statement between", value1, value2, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadFinanceStatementNotBetween(Integer value1, Integer value2) {
            addCriterion("file_is_upload_finance_statement not between", value1, value2, "fileIsUploadFinanceStatement");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterIsNull() {
            addCriterion("file_is_upload_guarantee_letter is null");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterIsNotNull() {
            addCriterion("file_is_upload_guarantee_letter is not null");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterEqualTo(Integer value) {
            addCriterion("file_is_upload_guarantee_letter =", value, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterNotEqualTo(Integer value) {
            addCriterion("file_is_upload_guarantee_letter <>", value, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterGreaterThan(Integer value) {
            addCriterion("file_is_upload_guarantee_letter >", value, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_is_upload_guarantee_letter >=", value, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterLessThan(Integer value) {
            addCriterion("file_is_upload_guarantee_letter <", value, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterLessThanOrEqualTo(Integer value) {
            addCriterion("file_is_upload_guarantee_letter <=", value, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterIn(List<Integer> values) {
            addCriterion("file_is_upload_guarantee_letter in", values, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterNotIn(List<Integer> values) {
            addCriterion("file_is_upload_guarantee_letter not in", values, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterBetween(Integer value1, Integer value2) {
            addCriterion("file_is_upload_guarantee_letter between", value1, value2, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadGuaranteeLetterNotBetween(Integer value1, Integer value2) {
            addCriterion("file_is_upload_guarantee_letter not between", value1, value2, "fileIsUploadGuaranteeLetter");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportIsNull() {
            addCriterion("file_is_upload_credit_report is null");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportIsNotNull() {
            addCriterion("file_is_upload_credit_report is not null");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportEqualTo(Integer value) {
            addCriterion("file_is_upload_credit_report =", value, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportNotEqualTo(Integer value) {
            addCriterion("file_is_upload_credit_report <>", value, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportGreaterThan(Integer value) {
            addCriterion("file_is_upload_credit_report >", value, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_is_upload_credit_report >=", value, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportLessThan(Integer value) {
            addCriterion("file_is_upload_credit_report <", value, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportLessThanOrEqualTo(Integer value) {
            addCriterion("file_is_upload_credit_report <=", value, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportIn(List<Integer> values) {
            addCriterion("file_is_upload_credit_report in", values, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportNotIn(List<Integer> values) {
            addCriterion("file_is_upload_credit_report not in", values, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportBetween(Integer value1, Integer value2) {
            addCriterion("file_is_upload_credit_report between", value1, value2, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileIsUploadCreditReportNotBetween(Integer value1, Integer value2) {
            addCriterion("file_is_upload_credit_report not between", value1, value2, "fileIsUploadCreditReport");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachIsNull() {
            addCriterion("file_finance_attach is null");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachIsNotNull() {
            addCriterion("file_finance_attach is not null");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachEqualTo(String value) {
            addCriterion("file_finance_attach =", value, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachNotEqualTo(String value) {
            addCriterion("file_finance_attach <>", value, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachGreaterThan(String value) {
            addCriterion("file_finance_attach >", value, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachGreaterThanOrEqualTo(String value) {
            addCriterion("file_finance_attach >=", value, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachLessThan(String value) {
            addCriterion("file_finance_attach <", value, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachLessThanOrEqualTo(String value) {
            addCriterion("file_finance_attach <=", value, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachLike(String value) {
            addCriterion("file_finance_attach like", value, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachNotLike(String value) {
            addCriterion("file_finance_attach not like", value, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachIn(List<String> values) {
            addCriterion("file_finance_attach in", values, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachNotIn(List<String> values) {
            addCriterion("file_finance_attach not in", values, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachBetween(String value1, String value2) {
            addCriterion("file_finance_attach between", value1, value2, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileFinanceAttachNotBetween(String value1, String value2) {
            addCriterion("file_finance_attach not between", value1, value2, "fileFinanceAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachIsNull() {
            addCriterion("file_guarantee_attach is null");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachIsNotNull() {
            addCriterion("file_guarantee_attach is not null");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachEqualTo(String value) {
            addCriterion("file_guarantee_attach =", value, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachNotEqualTo(String value) {
            addCriterion("file_guarantee_attach <>", value, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachGreaterThan(String value) {
            addCriterion("file_guarantee_attach >", value, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachGreaterThanOrEqualTo(String value) {
            addCriterion("file_guarantee_attach >=", value, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachLessThan(String value) {
            addCriterion("file_guarantee_attach <", value, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachLessThanOrEqualTo(String value) {
            addCriterion("file_guarantee_attach <=", value, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachLike(String value) {
            addCriterion("file_guarantee_attach like", value, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachNotLike(String value) {
            addCriterion("file_guarantee_attach not like", value, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachIn(List<String> values) {
            addCriterion("file_guarantee_attach in", values, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachNotIn(List<String> values) {
            addCriterion("file_guarantee_attach not in", values, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachBetween(String value1, String value2) {
            addCriterion("file_guarantee_attach between", value1, value2, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileGuaranteeAttachNotBetween(String value1, String value2) {
            addCriterion("file_guarantee_attach not between", value1, value2, "fileGuaranteeAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachIsNull() {
            addCriterion("file_credit_attach is null");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachIsNotNull() {
            addCriterion("file_credit_attach is not null");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachEqualTo(String value) {
            addCriterion("file_credit_attach =", value, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachNotEqualTo(String value) {
            addCriterion("file_credit_attach <>", value, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachGreaterThan(String value) {
            addCriterion("file_credit_attach >", value, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachGreaterThanOrEqualTo(String value) {
            addCriterion("file_credit_attach >=", value, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachLessThan(String value) {
            addCriterion("file_credit_attach <", value, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachLessThanOrEqualTo(String value) {
            addCriterion("file_credit_attach <=", value, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachLike(String value) {
            addCriterion("file_credit_attach like", value, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachNotLike(String value) {
            addCriterion("file_credit_attach not like", value, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachIn(List<String> values) {
            addCriterion("file_credit_attach in", values, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachNotIn(List<String> values) {
            addCriterion("file_credit_attach not in", values, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachBetween(String value1, String value2) {
            addCriterion("file_credit_attach between", value1, value2, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andFileCreditAttachNotBetween(String value1, String value2) {
            addCriterion("file_credit_attach not between", value1, value2, "fileCreditAttach");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdIsNull() {
            addCriterion("goods_order_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdIsNotNull() {
            addCriterion("goods_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdEqualTo(String value) {
            addCriterion("goods_order_id =", value, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdNotEqualTo(String value) {
            addCriterion("goods_order_id <>", value, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdGreaterThan(String value) {
            addCriterion("goods_order_id >", value, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_order_id >=", value, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdLessThan(String value) {
            addCriterion("goods_order_id <", value, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdLessThanOrEqualTo(String value) {
            addCriterion("goods_order_id <=", value, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdLike(String value) {
            addCriterion("goods_order_id like", value, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdNotLike(String value) {
            addCriterion("goods_order_id not like", value, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdIn(List<String> values) {
            addCriterion("goods_order_id in", values, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdNotIn(List<String> values) {
            addCriterion("goods_order_id not in", values, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdBetween(String value1, String value2) {
            addCriterion("goods_order_id between", value1, value2, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsOrderIdNotBetween(String value1, String value2) {
            addCriterion("goods_order_id not between", value1, value2, "goodsOrderId");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseIsNull() {
            addCriterion("goods_warehouse is null");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseIsNotNull() {
            addCriterion("goods_warehouse is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseEqualTo(String value) {
            addCriterion("goods_warehouse =", value, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseNotEqualTo(String value) {
            addCriterion("goods_warehouse <>", value, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseGreaterThan(String value) {
            addCriterion("goods_warehouse >", value, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseGreaterThanOrEqualTo(String value) {
            addCriterion("goods_warehouse >=", value, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseLessThan(String value) {
            addCriterion("goods_warehouse <", value, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseLessThanOrEqualTo(String value) {
            addCriterion("goods_warehouse <=", value, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseLike(String value) {
            addCriterion("goods_warehouse like", value, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseNotLike(String value) {
            addCriterion("goods_warehouse not like", value, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseIn(List<String> values) {
            addCriterion("goods_warehouse in", values, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseNotIn(List<String> values) {
            addCriterion("goods_warehouse not in", values, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseBetween(String value1, String value2) {
            addCriterion("goods_warehouse between", value1, value2, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsWarehouseNotBetween(String value1, String value2) {
            addCriterion("goods_warehouse not between", value1, value2, "goodsWarehouse");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateIsNull() {
            addCriterion("goods_collect_goods_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateIsNotNull() {
            addCriterion("goods_collect_goods_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateEqualTo(Date value) {
            addCriterionForJDBCDate("goods_collect_goods_date =", value, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("goods_collect_goods_date <>", value, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateGreaterThan(Date value) {
            addCriterionForJDBCDate("goods_collect_goods_date >", value, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_collect_goods_date >=", value, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateLessThan(Date value) {
            addCriterionForJDBCDate("goods_collect_goods_date <", value, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_collect_goods_date <=", value, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateIn(List<Date> values) {
            addCriterionForJDBCDate("goods_collect_goods_date in", values, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("goods_collect_goods_date not in", values, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_collect_goods_date between", value1, value2, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsCollectGoodsDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_collect_goods_date not between", value1, value2, "goodsCollectGoodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperIsNull() {
            addCriterion("goods_godown_keeper is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperIsNotNull() {
            addCriterion("goods_godown_keeper is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperEqualTo(String value) {
            addCriterion("goods_godown_keeper =", value, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperNotEqualTo(String value) {
            addCriterion("goods_godown_keeper <>", value, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperGreaterThan(String value) {
            addCriterion("goods_godown_keeper >", value, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperGreaterThanOrEqualTo(String value) {
            addCriterion("goods_godown_keeper >=", value, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperLessThan(String value) {
            addCriterion("goods_godown_keeper <", value, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperLessThanOrEqualTo(String value) {
            addCriterion("goods_godown_keeper <=", value, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperLike(String value) {
            addCriterion("goods_godown_keeper like", value, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperNotLike(String value) {
            addCriterion("goods_godown_keeper not like", value, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperIn(List<String> values) {
            addCriterion("goods_godown_keeper in", values, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperNotIn(List<String> values) {
            addCriterion("goods_godown_keeper not in", values, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperBetween(String value1, String value2) {
            addCriterion("goods_godown_keeper between", value1, value2, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsGodownKeeperNotBetween(String value1, String value2) {
            addCriterion("goods_godown_keeper not between", value1, value2, "goodsGodownKeeper");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameIsNull() {
            addCriterion("goods_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameIsNotNull() {
            addCriterion("goods_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameEqualTo(String value) {
            addCriterion("goods_contact_name =", value, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameNotEqualTo(String value) {
            addCriterion("goods_contact_name <>", value, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameGreaterThan(String value) {
            addCriterion("goods_contact_name >", value, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_contact_name >=", value, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameLessThan(String value) {
            addCriterion("goods_contact_name <", value, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameLessThanOrEqualTo(String value) {
            addCriterion("goods_contact_name <=", value, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameLike(String value) {
            addCriterion("goods_contact_name like", value, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameNotLike(String value) {
            addCriterion("goods_contact_name not like", value, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameIn(List<String> values) {
            addCriterion("goods_contact_name in", values, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameNotIn(List<String> values) {
            addCriterion("goods_contact_name not in", values, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameBetween(String value1, String value2) {
            addCriterion("goods_contact_name between", value1, value2, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactNameNotBetween(String value1, String value2) {
            addCriterion("goods_contact_name not between", value1, value2, "goodsContactName");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileIsNull() {
            addCriterion("goods_contact_mobile is null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileIsNotNull() {
            addCriterion("goods_contact_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileEqualTo(String value) {
            addCriterion("goods_contact_mobile =", value, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileNotEqualTo(String value) {
            addCriterion("goods_contact_mobile <>", value, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileGreaterThan(String value) {
            addCriterion("goods_contact_mobile >", value, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileGreaterThanOrEqualTo(String value) {
            addCriterion("goods_contact_mobile >=", value, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileLessThan(String value) {
            addCriterion("goods_contact_mobile <", value, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileLessThanOrEqualTo(String value) {
            addCriterion("goods_contact_mobile <=", value, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileLike(String value) {
            addCriterion("goods_contact_mobile like", value, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileNotLike(String value) {
            addCriterion("goods_contact_mobile not like", value, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileIn(List<String> values) {
            addCriterion("goods_contact_mobile in", values, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileNotIn(List<String> values) {
            addCriterion("goods_contact_mobile not in", values, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileBetween(String value1, String value2) {
            addCriterion("goods_contact_mobile between", value1, value2, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsContactMobileNotBetween(String value1, String value2) {
            addCriterion("goods_contact_mobile not between", value1, value2, "goodsContactMobile");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberIsNull() {
            addCriterion("goods_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberIsNotNull() {
            addCriterion("goods_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberEqualTo(String value) {
            addCriterion("goods_serial_number =", value, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberNotEqualTo(String value) {
            addCriterion("goods_serial_number <>", value, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberGreaterThan(String value) {
            addCriterion("goods_serial_number >", value, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("goods_serial_number >=", value, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberLessThan(String value) {
            addCriterion("goods_serial_number <", value, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("goods_serial_number <=", value, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberLike(String value) {
            addCriterion("goods_serial_number like", value, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberNotLike(String value) {
            addCriterion("goods_serial_number not like", value, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberIn(List<String> values) {
            addCriterion("goods_serial_number in", values, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberNotIn(List<String> values) {
            addCriterion("goods_serial_number not in", values, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberBetween(String value1, String value2) {
            addCriterion("goods_serial_number between", value1, value2, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsSerialNumberNotBetween(String value1, String value2) {
            addCriterion("goods_serial_number not between", value1, value2, "goodsSerialNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIsNull() {
            addCriterion("goods_category is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIsNotNull() {
            addCriterion("goods_category is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryEqualTo(String value) {
            addCriterion("goods_category =", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNotEqualTo(String value) {
            addCriterion("goods_category <>", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryGreaterThan(String value) {
            addCriterion("goods_category >", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("goods_category >=", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryLessThan(String value) {
            addCriterion("goods_category <", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryLessThanOrEqualTo(String value) {
            addCriterion("goods_category <=", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryLike(String value) {
            addCriterion("goods_category like", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNotLike(String value) {
            addCriterion("goods_category not like", value, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIn(List<String> values) {
            addCriterion("goods_category in", values, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNotIn(List<String> values) {
            addCriterion("goods_category not in", values, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryBetween(String value1, String value2) {
            addCriterion("goods_category between", value1, value2, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNotBetween(String value1, String value2) {
            addCriterion("goods_category not between", value1, value2, "goodsCategory");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIsNull() {
            addCriterion("goods_brand is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIsNotNull() {
            addCriterion("goods_brand is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandEqualTo(String value) {
            addCriterion("goods_brand =", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotEqualTo(String value) {
            addCriterion("goods_brand <>", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandGreaterThan(String value) {
            addCriterion("goods_brand >", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandGreaterThanOrEqualTo(String value) {
            addCriterion("goods_brand >=", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandLessThan(String value) {
            addCriterion("goods_brand <", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandLessThanOrEqualTo(String value) {
            addCriterion("goods_brand <=", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandLike(String value) {
            addCriterion("goods_brand like", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotLike(String value) {
            addCriterion("goods_brand not like", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIn(List<String> values) {
            addCriterion("goods_brand in", values, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotIn(List<String> values) {
            addCriterion("goods_brand not in", values, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandBetween(String value1, String value2) {
            addCriterion("goods_brand between", value1, value2, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotBetween(String value1, String value2) {
            addCriterion("goods_brand not between", value1, value2, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsIsNull() {
            addCriterion("goods_specifications is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsIsNotNull() {
            addCriterion("goods_specifications is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsEqualTo(String value) {
            addCriterion("goods_specifications =", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsNotEqualTo(String value) {
            addCriterion("goods_specifications <>", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsGreaterThan(String value) {
            addCriterion("goods_specifications >", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("goods_specifications >=", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsLessThan(String value) {
            addCriterion("goods_specifications <", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("goods_specifications <=", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsLike(String value) {
            addCriterion("goods_specifications like", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsNotLike(String value) {
            addCriterion("goods_specifications not like", value, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsIn(List<String> values) {
            addCriterion("goods_specifications in", values, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsNotIn(List<String> values) {
            addCriterion("goods_specifications not in", values, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsBetween(String value1, String value2) {
            addCriterion("goods_specifications between", value1, value2, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecificationsNotBetween(String value1, String value2) {
            addCriterion("goods_specifications not between", value1, value2, "goodsSpecifications");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIsNull() {
            addCriterion("goods_model is null");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIsNotNull() {
            addCriterion("goods_model is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsModelEqualTo(String value) {
            addCriterion("goods_model =", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotEqualTo(String value) {
            addCriterion("goods_model <>", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelGreaterThan(String value) {
            addCriterion("goods_model >", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelGreaterThanOrEqualTo(String value) {
            addCriterion("goods_model >=", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLessThan(String value) {
            addCriterion("goods_model <", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLessThanOrEqualTo(String value) {
            addCriterion("goods_model <=", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelLike(String value) {
            addCriterion("goods_model like", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotLike(String value) {
            addCriterion("goods_model not like", value, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelIn(List<String> values) {
            addCriterion("goods_model in", values, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotIn(List<String> values) {
            addCriterion("goods_model not in", values, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelBetween(String value1, String value2) {
            addCriterion("goods_model between", value1, value2, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsModelNotBetween(String value1, String value2) {
            addCriterion("goods_model not between", value1, value2, "goodsModel");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeIsNull() {
            addCriterion("goods_bar_code is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeIsNotNull() {
            addCriterion("goods_bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeEqualTo(String value) {
            addCriterion("goods_bar_code =", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeNotEqualTo(String value) {
            addCriterion("goods_bar_code <>", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeGreaterThan(String value) {
            addCriterion("goods_bar_code >", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_bar_code >=", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeLessThan(String value) {
            addCriterion("goods_bar_code <", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeLessThanOrEqualTo(String value) {
            addCriterion("goods_bar_code <=", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeLike(String value) {
            addCriterion("goods_bar_code like", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeNotLike(String value) {
            addCriterion("goods_bar_code not like", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeIn(List<String> values) {
            addCriterion("goods_bar_code in", values, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeNotIn(List<String> values) {
            addCriterion("goods_bar_code not in", values, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeBetween(String value1, String value2) {
            addCriterion("goods_bar_code between", value1, value2, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeNotBetween(String value1, String value2) {
            addCriterion("goods_bar_code not between", value1, value2, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
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

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
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