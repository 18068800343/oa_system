package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class FlowNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlowNodeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftIsNull() {
            addCriterion("Flo_Node_Left is null");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftIsNotNull() {
            addCriterion("Flo_Node_Left is not null");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftEqualTo(String value) {
            addCriterion("Flo_Node_Left =", value, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftNotEqualTo(String value) {
            addCriterion("Flo_Node_Left <>", value, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftGreaterThan(String value) {
            addCriterion("Flo_Node_Left >", value, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftGreaterThanOrEqualTo(String value) {
            addCriterion("Flo_Node_Left >=", value, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftLessThan(String value) {
            addCriterion("Flo_Node_Left <", value, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftLessThanOrEqualTo(String value) {
            addCriterion("Flo_Node_Left <=", value, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftLike(String value) {
            addCriterion("Flo_Node_Left like", value, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftNotLike(String value) {
            addCriterion("Flo_Node_Left not like", value, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftIn(List<String> values) {
            addCriterion("Flo_Node_Left in", values, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftNotIn(List<String> values) {
            addCriterion("Flo_Node_Left not in", values, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftBetween(String value1, String value2) {
            addCriterion("Flo_Node_Left between", value1, value2, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloNodeLeftNotBetween(String value1, String value2) {
            addCriterion("Flo_Node_Left not between", value1, value2, "floNodeLeft");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdIsNull() {
            addCriterion("Flo_Tmp_ID is null");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdIsNotNull() {
            addCriterion("Flo_Tmp_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdEqualTo(String value) {
            addCriterion("Flo_Tmp_ID =", value, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdNotEqualTo(String value) {
            addCriterion("Flo_Tmp_ID <>", value, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdGreaterThan(String value) {
            addCriterion("Flo_Tmp_ID >", value, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("Flo_Tmp_ID >=", value, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdLessThan(String value) {
            addCriterion("Flo_Tmp_ID <", value, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdLessThanOrEqualTo(String value) {
            addCriterion("Flo_Tmp_ID <=", value, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdLike(String value) {
            addCriterion("Flo_Tmp_ID like", value, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdNotLike(String value) {
            addCriterion("Flo_Tmp_ID not like", value, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdIn(List<String> values) {
            addCriterion("Flo_Tmp_ID in", values, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdNotIn(List<String> values) {
            addCriterion("Flo_Tmp_ID not in", values, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdBetween(String value1, String value2) {
            addCriterion("Flo_Tmp_ID between", value1, value2, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFloTmpIdNotBetween(String value1, String value2) {
            addCriterion("Flo_Tmp_ID not between", value1, value2, "floTmpId");
            return (Criteria) this;
        }

        public Criteria andFlownodenameIsNull() {
            addCriterion("FlowNodeName is null");
            return (Criteria) this;
        }

        public Criteria andFlownodenameIsNotNull() {
            addCriterion("FlowNodeName is not null");
            return (Criteria) this;
        }

        public Criteria andFlownodenameEqualTo(String value) {
            addCriterion("FlowNodeName =", value, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameNotEqualTo(String value) {
            addCriterion("FlowNodeName <>", value, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameGreaterThan(String value) {
            addCriterion("FlowNodeName >", value, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameGreaterThanOrEqualTo(String value) {
            addCriterion("FlowNodeName >=", value, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameLessThan(String value) {
            addCriterion("FlowNodeName <", value, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameLessThanOrEqualTo(String value) {
            addCriterion("FlowNodeName <=", value, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameLike(String value) {
            addCriterion("FlowNodeName like", value, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameNotLike(String value) {
            addCriterion("FlowNodeName not like", value, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameIn(List<String> values) {
            addCriterion("FlowNodeName in", values, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameNotIn(List<String> values) {
            addCriterion("FlowNodeName not in", values, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameBetween(String value1, String value2) {
            addCriterion("FlowNodeName between", value1, value2, "flownodename");
            return (Criteria) this;
        }

        public Criteria andFlownodenameNotBetween(String value1, String value2) {
            addCriterion("FlowNodeName not between", value1, value2, "flownodename");
            return (Criteria) this;
        }

        public Criteria andTipIsNull() {
            addCriterion("Tip is null");
            return (Criteria) this;
        }

        public Criteria andTipIsNotNull() {
            addCriterion("Tip is not null");
            return (Criteria) this;
        }

        public Criteria andTipEqualTo(String value) {
            addCriterion("Tip =", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipNotEqualTo(String value) {
            addCriterion("Tip <>", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipGreaterThan(String value) {
            addCriterion("Tip >", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipGreaterThanOrEqualTo(String value) {
            addCriterion("Tip >=", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipLessThan(String value) {
            addCriterion("Tip <", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipLessThanOrEqualTo(String value) {
            addCriterion("Tip <=", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipLike(String value) {
            addCriterion("Tip like", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipNotLike(String value) {
            addCriterion("Tip not like", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipIn(List<String> values) {
            addCriterion("Tip in", values, "tip");
            return (Criteria) this;
        }

        public Criteria andTipNotIn(List<String> values) {
            addCriterion("Tip not in", values, "tip");
            return (Criteria) this;
        }

        public Criteria andTipBetween(String value1, String value2) {
            addCriterion("Tip between", value1, value2, "tip");
            return (Criteria) this;
        }

        public Criteria andTipNotBetween(String value1, String value2) {
            addCriterion("Tip not between", value1, value2, "tip");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("Step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("Step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("Step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("Step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("Step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("Step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("Step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("Step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("Step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("Step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("Step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("Step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeIsNull() {
            addCriterion("NodeWorkType is null");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeIsNotNull() {
            addCriterion("NodeWorkType is not null");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeEqualTo(Integer value) {
            addCriterion("NodeWorkType =", value, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeNotEqualTo(Integer value) {
            addCriterion("NodeWorkType <>", value, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeGreaterThan(Integer value) {
            addCriterion("NodeWorkType >", value, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("NodeWorkType >=", value, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeLessThan(Integer value) {
            addCriterion("NodeWorkType <", value, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeLessThanOrEqualTo(Integer value) {
            addCriterion("NodeWorkType <=", value, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeIn(List<Integer> values) {
            addCriterion("NodeWorkType in", values, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeNotIn(List<Integer> values) {
            addCriterion("NodeWorkType not in", values, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeBetween(Integer value1, Integer value2) {
            addCriterion("NodeWorkType between", value1, value2, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andNodeworktypeNotBetween(Integer value1, Integer value2) {
            addCriterion("NodeWorkType not between", value1, value2, "nodeworktype");
            return (Criteria) this;
        }

        public Criteria andTspandayIsNull() {
            addCriterion("TSpanDay is null");
            return (Criteria) this;
        }

        public Criteria andTspandayIsNotNull() {
            addCriterion("TSpanDay is not null");
            return (Criteria) this;
        }

        public Criteria andTspandayEqualTo(Double value) {
            addCriterion("TSpanDay =", value, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayNotEqualTo(Double value) {
            addCriterion("TSpanDay <>", value, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayGreaterThan(Double value) {
            addCriterion("TSpanDay >", value, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayGreaterThanOrEqualTo(Double value) {
            addCriterion("TSpanDay >=", value, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayLessThan(Double value) {
            addCriterion("TSpanDay <", value, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayLessThanOrEqualTo(Double value) {
            addCriterion("TSpanDay <=", value, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayIn(List<Double> values) {
            addCriterion("TSpanDay in", values, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayNotIn(List<Double> values) {
            addCriterion("TSpanDay not in", values, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayBetween(Double value1, Double value2) {
            addCriterion("TSpanDay between", value1, value2, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspandayNotBetween(Double value1, Double value2) {
            addCriterion("TSpanDay not between", value1, value2, "tspanday");
            return (Criteria) this;
        }

        public Criteria andTspanhourIsNull() {
            addCriterion("TSpanHour is null");
            return (Criteria) this;
        }

        public Criteria andTspanhourIsNotNull() {
            addCriterion("TSpanHour is not null");
            return (Criteria) this;
        }

        public Criteria andTspanhourEqualTo(Double value) {
            addCriterion("TSpanHour =", value, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourNotEqualTo(Double value) {
            addCriterion("TSpanHour <>", value, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourGreaterThan(Double value) {
            addCriterion("TSpanHour >", value, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourGreaterThanOrEqualTo(Double value) {
            addCriterion("TSpanHour >=", value, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourLessThan(Double value) {
            addCriterion("TSpanHour <", value, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourLessThanOrEqualTo(Double value) {
            addCriterion("TSpanHour <=", value, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourIn(List<Double> values) {
            addCriterion("TSpanHour in", values, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourNotIn(List<Double> values) {
            addCriterion("TSpanHour not in", values, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourBetween(Double value1, Double value2) {
            addCriterion("TSpanHour between", value1, value2, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andTspanhourNotBetween(Double value1, Double value2) {
            addCriterion("TSpanHour not between", value1, value2, "tspanhour");
            return (Criteria) this;
        }

        public Criteria andWarningdayIsNull() {
            addCriterion("WarningDay is null");
            return (Criteria) this;
        }

        public Criteria andWarningdayIsNotNull() {
            addCriterion("WarningDay is not null");
            return (Criteria) this;
        }

        public Criteria andWarningdayEqualTo(Double value) {
            addCriterion("WarningDay =", value, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayNotEqualTo(Double value) {
            addCriterion("WarningDay <>", value, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayGreaterThan(Double value) {
            addCriterion("WarningDay >", value, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayGreaterThanOrEqualTo(Double value) {
            addCriterion("WarningDay >=", value, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayLessThan(Double value) {
            addCriterion("WarningDay <", value, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayLessThanOrEqualTo(Double value) {
            addCriterion("WarningDay <=", value, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayIn(List<Double> values) {
            addCriterion("WarningDay in", values, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayNotIn(List<Double> values) {
            addCriterion("WarningDay not in", values, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayBetween(Double value1, Double value2) {
            addCriterion("WarningDay between", value1, value2, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarningdayNotBetween(Double value1, Double value2) {
            addCriterion("WarningDay not between", value1, value2, "warningday");
            return (Criteria) this;
        }

        public Criteria andWarninghourIsNull() {
            addCriterion("WarningHour is null");
            return (Criteria) this;
        }

        public Criteria andWarninghourIsNotNull() {
            addCriterion("WarningHour is not null");
            return (Criteria) this;
        }

        public Criteria andWarninghourEqualTo(Double value) {
            addCriterion("WarningHour =", value, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourNotEqualTo(Double value) {
            addCriterion("WarningHour <>", value, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourGreaterThan(Double value) {
            addCriterion("WarningHour >", value, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourGreaterThanOrEqualTo(Double value) {
            addCriterion("WarningHour >=", value, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourLessThan(Double value) {
            addCriterion("WarningHour <", value, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourLessThanOrEqualTo(Double value) {
            addCriterion("WarningHour <=", value, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourIn(List<Double> values) {
            addCriterion("WarningHour in", values, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourNotIn(List<Double> values) {
            addCriterion("WarningHour not in", values, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourBetween(Double value1, Double value2) {
            addCriterion("WarningHour between", value1, value2, "warninghour");
            return (Criteria) this;
        }

        public Criteria andWarninghourNotBetween(Double value1, Double value2) {
            addCriterion("WarningHour not between", value1, value2, "warninghour");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameIsNull() {
            addCriterion("FWCNodeName is null");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameIsNotNull() {
            addCriterion("FWCNodeName is not null");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameEqualTo(String value) {
            addCriterion("FWCNodeName =", value, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameNotEqualTo(String value) {
            addCriterion("FWCNodeName <>", value, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameGreaterThan(String value) {
            addCriterion("FWCNodeName >", value, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameGreaterThanOrEqualTo(String value) {
            addCriterion("FWCNodeName >=", value, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameLessThan(String value) {
            addCriterion("FWCNodeName <", value, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameLessThanOrEqualTo(String value) {
            addCriterion("FWCNodeName <=", value, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameLike(String value) {
            addCriterion("FWCNodeName like", value, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameNotLike(String value) {
            addCriterion("FWCNodeName not like", value, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameIn(List<String> values) {
            addCriterion("FWCNodeName in", values, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameNotIn(List<String> values) {
            addCriterion("FWCNodeName not in", values, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameBetween(String value1, String value2) {
            addCriterion("FWCNodeName between", value1, value2, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andFwcnodenameNotBetween(String value1, String value2) {
            addCriterion("FWCNodeName not between", value1, value2, "fwcnodename");
            return (Criteria) this;
        }

        public Criteria andDocIsNull() {
            addCriterion("Doc is null");
            return (Criteria) this;
        }

        public Criteria andDocIsNotNull() {
            addCriterion("Doc is not null");
            return (Criteria) this;
        }

        public Criteria andDocEqualTo(String value) {
            addCriterion("Doc =", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotEqualTo(String value) {
            addCriterion("Doc <>", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocGreaterThan(String value) {
            addCriterion("Doc >", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocGreaterThanOrEqualTo(String value) {
            addCriterion("Doc >=", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLessThan(String value) {
            addCriterion("Doc <", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLessThanOrEqualTo(String value) {
            addCriterion("Doc <=", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLike(String value) {
            addCriterion("Doc like", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotLike(String value) {
            addCriterion("Doc not like", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocIn(List<String> values) {
            addCriterion("Doc in", values, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotIn(List<String> values) {
            addCriterion("Doc not in", values, "doc");
            return (Criteria) this;
        }

        public Criteria andDocBetween(String value1, String value2) {
            addCriterion("Doc between", value1, value2, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotBetween(String value1, String value2) {
            addCriterion("Doc not between", value1, value2, "doc");
            return (Criteria) this;
        }

        public Criteria andReturnroleIsNull() {
            addCriterion("ReturnRole is null");
            return (Criteria) this;
        }

        public Criteria andReturnroleIsNotNull() {
            addCriterion("ReturnRole is not null");
            return (Criteria) this;
        }

        public Criteria andReturnroleEqualTo(Integer value) {
            addCriterion("ReturnRole =", value, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleNotEqualTo(Integer value) {
            addCriterion("ReturnRole <>", value, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleGreaterThan(Integer value) {
            addCriterion("ReturnRole >", value, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReturnRole >=", value, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleLessThan(Integer value) {
            addCriterion("ReturnRole <", value, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleLessThanOrEqualTo(Integer value) {
            addCriterion("ReturnRole <=", value, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleIn(List<Integer> values) {
            addCriterion("ReturnRole in", values, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleNotIn(List<Integer> values) {
            addCriterion("ReturnRole not in", values, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleBetween(Integer value1, Integer value2) {
            addCriterion("ReturnRole between", value1, value2, "returnrole");
            return (Criteria) this;
        }

        public Criteria andReturnroleNotBetween(Integer value1, Integer value2) {
            addCriterion("ReturnRole not between", value1, value2, "returnrole");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderIsNull() {
            addCriterion("IsExpSender is null");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderIsNotNull() {
            addCriterion("IsExpSender is not null");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderEqualTo(Integer value) {
            addCriterion("IsExpSender =", value, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderNotEqualTo(Integer value) {
            addCriterion("IsExpSender <>", value, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderGreaterThan(Integer value) {
            addCriterion("IsExpSender >", value, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsExpSender >=", value, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderLessThan(Integer value) {
            addCriterion("IsExpSender <", value, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderLessThanOrEqualTo(Integer value) {
            addCriterion("IsExpSender <=", value, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderIn(List<Integer> values) {
            addCriterion("IsExpSender in", values, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderNotIn(List<Integer> values) {
            addCriterion("IsExpSender not in", values, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderBetween(Integer value1, Integer value2) {
            addCriterion("IsExpSender between", value1, value2, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andIsexpsenderNotBetween(Integer value1, Integer value2) {
            addCriterion("IsExpSender not between", value1, value2, "isexpsender");
            return (Criteria) this;
        }

        public Criteria andCancelroleIsNull() {
            addCriterion("CancelRole is null");
            return (Criteria) this;
        }

        public Criteria andCancelroleIsNotNull() {
            addCriterion("CancelRole is not null");
            return (Criteria) this;
        }

        public Criteria andCancelroleEqualTo(Integer value) {
            addCriterion("CancelRole =", value, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleNotEqualTo(Integer value) {
            addCriterion("CancelRole <>", value, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleGreaterThan(Integer value) {
            addCriterion("CancelRole >", value, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleGreaterThanOrEqualTo(Integer value) {
            addCriterion("CancelRole >=", value, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleLessThan(Integer value) {
            addCriterion("CancelRole <", value, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleLessThanOrEqualTo(Integer value) {
            addCriterion("CancelRole <=", value, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleIn(List<Integer> values) {
            addCriterion("CancelRole in", values, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleNotIn(List<Integer> values) {
            addCriterion("CancelRole not in", values, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleBetween(Integer value1, Integer value2) {
            addCriterion("CancelRole between", value1, value2, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andCancelroleNotBetween(Integer value1, Integer value2) {
            addCriterion("CancelRole not between", value1, value2, "cancelrole");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerIsNull() {
            addCriterion("WhenNoWorker is null");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerIsNotNull() {
            addCriterion("WhenNoWorker is not null");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerEqualTo(Integer value) {
            addCriterion("WhenNoWorker =", value, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerNotEqualTo(Integer value) {
            addCriterion("WhenNoWorker <>", value, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerGreaterThan(Integer value) {
            addCriterion("WhenNoWorker >", value, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerGreaterThanOrEqualTo(Integer value) {
            addCriterion("WhenNoWorker >=", value, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerLessThan(Integer value) {
            addCriterion("WhenNoWorker <", value, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerLessThanOrEqualTo(Integer value) {
            addCriterion("WhenNoWorker <=", value, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerIn(List<Integer> values) {
            addCriterion("WhenNoWorker in", values, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerNotIn(List<Integer> values) {
            addCriterion("WhenNoWorker not in", values, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerBetween(Integer value1, Integer value2) {
            addCriterion("WhenNoWorker between", value1, value2, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andWhennoworkerNotBetween(Integer value1, Integer value2) {
            addCriterion("WhenNoWorker not between", value1, value2, "whennoworker");
            return (Criteria) this;
        }

        public Criteria andCcroleIsNull() {
            addCriterion("CCRole is null");
            return (Criteria) this;
        }

        public Criteria andCcroleIsNotNull() {
            addCriterion("CCRole is not null");
            return (Criteria) this;
        }

        public Criteria andCcroleEqualTo(Integer value) {
            addCriterion("CCRole =", value, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleNotEqualTo(Integer value) {
            addCriterion("CCRole <>", value, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleGreaterThan(Integer value) {
            addCriterion("CCRole >", value, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleGreaterThanOrEqualTo(Integer value) {
            addCriterion("CCRole >=", value, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleLessThan(Integer value) {
            addCriterion("CCRole <", value, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleLessThanOrEqualTo(Integer value) {
            addCriterion("CCRole <=", value, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleIn(List<Integer> values) {
            addCriterion("CCRole in", values, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleNotIn(List<Integer> values) {
            addCriterion("CCRole not in", values, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleBetween(Integer value1, Integer value2) {
            addCriterion("CCRole between", value1, value2, "ccrole");
            return (Criteria) this;
        }

        public Criteria andCcroleNotBetween(Integer value1, Integer value2) {
            addCriterion("CCRole not between", value1, value2, "ccrole");
            return (Criteria) this;
        }

        public Criteria andIscanoverIsNull() {
            addCriterion("IsCanOver is null");
            return (Criteria) this;
        }

        public Criteria andIscanoverIsNotNull() {
            addCriterion("IsCanOver is not null");
            return (Criteria) this;
        }

        public Criteria andIscanoverEqualTo(Integer value) {
            addCriterion("IsCanOver =", value, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverNotEqualTo(Integer value) {
            addCriterion("IsCanOver <>", value, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverGreaterThan(Integer value) {
            addCriterion("IsCanOver >", value, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsCanOver >=", value, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverLessThan(Integer value) {
            addCriterion("IsCanOver <", value, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverLessThanOrEqualTo(Integer value) {
            addCriterion("IsCanOver <=", value, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverIn(List<Integer> values) {
            addCriterion("IsCanOver in", values, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverNotIn(List<Integer> values) {
            addCriterion("IsCanOver not in", values, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverBetween(Integer value1, Integer value2) {
            addCriterion("IsCanOver between", value1, value2, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIscanoverNotBetween(Integer value1, Integer value2) {
            addCriterion("IsCanOver not between", value1, value2, "iscanover");
            return (Criteria) this;
        }

        public Criteria andIsrmIsNull() {
            addCriterion("IsRM is null");
            return (Criteria) this;
        }

        public Criteria andIsrmIsNotNull() {
            addCriterion("IsRM is not null");
            return (Criteria) this;
        }

        public Criteria andIsrmEqualTo(Integer value) {
            addCriterion("IsRM =", value, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmNotEqualTo(Integer value) {
            addCriterion("IsRM <>", value, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmGreaterThan(Integer value) {
            addCriterion("IsRM >", value, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsRM >=", value, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmLessThan(Integer value) {
            addCriterion("IsRM <", value, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmLessThanOrEqualTo(Integer value) {
            addCriterion("IsRM <=", value, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmIn(List<Integer> values) {
            addCriterion("IsRM in", values, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmNotIn(List<Integer> values) {
            addCriterion("IsRM not in", values, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmBetween(Integer value1, Integer value2) {
            addCriterion("IsRM between", value1, value2, "isrm");
            return (Criteria) this;
        }

        public Criteria andIsrmNotBetween(Integer value1, Integer value2) {
            addCriterion("IsRM not between", value1, value2, "isrm");
            return (Criteria) this;
        }

        public Criteria andIshandoverIsNull() {
            addCriterion("IsHandOver is null");
            return (Criteria) this;
        }

        public Criteria andIshandoverIsNotNull() {
            addCriterion("IsHandOver is not null");
            return (Criteria) this;
        }

        public Criteria andIshandoverEqualTo(Boolean value) {
            addCriterion("IsHandOver =", value, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverNotEqualTo(Boolean value) {
            addCriterion("IsHandOver <>", value, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverGreaterThan(Boolean value) {
            addCriterion("IsHandOver >", value, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsHandOver >=", value, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverLessThan(Boolean value) {
            addCriterion("IsHandOver <", value, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverLessThanOrEqualTo(Boolean value) {
            addCriterion("IsHandOver <=", value, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverIn(List<Boolean> values) {
            addCriterion("IsHandOver in", values, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverNotIn(List<Boolean> values) {
            addCriterion("IsHandOver not in", values, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverBetween(Boolean value1, Boolean value2) {
            addCriterion("IsHandOver between", value1, value2, "ishandover");
            return (Criteria) this;
        }

        public Criteria andIshandoverNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsHandOver not between", value1, value2, "ishandover");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsIsNull() {
            addCriterion("ReadReceipts is null");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsIsNotNull() {
            addCriterion("ReadReceipts is not null");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsEqualTo(Integer value) {
            addCriterion("ReadReceipts =", value, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsNotEqualTo(Integer value) {
            addCriterion("ReadReceipts <>", value, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsGreaterThan(Integer value) {
            addCriterion("ReadReceipts >", value, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReadReceipts >=", value, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsLessThan(Integer value) {
            addCriterion("ReadReceipts <", value, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsLessThanOrEqualTo(Integer value) {
            addCriterion("ReadReceipts <=", value, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsIn(List<Integer> values) {
            addCriterion("ReadReceipts in", values, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsNotIn(List<Integer> values) {
            addCriterion("ReadReceipts not in", values, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsBetween(Integer value1, Integer value2) {
            addCriterion("ReadReceipts between", value1, value2, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andReadreceiptsNotBetween(Integer value1, Integer value2) {
            addCriterion("ReadReceipts not between", value1, value2, "readreceipts");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0IsNull() {
            addCriterion("AutoJumpRole0 is null");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0IsNotNull() {
            addCriterion("AutoJumpRole0 is not null");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0EqualTo(Integer value) {
            addCriterion("AutoJumpRole0 =", value, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0NotEqualTo(Integer value) {
            addCriterion("AutoJumpRole0 <>", value, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0GreaterThan(Integer value) {
            addCriterion("AutoJumpRole0 >", value, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0GreaterThanOrEqualTo(Integer value) {
            addCriterion("AutoJumpRole0 >=", value, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0LessThan(Integer value) {
            addCriterion("AutoJumpRole0 <", value, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0LessThanOrEqualTo(Integer value) {
            addCriterion("AutoJumpRole0 <=", value, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0In(List<Integer> values) {
            addCriterion("AutoJumpRole0 in", values, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0NotIn(List<Integer> values) {
            addCriterion("AutoJumpRole0 not in", values, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0Between(Integer value1, Integer value2) {
            addCriterion("AutoJumpRole0 between", value1, value2, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole0NotBetween(Integer value1, Integer value2) {
            addCriterion("AutoJumpRole0 not between", value1, value2, "autojumprole0");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1IsNull() {
            addCriterion("AutoJumpRole1 is null");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1IsNotNull() {
            addCriterion("AutoJumpRole1 is not null");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1EqualTo(Integer value) {
            addCriterion("AutoJumpRole1 =", value, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1NotEqualTo(Integer value) {
            addCriterion("AutoJumpRole1 <>", value, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1GreaterThan(Integer value) {
            addCriterion("AutoJumpRole1 >", value, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1GreaterThanOrEqualTo(Integer value) {
            addCriterion("AutoJumpRole1 >=", value, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1LessThan(Integer value) {
            addCriterion("AutoJumpRole1 <", value, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1LessThanOrEqualTo(Integer value) {
            addCriterion("AutoJumpRole1 <=", value, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1In(List<Integer> values) {
            addCriterion("AutoJumpRole1 in", values, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1NotIn(List<Integer> values) {
            addCriterion("AutoJumpRole1 not in", values, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1Between(Integer value1, Integer value2) {
            addCriterion("AutoJumpRole1 between", value1, value2, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole1NotBetween(Integer value1, Integer value2) {
            addCriterion("AutoJumpRole1 not between", value1, value2, "autojumprole1");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2IsNull() {
            addCriterion("AutoJumpRole2 is null");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2IsNotNull() {
            addCriterion("AutoJumpRole2 is not null");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2EqualTo(Integer value) {
            addCriterion("AutoJumpRole2 =", value, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2NotEqualTo(Integer value) {
            addCriterion("AutoJumpRole2 <>", value, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2GreaterThan(Integer value) {
            addCriterion("AutoJumpRole2 >", value, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2GreaterThanOrEqualTo(Integer value) {
            addCriterion("AutoJumpRole2 >=", value, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2LessThan(Integer value) {
            addCriterion("AutoJumpRole2 <", value, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2LessThanOrEqualTo(Integer value) {
            addCriterion("AutoJumpRole2 <=", value, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2In(List<Integer> values) {
            addCriterion("AutoJumpRole2 in", values, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2NotIn(List<Integer> values) {
            addCriterion("AutoJumpRole2 not in", values, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2Between(Integer value1, Integer value2) {
            addCriterion("AutoJumpRole2 between", value1, value2, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andAutojumprole2NotBetween(Integer value1, Integer value2) {
            addCriterion("AutoJumpRole2 not between", value1, value2, "autojumprole2");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsIsNull() {
            addCriterion("SFActiveFlows is null");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsIsNotNull() {
            addCriterion("SFActiveFlows is not null");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsEqualTo(String value) {
            addCriterion("SFActiveFlows =", value, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsNotEqualTo(String value) {
            addCriterion("SFActiveFlows <>", value, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsGreaterThan(String value) {
            addCriterion("SFActiveFlows >", value, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsGreaterThanOrEqualTo(String value) {
            addCriterion("SFActiveFlows >=", value, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsLessThan(String value) {
            addCriterion("SFActiveFlows <", value, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsLessThanOrEqualTo(String value) {
            addCriterion("SFActiveFlows <=", value, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsLike(String value) {
            addCriterion("SFActiveFlows like", value, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsNotLike(String value) {
            addCriterion("SFActiveFlows not like", value, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsIn(List<String> values) {
            addCriterion("SFActiveFlows in", values, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsNotIn(List<String> values) {
            addCriterion("SFActiveFlows not in", values, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsBetween(String value1, String value2) {
            addCriterion("SFActiveFlows between", value1, value2, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andSfactiveflowsNotBetween(String value1, String value2) {
            addCriterion("SFActiveFlows not between", value1, value2, "sfactiveflows");
            return (Criteria) this;
        }

        public Criteria andOuttimedealIsNull() {
            addCriterion("OutTimeDeal is null");
            return (Criteria) this;
        }

        public Criteria andOuttimedealIsNotNull() {
            addCriterion("OutTimeDeal is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimedealEqualTo(Integer value) {
            addCriterion("OutTimeDeal =", value, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealNotEqualTo(Integer value) {
            addCriterion("OutTimeDeal <>", value, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealGreaterThan(Integer value) {
            addCriterion("OutTimeDeal >", value, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealGreaterThanOrEqualTo(Integer value) {
            addCriterion("OutTimeDeal >=", value, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealLessThan(Integer value) {
            addCriterion("OutTimeDeal <", value, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealLessThanOrEqualTo(Integer value) {
            addCriterion("OutTimeDeal <=", value, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealIn(List<Integer> values) {
            addCriterion("OutTimeDeal in", values, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealNotIn(List<Integer> values) {
            addCriterion("OutTimeDeal not in", values, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealBetween(Integer value1, Integer value2) {
            addCriterion("OutTimeDeal between", value1, value2, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andOuttimedealNotBetween(Integer value1, Integer value2) {
            addCriterion("OutTimeDeal not between", value1, value2, "outtimedeal");
            return (Criteria) this;
        }

        public Criteria andDoouttimeIsNull() {
            addCriterion("DoOutTime is null");
            return (Criteria) this;
        }

        public Criteria andDoouttimeIsNotNull() {
            addCriterion("DoOutTime is not null");
            return (Criteria) this;
        }

        public Criteria andDoouttimeEqualTo(String value) {
            addCriterion("DoOutTime =", value, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeNotEqualTo(String value) {
            addCriterion("DoOutTime <>", value, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeGreaterThan(String value) {
            addCriterion("DoOutTime >", value, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeGreaterThanOrEqualTo(String value) {
            addCriterion("DoOutTime >=", value, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeLessThan(String value) {
            addCriterion("DoOutTime <", value, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeLessThanOrEqualTo(String value) {
            addCriterion("DoOutTime <=", value, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeLike(String value) {
            addCriterion("DoOutTime like", value, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeNotLike(String value) {
            addCriterion("DoOutTime not like", value, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeIn(List<String> values) {
            addCriterion("DoOutTime in", values, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeNotIn(List<String> values) {
            addCriterion("DoOutTime not in", values, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeBetween(String value1, String value2) {
            addCriterion("DoOutTime between", value1, value2, "doouttime");
            return (Criteria) this;
        }

        public Criteria andDoouttimeNotBetween(String value1, String value2) {
            addCriterion("DoOutTime not between", value1, value2, "doouttime");
            return (Criteria) this;
        }

        public Criteria andFormurlIsNull() {
            addCriterion("FormUrl is null");
            return (Criteria) this;
        }

        public Criteria andFormurlIsNotNull() {
            addCriterion("FormUrl is not null");
            return (Criteria) this;
        }

        public Criteria andFormurlEqualTo(String value) {
            addCriterion("FormUrl =", value, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlNotEqualTo(String value) {
            addCriterion("FormUrl <>", value, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlGreaterThan(String value) {
            addCriterion("FormUrl >", value, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlGreaterThanOrEqualTo(String value) {
            addCriterion("FormUrl >=", value, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlLessThan(String value) {
            addCriterion("FormUrl <", value, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlLessThanOrEqualTo(String value) {
            addCriterion("FormUrl <=", value, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlLike(String value) {
            addCriterion("FormUrl like", value, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlNotLike(String value) {
            addCriterion("FormUrl not like", value, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlIn(List<String> values) {
            addCriterion("FormUrl in", values, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlNotIn(List<String> values) {
            addCriterion("FormUrl not in", values, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlBetween(String value1, String value2) {
            addCriterion("FormUrl between", value1, value2, "formurl");
            return (Criteria) this;
        }

        public Criteria andFormurlNotBetween(String value1, String value2) {
            addCriterion("FormUrl not between", value1, value2, "formurl");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocIsNull() {
            addCriterion("TurnToDealDoc is null");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocIsNotNull() {
            addCriterion("TurnToDealDoc is not null");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocEqualTo(String value) {
            addCriterion("TurnToDealDoc =", value, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocNotEqualTo(String value) {
            addCriterion("TurnToDealDoc <>", value, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocGreaterThan(String value) {
            addCriterion("TurnToDealDoc >", value, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocGreaterThanOrEqualTo(String value) {
            addCriterion("TurnToDealDoc >=", value, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocLessThan(String value) {
            addCriterion("TurnToDealDoc <", value, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocLessThanOrEqualTo(String value) {
            addCriterion("TurnToDealDoc <=", value, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocLike(String value) {
            addCriterion("TurnToDealDoc like", value, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocNotLike(String value) {
            addCriterion("TurnToDealDoc not like", value, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocIn(List<String> values) {
            addCriterion("TurnToDealDoc in", values, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocNotIn(List<String> values) {
            addCriterion("TurnToDealDoc not in", values, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocBetween(String value1, String value2) {
            addCriterion("TurnToDealDoc between", value1, value2, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andTurntodealdocNotBetween(String value1, String value2) {
            addCriterion("TurnToDealDoc not between", value1, value2, "turntodealdoc");
            return (Criteria) this;
        }

        public Criteria andIsccflowIsNull() {
            addCriterion("IsCCFlow is null");
            return (Criteria) this;
        }

        public Criteria andIsccflowIsNotNull() {
            addCriterion("IsCCFlow is not null");
            return (Criteria) this;
        }

        public Criteria andIsccflowEqualTo(Integer value) {
            addCriterion("IsCCFlow =", value, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowNotEqualTo(Integer value) {
            addCriterion("IsCCFlow <>", value, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowGreaterThan(Integer value) {
            addCriterion("IsCCFlow >", value, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsCCFlow >=", value, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowLessThan(Integer value) {
            addCriterion("IsCCFlow <", value, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowLessThanOrEqualTo(Integer value) {
            addCriterion("IsCCFlow <=", value, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowIn(List<Integer> values) {
            addCriterion("IsCCFlow in", values, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowNotIn(List<Integer> values) {
            addCriterion("IsCCFlow not in", values, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowBetween(Integer value1, Integer value2) {
            addCriterion("IsCCFlow between", value1, value2, "isccflow");
            return (Criteria) this;
        }

        public Criteria andIsccflowNotBetween(Integer value1, Integer value2) {
            addCriterion("IsCCFlow not between", value1, value2, "isccflow");
            return (Criteria) this;
        }

        public Criteria andHisstasIsNull() {
            addCriterion("HisStas is null");
            return (Criteria) this;
        }

        public Criteria andHisstasIsNotNull() {
            addCriterion("HisStas is not null");
            return (Criteria) this;
        }

        public Criteria andHisstasEqualTo(String value) {
            addCriterion("HisStas =", value, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasNotEqualTo(String value) {
            addCriterion("HisStas <>", value, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasGreaterThan(String value) {
            addCriterion("HisStas >", value, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasGreaterThanOrEqualTo(String value) {
            addCriterion("HisStas >=", value, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasLessThan(String value) {
            addCriterion("HisStas <", value, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasLessThanOrEqualTo(String value) {
            addCriterion("HisStas <=", value, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasLike(String value) {
            addCriterion("HisStas like", value, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasNotLike(String value) {
            addCriterion("HisStas not like", value, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasIn(List<String> values) {
            addCriterion("HisStas in", values, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasNotIn(List<String> values) {
            addCriterion("HisStas not in", values, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasBetween(String value1, String value2) {
            addCriterion("HisStas between", value1, value2, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisstasNotBetween(String value1, String value2) {
            addCriterion("HisStas not between", value1, value2, "hisstas");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsIsNull() {
            addCriterion("HisDeptStrs is null");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsIsNotNull() {
            addCriterion("HisDeptStrs is not null");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsEqualTo(String value) {
            addCriterion("HisDeptStrs =", value, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsNotEqualTo(String value) {
            addCriterion("HisDeptStrs <>", value, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsGreaterThan(String value) {
            addCriterion("HisDeptStrs >", value, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsGreaterThanOrEqualTo(String value) {
            addCriterion("HisDeptStrs >=", value, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsLessThan(String value) {
            addCriterion("HisDeptStrs <", value, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsLessThanOrEqualTo(String value) {
            addCriterion("HisDeptStrs <=", value, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsLike(String value) {
            addCriterion("HisDeptStrs like", value, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsNotLike(String value) {
            addCriterion("HisDeptStrs not like", value, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsIn(List<String> values) {
            addCriterion("HisDeptStrs in", values, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsNotIn(List<String> values) {
            addCriterion("HisDeptStrs not in", values, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsBetween(String value1, String value2) {
            addCriterion("HisDeptStrs between", value1, value2, "hisdeptstrs");
            return (Criteria) this;
        }

        public Criteria andHisdeptstrsNotBetween(String value1, String value2) {
            addCriterion("HisDeptStrs not between", value1, value2, "hisdeptstrs");
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