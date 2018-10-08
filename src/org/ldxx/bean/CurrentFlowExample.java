package org.ldxx.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrentFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurrentFlowExample() {
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

        public Criteria andFloNodeIdIsNull() {
            addCriterion("Flo_Node_ID is null");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdIsNotNull() {
            addCriterion("Flo_Node_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdEqualTo(String value) {
            addCriterion("Flo_Node_ID =", value, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdNotEqualTo(String value) {
            addCriterion("Flo_Node_ID <>", value, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdGreaterThan(String value) {
            addCriterion("Flo_Node_ID >", value, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("Flo_Node_ID >=", value, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdLessThan(String value) {
            addCriterion("Flo_Node_ID <", value, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdLessThanOrEqualTo(String value) {
            addCriterion("Flo_Node_ID <=", value, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdLike(String value) {
            addCriterion("Flo_Node_ID like", value, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdNotLike(String value) {
            addCriterion("Flo_Node_ID not like", value, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdIn(List<String> values) {
            addCriterion("Flo_Node_ID in", values, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdNotIn(List<String> values) {
            addCriterion("Flo_Node_ID not in", values, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdBetween(String value1, String value2) {
            addCriterion("Flo_Node_ID between", value1, value2, "floNodeId");
            return (Criteria) this;
        }

        public Criteria andFloNodeIdNotBetween(String value1, String value2) {
            addCriterion("Flo_Node_ID not between", value1, value2, "floNodeId");
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

        public Criteria andBusIdIsNull() {
            addCriterion("Bus_ID is null");
            return (Criteria) this;
        }

        public Criteria andBusIdIsNotNull() {
            addCriterion("Bus_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBusIdEqualTo(String value) {
            addCriterion("Bus_ID =", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdNotEqualTo(String value) {
            addCriterion("Bus_ID <>", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdGreaterThan(String value) {
            addCriterion("Bus_ID >", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdGreaterThanOrEqualTo(String value) {
            addCriterion("Bus_ID >=", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdLessThan(String value) {
            addCriterion("Bus_ID <", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdLessThanOrEqualTo(String value) {
            addCriterion("Bus_ID <=", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdLike(String value) {
            addCriterion("Bus_ID like", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdNotLike(String value) {
            addCriterion("Bus_ID not like", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdIn(List<String> values) {
            addCriterion("Bus_ID in", values, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdNotIn(List<String> values) {
            addCriterion("Bus_ID not in", values, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdBetween(String value1, String value2) {
            addCriterion("Bus_ID between", value1, value2, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdNotBetween(String value1, String value2) {
            addCriterion("Bus_ID not between", value1, value2, "busId");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("Params is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("Params is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("Params =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("Params <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("Params >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("Params >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("Params <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("Params <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("Params like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("Params not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("Params in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("Params not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("Params between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("Params not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("Title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andWfstateIsNull() {
            addCriterion("WFState is null");
            return (Criteria) this;
        }

        public Criteria andWfstateIsNotNull() {
            addCriterion("WFState is not null");
            return (Criteria) this;
        }

        public Criteria andWfstateEqualTo(Integer value) {
            addCriterion("WFState =", value, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateNotEqualTo(Integer value) {
            addCriterion("WFState <>", value, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateGreaterThan(Integer value) {
            addCriterion("WFState >", value, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("WFState >=", value, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateLessThan(Integer value) {
            addCriterion("WFState <", value, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateLessThanOrEqualTo(Integer value) {
            addCriterion("WFState <=", value, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateIn(List<Integer> values) {
            addCriterion("WFState in", values, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateNotIn(List<Integer> values) {
            addCriterion("WFState not in", values, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateBetween(Integer value1, Integer value2) {
            addCriterion("WFState between", value1, value2, "wfstate");
            return (Criteria) this;
        }

        public Criteria andWfstateNotBetween(Integer value1, Integer value2) {
            addCriterion("WFState not between", value1, value2, "wfstate");
            return (Criteria) this;
        }

        public Criteria andStarterIsNull() {
            addCriterion("Starter is null");
            return (Criteria) this;
        }

        public Criteria andStarterIsNotNull() {
            addCriterion("Starter is not null");
            return (Criteria) this;
        }

        public Criteria andStarterEqualTo(String value) {
            addCriterion("Starter =", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotEqualTo(String value) {
            addCriterion("Starter <>", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterGreaterThan(String value) {
            addCriterion("Starter >", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterGreaterThanOrEqualTo(String value) {
            addCriterion("Starter >=", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterLessThan(String value) {
            addCriterion("Starter <", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterLessThanOrEqualTo(String value) {
            addCriterion("Starter <=", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterLike(String value) {
            addCriterion("Starter like", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotLike(String value) {
            addCriterion("Starter not like", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterIn(List<String> values) {
            addCriterion("Starter in", values, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotIn(List<String> values) {
            addCriterion("Starter not in", values, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterBetween(String value1, String value2) {
            addCriterion("Starter between", value1, value2, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotBetween(String value1, String value2) {
            addCriterion("Starter not between", value1, value2, "starter");
            return (Criteria) this;
        }

        public Criteria andStarternameIsNull() {
            addCriterion("StarterName is null");
            return (Criteria) this;
        }

        public Criteria andStarternameIsNotNull() {
            addCriterion("StarterName is not null");
            return (Criteria) this;
        }

        public Criteria andStarternameEqualTo(String value) {
            addCriterion("StarterName =", value, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameNotEqualTo(String value) {
            addCriterion("StarterName <>", value, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameGreaterThan(String value) {
            addCriterion("StarterName >", value, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameGreaterThanOrEqualTo(String value) {
            addCriterion("StarterName >=", value, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameLessThan(String value) {
            addCriterion("StarterName <", value, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameLessThanOrEqualTo(String value) {
            addCriterion("StarterName <=", value, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameLike(String value) {
            addCriterion("StarterName like", value, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameNotLike(String value) {
            addCriterion("StarterName not like", value, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameIn(List<String> values) {
            addCriterion("StarterName in", values, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameNotIn(List<String> values) {
            addCriterion("StarterName not in", values, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameBetween(String value1, String value2) {
            addCriterion("StarterName between", value1, value2, "startername");
            return (Criteria) this;
        }

        public Criteria andStarternameNotBetween(String value1, String value2) {
            addCriterion("StarterName not between", value1, value2, "startername");
            return (Criteria) this;
        }

        public Criteria andActorIsNull() {
            addCriterion("Actor is null");
            return (Criteria) this;
        }

        public Criteria andActorIsNotNull() {
            addCriterion("Actor is not null");
            return (Criteria) this;
        }

        public Criteria andActorEqualTo(String value) {
            addCriterion("Actor =", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotEqualTo(String value) {
            addCriterion("Actor <>", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorGreaterThan(String value) {
            addCriterion("Actor >", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorGreaterThanOrEqualTo(String value) {
            addCriterion("Actor >=", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorLessThan(String value) {
            addCriterion("Actor <", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorLessThanOrEqualTo(String value) {
            addCriterion("Actor <=", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorLike(String value) {
            addCriterion("Actor like", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotLike(String value) {
            addCriterion("Actor not like", value, "actor");
            return (Criteria) this;
        }

        public Criteria andActorIn(List<String> values) {
            addCriterion("Actor in", values, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotIn(List<String> values) {
            addCriterion("Actor not in", values, "actor");
            return (Criteria) this;
        }

        public Criteria andActorBetween(String value1, String value2) {
            addCriterion("Actor between", value1, value2, "actor");
            return (Criteria) this;
        }

        public Criteria andActorNotBetween(String value1, String value2) {
            addCriterion("Actor not between", value1, value2, "actor");
            return (Criteria) this;
        }

        public Criteria andActornameIsNull() {
            addCriterion("ActorName is null");
            return (Criteria) this;
        }

        public Criteria andActornameIsNotNull() {
            addCriterion("ActorName is not null");
            return (Criteria) this;
        }

        public Criteria andActornameEqualTo(String value) {
            addCriterion("ActorName =", value, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameNotEqualTo(String value) {
            addCriterion("ActorName <>", value, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameGreaterThan(String value) {
            addCriterion("ActorName >", value, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameGreaterThanOrEqualTo(String value) {
            addCriterion("ActorName >=", value, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameLessThan(String value) {
            addCriterion("ActorName <", value, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameLessThanOrEqualTo(String value) {
            addCriterion("ActorName <=", value, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameLike(String value) {
            addCriterion("ActorName like", value, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameNotLike(String value) {
            addCriterion("ActorName not like", value, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameIn(List<String> values) {
            addCriterion("ActorName in", values, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameNotIn(List<String> values) {
            addCriterion("ActorName not in", values, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameBetween(String value1, String value2) {
            addCriterion("ActorName between", value1, value2, "actorname");
            return (Criteria) this;
        }

        public Criteria andActornameNotBetween(String value1, String value2) {
            addCriterion("ActorName not between", value1, value2, "actorname");
            return (Criteria) this;
        }

        public Criteria andRdtIsNull() {
            addCriterion("RDT is null");
            return (Criteria) this;
        }

        public Criteria andRdtIsNotNull() {
            addCriterion("RDT is not null");
            return (Criteria) this;
        }

        public Criteria andRdtEqualTo(Date value) {
            addCriterion("RDT =", value, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtNotEqualTo(Date value) {
            addCriterion("RDT <>", value, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtGreaterThan(Date value) {
            addCriterion("RDT >", value, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtGreaterThanOrEqualTo(Date value) {
            addCriterion("RDT >=", value, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtLessThan(Date value) {
            addCriterion("RDT <", value, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtLessThanOrEqualTo(Date value) {
            addCriterion("RDT <=", value, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtIn(List<Date> values) {
            addCriterion("RDT in", values, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtNotIn(List<Date> values) {
            addCriterion("RDT not in", values, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtBetween(Date value1, Date value2) {
            addCriterion("RDT between", value1, value2, "rdt");
            return (Criteria) this;
        }

        public Criteria andRdtNotBetween(Date value1, Date value2) {
            addCriterion("RDT not between", value1, value2, "rdt");
            return (Criteria) this;
        }

        public Criteria andFkDeptIsNull() {
            addCriterion("FK_Dept is null");
            return (Criteria) this;
        }

        public Criteria andFkDeptIsNotNull() {
            addCriterion("FK_Dept is not null");
            return (Criteria) this;
        }

        public Criteria andFkDeptEqualTo(String value) {
            addCriterion("FK_Dept =", value, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptNotEqualTo(String value) {
            addCriterion("FK_Dept <>", value, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptGreaterThan(String value) {
            addCriterion("FK_Dept >", value, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptGreaterThanOrEqualTo(String value) {
            addCriterion("FK_Dept >=", value, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptLessThan(String value) {
            addCriterion("FK_Dept <", value, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptLessThanOrEqualTo(String value) {
            addCriterion("FK_Dept <=", value, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptLike(String value) {
            addCriterion("FK_Dept like", value, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptNotLike(String value) {
            addCriterion("FK_Dept not like", value, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptIn(List<String> values) {
            addCriterion("FK_Dept in", values, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptNotIn(List<String> values) {
            addCriterion("FK_Dept not in", values, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptBetween(String value1, String value2) {
            addCriterion("FK_Dept between", value1, value2, "fkDept");
            return (Criteria) this;
        }

        public Criteria andFkDeptNotBetween(String value1, String value2) {
            addCriterion("FK_Dept not between", value1, value2, "fkDept");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("DeptName is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("DeptName is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(String value) {
            addCriterion("DeptName =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(String value) {
            addCriterion("DeptName <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(String value) {
            addCriterion("DeptName >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("DeptName >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(String value) {
            addCriterion("DeptName <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(String value) {
            addCriterion("DeptName <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLike(String value) {
            addCriterion("DeptName like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotLike(String value) {
            addCriterion("DeptName not like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<String> values) {
            addCriterion("DeptName in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<String> values) {
            addCriterion("DeptName not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(String value1, String value2) {
            addCriterion("DeptName between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(String value1, String value2) {
            addCriterion("DeptName not between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andNodenameIsNull() {
            addCriterion("NodeName is null");
            return (Criteria) this;
        }

        public Criteria andNodenameIsNotNull() {
            addCriterion("NodeName is not null");
            return (Criteria) this;
        }

        public Criteria andNodenameEqualTo(String value) {
            addCriterion("NodeName =", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameNotEqualTo(String value) {
            addCriterion("NodeName <>", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameGreaterThan(String value) {
            addCriterion("NodeName >", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameGreaterThanOrEqualTo(String value) {
            addCriterion("NodeName >=", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameLessThan(String value) {
            addCriterion("NodeName <", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameLessThanOrEqualTo(String value) {
            addCriterion("NodeName <=", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameLike(String value) {
            addCriterion("NodeName like", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameNotLike(String value) {
            addCriterion("NodeName not like", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameIn(List<String> values) {
            addCriterion("NodeName in", values, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameNotIn(List<String> values) {
            addCriterion("NodeName not in", values, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameBetween(String value1, String value2) {
            addCriterion("NodeName between", value1, value2, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameNotBetween(String value1, String value2) {
            addCriterion("NodeName not between", value1, value2, "nodename");
            return (Criteria) this;
        }

        public Criteria andPriIsNull() {
            addCriterion("PRI is null");
            return (Criteria) this;
        }

        public Criteria andPriIsNotNull() {
            addCriterion("PRI is not null");
            return (Criteria) this;
        }

        public Criteria andPriEqualTo(Integer value) {
            addCriterion("PRI =", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotEqualTo(Integer value) {
            addCriterion("PRI <>", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThan(Integer value) {
            addCriterion("PRI >", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRI >=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThan(Integer value) {
            addCriterion("PRI <", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThanOrEqualTo(Integer value) {
            addCriterion("PRI <=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriIn(List<Integer> values) {
            addCriterion("PRI in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotIn(List<Integer> values) {
            addCriterion("PRI not in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriBetween(Integer value1, Integer value2) {
            addCriterion("PRI between", value1, value2, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotBetween(Integer value1, Integer value2) {
            addCriterion("PRI not between", value1, value2, "pri");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeIsNull() {
            addCriterion("SDTOfNode is null");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeIsNotNull() {
            addCriterion("SDTOfNode is not null");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeEqualTo(Date value) {
            addCriterion("SDTOfNode =", value, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeNotEqualTo(Date value) {
            addCriterion("SDTOfNode <>", value, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeGreaterThan(Date value) {
            addCriterion("SDTOfNode >", value, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeGreaterThanOrEqualTo(Date value) {
            addCriterion("SDTOfNode >=", value, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeLessThan(Date value) {
            addCriterion("SDTOfNode <", value, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeLessThanOrEqualTo(Date value) {
            addCriterion("SDTOfNode <=", value, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeIn(List<Date> values) {
            addCriterion("SDTOfNode in", values, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeNotIn(List<Date> values) {
            addCriterion("SDTOfNode not in", values, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeBetween(Date value1, Date value2) {
            addCriterion("SDTOfNode between", value1, value2, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofnodeNotBetween(Date value1, Date value2) {
            addCriterion("SDTOfNode not between", value1, value2, "sdtofnode");
            return (Criteria) this;
        }

        public Criteria andSdtofflowIsNull() {
            addCriterion("SDTOfFlow is null");
            return (Criteria) this;
        }

        public Criteria andSdtofflowIsNotNull() {
            addCriterion("SDTOfFlow is not null");
            return (Criteria) this;
        }

        public Criteria andSdtofflowEqualTo(Date value) {
            addCriterion("SDTOfFlow =", value, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowNotEqualTo(Date value) {
            addCriterion("SDTOfFlow <>", value, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowGreaterThan(Date value) {
            addCriterion("SDTOfFlow >", value, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowGreaterThanOrEqualTo(Date value) {
            addCriterion("SDTOfFlow >=", value, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowLessThan(Date value) {
            addCriterion("SDTOfFlow <", value, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowLessThanOrEqualTo(Date value) {
            addCriterion("SDTOfFlow <=", value, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowIn(List<Date> values) {
            addCriterion("SDTOfFlow in", values, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowNotIn(List<Date> values) {
            addCriterion("SDTOfFlow not in", values, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowBetween(Date value1, Date value2) {
            addCriterion("SDTOfFlow between", value1, value2, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andSdtofflowNotBetween(Date value1, Date value2) {
            addCriterion("SDTOfFlow not between", value1, value2, "sdtofflow");
            return (Criteria) this;
        }

        public Criteria andAgentIsNull() {
            addCriterion("Agent is null");
            return (Criteria) this;
        }

        public Criteria andAgentIsNotNull() {
            addCriterion("Agent is not null");
            return (Criteria) this;
        }

        public Criteria andAgentEqualTo(String value) {
            addCriterion("Agent =", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotEqualTo(String value) {
            addCriterion("Agent <>", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThan(String value) {
            addCriterion("Agent >", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThanOrEqualTo(String value) {
            addCriterion("Agent >=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThan(String value) {
            addCriterion("Agent <", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThanOrEqualTo(String value) {
            addCriterion("Agent <=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLike(String value) {
            addCriterion("Agent like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotLike(String value) {
            addCriterion("Agent not like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentIn(List<String> values) {
            addCriterion("Agent in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotIn(List<String> values) {
            addCriterion("Agent not in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentBetween(String value1, String value2) {
            addCriterion("Agent between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotBetween(String value1, String value2) {
            addCriterion("Agent not between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andAgenttypeIsNull() {
            addCriterion("AgentType is null");
            return (Criteria) this;
        }

        public Criteria andAgenttypeIsNotNull() {
            addCriterion("AgentType is not null");
            return (Criteria) this;
        }

        public Criteria andAgenttypeEqualTo(String value) {
            addCriterion("AgentType =", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeNotEqualTo(String value) {
            addCriterion("AgentType <>", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeGreaterThan(String value) {
            addCriterion("AgentType >", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("AgentType >=", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeLessThan(String value) {
            addCriterion("AgentType <", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeLessThanOrEqualTo(String value) {
            addCriterion("AgentType <=", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeLike(String value) {
            addCriterion("AgentType like", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeNotLike(String value) {
            addCriterion("AgentType not like", value, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeIn(List<String> values) {
            addCriterion("AgentType in", values, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeNotIn(List<String> values) {
            addCriterion("AgentType not in", values, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeBetween(String value1, String value2) {
            addCriterion("AgentType between", value1, value2, "agenttype");
            return (Criteria) this;
        }

        public Criteria andAgenttypeNotBetween(String value1, String value2) {
            addCriterion("AgentType not between", value1, value2, "agenttype");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("Memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("Memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("Memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("Memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("Memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("Memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("Memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("Memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("Memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("Memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("Memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("Memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("Memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("Memo not between", value1, value2, "memo");
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

        public Criteria andDoDateIsNull() {
            addCriterion("do_date is null");
            return (Criteria) this;
        }

        public Criteria andDoDateIsNotNull() {
            addCriterion("do_date is not null");
            return (Criteria) this;
        }

        public Criteria andDoDateEqualTo(Date value) {
            addCriterion("do_date =", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateNotEqualTo(Date value) {
            addCriterion("do_date <>", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateGreaterThan(Date value) {
            addCriterion("do_date >", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateGreaterThanOrEqualTo(Date value) {
            addCriterion("do_date >=", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateLessThan(Date value) {
            addCriterion("do_date <", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateLessThanOrEqualTo(Date value) {
            addCriterion("do_date <=", value, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateIn(List<Date> values) {
            addCriterion("do_date in", values, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateNotIn(List<Date> values) {
            addCriterion("do_date not in", values, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateBetween(Date value1, Date value2) {
            addCriterion("do_date between", value1, value2, "doDate");
            return (Criteria) this;
        }

        public Criteria andDoDateNotBetween(Date value1, Date value2) {
            addCriterion("do_date not between", value1, value2, "doDate");
            return (Criteria) this;
        }

        public Criteria andModeIdIsNull() {
            addCriterion("mode_id is null");
            return (Criteria) this;
        }

        public Criteria andModeIdIsNotNull() {
            addCriterion("mode_id is not null");
            return (Criteria) this;
        }

        public Criteria andModeIdEqualTo(String value) {
            addCriterion("mode_id =", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotEqualTo(String value) {
            addCriterion("mode_id <>", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdGreaterThan(String value) {
            addCriterion("mode_id >", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdGreaterThanOrEqualTo(String value) {
            addCriterion("mode_id >=", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLessThan(String value) {
            addCriterion("mode_id <", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLessThanOrEqualTo(String value) {
            addCriterion("mode_id <=", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLike(String value) {
            addCriterion("mode_id like", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotLike(String value) {
            addCriterion("mode_id not like", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdIn(List<String> values) {
            addCriterion("mode_id in", values, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotIn(List<String> values) {
            addCriterion("mode_id not in", values, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdBetween(String value1, String value2) {
            addCriterion("mode_id between", value1, value2, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotBetween(String value1, String value2) {
            addCriterion("mode_id not between", value1, value2, "modeId");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateIsNull() {
            addCriterion("flow_end_state is null");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateIsNotNull() {
            addCriterion("flow_end_state is not null");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateEqualTo(Integer value) {
            addCriterion("flow_end_state =", value, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateNotEqualTo(Integer value) {
            addCriterion("flow_end_state <>", value, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateGreaterThan(Integer value) {
            addCriterion("flow_end_state >", value, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_end_state >=", value, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateLessThan(Integer value) {
            addCriterion("flow_end_state <", value, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateLessThanOrEqualTo(Integer value) {
            addCriterion("flow_end_state <=", value, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateIn(List<Integer> values) {
            addCriterion("flow_end_state in", values, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateNotIn(List<Integer> values) {
            addCriterion("flow_end_state not in", values, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateBetween(Integer value1, Integer value2) {
            addCriterion("flow_end_state between", value1, value2, "flowEndState");
            return (Criteria) this;
        }

        public Criteria andFlowEndStateNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_end_state not between", value1, value2, "flowEndState");
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