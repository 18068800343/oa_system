package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andPrjIdIsNull() {
            addCriterion("prj_id is null");
            return (Criteria) this;
        }

        public Criteria andPrjIdIsNotNull() {
            addCriterion("prj_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrjIdEqualTo(String value) {
            addCriterion("prj_id =", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdNotEqualTo(String value) {
            addCriterion("prj_id <>", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdGreaterThan(String value) {
            addCriterion("prj_id >", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdGreaterThanOrEqualTo(String value) {
            addCriterion("prj_id >=", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdLessThan(String value) {
            addCriterion("prj_id <", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdLessThanOrEqualTo(String value) {
            addCriterion("prj_id <=", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdLike(String value) {
            addCriterion("prj_id like", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdNotLike(String value) {
            addCriterion("prj_id not like", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdIn(List<String> values) {
            addCriterion("prj_id in", values, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdNotIn(List<String> values) {
            addCriterion("prj_id not in", values, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdBetween(String value1, String value2) {
            addCriterion("prj_id between", value1, value2, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdNotBetween(String value1, String value2) {
            addCriterion("prj_id not between", value1, value2, "prjId");
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

        public Criteria andPrjNoIsNull() {
            addCriterion("prj_no is null");
            return (Criteria) this;
        }

        public Criteria andPrjNoIsNotNull() {
            addCriterion("prj_no is not null");
            return (Criteria) this;
        }

        public Criteria andPrjNoEqualTo(String value) {
            addCriterion("prj_no =", value, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoNotEqualTo(String value) {
            addCriterion("prj_no <>", value, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoGreaterThan(String value) {
            addCriterion("prj_no >", value, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoGreaterThanOrEqualTo(String value) {
            addCriterion("prj_no >=", value, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoLessThan(String value) {
            addCriterion("prj_no <", value, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoLessThanOrEqualTo(String value) {
            addCriterion("prj_no <=", value, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoLike(String value) {
            addCriterion("prj_no like", value, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoNotLike(String value) {
            addCriterion("prj_no not like", value, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoIn(List<String> values) {
            addCriterion("prj_no in", values, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoNotIn(List<String> values) {
            addCriterion("prj_no not in", values, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoBetween(String value1, String value2) {
            addCriterion("prj_no between", value1, value2, "prjNo");
            return (Criteria) this;
        }

        public Criteria andPrjNoNotBetween(String value1, String value2) {
            addCriterion("prj_no not between", value1, value2, "prjNo");
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

        public Criteria andPrjManagementModelIsNull() {
            addCriterion("prj_management_model is null");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelIsNotNull() {
            addCriterion("prj_management_model is not null");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelEqualTo(String value) {
            addCriterion("prj_management_model =", value, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelNotEqualTo(String value) {
            addCriterion("prj_management_model <>", value, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelGreaterThan(String value) {
            addCriterion("prj_management_model >", value, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelGreaterThanOrEqualTo(String value) {
            addCriterion("prj_management_model >=", value, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelLessThan(String value) {
            addCriterion("prj_management_model <", value, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelLessThanOrEqualTo(String value) {
            addCriterion("prj_management_model <=", value, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelLike(String value) {
            addCriterion("prj_management_model like", value, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelNotLike(String value) {
            addCriterion("prj_management_model not like", value, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelIn(List<String> values) {
            addCriterion("prj_management_model in", values, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelNotIn(List<String> values) {
            addCriterion("prj_management_model not in", values, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelBetween(String value1, String value2) {
            addCriterion("prj_management_model between", value1, value2, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjManagementModelNotBetween(String value1, String value2) {
            addCriterion("prj_management_model not between", value1, value2, "prjManagementModel");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyIsNull() {
            addCriterion("prj_company is null");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyIsNotNull() {
            addCriterion("prj_company is not null");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyEqualTo(String value) {
            addCriterion("prj_company =", value, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyNotEqualTo(String value) {
            addCriterion("prj_company <>", value, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyGreaterThan(String value) {
            addCriterion("prj_company >", value, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("prj_company >=", value, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyLessThan(String value) {
            addCriterion("prj_company <", value, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyLessThanOrEqualTo(String value) {
            addCriterion("prj_company <=", value, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyLike(String value) {
            addCriterion("prj_company like", value, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyNotLike(String value) {
            addCriterion("prj_company not like", value, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyIn(List<String> values) {
            addCriterion("prj_company in", values, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyNotIn(List<String> values) {
            addCriterion("prj_company not in", values, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyBetween(String value1, String value2) {
            addCriterion("prj_company between", value1, value2, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjCompanyNotBetween(String value1, String value2) {
            addCriterion("prj_company not between", value1, value2, "prjCompany");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitIsNull() {
            addCriterion("prj_owner_unit is null");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitIsNotNull() {
            addCriterion("prj_owner_unit is not null");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitEqualTo(String value) {
            addCriterion("prj_owner_unit =", value, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitNotEqualTo(String value) {
            addCriterion("prj_owner_unit <>", value, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitGreaterThan(String value) {
            addCriterion("prj_owner_unit >", value, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitGreaterThanOrEqualTo(String value) {
            addCriterion("prj_owner_unit >=", value, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitLessThan(String value) {
            addCriterion("prj_owner_unit <", value, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitLessThanOrEqualTo(String value) {
            addCriterion("prj_owner_unit <=", value, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitLike(String value) {
            addCriterion("prj_owner_unit like", value, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitNotLike(String value) {
            addCriterion("prj_owner_unit not like", value, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitIn(List<String> values) {
            addCriterion("prj_owner_unit in", values, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitNotIn(List<String> values) {
            addCriterion("prj_owner_unit not in", values, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitBetween(String value1, String value2) {
            addCriterion("prj_owner_unit between", value1, value2, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andPrjOwnerUnitNotBetween(String value1, String value2) {
            addCriterion("prj_owner_unit not between", value1, value2, "prjOwnerUnit");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNull() {
            addCriterion("work_content is null");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNotNull() {
            addCriterion("work_content is not null");
            return (Criteria) this;
        }

        public Criteria andWorkContentEqualTo(String value) {
            addCriterion("work_content =", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotEqualTo(String value) {
            addCriterion("work_content <>", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThan(String value) {
            addCriterion("work_content >", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThanOrEqualTo(String value) {
            addCriterion("work_content >=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThan(String value) {
            addCriterion("work_content <", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThanOrEqualTo(String value) {
            addCriterion("work_content <=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLike(String value) {
            addCriterion("work_content like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotLike(String value) {
            addCriterion("work_content not like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentIn(List<String> values) {
            addCriterion("work_content in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotIn(List<String> values) {
            addCriterion("work_content not in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentBetween(String value1, String value2) {
            addCriterion("work_content between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotBetween(String value1, String value2) {
            addCriterion("work_content not between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyIsNull() {
            addCriterion("prj_estimate_money is null");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyIsNotNull() {
            addCriterion("prj_estimate_money is not null");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyEqualTo(String value) {
            addCriterion("prj_estimate_money =", value, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyNotEqualTo(String value) {
            addCriterion("prj_estimate_money <>", value, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyGreaterThan(String value) {
            addCriterion("prj_estimate_money >", value, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("prj_estimate_money >=", value, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyLessThan(String value) {
            addCriterion("prj_estimate_money <", value, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyLessThanOrEqualTo(String value) {
            addCriterion("prj_estimate_money <=", value, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyLike(String value) {
            addCriterion("prj_estimate_money like", value, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyNotLike(String value) {
            addCriterion("prj_estimate_money not like", value, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyIn(List<String> values) {
            addCriterion("prj_estimate_money in", values, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyNotIn(List<String> values) {
            addCriterion("prj_estimate_money not in", values, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyBetween(String value1, String value2) {
            addCriterion("prj_estimate_money between", value1, value2, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateMoneyNotBetween(String value1, String value2) {
            addCriterion("prj_estimate_money not between", value1, value2, "prjEstimateMoney");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractIsNull() {
            addCriterion("prj_estimate_contract is null");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractIsNotNull() {
            addCriterion("prj_estimate_contract is not null");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractEqualTo(String value) {
            addCriterion("prj_estimate_contract =", value, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractNotEqualTo(String value) {
            addCriterion("prj_estimate_contract <>", value, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractGreaterThan(String value) {
            addCriterion("prj_estimate_contract >", value, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractGreaterThanOrEqualTo(String value) {
            addCriterion("prj_estimate_contract >=", value, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractLessThan(String value) {
            addCriterion("prj_estimate_contract <", value, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractLessThanOrEqualTo(String value) {
            addCriterion("prj_estimate_contract <=", value, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractLike(String value) {
            addCriterion("prj_estimate_contract like", value, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractNotLike(String value) {
            addCriterion("prj_estimate_contract not like", value, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractIn(List<String> values) {
            addCriterion("prj_estimate_contract in", values, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractNotIn(List<String> values) {
            addCriterion("prj_estimate_contract not in", values, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractBetween(String value1, String value2) {
            addCriterion("prj_estimate_contract between", value1, value2, "prjEstimateContract");
            return (Criteria) this;
        }

        public Criteria andPrjEstimateContractNotBetween(String value1, String value2) {
            addCriterion("prj_estimate_contract not between", value1, value2, "prjEstimateContract");
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

        public Criteria andProvisionalSumIsNull() {
            addCriterion("provisional_sum is null");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumIsNotNull() {
            addCriterion("provisional_sum is not null");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumEqualTo(String value) {
            addCriterion("provisional_sum =", value, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumNotEqualTo(String value) {
            addCriterion("provisional_sum <>", value, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumGreaterThan(String value) {
            addCriterion("provisional_sum >", value, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumGreaterThanOrEqualTo(String value) {
            addCriterion("provisional_sum >=", value, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumLessThan(String value) {
            addCriterion("provisional_sum <", value, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumLessThanOrEqualTo(String value) {
            addCriterion("provisional_sum <=", value, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumLike(String value) {
            addCriterion("provisional_sum like", value, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumNotLike(String value) {
            addCriterion("provisional_sum not like", value, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumIn(List<String> values) {
            addCriterion("provisional_sum in", values, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumNotIn(List<String> values) {
            addCriterion("provisional_sum not in", values, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumBetween(String value1, String value2) {
            addCriterion("provisional_sum between", value1, value2, "provisionalSum");
            return (Criteria) this;
        }

        public Criteria andProvisionalSumNotBetween(String value1, String value2) {
            addCriterion("provisional_sum not between", value1, value2, "provisionalSum");
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

        public Criteria andPrjEndTimeIsNull() {
            addCriterion("prj_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeIsNotNull() {
            addCriterion("prj_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeEqualTo(String value) {
            addCriterion("prj_end_time =", value, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeNotEqualTo(String value) {
            addCriterion("prj_end_time <>", value, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeGreaterThan(String value) {
            addCriterion("prj_end_time >", value, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_end_time >=", value, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeLessThan(String value) {
            addCriterion("prj_end_time <", value, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeLessThanOrEqualTo(String value) {
            addCriterion("prj_end_time <=", value, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeLike(String value) {
            addCriterion("prj_end_time like", value, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeNotLike(String value) {
            addCriterion("prj_end_time not like", value, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeIn(List<String> values) {
            addCriterion("prj_end_time in", values, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeNotIn(List<String> values) {
            addCriterion("prj_end_time not in", values, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeBetween(String value1, String value2) {
            addCriterion("prj_end_time between", value1, value2, "prjEndTime");
            return (Criteria) this;
        }

        public Criteria andPrjEndTimeNotBetween(String value1, String value2) {
            addCriterion("prj_end_time not between", value1, value2, "prjEndTime");
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

        public Criteria andMainDepartmentMoneyIsNull() {
            addCriterion("main_department_money is null");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyIsNotNull() {
            addCriterion("main_department_money is not null");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyEqualTo(Double value) {
            addCriterion("main_department_money =", value, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyNotEqualTo(Double value) {
            addCriterion("main_department_money <>", value, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyGreaterThan(Double value) {
            addCriterion("main_department_money >", value, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("main_department_money >=", value, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyLessThan(Double value) {
            addCriterion("main_department_money <", value, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyLessThanOrEqualTo(Double value) {
            addCriterion("main_department_money <=", value, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyIn(List<Double> values) {
            addCriterion("main_department_money in", values, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyNotIn(List<Double> values) {
            addCriterion("main_department_money not in", values, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyBetween(Double value1, Double value2) {
            addCriterion("main_department_money between", value1, value2, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andMainDepartmentMoneyNotBetween(Double value1, Double value2) {
            addCriterion("main_department_money not between", value1, value2, "mainDepartmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1IsNull() {
            addCriterion("assist_department1 is null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1IsNotNull() {
            addCriterion("assist_department1 is not null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1EqualTo(String value) {
            addCriterion("assist_department1 =", value, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1NotEqualTo(String value) {
            addCriterion("assist_department1 <>", value, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1GreaterThan(String value) {
            addCriterion("assist_department1 >", value, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1GreaterThanOrEqualTo(String value) {
            addCriterion("assist_department1 >=", value, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1LessThan(String value) {
            addCriterion("assist_department1 <", value, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1LessThanOrEqualTo(String value) {
            addCriterion("assist_department1 <=", value, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1Like(String value) {
            addCriterion("assist_department1 like", value, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1NotLike(String value) {
            addCriterion("assist_department1 not like", value, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1In(List<String> values) {
            addCriterion("assist_department1 in", values, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1NotIn(List<String> values) {
            addCriterion("assist_department1 not in", values, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1Between(String value1, String value2) {
            addCriterion("assist_department1 between", value1, value2, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1NotBetween(String value1, String value2) {
            addCriterion("assist_department1 not between", value1, value2, "assistDepartment1");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyIsNull() {
            addCriterion("assist_department1_money is null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyIsNotNull() {
            addCriterion("assist_department1_money is not null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyEqualTo(Double value) {
            addCriterion("assist_department1_money =", value, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyNotEqualTo(Double value) {
            addCriterion("assist_department1_money <>", value, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyGreaterThan(Double value) {
            addCriterion("assist_department1_money >", value, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("assist_department1_money >=", value, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyLessThan(Double value) {
            addCriterion("assist_department1_money <", value, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyLessThanOrEqualTo(Double value) {
            addCriterion("assist_department1_money <=", value, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyIn(List<Double> values) {
            addCriterion("assist_department1_money in", values, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyNotIn(List<Double> values) {
            addCriterion("assist_department1_money not in", values, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyBetween(Double value1, Double value2) {
            addCriterion("assist_department1_money between", value1, value2, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment1MoneyNotBetween(Double value1, Double value2) {
            addCriterion("assist_department1_money not between", value1, value2, "assistDepartment1Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2IsNull() {
            addCriterion("assist_department2 is null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2IsNotNull() {
            addCriterion("assist_department2 is not null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2EqualTo(String value) {
            addCriterion("assist_department2 =", value, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2NotEqualTo(String value) {
            addCriterion("assist_department2 <>", value, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2GreaterThan(String value) {
            addCriterion("assist_department2 >", value, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2GreaterThanOrEqualTo(String value) {
            addCriterion("assist_department2 >=", value, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2LessThan(String value) {
            addCriterion("assist_department2 <", value, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2LessThanOrEqualTo(String value) {
            addCriterion("assist_department2 <=", value, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2Like(String value) {
            addCriterion("assist_department2 like", value, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2NotLike(String value) {
            addCriterion("assist_department2 not like", value, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2In(List<String> values) {
            addCriterion("assist_department2 in", values, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2NotIn(List<String> values) {
            addCriterion("assist_department2 not in", values, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2Between(String value1, String value2) {
            addCriterion("assist_department2 between", value1, value2, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2NotBetween(String value1, String value2) {
            addCriterion("assist_department2 not between", value1, value2, "assistDepartment2");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyIsNull() {
            addCriterion("assist_department2_money is null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyIsNotNull() {
            addCriterion("assist_department2_money is not null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyEqualTo(Double value) {
            addCriterion("assist_department2_money =", value, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyNotEqualTo(Double value) {
            addCriterion("assist_department2_money <>", value, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyGreaterThan(Double value) {
            addCriterion("assist_department2_money >", value, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("assist_department2_money >=", value, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyLessThan(Double value) {
            addCriterion("assist_department2_money <", value, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyLessThanOrEqualTo(Double value) {
            addCriterion("assist_department2_money <=", value, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyIn(List<Double> values) {
            addCriterion("assist_department2_money in", values, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyNotIn(List<Double> values) {
            addCriterion("assist_department2_money not in", values, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyBetween(Double value1, Double value2) {
            addCriterion("assist_department2_money between", value1, value2, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment2MoneyNotBetween(Double value1, Double value2) {
            addCriterion("assist_department2_money not between", value1, value2, "assistDepartment2Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3IsNull() {
            addCriterion("assist_department3 is null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3IsNotNull() {
            addCriterion("assist_department3 is not null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3EqualTo(String value) {
            addCriterion("assist_department3 =", value, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3NotEqualTo(String value) {
            addCriterion("assist_department3 <>", value, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3GreaterThan(String value) {
            addCriterion("assist_department3 >", value, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3GreaterThanOrEqualTo(String value) {
            addCriterion("assist_department3 >=", value, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3LessThan(String value) {
            addCriterion("assist_department3 <", value, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3LessThanOrEqualTo(String value) {
            addCriterion("assist_department3 <=", value, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3Like(String value) {
            addCriterion("assist_department3 like", value, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3NotLike(String value) {
            addCriterion("assist_department3 not like", value, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3In(List<String> values) {
            addCriterion("assist_department3 in", values, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3NotIn(List<String> values) {
            addCriterion("assist_department3 not in", values, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3Between(String value1, String value2) {
            addCriterion("assist_department3 between", value1, value2, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3NotBetween(String value1, String value2) {
            addCriterion("assist_department3 not between", value1, value2, "assistDepartment3");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyIsNull() {
            addCriterion("assist_department3_money is null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyIsNotNull() {
            addCriterion("assist_department3_money is not null");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyEqualTo(Double value) {
            addCriterion("assist_department3_money =", value, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyNotEqualTo(Double value) {
            addCriterion("assist_department3_money <>", value, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyGreaterThan(Double value) {
            addCriterion("assist_department3_money >", value, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("assist_department3_money >=", value, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyLessThan(Double value) {
            addCriterion("assist_department3_money <", value, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyLessThanOrEqualTo(Double value) {
            addCriterion("assist_department3_money <=", value, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyIn(List<Double> values) {
            addCriterion("assist_department3_money in", values, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyNotIn(List<Double> values) {
            addCriterion("assist_department3_money not in", values, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyBetween(Double value1, Double value2) {
            addCriterion("assist_department3_money between", value1, value2, "assistDepartment3Money");
            return (Criteria) this;
        }

        public Criteria andAssistDepartment3MoneyNotBetween(Double value1, Double value2) {
            addCriterion("assist_department3_money not between", value1, value2, "assistDepartment3Money");
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