package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class MaterialDemandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialDemandExample() {
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

        public Criteria andMdlIdIsNull() {
            addCriterion("mdl_id is null");
            return (Criteria) this;
        }

        public Criteria andMdlIdIsNotNull() {
            addCriterion("mdl_id is not null");
            return (Criteria) this;
        }

        public Criteria andMdlIdEqualTo(String value) {
            addCriterion("mdl_id =", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotEqualTo(String value) {
            addCriterion("mdl_id <>", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdGreaterThan(String value) {
            addCriterion("mdl_id >", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdGreaterThanOrEqualTo(String value) {
            addCriterion("mdl_id >=", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLessThan(String value) {
            addCriterion("mdl_id <", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLessThanOrEqualTo(String value) {
            addCriterion("mdl_id <=", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdLike(String value) {
            addCriterion("mdl_id like", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotLike(String value) {
            addCriterion("mdl_id not like", value, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdIn(List<String> values) {
            addCriterion("mdl_id in", values, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotIn(List<String> values) {
            addCriterion("mdl_id not in", values, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdBetween(String value1, String value2) {
            addCriterion("mdl_id between", value1, value2, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMdlIdNotBetween(String value1, String value2) {
            addCriterion("mdl_id not between", value1, value2, "mdlId");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("material_name like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNull() {
            addCriterion("material_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNotNull() {
            addCriterion("material_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeEqualTo(String value) {
            addCriterion("material_code =", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotEqualTo(String value) {
            addCriterion("material_code <>", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThan(String value) {
            addCriterion("material_code >", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("material_code >=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThan(String value) {
            addCriterion("material_code <", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("material_code <=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLike(String value) {
            addCriterion("material_code like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotLike(String value) {
            addCriterion("material_code not like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIn(List<String> values) {
            addCriterion("material_code in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotIn(List<String> values) {
            addCriterion("material_code not in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeBetween(String value1, String value2) {
            addCriterion("material_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotBetween(String value1, String value2) {
            addCriterion("material_code not between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyIsNull() {
            addCriterion("buy_company is null");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyIsNotNull() {
            addCriterion("buy_company is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyEqualTo(String value) {
            addCriterion("buy_company =", value, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyNotEqualTo(String value) {
            addCriterion("buy_company <>", value, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyGreaterThan(String value) {
            addCriterion("buy_company >", value, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("buy_company >=", value, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyLessThan(String value) {
            addCriterion("buy_company <", value, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyLessThanOrEqualTo(String value) {
            addCriterion("buy_company <=", value, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyLike(String value) {
            addCriterion("buy_company like", value, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyNotLike(String value) {
            addCriterion("buy_company not like", value, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyIn(List<String> values) {
            addCriterion("buy_company in", values, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyNotIn(List<String> values) {
            addCriterion("buy_company not in", values, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyBetween(String value1, String value2) {
            addCriterion("buy_company between", value1, value2, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andBuyCompanyNotBetween(String value1, String value2) {
            addCriterion("buy_company not between", value1, value2, "buyCompany");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("num like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("num not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyIsNull() {
            addCriterion("department_recommend_metrial_mode_and_provide_company is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyIsNotNull() {
            addCriterion("department_recommend_metrial_mode_and_provide_company is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyEqualTo(String value) {
            addCriterion("department_recommend_metrial_mode_and_provide_company =", value, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyNotEqualTo(String value) {
            addCriterion("department_recommend_metrial_mode_and_provide_company <>", value, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyGreaterThan(String value) {
            addCriterion("department_recommend_metrial_mode_and_provide_company >", value, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("department_recommend_metrial_mode_and_provide_company >=", value, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyLessThan(String value) {
            addCriterion("department_recommend_metrial_mode_and_provide_company <", value, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyLessThanOrEqualTo(String value) {
            addCriterion("department_recommend_metrial_mode_and_provide_company <=", value, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyLike(String value) {
            addCriterion("department_recommend_metrial_mode_and_provide_company like", value, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyNotLike(String value) {
            addCriterion("department_recommend_metrial_mode_and_provide_company not like", value, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyIn(List<String> values) {
            addCriterion("department_recommend_metrial_mode_and_provide_company in", values, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyNotIn(List<String> values) {
            addCriterion("department_recommend_metrial_mode_and_provide_company not in", values, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyBetween(String value1, String value2) {
            addCriterion("department_recommend_metrial_mode_and_provide_company between", value1, value2, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andDepartmentRecommendMetrialModeAndProvideCompanyNotBetween(String value1, String value2) {
            addCriterion("department_recommend_metrial_mode_and_provide_company not between", value1, value2, "departmentRecommendMetrialModeAndProvideCompany");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideIsNull() {
            addCriterion("sure_material_mode_and_provide is null");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideIsNotNull() {
            addCriterion("sure_material_mode_and_provide is not null");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideEqualTo(String value) {
            addCriterion("sure_material_mode_and_provide =", value, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideNotEqualTo(String value) {
            addCriterion("sure_material_mode_and_provide <>", value, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideGreaterThan(String value) {
            addCriterion("sure_material_mode_and_provide >", value, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideGreaterThanOrEqualTo(String value) {
            addCriterion("sure_material_mode_and_provide >=", value, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideLessThan(String value) {
            addCriterion("sure_material_mode_and_provide <", value, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideLessThanOrEqualTo(String value) {
            addCriterion("sure_material_mode_and_provide <=", value, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideLike(String value) {
            addCriterion("sure_material_mode_and_provide like", value, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideNotLike(String value) {
            addCriterion("sure_material_mode_and_provide not like", value, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideIn(List<String> values) {
            addCriterion("sure_material_mode_and_provide in", values, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideNotIn(List<String> values) {
            addCriterion("sure_material_mode_and_provide not in", values, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideBetween(String value1, String value2) {
            addCriterion("sure_material_mode_and_provide between", value1, value2, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andSureMaterialModeAndProvideNotBetween(String value1, String value2) {
            addCriterion("sure_material_mode_and_provide not between", value1, value2, "sureMaterialModeAndProvide");
            return (Criteria) this;
        }

        public Criteria andPsIsNull() {
            addCriterion("ps is null");
            return (Criteria) this;
        }

        public Criteria andPsIsNotNull() {
            addCriterion("ps is not null");
            return (Criteria) this;
        }

        public Criteria andPsEqualTo(String value) {
            addCriterion("ps =", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotEqualTo(String value) {
            addCriterion("ps <>", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsGreaterThan(String value) {
            addCriterion("ps >", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsGreaterThanOrEqualTo(String value) {
            addCriterion("ps >=", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLessThan(String value) {
            addCriterion("ps <", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLessThanOrEqualTo(String value) {
            addCriterion("ps <=", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLike(String value) {
            addCriterion("ps like", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotLike(String value) {
            addCriterion("ps not like", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsIn(List<String> values) {
            addCriterion("ps in", values, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotIn(List<String> values) {
            addCriterion("ps not in", values, "ps");
            return (Criteria) this;
        }

        public Criteria andPsBetween(String value1, String value2) {
            addCriterion("ps between", value1, value2, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotBetween(String value1, String value2) {
            addCriterion("ps not between", value1, value2, "ps");
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