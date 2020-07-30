package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OutTrainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutTrainExample() {
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

        public Criteria andOtIdIsNull() {
            addCriterion("ot_id is null");
            return (Criteria) this;
        }

        public Criteria andOtIdIsNotNull() {
            addCriterion("ot_id is not null");
            return (Criteria) this;
        }

        public Criteria andOtIdEqualTo(String value) {
            addCriterion("ot_id =", value, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdNotEqualTo(String value) {
            addCriterion("ot_id <>", value, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdGreaterThan(String value) {
            addCriterion("ot_id >", value, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdGreaterThanOrEqualTo(String value) {
            addCriterion("ot_id >=", value, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdLessThan(String value) {
            addCriterion("ot_id <", value, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdLessThanOrEqualTo(String value) {
            addCriterion("ot_id <=", value, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdLike(String value) {
            addCriterion("ot_id like", value, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdNotLike(String value) {
            addCriterion("ot_id not like", value, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdIn(List<String> values) {
            addCriterion("ot_id in", values, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdNotIn(List<String> values) {
            addCriterion("ot_id not in", values, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdBetween(String value1, String value2) {
            addCriterion("ot_id between", value1, value2, "otId");
            return (Criteria) this;
        }

        public Criteria andOtIdNotBetween(String value1, String value2) {
            addCriterion("ot_id not between", value1, value2, "otId");
            return (Criteria) this;
        }

        public Criteria andOtTitleIsNull() {
            addCriterion("ot_title is null");
            return (Criteria) this;
        }

        public Criteria andOtTitleIsNotNull() {
            addCriterion("ot_title is not null");
            return (Criteria) this;
        }

        public Criteria andOtTitleEqualTo(String value) {
            addCriterion("ot_title =", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotEqualTo(String value) {
            addCriterion("ot_title <>", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleGreaterThan(String value) {
            addCriterion("ot_title >", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ot_title >=", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLessThan(String value) {
            addCriterion("ot_title <", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLessThanOrEqualTo(String value) {
            addCriterion("ot_title <=", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleLike(String value) {
            addCriterion("ot_title like", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotLike(String value) {
            addCriterion("ot_title not like", value, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleIn(List<String> values) {
            addCriterion("ot_title in", values, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotIn(List<String> values) {
            addCriterion("ot_title not in", values, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleBetween(String value1, String value2) {
            addCriterion("ot_title between", value1, value2, "otTitle");
            return (Criteria) this;
        }

        public Criteria andOtTitleNotBetween(String value1, String value2) {
            addCriterion("ot_title not between", value1, value2, "otTitle");
            return (Criteria) this;
        }

        public Criteria andProposerIsNull() {
            addCriterion("proposer is null");
            return (Criteria) this;
        }

        public Criteria andProposerIsNotNull() {
            addCriterion("proposer is not null");
            return (Criteria) this;
        }

        public Criteria andProposerEqualTo(String value) {
            addCriterion("proposer =", value, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerNotEqualTo(String value) {
            addCriterion("proposer <>", value, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerGreaterThan(String value) {
            addCriterion("proposer >", value, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerGreaterThanOrEqualTo(String value) {
            addCriterion("proposer >=", value, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerLessThan(String value) {
            addCriterion("proposer <", value, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerLessThanOrEqualTo(String value) {
            addCriterion("proposer <=", value, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerLike(String value) {
            addCriterion("proposer like", value, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerNotLike(String value) {
            addCriterion("proposer not like", value, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerIn(List<String> values) {
            addCriterion("proposer in", values, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerNotIn(List<String> values) {
            addCriterion("proposer not in", values, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerBetween(String value1, String value2) {
            addCriterion("proposer between", value1, value2, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerNotBetween(String value1, String value2) {
            addCriterion("proposer not between", value1, value2, "proposer");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentIsNull() {
            addCriterion("proposer_department is null");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentIsNotNull() {
            addCriterion("proposer_department is not null");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentEqualTo(Integer value) {
            addCriterion("proposer_department =", value, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentNotEqualTo(Integer value) {
            addCriterion("proposer_department <>", value, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentGreaterThan(Integer value) {
            addCriterion("proposer_department >", value, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("proposer_department >=", value, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentLessThan(Integer value) {
            addCriterion("proposer_department <", value, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentLessThanOrEqualTo(Integer value) {
            addCriterion("proposer_department <=", value, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentIn(List<Integer> values) {
            addCriterion("proposer_department in", values, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentNotIn(List<Integer> values) {
            addCriterion("proposer_department not in", values, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentBetween(Integer value1, Integer value2) {
            addCriterion("proposer_department between", value1, value2, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andProposerDepartmentNotBetween(Integer value1, Integer value2) {
            addCriterion("proposer_department not between", value1, value2, "proposerDepartment");
            return (Criteria) this;
        }

        public Criteria andDutyIdIsNull() {
            addCriterion("duty_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyIdIsNotNull() {
            addCriterion("duty_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyIdEqualTo(Integer value) {
            addCriterion("duty_id =", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotEqualTo(Integer value) {
            addCriterion("duty_id <>", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdGreaterThan(Integer value) {
            addCriterion("duty_id >", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("duty_id >=", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdLessThan(Integer value) {
            addCriterion("duty_id <", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdLessThanOrEqualTo(Integer value) {
            addCriterion("duty_id <=", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdIn(List<Integer> values) {
            addCriterion("duty_id in", values, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotIn(List<Integer> values) {
            addCriterion("duty_id not in", values, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdBetween(Integer value1, Integer value2) {
            addCriterion("duty_id between", value1, value2, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("duty_id not between", value1, value2, "dutyId");
            return (Criteria) this;
        }

        public Criteria andOtDateIsNull() {
            addCriterion("ot_date is null");
            return (Criteria) this;
        }

        public Criteria andOtDateIsNotNull() {
            addCriterion("ot_date is not null");
            return (Criteria) this;
        }

        public Criteria andOtDateEqualTo(String value) {
            addCriterion("ot_date =", value, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateNotEqualTo(String value) {
            addCriterion("ot_date <>", value, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateGreaterThan(String value) {
            addCriterion("ot_date >", value, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateGreaterThanOrEqualTo(String value) {
            addCriterion("ot_date >=", value, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateLessThan(String value) {
            addCriterion("ot_date <", value, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateLessThanOrEqualTo(String value) {
            addCriterion("ot_date <=", value, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateLike(String value) {
            addCriterion("ot_date like", value, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateNotLike(String value) {
            addCriterion("ot_date not like", value, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateIn(List<String> values) {
            addCriterion("ot_date in", values, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateNotIn(List<String> values) {
            addCriterion("ot_date not in", values, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateBetween(String value1, String value2) {
            addCriterion("ot_date between", value1, value2, "otDate");
            return (Criteria) this;
        }

        public Criteria andOtDateNotBetween(String value1, String value2) {
            addCriterion("ot_date not between", value1, value2, "otDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNull() {
            addCriterion("application_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNotNull() {
            addCriterion("application_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateEqualTo(String value) {
            addCriterion("application_date =", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotEqualTo(String value) {
            addCriterion("application_date <>", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThan(String value) {
            addCriterion("application_date >", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThanOrEqualTo(String value) {
            addCriterion("application_date >=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThan(String value) {
            addCriterion("application_date <", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThanOrEqualTo(String value) {
            addCriterion("application_date <=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLike(String value) {
            addCriterion("application_date like", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotLike(String value) {
            addCriterion("application_date not like", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIn(List<String> values) {
            addCriterion("application_date in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotIn(List<String> values) {
            addCriterion("application_date not in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateBetween(String value1, String value2) {
            addCriterion("application_date between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotBetween(String value1, String value2) {
            addCriterion("application_date not between", value1, value2, "applicationDate");
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

        public Criteria andOtStatusIsNull() {
            addCriterion("ot_status is null");
            return (Criteria) this;
        }

        public Criteria andOtStatusIsNotNull() {
            addCriterion("ot_status is not null");
            return (Criteria) this;
        }

        public Criteria andOtStatusEqualTo(Integer value) {
            addCriterion("ot_status =", value, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusNotEqualTo(Integer value) {
            addCriterion("ot_status <>", value, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusGreaterThan(Integer value) {
            addCriterion("ot_status >", value, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ot_status >=", value, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusLessThan(Integer value) {
            addCriterion("ot_status <", value, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ot_status <=", value, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusIn(List<Integer> values) {
            addCriterion("ot_status in", values, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusNotIn(List<Integer> values) {
            addCriterion("ot_status not in", values, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusBetween(Integer value1, Integer value2) {
            addCriterion("ot_status between", value1, value2, "otStatus");
            return (Criteria) this;
        }

        public Criteria andOtStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ot_status not between", value1, value2, "otStatus");
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