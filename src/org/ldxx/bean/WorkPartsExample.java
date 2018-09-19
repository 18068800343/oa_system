package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class WorkPartsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkPartsExample() {
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

        public Criteria andWpIdIsNull() {
            addCriterion("wp_id is null");
            return (Criteria) this;
        }

        public Criteria andWpIdIsNotNull() {
            addCriterion("wp_id is not null");
            return (Criteria) this;
        }

        public Criteria andWpIdEqualTo(String value) {
            addCriterion("wp_id =", value, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdNotEqualTo(String value) {
            addCriterion("wp_id <>", value, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdGreaterThan(String value) {
            addCriterion("wp_id >", value, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdGreaterThanOrEqualTo(String value) {
            addCriterion("wp_id >=", value, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdLessThan(String value) {
            addCriterion("wp_id <", value, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdLessThanOrEqualTo(String value) {
            addCriterion("wp_id <=", value, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdLike(String value) {
            addCriterion("wp_id like", value, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdNotLike(String value) {
            addCriterion("wp_id not like", value, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdIn(List<String> values) {
            addCriterion("wp_id in", values, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdNotIn(List<String> values) {
            addCriterion("wp_id not in", values, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdBetween(String value1, String value2) {
            addCriterion("wp_id between", value1, value2, "wpId");
            return (Criteria) this;
        }

        public Criteria andWpIdNotBetween(String value1, String value2) {
            addCriterion("wp_id not between", value1, value2, "wpId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdIsNull() {
            addCriterion("prj_construction_log_id is null");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdIsNotNull() {
            addCriterion("prj_construction_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdEqualTo(String value) {
            addCriterion("prj_construction_log_id =", value, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdNotEqualTo(String value) {
            addCriterion("prj_construction_log_id <>", value, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdGreaterThan(String value) {
            addCriterion("prj_construction_log_id >", value, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("prj_construction_log_id >=", value, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdLessThan(String value) {
            addCriterion("prj_construction_log_id <", value, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdLessThanOrEqualTo(String value) {
            addCriterion("prj_construction_log_id <=", value, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdLike(String value) {
            addCriterion("prj_construction_log_id like", value, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdNotLike(String value) {
            addCriterion("prj_construction_log_id not like", value, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdIn(List<String> values) {
            addCriterion("prj_construction_log_id in", values, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdNotIn(List<String> values) {
            addCriterion("prj_construction_log_id not in", values, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdBetween(String value1, String value2) {
            addCriterion("prj_construction_log_id between", value1, value2, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andPrjConstructionLogIdNotBetween(String value1, String value2) {
            addCriterion("prj_construction_log_id not between", value1, value2, "prjConstructionLogId");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameIsNull() {
            addCriterion("work_part_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameIsNotNull() {
            addCriterion("work_part_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameEqualTo(String value) {
            addCriterion("work_part_name =", value, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameNotEqualTo(String value) {
            addCriterion("work_part_name <>", value, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameGreaterThan(String value) {
            addCriterion("work_part_name >", value, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_part_name >=", value, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameLessThan(String value) {
            addCriterion("work_part_name <", value, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameLessThanOrEqualTo(String value) {
            addCriterion("work_part_name <=", value, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameLike(String value) {
            addCriterion("work_part_name like", value, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameNotLike(String value) {
            addCriterion("work_part_name not like", value, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameIn(List<String> values) {
            addCriterion("work_part_name in", values, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameNotIn(List<String> values) {
            addCriterion("work_part_name not in", values, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameBetween(String value1, String value2) {
            addCriterion("work_part_name between", value1, value2, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartNameNotBetween(String value1, String value2) {
            addCriterion("work_part_name not between", value1, value2, "workPartName");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextIsNull() {
            addCriterion("work_part_text is null");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextIsNotNull() {
            addCriterion("work_part_text is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextEqualTo(String value) {
            addCriterion("work_part_text =", value, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextNotEqualTo(String value) {
            addCriterion("work_part_text <>", value, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextGreaterThan(String value) {
            addCriterion("work_part_text >", value, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextGreaterThanOrEqualTo(String value) {
            addCriterion("work_part_text >=", value, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextLessThan(String value) {
            addCriterion("work_part_text <", value, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextLessThanOrEqualTo(String value) {
            addCriterion("work_part_text <=", value, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextLike(String value) {
            addCriterion("work_part_text like", value, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextNotLike(String value) {
            addCriterion("work_part_text not like", value, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextIn(List<String> values) {
            addCriterion("work_part_text in", values, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextNotIn(List<String> values) {
            addCriterion("work_part_text not in", values, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextBetween(String value1, String value2) {
            addCriterion("work_part_text between", value1, value2, "workPartText");
            return (Criteria) this;
        }

        public Criteria andWorkPartTextNotBetween(String value1, String value2) {
            addCriterion("work_part_text not between", value1, value2, "workPartText");
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