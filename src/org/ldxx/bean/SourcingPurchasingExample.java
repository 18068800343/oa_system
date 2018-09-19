package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class SourcingPurchasingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SourcingPurchasingExample() {
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

        public Criteria andSpIdIsNull() {
            addCriterion("sp_id is null");
            return (Criteria) this;
        }

        public Criteria andSpIdIsNotNull() {
            addCriterion("sp_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpIdEqualTo(Integer value) {
            addCriterion("sp_id =", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotEqualTo(Integer value) {
            addCriterion("sp_id <>", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThan(Integer value) {
            addCriterion("sp_id >", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_id >=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThan(Integer value) {
            addCriterion("sp_id <", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThanOrEqualTo(Integer value) {
            addCriterion("sp_id <=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdIn(List<Integer> values) {
            addCriterion("sp_id in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotIn(List<Integer> values) {
            addCriterion("sp_id not in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdBetween(Integer value1, Integer value2) {
            addCriterion("sp_id between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_id not between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andSpNameIsNull() {
            addCriterion("sp_name is null");
            return (Criteria) this;
        }

        public Criteria andSpNameIsNotNull() {
            addCriterion("sp_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpNameEqualTo(String value) {
            addCriterion("sp_name =", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotEqualTo(String value) {
            addCriterion("sp_name <>", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameGreaterThan(String value) {
            addCriterion("sp_name >", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameGreaterThanOrEqualTo(String value) {
            addCriterion("sp_name >=", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLessThan(String value) {
            addCriterion("sp_name <", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLessThanOrEqualTo(String value) {
            addCriterion("sp_name <=", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLike(String value) {
            addCriterion("sp_name like", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotLike(String value) {
            addCriterion("sp_name not like", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameIn(List<String> values) {
            addCriterion("sp_name in", values, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotIn(List<String> values) {
            addCriterion("sp_name not in", values, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameBetween(String value1, String value2) {
            addCriterion("sp_name between", value1, value2, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotBetween(String value1, String value2) {
            addCriterion("sp_name not between", value1, value2, "spName");
            return (Criteria) this;
        }

        public Criteria andSpTypeIsNull() {
            addCriterion("sp_type is null");
            return (Criteria) this;
        }

        public Criteria andSpTypeIsNotNull() {
            addCriterion("sp_type is not null");
            return (Criteria) this;
        }

        public Criteria andSpTypeEqualTo(String value) {
            addCriterion("sp_type =", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotEqualTo(String value) {
            addCriterion("sp_type <>", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeGreaterThan(String value) {
            addCriterion("sp_type >", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sp_type >=", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeLessThan(String value) {
            addCriterion("sp_type <", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeLessThanOrEqualTo(String value) {
            addCriterion("sp_type <=", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeLike(String value) {
            addCriterion("sp_type like", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotLike(String value) {
            addCriterion("sp_type not like", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeIn(List<String> values) {
            addCriterion("sp_type in", values, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotIn(List<String> values) {
            addCriterion("sp_type not in", values, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeBetween(String value1, String value2) {
            addCriterion("sp_type between", value1, value2, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotBetween(String value1, String value2) {
            addCriterion("sp_type not between", value1, value2, "spType");
            return (Criteria) this;
        }

        public Criteria andEvaScoreIsNull() {
            addCriterion("eva_score is null");
            return (Criteria) this;
        }

        public Criteria andEvaScoreIsNotNull() {
            addCriterion("eva_score is not null");
            return (Criteria) this;
        }

        public Criteria andEvaScoreEqualTo(String value) {
            addCriterion("eva_score =", value, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreNotEqualTo(String value) {
            addCriterion("eva_score <>", value, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreGreaterThan(String value) {
            addCriterion("eva_score >", value, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreGreaterThanOrEqualTo(String value) {
            addCriterion("eva_score >=", value, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreLessThan(String value) {
            addCriterion("eva_score <", value, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreLessThanOrEqualTo(String value) {
            addCriterion("eva_score <=", value, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreLike(String value) {
            addCriterion("eva_score like", value, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreNotLike(String value) {
            addCriterion("eva_score not like", value, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreIn(List<String> values) {
            addCriterion("eva_score in", values, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreNotIn(List<String> values) {
            addCriterion("eva_score not in", values, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreBetween(String value1, String value2) {
            addCriterion("eva_score between", value1, value2, "evaScore");
            return (Criteria) this;
        }

        public Criteria andEvaScoreNotBetween(String value1, String value2) {
            addCriterion("eva_score not between", value1, value2, "evaScore");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNull() {
            addCriterion("bank_no is null");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNotNull() {
            addCriterion("bank_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankNoEqualTo(String value) {
            addCriterion("bank_no =", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotEqualTo(String value) {
            addCriterion("bank_no <>", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThan(String value) {
            addCriterion("bank_no >", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_no >=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThan(String value) {
            addCriterion("bank_no <", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThanOrEqualTo(String value) {
            addCriterion("bank_no <=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLike(String value) {
            addCriterion("bank_no like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotLike(String value) {
            addCriterion("bank_no not like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoIn(List<String> values) {
            addCriterion("bank_no in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotIn(List<String> values) {
            addCriterion("bank_no not in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoBetween(String value1, String value2) {
            addCriterion("bank_no between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotBetween(String value1, String value2) {
            addCriterion("bank_no not between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationIsNull() {
            addCriterion("enterprise_qualification is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationIsNotNull() {
            addCriterion("enterprise_qualification is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationEqualTo(String value) {
            addCriterion("enterprise_qualification =", value, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationNotEqualTo(String value) {
            addCriterion("enterprise_qualification <>", value, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationGreaterThan(String value) {
            addCriterion("enterprise_qualification >", value, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_qualification >=", value, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationLessThan(String value) {
            addCriterion("enterprise_qualification <", value, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationLessThanOrEqualTo(String value) {
            addCriterion("enterprise_qualification <=", value, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationLike(String value) {
            addCriterion("enterprise_qualification like", value, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationNotLike(String value) {
            addCriterion("enterprise_qualification not like", value, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationIn(List<String> values) {
            addCriterion("enterprise_qualification in", values, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationNotIn(List<String> values) {
            addCriterion("enterprise_qualification not in", values, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationBetween(String value1, String value2) {
            addCriterion("enterprise_qualification between", value1, value2, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andEnterpriseQualificationNotBetween(String value1, String value2) {
            addCriterion("enterprise_qualification not between", value1, value2, "enterpriseQualification");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeIsNull() {
            addCriterion("business_license_time is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeIsNotNull() {
            addCriterion("business_license_time is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeEqualTo(String value) {
            addCriterion("business_license_time =", value, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeNotEqualTo(String value) {
            addCriterion("business_license_time <>", value, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeGreaterThan(String value) {
            addCriterion("business_license_time >", value, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_time >=", value, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeLessThan(String value) {
            addCriterion("business_license_time <", value, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeLessThanOrEqualTo(String value) {
            addCriterion("business_license_time <=", value, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeLike(String value) {
            addCriterion("business_license_time like", value, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeNotLike(String value) {
            addCriterion("business_license_time not like", value, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeIn(List<String> values) {
            addCriterion("business_license_time in", values, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeNotIn(List<String> values) {
            addCriterion("business_license_time not in", values, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeBetween(String value1, String value2) {
            addCriterion("business_license_time between", value1, value2, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseTimeNotBetween(String value1, String value2) {
            addCriterion("business_license_time not between", value1, value2, "businessLicenseTime");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(String value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(String value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(String value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(String value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(String value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(String value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLike(String value) {
            addCriterion("credit like", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotLike(String value) {
            addCriterion("credit not like", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<String> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<String> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(String value1, String value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(String value1, String value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManIsNull() {
            addCriterion("legal_person_man is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManIsNotNull() {
            addCriterion("legal_person_man is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManEqualTo(String value) {
            addCriterion("legal_person_man =", value, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManNotEqualTo(String value) {
            addCriterion("legal_person_man <>", value, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManGreaterThan(String value) {
            addCriterion("legal_person_man >", value, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_man >=", value, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManLessThan(String value) {
            addCriterion("legal_person_man <", value, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManLessThanOrEqualTo(String value) {
            addCriterion("legal_person_man <=", value, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManLike(String value) {
            addCriterion("legal_person_man like", value, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManNotLike(String value) {
            addCriterion("legal_person_man not like", value, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManIn(List<String> values) {
            addCriterion("legal_person_man in", values, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManNotIn(List<String> values) {
            addCriterion("legal_person_man not in", values, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManBetween(String value1, String value2) {
            addCriterion("legal_person_man between", value1, value2, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andLegalPersonManNotBetween(String value1, String value2) {
            addCriterion("legal_person_man not between", value1, value2, "legalPersonMan");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNull() {
            addCriterion("enterprise_type is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNotNull() {
            addCriterion("enterprise_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeEqualTo(String value) {
            addCriterion("enterprise_type =", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotEqualTo(String value) {
            addCriterion("enterprise_type <>", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThan(String value) {
            addCriterion("enterprise_type >", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_type >=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThan(String value) {
            addCriterion("enterprise_type <", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThanOrEqualTo(String value) {
            addCriterion("enterprise_type <=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLike(String value) {
            addCriterion("enterprise_type like", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotLike(String value) {
            addCriterion("enterprise_type not like", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIn(List<String> values) {
            addCriterion("enterprise_type in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotIn(List<String> values) {
            addCriterion("enterprise_type not in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeBetween(String value1, String value2) {
            addCriterion("enterprise_type between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotBetween(String value1, String value2) {
            addCriterion("enterprise_type not between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrIsNull() {
            addCriterion("enterprise_addr is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrIsNotNull() {
            addCriterion("enterprise_addr is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrEqualTo(String value) {
            addCriterion("enterprise_addr =", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrNotEqualTo(String value) {
            addCriterion("enterprise_addr <>", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrGreaterThan(String value) {
            addCriterion("enterprise_addr >", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_addr >=", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrLessThan(String value) {
            addCriterion("enterprise_addr <", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrLessThanOrEqualTo(String value) {
            addCriterion("enterprise_addr <=", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrLike(String value) {
            addCriterion("enterprise_addr like", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrNotLike(String value) {
            addCriterion("enterprise_addr not like", value, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrIn(List<String> values) {
            addCriterion("enterprise_addr in", values, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrNotIn(List<String> values) {
            addCriterion("enterprise_addr not in", values, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrBetween(String value1, String value2) {
            addCriterion("enterprise_addr between", value1, value2, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddrNotBetween(String value1, String value2) {
            addCriterion("enterprise_addr not between", value1, value2, "enterpriseAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxIsNull() {
            addCriterion("enterprise_sax is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxIsNotNull() {
            addCriterion("enterprise_sax is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxEqualTo(String value) {
            addCriterion("enterprise_sax =", value, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxNotEqualTo(String value) {
            addCriterion("enterprise_sax <>", value, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxGreaterThan(String value) {
            addCriterion("enterprise_sax >", value, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_sax >=", value, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxLessThan(String value) {
            addCriterion("enterprise_sax <", value, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxLessThanOrEqualTo(String value) {
            addCriterion("enterprise_sax <=", value, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxLike(String value) {
            addCriterion("enterprise_sax like", value, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxNotLike(String value) {
            addCriterion("enterprise_sax not like", value, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxIn(List<String> values) {
            addCriterion("enterprise_sax in", values, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxNotIn(List<String> values) {
            addCriterion("enterprise_sax not in", values, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxBetween(String value1, String value2) {
            addCriterion("enterprise_sax between", value1, value2, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseSaxNotBetween(String value1, String value2) {
            addCriterion("enterprise_sax not between", value1, value2, "enterpriseSax");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIsNull() {
            addCriterion("enterprise_email is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIsNotNull() {
            addCriterion("enterprise_email is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailEqualTo(String value) {
            addCriterion("enterprise_email =", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotEqualTo(String value) {
            addCriterion("enterprise_email <>", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailGreaterThan(String value) {
            addCriterion("enterprise_email >", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_email >=", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLessThan(String value) {
            addCriterion("enterprise_email <", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLessThanOrEqualTo(String value) {
            addCriterion("enterprise_email <=", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailLike(String value) {
            addCriterion("enterprise_email like", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotLike(String value) {
            addCriterion("enterprise_email not like", value, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailIn(List<String> values) {
            addCriterion("enterprise_email in", values, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotIn(List<String> values) {
            addCriterion("enterprise_email not in", values, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailBetween(String value1, String value2) {
            addCriterion("enterprise_email between", value1, value2, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmailNotBetween(String value1, String value2) {
            addCriterion("enterprise_email not between", value1, value2, "enterpriseEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaIsNull() {
            addCriterion("enterprise_eva is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaIsNotNull() {
            addCriterion("enterprise_eva is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaEqualTo(String value) {
            addCriterion("enterprise_eva =", value, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaNotEqualTo(String value) {
            addCriterion("enterprise_eva <>", value, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaGreaterThan(String value) {
            addCriterion("enterprise_eva >", value, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_eva >=", value, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaLessThan(String value) {
            addCriterion("enterprise_eva <", value, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaLessThanOrEqualTo(String value) {
            addCriterion("enterprise_eva <=", value, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaLike(String value) {
            addCriterion("enterprise_eva like", value, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaNotLike(String value) {
            addCriterion("enterprise_eva not like", value, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaIn(List<String> values) {
            addCriterion("enterprise_eva in", values, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaNotIn(List<String> values) {
            addCriterion("enterprise_eva not in", values, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaBetween(String value1, String value2) {
            addCriterion("enterprise_eva between", value1, value2, "enterpriseEva");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEvaNotBetween(String value1, String value2) {
            addCriterion("enterprise_eva not between", value1, value2, "enterpriseEva");
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