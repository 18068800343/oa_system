package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class PrjEndWorkApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrjEndWorkApplyExample() {
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

        public Criteria andPeIdIsNull() {
            addCriterion("pe_id is null");
            return (Criteria) this;
        }

        public Criteria andPeIdIsNotNull() {
            addCriterion("pe_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeIdEqualTo(String value) {
            addCriterion("pe_id =", value, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdNotEqualTo(String value) {
            addCriterion("pe_id <>", value, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdGreaterThan(String value) {
            addCriterion("pe_id >", value, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdGreaterThanOrEqualTo(String value) {
            addCriterion("pe_id >=", value, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdLessThan(String value) {
            addCriterion("pe_id <", value, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdLessThanOrEqualTo(String value) {
            addCriterion("pe_id <=", value, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdLike(String value) {
            addCriterion("pe_id like", value, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdNotLike(String value) {
            addCriterion("pe_id not like", value, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdIn(List<String> values) {
            addCriterion("pe_id in", values, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdNotIn(List<String> values) {
            addCriterion("pe_id not in", values, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdBetween(String value1, String value2) {
            addCriterion("pe_id between", value1, value2, "peId");
            return (Criteria) this;
        }

        public Criteria andPeIdNotBetween(String value1, String value2) {
            addCriterion("pe_id not between", value1, value2, "peId");
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

        public Criteria andContractMoneyEqualTo(Float value) {
            addCriterion("contract_money =", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotEqualTo(Float value) {
            addCriterion("contract_money <>", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThan(Float value) {
            addCriterion("contract_money >", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("contract_money >=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThan(Float value) {
            addCriterion("contract_money <", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThanOrEqualTo(Float value) {
            addCriterion("contract_money <=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIn(List<Float> values) {
            addCriterion("contract_money in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotIn(List<Float> values) {
            addCriterion("contract_money not in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyBetween(Float value1, Float value2) {
            addCriterion("contract_money between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotBetween(Float value1, Float value2) {
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

        public Criteria andEndMoneyEqualTo(Float value) {
            addCriterion("end_money =", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyNotEqualTo(Float value) {
            addCriterion("end_money <>", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyGreaterThan(Float value) {
            addCriterion("end_money >", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("end_money >=", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyLessThan(Float value) {
            addCriterion("end_money <", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyLessThanOrEqualTo(Float value) {
            addCriterion("end_money <=", value, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyIn(List<Float> values) {
            addCriterion("end_money in", values, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyNotIn(List<Float> values) {
            addCriterion("end_money not in", values, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyBetween(Float value1, Float value2) {
            addCriterion("end_money between", value1, value2, "endMoney");
            return (Criteria) this;
        }

        public Criteria andEndMoneyNotBetween(Float value1, Float value2) {
            addCriterion("end_money not between", value1, value2, "endMoney");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathIsNull() {
            addCriterion("other_file_path is null");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathIsNotNull() {
            addCriterion("other_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathEqualTo(String value) {
            addCriterion("other_file_path =", value, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathNotEqualTo(String value) {
            addCriterion("other_file_path <>", value, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathGreaterThan(String value) {
            addCriterion("other_file_path >", value, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("other_file_path >=", value, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathLessThan(String value) {
            addCriterion("other_file_path <", value, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathLessThanOrEqualTo(String value) {
            addCriterion("other_file_path <=", value, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathLike(String value) {
            addCriterion("other_file_path like", value, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathNotLike(String value) {
            addCriterion("other_file_path not like", value, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathIn(List<String> values) {
            addCriterion("other_file_path in", values, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathNotIn(List<String> values) {
            addCriterion("other_file_path not in", values, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathBetween(String value1, String value2) {
            addCriterion("other_file_path between", value1, value2, "otherFilePath");
            return (Criteria) this;
        }

        public Criteria andOtherFilePathNotBetween(String value1, String value2) {
            addCriterion("other_file_path not between", value1, value2, "otherFilePath");
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