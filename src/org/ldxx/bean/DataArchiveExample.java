package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class DataArchiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataArchiveExample() {
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

        public Criteria andDaIdIsNull() {
            addCriterion("da_id is null");
            return (Criteria) this;
        }

        public Criteria andDaIdIsNotNull() {
            addCriterion("da_id is not null");
            return (Criteria) this;
        }

        public Criteria andDaIdEqualTo(String value) {
            addCriterion("da_id =", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotEqualTo(String value) {
            addCriterion("da_id <>", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdGreaterThan(String value) {
            addCriterion("da_id >", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdGreaterThanOrEqualTo(String value) {
            addCriterion("da_id >=", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLessThan(String value) {
            addCriterion("da_id <", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLessThanOrEqualTo(String value) {
            addCriterion("da_id <=", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLike(String value) {
            addCriterion("da_id like", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotLike(String value) {
            addCriterion("da_id not like", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdIn(List<String> values) {
            addCriterion("da_id in", values, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotIn(List<String> values) {
            addCriterion("da_id not in", values, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdBetween(String value1, String value2) {
            addCriterion("da_id between", value1, value2, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotBetween(String value1, String value2) {
            addCriterion("da_id not between", value1, value2, "daId");
            return (Criteria) this;
        }

        public Criteria andDaNameIsNull() {
            addCriterion("da_name is null");
            return (Criteria) this;
        }

        public Criteria andDaNameIsNotNull() {
            addCriterion("da_name is not null");
            return (Criteria) this;
        }

        public Criteria andDaNameEqualTo(String value) {
            addCriterion("da_name =", value, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameNotEqualTo(String value) {
            addCriterion("da_name <>", value, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameGreaterThan(String value) {
            addCriterion("da_name >", value, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameGreaterThanOrEqualTo(String value) {
            addCriterion("da_name >=", value, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameLessThan(String value) {
            addCriterion("da_name <", value, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameLessThanOrEqualTo(String value) {
            addCriterion("da_name <=", value, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameLike(String value) {
            addCriterion("da_name like", value, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameNotLike(String value) {
            addCriterion("da_name not like", value, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameIn(List<String> values) {
            addCriterion("da_name in", values, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameNotIn(List<String> values) {
            addCriterion("da_name not in", values, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameBetween(String value1, String value2) {
            addCriterion("da_name between", value1, value2, "daName");
            return (Criteria) this;
        }

        public Criteria andDaNameNotBetween(String value1, String value2) {
            addCriterion("da_name not between", value1, value2, "daName");
            return (Criteria) this;
        }

        public Criteria andAttendeesIsNull() {
            addCriterion("attendees is null");
            return (Criteria) this;
        }

        public Criteria andAttendeesIsNotNull() {
            addCriterion("attendees is not null");
            return (Criteria) this;
        }

        public Criteria andAttendeesEqualTo(String value) {
            addCriterion("attendees =", value, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesNotEqualTo(String value) {
            addCriterion("attendees <>", value, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesGreaterThan(String value) {
            addCriterion("attendees >", value, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesGreaterThanOrEqualTo(String value) {
            addCriterion("attendees >=", value, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesLessThan(String value) {
            addCriterion("attendees <", value, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesLessThanOrEqualTo(String value) {
            addCriterion("attendees <=", value, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesLike(String value) {
            addCriterion("attendees like", value, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesNotLike(String value) {
            addCriterion("attendees not like", value, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesIn(List<String> values) {
            addCriterion("attendees in", values, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesNotIn(List<String> values) {
            addCriterion("attendees not in", values, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesBetween(String value1, String value2) {
            addCriterion("attendees between", value1, value2, "attendees");
            return (Criteria) this;
        }

        public Criteria andAttendeesNotBetween(String value1, String value2) {
            addCriterion("attendees not between", value1, value2, "attendees");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationIsNull() {
            addCriterion("training_location is null");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationIsNotNull() {
            addCriterion("training_location is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationEqualTo(String value) {
            addCriterion("training_location =", value, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationNotEqualTo(String value) {
            addCriterion("training_location <>", value, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationGreaterThan(String value) {
            addCriterion("training_location >", value, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationGreaterThanOrEqualTo(String value) {
            addCriterion("training_location >=", value, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationLessThan(String value) {
            addCriterion("training_location <", value, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationLessThanOrEqualTo(String value) {
            addCriterion("training_location <=", value, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationLike(String value) {
            addCriterion("training_location like", value, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationNotLike(String value) {
            addCriterion("training_location not like", value, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationIn(List<String> values) {
            addCriterion("training_location in", values, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationNotIn(List<String> values) {
            addCriterion("training_location not in", values, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationBetween(String value1, String value2) {
            addCriterion("training_location between", value1, value2, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingLocationNotBetween(String value1, String value2) {
            addCriterion("training_location not between", value1, value2, "trainingLocation");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeIsNull() {
            addCriterion("training_time is null");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeIsNotNull() {
            addCriterion("training_time is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeEqualTo(String value) {
            addCriterion("training_time =", value, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeNotEqualTo(String value) {
            addCriterion("training_time <>", value, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeGreaterThan(String value) {
            addCriterion("training_time >", value, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("training_time >=", value, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeLessThan(String value) {
            addCriterion("training_time <", value, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeLessThanOrEqualTo(String value) {
            addCriterion("training_time <=", value, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeLike(String value) {
            addCriterion("training_time like", value, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeNotLike(String value) {
            addCriterion("training_time not like", value, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeIn(List<String> values) {
            addCriterion("training_time in", values, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeNotIn(List<String> values) {
            addCriterion("training_time not in", values, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeBetween(String value1, String value2) {
            addCriterion("training_time between", value1, value2, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingTimeNotBetween(String value1, String value2) {
            addCriterion("training_time not between", value1, value2, "trainingTime");
            return (Criteria) this;
        }

        public Criteria andTrainingDataIsNull() {
            addCriterion("training_data is null");
            return (Criteria) this;
        }

        public Criteria andTrainingDataIsNotNull() {
            addCriterion("training_data is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingDataEqualTo(String value) {
            addCriterion("training_data =", value, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataNotEqualTo(String value) {
            addCriterion("training_data <>", value, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataGreaterThan(String value) {
            addCriterion("training_data >", value, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataGreaterThanOrEqualTo(String value) {
            addCriterion("training_data >=", value, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataLessThan(String value) {
            addCriterion("training_data <", value, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataLessThanOrEqualTo(String value) {
            addCriterion("training_data <=", value, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataLike(String value) {
            addCriterion("training_data like", value, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataNotLike(String value) {
            addCriterion("training_data not like", value, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataIn(List<String> values) {
            addCriterion("training_data in", values, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataNotIn(List<String> values) {
            addCriterion("training_data not in", values, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataBetween(String value1, String value2) {
            addCriterion("training_data between", value1, value2, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingDataNotBetween(String value1, String value2) {
            addCriterion("training_data not between", value1, value2, "trainingData");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialIsNull() {
            addCriterion("training_credential is null");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialIsNotNull() {
            addCriterion("training_credential is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialEqualTo(String value) {
            addCriterion("training_credential =", value, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialNotEqualTo(String value) {
            addCriterion("training_credential <>", value, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialGreaterThan(String value) {
            addCriterion("training_credential >", value, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialGreaterThanOrEqualTo(String value) {
            addCriterion("training_credential >=", value, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialLessThan(String value) {
            addCriterion("training_credential <", value, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialLessThanOrEqualTo(String value) {
            addCriterion("training_credential <=", value, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialLike(String value) {
            addCriterion("training_credential like", value, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialNotLike(String value) {
            addCriterion("training_credential not like", value, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialIn(List<String> values) {
            addCriterion("training_credential in", values, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialNotIn(List<String> values) {
            addCriterion("training_credential not in", values, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialBetween(String value1, String value2) {
            addCriterion("training_credential between", value1, value2, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andTrainingCredentialNotBetween(String value1, String value2) {
            addCriterion("training_credential not between", value1, value2, "trainingCredential");
            return (Criteria) this;
        }

        public Criteria andDaStatusIsNull() {
            addCriterion("da_status is null");
            return (Criteria) this;
        }

        public Criteria andDaStatusIsNotNull() {
            addCriterion("da_status is not null");
            return (Criteria) this;
        }

        public Criteria andDaStatusEqualTo(Integer value) {
            addCriterion("da_status =", value, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusNotEqualTo(Integer value) {
            addCriterion("da_status <>", value, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusGreaterThan(Integer value) {
            addCriterion("da_status >", value, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("da_status >=", value, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusLessThan(Integer value) {
            addCriterion("da_status <", value, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusLessThanOrEqualTo(Integer value) {
            addCriterion("da_status <=", value, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusIn(List<Integer> values) {
            addCriterion("da_status in", values, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusNotIn(List<Integer> values) {
            addCriterion("da_status not in", values, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusBetween(Integer value1, Integer value2) {
            addCriterion("da_status between", value1, value2, "daStatus");
            return (Criteria) this;
        }

        public Criteria andDaStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("da_status not between", value1, value2, "daStatus");
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