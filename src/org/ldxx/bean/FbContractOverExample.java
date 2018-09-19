package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class FbContractOverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbContractOverExample() {
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

        public Criteria andFcoIdIsNull() {
            addCriterion("fco_id is null");
            return (Criteria) this;
        }

        public Criteria andFcoIdIsNotNull() {
            addCriterion("fco_id is not null");
            return (Criteria) this;
        }

        public Criteria andFcoIdEqualTo(String value) {
            addCriterion("fco_id =", value, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdNotEqualTo(String value) {
            addCriterion("fco_id <>", value, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdGreaterThan(String value) {
            addCriterion("fco_id >", value, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdGreaterThanOrEqualTo(String value) {
            addCriterion("fco_id >=", value, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdLessThan(String value) {
            addCriterion("fco_id <", value, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdLessThanOrEqualTo(String value) {
            addCriterion("fco_id <=", value, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdLike(String value) {
            addCriterion("fco_id like", value, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdNotLike(String value) {
            addCriterion("fco_id not like", value, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdIn(List<String> values) {
            addCriterion("fco_id in", values, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdNotIn(List<String> values) {
            addCriterion("fco_id not in", values, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdBetween(String value1, String value2) {
            addCriterion("fco_id between", value1, value2, "fcoId");
            return (Criteria) this;
        }

        public Criteria andFcoIdNotBetween(String value1, String value2) {
            addCriterion("fco_id not between", value1, value2, "fcoId");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIsNull() {
            addCriterion("prj_code is null");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIsNotNull() {
            addCriterion("prj_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrjCodeEqualTo(String value) {
            addCriterion("prj_code =", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotEqualTo(String value) {
            addCriterion("prj_code <>", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeGreaterThan(String value) {
            addCriterion("prj_code >", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeGreaterThanOrEqualTo(String value) {
            addCriterion("prj_code >=", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLessThan(String value) {
            addCriterion("prj_code <", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLessThanOrEqualTo(String value) {
            addCriterion("prj_code <=", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLike(String value) {
            addCriterion("prj_code like", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotLike(String value) {
            addCriterion("prj_code not like", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIn(List<String> values) {
            addCriterion("prj_code in", values, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotIn(List<String> values) {
            addCriterion("prj_code not in", values, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeBetween(String value1, String value2) {
            addCriterion("prj_code between", value1, value2, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotBetween(String value1, String value2) {
            addCriterion("prj_code not between", value1, value2, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjNameIsNull() {
            addCriterion("prj_name is null");
            return (Criteria) this;
        }

        public Criteria andPrjNameIsNotNull() {
            addCriterion("prj_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrjNameEqualTo(String value) {
            addCriterion("prj_name =", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameNotEqualTo(String value) {
            addCriterion("prj_name <>", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameGreaterThan(String value) {
            addCriterion("prj_name >", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameGreaterThanOrEqualTo(String value) {
            addCriterion("prj_name >=", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameLessThan(String value) {
            addCriterion("prj_name <", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameLessThanOrEqualTo(String value) {
            addCriterion("prj_name <=", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameLike(String value) {
            addCriterion("prj_name like", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameNotLike(String value) {
            addCriterion("prj_name not like", value, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameIn(List<String> values) {
            addCriterion("prj_name in", values, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameNotIn(List<String> values) {
            addCriterion("prj_name not in", values, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameBetween(String value1, String value2) {
            addCriterion("prj_name between", value1, value2, "prjName");
            return (Criteria) this;
        }

        public Criteria andPrjNameNotBetween(String value1, String value2) {
            addCriterion("prj_name not between", value1, value2, "prjName");
            return (Criteria) this;
        }

        public Criteria andCjContractIsNull() {
            addCriterion("cj_contract is null");
            return (Criteria) this;
        }

        public Criteria andCjContractIsNotNull() {
            addCriterion("cj_contract is not null");
            return (Criteria) this;
        }

        public Criteria andCjContractEqualTo(String value) {
            addCriterion("cj_contract =", value, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractNotEqualTo(String value) {
            addCriterion("cj_contract <>", value, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractGreaterThan(String value) {
            addCriterion("cj_contract >", value, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractGreaterThanOrEqualTo(String value) {
            addCriterion("cj_contract >=", value, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractLessThan(String value) {
            addCriterion("cj_contract <", value, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractLessThanOrEqualTo(String value) {
            addCriterion("cj_contract <=", value, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractLike(String value) {
            addCriterion("cj_contract like", value, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractNotLike(String value) {
            addCriterion("cj_contract not like", value, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractIn(List<String> values) {
            addCriterion("cj_contract in", values, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractNotIn(List<String> values) {
            addCriterion("cj_contract not in", values, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractBetween(String value1, String value2) {
            addCriterion("cj_contract between", value1, value2, "cjContract");
            return (Criteria) this;
        }

        public Criteria andCjContractNotBetween(String value1, String value2) {
            addCriterion("cj_contract not between", value1, value2, "cjContract");
            return (Criteria) this;
        }

        public Criteria andFbContractIsNull() {
            addCriterion("fb_contract is null");
            return (Criteria) this;
        }

        public Criteria andFbContractIsNotNull() {
            addCriterion("fb_contract is not null");
            return (Criteria) this;
        }

        public Criteria andFbContractEqualTo(String value) {
            addCriterion("fb_contract =", value, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractNotEqualTo(String value) {
            addCriterion("fb_contract <>", value, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractGreaterThan(String value) {
            addCriterion("fb_contract >", value, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractGreaterThanOrEqualTo(String value) {
            addCriterion("fb_contract >=", value, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractLessThan(String value) {
            addCriterion("fb_contract <", value, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractLessThanOrEqualTo(String value) {
            addCriterion("fb_contract <=", value, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractLike(String value) {
            addCriterion("fb_contract like", value, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractNotLike(String value) {
            addCriterion("fb_contract not like", value, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractIn(List<String> values) {
            addCriterion("fb_contract in", values, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractNotIn(List<String> values) {
            addCriterion("fb_contract not in", values, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractBetween(String value1, String value2) {
            addCriterion("fb_contract between", value1, value2, "fbContract");
            return (Criteria) this;
        }

        public Criteria andFbContractNotBetween(String value1, String value2) {
            addCriterion("fb_contract not between", value1, value2, "fbContract");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNull() {
            addCriterion("settlement_type is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIsNotNull() {
            addCriterion("settlement_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeEqualTo(String value) {
            addCriterion("settlement_type =", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotEqualTo(String value) {
            addCriterion("settlement_type <>", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThan(String value) {
            addCriterion("settlement_type >", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_type >=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThan(String value) {
            addCriterion("settlement_type <", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLessThanOrEqualTo(String value) {
            addCriterion("settlement_type <=", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeLike(String value) {
            addCriterion("settlement_type like", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotLike(String value) {
            addCriterion("settlement_type not like", value, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeIn(List<String> values) {
            addCriterion("settlement_type in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotIn(List<String> values) {
            addCriterion("settlement_type not in", values, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeBetween(String value1, String value2) {
            addCriterion("settlement_type between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTypeNotBetween(String value1, String value2) {
            addCriterion("settlement_type not between", value1, value2, "settlementType");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNull() {
            addCriterion("settlement_time is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIsNotNull() {
            addCriterion("settlement_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeEqualTo(String value) {
            addCriterion("settlement_time =", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotEqualTo(String value) {
            addCriterion("settlement_time <>", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThan(String value) {
            addCriterion("settlement_time >", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeGreaterThanOrEqualTo(String value) {
            addCriterion("settlement_time >=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThan(String value) {
            addCriterion("settlement_time <", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLessThanOrEqualTo(String value) {
            addCriterion("settlement_time <=", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeLike(String value) {
            addCriterion("settlement_time like", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotLike(String value) {
            addCriterion("settlement_time not like", value, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeIn(List<String> values) {
            addCriterion("settlement_time in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotIn(List<String> values) {
            addCriterion("settlement_time not in", values, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeBetween(String value1, String value2) {
            addCriterion("settlement_time between", value1, value2, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andSettlementTimeNotBetween(String value1, String value2) {
            addCriterion("settlement_time not between", value1, value2, "settlementTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextIsNull() {
            addCriterion("contract_probably_text is null");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextIsNotNull() {
            addCriterion("contract_probably_text is not null");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextEqualTo(String value) {
            addCriterion("contract_probably_text =", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextNotEqualTo(String value) {
            addCriterion("contract_probably_text <>", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextGreaterThan(String value) {
            addCriterion("contract_probably_text >", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextGreaterThanOrEqualTo(String value) {
            addCriterion("contract_probably_text >=", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextLessThan(String value) {
            addCriterion("contract_probably_text <", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextLessThanOrEqualTo(String value) {
            addCriterion("contract_probably_text <=", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextLike(String value) {
            addCriterion("contract_probably_text like", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextNotLike(String value) {
            addCriterion("contract_probably_text not like", value, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextIn(List<String> values) {
            addCriterion("contract_probably_text in", values, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextNotIn(List<String> values) {
            addCriterion("contract_probably_text not in", values, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextBetween(String value1, String value2) {
            addCriterion("contract_probably_text between", value1, value2, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextNotBetween(String value1, String value2) {
            addCriterion("contract_probably_text not between", value1, value2, "contractProbablyText");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathIsNull() {
            addCriterion("cpt_sign_name_imgpath is null");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathIsNotNull() {
            addCriterion("cpt_sign_name_imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathEqualTo(String value) {
            addCriterion("cpt_sign_name_imgpath =", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathNotEqualTo(String value) {
            addCriterion("cpt_sign_name_imgpath <>", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathGreaterThan(String value) {
            addCriterion("cpt_sign_name_imgpath >", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("cpt_sign_name_imgpath >=", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathLessThan(String value) {
            addCriterion("cpt_sign_name_imgpath <", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathLessThanOrEqualTo(String value) {
            addCriterion("cpt_sign_name_imgpath <=", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathLike(String value) {
            addCriterion("cpt_sign_name_imgpath like", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathNotLike(String value) {
            addCriterion("cpt_sign_name_imgpath not like", value, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathIn(List<String> values) {
            addCriterion("cpt_sign_name_imgpath in", values, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathNotIn(List<String> values) {
            addCriterion("cpt_sign_name_imgpath not in", values, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathBetween(String value1, String value2) {
            addCriterion("cpt_sign_name_imgpath between", value1, value2, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignNameImgpathNotBetween(String value1, String value2) {
            addCriterion("cpt_sign_name_imgpath not between", value1, value2, "cptSignNameImgpath");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeIsNull() {
            addCriterion("cpt_sign_time is null");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeIsNotNull() {
            addCriterion("cpt_sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeEqualTo(String value) {
            addCriterion("cpt_sign_time =", value, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeNotEqualTo(String value) {
            addCriterion("cpt_sign_time <>", value, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeGreaterThan(String value) {
            addCriterion("cpt_sign_time >", value, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeGreaterThanOrEqualTo(String value) {
            addCriterion("cpt_sign_time >=", value, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeLessThan(String value) {
            addCriterion("cpt_sign_time <", value, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeLessThanOrEqualTo(String value) {
            addCriterion("cpt_sign_time <=", value, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeLike(String value) {
            addCriterion("cpt_sign_time like", value, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeNotLike(String value) {
            addCriterion("cpt_sign_time not like", value, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeIn(List<String> values) {
            addCriterion("cpt_sign_time in", values, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeNotIn(List<String> values) {
            addCriterion("cpt_sign_time not in", values, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeBetween(String value1, String value2) {
            addCriterion("cpt_sign_time between", value1, value2, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignTimeNotBetween(String value1, String value2) {
            addCriterion("cpt_sign_time not between", value1, value2, "cptSignTime");
            return (Criteria) this;
        }

        public Criteria andCptSignNameIsNull() {
            addCriterion("cpt_sign_name is null");
            return (Criteria) this;
        }

        public Criteria andCptSignNameIsNotNull() {
            addCriterion("cpt_sign_name is not null");
            return (Criteria) this;
        }

        public Criteria andCptSignNameEqualTo(String value) {
            addCriterion("cpt_sign_name =", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameNotEqualTo(String value) {
            addCriterion("cpt_sign_name <>", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameGreaterThan(String value) {
            addCriterion("cpt_sign_name >", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameGreaterThanOrEqualTo(String value) {
            addCriterion("cpt_sign_name >=", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameLessThan(String value) {
            addCriterion("cpt_sign_name <", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameLessThanOrEqualTo(String value) {
            addCriterion("cpt_sign_name <=", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameLike(String value) {
            addCriterion("cpt_sign_name like", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameNotLike(String value) {
            addCriterion("cpt_sign_name not like", value, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameIn(List<String> values) {
            addCriterion("cpt_sign_name in", values, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameNotIn(List<String> values) {
            addCriterion("cpt_sign_name not in", values, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameBetween(String value1, String value2) {
            addCriterion("cpt_sign_name between", value1, value2, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andCptSignNameNotBetween(String value1, String value2) {
            addCriterion("cpt_sign_name not between", value1, value2, "cptSignName");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeIsNull() {
            addCriterion("contract_probably_text_time is null");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeIsNotNull() {
            addCriterion("contract_probably_text_time is not null");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeEqualTo(String value) {
            addCriterion("contract_probably_text_time =", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeNotEqualTo(String value) {
            addCriterion("contract_probably_text_time <>", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeGreaterThan(String value) {
            addCriterion("contract_probably_text_time >", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_probably_text_time >=", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeLessThan(String value) {
            addCriterion("contract_probably_text_time <", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeLessThanOrEqualTo(String value) {
            addCriterion("contract_probably_text_time <=", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeLike(String value) {
            addCriterion("contract_probably_text_time like", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeNotLike(String value) {
            addCriterion("contract_probably_text_time not like", value, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeIn(List<String> values) {
            addCriterion("contract_probably_text_time in", values, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeNotIn(List<String> values) {
            addCriterion("contract_probably_text_time not in", values, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeBetween(String value1, String value2) {
            addCriterion("contract_probably_text_time between", value1, value2, "contractProbablyTextTime");
            return (Criteria) this;
        }

        public Criteria andContractProbablyTextTimeNotBetween(String value1, String value2) {
            addCriterion("contract_probably_text_time not between", value1, value2, "contractProbablyTextTime");
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