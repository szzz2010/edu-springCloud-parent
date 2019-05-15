package com.haohao.modelAndExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanUserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public LoanUserInfoExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNull() {
            addCriterion("id_card_no is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNotNull() {
            addCriterion("id_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoEqualTo(String value) {
            addCriterion("id_card_no =", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotEqualTo(String value) {
            addCriterion("id_card_no <>", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThan(String value) {
            addCriterion("id_card_no >", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_no >=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThan(String value) {
            addCriterion("id_card_no <", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThanOrEqualTo(String value) {
            addCriterion("id_card_no <=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLike(String value) {
            addCriterion("id_card_no like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotLike(String value) {
            addCriterion("id_card_no not like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIn(List<String> values) {
            addCriterion("id_card_no in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotIn(List<String> values) {
            addCriterion("id_card_no not in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoBetween(String value1, String value2) {
            addCriterion("id_card_no between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotBetween(String value1, String value2) {
            addCriterion("id_card_no not between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIsNull() {
            addCriterion("cell_phone is null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIsNotNull() {
            addCriterion("cell_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneEqualTo(String value) {
            addCriterion("cell_phone =", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotEqualTo(String value) {
            addCriterion("cell_phone <>", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneGreaterThan(String value) {
            addCriterion("cell_phone >", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cell_phone >=", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLessThan(String value) {
            addCriterion("cell_phone <", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLessThanOrEqualTo(String value) {
            addCriterion("cell_phone <=", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLike(String value) {
            addCriterion("cell_phone like", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotLike(String value) {
            addCriterion("cell_phone not like", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIn(List<String> values) {
            addCriterion("cell_phone in", values, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotIn(List<String> values) {
            addCriterion("cell_phone not in", values, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneBetween(String value1, String value2) {
            addCriterion("cell_phone between", value1, value2, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotBetween(String value1, String value2) {
            addCriterion("cell_phone not between", value1, value2, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andIdperiodIsNull() {
            addCriterion("idPeriod is null");
            return (Criteria) this;
        }

        public Criteria andIdperiodIsNotNull() {
            addCriterion("idPeriod is not null");
            return (Criteria) this;
        }

        public Criteria andIdperiodEqualTo(String value) {
            addCriterion("idPeriod =", value, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodNotEqualTo(String value) {
            addCriterion("idPeriod <>", value, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodGreaterThan(String value) {
            addCriterion("idPeriod >", value, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodGreaterThanOrEqualTo(String value) {
            addCriterion("idPeriod >=", value, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodLessThan(String value) {
            addCriterion("idPeriod <", value, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodLessThanOrEqualTo(String value) {
            addCriterion("idPeriod <=", value, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodLike(String value) {
            addCriterion("idPeriod like", value, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodNotLike(String value) {
            addCriterion("idPeriod not like", value, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodIn(List<String> values) {
            addCriterion("idPeriod in", values, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodNotIn(List<String> values) {
            addCriterion("idPeriod not in", values, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodBetween(String value1, String value2) {
            addCriterion("idPeriod between", value1, value2, "idperiod");
            return (Criteria) this;
        }

        public Criteria andIdperiodNotBetween(String value1, String value2) {
            addCriterion("idPeriod not between", value1, value2, "idperiod");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrIsNull() {
            addCriterion("home_town_addr is null");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrIsNotNull() {
            addCriterion("home_town_addr is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrEqualTo(String value) {
            addCriterion("home_town_addr =", value, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrNotEqualTo(String value) {
            addCriterion("home_town_addr <>", value, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrGreaterThan(String value) {
            addCriterion("home_town_addr >", value, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrGreaterThanOrEqualTo(String value) {
            addCriterion("home_town_addr >=", value, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrLessThan(String value) {
            addCriterion("home_town_addr <", value, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrLessThanOrEqualTo(String value) {
            addCriterion("home_town_addr <=", value, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrLike(String value) {
            addCriterion("home_town_addr like", value, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrNotLike(String value) {
            addCriterion("home_town_addr not like", value, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrIn(List<String> values) {
            addCriterion("home_town_addr in", values, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrNotIn(List<String> values) {
            addCriterion("home_town_addr not in", values, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrBetween(String value1, String value2) {
            addCriterion("home_town_addr between", value1, value2, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAddrNotBetween(String value1, String value2) {
            addCriterion("home_town_addr not between", value1, value2, "homeTownAddr");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationIsNull() {
            addCriterion("home_town_app_location is null");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationIsNotNull() {
            addCriterion("home_town_app_location is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationEqualTo(String value) {
            addCriterion("home_town_app_location =", value, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationNotEqualTo(String value) {
            addCriterion("home_town_app_location <>", value, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationGreaterThan(String value) {
            addCriterion("home_town_app_location >", value, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationGreaterThanOrEqualTo(String value) {
            addCriterion("home_town_app_location >=", value, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationLessThan(String value) {
            addCriterion("home_town_app_location <", value, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationLessThanOrEqualTo(String value) {
            addCriterion("home_town_app_location <=", value, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationLike(String value) {
            addCriterion("home_town_app_location like", value, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationNotLike(String value) {
            addCriterion("home_town_app_location not like", value, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationIn(List<String> values) {
            addCriterion("home_town_app_location in", values, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationNotIn(List<String> values) {
            addCriterion("home_town_app_location not in", values, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationBetween(String value1, String value2) {
            addCriterion("home_town_app_location between", value1, value2, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andHomeTownAppLocationNotBetween(String value1, String value2) {
            addCriterion("home_town_app_location not between", value1, value2, "homeTownAppLocation");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrIsNull() {
            addCriterion("communicate_addr is null");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrIsNotNull() {
            addCriterion("communicate_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrEqualTo(String value) {
            addCriterion("communicate_addr =", value, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrNotEqualTo(String value) {
            addCriterion("communicate_addr <>", value, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrGreaterThan(String value) {
            addCriterion("communicate_addr >", value, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrGreaterThanOrEqualTo(String value) {
            addCriterion("communicate_addr >=", value, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrLessThan(String value) {
            addCriterion("communicate_addr <", value, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrLessThanOrEqualTo(String value) {
            addCriterion("communicate_addr <=", value, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrLike(String value) {
            addCriterion("communicate_addr like", value, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrNotLike(String value) {
            addCriterion("communicate_addr not like", value, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrIn(List<String> values) {
            addCriterion("communicate_addr in", values, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrNotIn(List<String> values) {
            addCriterion("communicate_addr not in", values, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrBetween(String value1, String value2) {
            addCriterion("communicate_addr between", value1, value2, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andCommunicateAddrNotBetween(String value1, String value2) {
            addCriterion("communicate_addr not between", value1, value2, "communicateAddr");
            return (Criteria) this;
        }

        public Criteria andLocalYearsIsNull() {
            addCriterion("local_years is null");
            return (Criteria) this;
        }

        public Criteria andLocalYearsIsNotNull() {
            addCriterion("local_years is not null");
            return (Criteria) this;
        }

        public Criteria andLocalYearsEqualTo(String value) {
            addCriterion("local_years =", value, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsNotEqualTo(String value) {
            addCriterion("local_years <>", value, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsGreaterThan(String value) {
            addCriterion("local_years >", value, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsGreaterThanOrEqualTo(String value) {
            addCriterion("local_years >=", value, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsLessThan(String value) {
            addCriterion("local_years <", value, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsLessThanOrEqualTo(String value) {
            addCriterion("local_years <=", value, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsLike(String value) {
            addCriterion("local_years like", value, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsNotLike(String value) {
            addCriterion("local_years not like", value, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsIn(List<String> values) {
            addCriterion("local_years in", values, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsNotIn(List<String> values) {
            addCriterion("local_years not in", values, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsBetween(String value1, String value2) {
            addCriterion("local_years between", value1, value2, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalYearsNotBetween(String value1, String value2) {
            addCriterion("local_years not between", value1, value2, "localYears");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneIsNull() {
            addCriterion("local_phone is null");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneIsNotNull() {
            addCriterion("local_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneEqualTo(String value) {
            addCriterion("local_phone =", value, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneNotEqualTo(String value) {
            addCriterion("local_phone <>", value, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneGreaterThan(String value) {
            addCriterion("local_phone >", value, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("local_phone >=", value, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneLessThan(String value) {
            addCriterion("local_phone <", value, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneLessThanOrEqualTo(String value) {
            addCriterion("local_phone <=", value, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneLike(String value) {
            addCriterion("local_phone like", value, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneNotLike(String value) {
            addCriterion("local_phone not like", value, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneIn(List<String> values) {
            addCriterion("local_phone in", values, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneNotIn(List<String> values) {
            addCriterion("local_phone not in", values, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneBetween(String value1, String value2) {
            addCriterion("local_phone between", value1, value2, "localPhone");
            return (Criteria) this;
        }

        public Criteria andLocalPhoneNotBetween(String value1, String value2) {
            addCriterion("local_phone not between", value1, value2, "localPhone");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNull() {
            addCriterion("marriage is null");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNotNull() {
            addCriterion("marriage is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageEqualTo(String value) {
            addCriterion("marriage =", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotEqualTo(String value) {
            addCriterion("marriage <>", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThan(String value) {
            addCriterion("marriage >", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThanOrEqualTo(String value) {
            addCriterion("marriage >=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThan(String value) {
            addCriterion("marriage <", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThanOrEqualTo(String value) {
            addCriterion("marriage <=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLike(String value) {
            addCriterion("marriage like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotLike(String value) {
            addCriterion("marriage not like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageIn(List<String> values) {
            addCriterion("marriage in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotIn(List<String> values) {
            addCriterion("marriage not in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageBetween(String value1, String value2) {
            addCriterion("marriage between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotBetween(String value1, String value2) {
            addCriterion("marriage not between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andFamilySituationIsNull() {
            addCriterion("family_situation is null");
            return (Criteria) this;
        }

        public Criteria andFamilySituationIsNotNull() {
            addCriterion("family_situation is not null");
            return (Criteria) this;
        }

        public Criteria andFamilySituationEqualTo(String value) {
            addCriterion("family_situation =", value, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationNotEqualTo(String value) {
            addCriterion("family_situation <>", value, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationGreaterThan(String value) {
            addCriterion("family_situation >", value, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationGreaterThanOrEqualTo(String value) {
            addCriterion("family_situation >=", value, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationLessThan(String value) {
            addCriterion("family_situation <", value, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationLessThanOrEqualTo(String value) {
            addCriterion("family_situation <=", value, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationLike(String value) {
            addCriterion("family_situation like", value, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationNotLike(String value) {
            addCriterion("family_situation not like", value, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationIn(List<String> values) {
            addCriterion("family_situation in", values, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationNotIn(List<String> values) {
            addCriterion("family_situation not in", values, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationBetween(String value1, String value2) {
            addCriterion("family_situation between", value1, value2, "familySituation");
            return (Criteria) this;
        }

        public Criteria andFamilySituationNotBetween(String value1, String value2) {
            addCriterion("family_situation not between", value1, value2, "familySituation");
            return (Criteria) this;
        }

        public Criteria andAppCityIsNull() {
            addCriterion("app_city is null");
            return (Criteria) this;
        }

        public Criteria andAppCityIsNotNull() {
            addCriterion("app_city is not null");
            return (Criteria) this;
        }

        public Criteria andAppCityEqualTo(String value) {
            addCriterion("app_city =", value, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityNotEqualTo(String value) {
            addCriterion("app_city <>", value, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityGreaterThan(String value) {
            addCriterion("app_city >", value, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityGreaterThanOrEqualTo(String value) {
            addCriterion("app_city >=", value, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityLessThan(String value) {
            addCriterion("app_city <", value, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityLessThanOrEqualTo(String value) {
            addCriterion("app_city <=", value, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityLike(String value) {
            addCriterion("app_city like", value, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityNotLike(String value) {
            addCriterion("app_city not like", value, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityIn(List<String> values) {
            addCriterion("app_city in", values, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityNotIn(List<String> values) {
            addCriterion("app_city not in", values, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityBetween(String value1, String value2) {
            addCriterion("app_city between", value1, value2, "appCity");
            return (Criteria) this;
        }

        public Criteria andAppCityNotBetween(String value1, String value2) {
            addCriterion("app_city not between", value1, value2, "appCity");
            return (Criteria) this;
        }

        public Criteria andIsHasChildIsNull() {
            addCriterion("is_has_child is null");
            return (Criteria) this;
        }

        public Criteria andIsHasChildIsNotNull() {
            addCriterion("is_has_child is not null");
            return (Criteria) this;
        }

        public Criteria andIsHasChildEqualTo(String value) {
            addCriterion("is_has_child =", value, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildNotEqualTo(String value) {
            addCriterion("is_has_child <>", value, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildGreaterThan(String value) {
            addCriterion("is_has_child >", value, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildGreaterThanOrEqualTo(String value) {
            addCriterion("is_has_child >=", value, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildLessThan(String value) {
            addCriterion("is_has_child <", value, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildLessThanOrEqualTo(String value) {
            addCriterion("is_has_child <=", value, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildLike(String value) {
            addCriterion("is_has_child like", value, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildNotLike(String value) {
            addCriterion("is_has_child not like", value, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildIn(List<String> values) {
            addCriterion("is_has_child in", values, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildNotIn(List<String> values) {
            addCriterion("is_has_child not in", values, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildBetween(String value1, String value2) {
            addCriterion("is_has_child between", value1, value2, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andIsHasChildNotBetween(String value1, String value2) {
            addCriterion("is_has_child not between", value1, value2, "isHasChild");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNull() {
            addCriterion("sign_date is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(String value) {
            addCriterion("sign_date =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(String value) {
            addCriterion("sign_date <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(String value) {
            addCriterion("sign_date >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(String value) {
            addCriterion("sign_date >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(String value) {
            addCriterion("sign_date <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(String value) {
            addCriterion("sign_date <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLike(String value) {
            addCriterion("sign_date like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotLike(String value) {
            addCriterion("sign_date not like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<String> values) {
            addCriterion("sign_date in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<String> values) {
            addCriterion("sign_date not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(String value1, String value2) {
            addCriterion("sign_date between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(String value1, String value2) {
            addCriterion("sign_date not between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andApprDateIsNull() {
            addCriterion("appr_date is null");
            return (Criteria) this;
        }

        public Criteria andApprDateIsNotNull() {
            addCriterion("appr_date is not null");
            return (Criteria) this;
        }

        public Criteria andApprDateEqualTo(String value) {
            addCriterion("appr_date =", value, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateNotEqualTo(String value) {
            addCriterion("appr_date <>", value, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateGreaterThan(String value) {
            addCriterion("appr_date >", value, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateGreaterThanOrEqualTo(String value) {
            addCriterion("appr_date >=", value, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateLessThan(String value) {
            addCriterion("appr_date <", value, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateLessThanOrEqualTo(String value) {
            addCriterion("appr_date <=", value, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateLike(String value) {
            addCriterion("appr_date like", value, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateNotLike(String value) {
            addCriterion("appr_date not like", value, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateIn(List<String> values) {
            addCriterion("appr_date in", values, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateNotIn(List<String> values) {
            addCriterion("appr_date not in", values, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateBetween(String value1, String value2) {
            addCriterion("appr_date between", value1, value2, "apprDate");
            return (Criteria) this;
        }

        public Criteria andApprDateNotBetween(String value1, String value2) {
            addCriterion("appr_date not between", value1, value2, "apprDate");
            return (Criteria) this;
        }

        public Criteria andSubmitCityIsNull() {
            addCriterion("submit_city is null");
            return (Criteria) this;
        }

        public Criteria andSubmitCityIsNotNull() {
            addCriterion("submit_city is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitCityEqualTo(String value) {
            addCriterion("submit_city =", value, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityNotEqualTo(String value) {
            addCriterion("submit_city <>", value, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityGreaterThan(String value) {
            addCriterion("submit_city >", value, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityGreaterThanOrEqualTo(String value) {
            addCriterion("submit_city >=", value, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityLessThan(String value) {
            addCriterion("submit_city <", value, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityLessThanOrEqualTo(String value) {
            addCriterion("submit_city <=", value, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityLike(String value) {
            addCriterion("submit_city like", value, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityNotLike(String value) {
            addCriterion("submit_city not like", value, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityIn(List<String> values) {
            addCriterion("submit_city in", values, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityNotIn(List<String> values) {
            addCriterion("submit_city not in", values, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityBetween(String value1, String value2) {
            addCriterion("submit_city between", value1, value2, "submitCity");
            return (Criteria) this;
        }

        public Criteria andSubmitCityNotBetween(String value1, String value2) {
            addCriterion("submit_city not between", value1, value2, "submitCity");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownIsNull() {
            addCriterion("family_is_known is null");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownIsNotNull() {
            addCriterion("family_is_known is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownEqualTo(String value) {
            addCriterion("family_is_known =", value, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownNotEqualTo(String value) {
            addCriterion("family_is_known <>", value, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownGreaterThan(String value) {
            addCriterion("family_is_known >", value, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownGreaterThanOrEqualTo(String value) {
            addCriterion("family_is_known >=", value, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownLessThan(String value) {
            addCriterion("family_is_known <", value, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownLessThanOrEqualTo(String value) {
            addCriterion("family_is_known <=", value, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownLike(String value) {
            addCriterion("family_is_known like", value, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownNotLike(String value) {
            addCriterion("family_is_known not like", value, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownIn(List<String> values) {
            addCriterion("family_is_known in", values, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownNotIn(List<String> values) {
            addCriterion("family_is_known not in", values, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownBetween(String value1, String value2) {
            addCriterion("family_is_known between", value1, value2, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andFamilyIsKnownNotBetween(String value1, String value2) {
            addCriterion("family_is_known not between", value1, value2, "familyIsKnown");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentIsNull() {
            addCriterion("month_payment is null");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentIsNotNull() {
            addCriterion("month_payment is not null");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentEqualTo(BigDecimal value) {
            addCriterion("month_payment =", value, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentNotEqualTo(BigDecimal value) {
            addCriterion("month_payment <>", value, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentGreaterThan(BigDecimal value) {
            addCriterion("month_payment >", value, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_payment >=", value, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentLessThan(BigDecimal value) {
            addCriterion("month_payment <", value, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_payment <=", value, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentIn(List<BigDecimal> values) {
            addCriterion("month_payment in", values, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentNotIn(List<BigDecimal> values) {
            addCriterion("month_payment not in", values, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_payment between", value1, value2, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andMonthPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_payment not between", value1, value2, "monthPayment");
            return (Criteria) this;
        }

        public Criteria andHomePartnerIsNull() {
            addCriterion("home_partner is null");
            return (Criteria) this;
        }

        public Criteria andHomePartnerIsNotNull() {
            addCriterion("home_partner is not null");
            return (Criteria) this;
        }

        public Criteria andHomePartnerEqualTo(String value) {
            addCriterion("home_partner =", value, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerNotEqualTo(String value) {
            addCriterion("home_partner <>", value, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerGreaterThan(String value) {
            addCriterion("home_partner >", value, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerGreaterThanOrEqualTo(String value) {
            addCriterion("home_partner >=", value, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerLessThan(String value) {
            addCriterion("home_partner <", value, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerLessThanOrEqualTo(String value) {
            addCriterion("home_partner <=", value, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerLike(String value) {
            addCriterion("home_partner like", value, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerNotLike(String value) {
            addCriterion("home_partner not like", value, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerIn(List<String> values) {
            addCriterion("home_partner in", values, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerNotIn(List<String> values) {
            addCriterion("home_partner not in", values, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerBetween(String value1, String value2) {
            addCriterion("home_partner between", value1, value2, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomePartnerNotBetween(String value1, String value2) {
            addCriterion("home_partner not between", value1, value2, "homePartner");
            return (Criteria) this;
        }

        public Criteria andHomeTypeIsNull() {
            addCriterion("home_type is null");
            return (Criteria) this;
        }

        public Criteria andHomeTypeIsNotNull() {
            addCriterion("home_type is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTypeEqualTo(String value) {
            addCriterion("home_type =", value, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeNotEqualTo(String value) {
            addCriterion("home_type <>", value, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeGreaterThan(String value) {
            addCriterion("home_type >", value, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("home_type >=", value, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeLessThan(String value) {
            addCriterion("home_type <", value, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeLessThanOrEqualTo(String value) {
            addCriterion("home_type <=", value, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeLike(String value) {
            addCriterion("home_type like", value, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeNotLike(String value) {
            addCriterion("home_type not like", value, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeIn(List<String> values) {
            addCriterion("home_type in", values, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeNotIn(List<String> values) {
            addCriterion("home_type not in", values, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeBetween(String value1, String value2) {
            addCriterion("home_type between", value1, value2, "homeType");
            return (Criteria) this;
        }

        public Criteria andHomeTypeNotBetween(String value1, String value2) {
            addCriterion("home_type not between", value1, value2, "homeType");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeIsNull() {
            addCriterion("affirm_date_time is null");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeIsNotNull() {
            addCriterion("affirm_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeEqualTo(String value) {
            addCriterion("affirm_date_time =", value, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeNotEqualTo(String value) {
            addCriterion("affirm_date_time <>", value, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeGreaterThan(String value) {
            addCriterion("affirm_date_time >", value, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("affirm_date_time >=", value, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeLessThan(String value) {
            addCriterion("affirm_date_time <", value, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeLessThanOrEqualTo(String value) {
            addCriterion("affirm_date_time <=", value, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeLike(String value) {
            addCriterion("affirm_date_time like", value, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeNotLike(String value) {
            addCriterion("affirm_date_time not like", value, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeIn(List<String> values) {
            addCriterion("affirm_date_time in", values, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeNotIn(List<String> values) {
            addCriterion("affirm_date_time not in", values, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeBetween(String value1, String value2) {
            addCriterion("affirm_date_time between", value1, value2, "affirmDateTime");
            return (Criteria) this;
        }

        public Criteria andAffirmDateTimeNotBetween(String value1, String value2) {
            addCriterion("affirm_date_time not between", value1, value2, "affirmDateTime");
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