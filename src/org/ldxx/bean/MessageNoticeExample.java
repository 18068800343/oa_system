package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class MessageNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageNoticeExample() {
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

        public Criteria andMnIdIsNull() {
            addCriterion("mn_id is null");
            return (Criteria) this;
        }

        public Criteria andMnIdIsNotNull() {
            addCriterion("mn_id is not null");
            return (Criteria) this;
        }

        public Criteria andMnIdEqualTo(String value) {
            addCriterion("mn_id =", value, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdNotEqualTo(String value) {
            addCriterion("mn_id <>", value, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdGreaterThan(String value) {
            addCriterion("mn_id >", value, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdGreaterThanOrEqualTo(String value) {
            addCriterion("mn_id >=", value, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdLessThan(String value) {
            addCriterion("mn_id <", value, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdLessThanOrEqualTo(String value) {
            addCriterion("mn_id <=", value, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdLike(String value) {
            addCriterion("mn_id like", value, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdNotLike(String value) {
            addCriterion("mn_id not like", value, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdIn(List<String> values) {
            addCriterion("mn_id in", values, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdNotIn(List<String> values) {
            addCriterion("mn_id not in", values, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdBetween(String value1, String value2) {
            addCriterion("mn_id between", value1, value2, "mnId");
            return (Criteria) this;
        }

        public Criteria andMnIdNotBetween(String value1, String value2) {
            addCriterion("mn_id not between", value1, value2, "mnId");
            return (Criteria) this;
        }

        public Criteria andMfIdIsNull() {
            addCriterion("mf_id is null");
            return (Criteria) this;
        }

        public Criteria andMfIdIsNotNull() {
            addCriterion("mf_id is not null");
            return (Criteria) this;
        }

        public Criteria andMfIdEqualTo(String value) {
            addCriterion("mf_id =", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdNotEqualTo(String value) {
            addCriterion("mf_id <>", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdGreaterThan(String value) {
            addCriterion("mf_id >", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdGreaterThanOrEqualTo(String value) {
            addCriterion("mf_id >=", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdLessThan(String value) {
            addCriterion("mf_id <", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdLessThanOrEqualTo(String value) {
            addCriterion("mf_id <=", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdLike(String value) {
            addCriterion("mf_id like", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdNotLike(String value) {
            addCriterion("mf_id not like", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdIn(List<String> values) {
            addCriterion("mf_id in", values, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdNotIn(List<String> values) {
            addCriterion("mf_id not in", values, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdBetween(String value1, String value2) {
            addCriterion("mf_id between", value1, value2, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdNotBetween(String value1, String value2) {
            addCriterion("mf_id not between", value1, value2, "mfId");
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