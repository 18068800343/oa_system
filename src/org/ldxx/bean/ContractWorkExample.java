package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class ContractWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractWorkExample() {
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

        public Criteria andCwIdIsNull() {
            addCriterion("cw_id is null");
            return (Criteria) this;
        }

        public Criteria andCwIdIsNotNull() {
            addCriterion("cw_id is not null");
            return (Criteria) this;
        }

        public Criteria andCwIdEqualTo(String value) {
            addCriterion("cw_id =", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdNotEqualTo(String value) {
            addCriterion("cw_id <>", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdGreaterThan(String value) {
            addCriterion("cw_id >", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdGreaterThanOrEqualTo(String value) {
            addCriterion("cw_id >=", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdLessThan(String value) {
            addCriterion("cw_id <", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdLessThanOrEqualTo(String value) {
            addCriterion("cw_id <=", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdLike(String value) {
            addCriterion("cw_id like", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdNotLike(String value) {
            addCriterion("cw_id not like", value, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdIn(List<String> values) {
            addCriterion("cw_id in", values, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdNotIn(List<String> values) {
            addCriterion("cw_id not in", values, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdBetween(String value1, String value2) {
            addCriterion("cw_id between", value1, value2, "cwId");
            return (Criteria) this;
        }

        public Criteria andCwIdNotBetween(String value1, String value2) {
            addCriterion("cw_id not between", value1, value2, "cwId");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIsNull() {
            addCriterion("prj_code is null");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIsNotNull() {
            addCriterion("prj_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrjCodeEqualTo(String value) {
            addCriterion("prj_code =", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotEqualTo(String value) {
            addCriterion("prj_code <>", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeGreaterThan(String value) {
            addCriterion("prj_code >", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_code >=", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLessThan(String value) {
            addCriterion("prj_code <", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLessThanOrEqualTo(String value) {
            addCriterion("prj_code <=", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLike(String value) {
            addCriterion("prj_code like", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotLike(String value) {
            addCriterion("prj_code not like", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIn(List<String> values) {
            addCriterion("prj_code in", values, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotIn(List<String> values) {
            addCriterion("prj_code not in", values, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeBetween(String value1, String value2) {
            addCriterion("prj_code between", value1, value2, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotBetween(String value1, String value2) {
            addCriterion("prj_code not between", value1, value2, "prjCode");
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

        public Criteria andPrjProbablyTextIsNull() {
            addCriterion("prj_probably_text is null");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextIsNotNull() {
            addCriterion("prj_probably_text is not null");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextEqualTo(String value) {
            addCriterion("prj_probably_text =", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextNotEqualTo(String value) {
            addCriterion("prj_probably_text <>", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextGreaterThan(String value) {
            addCriterion("prj_probably_text >", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextGreaterThanOrEqualTo(String value) {
            addCriterion("prj_probably_text >=", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextLessThan(String value) {
            addCriterion("prj_probably_text <", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextLessThanOrEqualTo(String value) {
            addCriterion("prj_probably_text <=", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextLike(String value) {
            addCriterion("prj_probably_text like", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextNotLike(String value) {
            addCriterion("prj_probably_text not like", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextIn(List<String> values) {
            addCriterion("prj_probably_text in", values, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextNotIn(List<String> values) {
            addCriterion("prj_probably_text not in", values, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextBetween(String value1, String value2) {
            addCriterion("prj_probably_text between", value1, value2, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextNotBetween(String value1, String value2) {
            addCriterion("prj_probably_text not between", value1, value2, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeIsNull() {
            addCriterion("prj_long_time is null");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeIsNotNull() {
            addCriterion("prj_long_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeEqualTo(String value) {
            addCriterion("prj_long_time =", value, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeNotEqualTo(String value) {
            addCriterion("prj_long_time <>", value, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeGreaterThan(String value) {
            addCriterion("prj_long_time >", value, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_long_time >=", value, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeLessThan(String value) {
            addCriterion("prj_long_time <", value, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeLessThanOrEqualTo(String value) {
            addCriterion("prj_long_time <=", value, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeLike(String value) {
            addCriterion("prj_long_time like", value, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeNotLike(String value) {
            addCriterion("prj_long_time not like", value, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeIn(List<String> values) {
            addCriterion("prj_long_time in", values, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeNotIn(List<String> values) {
            addCriterion("prj_long_time not in", values, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeBetween(String value1, String value2) {
            addCriterion("prj_long_time between", value1, value2, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andPrjLongTimeNotBetween(String value1, String value2) {
            addCriterion("prj_long_time not between", value1, value2, "prjLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkTextIsNull() {
            addCriterion("work_text is null");
            return (Criteria) this;
        }

        public Criteria andWorkTextIsNotNull() {
            addCriterion("work_text is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTextEqualTo(String value) {
            addCriterion("work_text =", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextNotEqualTo(String value) {
            addCriterion("work_text <>", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextGreaterThan(String value) {
            addCriterion("work_text >", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextGreaterThanOrEqualTo(String value) {
            addCriterion("work_text >=", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextLessThan(String value) {
            addCriterion("work_text <", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextLessThanOrEqualTo(String value) {
            addCriterion("work_text <=", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextLike(String value) {
            addCriterion("work_text like", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextNotLike(String value) {
            addCriterion("work_text not like", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextIn(List<String> values) {
            addCriterion("work_text in", values, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextNotIn(List<String> values) {
            addCriterion("work_text not in", values, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextBetween(String value1, String value2) {
            addCriterion("work_text between", value1, value2, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextNotBetween(String value1, String value2) {
            addCriterion("work_text not between", value1, value2, "workText");
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

        public Criteria andEndMoneyIsNull() {
            addCriterion("end_money is null");
            return (Criteria) this;
        }

        public Criteria andEndMoneyIsNotNull() {
            addCriterion("end_money is not null");
            return (Criteria) this;
        }

        public Criteria andEndMoneyEqualTo(Double value) {
            addCriterion("end_money =", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyNotEqualTo(Double value) {
            addCriterion("end_money <>", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyGreaterThan(Double value) {
            addCriterion("end_money >", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("end_money >=", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyLessThan(Double value) {
            addCriterion("end_money <", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyLessThanOrEqualTo(Double value) {
            addCriterion("end_money <=", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyIn(List<Double> values) {
            addCriterion("end_money in", values, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyNotIn(List<Double> values) {
            addCriterion("end_money not in", values, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyBetween(Double value1, Double value2) {
            addCriterion("end_money between", value1, value2, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyNotBetween(Double value1, Double value2) {
            addCriterion("end_money not between", value1, value2, "endMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentIsNull() {
            addCriterion("main_department is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentIsNotNull() {
            addCriterion("main_department is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentEqualTo(Double value) {
            addCriterion("main_department =", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentNotEqualTo(Double value) {
            addCriterion("main_department <>", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentGreaterThan(Double value) {
            addCriterion("main_department >", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentGreaterThanOrEqualTo(Double value) {
            addCriterion("main_department >=", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentLessThan(Double value) {
            addCriterion("main_department <", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentLessThanOrEqualTo(Double value) {
            addCriterion("main_department <=", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentIn(List<Double> values) {
            addCriterion("main_department in", values, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentNotIn(List<Double> values) {
            addCriterion("main_department not in", values, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentBetween(Double value1, Double value2) {
            addCriterion("main_department between", value1, value2, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentNotBetween(Double value1, Double value2) {
            addCriterion("main_department not between", value1, value2, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1IsNull() {
            addCriterion("cooperation_department_money1 is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1IsNotNull() {
            addCriterion("cooperation_department_money1 is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1EqualTo(Double value) {
            addCriterion("cooperation_department_money1 =", value, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1NotEqualTo(Double value) {
            addCriterion("cooperation_department_money1 <>", value, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1GreaterThan(Double value) {
            addCriterion("cooperation_department_money1 >", value, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1GreaterThanOrEqualTo(Double value) {
            addCriterion("cooperation_department_money1 >=", value, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1LessThan(Double value) {
            addCriterion("cooperation_department_money1 <", value, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1LessThanOrEqualTo(Double value) {
            addCriterion("cooperation_department_money1 <=", value, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1In(List<Double> values) {
            addCriterion("cooperation_department_money1 in", values, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1NotIn(List<Double> values) {
            addCriterion("cooperation_department_money1 not in", values, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1Between(Double value1, Double value2) {
            addCriterion("cooperation_department_money1 between", value1, value2, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney1NotBetween(Double value1, Double value2) {
            addCriterion("cooperation_department_money1 not between", value1, value2, "cooperationDepartmentMoney1");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2IsNull() {
            addCriterion("cooperation_department_money2 is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2IsNotNull() {
            addCriterion("cooperation_department_money2 is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2EqualTo(Double value) {
            addCriterion("cooperation_department_money2 =", value, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2NotEqualTo(Double value) {
            addCriterion("cooperation_department_money2 <>", value, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2GreaterThan(Double value) {
            addCriterion("cooperation_department_money2 >", value, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2GreaterThanOrEqualTo(Double value) {
            addCriterion("cooperation_department_money2 >=", value, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2LessThan(Double value) {
            addCriterion("cooperation_department_money2 <", value, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2LessThanOrEqualTo(Double value) {
            addCriterion("cooperation_department_money2 <=", value, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2In(List<Double> values) {
            addCriterion("cooperation_department_money2 in", values, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2NotIn(List<Double> values) {
            addCriterion("cooperation_department_money2 not in", values, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2Between(Double value1, Double value2) {
            addCriterion("cooperation_department_money2 between", value1, value2, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney2NotBetween(Double value1, Double value2) {
            addCriterion("cooperation_department_money2 not between", value1, value2, "cooperationDepartmentMoney2");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3IsNull() {
            addCriterion("cooperation_department_money3 is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3IsNotNull() {
            addCriterion("cooperation_department_money3 is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3EqualTo(Double value) {
            addCriterion("cooperation_department_money3 =", value, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3NotEqualTo(Double value) {
            addCriterion("cooperation_department_money3 <>", value, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3GreaterThan(Double value) {
            addCriterion("cooperation_department_money3 >", value, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3GreaterThanOrEqualTo(Double value) {
            addCriterion("cooperation_department_money3 >=", value, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3LessThan(Double value) {
            addCriterion("cooperation_department_money3 <", value, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3LessThanOrEqualTo(Double value) {
            addCriterion("cooperation_department_money3 <=", value, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3In(List<Double> values) {
            addCriterion("cooperation_department_money3 in", values, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3NotIn(List<Double> values) {
            addCriterion("cooperation_department_money3 not in", values, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3Between(Double value1, Double value2) {
            addCriterion("cooperation_department_money3 between", value1, value2, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentMoney3NotBetween(Double value1, Double value2) {
            addCriterion("cooperation_department_money3 not between", value1, value2, "cooperationDepartmentMoney3");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyIsNull() {
            addCriterion("all_receieve_money is null");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyIsNotNull() {
            addCriterion("all_receieve_money is not null");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyEqualTo(Double value) {
            addCriterion("all_receieve_money =", value, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyNotEqualTo(Double value) {
            addCriterion("all_receieve_money <>", value, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyGreaterThan(Double value) {
            addCriterion("all_receieve_money >", value, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("all_receieve_money >=", value, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyLessThan(Double value) {
            addCriterion("all_receieve_money <", value, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyLessThanOrEqualTo(Double value) {
            addCriterion("all_receieve_money <=", value, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyIn(List<Double> values) {
            addCriterion("all_receieve_money in", values, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyNotIn(List<Double> values) {
            addCriterion("all_receieve_money not in", values, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyBetween(Double value1, Double value2) {
            addCriterion("all_receieve_money between", value1, value2, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andAllReceieveMoneyNotBetween(Double value1, Double value2) {
            addCriterion("all_receieve_money not between", value1, value2, "allReceieveMoney");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostIsNull() {
            addCriterion("prj_direct_cost is null");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostIsNotNull() {
            addCriterion("prj_direct_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostEqualTo(String value) {
            addCriterion("prj_direct_cost =", value, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostNotEqualTo(String value) {
            addCriterion("prj_direct_cost <>", value, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostGreaterThan(String value) {
            addCriterion("prj_direct_cost >", value, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostGreaterThanOrEqualTo(String value) {
            addCriterion("prj_direct_cost >=", value, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostLessThan(String value) {
            addCriterion("prj_direct_cost <", value, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostLessThanOrEqualTo(String value) {
            addCriterion("prj_direct_cost <=", value, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostLike(String value) {
            addCriterion("prj_direct_cost like", value, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostNotLike(String value) {
            addCriterion("prj_direct_cost not like", value, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostIn(List<String> values) {
            addCriterion("prj_direct_cost in", values, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostNotIn(List<String> values) {
            addCriterion("prj_direct_cost not in", values, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostBetween(String value1, String value2) {
            addCriterion("prj_direct_cost between", value1, value2, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjDirectCostNotBetween(String value1, String value2) {
            addCriterion("prj_direct_cost not between", value1, value2, "prjDirectCost");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManIsNull() {
            addCriterion("prj_charge_man is null");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManIsNotNull() {
            addCriterion("prj_charge_man is not null");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManEqualTo(String value) {
            addCriterion("prj_charge_man =", value, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManNotEqualTo(String value) {
            addCriterion("prj_charge_man <>", value, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManGreaterThan(String value) {
            addCriterion("prj_charge_man >", value, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManGreaterThanOrEqualTo(String value) {
            addCriterion("prj_charge_man >=", value, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManLessThan(String value) {
            addCriterion("prj_charge_man <", value, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManLessThanOrEqualTo(String value) {
            addCriterion("prj_charge_man <=", value, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManLike(String value) {
            addCriterion("prj_charge_man like", value, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManNotLike(String value) {
            addCriterion("prj_charge_man not like", value, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManIn(List<String> values) {
            addCriterion("prj_charge_man in", values, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManNotIn(List<String> values) {
            addCriterion("prj_charge_man not in", values, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManBetween(String value1, String value2) {
            addCriterion("prj_charge_man between", value1, value2, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andPrjChargeManNotBetween(String value1, String value2) {
            addCriterion("prj_charge_man not between", value1, value2, "prjChargeMan");
            return (Criteria) this;
        }

        public Criteria andOtherFileIsNull() {
            addCriterion("other_file is null");
            return (Criteria) this;
        }

        public Criteria andOtherFileIsNotNull() {
            addCriterion("other_file is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFileEqualTo(String value) {
            addCriterion("other_file =", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileNotEqualTo(String value) {
            addCriterion("other_file <>", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileGreaterThan(String value) {
            addCriterion("other_file >", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileGreaterThanOrEqualTo(String value) {
            addCriterion("other_file >=", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileLessThan(String value) {
            addCriterion("other_file <", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileLessThanOrEqualTo(String value) {
            addCriterion("other_file <=", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileLike(String value) {
            addCriterion("other_file like", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileNotLike(String value) {
            addCriterion("other_file not like", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileIn(List<String> values) {
            addCriterion("other_file in", values, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileNotIn(List<String> values) {
            addCriterion("other_file not in", values, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileBetween(String value1, String value2) {
            addCriterion("other_file between", value1, value2, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileNotBetween(String value1, String value2) {
            addCriterion("other_file not between", value1, value2, "otherFile");
            return (Criteria) this;
        }

        public Criteria andCoTypeIsNull() {
            addCriterion("co_type is null");
            return (Criteria) this;
        }

        public Criteria andCoTypeIsNotNull() {
            addCriterion("co_type is not null");
            return (Criteria) this;
        }

        public Criteria andCoTypeEqualTo(Integer value) {
            addCriterion("co_type =", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeNotEqualTo(Integer value) {
            addCriterion("co_type <>", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeGreaterThan(Integer value) {
            addCriterion("co_type >", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("co_type >=", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeLessThan(Integer value) {
            addCriterion("co_type <", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeLessThanOrEqualTo(Integer value) {
            addCriterion("co_type <=", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeIn(List<Integer> values) {
            addCriterion("co_type in", values, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeNotIn(List<Integer> values) {
            addCriterion("co_type not in", values, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeBetween(Integer value1, Integer value2) {
            addCriterion("co_type between", value1, value2, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("co_type not between", value1, value2, "coType");
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