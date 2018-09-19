package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class InternalTrainingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InternalTrainingExample() {
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

        public Criteria andItIdIsNull() {
            addCriterion("it_id is null");
            return (Criteria) this;
        }

        public Criteria andItIdIsNotNull() {
            addCriterion("it_id is not null");
            return (Criteria) this;
        }

        public Criteria andItIdEqualTo(String value) {
            addCriterion("it_id =", value, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdNotEqualTo(String value) {
            addCriterion("it_id <>", value, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdGreaterThan(String value) {
            addCriterion("it_id >", value, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdGreaterThanOrEqualTo(String value) {
            addCriterion("it_id >=", value, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdLessThan(String value) {
            addCriterion("it_id <", value, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdLessThanOrEqualTo(String value) {
            addCriterion("it_id <=", value, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdLike(String value) {
            addCriterion("it_id like", value, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdNotLike(String value) {
            addCriterion("it_id not like", value, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdIn(List<String> values) {
            addCriterion("it_id in", values, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdNotIn(List<String> values) {
            addCriterion("it_id not in", values, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdBetween(String value1, String value2) {
            addCriterion("it_id between", value1, value2, "itId");
            return (Criteria) this;
        }

        public Criteria andItIdNotBetween(String value1, String value2) {
            addCriterion("it_id not between", value1, value2, "itId");
            return (Criteria) this;
        }

        public Criteria andTrainingManIsNull() {
            addCriterion("training_man is null");
            return (Criteria) this;
        }

        public Criteria andTrainingManIsNotNull() {
            addCriterion("training_man is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingManEqualTo(String value) {
            addCriterion("training_man =", value, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManNotEqualTo(String value) {
            addCriterion("training_man <>", value, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManGreaterThan(String value) {
            addCriterion("training_man >", value, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManGreaterThanOrEqualTo(String value) {
            addCriterion("training_man >=", value, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManLessThan(String value) {
            addCriterion("training_man <", value, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManLessThanOrEqualTo(String value) {
            addCriterion("training_man <=", value, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManLike(String value) {
            addCriterion("training_man like", value, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManNotLike(String value) {
            addCriterion("training_man not like", value, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManIn(List<String> values) {
            addCriterion("training_man in", values, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManNotIn(List<String> values) {
            addCriterion("training_man not in", values, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManBetween(String value1, String value2) {
            addCriterion("training_man between", value1, value2, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andTrainingManNotBetween(String value1, String value2) {
            addCriterion("training_man not between", value1, value2, "trainingMan");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(Integer value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(Integer value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(Integer value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(Integer value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(Integer value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<Integer> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<Integer> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(Integer value1, Integer value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(Integer value1, Integer value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(Integer value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(Integer value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(Integer value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(Integer value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(Integer value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(Integer value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<Integer> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<Integer> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(Integer value1, Integer value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(Integer value1, Integer value2) {
            addCriterion("duty not between", value1, value2, "duty");
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

        public Criteria andTrainingMoneyEqualTo(Double value) {
            addCriterion("training_money =", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyNotEqualTo(Double value) {
            addCriterion("training_money <>", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyGreaterThan(Double value) {
            addCriterion("training_money >", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("training_money >=", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyLessThan(Double value) {
            addCriterion("training_money <", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyLessThanOrEqualTo(Double value) {
            addCriterion("training_money <=", value, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyIn(List<Double> values) {
            addCriterion("training_money in", values, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyNotIn(List<Double> values) {
            addCriterion("training_money not in", values, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyBetween(Double value1, Double value2) {
            addCriterion("training_money between", value1, value2, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andTrainingMoneyNotBetween(Double value1, Double value2) {
            addCriterion("training_money not between", value1, value2, "trainingMoney");
            return (Criteria) this;
        }

        public Criteria andItAccessoryIsNull() {
            addCriterion("it_accessory is null");
            return (Criteria) this;
        }

        public Criteria andItAccessoryIsNotNull() {
            addCriterion("it_accessory is not null");
            return (Criteria) this;
        }

        public Criteria andItAccessoryEqualTo(String value) {
            addCriterion("it_accessory =", value, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryNotEqualTo(String value) {
            addCriterion("it_accessory <>", value, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryGreaterThan(String value) {
            addCriterion("it_accessory >", value, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryGreaterThanOrEqualTo(String value) {
            addCriterion("it_accessory >=", value, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryLessThan(String value) {
            addCriterion("it_accessory <", value, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryLessThanOrEqualTo(String value) {
            addCriterion("it_accessory <=", value, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryLike(String value) {
            addCriterion("it_accessory like", value, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryNotLike(String value) {
            addCriterion("it_accessory not like", value, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryIn(List<String> values) {
            addCriterion("it_accessory in", values, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryNotIn(List<String> values) {
            addCriterion("it_accessory not in", values, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryBetween(String value1, String value2) {
            addCriterion("it_accessory between", value1, value2, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItAccessoryNotBetween(String value1, String value2) {
            addCriterion("it_accessory not between", value1, value2, "itAccessory");
            return (Criteria) this;
        }

        public Criteria andItStatusIsNull() {
            addCriterion("it_status is null");
            return (Criteria) this;
        }

        public Criteria andItStatusIsNotNull() {
            addCriterion("it_status is not null");
            return (Criteria) this;
        }

        public Criteria andItStatusEqualTo(Integer value) {
            addCriterion("it_status =", value, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusNotEqualTo(Integer value) {
            addCriterion("it_status <>", value, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusGreaterThan(Integer value) {
            addCriterion("it_status >", value, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("it_status >=", value, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusLessThan(Integer value) {
            addCriterion("it_status <", value, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusLessThanOrEqualTo(Integer value) {
            addCriterion("it_status <=", value, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusIn(List<Integer> values) {
            addCriterion("it_status in", values, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusNotIn(List<Integer> values) {
            addCriterion("it_status not in", values, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusBetween(Integer value1, Integer value2) {
            addCriterion("it_status between", value1, value2, "itStatus");
            return (Criteria) this;
        }

        public Criteria andItStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("it_status not between", value1, value2, "itStatus");
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