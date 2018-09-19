package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class PrjProgressFillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrjProgressFillExample() {
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

        public Criteria andPpfIdIsNull() {
            addCriterion("ppf_id is null");
            return (Criteria) this;
        }

        public Criteria andPpfIdIsNotNull() {
            addCriterion("ppf_id is not null");
            return (Criteria) this;
        }

        public Criteria andPpfIdEqualTo(String value) {
            addCriterion("ppf_id =", value, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdNotEqualTo(String value) {
            addCriterion("ppf_id <>", value, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdGreaterThan(String value) {
            addCriterion("ppf_id >", value, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdGreaterThanOrEqualTo(String value) {
            addCriterion("ppf_id >=", value, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdLessThan(String value) {
            addCriterion("ppf_id <", value, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdLessThanOrEqualTo(String value) {
            addCriterion("ppf_id <=", value, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdLike(String value) {
            addCriterion("ppf_id like", value, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdNotLike(String value) {
            addCriterion("ppf_id not like", value, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdIn(List<String> values) {
            addCriterion("ppf_id in", values, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdNotIn(List<String> values) {
            addCriterion("ppf_id not in", values, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdBetween(String value1, String value2) {
            addCriterion("ppf_id between", value1, value2, "ppfId");
            return (Criteria) this;
        }

        public Criteria andPpfIdNotBetween(String value1, String value2) {
            addCriterion("ppf_id not between", value1, value2, "ppfId");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeIsNull() {
            addCriterion("produce_task_list_code is null");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeIsNotNull() {
            addCriterion("produce_task_list_code is not null");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeEqualTo(String value) {
            addCriterion("produce_task_list_code =", value, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeNotEqualTo(String value) {
            addCriterion("produce_task_list_code <>", value, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeGreaterThan(String value) {
            addCriterion("produce_task_list_code >", value, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeGreaterThanOrEqualTo(String value) {
            addCriterion("produce_task_list_code >=", value, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeLessThan(String value) {
            addCriterion("produce_task_list_code <", value, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeLessThanOrEqualTo(String value) {
            addCriterion("produce_task_list_code <=", value, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeLike(String value) {
            addCriterion("produce_task_list_code like", value, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeNotLike(String value) {
            addCriterion("produce_task_list_code not like", value, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeIn(List<String> values) {
            addCriterion("produce_task_list_code in", values, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeNotIn(List<String> values) {
            addCriterion("produce_task_list_code not in", values, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeBetween(String value1, String value2) {
            addCriterion("produce_task_list_code between", value1, value2, "produceTaskListCode");
            return (Criteria) this;
        }

        public Criteria andProduceTaskListCodeNotBetween(String value1, String value2) {
            addCriterion("produce_task_list_code not between", value1, value2, "produceTaskListCode");
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

        public Criteria andPrjTypeIsNull() {
            addCriterion("prj_type is null");
            return (Criteria) this;
        }

        public Criteria andPrjTypeIsNotNull() {
            addCriterion("prj_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrjTypeEqualTo(String value) {
            addCriterion("prj_type =", value, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeNotEqualTo(String value) {
            addCriterion("prj_type <>", value, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeGreaterThan(String value) {
            addCriterion("prj_type >", value, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_type >=", value, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeLessThan(String value) {
            addCriterion("prj_type <", value, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeLessThanOrEqualTo(String value) {
            addCriterion("prj_type <=", value, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeLike(String value) {
            addCriterion("prj_type like", value, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeNotLike(String value) {
            addCriterion("prj_type not like", value, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeIn(List<String> values) {
            addCriterion("prj_type in", values, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeNotIn(List<String> values) {
            addCriterion("prj_type not in", values, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeBetween(String value1, String value2) {
            addCriterion("prj_type between", value1, value2, "prjType");
            return (Criteria) this;
        }

        public Criteria andPrjTypeNotBetween(String value1, String value2) {
            addCriterion("prj_type not between", value1, value2, "prjType");
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

        public Criteria andEstimateContractMoneyIsNull() {
            addCriterion("estimate_contract_money is null");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyIsNotNull() {
            addCriterion("estimate_contract_money is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyEqualTo(String value) {
            addCriterion("estimate_contract_money =", value, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyNotEqualTo(String value) {
            addCriterion("estimate_contract_money <>", value, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyGreaterThan(String value) {
            addCriterion("estimate_contract_money >", value, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("estimate_contract_money >=", value, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyLessThan(String value) {
            addCriterion("estimate_contract_money <", value, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyLessThanOrEqualTo(String value) {
            addCriterion("estimate_contract_money <=", value, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyLike(String value) {
            addCriterion("estimate_contract_money like", value, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyNotLike(String value) {
            addCriterion("estimate_contract_money not like", value, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyIn(List<String> values) {
            addCriterion("estimate_contract_money in", values, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyNotIn(List<String> values) {
            addCriterion("estimate_contract_money not in", values, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyBetween(String value1, String value2) {
            addCriterion("estimate_contract_money between", value1, value2, "estimateContractMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateContractMoneyNotBetween(String value1, String value2) {
            addCriterion("estimate_contract_money not between", value1, value2, "estimateContractMoney");
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

        public Criteria andTemporaryMoneyEqualTo(String value) {
            addCriterion("temporary_money =", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyNotEqualTo(String value) {
            addCriterion("temporary_money <>", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyGreaterThan(String value) {
            addCriterion("temporary_money >", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("temporary_money >=", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyLessThan(String value) {
            addCriterion("temporary_money <", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyLessThanOrEqualTo(String value) {
            addCriterion("temporary_money <=", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyLike(String value) {
            addCriterion("temporary_money like", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyNotLike(String value) {
            addCriterion("temporary_money not like", value, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyIn(List<String> values) {
            addCriterion("temporary_money in", values, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyNotIn(List<String> values) {
            addCriterion("temporary_money not in", values, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyBetween(String value1, String value2) {
            addCriterion("temporary_money between", value1, value2, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andTemporaryMoneyNotBetween(String value1, String value2) {
            addCriterion("temporary_money not between", value1, value2, "temporaryMoney");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeIsNull() {
            addCriterion("prj_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeIsNotNull() {
            addCriterion("prj_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeEqualTo(String value) {
            addCriterion("prj_start_time =", value, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeNotEqualTo(String value) {
            addCriterion("prj_start_time <>", value, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeGreaterThan(String value) {
            addCriterion("prj_start_time >", value, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_start_time >=", value, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeLessThan(String value) {
            addCriterion("prj_start_time <", value, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeLessThanOrEqualTo(String value) {
            addCriterion("prj_start_time <=", value, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeLike(String value) {
            addCriterion("prj_start_time like", value, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeNotLike(String value) {
            addCriterion("prj_start_time not like", value, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeIn(List<String> values) {
            addCriterion("prj_start_time in", values, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeNotIn(List<String> values) {
            addCriterion("prj_start_time not in", values, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeBetween(String value1, String value2) {
            addCriterion("prj_start_time between", value1, value2, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjStartTimeNotBetween(String value1, String value2) {
            addCriterion("prj_start_time not between", value1, value2, "prjStartTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeIsNull() {
            addCriterion("prj_estimate_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeIsNotNull() {
            addCriterion("prj_estimate_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeEqualTo(String value) {
            addCriterion("prj_estimate_end_time =", value, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeNotEqualTo(String value) {
            addCriterion("prj_estimate_end_time <>", value, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeGreaterThan(String value) {
            addCriterion("prj_estimate_end_time >", value, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_estimate_end_time >=", value, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeLessThan(String value) {
            addCriterion("prj_estimate_end_time <", value, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeLessThanOrEqualTo(String value) {
            addCriterion("prj_estimate_end_time <=", value, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeLike(String value) {
            addCriterion("prj_estimate_end_time like", value, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeNotLike(String value) {
            addCriterion("prj_estimate_end_time not like", value, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeIn(List<String> values) {
            addCriterion("prj_estimate_end_time in", values, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeNotIn(List<String> values) {
            addCriterion("prj_estimate_end_time not in", values, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeBetween(String value1, String value2) {
            addCriterion("prj_estimate_end_time between", value1, value2, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateEndTimeNotBetween(String value1, String value2) {
            addCriterion("prj_estimate_end_time not between", value1, value2, "prjEstimateEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonIsNull() {
            addCriterion("prj_charge_person is null");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonIsNotNull() {
            addCriterion("prj_charge_person is not null");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonEqualTo(String value) {
            addCriterion("prj_charge_person =", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonNotEqualTo(String value) {
            addCriterion("prj_charge_person <>", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonGreaterThan(String value) {
            addCriterion("prj_charge_person >", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonGreaterThanOrEqualTo(String value) {
            addCriterion("prj_charge_person >=", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonLessThan(String value) {
            addCriterion("prj_charge_person <", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonLessThanOrEqualTo(String value) {
            addCriterion("prj_charge_person <=", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonLike(String value) {
            addCriterion("prj_charge_person like", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonNotLike(String value) {
            addCriterion("prj_charge_person not like", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonIn(List<String> values) {
            addCriterion("prj_charge_person in", values, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonNotIn(List<String> values) {
            addCriterion("prj_charge_person not in", values, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonBetween(String value1, String value2) {
            addCriterion("prj_charge_person between", value1, value2, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonNotBetween(String value1, String value2) {
            addCriterion("prj_charge_person not between", value1, value2, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyIsNull() {
            addCriterion("estimate_all_money is null");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyIsNotNull() {
            addCriterion("estimate_all_money is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyEqualTo(String value) {
            addCriterion("estimate_all_money =", value, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyNotEqualTo(String value) {
            addCriterion("estimate_all_money <>", value, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyGreaterThan(String value) {
            addCriterion("estimate_all_money >", value, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("estimate_all_money >=", value, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyLessThan(String value) {
            addCriterion("estimate_all_money <", value, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyLessThanOrEqualTo(String value) {
            addCriterion("estimate_all_money <=", value, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyLike(String value) {
            addCriterion("estimate_all_money like", value, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyNotLike(String value) {
            addCriterion("estimate_all_money not like", value, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyIn(List<String> values) {
            addCriterion("estimate_all_money in", values, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyNotIn(List<String> values) {
            addCriterion("estimate_all_money not in", values, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyBetween(String value1, String value2) {
            addCriterion("estimate_all_money between", value1, value2, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andEstimateAllMoneyNotBetween(String value1, String value2) {
            addCriterion("estimate_all_money not between", value1, value2, "estimateAllMoney");
            return (Criteria) this;
        }

        public Criteria andThisTimeIsNull() {
            addCriterion("this_time is null");
            return (Criteria) this;
        }

        public Criteria andThisTimeIsNotNull() {
            addCriterion("this_time is not null");
            return (Criteria) this;
        }

        public Criteria andThisTimeEqualTo(String value) {
            addCriterion("this_time =", value, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeNotEqualTo(String value) {
            addCriterion("this_time <>", value, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeGreaterThan(String value) {
            addCriterion("this_time >", value, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeGreaterThanOrEqualTo(String value) {
            addCriterion("this_time >=", value, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeLessThan(String value) {
            addCriterion("this_time <", value, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeLessThanOrEqualTo(String value) {
            addCriterion("this_time <=", value, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeLike(String value) {
            addCriterion("this_time like", value, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeNotLike(String value) {
            addCriterion("this_time not like", value, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeIn(List<String> values) {
            addCriterion("this_time in", values, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeNotIn(List<String> values) {
            addCriterion("this_time not in", values, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeBetween(String value1, String value2) {
            addCriterion("this_time between", value1, value2, "thisTime");
            return (Criteria) this;
        }

        public Criteria andThisTimeNotBetween(String value1, String value2) {
            addCriterion("this_time not between", value1, value2, "thisTime");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyIsNull() {
            addCriterion("main_depart_this_time_rec_money is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyIsNotNull() {
            addCriterion("main_depart_this_time_rec_money is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyEqualTo(String value) {
            addCriterion("main_depart_this_time_rec_money =", value, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyNotEqualTo(String value) {
            addCriterion("main_depart_this_time_rec_money <>", value, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyGreaterThan(String value) {
            addCriterion("main_depart_this_time_rec_money >", value, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("main_depart_this_time_rec_money >=", value, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyLessThan(String value) {
            addCriterion("main_depart_this_time_rec_money <", value, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyLessThanOrEqualTo(String value) {
            addCriterion("main_depart_this_time_rec_money <=", value, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyLike(String value) {
            addCriterion("main_depart_this_time_rec_money like", value, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyNotLike(String value) {
            addCriterion("main_depart_this_time_rec_money not like", value, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyIn(List<String> values) {
            addCriterion("main_depart_this_time_rec_money in", values, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyNotIn(List<String> values) {
            addCriterion("main_depart_this_time_rec_money not in", values, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyBetween(String value1, String value2) {
            addCriterion("main_depart_this_time_rec_money between", value1, value2, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyNotBetween(String value1, String value2) {
            addCriterion("main_depart_this_time_rec_money not between", value1, value2, "mainDepartThisTimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileIsNull() {
            addCriterion("main_depart_this_time_rec_money_otherfile is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileIsNotNull() {
            addCriterion("main_depart_this_time_rec_money_otherfile is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileEqualTo(String value) {
            addCriterion("main_depart_this_time_rec_money_otherfile =", value, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileNotEqualTo(String value) {
            addCriterion("main_depart_this_time_rec_money_otherfile <>", value, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileGreaterThan(String value) {
            addCriterion("main_depart_this_time_rec_money_otherfile >", value, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileGreaterThanOrEqualTo(String value) {
            addCriterion("main_depart_this_time_rec_money_otherfile >=", value, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileLessThan(String value) {
            addCriterion("main_depart_this_time_rec_money_otherfile <", value, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileLessThanOrEqualTo(String value) {
            addCriterion("main_depart_this_time_rec_money_otherfile <=", value, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileLike(String value) {
            addCriterion("main_depart_this_time_rec_money_otherfile like", value, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileNotLike(String value) {
            addCriterion("main_depart_this_time_rec_money_otherfile not like", value, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileIn(List<String> values) {
            addCriterion("main_depart_this_time_rec_money_otherfile in", values, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileNotIn(List<String> values) {
            addCriterion("main_depart_this_time_rec_money_otherfile not in", values, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileBetween(String value1, String value2) {
            addCriterion("main_depart_this_time_rec_money_otherfile between", value1, value2, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andMainDepartThisTimeRecMoneyOtherfileNotBetween(String value1, String value2) {
            addCriterion("main_depart_this_time_rec_money_otherfile not between", value1, value2, "mainDepartThisTimeRecMoneyOtherfile");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyIsNull() {
            addCriterion("cooperation_thistime_rec_money is null");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyIsNotNull() {
            addCriterion("cooperation_thistime_rec_money is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyEqualTo(String value) {
            addCriterion("cooperation_thistime_rec_money =", value, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyNotEqualTo(String value) {
            addCriterion("cooperation_thistime_rec_money <>", value, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyGreaterThan(String value) {
            addCriterion("cooperation_thistime_rec_money >", value, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("cooperation_thistime_rec_money >=", value, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyLessThan(String value) {
            addCriterion("cooperation_thistime_rec_money <", value, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyLessThanOrEqualTo(String value) {
            addCriterion("cooperation_thistime_rec_money <=", value, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyLike(String value) {
            addCriterion("cooperation_thistime_rec_money like", value, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyNotLike(String value) {
            addCriterion("cooperation_thistime_rec_money not like", value, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyIn(List<String> values) {
            addCriterion("cooperation_thistime_rec_money in", values, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyNotIn(List<String> values) {
            addCriterion("cooperation_thistime_rec_money not in", values, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyBetween(String value1, String value2) {
            addCriterion("cooperation_thistime_rec_money between", value1, value2, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationThistimeRecMoneyNotBetween(String value1, String value2) {
            addCriterion("cooperation_thistime_rec_money not between", value1, value2, "cooperationThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisIsNull() {
            addCriterion("main_depart_all_rec_money_outhis is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisIsNotNull() {
            addCriterion("main_depart_all_rec_money_outhis is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisEqualTo(String value) {
            addCriterion("main_depart_all_rec_money_outhis =", value, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisNotEqualTo(String value) {
            addCriterion("main_depart_all_rec_money_outhis <>", value, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisGreaterThan(String value) {
            addCriterion("main_depart_all_rec_money_outhis >", value, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisGreaterThanOrEqualTo(String value) {
            addCriterion("main_depart_all_rec_money_outhis >=", value, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisLessThan(String value) {
            addCriterion("main_depart_all_rec_money_outhis <", value, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisLessThanOrEqualTo(String value) {
            addCriterion("main_depart_all_rec_money_outhis <=", value, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisLike(String value) {
            addCriterion("main_depart_all_rec_money_outhis like", value, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisNotLike(String value) {
            addCriterion("main_depart_all_rec_money_outhis not like", value, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisIn(List<String> values) {
            addCriterion("main_depart_all_rec_money_outhis in", values, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisNotIn(List<String> values) {
            addCriterion("main_depart_all_rec_money_outhis not in", values, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisBetween(String value1, String value2) {
            addCriterion("main_depart_all_rec_money_outhis between", value1, value2, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyOuthisNotBetween(String value1, String value2) {
            addCriterion("main_depart_all_rec_money_outhis not between", value1, value2, "mainDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisIsNull() {
            addCriterion("cooperation_depart_all_rec_money_outhis is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisIsNotNull() {
            addCriterion("cooperation_depart_all_rec_money_outhis is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisEqualTo(String value) {
            addCriterion("cooperation_depart_all_rec_money_outhis =", value, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisNotEqualTo(String value) {
            addCriterion("cooperation_depart_all_rec_money_outhis <>", value, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisGreaterThan(String value) {
            addCriterion("cooperation_depart_all_rec_money_outhis >", value, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisGreaterThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_all_rec_money_outhis >=", value, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisLessThan(String value) {
            addCriterion("cooperation_depart_all_rec_money_outhis <", value, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisLessThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_all_rec_money_outhis <=", value, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisLike(String value) {
            addCriterion("cooperation_depart_all_rec_money_outhis like", value, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisNotLike(String value) {
            addCriterion("cooperation_depart_all_rec_money_outhis not like", value, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisIn(List<String> values) {
            addCriterion("cooperation_depart_all_rec_money_outhis in", values, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisNotIn(List<String> values) {
            addCriterion("cooperation_depart_all_rec_money_outhis not in", values, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisBetween(String value1, String value2) {
            addCriterion("cooperation_depart_all_rec_money_outhis between", value1, value2, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyOuthisNotBetween(String value1, String value2) {
            addCriterion("cooperation_depart_all_rec_money_outhis not between", value1, value2, "cooperationDepartAllRecMoneyOuthis");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyIsNull() {
            addCriterion("main_depart_thistime_rec_money is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyIsNotNull() {
            addCriterion("main_depart_thistime_rec_money is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyEqualTo(String value) {
            addCriterion("main_depart_thistime_rec_money =", value, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyNotEqualTo(String value) {
            addCriterion("main_depart_thistime_rec_money <>", value, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyGreaterThan(String value) {
            addCriterion("main_depart_thistime_rec_money >", value, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("main_depart_thistime_rec_money >=", value, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyLessThan(String value) {
            addCriterion("main_depart_thistime_rec_money <", value, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyLessThanOrEqualTo(String value) {
            addCriterion("main_depart_thistime_rec_money <=", value, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyLike(String value) {
            addCriterion("main_depart_thistime_rec_money like", value, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyNotLike(String value) {
            addCriterion("main_depart_thistime_rec_money not like", value, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyIn(List<String> values) {
            addCriterion("main_depart_thistime_rec_money in", values, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyNotIn(List<String> values) {
            addCriterion("main_depart_thistime_rec_money not in", values, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyBetween(String value1, String value2) {
            addCriterion("main_depart_thistime_rec_money between", value1, value2, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeRecMoneyNotBetween(String value1, String value2) {
            addCriterion("main_depart_thistime_rec_money not between", value1, value2, "mainDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyIsNull() {
            addCriterion("cooperation_depart_thistime_rec_money is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyIsNotNull() {
            addCriterion("cooperation_depart_thistime_rec_money is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyEqualTo(String value) {
            addCriterion("cooperation_depart_thistime_rec_money =", value, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyNotEqualTo(String value) {
            addCriterion("cooperation_depart_thistime_rec_money <>", value, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyGreaterThan(String value) {
            addCriterion("cooperation_depart_thistime_rec_money >", value, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_thistime_rec_money >=", value, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyLessThan(String value) {
            addCriterion("cooperation_depart_thistime_rec_money <", value, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyLessThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_thistime_rec_money <=", value, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyLike(String value) {
            addCriterion("cooperation_depart_thistime_rec_money like", value, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyNotLike(String value) {
            addCriterion("cooperation_depart_thistime_rec_money not like", value, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyIn(List<String> values) {
            addCriterion("cooperation_depart_thistime_rec_money in", values, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyNotIn(List<String> values) {
            addCriterion("cooperation_depart_thistime_rec_money not in", values, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyBetween(String value1, String value2) {
            addCriterion("cooperation_depart_thistime_rec_money between", value1, value2, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeRecMoneyNotBetween(String value1, String value2) {
            addCriterion("cooperation_depart_thistime_rec_money not between", value1, value2, "cooperationDepartThistimeRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyIsNull() {
            addCriterion("main_depart_all_rec_money is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyIsNotNull() {
            addCriterion("main_depart_all_rec_money is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyEqualTo(String value) {
            addCriterion("main_depart_all_rec_money =", value, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyNotEqualTo(String value) {
            addCriterion("main_depart_all_rec_money <>", value, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyGreaterThan(String value) {
            addCriterion("main_depart_all_rec_money >", value, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("main_depart_all_rec_money >=", value, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyLessThan(String value) {
            addCriterion("main_depart_all_rec_money <", value, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyLessThanOrEqualTo(String value) {
            addCriterion("main_depart_all_rec_money <=", value, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyLike(String value) {
            addCriterion("main_depart_all_rec_money like", value, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyNotLike(String value) {
            addCriterion("main_depart_all_rec_money not like", value, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyIn(List<String> values) {
            addCriterion("main_depart_all_rec_money in", values, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyNotIn(List<String> values) {
            addCriterion("main_depart_all_rec_money not in", values, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyBetween(String value1, String value2) {
            addCriterion("main_depart_all_rec_money between", value1, value2, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllRecMoneyNotBetween(String value1, String value2) {
            addCriterion("main_depart_all_rec_money not between", value1, value2, "mainDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyIsNull() {
            addCriterion("cooperation_depart_all_rec_money is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyIsNotNull() {
            addCriterion("cooperation_depart_all_rec_money is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyEqualTo(String value) {
            addCriterion("cooperation_depart_all_rec_money =", value, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyNotEqualTo(String value) {
            addCriterion("cooperation_depart_all_rec_money <>", value, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyGreaterThan(String value) {
            addCriterion("cooperation_depart_all_rec_money >", value, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_all_rec_money >=", value, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyLessThan(String value) {
            addCriterion("cooperation_depart_all_rec_money <", value, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyLessThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_all_rec_money <=", value, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyLike(String value) {
            addCriterion("cooperation_depart_all_rec_money like", value, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyNotLike(String value) {
            addCriterion("cooperation_depart_all_rec_money not like", value, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyIn(List<String> values) {
            addCriterion("cooperation_depart_all_rec_money in", values, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyNotIn(List<String> values) {
            addCriterion("cooperation_depart_all_rec_money not in", values, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyBetween(String value1, String value2) {
            addCriterion("cooperation_depart_all_rec_money between", value1, value2, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllRecMoneyNotBetween(String value1, String value2) {
            addCriterion("cooperation_depart_all_rec_money not between", value1, value2, "cooperationDepartAllRecMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostIsNull() {
            addCriterion("main_depart_thistime_cost is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostIsNotNull() {
            addCriterion("main_depart_thistime_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostEqualTo(String value) {
            addCriterion("main_depart_thistime_cost =", value, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostNotEqualTo(String value) {
            addCriterion("main_depart_thistime_cost <>", value, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostGreaterThan(String value) {
            addCriterion("main_depart_thistime_cost >", value, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostGreaterThanOrEqualTo(String value) {
            addCriterion("main_depart_thistime_cost >=", value, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostLessThan(String value) {
            addCriterion("main_depart_thistime_cost <", value, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostLessThanOrEqualTo(String value) {
            addCriterion("main_depart_thistime_cost <=", value, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostLike(String value) {
            addCriterion("main_depart_thistime_cost like", value, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostNotLike(String value) {
            addCriterion("main_depart_thistime_cost not like", value, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostIn(List<String> values) {
            addCriterion("main_depart_thistime_cost in", values, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostNotIn(List<String> values) {
            addCriterion("main_depart_thistime_cost not in", values, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostBetween(String value1, String value2) {
            addCriterion("main_depart_thistime_cost between", value1, value2, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartThistimeCostNotBetween(String value1, String value2) {
            addCriterion("main_depart_thistime_cost not between", value1, value2, "mainDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostIsNull() {
            addCriterion("main_depart_all_cost is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostIsNotNull() {
            addCriterion("main_depart_all_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostEqualTo(String value) {
            addCriterion("main_depart_all_cost =", value, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostNotEqualTo(String value) {
            addCriterion("main_depart_all_cost <>", value, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostGreaterThan(String value) {
            addCriterion("main_depart_all_cost >", value, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostGreaterThanOrEqualTo(String value) {
            addCriterion("main_depart_all_cost >=", value, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostLessThan(String value) {
            addCriterion("main_depart_all_cost <", value, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostLessThanOrEqualTo(String value) {
            addCriterion("main_depart_all_cost <=", value, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostLike(String value) {
            addCriterion("main_depart_all_cost like", value, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostNotLike(String value) {
            addCriterion("main_depart_all_cost not like", value, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostIn(List<String> values) {
            addCriterion("main_depart_all_cost in", values, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostNotIn(List<String> values) {
            addCriterion("main_depart_all_cost not in", values, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostBetween(String value1, String value2) {
            addCriterion("main_depart_all_cost between", value1, value2, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andMainDepartAllCostNotBetween(String value1, String value2) {
            addCriterion("main_depart_all_cost not between", value1, value2, "mainDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostIsNull() {
            addCriterion("cooperation_depart_thistime_cost is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostIsNotNull() {
            addCriterion("cooperation_depart_thistime_cost is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostEqualTo(String value) {
            addCriterion("cooperation_depart_thistime_cost =", value, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostNotEqualTo(String value) {
            addCriterion("cooperation_depart_thistime_cost <>", value, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostGreaterThan(String value) {
            addCriterion("cooperation_depart_thistime_cost >", value, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostGreaterThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_thistime_cost >=", value, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostLessThan(String value) {
            addCriterion("cooperation_depart_thistime_cost <", value, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostLessThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_thistime_cost <=", value, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostLike(String value) {
            addCriterion("cooperation_depart_thistime_cost like", value, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostNotLike(String value) {
            addCriterion("cooperation_depart_thistime_cost not like", value, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostIn(List<String> values) {
            addCriterion("cooperation_depart_thistime_cost in", values, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostNotIn(List<String> values) {
            addCriterion("cooperation_depart_thistime_cost not in", values, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostBetween(String value1, String value2) {
            addCriterion("cooperation_depart_thistime_cost between", value1, value2, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartThistimeCostNotBetween(String value1, String value2) {
            addCriterion("cooperation_depart_thistime_cost not between", value1, value2, "cooperationDepartThistimeCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostIsNull() {
            addCriterion("cooperation_depart_all_cost is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostIsNotNull() {
            addCriterion("cooperation_depart_all_cost is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostEqualTo(String value) {
            addCriterion("cooperation_depart_all_cost =", value, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostNotEqualTo(String value) {
            addCriterion("cooperation_depart_all_cost <>", value, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostGreaterThan(String value) {
            addCriterion("cooperation_depart_all_cost >", value, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostGreaterThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_all_cost >=", value, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostLessThan(String value) {
            addCriterion("cooperation_depart_all_cost <", value, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostLessThanOrEqualTo(String value) {
            addCriterion("cooperation_depart_all_cost <=", value, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostLike(String value) {
            addCriterion("cooperation_depart_all_cost like", value, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostNotLike(String value) {
            addCriterion("cooperation_depart_all_cost not like", value, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostIn(List<String> values) {
            addCriterion("cooperation_depart_all_cost in", values, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostNotIn(List<String> values) {
            addCriterion("cooperation_depart_all_cost not in", values, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostBetween(String value1, String value2) {
            addCriterion("cooperation_depart_all_cost between", value1, value2, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartAllCostNotBetween(String value1, String value2) {
            addCriterion("cooperation_depart_all_cost not between", value1, value2, "cooperationDepartAllCost");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyIsNull() {
            addCriterion("all_rec_money is null");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyIsNotNull() {
            addCriterion("all_rec_money is not null");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyEqualTo(String value) {
            addCriterion("all_rec_money =", value, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyNotEqualTo(String value) {
            addCriterion("all_rec_money <>", value, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyGreaterThan(String value) {
            addCriterion("all_rec_money >", value, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("all_rec_money >=", value, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyLessThan(String value) {
            addCriterion("all_rec_money <", value, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyLessThanOrEqualTo(String value) {
            addCriterion("all_rec_money <=", value, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyLike(String value) {
            addCriterion("all_rec_money like", value, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyNotLike(String value) {
            addCriterion("all_rec_money not like", value, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyIn(List<String> values) {
            addCriterion("all_rec_money in", values, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyNotIn(List<String> values) {
            addCriterion("all_rec_money not in", values, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyBetween(String value1, String value2) {
            addCriterion("all_rec_money between", value1, value2, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllRecMoneyNotBetween(String value1, String value2) {
            addCriterion("all_rec_money not between", value1, value2, "allRecMoney");
            return (Criteria) this;
        }

        public Criteria andAllCostIsNull() {
            addCriterion("all_cost is null");
            return (Criteria) this;
        }

        public Criteria andAllCostIsNotNull() {
            addCriterion("all_cost is not null");
            return (Criteria) this;
        }

        public Criteria andAllCostEqualTo(String value) {
            addCriterion("all_cost =", value, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostNotEqualTo(String value) {
            addCriterion("all_cost <>", value, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostGreaterThan(String value) {
            addCriterion("all_cost >", value, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostGreaterThanOrEqualTo(String value) {
            addCriterion("all_cost >=", value, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostLessThan(String value) {
            addCriterion("all_cost <", value, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostLessThanOrEqualTo(String value) {
            addCriterion("all_cost <=", value, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostLike(String value) {
            addCriterion("all_cost like", value, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostNotLike(String value) {
            addCriterion("all_cost not like", value, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostIn(List<String> values) {
            addCriterion("all_cost in", values, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostNotIn(List<String> values) {
            addCriterion("all_cost not in", values, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostBetween(String value1, String value2) {
            addCriterion("all_cost between", value1, value2, "allCost");
            return (Criteria) this;
        }

        public Criteria andAllCostNotBetween(String value1, String value2) {
            addCriterion("all_cost not between", value1, value2, "allCost");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathIsNull() {
            addCriterion("progress_otherfile_path is null");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathIsNotNull() {
            addCriterion("progress_otherfile_path is not null");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathEqualTo(String value) {
            addCriterion("progress_otherfile_path =", value, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathNotEqualTo(String value) {
            addCriterion("progress_otherfile_path <>", value, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathGreaterThan(String value) {
            addCriterion("progress_otherfile_path >", value, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathGreaterThanOrEqualTo(String value) {
            addCriterion("progress_otherfile_path >=", value, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathLessThan(String value) {
            addCriterion("progress_otherfile_path <", value, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathLessThanOrEqualTo(String value) {
            addCriterion("progress_otherfile_path <=", value, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathLike(String value) {
            addCriterion("progress_otherfile_path like", value, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathNotLike(String value) {
            addCriterion("progress_otherfile_path not like", value, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathIn(List<String> values) {
            addCriterion("progress_otherfile_path in", values, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathNotIn(List<String> values) {
            addCriterion("progress_otherfile_path not in", values, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathBetween(String value1, String value2) {
            addCriterion("progress_otherfile_path between", value1, value2, "progressOtherfilePath");
            return (Criteria) this;
        }

        public Criteria andProgressOtherfilePathNotBetween(String value1, String value2) {
            addCriterion("progress_otherfile_path not between", value1, value2, "progressOtherfilePath");
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