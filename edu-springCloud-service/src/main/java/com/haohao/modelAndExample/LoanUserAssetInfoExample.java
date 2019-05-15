package com.haohao.modelAndExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoanUserAssetInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected boolean page;

    protected int offset;

    protected int count;

    public LoanUserAssetInfoExample() {
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

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseAddrIsNull() {
            addCriterion("house_addr is null");
            return (Criteria) this;
        }

        public Criteria andHouseAddrIsNotNull() {
            addCriterion("house_addr is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAddrEqualTo(String value) {
            addCriterion("house_addr =", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrNotEqualTo(String value) {
            addCriterion("house_addr <>", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrGreaterThan(String value) {
            addCriterion("house_addr >", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrGreaterThanOrEqualTo(String value) {
            addCriterion("house_addr >=", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrLessThan(String value) {
            addCriterion("house_addr <", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrLessThanOrEqualTo(String value) {
            addCriterion("house_addr <=", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrLike(String value) {
            addCriterion("house_addr like", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrNotLike(String value) {
            addCriterion("house_addr not like", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrIn(List<String> values) {
            addCriterion("house_addr in", values, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrNotIn(List<String> values) {
            addCriterion("house_addr not in", values, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrBetween(String value1, String value2) {
            addCriterion("house_addr between", value1, value2, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrNotBetween(String value1, String value2) {
            addCriterion("house_addr not between", value1, value2, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumIsNull() {
            addCriterion("shared_people_num is null");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumIsNotNull() {
            addCriterion("shared_people_num is not null");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumEqualTo(String value) {
            addCriterion("shared_people_num =", value, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumNotEqualTo(String value) {
            addCriterion("shared_people_num <>", value, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumGreaterThan(String value) {
            addCriterion("shared_people_num >", value, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumGreaterThanOrEqualTo(String value) {
            addCriterion("shared_people_num >=", value, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumLessThan(String value) {
            addCriterion("shared_people_num <", value, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumLessThanOrEqualTo(String value) {
            addCriterion("shared_people_num <=", value, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumLike(String value) {
            addCriterion("shared_people_num like", value, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumNotLike(String value) {
            addCriterion("shared_people_num not like", value, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumIn(List<String> values) {
            addCriterion("shared_people_num in", values, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumNotIn(List<String> values) {
            addCriterion("shared_people_num not in", values, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumBetween(String value1, String value2) {
            addCriterion("shared_people_num between", value1, value2, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andSharedPeopleNumNotBetween(String value1, String value2) {
            addCriterion("shared_people_num not between", value1, value2, "sharedPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIsNull() {
            addCriterion("house_area is null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIsNotNull() {
            addCriterion("house_area is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaEqualTo(String value) {
            addCriterion("house_area =", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotEqualTo(String value) {
            addCriterion("house_area <>", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThan(String value) {
            addCriterion("house_area >", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThanOrEqualTo(String value) {
            addCriterion("house_area >=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThan(String value) {
            addCriterion("house_area <", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThanOrEqualTo(String value) {
            addCriterion("house_area <=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLike(String value) {
            addCriterion("house_area like", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotLike(String value) {
            addCriterion("house_area not like", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIn(List<String> values) {
            addCriterion("house_area in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotIn(List<String> values) {
            addCriterion("house_area not in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaBetween(String value1, String value2) {
            addCriterion("house_area between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotBetween(String value1, String value2) {
            addCriterion("house_area not between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNull() {
            addCriterion("buy_time is null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNotNull() {
            addCriterion("buy_time is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeEqualTo(String value) {
            addCriterion("buy_time =", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotEqualTo(String value) {
            addCriterion("buy_time <>", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThan(String value) {
            addCriterion("buy_time >", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("buy_time >=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThan(String value) {
            addCriterion("buy_time <", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThanOrEqualTo(String value) {
            addCriterion("buy_time <=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLike(String value) {
            addCriterion("buy_time like", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotLike(String value) {
            addCriterion("buy_time not like", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIn(List<String> values) {
            addCriterion("buy_time in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotIn(List<String> values) {
            addCriterion("buy_time not in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeBetween(String value1, String value2) {
            addCriterion("buy_time between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotBetween(String value1, String value2) {
            addCriterion("buy_time not between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andHousePriceIsNull() {
            addCriterion("house_price is null");
            return (Criteria) this;
        }

        public Criteria andHousePriceIsNotNull() {
            addCriterion("house_price is not null");
            return (Criteria) this;
        }

        public Criteria andHousePriceEqualTo(BigDecimal value) {
            addCriterion("house_price =", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotEqualTo(BigDecimal value) {
            addCriterion("house_price <>", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceGreaterThan(BigDecimal value) {
            addCriterion("house_price >", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("house_price >=", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceLessThan(BigDecimal value) {
            addCriterion("house_price <", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("house_price <=", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceIn(List<BigDecimal> values) {
            addCriterion("house_price in", values, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotIn(List<BigDecimal> values) {
            addCriterion("house_price not in", values, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_price between", value1, value2, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_price not between", value1, value2, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateIsNull() {
            addCriterion("house_proRight_rate is null");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateIsNotNull() {
            addCriterion("house_proRight_rate is not null");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateEqualTo(String value) {
            addCriterion("house_proRight_rate =", value, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateNotEqualTo(String value) {
            addCriterion("house_proRight_rate <>", value, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateGreaterThan(String value) {
            addCriterion("house_proRight_rate >", value, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateGreaterThanOrEqualTo(String value) {
            addCriterion("house_proRight_rate >=", value, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateLessThan(String value) {
            addCriterion("house_proRight_rate <", value, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateLessThanOrEqualTo(String value) {
            addCriterion("house_proRight_rate <=", value, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateLike(String value) {
            addCriterion("house_proRight_rate like", value, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateNotLike(String value) {
            addCriterion("house_proRight_rate not like", value, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateIn(List<String> values) {
            addCriterion("house_proRight_rate in", values, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateNotIn(List<String> values) {
            addCriterion("house_proRight_rate not in", values, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateBetween(String value1, String value2) {
            addCriterion("house_proRight_rate between", value1, value2, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseProrightRateNotBetween(String value1, String value2) {
            addCriterion("house_proRight_rate not between", value1, value2, "houseProrightRate");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitIsNull() {
            addCriterion("houseLo_year_limit is null");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitIsNotNull() {
            addCriterion("houseLo_year_limit is not null");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitEqualTo(Integer value) {
            addCriterion("houseLo_year_limit =", value, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitNotEqualTo(Integer value) {
            addCriterion("houseLo_year_limit <>", value, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitGreaterThan(Integer value) {
            addCriterion("houseLo_year_limit >", value, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("houseLo_year_limit >=", value, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitLessThan(Integer value) {
            addCriterion("houseLo_year_limit <", value, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitLessThanOrEqualTo(Integer value) {
            addCriterion("houseLo_year_limit <=", value, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitIn(List<Integer> values) {
            addCriterion("houseLo_year_limit in", values, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitNotIn(List<Integer> values) {
            addCriterion("houseLo_year_limit not in", values, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitBetween(Integer value1, Integer value2) {
            addCriterion("houseLo_year_limit between", value1, value2, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseloYearLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("houseLo_year_limit not between", value1, value2, "houseloYearLimit");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentIsNull() {
            addCriterion("house_monthly_payment is null");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentIsNotNull() {
            addCriterion("house_monthly_payment is not null");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentEqualTo(BigDecimal value) {
            addCriterion("house_monthly_payment =", value, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentNotEqualTo(BigDecimal value) {
            addCriterion("house_monthly_payment <>", value, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentGreaterThan(BigDecimal value) {
            addCriterion("house_monthly_payment >", value, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("house_monthly_payment >=", value, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentLessThan(BigDecimal value) {
            addCriterion("house_monthly_payment <", value, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("house_monthly_payment <=", value, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentIn(List<BigDecimal> values) {
            addCriterion("house_monthly_payment in", values, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentNotIn(List<BigDecimal> values) {
            addCriterion("house_monthly_payment not in", values, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_monthly_payment between", value1, value2, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseMonthlyPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_monthly_payment not between", value1, value2, "houseMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceIsNull() {
            addCriterion("houseLo_balance is null");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceIsNotNull() {
            addCriterion("houseLo_balance is not null");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceEqualTo(BigDecimal value) {
            addCriterion("houseLo_balance =", value, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceNotEqualTo(BigDecimal value) {
            addCriterion("houseLo_balance <>", value, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceGreaterThan(BigDecimal value) {
            addCriterion("houseLo_balance >", value, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("houseLo_balance >=", value, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceLessThan(BigDecimal value) {
            addCriterion("houseLo_balance <", value, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("houseLo_balance <=", value, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceIn(List<BigDecimal> values) {
            addCriterion("houseLo_balance in", values, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceNotIn(List<BigDecimal> values) {
            addCriterion("houseLo_balance not in", values, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("houseLo_balance between", value1, value2, "houseloBalance");
            return (Criteria) this;
        }

        public Criteria andHouseloBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("houseLo_balance not between", value1, value2, "houseloBalance");
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