package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class FbContractOverWjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbContractOverWjExample() {
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

        public Criteria andFcowIdIsNull() {
            addCriterion("fcow_id is null");
            return (Criteria) this;
        }

        public Criteria andFcowIdIsNotNull() {
            addCriterion("fcow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFcowIdEqualTo(String value) {
            addCriterion("fcow_id =", value, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdNotEqualTo(String value) {
            addCriterion("fcow_id <>", value, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdGreaterThan(String value) {
            addCriterion("fcow_id >", value, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdGreaterThanOrEqualTo(String value) {
            addCriterion("fcow_id >=", value, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdLessThan(String value) {
            addCriterion("fcow_id <", value, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdLessThanOrEqualTo(String value) {
            addCriterion("fcow_id <=", value, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdLike(String value) {
            addCriterion("fcow_id like", value, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdNotLike(String value) {
            addCriterion("fcow_id not like", value, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdIn(List<String> values) {
            addCriterion("fcow_id in", values, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdNotIn(List<String> values) {
            addCriterion("fcow_id not in", values, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdBetween(String value1, String value2) {
            addCriterion("fcow_id between", value1, value2, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFcowIdNotBetween(String value1, String value2) {
            addCriterion("fcow_id not between", value1, value2, "fcowId");
            return (Criteria) this;
        }

        public Criteria andFbContractNameIsNull() {
            addCriterion("fb_contract_name is null");
            return (Criteria) this;
        }

        public Criteria andFbContractNameIsNotNull() {
            addCriterion("fb_contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andFbContractNameEqualTo(String value) {
            addCriterion("fb_contract_name =", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameNotEqualTo(String value) {
            addCriterion("fb_contract_name <>", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameGreaterThan(String value) {
            addCriterion("fb_contract_name >", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("fb_contract_name >=", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameLessThan(String value) {
            addCriterion("fb_contract_name <", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameLessThanOrEqualTo(String value) {
            addCriterion("fb_contract_name <=", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameLike(String value) {
            addCriterion("fb_contract_name like", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameNotLike(String value) {
            addCriterion("fb_contract_name not like", value, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameIn(List<String> values) {
            addCriterion("fb_contract_name in", values, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameNotIn(List<String> values) {
            addCriterion("fb_contract_name not in", values, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameBetween(String value1, String value2) {
            addCriterion("fb_contract_name between", value1, value2, "fbContractName");
            return (Criteria) this;
        }

        public Criteria andFbContractNameNotBetween(String value1, String value2) {
            addCriterion("fb_contract_name not between", value1, value2, "fbContractName");
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

        public Criteria andPrjChargePersonIsNull() {
            addCriterion("prj_charge_person is null");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonIsNotNull() {
            addCriterion("prj_charge_person is not null");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonEqualTo(String value) {
            addCriterion("prj_charge_person =", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonNotEqualTo(String value) {
            addCriterion("prj_charge_person <>", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonGreaterThan(String value) {
            addCriterion("prj_charge_person >", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonGreaterThanOrEqualTo(String value) {
            addCriterion("prj_charge_person >=", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonLessThan(String value) {
            addCriterion("prj_charge_person <", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonLessThanOrEqualTo(String value) {
            addCriterion("prj_charge_person <=", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonLike(String value) {
            addCriterion("prj_charge_person like", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonNotLike(String value) {
            addCriterion("prj_charge_person not like", value, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonIn(List<String> values) {
            addCriterion("prj_charge_person in", values, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonNotIn(List<String> values) {
            addCriterion("prj_charge_person not in", values, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonBetween(String value1, String value2) {
            addCriterion("prj_charge_person between", value1, value2, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjChargePersonNotBetween(String value1, String value2) {
            addCriterion("prj_charge_person not between", value1, value2, "prjChargePerson");
            return (Criteria) this;
        }

        public Criteria andCjContractNameIsNull() {
            addCriterion("cj_contract_name is null");
            return (Criteria) this;
        }

        public Criteria andCjContractNameIsNotNull() {
            addCriterion("cj_contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andCjContractNameEqualTo(String value) {
            addCriterion("cj_contract_name =", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameNotEqualTo(String value) {
            addCriterion("cj_contract_name <>", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameGreaterThan(String value) {
            addCriterion("cj_contract_name >", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("cj_contract_name >=", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameLessThan(String value) {
            addCriterion("cj_contract_name <", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameLessThanOrEqualTo(String value) {
            addCriterion("cj_contract_name <=", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameLike(String value) {
            addCriterion("cj_contract_name like", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameNotLike(String value) {
            addCriterion("cj_contract_name not like", value, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameIn(List<String> values) {
            addCriterion("cj_contract_name in", values, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameNotIn(List<String> values) {
            addCriterion("cj_contract_name not in", values, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameBetween(String value1, String value2) {
            addCriterion("cj_contract_name between", value1, value2, "cjContractName");
            return (Criteria) this;
        }

        public Criteria andCjContractNameNotBetween(String value1, String value2) {
            addCriterion("cj_contract_name not between", value1, value2, "cjContractName");
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

        public Criteria andContractNameYiIsNull() {
            addCriterion("contract_name_yi is null");
            return (Criteria) this;
        }

        public Criteria andContractNameYiIsNotNull() {
            addCriterion("contract_name_yi is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameYiEqualTo(String value) {
            addCriterion("contract_name_yi =", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiNotEqualTo(String value) {
            addCriterion("contract_name_yi <>", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiGreaterThan(String value) {
            addCriterion("contract_name_yi >", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name_yi >=", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiLessThan(String value) {
            addCriterion("contract_name_yi <", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiLessThanOrEqualTo(String value) {
            addCriterion("contract_name_yi <=", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiLike(String value) {
            addCriterion("contract_name_yi like", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiNotLike(String value) {
            addCriterion("contract_name_yi not like", value, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiIn(List<String> values) {
            addCriterion("contract_name_yi in", values, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiNotIn(List<String> values) {
            addCriterion("contract_name_yi not in", values, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiBetween(String value1, String value2) {
            addCriterion("contract_name_yi between", value1, value2, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andContractNameYiNotBetween(String value1, String value2) {
            addCriterion("contract_name_yi not between", value1, value2, "contractNameYi");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonIsNull() {
            addCriterion("fb_charge_person is null");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonIsNotNull() {
            addCriterion("fb_charge_person is not null");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonEqualTo(String value) {
            addCriterion("fb_charge_person =", value, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonNotEqualTo(String value) {
            addCriterion("fb_charge_person <>", value, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonGreaterThan(String value) {
            addCriterion("fb_charge_person >", value, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonGreaterThanOrEqualTo(String value) {
            addCriterion("fb_charge_person >=", value, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonLessThan(String value) {
            addCriterion("fb_charge_person <", value, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonLessThanOrEqualTo(String value) {
            addCriterion("fb_charge_person <=", value, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonLike(String value) {
            addCriterion("fb_charge_person like", value, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonNotLike(String value) {
            addCriterion("fb_charge_person not like", value, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonIn(List<String> values) {
            addCriterion("fb_charge_person in", values, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonNotIn(List<String> values) {
            addCriterion("fb_charge_person not in", values, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonBetween(String value1, String value2) {
            addCriterion("fb_charge_person between", value1, value2, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andFbChargePersonNotBetween(String value1, String value2) {
            addCriterion("fb_charge_person not between", value1, value2, "fbChargePerson");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextIsNull() {
            addCriterion("prj_probably_text is null");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextIsNotNull() {
            addCriterion("prj_probably_text is not null");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextEqualTo(String value) {
            addCriterion("prj_probably_text =", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextNotEqualTo(String value) {
            addCriterion("prj_probably_text <>", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextGreaterThan(String value) {
            addCriterion("prj_probably_text >", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextGreaterThanOrEqualTo(String value) {
            addCriterion("prj_probably_text >=", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextLessThan(String value) {
            addCriterion("prj_probably_text <", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextLessThanOrEqualTo(String value) {
            addCriterion("prj_probably_text <=", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextLike(String value) {
            addCriterion("prj_probably_text like", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextNotLike(String value) {
            addCriterion("prj_probably_text not like", value, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextIn(List<String> values) {
            addCriterion("prj_probably_text in", values, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextNotIn(List<String> values) {
            addCriterion("prj_probably_text not in", values, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextBetween(String value1, String value2) {
            addCriterion("prj_probably_text between", value1, value2, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andPrjProbablyTextNotBetween(String value1, String value2) {
            addCriterion("prj_probably_text not between", value1, value2, "prjProbablyText");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeIsNull() {
            addCriterion("work_long_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeIsNotNull() {
            addCriterion("work_long_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeEqualTo(String value) {
            addCriterion("work_long_time =", value, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeNotEqualTo(String value) {
            addCriterion("work_long_time <>", value, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeGreaterThan(String value) {
            addCriterion("work_long_time >", value, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeGreaterThanOrEqualTo(String value) {
            addCriterion("work_long_time >=", value, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeLessThan(String value) {
            addCriterion("work_long_time <", value, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeLessThanOrEqualTo(String value) {
            addCriterion("work_long_time <=", value, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeLike(String value) {
            addCriterion("work_long_time like", value, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeNotLike(String value) {
            addCriterion("work_long_time not like", value, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeIn(List<String> values) {
            addCriterion("work_long_time in", values, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeNotIn(List<String> values) {
            addCriterion("work_long_time not in", values, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeBetween(String value1, String value2) {
            addCriterion("work_long_time between", value1, value2, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkLongTimeNotBetween(String value1, String value2) {
            addCriterion("work_long_time not between", value1, value2, "workLongTime");
            return (Criteria) this;
        }

        public Criteria andWorkTextIsNull() {
            addCriterion("work_text is null");
            return (Criteria) this;
        }

        public Criteria andWorkTextIsNotNull() {
            addCriterion("work_text is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTextEqualTo(String value) {
            addCriterion("work_text =", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextNotEqualTo(String value) {
            addCriterion("work_text <>", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextGreaterThan(String value) {
            addCriterion("work_text >", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextGreaterThanOrEqualTo(String value) {
            addCriterion("work_text >=", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextLessThan(String value) {
            addCriterion("work_text <", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextLessThanOrEqualTo(String value) {
            addCriterion("work_text <=", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextLike(String value) {
            addCriterion("work_text like", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextNotLike(String value) {
            addCriterion("work_text not like", value, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextIn(List<String> values) {
            addCriterion("work_text in", values, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextNotIn(List<String> values) {
            addCriterion("work_text not in", values, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextBetween(String value1, String value2) {
            addCriterion("work_text between", value1, value2, "workText");
            return (Criteria) this;
        }

        public Criteria andWorkTextNotBetween(String value1, String value2) {
            addCriterion("work_text not between", value1, value2, "workText");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNull() {
            addCriterion("contract_money is null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNotNull() {
            addCriterion("contract_money is not null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyEqualTo(Double value) {
            addCriterion("contract_money =", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotEqualTo(Double value) {
            addCriterion("contract_money <>", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThan(Double value) {
            addCriterion("contract_money >", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_money >=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThan(Double value) {
            addCriterion("contract_money <", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThanOrEqualTo(Double value) {
            addCriterion("contract_money <=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIn(List<Double> values) {
            addCriterion("contract_money in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotIn(List<Double> values) {
            addCriterion("contract_money not in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyBetween(Double value1, Double value2) {
            addCriterion("contract_money between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotBetween(Double value1, Double value2) {
            addCriterion("contract_money not between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyIsNull() {
            addCriterion("provisional_money is null");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyIsNotNull() {
            addCriterion("provisional_money is not null");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyEqualTo(Double value) {
            addCriterion("provisional_money =", value, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyNotEqualTo(Double value) {
            addCriterion("provisional_money <>", value, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyGreaterThan(Double value) {
            addCriterion("provisional_money >", value, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("provisional_money >=", value, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyLessThan(Double value) {
            addCriterion("provisional_money <", value, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyLessThanOrEqualTo(Double value) {
            addCriterion("provisional_money <=", value, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyIn(List<Double> values) {
            addCriterion("provisional_money in", values, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyNotIn(List<Double> values) {
            addCriterion("provisional_money not in", values, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyBetween(Double value1, Double value2) {
            addCriterion("provisional_money between", value1, value2, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andProvisionalMoneyNotBetween(Double value1, Double value2) {
            addCriterion("provisional_money not between", value1, value2, "provisionalMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyIsNull() {
            addCriterion("over_work_money is null");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyIsNotNull() {
            addCriterion("over_work_money is not null");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyEqualTo(Double value) {
            addCriterion("over_work_money =", value, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyNotEqualTo(Double value) {
            addCriterion("over_work_money <>", value, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyGreaterThan(Double value) {
            addCriterion("over_work_money >", value, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("over_work_money >=", value, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyLessThan(Double value) {
            addCriterion("over_work_money <", value, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyLessThanOrEqualTo(Double value) {
            addCriterion("over_work_money <=", value, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyIn(List<Double> values) {
            addCriterion("over_work_money in", values, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyNotIn(List<Double> values) {
            addCriterion("over_work_money not in", values, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyBetween(Double value1, Double value2) {
            addCriterion("over_work_money between", value1, value2, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkMoneyNotBetween(Double value1, Double value2) {
            addCriterion("over_work_money not between", value1, value2, "overWorkMoney");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainIsNull() {
            addCriterion("over_work_explain is null");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainIsNotNull() {
            addCriterion("over_work_explain is not null");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainEqualTo(String value) {
            addCriterion("over_work_explain =", value, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainNotEqualTo(String value) {
            addCriterion("over_work_explain <>", value, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainGreaterThan(String value) {
            addCriterion("over_work_explain >", value, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainGreaterThanOrEqualTo(String value) {
            addCriterion("over_work_explain >=", value, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainLessThan(String value) {
            addCriterion("over_work_explain <", value, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainLessThanOrEqualTo(String value) {
            addCriterion("over_work_explain <=", value, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainLike(String value) {
            addCriterion("over_work_explain like", value, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainNotLike(String value) {
            addCriterion("over_work_explain not like", value, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainIn(List<String> values) {
            addCriterion("over_work_explain in", values, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainNotIn(List<String> values) {
            addCriterion("over_work_explain not in", values, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainBetween(String value1, String value2) {
            addCriterion("over_work_explain between", value1, value2, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andOverWorkExplainNotBetween(String value1, String value2) {
            addCriterion("over_work_explain not between", value1, value2, "overWorkExplain");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyIsNull() {
            addCriterion("all_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyIsNotNull() {
            addCriterion("all_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyEqualTo(Double value) {
            addCriterion("all_pay_money =", value, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyNotEqualTo(Double value) {
            addCriterion("all_pay_money <>", value, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyGreaterThan(Double value) {
            addCriterion("all_pay_money >", value, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("all_pay_money >=", value, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyLessThan(Double value) {
            addCriterion("all_pay_money <", value, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyLessThanOrEqualTo(Double value) {
            addCriterion("all_pay_money <=", value, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyIn(List<Double> values) {
            addCriterion("all_pay_money in", values, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyNotIn(List<Double> values) {
            addCriterion("all_pay_money not in", values, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyBetween(Double value1, Double value2) {
            addCriterion("all_pay_money between", value1, value2, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andAllPayMoneyNotBetween(Double value1, Double value2) {
            addCriterion("all_pay_money not between", value1, value2, "allPayMoney");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreIsNull() {
            addCriterion("do_appoint_score is null");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreIsNotNull() {
            addCriterion("do_appoint_score is not null");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreEqualTo(String value) {
            addCriterion("do_appoint_score =", value, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreNotEqualTo(String value) {
            addCriterion("do_appoint_score <>", value, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreGreaterThan(String value) {
            addCriterion("do_appoint_score >", value, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreGreaterThanOrEqualTo(String value) {
            addCriterion("do_appoint_score >=", value, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreLessThan(String value) {
            addCriterion("do_appoint_score <", value, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreLessThanOrEqualTo(String value) {
            addCriterion("do_appoint_score <=", value, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreLike(String value) {
            addCriterion("do_appoint_score like", value, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreNotLike(String value) {
            addCriterion("do_appoint_score not like", value, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreIn(List<String> values) {
            addCriterion("do_appoint_score in", values, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreNotIn(List<String> values) {
            addCriterion("do_appoint_score not in", values, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreBetween(String value1, String value2) {
            addCriterion("do_appoint_score between", value1, value2, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andDoAppointScoreNotBetween(String value1, String value2) {
            addCriterion("do_appoint_score not between", value1, value2, "doAppointScore");
            return (Criteria) this;
        }

        public Criteria andOtherFileIsNull() {
            addCriterion("other_file is null");
            return (Criteria) this;
        }

        public Criteria andOtherFileIsNotNull() {
            addCriterion("other_file is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFileEqualTo(String value) {
            addCriterion("other_file =", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileNotEqualTo(String value) {
            addCriterion("other_file <>", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileGreaterThan(String value) {
            addCriterion("other_file >", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileGreaterThanOrEqualTo(String value) {
            addCriterion("other_file >=", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileLessThan(String value) {
            addCriterion("other_file <", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileLessThanOrEqualTo(String value) {
            addCriterion("other_file <=", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileLike(String value) {
            addCriterion("other_file like", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileNotLike(String value) {
            addCriterion("other_file not like", value, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileIn(List<String> values) {
            addCriterion("other_file in", values, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileNotIn(List<String> values) {
            addCriterion("other_file not in", values, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileBetween(String value1, String value2) {
            addCriterion("other_file between", value1, value2, "otherFile");
            return (Criteria) this;
        }

        public Criteria andOtherFileNotBetween(String value1, String value2) {
            addCriterion("other_file not between", value1, value2, "otherFile");
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