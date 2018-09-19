package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class DictionaryFirstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryFirstExample() {
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

        public Criteria andIdFirstIsNull() {
            addCriterion("id_first is null");
            return (Criteria) this;
        }

        public Criteria andIdFirstIsNotNull() {
            addCriterion("id_first is not null");
            return (Criteria) this;
        }

        public Criteria andIdFirstEqualTo(String value) {
            addCriterion("id_first =", value, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstNotEqualTo(String value) {
            addCriterion("id_first <>", value, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstGreaterThan(String value) {
            addCriterion("id_first >", value, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstGreaterThanOrEqualTo(String value) {
            addCriterion("id_first >=", value, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstLessThan(String value) {
            addCriterion("id_first <", value, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstLessThanOrEqualTo(String value) {
            addCriterion("id_first <=", value, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstLike(String value) {
            addCriterion("id_first like", value, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstNotLike(String value) {
            addCriterion("id_first not like", value, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstIn(List<String> values) {
            addCriterion("id_first in", values, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstNotIn(List<String> values) {
            addCriterion("id_first not in", values, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstBetween(String value1, String value2) {
            addCriterion("id_first between", value1, value2, "idFirst");
            return (Criteria) this;
        }

        public Criteria andIdFirstNotBetween(String value1, String value2) {
            addCriterion("id_first not between", value1, value2, "idFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstIsNull() {
            addCriterion("name_first is null");
            return (Criteria) this;
        }

        public Criteria andNameFirstIsNotNull() {
            addCriterion("name_first is not null");
            return (Criteria) this;
        }

        public Criteria andNameFirstEqualTo(String value) {
            addCriterion("name_first =", value, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstNotEqualTo(String value) {
            addCriterion("name_first <>", value, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstGreaterThan(String value) {
            addCriterion("name_first >", value, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstGreaterThanOrEqualTo(String value) {
            addCriterion("name_first >=", value, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstLessThan(String value) {
            addCriterion("name_first <", value, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstLessThanOrEqualTo(String value) {
            addCriterion("name_first <=", value, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstLike(String value) {
            addCriterion("name_first like", value, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstNotLike(String value) {
            addCriterion("name_first not like", value, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstIn(List<String> values) {
            addCriterion("name_first in", values, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstNotIn(List<String> values) {
            addCriterion("name_first not in", values, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstBetween(String value1, String value2) {
            addCriterion("name_first between", value1, value2, "nameFirst");
            return (Criteria) this;
        }

        public Criteria andNameFirstNotBetween(String value1, String value2) {
            addCriterion("name_first not between", value1, value2, "nameFirst");
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