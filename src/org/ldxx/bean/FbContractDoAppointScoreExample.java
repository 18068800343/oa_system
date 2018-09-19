package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class FbContractDoAppointScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbContractDoAppointScoreExample() {
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

        public Criteria andFcdIdIsNull() {
            addCriterion("fcd_id is null");
            return (Criteria) this;
        }

        public Criteria andFcdIdIsNotNull() {
            addCriterion("fcd_id is not null");
            return (Criteria) this;
        }

        public Criteria andFcdIdEqualTo(String value) {
            addCriterion("fcd_id =", value, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdNotEqualTo(String value) {
            addCriterion("fcd_id <>", value, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdGreaterThan(String value) {
            addCriterion("fcd_id >", value, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdGreaterThanOrEqualTo(String value) {
            addCriterion("fcd_id >=", value, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdLessThan(String value) {
            addCriterion("fcd_id <", value, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdLessThanOrEqualTo(String value) {
            addCriterion("fcd_id <=", value, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdLike(String value) {
            addCriterion("fcd_id like", value, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdNotLike(String value) {
            addCriterion("fcd_id not like", value, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdIn(List<String> values) {
            addCriterion("fcd_id in", values, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdNotIn(List<String> values) {
            addCriterion("fcd_id not in", values, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdBetween(String value1, String value2) {
            addCriterion("fcd_id between", value1, value2, "fcdId");
            return (Criteria) this;
        }

        public Criteria andFcdIdNotBetween(String value1, String value2) {
            addCriterion("fcd_id not between", value1, value2, "fcdId");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeIsNull() {
            addCriterion("task_list_code is null");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeIsNotNull() {
            addCriterion("task_list_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeEqualTo(String value) {
            addCriterion("task_list_code =", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeNotEqualTo(String value) {
            addCriterion("task_list_code <>", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeGreaterThan(String value) {
            addCriterion("task_list_code >", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeGreaterThanOrEqualTo(String value) {
            addCriterion("task_list_code >=", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeLessThan(String value) {
            addCriterion("task_list_code <", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeLessThanOrEqualTo(String value) {
            addCriterion("task_list_code <=", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeLike(String value) {
            addCriterion("task_list_code like", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeNotLike(String value) {
            addCriterion("task_list_code not like", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeIn(List<String> values) {
            addCriterion("task_list_code in", values, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeNotIn(List<String> values) {
            addCriterion("task_list_code not in", values, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeBetween(String value1, String value2) {
            addCriterion("task_list_code between", value1, value2, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeNotBetween(String value1, String value2) {
            addCriterion("task_list_code not between", value1, value2, "taskListCode");
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

        public Criteria andFbContractCodeIsNull() {
            addCriterion("fb_contract_code is null");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeIsNotNull() {
            addCriterion("fb_contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeEqualTo(String value) {
            addCriterion("fb_contract_code =", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeNotEqualTo(String value) {
            addCriterion("fb_contract_code <>", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeGreaterThan(String value) {
            addCriterion("fb_contract_code >", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fb_contract_code >=", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeLessThan(String value) {
            addCriterion("fb_contract_code <", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeLessThanOrEqualTo(String value) {
            addCriterion("fb_contract_code <=", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeLike(String value) {
            addCriterion("fb_contract_code like", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeNotLike(String value) {
            addCriterion("fb_contract_code not like", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeIn(List<String> values) {
            addCriterion("fb_contract_code in", values, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeNotIn(List<String> values) {
            addCriterion("fb_contract_code not in", values, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeBetween(String value1, String value2) {
            addCriterion("fb_contract_code between", value1, value2, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeNotBetween(String value1, String value2) {
            addCriterion("fb_contract_code not between", value1, value2, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractNameIsNull() {
            addCriterion("fb_contract_name is null");
            return (Criteria) this;
        }

        public Criteria andFbContractNameIsNotNull() {
            addCriterion("fb_contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andFbContractNameEqualTo(String value) {
            addCriterion("fb_contract_name =", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameNotEqualTo(String value) {
            addCriterion("fb_contract_name <>", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameGreaterThan(String value) {
            addCriterion("fb_contract_name >", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("fb_contract_name >=", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameLessThan(String value) {
            addCriterion("fb_contract_name <", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameLessThanOrEqualTo(String value) {
            addCriterion("fb_contract_name <=", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameLike(String value) {
            addCriterion("fb_contract_name like", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameNotLike(String value) {
            addCriterion("fb_contract_name not like", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameIn(List<String> values) {
            addCriterion("fb_contract_name in", values, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameNotIn(List<String> values) {
            addCriterion("fb_contract_name not in", values, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameBetween(String value1, String value2) {
            addCriterion("fb_contract_name between", value1, value2, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameNotBetween(String value1, String value2) {
            addCriterion("fb_contract_name not between", value1, value2, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentIsNull() {
            addCriterion("fb_department is null");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentIsNotNull() {
            addCriterion("fb_department is not null");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentEqualTo(String value) {
            addCriterion("fb_department =", value, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentNotEqualTo(String value) {
            addCriterion("fb_department <>", value, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentGreaterThan(String value) {
            addCriterion("fb_department >", value, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("fb_department >=", value, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentLessThan(String value) {
            addCriterion("fb_department <", value, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentLessThanOrEqualTo(String value) {
            addCriterion("fb_department <=", value, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentLike(String value) {
            addCriterion("fb_department like", value, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentNotLike(String value) {
            addCriterion("fb_department not like", value, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentIn(List<String> values) {
            addCriterion("fb_department in", values, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentNotIn(List<String> values) {
            addCriterion("fb_department not in", values, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentBetween(String value1, String value2) {
            addCriterion("fb_department between", value1, value2, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andFbDepartmentNotBetween(String value1, String value2) {
            addCriterion("fb_department not between", value1, value2, "fbDepartment");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonIsNull() {
            addCriterion("actual_charge_person is null");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonIsNotNull() {
            addCriterion("actual_charge_person is not null");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonEqualTo(String value) {
            addCriterion("actual_charge_person =", value, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonNotEqualTo(String value) {
            addCriterion("actual_charge_person <>", value, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonGreaterThan(String value) {
            addCriterion("actual_charge_person >", value, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonGreaterThanOrEqualTo(String value) {
            addCriterion("actual_charge_person >=", value, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonLessThan(String value) {
            addCriterion("actual_charge_person <", value, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonLessThanOrEqualTo(String value) {
            addCriterion("actual_charge_person <=", value, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonLike(String value) {
            addCriterion("actual_charge_person like", value, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonNotLike(String value) {
            addCriterion("actual_charge_person not like", value, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonIn(List<String> values) {
            addCriterion("actual_charge_person in", values, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonNotIn(List<String> values) {
            addCriterion("actual_charge_person not in", values, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonBetween(String value1, String value2) {
            addCriterion("actual_charge_person between", value1, value2, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andActualChargePersonNotBetween(String value1, String value2) {
            addCriterion("actual_charge_person not between", value1, value2, "actualChargePerson");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationIsNull() {
            addCriterion("score_material_situation is null");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationIsNotNull() {
            addCriterion("score_material_situation is not null");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationEqualTo(String value) {
            addCriterion("score_material_situation =", value, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationNotEqualTo(String value) {
            addCriterion("score_material_situation <>", value, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationGreaterThan(String value) {
            addCriterion("score_material_situation >", value, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationGreaterThanOrEqualTo(String value) {
            addCriterion("score_material_situation >=", value, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationLessThan(String value) {
            addCriterion("score_material_situation <", value, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationLessThanOrEqualTo(String value) {
            addCriterion("score_material_situation <=", value, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationLike(String value) {
            addCriterion("score_material_situation like", value, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationNotLike(String value) {
            addCriterion("score_material_situation not like", value, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationIn(List<String> values) {
            addCriterion("score_material_situation in", values, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationNotIn(List<String> values) {
            addCriterion("score_material_situation not in", values, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationBetween(String value1, String value2) {
            addCriterion("score_material_situation between", value1, value2, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreMaterialSituationNotBetween(String value1, String value2) {
            addCriterion("score_material_situation not between", value1, value2, "scoreMaterialSituation");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityIsNull() {
            addCriterion("score_manage_ability is null");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityIsNotNull() {
            addCriterion("score_manage_ability is not null");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityEqualTo(String value) {
            addCriterion("score_manage_ability =", value, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityNotEqualTo(String value) {
            addCriterion("score_manage_ability <>", value, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityGreaterThan(String value) {
            addCriterion("score_manage_ability >", value, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityGreaterThanOrEqualTo(String value) {
            addCriterion("score_manage_ability >=", value, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityLessThan(String value) {
            addCriterion("score_manage_ability <", value, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityLessThanOrEqualTo(String value) {
            addCriterion("score_manage_ability <=", value, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityLike(String value) {
            addCriterion("score_manage_ability like", value, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityNotLike(String value) {
            addCriterion("score_manage_ability not like", value, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityIn(List<String> values) {
            addCriterion("score_manage_ability in", values, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityNotIn(List<String> values) {
            addCriterion("score_manage_ability not in", values, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityBetween(String value1, String value2) {
            addCriterion("score_manage_ability between", value1, value2, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreManageAbilityNotBetween(String value1, String value2) {
            addCriterion("score_manage_ability not between", value1, value2, "scoreManageAbility");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlIsNull() {
            addCriterion("score_quality_control is null");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlIsNotNull() {
            addCriterion("score_quality_control is not null");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlEqualTo(String value) {
            addCriterion("score_quality_control =", value, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlNotEqualTo(String value) {
            addCriterion("score_quality_control <>", value, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlGreaterThan(String value) {
            addCriterion("score_quality_control >", value, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlGreaterThanOrEqualTo(String value) {
            addCriterion("score_quality_control >=", value, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlLessThan(String value) {
            addCriterion("score_quality_control <", value, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlLessThanOrEqualTo(String value) {
            addCriterion("score_quality_control <=", value, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlLike(String value) {
            addCriterion("score_quality_control like", value, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlNotLike(String value) {
            addCriterion("score_quality_control not like", value, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlIn(List<String> values) {
            addCriterion("score_quality_control in", values, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlNotIn(List<String> values) {
            addCriterion("score_quality_control not in", values, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlBetween(String value1, String value2) {
            addCriterion("score_quality_control between", value1, value2, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreQualityControlNotBetween(String value1, String value2) {
            addCriterion("score_quality_control not between", value1, value2, "scoreQualityControl");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityIsNull() {
            addCriterion("score_money_ability is null");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityIsNotNull() {
            addCriterion("score_money_ability is not null");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityEqualTo(String value) {
            addCriterion("score_money_ability =", value, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityNotEqualTo(String value) {
            addCriterion("score_money_ability <>", value, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityGreaterThan(String value) {
            addCriterion("score_money_ability >", value, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityGreaterThanOrEqualTo(String value) {
            addCriterion("score_money_ability >=", value, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityLessThan(String value) {
            addCriterion("score_money_ability <", value, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityLessThanOrEqualTo(String value) {
            addCriterion("score_money_ability <=", value, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityLike(String value) {
            addCriterion("score_money_ability like", value, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityNotLike(String value) {
            addCriterion("score_money_ability not like", value, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityIn(List<String> values) {
            addCriterion("score_money_ability in", values, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityNotIn(List<String> values) {
            addCriterion("score_money_ability not in", values, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityBetween(String value1, String value2) {
            addCriterion("score_money_ability between", value1, value2, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyAbilityNotBetween(String value1, String value2) {
            addCriterion("score_money_ability not between", value1, value2, "scoreMoneyAbility");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationIsNull() {
            addCriterion("score_company_reputation is null");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationIsNotNull() {
            addCriterion("score_company_reputation is not null");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationEqualTo(String value) {
            addCriterion("score_company_reputation =", value, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationNotEqualTo(String value) {
            addCriterion("score_company_reputation <>", value, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationGreaterThan(String value) {
            addCriterion("score_company_reputation >", value, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationGreaterThanOrEqualTo(String value) {
            addCriterion("score_company_reputation >=", value, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationLessThan(String value) {
            addCriterion("score_company_reputation <", value, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationLessThanOrEqualTo(String value) {
            addCriterion("score_company_reputation <=", value, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationLike(String value) {
            addCriterion("score_company_reputation like", value, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationNotLike(String value) {
            addCriterion("score_company_reputation not like", value, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationIn(List<String> values) {
            addCriterion("score_company_reputation in", values, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationNotIn(List<String> values) {
            addCriterion("score_company_reputation not in", values, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationBetween(String value1, String value2) {
            addCriterion("score_company_reputation between", value1, value2, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreCompanyReputationNotBetween(String value1, String value2) {
            addCriterion("score_company_reputation not between", value1, value2, "scoreCompanyReputation");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlIsNull() {
            addCriterion("score_jindu_control is null");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlIsNotNull() {
            addCriterion("score_jindu_control is not null");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlEqualTo(String value) {
            addCriterion("score_jindu_control =", value, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlNotEqualTo(String value) {
            addCriterion("score_jindu_control <>", value, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlGreaterThan(String value) {
            addCriterion("score_jindu_control >", value, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlGreaterThanOrEqualTo(String value) {
            addCriterion("score_jindu_control >=", value, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlLessThan(String value) {
            addCriterion("score_jindu_control <", value, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlLessThanOrEqualTo(String value) {
            addCriterion("score_jindu_control <=", value, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlLike(String value) {
            addCriterion("score_jindu_control like", value, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlNotLike(String value) {
            addCriterion("score_jindu_control not like", value, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlIn(List<String> values) {
            addCriterion("score_jindu_control in", values, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlNotIn(List<String> values) {
            addCriterion("score_jindu_control not in", values, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlBetween(String value1, String value2) {
            addCriterion("score_jindu_control between", value1, value2, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andScoreJinduControlNotBetween(String value1, String value2) {
            addCriterion("score_jindu_control not between", value1, value2, "scoreJinduControl");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentIsNull() {
            addCriterion("safety_civilization_environment is null");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentIsNotNull() {
            addCriterion("safety_civilization_environment is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentEqualTo(String value) {
            addCriterion("safety_civilization_environment =", value, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentNotEqualTo(String value) {
            addCriterion("safety_civilization_environment <>", value, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentGreaterThan(String value) {
            addCriterion("safety_civilization_environment >", value, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentGreaterThanOrEqualTo(String value) {
            addCriterion("safety_civilization_environment >=", value, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentLessThan(String value) {
            addCriterion("safety_civilization_environment <", value, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentLessThanOrEqualTo(String value) {
            addCriterion("safety_civilization_environment <=", value, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentLike(String value) {
            addCriterion("safety_civilization_environment like", value, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentNotLike(String value) {
            addCriterion("safety_civilization_environment not like", value, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentIn(List<String> values) {
            addCriterion("safety_civilization_environment in", values, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentNotIn(List<String> values) {
            addCriterion("safety_civilization_environment not in", values, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentBetween(String value1, String value2) {
            addCriterion("safety_civilization_environment between", value1, value2, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andSafetyCivilizationEnvironmentNotBetween(String value1, String value2) {
            addCriterion("safety_civilization_environment not between", value1, value2, "safetyCivilizationEnvironment");
            return (Criteria) this;
        }

        public Criteria andAllScoreIsNull() {
            addCriterion("all_score is null");
            return (Criteria) this;
        }

        public Criteria andAllScoreIsNotNull() {
            addCriterion("all_score is not null");
            return (Criteria) this;
        }

        public Criteria andAllScoreEqualTo(String value) {
            addCriterion("all_score =", value, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreNotEqualTo(String value) {
            addCriterion("all_score <>", value, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreGreaterThan(String value) {
            addCriterion("all_score >", value, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreGreaterThanOrEqualTo(String value) {
            addCriterion("all_score >=", value, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreLessThan(String value) {
            addCriterion("all_score <", value, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreLessThanOrEqualTo(String value) {
            addCriterion("all_score <=", value, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreLike(String value) {
            addCriterion("all_score like", value, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreNotLike(String value) {
            addCriterion("all_score not like", value, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreIn(List<String> values) {
            addCriterion("all_score in", values, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreNotIn(List<String> values) {
            addCriterion("all_score not in", values, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreBetween(String value1, String value2) {
            addCriterion("all_score between", value1, value2, "allScore");
            return (Criteria) this;
        }

        public Criteria andAllScoreNotBetween(String value1, String value2) {
            addCriterion("all_score not between", value1, value2, "allScore");
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