package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OutTrainAllExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutTrainAllExample() {
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

        public Criteria andOtaIdIsNull() {
            addCriterion("ota_id is null");
            return (Criteria) this;
        }

        public Criteria andOtaIdIsNotNull() {
            addCriterion("ota_id is not null");
            return (Criteria) this;
        }

        public Criteria andOtaIdEqualTo(String value) {
            addCriterion("ota_id =", value, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdNotEqualTo(String value) {
            addCriterion("ota_id <>", value, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdGreaterThan(String value) {
            addCriterion("ota_id >", value, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdGreaterThanOrEqualTo(String value) {
            addCriterion("ota_id >=", value, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdLessThan(String value) {
            addCriterion("ota_id <", value, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdLessThanOrEqualTo(String value) {
            addCriterion("ota_id <=", value, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdLike(String value) {
            addCriterion("ota_id like", value, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdNotLike(String value) {
            addCriterion("ota_id not like", value, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdIn(List<String> values) {
            addCriterion("ota_id in", values, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdNotIn(List<String> values) {
            addCriterion("ota_id not in", values, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdBetween(String value1, String value2) {
            addCriterion("ota_id between", value1, value2, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaIdNotBetween(String value1, String value2) {
            addCriterion("ota_id not between", value1, value2, "otaId");
            return (Criteria) this;
        }

        public Criteria andOtaTitleIsNull() {
            addCriterion("ota_title is null");
            return (Criteria) this;
        }

        public Criteria andOtaTitleIsNotNull() {
            addCriterion("ota_title is not null");
            return (Criteria) this;
        }

        public Criteria andOtaTitleEqualTo(String value) {
            addCriterion("ota_title =", value, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleNotEqualTo(String value) {
            addCriterion("ota_title <>", value, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleGreaterThan(String value) {
            addCriterion("ota_title >", value, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ota_title >=", value, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleLessThan(String value) {
            addCriterion("ota_title <", value, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleLessThanOrEqualTo(String value) {
            addCriterion("ota_title <=", value, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleLike(String value) {
            addCriterion("ota_title like", value, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleNotLike(String value) {
            addCriterion("ota_title not like", value, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleIn(List<String> values) {
            addCriterion("ota_title in", values, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleNotIn(List<String> values) {
            addCriterion("ota_title not in", values, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleBetween(String value1, String value2) {
            addCriterion("ota_title between", value1, value2, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andOtaTitleNotBetween(String value1, String value2) {
            addCriterion("ota_title not between", value1, value2, "otaTitle");
            return (Criteria) this;
        }

        public Criteria andTrainingNameIsNull() {
            addCriterion("training_name is null");
            return (Criteria) this;
        }

        public Criteria andTrainingNameIsNotNull() {
            addCriterion("training_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingNameEqualTo(String value) {
            addCriterion("training_name =", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameNotEqualTo(String value) {
            addCriterion("training_name <>", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameGreaterThan(String value) {
            addCriterion("training_name >", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameGreaterThanOrEqualTo(String value) {
            addCriterion("training_name >=", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameLessThan(String value) {
            addCriterion("training_name <", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameLessThanOrEqualTo(String value) {
            addCriterion("training_name <=", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameLike(String value) {
            addCriterion("training_name like", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameNotLike(String value) {
            addCriterion("training_name not like", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameIn(List<String> values) {
            addCriterion("training_name in", values, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameNotIn(List<String> values) {
            addCriterion("training_name not in", values, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameBetween(String value1, String value2) {
            addCriterion("training_name between", value1, value2, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameNotBetween(String value1, String value2) {
            addCriterion("training_name not between", value1, value2, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingLvIsNull() {
            addCriterion("training_lv is null");
            return (Criteria) this;
        }

        public Criteria andTrainingLvIsNotNull() {
            addCriterion("training_lv is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingLvEqualTo(String value) {
            addCriterion("training_lv =", value, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvNotEqualTo(String value) {
            addCriterion("training_lv <>", value, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvGreaterThan(String value) {
            addCriterion("training_lv >", value, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvGreaterThanOrEqualTo(String value) {
            addCriterion("training_lv >=", value, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvLessThan(String value) {
            addCriterion("training_lv <", value, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvLessThanOrEqualTo(String value) {
            addCriterion("training_lv <=", value, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvLike(String value) {
            addCriterion("training_lv like", value, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvNotLike(String value) {
            addCriterion("training_lv not like", value, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvIn(List<String> values) {
            addCriterion("training_lv in", values, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvNotIn(List<String> values) {
            addCriterion("training_lv not in", values, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvBetween(String value1, String value2) {
            addCriterion("training_lv between", value1, value2, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andTrainingLvNotBetween(String value1, String value2) {
            addCriterion("training_lv not between", value1, value2, "trainingLv");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
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

        public Criteria andTrainingMoneyIsNull() {
            addCriterion("training_money is null");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyIsNotNull() {
            addCriterion("training_money is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyEqualTo(BigDecimal value) {
            addCriterion("training_money =", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyNotEqualTo(BigDecimal value) {
            addCriterion("training_money <>", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyGreaterThan(BigDecimal value) {
            addCriterion("training_money >", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("training_money >=", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyLessThan(BigDecimal value) {
            addCriterion("training_money <", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("training_money <=", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyIn(List<BigDecimal> values) {
            addCriterion("training_money in", values, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyNotIn(List<BigDecimal> values) {
            addCriterion("training_money not in", values, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("training_money between", value1, value2, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("training_money not between", value1, value2, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIsNull() {
            addCriterion("training_date is null");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIsNotNull() {
            addCriterion("training_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingDateEqualTo(String value) {
            addCriterion("training_date =", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotEqualTo(String value) {
            addCriterion("training_date <>", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateGreaterThan(String value) {
            addCriterion("training_date >", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateGreaterThanOrEqualTo(String value) {
            addCriterion("training_date >=", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateLessThan(String value) {
            addCriterion("training_date <", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateLessThanOrEqualTo(String value) {
            addCriterion("training_date <=", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateLike(String value) {
            addCriterion("training_date like", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotLike(String value) {
            addCriterion("training_date not like", value, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateIn(List<String> values) {
            addCriterion("training_date in", values, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotIn(List<String> values) {
            addCriterion("training_date not in", values, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateBetween(String value1, String value2) {
            addCriterion("training_date between", value1, value2, "trainingDate");
            return (Criteria) this;
        }

        public Criteria andTrainingDateNotBetween(String value1, String value2) {
            addCriterion("training_date not between", value1, value2, "trainingDate");
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

        public Criteria andOtaStatusIsNull() {
            addCriterion("ota_status is null");
            return (Criteria) this;
        }

        public Criteria andOtaStatusIsNotNull() {
            addCriterion("ota_status is not null");
            return (Criteria) this;
        }

        public Criteria andOtaStatusEqualTo(Integer value) {
            addCriterion("ota_status =", value, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusNotEqualTo(Integer value) {
            addCriterion("ota_status <>", value, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusGreaterThan(Integer value) {
            addCriterion("ota_status >", value, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ota_status >=", value, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusLessThan(Integer value) {
            addCriterion("ota_status <", value, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ota_status <=", value, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusIn(List<Integer> values) {
            addCriterion("ota_status in", values, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusNotIn(List<Integer> values) {
            addCriterion("ota_status not in", values, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusBetween(Integer value1, Integer value2) {
            addCriterion("ota_status between", value1, value2, "otaStatus");
            return (Criteria) this;
        }

        public Criteria andOtaStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ota_status not between", value1, value2, "otaStatus");
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