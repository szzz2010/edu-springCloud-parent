package com.haohao.modelAndExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanUserCreditInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public LoanUserCreditInfoExample() {
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

        public Criteria andCreditCardNumsIsNull() {
            addCriterion("credit_card_nums is null");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsIsNotNull() {
            addCriterion("credit_card_nums is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsEqualTo(Integer value) {
            addCriterion("credit_card_nums =", value, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsNotEqualTo(Integer value) {
            addCriterion("credit_card_nums <>", value, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsGreaterThan(Integer value) {
            addCriterion("credit_card_nums >", value, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit_card_nums >=", value, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsLessThan(Integer value) {
            addCriterion("credit_card_nums <", value, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsLessThanOrEqualTo(Integer value) {
            addCriterion("credit_card_nums <=", value, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsIn(List<Integer> values) {
            addCriterion("credit_card_nums in", values, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsNotIn(List<Integer> values) {
            addCriterion("credit_card_nums not in", values, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsBetween(Integer value1, Integer value2) {
            addCriterion("credit_card_nums between", value1, value2, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andCreditCardNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("credit_card_nums not between", value1, value2, "creditCardNums");
            return (Criteria) this;
        }

        public Criteria andMaxLimitIsNull() {
            addCriterion("max_limit is null");
            return (Criteria) this;
        }

        public Criteria andMaxLimitIsNotNull() {
            addCriterion("max_limit is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLimitEqualTo(BigDecimal value) {
            addCriterion("max_limit =", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitNotEqualTo(BigDecimal value) {
            addCriterion("max_limit <>", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitGreaterThan(BigDecimal value) {
            addCriterion("max_limit >", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_limit >=", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitLessThan(BigDecimal value) {
            addCriterion("max_limit <", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_limit <=", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitIn(List<BigDecimal> values) {
            addCriterion("max_limit in", values, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitNotIn(List<BigDecimal> values) {
            addCriterion("max_limit not in", values, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_limit between", value1, value2, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_limit not between", value1, value2, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andPayEntireIsNull() {
            addCriterion("pay_entire is null");
            return (Criteria) this;
        }

        public Criteria andPayEntireIsNotNull() {
            addCriterion("pay_entire is not null");
            return (Criteria) this;
        }

        public Criteria andPayEntireEqualTo(String value) {
            addCriterion("pay_entire =", value, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireNotEqualTo(String value) {
            addCriterion("pay_entire <>", value, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireGreaterThan(String value) {
            addCriterion("pay_entire >", value, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireGreaterThanOrEqualTo(String value) {
            addCriterion("pay_entire >=", value, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireLessThan(String value) {
            addCriterion("pay_entire <", value, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireLessThanOrEqualTo(String value) {
            addCriterion("pay_entire <=", value, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireLike(String value) {
            addCriterion("pay_entire like", value, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireNotLike(String value) {
            addCriterion("pay_entire not like", value, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireIn(List<String> values) {
            addCriterion("pay_entire in", values, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireNotIn(List<String> values) {
            addCriterion("pay_entire not in", values, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireBetween(String value1, String value2) {
            addCriterion("pay_entire between", value1, value2, "payEntire");
            return (Criteria) this;
        }

        public Criteria andPayEntireNotBetween(String value1, String value2) {
            addCriterion("pay_entire not between", value1, value2, "payEntire");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighIsNull() {
            addCriterion("loanOVD_high is null");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighIsNotNull() {
            addCriterion("loanOVD_high is not null");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighEqualTo(Integer value) {
            addCriterion("loanOVD_high =", value, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighNotEqualTo(Integer value) {
            addCriterion("loanOVD_high <>", value, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighGreaterThan(Integer value) {
            addCriterion("loanOVD_high >", value, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighGreaterThanOrEqualTo(Integer value) {
            addCriterion("loanOVD_high >=", value, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighLessThan(Integer value) {
            addCriterion("loanOVD_high <", value, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighLessThanOrEqualTo(Integer value) {
            addCriterion("loanOVD_high <=", value, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighIn(List<Integer> values) {
            addCriterion("loanOVD_high in", values, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighNotIn(List<Integer> values) {
            addCriterion("loanOVD_high not in", values, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighBetween(Integer value1, Integer value2) {
            addCriterion("loanOVD_high between", value1, value2, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andLoanovdHighNotBetween(Integer value1, Integer value2) {
            addCriterion("loanOVD_high not between", value1, value2, "loanovdHigh");
            return (Criteria) this;
        }

        public Criteria andQueryTimesIsNull() {
            addCriterion("query_times is null");
            return (Criteria) this;
        }

        public Criteria andQueryTimesIsNotNull() {
            addCriterion("query_times is not null");
            return (Criteria) this;
        }

        public Criteria andQueryTimesEqualTo(Integer value) {
            addCriterion("query_times =", value, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesNotEqualTo(Integer value) {
            addCriterion("query_times <>", value, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesGreaterThan(Integer value) {
            addCriterion("query_times >", value, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("query_times >=", value, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesLessThan(Integer value) {
            addCriterion("query_times <", value, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesLessThanOrEqualTo(Integer value) {
            addCriterion("query_times <=", value, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesIn(List<Integer> values) {
            addCriterion("query_times in", values, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesNotIn(List<Integer> values) {
            addCriterion("query_times not in", values, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesBetween(Integer value1, Integer value2) {
            addCriterion("query_times between", value1, value2, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andQueryTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("query_times not between", value1, value2, "queryTimes");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankIsNull() {
            addCriterion("app_pboc_blank is null");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankIsNotNull() {
            addCriterion("app_pboc_blank is not null");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankEqualTo(String value) {
            addCriterion("app_pboc_blank =", value, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankNotEqualTo(String value) {
            addCriterion("app_pboc_blank <>", value, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankGreaterThan(String value) {
            addCriterion("app_pboc_blank >", value, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankGreaterThanOrEqualTo(String value) {
            addCriterion("app_pboc_blank >=", value, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankLessThan(String value) {
            addCriterion("app_pboc_blank <", value, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankLessThanOrEqualTo(String value) {
            addCriterion("app_pboc_blank <=", value, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankLike(String value) {
            addCriterion("app_pboc_blank like", value, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankNotLike(String value) {
            addCriterion("app_pboc_blank not like", value, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankIn(List<String> values) {
            addCriterion("app_pboc_blank in", values, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankNotIn(List<String> values) {
            addCriterion("app_pboc_blank not in", values, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankBetween(String value1, String value2) {
            addCriterion("app_pboc_blank between", value1, value2, "appPbocBlank");
            return (Criteria) this;
        }

        public Criteria andAppPbocBlankNotBetween(String value1, String value2) {
            addCriterion("app_pboc_blank not between", value1, value2, "appPbocBlank");
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