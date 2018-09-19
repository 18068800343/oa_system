package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class FbContractReopenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbContractReopenExample() {
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

        public Criteria andFbrIdIsNull() {
            addCriterion("fbr_id is null");
            return (Criteria) this;
        }

        public Criteria andFbrIdIsNotNull() {
            addCriterion("fbr_id is not null");
            return (Criteria) this;
        }

        public Criteria andFbrIdEqualTo(String value) {
            addCriterion("fbr_id =", value, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdNotEqualTo(String value) {
            addCriterion("fbr_id <>", value, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdGreaterThan(String value) {
            addCriterion("fbr_id >", value, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdGreaterThanOrEqualTo(String value) {
            addCriterion("fbr_id >=", value, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdLessThan(String value) {
            addCriterion("fbr_id <", value, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdLessThanOrEqualTo(String value) {
            addCriterion("fbr_id <=", value, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdLike(String value) {
            addCriterion("fbr_id like", value, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdNotLike(String value) {
            addCriterion("fbr_id not like", value, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdIn(List<String> values) {
            addCriterion("fbr_id in", values, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdNotIn(List<String> values) {
            addCriterion("fbr_id not in", values, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdBetween(String value1, String value2) {
            addCriterion("fbr_id between", value1, value2, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbrIdNotBetween(String value1, String value2) {
            addCriterion("fbr_id not between", value1, value2, "fbrId");
            return (Criteria) this;
        }

        public Criteria andFbIdIsNull() {
            addCriterion("fb_id is null");
            return (Criteria) this;
        }

        public Criteria andFbIdIsNotNull() {
            addCriterion("fb_id is not null");
            return (Criteria) this;
        }

        public Criteria andFbIdEqualTo(String value) {
            addCriterion("fb_id =", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotEqualTo(String value) {
            addCriterion("fb_id <>", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdGreaterThan(String value) {
            addCriterion("fb_id >", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdGreaterThanOrEqualTo(String value) {
            addCriterion("fb_id >=", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLessThan(String value) {
            addCriterion("fb_id <", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLessThanOrEqualTo(String value) {
            addCriterion("fb_id <=", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLike(String value) {
            addCriterion("fb_id like", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotLike(String value) {
            addCriterion("fb_id not like", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdIn(List<String> values) {
            addCriterion("fb_id in", values, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotIn(List<String> values) {
            addCriterion("fb_id not in", values, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdBetween(String value1, String value2) {
            addCriterion("fb_id between", value1, value2, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotBetween(String value1, String value2) {
            addCriterion("fb_id not between", value1, value2, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeIsNull() {
            addCriterion("fb_contract_code is null");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeIsNotNull() {
            addCriterion("fb_contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeEqualTo(String value) {
            addCriterion("fb_contract_code =", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeNotEqualTo(String value) {
            addCriterion("fb_contract_code <>", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeGreaterThan(String value) {
            addCriterion("fb_contract_code >", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fb_contract_code >=", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeLessThan(String value) {
            addCriterion("fb_contract_code <", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeLessThanOrEqualTo(String value) {
            addCriterion("fb_contract_code <=", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeLike(String value) {
            addCriterion("fb_contract_code like", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeNotLike(String value) {
            addCriterion("fb_contract_code not like", value, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeIn(List<String> values) {
            addCriterion("fb_contract_code in", values, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeNotIn(List<String> values) {
            addCriterion("fb_contract_code not in", values, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeBetween(String value1, String value2) {
            addCriterion("fb_contract_code between", value1, value2, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractCodeNotBetween(String value1, String value2) {
            addCriterion("fb_contract_code not between", value1, value2, "fbContractCode");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonIsNull() {
            addCriterion("fb_contract_reopen_reason is null");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonIsNotNull() {
            addCriterion("fb_contract_reopen_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonEqualTo(String value) {
            addCriterion("fb_contract_reopen_reason =", value, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonNotEqualTo(String value) {
            addCriterion("fb_contract_reopen_reason <>", value, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonGreaterThan(String value) {
            addCriterion("fb_contract_reopen_reason >", value, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonGreaterThanOrEqualTo(String value) {
            addCriterion("fb_contract_reopen_reason >=", value, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonLessThan(String value) {
            addCriterion("fb_contract_reopen_reason <", value, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonLessThanOrEqualTo(String value) {
            addCriterion("fb_contract_reopen_reason <=", value, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonLike(String value) {
            addCriterion("fb_contract_reopen_reason like", value, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonNotLike(String value) {
            addCriterion("fb_contract_reopen_reason not like", value, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonIn(List<String> values) {
            addCriterion("fb_contract_reopen_reason in", values, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonNotIn(List<String> values) {
            addCriterion("fb_contract_reopen_reason not in", values, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonBetween(String value1, String value2) {
            addCriterion("fb_contract_reopen_reason between", value1, value2, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andFbContractReopenReasonNotBetween(String value1, String value2) {
            addCriterion("fb_contract_reopen_reason not between", value1, value2, "fbContractReopenReason");
            return (Criteria) this;
        }

        public Criteria andReopenTimeIsNull() {
            addCriterion("reopen_time is null");
            return (Criteria) this;
        }

        public Criteria andReopenTimeIsNotNull() {
            addCriterion("reopen_time is not null");
            return (Criteria) this;
        }

        public Criteria andReopenTimeEqualTo(String value) {
            addCriterion("reopen_time =", value, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeNotEqualTo(String value) {
            addCriterion("reopen_time <>", value, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeGreaterThan(String value) {
            addCriterion("reopen_time >", value, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("reopen_time >=", value, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeLessThan(String value) {
            addCriterion("reopen_time <", value, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeLessThanOrEqualTo(String value) {
            addCriterion("reopen_time <=", value, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeLike(String value) {
            addCriterion("reopen_time like", value, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeNotLike(String value) {
            addCriterion("reopen_time not like", value, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeIn(List<String> values) {
            addCriterion("reopen_time in", values, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeNotIn(List<String> values) {
            addCriterion("reopen_time not in", values, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeBetween(String value1, String value2) {
            addCriterion("reopen_time between", value1, value2, "reopenTime");
            return (Criteria) this;
        }

        public Criteria andReopenTimeNotBetween(String value1, String value2) {
            addCriterion("reopen_time not between", value1, value2, "reopenTime");
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