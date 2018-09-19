package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class TaskTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskTableExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTaskListIdIsNull() {
            addCriterion("task_list_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskListIdIsNotNull() {
            addCriterion("task_list_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskListIdEqualTo(String value) {
            addCriterion("task_list_id =", value, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdNotEqualTo(String value) {
            addCriterion("task_list_id <>", value, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdGreaterThan(String value) {
            addCriterion("task_list_id >", value, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_list_id >=", value, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdLessThan(String value) {
            addCriterion("task_list_id <", value, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdLessThanOrEqualTo(String value) {
            addCriterion("task_list_id <=", value, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdLike(String value) {
            addCriterion("task_list_id like", value, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdNotLike(String value) {
            addCriterion("task_list_id not like", value, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdIn(List<String> values) {
            addCriterion("task_list_id in", values, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdNotIn(List<String> values) {
            addCriterion("task_list_id not in", values, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdBetween(String value1, String value2) {
            addCriterion("task_list_id between", value1, value2, "taskListId");
            return (Criteria) this;
        }

        public Criteria andTaskListIdNotBetween(String value1, String value2) {
            addCriterion("task_list_id not between", value1, value2, "taskListId");
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

        public Criteria andPrjOperateModeIsNull() {
            addCriterion("prj_operate_mode is null");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeIsNotNull() {
            addCriterion("prj_operate_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeEqualTo(String value) {
            addCriterion("prj_operate_mode =", value, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeNotEqualTo(String value) {
            addCriterion("prj_operate_mode <>", value, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeGreaterThan(String value) {
            addCriterion("prj_operate_mode >", value, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_operate_mode >=", value, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeLessThan(String value) {
            addCriterion("prj_operate_mode <", value, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeLessThanOrEqualTo(String value) {
            addCriterion("prj_operate_mode <=", value, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeLike(String value) {
            addCriterion("prj_operate_mode like", value, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeNotLike(String value) {
            addCriterion("prj_operate_mode not like", value, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeIn(List<String> values) {
            addCriterion("prj_operate_mode in", values, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeNotIn(List<String> values) {
            addCriterion("prj_operate_mode not in", values, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeBetween(String value1, String value2) {
            addCriterion("prj_operate_mode between", value1, value2, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjOperateModeNotBetween(String value1, String value2) {
            addCriterion("prj_operate_mode not between", value1, value2, "prjOperateMode");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyIsNull() {
            addCriterion("prj_money is null");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyIsNotNull() {
            addCriterion("prj_money is not null");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyEqualTo(String value) {
            addCriterion("prj_money =", value, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyNotEqualTo(String value) {
            addCriterion("prj_money <>", value, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyGreaterThan(String value) {
            addCriterion("prj_money >", value, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("prj_money >=", value, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyLessThan(String value) {
            addCriterion("prj_money <", value, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyLessThanOrEqualTo(String value) {
            addCriterion("prj_money <=", value, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyLike(String value) {
            addCriterion("prj_money like", value, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyNotLike(String value) {
            addCriterion("prj_money not like", value, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyIn(List<String> values) {
            addCriterion("prj_money in", values, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyNotIn(List<String> values) {
            addCriterion("prj_money not in", values, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyBetween(String value1, String value2) {
            addCriterion("prj_money between", value1, value2, "prjMoney");
            return (Criteria) this;
        }

        public Criteria andPrjMoneyNotBetween(String value1, String value2) {
            addCriterion("prj_money not between", value1, value2, "prjMoney");
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

        public Criteria andMainDepartmentIsNull() {
            addCriterion("main_department is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentIsNotNull() {
            addCriterion("main_department is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentEqualTo(String value) {
            addCriterion("main_department =", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentNotEqualTo(String value) {
            addCriterion("main_department <>", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentGreaterThan(String value) {
            addCriterion("main_department >", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("main_department >=", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentLessThan(String value) {
            addCriterion("main_department <", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentLessThanOrEqualTo(String value) {
            addCriterion("main_department <=", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentLike(String value) {
            addCriterion("main_department like", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentNotLike(String value) {
            addCriterion("main_department not like", value, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentIn(List<String> values) {
            addCriterion("main_department in", values, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentNotIn(List<String> values) {
            addCriterion("main_department not in", values, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentBetween(String value1, String value2) {
            addCriterion("main_department between", value1, value2, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentNotBetween(String value1, String value2) {
            addCriterion("main_department not between", value1, value2, "mainDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentIsNull() {
            addCriterion("cooperation_department is null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentIsNotNull() {
            addCriterion("cooperation_department is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentEqualTo(String value) {
            addCriterion("cooperation_department =", value, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentNotEqualTo(String value) {
            addCriterion("cooperation_department <>", value, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentGreaterThan(String value) {
            addCriterion("cooperation_department >", value, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("cooperation_department >=", value, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentLessThan(String value) {
            addCriterion("cooperation_department <", value, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentLessThanOrEqualTo(String value) {
            addCriterion("cooperation_department <=", value, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentLike(String value) {
            addCriterion("cooperation_department like", value, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentNotLike(String value) {
            addCriterion("cooperation_department not like", value, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentIn(List<String> values) {
            addCriterion("cooperation_department in", values, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentNotIn(List<String> values) {
            addCriterion("cooperation_department not in", values, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentBetween(String value1, String value2) {
            addCriterion("cooperation_department between", value1, value2, "cooperationDepartment");
            return (Criteria) this;
        }

        public Criteria andCooperationDepartmentNotBetween(String value1, String value2) {
            addCriterion("cooperation_department not between", value1, value2, "cooperationDepartment");
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

        public Criteria andOwnerDepartmentIsNull() {
            addCriterion("owner_department is null");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentIsNotNull() {
            addCriterion("owner_department is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentEqualTo(String value) {
            addCriterion("owner_department =", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentNotEqualTo(String value) {
            addCriterion("owner_department <>", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentGreaterThan(String value) {
            addCriterion("owner_department >", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("owner_department >=", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentLessThan(String value) {
            addCriterion("owner_department <", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentLessThanOrEqualTo(String value) {
            addCriterion("owner_department <=", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentLike(String value) {
            addCriterion("owner_department like", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentNotLike(String value) {
            addCriterion("owner_department not like", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentIn(List<String> values) {
            addCriterion("owner_department in", values, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentNotIn(List<String> values) {
            addCriterion("owner_department not in", values, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentBetween(String value1, String value2) {
            addCriterion("owner_department between", value1, value2, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentNotBetween(String value1, String value2) {
            addCriterion("owner_department not between", value1, value2, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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