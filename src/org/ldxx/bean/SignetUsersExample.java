package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class SignetUsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SignetUsersExample() {
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

        public Criteria andSuIdIsNull() {
            addCriterion("su_id is null");
            return (Criteria) this;
        }

        public Criteria andSuIdIsNotNull() {
            addCriterion("su_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuIdEqualTo(String value) {
            addCriterion("su_id =", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotEqualTo(String value) {
            addCriterion("su_id <>", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdGreaterThan(String value) {
            addCriterion("su_id >", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdGreaterThanOrEqualTo(String value) {
            addCriterion("su_id >=", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdLessThan(String value) {
            addCriterion("su_id <", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdLessThanOrEqualTo(String value) {
            addCriterion("su_id <=", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdLike(String value) {
            addCriterion("su_id like", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotLike(String value) {
            addCriterion("su_id not like", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdIn(List<String> values) {
            addCriterion("su_id in", values, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotIn(List<String> values) {
            addCriterion("su_id not in", values, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdBetween(String value1, String value2) {
            addCriterion("su_id between", value1, value2, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotBetween(String value1, String value2) {
            addCriterion("su_id not between", value1, value2, "suId");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(String value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(String value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(String value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(String value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(String value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLike(String value) {
            addCriterion("begin_time like", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotLike(String value) {
            addCriterion("begin_time not like", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<String> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<String> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(String value1, String value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(String value1, String value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andCustodyManIsNull() {
            addCriterion("custody_man is null");
            return (Criteria) this;
        }

        public Criteria andCustodyManIsNotNull() {
            addCriterion("custody_man is not null");
            return (Criteria) this;
        }

        public Criteria andCustodyManEqualTo(String value) {
            addCriterion("custody_man =", value, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManNotEqualTo(String value) {
            addCriterion("custody_man <>", value, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManGreaterThan(String value) {
            addCriterion("custody_man >", value, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManGreaterThanOrEqualTo(String value) {
            addCriterion("custody_man >=", value, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManLessThan(String value) {
            addCriterion("custody_man <", value, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManLessThanOrEqualTo(String value) {
            addCriterion("custody_man <=", value, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManLike(String value) {
            addCriterion("custody_man like", value, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManNotLike(String value) {
            addCriterion("custody_man not like", value, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManIn(List<String> values) {
            addCriterion("custody_man in", values, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManNotIn(List<String> values) {
            addCriterion("custody_man not in", values, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManBetween(String value1, String value2) {
            addCriterion("custody_man between", value1, value2, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andCustodyManNotBetween(String value1, String value2) {
            addCriterion("custody_man not between", value1, value2, "custodyMan");
            return (Criteria) this;
        }

        public Criteria andUseProjectIsNull() {
            addCriterion("use_project is null");
            return (Criteria) this;
        }

        public Criteria andUseProjectIsNotNull() {
            addCriterion("use_project is not null");
            return (Criteria) this;
        }

        public Criteria andUseProjectEqualTo(String value) {
            addCriterion("use_project =", value, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectNotEqualTo(String value) {
            addCriterion("use_project <>", value, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectGreaterThan(String value) {
            addCriterion("use_project >", value, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectGreaterThanOrEqualTo(String value) {
            addCriterion("use_project >=", value, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectLessThan(String value) {
            addCriterion("use_project <", value, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectLessThanOrEqualTo(String value) {
            addCriterion("use_project <=", value, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectLike(String value) {
            addCriterion("use_project like", value, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectNotLike(String value) {
            addCriterion("use_project not like", value, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectIn(List<String> values) {
            addCriterion("use_project in", values, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectNotIn(List<String> values) {
            addCriterion("use_project not in", values, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectBetween(String value1, String value2) {
            addCriterion("use_project between", value1, value2, "useProject");
            return (Criteria) this;
        }

        public Criteria andUseProjectNotBetween(String value1, String value2) {
            addCriterion("use_project not between", value1, value2, "useProject");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeIsNull() {
            addCriterion("destroy_time is null");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeIsNotNull() {
            addCriterion("destroy_time is not null");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeEqualTo(String value) {
            addCriterion("destroy_time =", value, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeNotEqualTo(String value) {
            addCriterion("destroy_time <>", value, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeGreaterThan(String value) {
            addCriterion("destroy_time >", value, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("destroy_time >=", value, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeLessThan(String value) {
            addCriterion("destroy_time <", value, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeLessThanOrEqualTo(String value) {
            addCriterion("destroy_time <=", value, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeLike(String value) {
            addCriterion("destroy_time like", value, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeNotLike(String value) {
            addCriterion("destroy_time not like", value, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeIn(List<String> values) {
            addCriterion("destroy_time in", values, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeNotIn(List<String> values) {
            addCriterion("destroy_time not in", values, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeBetween(String value1, String value2) {
            addCriterion("destroy_time between", value1, value2, "destroyTime");
            return (Criteria) this;
        }

        public Criteria andDestroyTimeNotBetween(String value1, String value2) {
            addCriterion("destroy_time not between", value1, value2, "destroyTime");
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