package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class PayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayExample() {
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

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(String value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(String value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(String value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(String value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(String value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLike(String value) {
            addCriterion("pay_id like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotLike(String value) {
            addCriterion("pay_id not like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<String> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<String> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(String value1, String value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(String value1, String value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayCodeIsNull() {
            addCriterion("pay_code is null");
            return (Criteria) this;
        }

        public Criteria andPayCodeIsNotNull() {
            addCriterion("pay_code is not null");
            return (Criteria) this;
        }

        public Criteria andPayCodeEqualTo(String value) {
            addCriterion("pay_code =", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeNotEqualTo(String value) {
            addCriterion("pay_code <>", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeGreaterThan(String value) {
            addCriterion("pay_code >", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_code >=", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeLessThan(String value) {
            addCriterion("pay_code <", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeLessThanOrEqualTo(String value) {
            addCriterion("pay_code <=", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeLike(String value) {
            addCriterion("pay_code like", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeNotLike(String value) {
            addCriterion("pay_code not like", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeIn(List<String> values) {
            addCriterion("pay_code in", values, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeNotIn(List<String> values) {
            addCriterion("pay_code not in", values, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeBetween(String value1, String value2) {
            addCriterion("pay_code between", value1, value2, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeNotBetween(String value1, String value2) {
            addCriterion("pay_code not between", value1, value2, "payCode");
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

        public Criteria andContractMoneyIsNull() {
            addCriterion("contract_money is null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNotNull() {
            addCriterion("contract_money is not null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyEqualTo(String value) {
            addCriterion("contract_money =", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotEqualTo(String value) {
            addCriterion("contract_money <>", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThan(String value) {
            addCriterion("contract_money >", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("contract_money >=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThan(String value) {
            addCriterion("contract_money <", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThanOrEqualTo(String value) {
            addCriterion("contract_money <=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLike(String value) {
            addCriterion("contract_money like", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotLike(String value) {
            addCriterion("contract_money not like", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIn(List<String> values) {
            addCriterion("contract_money in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotIn(List<String> values) {
            addCriterion("contract_money not in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyBetween(String value1, String value2) {
            addCriterion("contract_money between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotBetween(String value1, String value2) {
            addCriterion("contract_money not between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyIsNull() {
            addCriterion("already_kp_money is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyIsNotNull() {
            addCriterion("already_kp_money is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyEqualTo(String value) {
            addCriterion("already_kp_money =", value, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyNotEqualTo(String value) {
            addCriterion("already_kp_money <>", value, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyGreaterThan(String value) {
            addCriterion("already_kp_money >", value, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("already_kp_money >=", value, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyLessThan(String value) {
            addCriterion("already_kp_money <", value, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyLessThanOrEqualTo(String value) {
            addCriterion("already_kp_money <=", value, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyLike(String value) {
            addCriterion("already_kp_money like", value, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyNotLike(String value) {
            addCriterion("already_kp_money not like", value, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyIn(List<String> values) {
            addCriterion("already_kp_money in", values, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyNotIn(List<String> values) {
            addCriterion("already_kp_money not in", values, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyBetween(String value1, String value2) {
            addCriterion("already_kp_money between", value1, value2, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyKpMoneyNotBetween(String value1, String value2) {
            addCriterion("already_kp_money not between", value1, value2, "alreadyKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyIsNull() {
            addCriterion("this_time_kp_money is null");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyIsNotNull() {
            addCriterion("this_time_kp_money is not null");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyEqualTo(String value) {
            addCriterion("this_time_kp_money =", value, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyNotEqualTo(String value) {
            addCriterion("this_time_kp_money <>", value, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyGreaterThan(String value) {
            addCriterion("this_time_kp_money >", value, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("this_time_kp_money >=", value, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyLessThan(String value) {
            addCriterion("this_time_kp_money <", value, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyLessThanOrEqualTo(String value) {
            addCriterion("this_time_kp_money <=", value, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyLike(String value) {
            addCriterion("this_time_kp_money like", value, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyNotLike(String value) {
            addCriterion("this_time_kp_money not like", value, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyIn(List<String> values) {
            addCriterion("this_time_kp_money in", values, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyNotIn(List<String> values) {
            addCriterion("this_time_kp_money not in", values, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyBetween(String value1, String value2) {
            addCriterion("this_time_kp_money between", value1, value2, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeKpMoneyNotBetween(String value1, String value2) {
            addCriterion("this_time_kp_money not between", value1, value2, "thisTimeKpMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeIsNull() {
            addCriterion("main_contract_code is null");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeIsNotNull() {
            addCriterion("main_contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeEqualTo(String value) {
            addCriterion("main_contract_code =", value, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeNotEqualTo(String value) {
            addCriterion("main_contract_code <>", value, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeGreaterThan(String value) {
            addCriterion("main_contract_code >", value, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("main_contract_code >=", value, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeLessThan(String value) {
            addCriterion("main_contract_code <", value, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeLessThanOrEqualTo(String value) {
            addCriterion("main_contract_code <=", value, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeLike(String value) {
            addCriterion("main_contract_code like", value, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeNotLike(String value) {
            addCriterion("main_contract_code not like", value, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeIn(List<String> values) {
            addCriterion("main_contract_code in", values, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeNotIn(List<String> values) {
            addCriterion("main_contract_code not in", values, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeBetween(String value1, String value2) {
            addCriterion("main_contract_code between", value1, value2, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractCodeNotBetween(String value1, String value2) {
            addCriterion("main_contract_code not between", value1, value2, "mainContractCode");
            return (Criteria) this;
        }

        public Criteria andMainContractNameIsNull() {
            addCriterion("main_contract_name is null");
            return (Criteria) this;
        }

        public Criteria andMainContractNameIsNotNull() {
            addCriterion("main_contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andMainContractNameEqualTo(String value) {
            addCriterion("main_contract_name =", value, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameNotEqualTo(String value) {
            addCriterion("main_contract_name <>", value, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameGreaterThan(String value) {
            addCriterion("main_contract_name >", value, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("main_contract_name >=", value, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameLessThan(String value) {
            addCriterion("main_contract_name <", value, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameLessThanOrEqualTo(String value) {
            addCriterion("main_contract_name <=", value, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameLike(String value) {
            addCriterion("main_contract_name like", value, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameNotLike(String value) {
            addCriterion("main_contract_name not like", value, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameIn(List<String> values) {
            addCriterion("main_contract_name in", values, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameNotIn(List<String> values) {
            addCriterion("main_contract_name not in", values, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameBetween(String value1, String value2) {
            addCriterion("main_contract_name between", value1, value2, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractNameNotBetween(String value1, String value2) {
            addCriterion("main_contract_name not between", value1, value2, "mainContractName");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyIsNull() {
            addCriterion("main_contract_money is null");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyIsNotNull() {
            addCriterion("main_contract_money is not null");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyEqualTo(String value) {
            addCriterion("main_contract_money =", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyNotEqualTo(String value) {
            addCriterion("main_contract_money <>", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyGreaterThan(String value) {
            addCriterion("main_contract_money >", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("main_contract_money >=", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyLessThan(String value) {
            addCriterion("main_contract_money <", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyLessThanOrEqualTo(String value) {
            addCriterion("main_contract_money <=", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyLike(String value) {
            addCriterion("main_contract_money like", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyNotLike(String value) {
            addCriterion("main_contract_money not like", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyIn(List<String> values) {
            addCriterion("main_contract_money in", values, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyNotIn(List<String> values) {
            addCriterion("main_contract_money not in", values, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyBetween(String value1, String value2) {
            addCriterion("main_contract_money between", value1, value2, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyNotBetween(String value1, String value2) {
            addCriterion("main_contract_money not between", value1, value2, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeIsNull() {
            addCriterion("prj_list_code is null");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeIsNotNull() {
            addCriterion("prj_list_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeEqualTo(String value) {
            addCriterion("prj_list_code =", value, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeNotEqualTo(String value) {
            addCriterion("prj_list_code <>", value, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeGreaterThan(String value) {
            addCriterion("prj_list_code >", value, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_list_code >=", value, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeLessThan(String value) {
            addCriterion("prj_list_code <", value, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeLessThanOrEqualTo(String value) {
            addCriterion("prj_list_code <=", value, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeLike(String value) {
            addCriterion("prj_list_code like", value, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeNotLike(String value) {
            addCriterion("prj_list_code not like", value, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeIn(List<String> values) {
            addCriterion("prj_list_code in", values, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeNotIn(List<String> values) {
            addCriterion("prj_list_code not in", values, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeBetween(String value1, String value2) {
            addCriterion("prj_list_code between", value1, value2, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjListCodeNotBetween(String value1, String value2) {
            addCriterion("prj_list_code not between", value1, value2, "prjListCode");
            return (Criteria) this;
        }

        public Criteria andPrjNameIsNull() {
            addCriterion("prj_name is null");
            return (Criteria) this;
        }

        public Criteria andPrjNameIsNotNull() {
            addCriterion("prj_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrjNameEqualTo(String value) {
            addCriterion("prj_name =", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameNotEqualTo(String value) {
            addCriterion("prj_name <>", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameGreaterThan(String value) {
            addCriterion("prj_name >", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameGreaterThanOrEqualTo(String value) {
            addCriterion("prj_name >=", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameLessThan(String value) {
            addCriterion("prj_name <", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameLessThanOrEqualTo(String value) {
            addCriterion("prj_name <=", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameLike(String value) {
            addCriterion("prj_name like", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameNotLike(String value) {
            addCriterion("prj_name not like", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameIn(List<String> values) {
            addCriterion("prj_name in", values, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameNotIn(List<String> values) {
            addCriterion("prj_name not in", values, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameBetween(String value1, String value2) {
            addCriterion("prj_name between", value1, value2, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameNotBetween(String value1, String value2) {
            addCriterion("prj_name not between", value1, value2, "prjName");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleIsNull() {
            addCriterion("fb_contract_schedule is null");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleIsNotNull() {
            addCriterion("fb_contract_schedule is not null");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleEqualTo(String value) {
            addCriterion("fb_contract_schedule =", value, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleNotEqualTo(String value) {
            addCriterion("fb_contract_schedule <>", value, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleGreaterThan(String value) {
            addCriterion("fb_contract_schedule >", value, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleGreaterThanOrEqualTo(String value) {
            addCriterion("fb_contract_schedule >=", value, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleLessThan(String value) {
            addCriterion("fb_contract_schedule <", value, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleLessThanOrEqualTo(String value) {
            addCriterion("fb_contract_schedule <=", value, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleLike(String value) {
            addCriterion("fb_contract_schedule like", value, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleNotLike(String value) {
            addCriterion("fb_contract_schedule not like", value, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleIn(List<String> values) {
            addCriterion("fb_contract_schedule in", values, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleNotIn(List<String> values) {
            addCriterion("fb_contract_schedule not in", values, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleBetween(String value1, String value2) {
            addCriterion("fb_contract_schedule between", value1, value2, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andFbContractScheduleNotBetween(String value1, String value2) {
            addCriterion("fb_contract_schedule not between", value1, value2, "fbContractSchedule");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostIsNull() {
            addCriterion("if_contract_do_cost is null");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostIsNotNull() {
            addCriterion("if_contract_do_cost is not null");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostEqualTo(String value) {
            addCriterion("if_contract_do_cost =", value, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostNotEqualTo(String value) {
            addCriterion("if_contract_do_cost <>", value, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostGreaterThan(String value) {
            addCriterion("if_contract_do_cost >", value, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostGreaterThanOrEqualTo(String value) {
            addCriterion("if_contract_do_cost >=", value, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostLessThan(String value) {
            addCriterion("if_contract_do_cost <", value, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostLessThanOrEqualTo(String value) {
            addCriterion("if_contract_do_cost <=", value, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostLike(String value) {
            addCriterion("if_contract_do_cost like", value, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostNotLike(String value) {
            addCriterion("if_contract_do_cost not like", value, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostIn(List<String> values) {
            addCriterion("if_contract_do_cost in", values, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostNotIn(List<String> values) {
            addCriterion("if_contract_do_cost not in", values, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostBetween(String value1, String value2) {
            addCriterion("if_contract_do_cost between", value1, value2, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andIfContractDoCostNotBetween(String value1, String value2) {
            addCriterion("if_contract_do_cost not between", value1, value2, "ifContractDoCost");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyIsNull() {
            addCriterion("contract_do_cost_money is null");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyIsNotNull() {
            addCriterion("contract_do_cost_money is not null");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyEqualTo(String value) {
            addCriterion("contract_do_cost_money =", value, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyNotEqualTo(String value) {
            addCriterion("contract_do_cost_money <>", value, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyGreaterThan(String value) {
            addCriterion("contract_do_cost_money >", value, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("contract_do_cost_money >=", value, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyLessThan(String value) {
            addCriterion("contract_do_cost_money <", value, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyLessThanOrEqualTo(String value) {
            addCriterion("contract_do_cost_money <=", value, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyLike(String value) {
            addCriterion("contract_do_cost_money like", value, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyNotLike(String value) {
            addCriterion("contract_do_cost_money not like", value, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyIn(List<String> values) {
            addCriterion("contract_do_cost_money in", values, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyNotIn(List<String> values) {
            addCriterion("contract_do_cost_money not in", values, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyBetween(String value1, String value2) {
            addCriterion("contract_do_cost_money between", value1, value2, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andContractDoCostMoneyNotBetween(String value1, String value2) {
            addCriterion("contract_do_cost_money not between", value1, value2, "contractDoCostMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyIsNull() {
            addCriterion("already_accumulate_money is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyIsNotNull() {
            addCriterion("already_accumulate_money is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyEqualTo(String value) {
            addCriterion("already_accumulate_money =", value, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyNotEqualTo(String value) {
            addCriterion("already_accumulate_money <>", value, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyGreaterThan(String value) {
            addCriterion("already_accumulate_money >", value, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("already_accumulate_money >=", value, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyLessThan(String value) {
            addCriterion("already_accumulate_money <", value, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyLessThanOrEqualTo(String value) {
            addCriterion("already_accumulate_money <=", value, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyLike(String value) {
            addCriterion("already_accumulate_money like", value, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyNotLike(String value) {
            addCriterion("already_accumulate_money not like", value, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyIn(List<String> values) {
            addCriterion("already_accumulate_money in", values, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyNotIn(List<String> values) {
            addCriterion("already_accumulate_money not in", values, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyBetween(String value1, String value2) {
            addCriterion("already_accumulate_money between", value1, value2, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andAlreadyAccumulateMoneyNotBetween(String value1, String value2) {
            addCriterion("already_accumulate_money not between", value1, value2, "alreadyAccumulateMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyIsNull() {
            addCriterion("should_cut_df_money is null");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyIsNotNull() {
            addCriterion("should_cut_df_money is not null");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyEqualTo(String value) {
            addCriterion("should_cut_df_money =", value, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyNotEqualTo(String value) {
            addCriterion("should_cut_df_money <>", value, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyGreaterThan(String value) {
            addCriterion("should_cut_df_money >", value, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("should_cut_df_money >=", value, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyLessThan(String value) {
            addCriterion("should_cut_df_money <", value, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyLessThanOrEqualTo(String value) {
            addCriterion("should_cut_df_money <=", value, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyLike(String value) {
            addCriterion("should_cut_df_money like", value, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyNotLike(String value) {
            addCriterion("should_cut_df_money not like", value, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyIn(List<String> values) {
            addCriterion("should_cut_df_money in", values, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyNotIn(List<String> values) {
            addCriterion("should_cut_df_money not in", values, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyBetween(String value1, String value2) {
            addCriterion("should_cut_df_money between", value1, value2, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutDfMoneyNotBetween(String value1, String value2) {
            addCriterion("should_cut_df_money not between", value1, value2, "shouldCutDfMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyIsNull() {
            addCriterion("should_cut_material_money is null");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyIsNotNull() {
            addCriterion("should_cut_material_money is not null");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyEqualTo(String value) {
            addCriterion("should_cut_material_money =", value, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyNotEqualTo(String value) {
            addCriterion("should_cut_material_money <>", value, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyGreaterThan(String value) {
            addCriterion("should_cut_material_money >", value, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("should_cut_material_money >=", value, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyLessThan(String value) {
            addCriterion("should_cut_material_money <", value, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyLessThanOrEqualTo(String value) {
            addCriterion("should_cut_material_money <=", value, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyLike(String value) {
            addCriterion("should_cut_material_money like", value, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyNotLike(String value) {
            addCriterion("should_cut_material_money not like", value, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyIn(List<String> values) {
            addCriterion("should_cut_material_money in", values, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyNotIn(List<String> values) {
            addCriterion("should_cut_material_money not in", values, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyBetween(String value1, String value2) {
            addCriterion("should_cut_material_money between", value1, value2, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andShouldCutMaterialMoneyNotBetween(String value1, String value2) {
            addCriterion("should_cut_material_money not between", value1, value2, "shouldCutMaterialMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyIsNull() {
            addCriterion("this_time_ask_money is null");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyIsNotNull() {
            addCriterion("this_time_ask_money is not null");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyEqualTo(String value) {
            addCriterion("this_time_ask_money =", value, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyNotEqualTo(String value) {
            addCriterion("this_time_ask_money <>", value, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyGreaterThan(String value) {
            addCriterion("this_time_ask_money >", value, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("this_time_ask_money >=", value, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyLessThan(String value) {
            addCriterion("this_time_ask_money <", value, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyLessThanOrEqualTo(String value) {
            addCriterion("this_time_ask_money <=", value, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyLike(String value) {
            addCriterion("this_time_ask_money like", value, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyNotLike(String value) {
            addCriterion("this_time_ask_money not like", value, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyIn(List<String> values) {
            addCriterion("this_time_ask_money in", values, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyNotIn(List<String> values) {
            addCriterion("this_time_ask_money not in", values, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyBetween(String value1, String value2) {
            addCriterion("this_time_ask_money between", value1, value2, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeAskMoneyNotBetween(String value1, String value2) {
            addCriterion("this_time_ask_money not between", value1, value2, "thisTimeAskMoney");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(String value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(String value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(String value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(String value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(String value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(String value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLike(String value) {
            addCriterion("pay_method like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotLike(String value) {
            addCriterion("pay_method not like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<String> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<String> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(String value1, String value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(String value1, String value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyIsNull() {
            addCriterion("receieve_money_company is null");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyIsNotNull() {
            addCriterion("receieve_money_company is not null");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyEqualTo(String value) {
            addCriterion("receieve_money_company =", value, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyNotEqualTo(String value) {
            addCriterion("receieve_money_company <>", value, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyGreaterThan(String value) {
            addCriterion("receieve_money_company >", value, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("receieve_money_company >=", value, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyLessThan(String value) {
            addCriterion("receieve_money_company <", value, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyLessThanOrEqualTo(String value) {
            addCriterion("receieve_money_company <=", value, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyLike(String value) {
            addCriterion("receieve_money_company like", value, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyNotLike(String value) {
            addCriterion("receieve_money_company not like", value, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyIn(List<String> values) {
            addCriterion("receieve_money_company in", values, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyNotIn(List<String> values) {
            addCriterion("receieve_money_company not in", values, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyBetween(String value1, String value2) {
            addCriterion("receieve_money_company between", value1, value2, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andReceieveMoneyCompanyNotBetween(String value1, String value2) {
            addCriterion("receieve_money_company not between", value1, value2, "receieveMoneyCompany");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyIsNull() {
            addCriterion("this_time_actual_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyIsNotNull() {
            addCriterion("this_time_actual_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyEqualTo(String value) {
            addCriterion("this_time_actual_pay_money =", value, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyNotEqualTo(String value) {
            addCriterion("this_time_actual_pay_money <>", value, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyGreaterThan(String value) {
            addCriterion("this_time_actual_pay_money >", value, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("this_time_actual_pay_money >=", value, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyLessThan(String value) {
            addCriterion("this_time_actual_pay_money <", value, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyLessThanOrEqualTo(String value) {
            addCriterion("this_time_actual_pay_money <=", value, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyLike(String value) {
            addCriterion("this_time_actual_pay_money like", value, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyNotLike(String value) {
            addCriterion("this_time_actual_pay_money not like", value, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyIn(List<String> values) {
            addCriterion("this_time_actual_pay_money in", values, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyNotIn(List<String> values) {
            addCriterion("this_time_actual_pay_money not in", values, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyBetween(String value1, String value2) {
            addCriterion("this_time_actual_pay_money between", value1, value2, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeActualPayMoneyNotBetween(String value1, String value2) {
            addCriterion("this_time_actual_pay_money not between", value1, value2, "thisTimeActualPayMoney");
            return (Criteria) this;
        }

        public Criteria andPayListExplainIsNull() {
            addCriterion("pay_list_explain is null");
            return (Criteria) this;
        }

        public Criteria andPayListExplainIsNotNull() {
            addCriterion("pay_list_explain is not null");
            return (Criteria) this;
        }

        public Criteria andPayListExplainEqualTo(String value) {
            addCriterion("pay_list_explain =", value, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainNotEqualTo(String value) {
            addCriterion("pay_list_explain <>", value, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainGreaterThan(String value) {
            addCriterion("pay_list_explain >", value, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainGreaterThanOrEqualTo(String value) {
            addCriterion("pay_list_explain >=", value, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainLessThan(String value) {
            addCriterion("pay_list_explain <", value, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainLessThanOrEqualTo(String value) {
            addCriterion("pay_list_explain <=", value, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainLike(String value) {
            addCriterion("pay_list_explain like", value, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainNotLike(String value) {
            addCriterion("pay_list_explain not like", value, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainIn(List<String> values) {
            addCriterion("pay_list_explain in", values, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainNotIn(List<String> values) {
            addCriterion("pay_list_explain not in", values, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainBetween(String value1, String value2) {
            addCriterion("pay_list_explain between", value1, value2, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andPayListExplainNotBetween(String value1, String value2) {
            addCriterion("pay_list_explain not between", value1, value2, "payListExplain");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonIsNull() {
            addCriterion("compiler_person is null");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonIsNotNull() {
            addCriterion("compiler_person is not null");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonEqualTo(String value) {
            addCriterion("compiler_person =", value, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonNotEqualTo(String value) {
            addCriterion("compiler_person <>", value, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonGreaterThan(String value) {
            addCriterion("compiler_person >", value, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonGreaterThanOrEqualTo(String value) {
            addCriterion("compiler_person >=", value, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonLessThan(String value) {
            addCriterion("compiler_person <", value, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonLessThanOrEqualTo(String value) {
            addCriterion("compiler_person <=", value, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonLike(String value) {
            addCriterion("compiler_person like", value, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonNotLike(String value) {
            addCriterion("compiler_person not like", value, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonIn(List<String> values) {
            addCriterion("compiler_person in", values, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonNotIn(List<String> values) {
            addCriterion("compiler_person not in", values, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonBetween(String value1, String value2) {
            addCriterion("compiler_person between", value1, value2, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerPersonNotBetween(String value1, String value2) {
            addCriterion("compiler_person not between", value1, value2, "compilerPerson");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeIsNull() {
            addCriterion("compiler_time is null");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeIsNotNull() {
            addCriterion("compiler_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeEqualTo(String value) {
            addCriterion("compiler_time =", value, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeNotEqualTo(String value) {
            addCriterion("compiler_time <>", value, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeGreaterThan(String value) {
            addCriterion("compiler_time >", value, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeGreaterThanOrEqualTo(String value) {
            addCriterion("compiler_time >=", value, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeLessThan(String value) {
            addCriterion("compiler_time <", value, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeLessThanOrEqualTo(String value) {
            addCriterion("compiler_time <=", value, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeLike(String value) {
            addCriterion("compiler_time like", value, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeNotLike(String value) {
            addCriterion("compiler_time not like", value, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeIn(List<String> values) {
            addCriterion("compiler_time in", values, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeNotIn(List<String> values) {
            addCriterion("compiler_time not in", values, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeBetween(String value1, String value2) {
            addCriterion("compiler_time between", value1, value2, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andCompilerTimeNotBetween(String value1, String value2) {
            addCriterion("compiler_time not between", value1, value2, "compilerTime");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileIsNull() {
            addCriterion("open_ticket_file is null");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileIsNotNull() {
            addCriterion("open_ticket_file is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileEqualTo(String value) {
            addCriterion("open_ticket_file =", value, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileNotEqualTo(String value) {
            addCriterion("open_ticket_file <>", value, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileGreaterThan(String value) {
            addCriterion("open_ticket_file >", value, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileGreaterThanOrEqualTo(String value) {
            addCriterion("open_ticket_file >=", value, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileLessThan(String value) {
            addCriterion("open_ticket_file <", value, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileLessThanOrEqualTo(String value) {
            addCriterion("open_ticket_file <=", value, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileLike(String value) {
            addCriterion("open_ticket_file like", value, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileNotLike(String value) {
            addCriterion("open_ticket_file not like", value, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileIn(List<String> values) {
            addCriterion("open_ticket_file in", values, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileNotIn(List<String> values) {
            addCriterion("open_ticket_file not in", values, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileBetween(String value1, String value2) {
            addCriterion("open_ticket_file between", value1, value2, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andOpenTicketFileNotBetween(String value1, String value2) {
            addCriterion("open_ticket_file not between", value1, value2, "openTicketFile");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathIsNull() {
            addCriterion("ticket_file_path is null");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathIsNotNull() {
            addCriterion("ticket_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathEqualTo(String value) {
            addCriterion("ticket_file_path =", value, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathNotEqualTo(String value) {
            addCriterion("ticket_file_path <>", value, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathGreaterThan(String value) {
            addCriterion("ticket_file_path >", value, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_file_path >=", value, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathLessThan(String value) {
            addCriterion("ticket_file_path <", value, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathLessThanOrEqualTo(String value) {
            addCriterion("ticket_file_path <=", value, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathLike(String value) {
            addCriterion("ticket_file_path like", value, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathNotLike(String value) {
            addCriterion("ticket_file_path not like", value, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathIn(List<String> values) {
            addCriterion("ticket_file_path in", values, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathNotIn(List<String> values) {
            addCriterion("ticket_file_path not in", values, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathBetween(String value1, String value2) {
            addCriterion("ticket_file_path between", value1, value2, "ticketFilePath");
            return (Criteria) this;
        }

        public Criteria andTicketFilePathNotBetween(String value1, String value2) {
            addCriterion("ticket_file_path not between", value1, value2, "ticketFilePath");
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