package com.haohao.modelAndExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public LoanOrderInfoExample() {
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

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNull() {
            addCriterion("contract_code is null");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNotNull() {
            addCriterion("contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andContractCodeEqualTo(String value) {
            addCriterion("contract_code =", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotEqualTo(String value) {
            addCriterion("contract_code <>", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThan(String value) {
            addCriterion("contract_code >", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_code >=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThan(String value) {
            addCriterion("contract_code <", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThanOrEqualTo(String value) {
            addCriterion("contract_code <=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLike(String value) {
            addCriterion("contract_code like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotLike(String value) {
            addCriterion("contract_code not like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeIn(List<String> values) {
            addCriterion("contract_code in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotIn(List<String> values) {
            addCriterion("contract_code not in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeBetween(String value1, String value2) {
            addCriterion("contract_code between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotBetween(String value1, String value2) {
            addCriterion("contract_code not between", value1, value2, "contractCode");
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

        public Criteria andContractAmtIsNull() {
            addCriterion("contract_amt is null");
            return (Criteria) this;
        }

        public Criteria andContractAmtIsNotNull() {
            addCriterion("contract_amt is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmtEqualTo(BigDecimal value) {
            addCriterion("contract_amt =", value, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtNotEqualTo(BigDecimal value) {
            addCriterion("contract_amt <>", value, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtGreaterThan(BigDecimal value) {
            addCriterion("contract_amt >", value, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amt >=", value, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtLessThan(BigDecimal value) {
            addCriterion("contract_amt <", value, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amt <=", value, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtIn(List<BigDecimal> values) {
            addCriterion("contract_amt in", values, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtNotIn(List<BigDecimal> values) {
            addCriterion("contract_amt not in", values, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amt between", value1, value2, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andContractAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amt not between", value1, value2, "contractAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtIsNull() {
            addCriterion("consult_amt is null");
            return (Criteria) this;
        }

        public Criteria andConsultAmtIsNotNull() {
            addCriterion("consult_amt is not null");
            return (Criteria) this;
        }

        public Criteria andConsultAmtEqualTo(BigDecimal value) {
            addCriterion("consult_amt =", value, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtNotEqualTo(BigDecimal value) {
            addCriterion("consult_amt <>", value, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtGreaterThan(BigDecimal value) {
            addCriterion("consult_amt >", value, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consult_amt >=", value, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtLessThan(BigDecimal value) {
            addCriterion("consult_amt <", value, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consult_amt <=", value, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtIn(List<BigDecimal> values) {
            addCriterion("consult_amt in", values, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtNotIn(List<BigDecimal> values) {
            addCriterion("consult_amt not in", values, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consult_amt between", value1, value2, "consultAmt");
            return (Criteria) this;
        }

        public Criteria andConsultAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consult_amt not between", value1, value2, "consultAmt");
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

        public Criteria andRiskAmtIsNull() {
            addCriterion("risk_amt is null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIsNotNull() {
            addCriterion("risk_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAmtEqualTo(BigDecimal value) {
            addCriterion("risk_amt =", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotEqualTo(BigDecimal value) {
            addCriterion("risk_amt <>", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThan(BigDecimal value) {
            addCriterion("risk_amt >", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("risk_amt >=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThan(BigDecimal value) {
            addCriterion("risk_amt <", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("risk_amt <=", value, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtIn(List<BigDecimal> values) {
            addCriterion("risk_amt in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotIn(List<BigDecimal> values) {
            addCriterion("risk_amt not in", values, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("risk_amt between", value1, value2, "riskAmt");
            return (Criteria) this;
        }

        public Criteria andRiskAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("risk_amt not between", value1, value2, "riskAmt");
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

        public Criteria andCreditDepositIsNull() {
            addCriterion("credit_deposit is null");
            return (Criteria) this;
        }

        public Criteria andCreditDepositIsNotNull() {
            addCriterion("credit_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditDepositEqualTo(BigDecimal value) {
            addCriterion("credit_deposit =", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositNotEqualTo(BigDecimal value) {
            addCriterion("credit_deposit <>", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositGreaterThan(BigDecimal value) {
            addCriterion("credit_deposit >", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_deposit >=", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositLessThan(BigDecimal value) {
            addCriterion("credit_deposit <", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_deposit <=", value, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositIn(List<BigDecimal> values) {
            addCriterion("credit_deposit in", values, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositNotIn(List<BigDecimal> values) {
            addCriterion("credit_deposit not in", values, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_deposit between", value1, value2, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andCreditDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_deposit not between", value1, value2, "creditDeposit");
            return (Criteria) this;
        }

        public Criteria andPremiumIsNull() {
            addCriterion("premium is null");
            return (Criteria) this;
        }

        public Criteria andPremiumIsNotNull() {
            addCriterion("premium is not null");
            return (Criteria) this;
        }

        public Criteria andPremiumEqualTo(BigDecimal value) {
            addCriterion("premium =", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotEqualTo(BigDecimal value) {
            addCriterion("premium <>", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumGreaterThan(BigDecimal value) {
            addCriterion("premium >", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("premium >=", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumLessThan(BigDecimal value) {
            addCriterion("premium <", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("premium <=", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumIn(List<BigDecimal> values) {
            addCriterion("premium in", values, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotIn(List<BigDecimal> values) {
            addCriterion("premium not in", values, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("premium between", value1, value2, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("premium not between", value1, value2, "premium");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
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

        public Criteria andLoanPurposeEqualTo(String value) {
            addCriterion("loan_purpose =", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeNotEqualTo(String value) {
            addCriterion("loan_purpose <>", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeGreaterThan(String value) {
            addCriterion("loan_purpose >", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_purpose >=", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeLessThan(String value) {
            addCriterion("loan_purpose <", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeLessThanOrEqualTo(String value) {
            addCriterion("loan_purpose <=", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeLike(String value) {
            addCriterion("loan_purpose like", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeNotLike(String value) {
            addCriterion("loan_purpose not like", value, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeIn(List<String> values) {
            addCriterion("loan_purpose in", values, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeNotIn(List<String> values) {
            addCriterion("loan_purpose not in", values, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeBetween(String value1, String value2) {
            addCriterion("loan_purpose between", value1, value2, "loanPurpose");
            return (Criteria) this;
        }

        public Criteria andLoanPurposeNotBetween(String value1, String value2) {
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

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andRiskStatusIsNull() {
            addCriterion("risk_status is null");
            return (Criteria) this;
        }

        public Criteria andRiskStatusIsNotNull() {
            addCriterion("risk_status is not null");
            return (Criteria) this;
        }

        public Criteria andRiskStatusEqualTo(Integer value) {
            addCriterion("risk_status =", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusNotEqualTo(Integer value) {
            addCriterion("risk_status <>", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusGreaterThan(Integer value) {
            addCriterion("risk_status >", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("risk_status >=", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusLessThan(Integer value) {
            addCriterion("risk_status <", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("risk_status <=", value, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusIn(List<Integer> values) {
            addCriterion("risk_status in", values, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusNotIn(List<Integer> values) {
            addCriterion("risk_status not in", values, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusBetween(Integer value1, Integer value2) {
            addCriterion("risk_status between", value1, value2, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("risk_status not between", value1, value2, "riskStatus");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNull() {
            addCriterion("risk_level is null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNotNull() {
            addCriterion("risk_level is not null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelEqualTo(String value) {
            addCriterion("risk_level =", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotEqualTo(String value) {
            addCriterion("risk_level <>", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThan(String value) {
            addCriterion("risk_level >", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThanOrEqualTo(String value) {
            addCriterion("risk_level >=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThan(String value) {
            addCriterion("risk_level <", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThanOrEqualTo(String value) {
            addCriterion("risk_level <=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLike(String value) {
            addCriterion("risk_level like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotLike(String value) {
            addCriterion("risk_level not like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIn(List<String> values) {
            addCriterion("risk_level in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotIn(List<String> values) {
            addCriterion("risk_level not in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelBetween(String value1, String value2) {
            addCriterion("risk_level between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotBetween(String value1, String value2) {
            addCriterion("risk_level not between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusIsNull() {
            addCriterion("xs_entry_status is null");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusIsNotNull() {
            addCriterion("xs_entry_status is not null");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusEqualTo(Integer value) {
            addCriterion("xs_entry_status =", value, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusNotEqualTo(Integer value) {
            addCriterion("xs_entry_status <>", value, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusGreaterThan(Integer value) {
            addCriterion("xs_entry_status >", value, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("xs_entry_status >=", value, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusLessThan(Integer value) {
            addCriterion("xs_entry_status <", value, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusLessThanOrEqualTo(Integer value) {
            addCriterion("xs_entry_status <=", value, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusIn(List<Integer> values) {
            addCriterion("xs_entry_status in", values, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusNotIn(List<Integer> values) {
            addCriterion("xs_entry_status not in", values, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusBetween(Integer value1, Integer value2) {
            addCriterion("xs_entry_status between", value1, value2, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsEntryStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("xs_entry_status not between", value1, value2, "xsEntryStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusIsNull() {
            addCriterion("xs_pay_status is null");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusIsNotNull() {
            addCriterion("xs_pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusEqualTo(Integer value) {
            addCriterion("xs_pay_status =", value, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusNotEqualTo(Integer value) {
            addCriterion("xs_pay_status <>", value, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusGreaterThan(Integer value) {
            addCriterion("xs_pay_status >", value, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("xs_pay_status >=", value, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusLessThan(Integer value) {
            addCriterion("xs_pay_status <", value, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("xs_pay_status <=", value, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusIn(List<Integer> values) {
            addCriterion("xs_pay_status in", values, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusNotIn(List<Integer> values) {
            addCriterion("xs_pay_status not in", values, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("xs_pay_status between", value1, value2, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("xs_pay_status not between", value1, value2, "xsPayStatus");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeIsNull() {
            addCriterion("xs_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeIsNotNull() {
            addCriterion("xs_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeEqualTo(Long value) {
            addCriterion("xs_pay_time =", value, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeNotEqualTo(Long value) {
            addCriterion("xs_pay_time <>", value, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeGreaterThan(Long value) {
            addCriterion("xs_pay_time >", value, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("xs_pay_time >=", value, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeLessThan(Long value) {
            addCriterion("xs_pay_time <", value, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeLessThanOrEqualTo(Long value) {
            addCriterion("xs_pay_time <=", value, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeIn(List<Long> values) {
            addCriterion("xs_pay_time in", values, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeNotIn(List<Long> values) {
            addCriterion("xs_pay_time not in", values, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeBetween(Long value1, Long value2) {
            addCriterion("xs_pay_time between", value1, value2, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andXsPayTimeNotBetween(Long value1, Long value2) {
            addCriterion("xs_pay_time not between", value1, value2, "xsPayTime");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateIsNull() {
            addCriterion("borrow_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateIsNotNull() {
            addCriterion("borrow_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateEqualTo(String value) {
            addCriterion("borrow_apply_date =", value, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateNotEqualTo(String value) {
            addCriterion("borrow_apply_date <>", value, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateGreaterThan(String value) {
            addCriterion("borrow_apply_date >", value, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_apply_date >=", value, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateLessThan(String value) {
            addCriterion("borrow_apply_date <", value, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateLessThanOrEqualTo(String value) {
            addCriterion("borrow_apply_date <=", value, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateLike(String value) {
            addCriterion("borrow_apply_date like", value, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateNotLike(String value) {
            addCriterion("borrow_apply_date not like", value, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateIn(List<String> values) {
            addCriterion("borrow_apply_date in", values, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateNotIn(List<String> values) {
            addCriterion("borrow_apply_date not in", values, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateBetween(String value1, String value2) {
            addCriterion("borrow_apply_date between", value1, value2, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andBorrowApplyDateNotBetween(String value1, String value2) {
            addCriterion("borrow_apply_date not between", value1, value2, "borrowApplyDate");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIsNull() {
            addCriterion("repay_source is null");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIsNotNull() {
            addCriterion("repay_source is not null");
            return (Criteria) this;
        }

        public Criteria andRepaySourceEqualTo(String value) {
            addCriterion("repay_source =", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotEqualTo(String value) {
            addCriterion("repay_source <>", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceGreaterThan(String value) {
            addCriterion("repay_source >", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceGreaterThanOrEqualTo(String value) {
            addCriterion("repay_source >=", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLessThan(String value) {
            addCriterion("repay_source <", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLessThanOrEqualTo(String value) {
            addCriterion("repay_source <=", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLike(String value) {
            addCriterion("repay_source like", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotLike(String value) {
            addCriterion("repay_source not like", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIn(List<String> values) {
            addCriterion("repay_source in", values, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotIn(List<String> values) {
            addCriterion("repay_source not in", values, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceBetween(String value1, String value2) {
            addCriterion("repay_source between", value1, value2, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotBetween(String value1, String value2) {
            addCriterion("repay_source not between", value1, value2, "repaySource");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyIsNull() {
            addCriterion("subject_property is null");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyIsNotNull() {
            addCriterion("subject_property is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyEqualTo(String value) {
            addCriterion("subject_property =", value, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyNotEqualTo(String value) {
            addCriterion("subject_property <>", value, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyGreaterThan(String value) {
            addCriterion("subject_property >", value, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("subject_property >=", value, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyLessThan(String value) {
            addCriterion("subject_property <", value, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyLessThanOrEqualTo(String value) {
            addCriterion("subject_property <=", value, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyLike(String value) {
            addCriterion("subject_property like", value, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyNotLike(String value) {
            addCriterion("subject_property not like", value, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyIn(List<String> values) {
            addCriterion("subject_property in", values, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyNotIn(List<String> values) {
            addCriterion("subject_property not in", values, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyBetween(String value1, String value2) {
            addCriterion("subject_property between", value1, value2, "subjectProperty");
            return (Criteria) this;
        }

        public Criteria andSubjectPropertyNotBetween(String value1, String value2) {
            addCriterion("subject_property not between", value1, value2, "subjectProperty");
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