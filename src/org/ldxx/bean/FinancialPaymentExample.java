package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinancialPaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancialPaymentExample() {
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

        public Criteria andFpIdIsNull() {
            addCriterion("fp_id is null");
            return (Criteria) this;
        }

        public Criteria andFpIdIsNotNull() {
            addCriterion("fp_id is not null");
            return (Criteria) this;
        }

        public Criteria andFpIdEqualTo(String value) {
            addCriterion("fp_id =", value, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdNotEqualTo(String value) {
            addCriterion("fp_id <>", value, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdGreaterThan(String value) {
            addCriterion("fp_id >", value, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdGreaterThanOrEqualTo(String value) {
            addCriterion("fp_id >=", value, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdLessThan(String value) {
            addCriterion("fp_id <", value, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdLessThanOrEqualTo(String value) {
            addCriterion("fp_id <=", value, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdLike(String value) {
            addCriterion("fp_id like", value, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdNotLike(String value) {
            addCriterion("fp_id not like", value, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdIn(List<String> values) {
            addCriterion("fp_id in", values, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdNotIn(List<String> values) {
            addCriterion("fp_id not in", values, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdBetween(String value1, String value2) {
            addCriterion("fp_id between", value1, value2, "fpId");
            return (Criteria) this;
        }

        public Criteria andFpIdNotBetween(String value1, String value2) {
            addCriterion("fp_id not between", value1, value2, "fpId");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andWorkNoIsNull() {
            addCriterion("work_no is null");
            return (Criteria) this;
        }

        public Criteria andWorkNoIsNotNull() {
            addCriterion("work_no is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNoEqualTo(String value) {
            addCriterion("work_no =", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotEqualTo(String value) {
            addCriterion("work_no <>", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThan(String value) {
            addCriterion("work_no >", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThanOrEqualTo(String value) {
            addCriterion("work_no >=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThan(String value) {
            addCriterion("work_no <", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThanOrEqualTo(String value) {
            addCriterion("work_no <=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLike(String value) {
            addCriterion("work_no like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotLike(String value) {
            addCriterion("work_no not like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoIn(List<String> values) {
            addCriterion("work_no in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotIn(List<String> values) {
            addCriterion("work_no not in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoBetween(String value1, String value2) {
            addCriterion("work_no between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotBetween(String value1, String value2) {
            addCriterion("work_no not between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andContractNumberIsNull() {
            addCriterion("contract_number is null");
            return (Criteria) this;
        }

        public Criteria andContractNumberIsNotNull() {
            addCriterion("contract_number is not null");
            return (Criteria) this;
        }

        public Criteria andContractNumberEqualTo(String value) {
            addCriterion("contract_number =", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotEqualTo(String value) {
            addCriterion("contract_number <>", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberGreaterThan(String value) {
            addCriterion("contract_number >", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contract_number >=", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLessThan(String value) {
            addCriterion("contract_number <", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLessThanOrEqualTo(String value) {
            addCriterion("contract_number <=", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLike(String value) {
            addCriterion("contract_number like", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotLike(String value) {
            addCriterion("contract_number not like", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberIn(List<String> values) {
            addCriterion("contract_number in", values, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotIn(List<String> values) {
            addCriterion("contract_number not in", values, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberBetween(String value1, String value2) {
            addCriterion("contract_number between", value1, value2, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotBetween(String value1, String value2) {
            addCriterion("contract_number not between", value1, value2, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberIsNull() {
            addCriterion("payment_number is null");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberIsNotNull() {
            addCriterion("payment_number is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberEqualTo(String value) {
            addCriterion("payment_number =", value, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberNotEqualTo(String value) {
            addCriterion("payment_number <>", value, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberGreaterThan(String value) {
            addCriterion("payment_number >", value, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("payment_number >=", value, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberLessThan(String value) {
            addCriterion("payment_number <", value, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberLessThanOrEqualTo(String value) {
            addCriterion("payment_number <=", value, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberLike(String value) {
            addCriterion("payment_number like", value, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberNotLike(String value) {
            addCriterion("payment_number not like", value, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberIn(List<String> values) {
            addCriterion("payment_number in", values, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberNotIn(List<String> values) {
            addCriterion("payment_number not in", values, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberBetween(String value1, String value2) {
            addCriterion("payment_number between", value1, value2, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andPaymentNumberNotBetween(String value1, String value2) {
            addCriterion("payment_number not between", value1, value2, "paymentNumber");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNull() {
            addCriterion("contract_name is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("contract_name =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("contract_name <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("contract_name >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("contract_name <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("contract_name <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("contract_name like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("contract_name not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("contract_name in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("contract_name not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("contract_name between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("contract_name not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andAdministrationIsNull() {
            addCriterion("administration is null");
            return (Criteria) this;
        }

        public Criteria andAdministrationIsNotNull() {
            addCriterion("administration is not null");
            return (Criteria) this;
        }

        public Criteria andAdministrationEqualTo(String value) {
            addCriterion("administration =", value, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationNotEqualTo(String value) {
            addCriterion("administration <>", value, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationGreaterThan(String value) {
            addCriterion("administration >", value, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationGreaterThanOrEqualTo(String value) {
            addCriterion("administration >=", value, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationLessThan(String value) {
            addCriterion("administration <", value, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationLessThanOrEqualTo(String value) {
            addCriterion("administration <=", value, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationLike(String value) {
            addCriterion("administration like", value, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationNotLike(String value) {
            addCriterion("administration not like", value, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationIn(List<String> values) {
            addCriterion("administration in", values, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationNotIn(List<String> values) {
            addCriterion("administration not in", values, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationBetween(String value1, String value2) {
            addCriterion("administration between", value1, value2, "administration");
            return (Criteria) this;
        }

        public Criteria andAdministrationNotBetween(String value1, String value2) {
            addCriterion("administration not between", value1, value2, "administration");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNull() {
            addCriterion("contract_amount is null");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNotNull() {
            addCriterion("contract_amount is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmountEqualTo(BigDecimal value) {
            addCriterion("contract_amount =", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotEqualTo(BigDecimal value) {
            addCriterion("contract_amount <>", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThan(BigDecimal value) {
            addCriterion("contract_amount >", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount >=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThan(BigDecimal value) {
            addCriterion("contract_amount <", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount <=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountIn(List<BigDecimal> values) {
            addCriterion("contract_amount in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotIn(List<BigDecimal> values) {
            addCriterion("contract_amount not in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount not between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmount2IsNull() {
            addCriterion("contract_amount2 is null");
            return (Criteria) this;
        }

        public Criteria andContractAmount2IsNotNull() {
            addCriterion("contract_amount2 is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmount2EqualTo(BigDecimal value) {
            addCriterion("contract_amount2 =", value, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2NotEqualTo(BigDecimal value) {
            addCriterion("contract_amount2 <>", value, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2GreaterThan(BigDecimal value) {
            addCriterion("contract_amount2 >", value, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount2 >=", value, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2LessThan(BigDecimal value) {
            addCriterion("contract_amount2 <", value, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount2 <=", value, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2In(List<BigDecimal> values) {
            addCriterion("contract_amount2 in", values, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2NotIn(List<BigDecimal> values) {
            addCriterion("contract_amount2 not in", values, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount2 between", value1, value2, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractAmount2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount2 not between", value1, value2, "contractAmount2");
            return (Criteria) this;
        }

        public Criteria andContractPaymentIsNull() {
            addCriterion("contract_payment is null");
            return (Criteria) this;
        }

        public Criteria andContractPaymentIsNotNull() {
            addCriterion("contract_payment is not null");
            return (Criteria) this;
        }

        public Criteria andContractPaymentEqualTo(BigDecimal value) {
            addCriterion("contract_payment =", value, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentNotEqualTo(BigDecimal value) {
            addCriterion("contract_payment <>", value, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentGreaterThan(BigDecimal value) {
            addCriterion("contract_payment >", value, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_payment >=", value, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentLessThan(BigDecimal value) {
            addCriterion("contract_payment <", value, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_payment <=", value, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentIn(List<BigDecimal> values) {
            addCriterion("contract_payment in", values, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentNotIn(List<BigDecimal> values) {
            addCriterion("contract_payment not in", values, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_payment between", value1, value2, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andContractPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_payment not between", value1, value2, "contractPayment");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioIsNull() {
            addCriterion("collection_ratio is null");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioIsNotNull() {
            addCriterion("collection_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioEqualTo(BigDecimal value) {
            addCriterion("collection_ratio =", value, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioNotEqualTo(BigDecimal value) {
            addCriterion("collection_ratio <>", value, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioGreaterThan(BigDecimal value) {
            addCriterion("collection_ratio >", value, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("collection_ratio >=", value, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioLessThan(BigDecimal value) {
            addCriterion("collection_ratio <", value, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("collection_ratio <=", value, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioIn(List<BigDecimal> values) {
            addCriterion("collection_ratio in", values, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioNotIn(List<BigDecimal> values) {
            addCriterion("collection_ratio not in", values, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collection_ratio between", value1, value2, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andCollectionRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collection_ratio not between", value1, value2, "collectionRatio");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitIsNull() {
            addCriterion("contract_no_split is null");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitIsNotNull() {
            addCriterion("contract_no_split is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitEqualTo(String value) {
            addCriterion("contract_no_split =", value, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitNotEqualTo(String value) {
            addCriterion("contract_no_split <>", value, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitGreaterThan(String value) {
            addCriterion("contract_no_split >", value, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitGreaterThanOrEqualTo(String value) {
            addCriterion("contract_no_split >=", value, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitLessThan(String value) {
            addCriterion("contract_no_split <", value, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitLessThanOrEqualTo(String value) {
            addCriterion("contract_no_split <=", value, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitLike(String value) {
            addCriterion("contract_no_split like", value, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitNotLike(String value) {
            addCriterion("contract_no_split not like", value, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitIn(List<String> values) {
            addCriterion("contract_no_split in", values, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitNotIn(List<String> values) {
            addCriterion("contract_no_split not in", values, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitBetween(String value1, String value2) {
            addCriterion("contract_no_split between", value1, value2, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNoSplitNotBetween(String value1, String value2) {
            addCriterion("contract_no_split not between", value1, value2, "contractNoSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitIsNull() {
            addCriterion("contract_name_split is null");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitIsNotNull() {
            addCriterion("contract_name_split is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitEqualTo(String value) {
            addCriterion("contract_name_split =", value, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitNotEqualTo(String value) {
            addCriterion("contract_name_split <>", value, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitGreaterThan(String value) {
            addCriterion("contract_name_split >", value, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name_split >=", value, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitLessThan(String value) {
            addCriterion("contract_name_split <", value, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitLessThanOrEqualTo(String value) {
            addCriterion("contract_name_split <=", value, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitLike(String value) {
            addCriterion("contract_name_split like", value, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitNotLike(String value) {
            addCriterion("contract_name_split not like", value, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitIn(List<String> values) {
            addCriterion("contract_name_split in", values, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitNotIn(List<String> values) {
            addCriterion("contract_name_split not in", values, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitBetween(String value1, String value2) {
            addCriterion("contract_name_split between", value1, value2, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andContractNameSplitNotBetween(String value1, String value2) {
            addCriterion("contract_name_split not between", value1, value2, "contractNameSplit");
            return (Criteria) this;
        }

        public Criteria andSecondPartyIsNull() {
            addCriterion("second_party is null");
            return (Criteria) this;
        }

        public Criteria andSecondPartyIsNotNull() {
            addCriterion("second_party is not null");
            return (Criteria) this;
        }

        public Criteria andSecondPartyEqualTo(String value) {
            addCriterion("second_party =", value, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyNotEqualTo(String value) {
            addCriterion("second_party <>", value, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyGreaterThan(String value) {
            addCriterion("second_party >", value, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyGreaterThanOrEqualTo(String value) {
            addCriterion("second_party >=", value, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyLessThan(String value) {
            addCriterion("second_party <", value, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyLessThanOrEqualTo(String value) {
            addCriterion("second_party <=", value, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyLike(String value) {
            addCriterion("second_party like", value, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyNotLike(String value) {
            addCriterion("second_party not like", value, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyIn(List<String> values) {
            addCriterion("second_party in", values, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyNotIn(List<String> values) {
            addCriterion("second_party not in", values, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyBetween(String value1, String value2) {
            addCriterion("second_party between", value1, value2, "secondParty");
            return (Criteria) this;
        }

        public Criteria andSecondPartyNotBetween(String value1, String value2) {
            addCriterion("second_party not between", value1, value2, "secondParty");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitIsNull() {
            addCriterion("contract_amount_split is null");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitIsNotNull() {
            addCriterion("contract_amount_split is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitEqualTo(BigDecimal value) {
            addCriterion("contract_amount_split =", value, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitNotEqualTo(BigDecimal value) {
            addCriterion("contract_amount_split <>", value, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitGreaterThan(BigDecimal value) {
            addCriterion("contract_amount_split >", value, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount_split >=", value, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitLessThan(BigDecimal value) {
            addCriterion("contract_amount_split <", value, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount_split <=", value, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitIn(List<BigDecimal> values) {
            addCriterion("contract_amount_split in", values, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitNotIn(List<BigDecimal> values) {
            addCriterion("contract_amount_split not in", values, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount_split between", value1, value2, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount_split not between", value1, value2, "contractAmountSplit");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2IsNull() {
            addCriterion("contract_amount_split2 is null");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2IsNotNull() {
            addCriterion("contract_amount_split2 is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2EqualTo(BigDecimal value) {
            addCriterion("contract_amount_split2 =", value, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2NotEqualTo(BigDecimal value) {
            addCriterion("contract_amount_split2 <>", value, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2GreaterThan(BigDecimal value) {
            addCriterion("contract_amount_split2 >", value, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount_split2 >=", value, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2LessThan(BigDecimal value) {
            addCriterion("contract_amount_split2 <", value, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount_split2 <=", value, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2In(List<BigDecimal> values) {
            addCriterion("contract_amount_split2 in", values, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2NotIn(List<BigDecimal> values) {
            addCriterion("contract_amount_split2 not in", values, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount_split2 between", value1, value2, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andContractAmountSplit2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount_split2 not between", value1, value2, "contractAmountSplit2");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentIsNull() {
            addCriterion("accumulated_payment is null");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentIsNotNull() {
            addCriterion("accumulated_payment is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentEqualTo(BigDecimal value) {
            addCriterion("accumulated_payment =", value, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentNotEqualTo(BigDecimal value) {
            addCriterion("accumulated_payment <>", value, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentGreaterThan(BigDecimal value) {
            addCriterion("accumulated_payment >", value, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accumulated_payment >=", value, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentLessThan(BigDecimal value) {
            addCriterion("accumulated_payment <", value, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accumulated_payment <=", value, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentIn(List<BigDecimal> values) {
            addCriterion("accumulated_payment in", values, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentNotIn(List<BigDecimal> values) {
            addCriterion("accumulated_payment not in", values, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accumulated_payment between", value1, value2, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andAccumulatedPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accumulated_payment not between", value1, value2, "accumulatedPayment");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountIsNull() {
            addCriterion("Invoiced_amount is null");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountIsNotNull() {
            addCriterion("Invoiced_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountEqualTo(BigDecimal value) {
            addCriterion("Invoiced_amount =", value, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountNotEqualTo(BigDecimal value) {
            addCriterion("Invoiced_amount <>", value, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountGreaterThan(BigDecimal value) {
            addCriterion("Invoiced_amount >", value, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Invoiced_amount >=", value, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountLessThan(BigDecimal value) {
            addCriterion("Invoiced_amount <", value, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Invoiced_amount <=", value, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountIn(List<BigDecimal> values) {
            addCriterion("Invoiced_amount in", values, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountNotIn(List<BigDecimal> values) {
            addCriterion("Invoiced_amount not in", values, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Invoiced_amount between", value1, value2, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoicedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Invoiced_amount not between", value1, value2, "invoicedAmount");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherIsNull() {
            addCriterion("invoice_number_other is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherIsNotNull() {
            addCriterion("invoice_number_other is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherEqualTo(String value) {
            addCriterion("invoice_number_other =", value, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherNotEqualTo(String value) {
            addCriterion("invoice_number_other <>", value, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherGreaterThan(String value) {
            addCriterion("invoice_number_other >", value, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_number_other >=", value, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherLessThan(String value) {
            addCriterion("invoice_number_other <", value, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherLessThanOrEqualTo(String value) {
            addCriterion("invoice_number_other <=", value, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherLike(String value) {
            addCriterion("invoice_number_other like", value, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherNotLike(String value) {
            addCriterion("invoice_number_other not like", value, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherIn(List<String> values) {
            addCriterion("invoice_number_other in", values, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherNotIn(List<String> values) {
            addCriterion("invoice_number_other not in", values, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherBetween(String value1, String value2) {
            addCriterion("invoice_number_other between", value1, value2, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumberOtherNotBetween(String value1, String value2) {
            addCriterion("invoice_number_other not between", value1, value2, "invoiceNumberOther");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedIsNull() {
            addCriterion("amount_received is null");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedIsNotNull() {
            addCriterion("amount_received is not null");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedEqualTo(BigDecimal value) {
            addCriterion("amount_received =", value, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedNotEqualTo(BigDecimal value) {
            addCriterion("amount_received <>", value, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedGreaterThan(BigDecimal value) {
            addCriterion("amount_received >", value, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_received >=", value, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedLessThan(BigDecimal value) {
            addCriterion("amount_received <", value, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_received <=", value, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedIn(List<BigDecimal> values) {
            addCriterion("amount_received in", values, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedNotIn(List<BigDecimal> values) {
            addCriterion("amount_received not in", values, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_received between", value1, value2, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andAmountReceivedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_received not between", value1, value2, "amountReceived");
            return (Criteria) this;
        }

        public Criteria andActualPaymentIsNull() {
            addCriterion("actual_payment is null");
            return (Criteria) this;
        }

        public Criteria andActualPaymentIsNotNull() {
            addCriterion("actual_payment is not null");
            return (Criteria) this;
        }

        public Criteria andActualPaymentEqualTo(BigDecimal value) {
            addCriterion("actual_payment =", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentNotEqualTo(BigDecimal value) {
            addCriterion("actual_payment <>", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentGreaterThan(BigDecimal value) {
            addCriterion("actual_payment >", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_payment >=", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentLessThan(BigDecimal value) {
            addCriterion("actual_payment <", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_payment <=", value, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentIn(List<BigDecimal> values) {
            addCriterion("actual_payment in", values, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentNotIn(List<BigDecimal> values) {
            addCriterion("actual_payment not in", values, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_payment between", value1, value2, "actualPayment");
            return (Criteria) this;
        }

        public Criteria andActualPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_payment not between", value1, value2, "actualPayment");
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