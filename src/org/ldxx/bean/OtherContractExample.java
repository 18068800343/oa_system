package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OtherContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OtherContractExample() {
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

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(String value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(String value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(String value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(String value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(String value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(String value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLike(String value) {
            addCriterion("o_id like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotLike(String value) {
            addCriterion("o_id not like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<String> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<String> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(String value1, String value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(String value1, String value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNull() {
            addCriterion("contract_type is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("contract_type is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(String value) {
            addCriterion("contract_type =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(String value) {
            addCriterion("contract_type <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(String value) {
            addCriterion("contract_type >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_type >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(String value) {
            addCriterion("contract_type <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(String value) {
            addCriterion("contract_type <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLike(String value) {
            addCriterion("contract_type like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotLike(String value) {
            addCriterion("contract_type not like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<String> values) {
            addCriterion("contract_type in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<String> values) {
            addCriterion("contract_type not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(String value1, String value2) {
            addCriterion("contract_type between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(String value1, String value2) {
            addCriterion("contract_type not between", value1, value2, "contractType");
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

        public Criteria andContractNameIsNull() {
            addCriterion("contract_name is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("contract_name =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("contract_name <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("contract_name >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("contract_name <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("contract_name <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("contract_name like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("contract_name not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("contract_name in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("contract_name not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("contract_name between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("contract_name not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaIsNull() {
            addCriterion("contract_name_jia is null");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaIsNotNull() {
            addCriterion("contract_name_jia is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaEqualTo(String value) {
            addCriterion("contract_name_jia =", value, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaNotEqualTo(String value) {
            addCriterion("contract_name_jia <>", value, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaGreaterThan(String value) {
            addCriterion("contract_name_jia >", value, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name_jia >=", value, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaLessThan(String value) {
            addCriterion("contract_name_jia <", value, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaLessThanOrEqualTo(String value) {
            addCriterion("contract_name_jia <=", value, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaLike(String value) {
            addCriterion("contract_name_jia like", value, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaNotLike(String value) {
            addCriterion("contract_name_jia not like", value, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaIn(List<String> values) {
            addCriterion("contract_name_jia in", values, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaNotIn(List<String> values) {
            addCriterion("contract_name_jia not in", values, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaBetween(String value1, String value2) {
            addCriterion("contract_name_jia between", value1, value2, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameJiaNotBetween(String value1, String value2) {
            addCriterion("contract_name_jia not between", value1, value2, "contractNameJia");
            return (Criteria) this;
        }

        public Criteria andContractNameYiIsNull() {
            addCriterion("contract_name_yi is null");
            return (Criteria) this;
        }

        public Criteria andContractNameYiIsNotNull() {
            addCriterion("contract_name_yi is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameYiEqualTo(String value) {
            addCriterion("contract_name_yi =", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiNotEqualTo(String value) {
            addCriterion("contract_name_yi <>", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiGreaterThan(String value) {
            addCriterion("contract_name_yi >", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name_yi >=", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiLessThan(String value) {
            addCriterion("contract_name_yi <", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiLessThanOrEqualTo(String value) {
            addCriterion("contract_name_yi <=", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiLike(String value) {
            addCriterion("contract_name_yi like", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiNotLike(String value) {
            addCriterion("contract_name_yi not like", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiIn(List<String> values) {
            addCriterion("contract_name_yi in", values, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiNotIn(List<String> values) {
            addCriterion("contract_name_yi not in", values, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiBetween(String value1, String value2) {
            addCriterion("contract_name_yi between", value1, value2, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiNotBetween(String value1, String value2) {
            addCriterion("contract_name_yi not between", value1, value2, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNull() {
            addCriterion("contract_money is null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNotNull() {
            addCriterion("contract_money is not null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyEqualTo(BigDecimal value) {
            addCriterion("contract_money =", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotEqualTo(BigDecimal value) {
            addCriterion("contract_money <>", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThan(BigDecimal value) {
            addCriterion("contract_money >", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_money >=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThan(BigDecimal value) {
            addCriterion("contract_money <", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_money <=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIn(List<BigDecimal> values) {
            addCriterion("contract_money in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotIn(List<BigDecimal> values) {
            addCriterion("contract_money not in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_money between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_money not between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentIsNull() {
            addCriterion("abutment_department is null");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentIsNotNull() {
            addCriterion("abutment_department is not null");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentEqualTo(String value) {
            addCriterion("abutment_department =", value, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentNotEqualTo(String value) {
            addCriterion("abutment_department <>", value, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentGreaterThan(String value) {
            addCriterion("abutment_department >", value, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("abutment_department >=", value, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentLessThan(String value) {
            addCriterion("abutment_department <", value, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentLessThanOrEqualTo(String value) {
            addCriterion("abutment_department <=", value, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentLike(String value) {
            addCriterion("abutment_department like", value, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentNotLike(String value) {
            addCriterion("abutment_department not like", value, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentIn(List<String> values) {
            addCriterion("abutment_department in", values, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentNotIn(List<String> values) {
            addCriterion("abutment_department not in", values, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentBetween(String value1, String value2) {
            addCriterion("abutment_department between", value1, value2, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAbutmentDepartmentNotBetween(String value1, String value2) {
            addCriterion("abutment_department not between", value1, value2, "abutmentDepartment");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeIsNull() {
            addCriterion("contract_start_time is null");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeIsNotNull() {
            addCriterion("contract_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeEqualTo(String value) {
            addCriterion("contract_start_time =", value, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeNotEqualTo(String value) {
            addCriterion("contract_start_time <>", value, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeGreaterThan(String value) {
            addCriterion("contract_start_time >", value, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_start_time >=", value, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeLessThan(String value) {
            addCriterion("contract_start_time <", value, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeLessThanOrEqualTo(String value) {
            addCriterion("contract_start_time <=", value, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeLike(String value) {
            addCriterion("contract_start_time like", value, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeNotLike(String value) {
            addCriterion("contract_start_time not like", value, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeIn(List<String> values) {
            addCriterion("contract_start_time in", values, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeNotIn(List<String> values) {
            addCriterion("contract_start_time not in", values, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeBetween(String value1, String value2) {
            addCriterion("contract_start_time between", value1, value2, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractStartTimeNotBetween(String value1, String value2) {
            addCriterion("contract_start_time not between", value1, value2, "contractStartTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeIsNull() {
            addCriterion("contract_end_time is null");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeIsNotNull() {
            addCriterion("contract_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeEqualTo(String value) {
            addCriterion("contract_end_time =", value, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeNotEqualTo(String value) {
            addCriterion("contract_end_time <>", value, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeGreaterThan(String value) {
            addCriterion("contract_end_time >", value, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_end_time >=", value, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeLessThan(String value) {
            addCriterion("contract_end_time <", value, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeLessThanOrEqualTo(String value) {
            addCriterion("contract_end_time <=", value, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeLike(String value) {
            addCriterion("contract_end_time like", value, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeNotLike(String value) {
            addCriterion("contract_end_time not like", value, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeIn(List<String> values) {
            addCriterion("contract_end_time in", values, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeNotIn(List<String> values) {
            addCriterion("contract_end_time not in", values, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeBetween(String value1, String value2) {
            addCriterion("contract_end_time between", value1, value2, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractEndTimeNotBetween(String value1, String value2) {
            addCriterion("contract_end_time not between", value1, value2, "contractEndTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextIsNull() {
            addCriterion("contract_probably_text is null");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextIsNotNull() {
            addCriterion("contract_probably_text is not null");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextEqualTo(String value) {
            addCriterion("contract_probably_text =", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextNotEqualTo(String value) {
            addCriterion("contract_probably_text <>", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextGreaterThan(String value) {
            addCriterion("contract_probably_text >", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextGreaterThanOrEqualTo(String value) {
            addCriterion("contract_probably_text >=", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextLessThan(String value) {
            addCriterion("contract_probably_text <", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextLessThanOrEqualTo(String value) {
            addCriterion("contract_probably_text <=", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextLike(String value) {
            addCriterion("contract_probably_text like", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextNotLike(String value) {
            addCriterion("contract_probably_text not like", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextIn(List<String> values) {
            addCriterion("contract_probably_text in", values, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextNotIn(List<String> values) {
            addCriterion("contract_probably_text not in", values, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextBetween(String value1, String value2) {
            addCriterion("contract_probably_text between", value1, value2, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextNotBetween(String value1, String value2) {
            addCriterion("contract_probably_text not between", value1, value2, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeIsNull() {
            addCriterion("abutment_signed_time is null");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeIsNotNull() {
            addCriterion("abutment_signed_time is not null");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeEqualTo(String value) {
            addCriterion("abutment_signed_time =", value, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeNotEqualTo(String value) {
            addCriterion("abutment_signed_time <>", value, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeGreaterThan(String value) {
            addCriterion("abutment_signed_time >", value, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("abutment_signed_time >=", value, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeLessThan(String value) {
            addCriterion("abutment_signed_time <", value, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeLessThanOrEqualTo(String value) {
            addCriterion("abutment_signed_time <=", value, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeLike(String value) {
            addCriterion("abutment_signed_time like", value, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeNotLike(String value) {
            addCriterion("abutment_signed_time not like", value, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeIn(List<String> values) {
            addCriterion("abutment_signed_time in", values, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeNotIn(List<String> values) {
            addCriterion("abutment_signed_time not in", values, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeBetween(String value1, String value2) {
            addCriterion("abutment_signed_time between", value1, value2, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andAbutmentSignedTimeNotBetween(String value1, String value2) {
            addCriterion("abutment_signed_time not between", value1, value2, "abutmentSignedTime");
            return (Criteria) this;
        }

        public Criteria andContractFilePathIsNull() {
            addCriterion("contract_file_path is null");
            return (Criteria) this;
        }

        public Criteria andContractFilePathIsNotNull() {
            addCriterion("contract_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andContractFilePathEqualTo(String value) {
            addCriterion("contract_file_path =", value, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathNotEqualTo(String value) {
            addCriterion("contract_file_path <>", value, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathGreaterThan(String value) {
            addCriterion("contract_file_path >", value, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("contract_file_path >=", value, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathLessThan(String value) {
            addCriterion("contract_file_path <", value, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathLessThanOrEqualTo(String value) {
            addCriterion("contract_file_path <=", value, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathLike(String value) {
            addCriterion("contract_file_path like", value, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathNotLike(String value) {
            addCriterion("contract_file_path not like", value, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathIn(List<String> values) {
            addCriterion("contract_file_path in", values, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathNotIn(List<String> values) {
            addCriterion("contract_file_path not in", values, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathBetween(String value1, String value2) {
            addCriterion("contract_file_path between", value1, value2, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andContractFilePathNotBetween(String value1, String value2) {
            addCriterion("contract_file_path not between", value1, value2, "contractFilePath");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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