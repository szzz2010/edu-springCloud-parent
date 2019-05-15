package com.haohao.modelAndExample;

import java.util.ArrayList;
import java.util.List;

public class LoanBankCardInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public LoanBankCardInfoExample() {
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

        public Criteria andDebtorIsNull() {
            addCriterion("debtor is null");
            return (Criteria) this;
        }

        public Criteria andDebtorIsNotNull() {
            addCriterion("debtor is not null");
            return (Criteria) this;
        }

        public Criteria andDebtorEqualTo(String value) {
            addCriterion("debtor =", value, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorNotEqualTo(String value) {
            addCriterion("debtor <>", value, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorGreaterThan(String value) {
            addCriterion("debtor >", value, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorGreaterThanOrEqualTo(String value) {
            addCriterion("debtor >=", value, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorLessThan(String value) {
            addCriterion("debtor <", value, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorLessThanOrEqualTo(String value) {
            addCriterion("debtor <=", value, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorLike(String value) {
            addCriterion("debtor like", value, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorNotLike(String value) {
            addCriterion("debtor not like", value, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorIn(List<String> values) {
            addCriterion("debtor in", values, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorNotIn(List<String> values) {
            addCriterion("debtor not in", values, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorBetween(String value1, String value2) {
            addCriterion("debtor between", value1, value2, "debtor");
            return (Criteria) this;
        }

        public Criteria andDebtorNotBetween(String value1, String value2) {
            addCriterion("debtor not between", value1, value2, "debtor");
            return (Criteria) this;
        }

        public Criteria andLoanBankIsNull() {
            addCriterion("loan_bank is null");
            return (Criteria) this;
        }

        public Criteria andLoanBankIsNotNull() {
            addCriterion("loan_bank is not null");
            return (Criteria) this;
        }

        public Criteria andLoanBankEqualTo(String value) {
            addCriterion("loan_bank =", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNotEqualTo(String value) {
            addCriterion("loan_bank <>", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankGreaterThan(String value) {
            addCriterion("loan_bank >", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankGreaterThanOrEqualTo(String value) {
            addCriterion("loan_bank >=", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankLessThan(String value) {
            addCriterion("loan_bank <", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankLessThanOrEqualTo(String value) {
            addCriterion("loan_bank <=", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankLike(String value) {
            addCriterion("loan_bank like", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNotLike(String value) {
            addCriterion("loan_bank not like", value, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankIn(List<String> values) {
            addCriterion("loan_bank in", values, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNotIn(List<String> values) {
            addCriterion("loan_bank not in", values, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankBetween(String value1, String value2) {
            addCriterion("loan_bank between", value1, value2, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNotBetween(String value1, String value2) {
            addCriterion("loan_bank not between", value1, value2, "loanBank");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumIsNull() {
            addCriterion("loan_bank_num is null");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumIsNotNull() {
            addCriterion("loan_bank_num is not null");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumEqualTo(String value) {
            addCriterion("loan_bank_num =", value, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumNotEqualTo(String value) {
            addCriterion("loan_bank_num <>", value, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumGreaterThan(String value) {
            addCriterion("loan_bank_num >", value, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumGreaterThanOrEqualTo(String value) {
            addCriterion("loan_bank_num >=", value, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumLessThan(String value) {
            addCriterion("loan_bank_num <", value, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumLessThanOrEqualTo(String value) {
            addCriterion("loan_bank_num <=", value, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumLike(String value) {
            addCriterion("loan_bank_num like", value, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumNotLike(String value) {
            addCriterion("loan_bank_num not like", value, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumIn(List<String> values) {
            addCriterion("loan_bank_num in", values, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumNotIn(List<String> values) {
            addCriterion("loan_bank_num not in", values, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumBetween(String value1, String value2) {
            addCriterion("loan_bank_num between", value1, value2, "loanBankNum");
            return (Criteria) this;
        }

        public Criteria andLoanBankNumNotBetween(String value1, String value2) {
            addCriterion("loan_bank_num not between", value1, value2, "loanBankNum");
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

        public Criteria andBranchNameIsNull() {
            addCriterion("branch_name is null");
            return (Criteria) this;
        }

        public Criteria andBranchNameIsNotNull() {
            addCriterion("branch_name is not null");
            return (Criteria) this;
        }

        public Criteria andBranchNameEqualTo(String value) {
            addCriterion("branch_name =", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotEqualTo(String value) {
            addCriterion("branch_name <>", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameGreaterThan(String value) {
            addCriterion("branch_name >", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameGreaterThanOrEqualTo(String value) {
            addCriterion("branch_name >=", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLessThan(String value) {
            addCriterion("branch_name <", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLessThanOrEqualTo(String value) {
            addCriterion("branch_name <=", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLike(String value) {
            addCriterion("branch_name like", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotLike(String value) {
            addCriterion("branch_name not like", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameIn(List<String> values) {
            addCriterion("branch_name in", values, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotIn(List<String> values) {
            addCriterion("branch_name not in", values, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameBetween(String value1, String value2) {
            addCriterion("branch_name between", value1, value2, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotBetween(String value1, String value2) {
            addCriterion("branch_name not between", value1, value2, "branchName");
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