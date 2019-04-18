package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class FbContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbContractExample() {
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

        public Criteria andFbIdIsNull() {
            addCriterion("fb_id is null");
            return (Criteria) this;
        }

        public Criteria andFbIdIsNotNull() {
            addCriterion("fb_id is not null");
            return (Criteria) this;
        }

        public Criteria andFbIdEqualTo(String value) {
            addCriterion("fb_id =", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotEqualTo(String value) {
            addCriterion("fb_id <>", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdGreaterThan(String value) {
            addCriterion("fb_id >", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdGreaterThanOrEqualTo(String value) {
            addCriterion("fb_id >=", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLessThan(String value) {
            addCriterion("fb_id <", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLessThanOrEqualTo(String value) {
            addCriterion("fb_id <=", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLike(String value) {
            addCriterion("fb_id like", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotLike(String value) {
            addCriterion("fb_id not like", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdIn(List<String> values) {
            addCriterion("fb_id in", values, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotIn(List<String> values) {
            addCriterion("fb_id not in", values, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdBetween(String value1, String value2) {
            addCriterion("fb_id between", value1, value2, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotBetween(String value1, String value2) {
            addCriterion("fb_id not between", value1, value2, "fbId");
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

        public Criteria andFbcTypeIsNull() {
            addCriterion("fbc_type is null");
            return (Criteria) this;
        }

        public Criteria andFbcTypeIsNotNull() {
            addCriterion("fbc_type is not null");
            return (Criteria) this;
        }

        public Criteria andFbcTypeEqualTo(String value) {
            addCriterion("fbc_type =", value, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeNotEqualTo(String value) {
            addCriterion("fbc_type <>", value, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeGreaterThan(String value) {
            addCriterion("fbc_type >", value, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fbc_type >=", value, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeLessThan(String value) {
            addCriterion("fbc_type <", value, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeLessThanOrEqualTo(String value) {
            addCriterion("fbc_type <=", value, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeLike(String value) {
            addCriterion("fbc_type like", value, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeNotLike(String value) {
            addCriterion("fbc_type not like", value, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeIn(List<String> values) {
            addCriterion("fbc_type in", values, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeNotIn(List<String> values) {
            addCriterion("fbc_type not in", values, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeBetween(String value1, String value2) {
            addCriterion("fbc_type between", value1, value2, "fbcType");
            return (Criteria) this;
        }

        public Criteria andFbcTypeNotBetween(String value1, String value2) {
            addCriterion("fbc_type not between", value1, value2, "fbcType");
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

        public Criteria andWorkNoIsNull() {
            addCriterion("work_no is null");
            return (Criteria) this;
        }

        public Criteria andWorkNoIsNotNull() {
            addCriterion("work_no is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNoEqualTo(String value) {
            addCriterion("work_no =", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotEqualTo(String value) {
            addCriterion("work_no <>", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThan(String value) {
            addCriterion("work_no >", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThanOrEqualTo(String value) {
            addCriterion("work_no >=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThan(String value) {
            addCriterion("work_no <", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThanOrEqualTo(String value) {
            addCriterion("work_no <=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLike(String value) {
            addCriterion("work_no like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotLike(String value) {
            addCriterion("work_no not like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoIn(List<String> values) {
            addCriterion("work_no in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotIn(List<String> values) {
            addCriterion("work_no not in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoBetween(String value1, String value2) {
            addCriterion("work_no between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotBetween(String value1, String value2) {
            addCriterion("work_no not between", value1, value2, "workNo");
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

        public Criteria andCjContractCodeIsNull() {
            addCriterion("cj_contract_code is null");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeIsNotNull() {
            addCriterion("cj_contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeEqualTo(String value) {
            addCriterion("cj_contract_code =", value, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeNotEqualTo(String value) {
            addCriterion("cj_contract_code <>", value, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeGreaterThan(String value) {
            addCriterion("cj_contract_code >", value, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cj_contract_code >=", value, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeLessThan(String value) {
            addCriterion("cj_contract_code <", value, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeLessThanOrEqualTo(String value) {
            addCriterion("cj_contract_code <=", value, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeLike(String value) {
            addCriterion("cj_contract_code like", value, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeNotLike(String value) {
            addCriterion("cj_contract_code not like", value, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeIn(List<String> values) {
            addCriterion("cj_contract_code in", values, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeNotIn(List<String> values) {
            addCriterion("cj_contract_code not in", values, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeBetween(String value1, String value2) {
            addCriterion("cj_contract_code between", value1, value2, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractCodeNotBetween(String value1, String value2) {
            addCriterion("cj_contract_code not between", value1, value2, "cjContractCode");
            return (Criteria) this;
        }

        public Criteria andCjContractNameIsNull() {
            addCriterion("cj_contract_name is null");
            return (Criteria) this;
        }

        public Criteria andCjContractNameIsNotNull() {
            addCriterion("cj_contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andCjContractNameEqualTo(String value) {
            addCriterion("cj_contract_name =", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameNotEqualTo(String value) {
            addCriterion("cj_contract_name <>", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameGreaterThan(String value) {
            addCriterion("cj_contract_name >", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("cj_contract_name >=", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameLessThan(String value) {
            addCriterion("cj_contract_name <", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameLessThanOrEqualTo(String value) {
            addCriterion("cj_contract_name <=", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameLike(String value) {
            addCriterion("cj_contract_name like", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameNotLike(String value) {
            addCriterion("cj_contract_name not like", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameIn(List<String> values) {
            addCriterion("cj_contract_name in", values, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameNotIn(List<String> values) {
            addCriterion("cj_contract_name not in", values, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameBetween(String value1, String value2) {
            addCriterion("cj_contract_name between", value1, value2, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameNotBetween(String value1, String value2) {
            addCriterion("cj_contract_name not between", value1, value2, "cjContractName");
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

        public Criteria andMainContractMoneyEqualTo(Double value) {
            addCriterion("main_contract_money =", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyNotEqualTo(Double value) {
            addCriterion("main_contract_money <>", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyGreaterThan(Double value) {
            addCriterion("main_contract_money >", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("main_contract_money >=", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyLessThan(Double value) {
            addCriterion("main_contract_money <", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyLessThanOrEqualTo(Double value) {
            addCriterion("main_contract_money <=", value, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyIn(List<Double> values) {
            addCriterion("main_contract_money in", values, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyNotIn(List<Double> values) {
            addCriterion("main_contract_money not in", values, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyBetween(Double value1, Double value2) {
            addCriterion("main_contract_money between", value1, value2, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andMainContractMoneyNotBetween(Double value1, Double value2) {
            addCriterion("main_contract_money not between", value1, value2, "mainContractMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyIsNull() {
            addCriterion("now_fb_all_money is null");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyIsNotNull() {
            addCriterion("now_fb_all_money is not null");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyEqualTo(Double value) {
            addCriterion("now_fb_all_money =", value, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyNotEqualTo(Double value) {
            addCriterion("now_fb_all_money <>", value, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyGreaterThan(Double value) {
            addCriterion("now_fb_all_money >", value, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("now_fb_all_money >=", value, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyLessThan(Double value) {
            addCriterion("now_fb_all_money <", value, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyLessThanOrEqualTo(Double value) {
            addCriterion("now_fb_all_money <=", value, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyIn(List<Double> values) {
            addCriterion("now_fb_all_money in", values, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyNotIn(List<Double> values) {
            addCriterion("now_fb_all_money not in", values, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyBetween(Double value1, Double value2) {
            addCriterion("now_fb_all_money between", value1, value2, "nowFbAllMoney");
            return (Criteria) this;
        }

        public Criteria andNowFbAllMoneyNotBetween(Double value1, Double value2) {
            addCriterion("now_fb_all_money not between", value1, value2, "nowFbAllMoney");
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

        public Criteria andMainManageDepartmentIsNull() {
            addCriterion("main_manage_department is null");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentIsNotNull() {
            addCriterion("main_manage_department is not null");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentEqualTo(String value) {
            addCriterion("main_manage_department =", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentNotEqualTo(String value) {
            addCriterion("main_manage_department <>", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentGreaterThan(String value) {
            addCriterion("main_manage_department >", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("main_manage_department >=", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentLessThan(String value) {
            addCriterion("main_manage_department <", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentLessThanOrEqualTo(String value) {
            addCriterion("main_manage_department <=", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentLike(String value) {
            addCriterion("main_manage_department like", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentNotLike(String value) {
            addCriterion("main_manage_department not like", value, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentIn(List<String> values) {
            addCriterion("main_manage_department in", values, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentNotIn(List<String> values) {
            addCriterion("main_manage_department not in", values, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentBetween(String value1, String value2) {
            addCriterion("main_manage_department between", value1, value2, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andMainManageDepartmentNotBetween(String value1, String value2) {
            addCriterion("main_manage_department not between", value1, value2, "mainManageDepartment");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeIsNull() {
            addCriterion("contract_long_time is null");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeIsNotNull() {
            addCriterion("contract_long_time is not null");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeEqualTo(String value) {
            addCriterion("contract_long_time =", value, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeNotEqualTo(String value) {
            addCriterion("contract_long_time <>", value, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeGreaterThan(String value) {
            addCriterion("contract_long_time >", value, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_long_time >=", value, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeLessThan(String value) {
            addCriterion("contract_long_time <", value, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeLessThanOrEqualTo(String value) {
            addCriterion("contract_long_time <=", value, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeLike(String value) {
            addCriterion("contract_long_time like", value, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeNotLike(String value) {
            addCriterion("contract_long_time not like", value, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeIn(List<String> values) {
            addCriterion("contract_long_time in", values, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeNotIn(List<String> values) {
            addCriterion("contract_long_time not in", values, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeBetween(String value1, String value2) {
            addCriterion("contract_long_time between", value1, value2, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andContractLongTimeNotBetween(String value1, String value2) {
            addCriterion("contract_long_time not between", value1, value2, "contractLongTime");
            return (Criteria) this;
        }

        public Criteria andPayModeIsNull() {
            addCriterion("pay_mode is null");
            return (Criteria) this;
        }

        public Criteria andPayModeIsNotNull() {
            addCriterion("pay_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPayModeEqualTo(String value) {
            addCriterion("pay_mode =", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeNotEqualTo(String value) {
            addCriterion("pay_mode <>", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeGreaterThan(String value) {
            addCriterion("pay_mode >", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_mode >=", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeLessThan(String value) {
            addCriterion("pay_mode <", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeLessThanOrEqualTo(String value) {
            addCriterion("pay_mode <=", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeLike(String value) {
            addCriterion("pay_mode like", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeNotLike(String value) {
            addCriterion("pay_mode not like", value, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeIn(List<String> values) {
            addCriterion("pay_mode in", values, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeNotIn(List<String> values) {
            addCriterion("pay_mode not in", values, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeBetween(String value1, String value2) {
            addCriterion("pay_mode between", value1, value2, "payMode");
            return (Criteria) this;
        }

        public Criteria andPayModeNotBetween(String value1, String value2) {
            addCriterion("pay_mode not between", value1, value2, "payMode");
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

        public Criteria andContractMoneyEqualTo(Double value) {
            addCriterion("contract_money =", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotEqualTo(Double value) {
            addCriterion("contract_money <>", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThan(Double value) {
            addCriterion("contract_money >", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_money >=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThan(Double value) {
            addCriterion("contract_money <", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThanOrEqualTo(Double value) {
            addCriterion("contract_money <=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIn(List<Double> values) {
            addCriterion("contract_money in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotIn(List<Double> values) {
            addCriterion("contract_money not in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyBetween(Double value1, Double value2) {
            addCriterion("contract_money between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotBetween(Double value1, Double value2) {
            addCriterion("contract_money not between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyIsNull() {
            addCriterion("temporary_money is null");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyIsNotNull() {
            addCriterion("temporary_money is not null");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyEqualTo(Double value) {
            addCriterion("temporary_money =", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyNotEqualTo(Double value) {
            addCriterion("temporary_money <>", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyGreaterThan(Double value) {
            addCriterion("temporary_money >", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("temporary_money >=", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyLessThan(Double value) {
            addCriterion("temporary_money <", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyLessThanOrEqualTo(Double value) {
            addCriterion("temporary_money <=", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyIn(List<Double> values) {
            addCriterion("temporary_money in", values, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyNotIn(List<Double> values) {
            addCriterion("temporary_money not in", values, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyBetween(Double value1, Double value2) {
            addCriterion("temporary_money between", value1, value2, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyNotBetween(Double value1, Double value2) {
            addCriterion("temporary_money not between", value1, value2, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andContractTextPathIsNull() {
            addCriterion("contract_text_path is null");
            return (Criteria) this;
        }

        public Criteria andContractTextPathIsNotNull() {
            addCriterion("contract_text_path is not null");
            return (Criteria) this;
        }

        public Criteria andContractTextPathEqualTo(String value) {
            addCriterion("contract_text_path =", value, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathNotEqualTo(String value) {
            addCriterion("contract_text_path <>", value, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathGreaterThan(String value) {
            addCriterion("contract_text_path >", value, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathGreaterThanOrEqualTo(String value) {
            addCriterion("contract_text_path >=", value, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathLessThan(String value) {
            addCriterion("contract_text_path <", value, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathLessThanOrEqualTo(String value) {
            addCriterion("contract_text_path <=", value, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathLike(String value) {
            addCriterion("contract_text_path like", value, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathNotLike(String value) {
            addCriterion("contract_text_path not like", value, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathIn(List<String> values) {
            addCriterion("contract_text_path in", values, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathNotIn(List<String> values) {
            addCriterion("contract_text_path not in", values, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathBetween(String value1, String value2) {
            addCriterion("contract_text_path between", value1, value2, "contractTextPath");
            return (Criteria) this;
        }

        public Criteria andContractTextPathNotBetween(String value1, String value2) {
            addCriterion("contract_text_path not between", value1, value2, "contractTextPath");
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

        public Criteria andCptSignNameImgpathIsNull() {
            addCriterion("cpt_sign_name_imgpath is null");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathIsNotNull() {
            addCriterion("cpt_sign_name_imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathEqualTo(String value) {
            addCriterion("cpt_sign_name_imgpath =", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathNotEqualTo(String value) {
            addCriterion("cpt_sign_name_imgpath <>", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathGreaterThan(String value) {
            addCriterion("cpt_sign_name_imgpath >", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("cpt_sign_name_imgpath >=", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathLessThan(String value) {
            addCriterion("cpt_sign_name_imgpath <", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathLessThanOrEqualTo(String value) {
            addCriterion("cpt_sign_name_imgpath <=", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathLike(String value) {
            addCriterion("cpt_sign_name_imgpath like", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathNotLike(String value) {
            addCriterion("cpt_sign_name_imgpath not like", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathIn(List<String> values) {
            addCriterion("cpt_sign_name_imgpath in", values, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathNotIn(List<String> values) {
            addCriterion("cpt_sign_name_imgpath not in", values, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathBetween(String value1, String value2) {
            addCriterion("cpt_sign_name_imgpath between", value1, value2, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathNotBetween(String value1, String value2) {
            addCriterion("cpt_sign_name_imgpath not between", value1, value2, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameIsNull() {
            addCriterion("cpt_sign_name is null");
            return (Criteria) this;
        }

        public Criteria andCptSignNameIsNotNull() {
            addCriterion("cpt_sign_name is not null");
            return (Criteria) this;
        }

        public Criteria andCptSignNameEqualTo(String value) {
            addCriterion("cpt_sign_name =", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameNotEqualTo(String value) {
            addCriterion("cpt_sign_name <>", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameGreaterThan(String value) {
            addCriterion("cpt_sign_name >", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameGreaterThanOrEqualTo(String value) {
            addCriterion("cpt_sign_name >=", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameLessThan(String value) {
            addCriterion("cpt_sign_name <", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameLessThanOrEqualTo(String value) {
            addCriterion("cpt_sign_name <=", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameLike(String value) {
            addCriterion("cpt_sign_name like", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameNotLike(String value) {
            addCriterion("cpt_sign_name not like", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameIn(List<String> values) {
            addCriterion("cpt_sign_name in", values, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameNotIn(List<String> values) {
            addCriterion("cpt_sign_name not in", values, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameBetween(String value1, String value2) {
            addCriterion("cpt_sign_name between", value1, value2, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameNotBetween(String value1, String value2) {
            addCriterion("cpt_sign_name not between", value1, value2, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeIsNull() {
            addCriterion("contract_probably_text_time is null");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeIsNotNull() {
            addCriterion("contract_probably_text_time is not null");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeEqualTo(String value) {
            addCriterion("contract_probably_text_time =", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeNotEqualTo(String value) {
            addCriterion("contract_probably_text_time <>", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeGreaterThan(String value) {
            addCriterion("contract_probably_text_time >", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_probably_text_time >=", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeLessThan(String value) {
            addCriterion("contract_probably_text_time <", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeLessThanOrEqualTo(String value) {
            addCriterion("contract_probably_text_time <=", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeLike(String value) {
            addCriterion("contract_probably_text_time like", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeNotLike(String value) {
            addCriterion("contract_probably_text_time not like", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeIn(List<String> values) {
            addCriterion("contract_probably_text_time in", values, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeNotIn(List<String> values) {
            addCriterion("contract_probably_text_time not in", values, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeBetween(String value1, String value2) {
            addCriterion("contract_probably_text_time between", value1, value2, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeNotBetween(String value1, String value2) {
            addCriterion("contract_probably_text_time not between", value1, value2, "contractProbablyTextTime");
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