package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class ProjectTraceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectTraceLogExample() {
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

        public Criteria andPtlIdIsNull() {
            addCriterion("ptl_id is null");
            return (Criteria) this;
        }

        public Criteria andPtlIdIsNotNull() {
            addCriterion("ptl_id is not null");
            return (Criteria) this;
        }

        public Criteria andPtlIdEqualTo(String value) {
            addCriterion("ptl_id =", value, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdNotEqualTo(String value) {
            addCriterion("ptl_id <>", value, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdGreaterThan(String value) {
            addCriterion("ptl_id >", value, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdGreaterThanOrEqualTo(String value) {
            addCriterion("ptl_id >=", value, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdLessThan(String value) {
            addCriterion("ptl_id <", value, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdLessThanOrEqualTo(String value) {
            addCriterion("ptl_id <=", value, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdLike(String value) {
            addCriterion("ptl_id like", value, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdNotLike(String value) {
            addCriterion("ptl_id not like", value, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdIn(List<String> values) {
            addCriterion("ptl_id in", values, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdNotIn(List<String> values) {
            addCriterion("ptl_id not in", values, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdBetween(String value1, String value2) {
            addCriterion("ptl_id between", value1, value2, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPtlIdNotBetween(String value1, String value2) {
            addCriterion("ptl_id not between", value1, value2, "ptlId");
            return (Criteria) this;
        }

        public Criteria andPrjIdIsNull() {
            addCriterion("prj_id is null");
            return (Criteria) this;
        }

        public Criteria andPrjIdIsNotNull() {
            addCriterion("prj_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrjIdEqualTo(String value) {
            addCriterion("prj_id =", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdNotEqualTo(String value) {
            addCriterion("prj_id <>", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdGreaterThan(String value) {
            addCriterion("prj_id >", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdGreaterThanOrEqualTo(String value) {
            addCriterion("prj_id >=", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdLessThan(String value) {
            addCriterion("prj_id <", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdLessThanOrEqualTo(String value) {
            addCriterion("prj_id <=", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdLike(String value) {
            addCriterion("prj_id like", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdNotLike(String value) {
            addCriterion("prj_id not like", value, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdIn(List<String> values) {
            addCriterion("prj_id in", values, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdNotIn(List<String> values) {
            addCriterion("prj_id not in", values, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdBetween(String value1, String value2) {
            addCriterion("prj_id between", value1, value2, "prjId");
            return (Criteria) this;
        }

        public Criteria andPrjIdNotBetween(String value1, String value2) {
            addCriterion("prj_id not between", value1, value2, "prjId");
            return (Criteria) this;
        }

        public Criteria andManageNoIsNull() {
            addCriterion("manage_no is null");
            return (Criteria) this;
        }

        public Criteria andManageNoIsNotNull() {
            addCriterion("manage_no is not null");
            return (Criteria) this;
        }

        public Criteria andManageNoEqualTo(String value) {
            addCriterion("manage_no =", value, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoNotEqualTo(String value) {
            addCriterion("manage_no <>", value, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoGreaterThan(String value) {
            addCriterion("manage_no >", value, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoGreaterThanOrEqualTo(String value) {
            addCriterion("manage_no >=", value, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoLessThan(String value) {
            addCriterion("manage_no <", value, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoLessThanOrEqualTo(String value) {
            addCriterion("manage_no <=", value, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoLike(String value) {
            addCriterion("manage_no like", value, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoNotLike(String value) {
            addCriterion("manage_no not like", value, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoIn(List<String> values) {
            addCriterion("manage_no in", values, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoNotIn(List<String> values) {
            addCriterion("manage_no not in", values, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoBetween(String value1, String value2) {
            addCriterion("manage_no between", value1, value2, "manageNo");
            return (Criteria) this;
        }

        public Criteria andManageNoNotBetween(String value1, String value2) {
            addCriterion("manage_no not between", value1, value2, "manageNo");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentIsNull() {
            addCriterion("sponsor_department is null");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentIsNotNull() {
            addCriterion("sponsor_department is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentEqualTo(String value) {
            addCriterion("sponsor_department =", value, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentNotEqualTo(String value) {
            addCriterion("sponsor_department <>", value, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentGreaterThan(String value) {
            addCriterion("sponsor_department >", value, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("sponsor_department >=", value, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentLessThan(String value) {
            addCriterion("sponsor_department <", value, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentLessThanOrEqualTo(String value) {
            addCriterion("sponsor_department <=", value, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentLike(String value) {
            addCriterion("sponsor_department like", value, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentNotLike(String value) {
            addCriterion("sponsor_department not like", value, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentIn(List<String> values) {
            addCriterion("sponsor_department in", values, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentNotIn(List<String> values) {
            addCriterion("sponsor_department not in", values, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentBetween(String value1, String value2) {
            addCriterion("sponsor_department between", value1, value2, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andSponsorDepartmentNotBetween(String value1, String value2) {
            addCriterion("sponsor_department not between", value1, value2, "sponsorDepartment");
            return (Criteria) this;
        }

        public Criteria andPtlStateIsNull() {
            addCriterion("ptl_state is null");
            return (Criteria) this;
        }

        public Criteria andPtlStateIsNotNull() {
            addCriterion("ptl_state is not null");
            return (Criteria) this;
        }

        public Criteria andPtlStateEqualTo(Integer value) {
            addCriterion("ptl_state =", value, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateNotEqualTo(Integer value) {
            addCriterion("ptl_state <>", value, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateGreaterThan(Integer value) {
            addCriterion("ptl_state >", value, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ptl_state >=", value, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateLessThan(Integer value) {
            addCriterion("ptl_state <", value, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateLessThanOrEqualTo(Integer value) {
            addCriterion("ptl_state <=", value, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateIn(List<Integer> values) {
            addCriterion("ptl_state in", values, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateNotIn(List<Integer> values) {
            addCriterion("ptl_state not in", values, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateBetween(Integer value1, Integer value2) {
            addCriterion("ptl_state between", value1, value2, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlStateNotBetween(Integer value1, Integer value2) {
            addCriterion("ptl_state not between", value1, value2, "ptlState");
            return (Criteria) this;
        }

        public Criteria andPtlNameIsNull() {
            addCriterion("ptl_name is null");
            return (Criteria) this;
        }

        public Criteria andPtlNameIsNotNull() {
            addCriterion("ptl_name is not null");
            return (Criteria) this;
        }

        public Criteria andPtlNameEqualTo(String value) {
            addCriterion("ptl_name =", value, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameNotEqualTo(String value) {
            addCriterion("ptl_name <>", value, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameGreaterThan(String value) {
            addCriterion("ptl_name >", value, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameGreaterThanOrEqualTo(String value) {
            addCriterion("ptl_name >=", value, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameLessThan(String value) {
            addCriterion("ptl_name <", value, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameLessThanOrEqualTo(String value) {
            addCriterion("ptl_name <=", value, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameLike(String value) {
            addCriterion("ptl_name like", value, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameNotLike(String value) {
            addCriterion("ptl_name not like", value, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameIn(List<String> values) {
            addCriterion("ptl_name in", values, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameNotIn(List<String> values) {
            addCriterion("ptl_name not in", values, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameBetween(String value1, String value2) {
            addCriterion("ptl_name between", value1, value2, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlNameNotBetween(String value1, String value2) {
            addCriterion("ptl_name not between", value1, value2, "ptlName");
            return (Criteria) this;
        }

        public Criteria andPtlTimeIsNull() {
            addCriterion("ptl_time is null");
            return (Criteria) this;
        }

        public Criteria andPtlTimeIsNotNull() {
            addCriterion("ptl_time is not null");
            return (Criteria) this;
        }

        public Criteria andPtlTimeEqualTo(String value) {
            addCriterion("ptl_time =", value, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeNotEqualTo(String value) {
            addCriterion("ptl_time <>", value, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeGreaterThan(String value) {
            addCriterion("ptl_time >", value, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ptl_time >=", value, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeLessThan(String value) {
            addCriterion("ptl_time <", value, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeLessThanOrEqualTo(String value) {
            addCriterion("ptl_time <=", value, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeLike(String value) {
            addCriterion("ptl_time like", value, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeNotLike(String value) {
            addCriterion("ptl_time not like", value, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeIn(List<String> values) {
            addCriterion("ptl_time in", values, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeNotIn(List<String> values) {
            addCriterion("ptl_time not in", values, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeBetween(String value1, String value2) {
            addCriterion("ptl_time between", value1, value2, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andPtlTimeNotBetween(String value1, String value2) {
            addCriterion("ptl_time not between", value1, value2, "ptlTime");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentIsNull() {
            addCriterion("business_department is null");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentIsNotNull() {
            addCriterion("business_department is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentEqualTo(String value) {
            addCriterion("business_department =", value, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentNotEqualTo(String value) {
            addCriterion("business_department <>", value, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentGreaterThan(String value) {
            addCriterion("business_department >", value, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("business_department >=", value, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentLessThan(String value) {
            addCriterion("business_department <", value, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentLessThanOrEqualTo(String value) {
            addCriterion("business_department <=", value, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentLike(String value) {
            addCriterion("business_department like", value, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentNotLike(String value) {
            addCriterion("business_department not like", value, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentIn(List<String> values) {
            addCriterion("business_department in", values, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentNotIn(List<String> values) {
            addCriterion("business_department not in", values, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentBetween(String value1, String value2) {
            addCriterion("business_department between", value1, value2, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentNotBetween(String value1, String value2) {
            addCriterion("business_department not between", value1, value2, "businessDepartment");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionIsNull() {
            addCriterion("business_department_opinion is null");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionIsNotNull() {
            addCriterion("business_department_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionEqualTo(String value) {
            addCriterion("business_department_opinion =", value, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionNotEqualTo(String value) {
            addCriterion("business_department_opinion <>", value, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionGreaterThan(String value) {
            addCriterion("business_department_opinion >", value, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("business_department_opinion >=", value, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionLessThan(String value) {
            addCriterion("business_department_opinion <", value, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionLessThanOrEqualTo(String value) {
            addCriterion("business_department_opinion <=", value, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionLike(String value) {
            addCriterion("business_department_opinion like", value, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionNotLike(String value) {
            addCriterion("business_department_opinion not like", value, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionIn(List<String> values) {
            addCriterion("business_department_opinion in", values, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionNotIn(List<String> values) {
            addCriterion("business_department_opinion not in", values, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionBetween(String value1, String value2) {
            addCriterion("business_department_opinion between", value1, value2, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentOpinionNotBetween(String value1, String value2) {
            addCriterion("business_department_opinion not between", value1, value2, "businessDepartmentOpinion");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateIsNull() {
            addCriterion("business_department_date is null");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateIsNotNull() {
            addCriterion("business_department_date is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateEqualTo(String value) {
            addCriterion("business_department_date =", value, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateNotEqualTo(String value) {
            addCriterion("business_department_date <>", value, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateGreaterThan(String value) {
            addCriterion("business_department_date >", value, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateGreaterThanOrEqualTo(String value) {
            addCriterion("business_department_date >=", value, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateLessThan(String value) {
            addCriterion("business_department_date <", value, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateLessThanOrEqualTo(String value) {
            addCriterion("business_department_date <=", value, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateLike(String value) {
            addCriterion("business_department_date like", value, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateNotLike(String value) {
            addCriterion("business_department_date not like", value, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateIn(List<String> values) {
            addCriterion("business_department_date in", values, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateNotIn(List<String> values) {
            addCriterion("business_department_date not in", values, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateBetween(String value1, String value2) {
            addCriterion("business_department_date between", value1, value2, "businessDepartmentDate");
            return (Criteria) this;
        }

        public Criteria andBusinessDepartmentDateNotBetween(String value1, String value2) {
            addCriterion("business_department_date not between", value1, value2, "businessDepartmentDate");
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