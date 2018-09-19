package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class InvoiceSignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoiceSignExample() {
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

        public Criteria andIsIdIsNull() {
            addCriterion("is_id is null");
            return (Criteria) this;
        }

        public Criteria andIsIdIsNotNull() {
            addCriterion("is_id is not null");
            return (Criteria) this;
        }

        public Criteria andIsIdEqualTo(String value) {
            addCriterion("is_id =", value, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdNotEqualTo(String value) {
            addCriterion("is_id <>", value, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdGreaterThan(String value) {
            addCriterion("is_id >", value, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdGreaterThanOrEqualTo(String value) {
            addCriterion("is_id >=", value, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdLessThan(String value) {
            addCriterion("is_id <", value, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdLessThanOrEqualTo(String value) {
            addCriterion("is_id <=", value, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdLike(String value) {
            addCriterion("is_id like", value, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdNotLike(String value) {
            addCriterion("is_id not like", value, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdIn(List<String> values) {
            addCriterion("is_id in", values, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdNotIn(List<String> values) {
            addCriterion("is_id not in", values, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdBetween(String value1, String value2) {
            addCriterion("is_id between", value1, value2, "isId");
            return (Criteria) this;
        }

        public Criteria andIsIdNotBetween(String value1, String value2) {
            addCriterion("is_id not between", value1, value2, "isId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateIsNull() {
            addCriterion("invoice_date is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateIsNotNull() {
            addCriterion("invoice_date is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateEqualTo(String value) {
            addCriterion("invoice_date =", value, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateNotEqualTo(String value) {
            addCriterion("invoice_date <>", value, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateGreaterThan(String value) {
            addCriterion("invoice_date >", value, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_date >=", value, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateLessThan(String value) {
            addCriterion("invoice_date <", value, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateLessThanOrEqualTo(String value) {
            addCriterion("invoice_date <=", value, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateLike(String value) {
            addCriterion("invoice_date like", value, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateNotLike(String value) {
            addCriterion("invoice_date not like", value, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateIn(List<String> values) {
            addCriterion("invoice_date in", values, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateNotIn(List<String> values) {
            addCriterion("invoice_date not in", values, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateBetween(String value1, String value2) {
            addCriterion("invoice_date between", value1, value2, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceDateNotBetween(String value1, String value2) {
            addCriterion("invoice_date not between", value1, value2, "invoiceDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyIsNull() {
            addCriterion("invoice_money is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyIsNotNull() {
            addCriterion("invoice_money is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyEqualTo(Float value) {
            addCriterion("invoice_money =", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyNotEqualTo(Float value) {
            addCriterion("invoice_money <>", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyGreaterThan(Float value) {
            addCriterion("invoice_money >", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("invoice_money >=", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyLessThan(Float value) {
            addCriterion("invoice_money <", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyLessThanOrEqualTo(Float value) {
            addCriterion("invoice_money <=", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyIn(List<Float> values) {
            addCriterion("invoice_money in", values, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyNotIn(List<Float> values) {
            addCriterion("invoice_money not in", values, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyBetween(Float value1, Float value2) {
            addCriterion("invoice_money between", value1, value2, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyNotBetween(Float value1, Float value2) {
            addCriterion("invoice_money not between", value1, value2, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(String value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(String value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(String value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(String value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLike(String value) {
            addCriterion("invoice_type like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotLike(String value) {
            addCriterion("invoice_type not like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<String> values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<String> values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(String value1, String value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNull() {
            addCriterion("invoice_no is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNotNull() {
            addCriterion("invoice_no is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoEqualTo(String value) {
            addCriterion("invoice_no =", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotEqualTo(String value) {
            addCriterion("invoice_no <>", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThan(String value) {
            addCriterion("invoice_no >", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_no >=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThan(String value) {
            addCriterion("invoice_no <", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThanOrEqualTo(String value) {
            addCriterion("invoice_no <=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLike(String value) {
            addCriterion("invoice_no like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotLike(String value) {
            addCriterion("invoice_no not like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIn(List<String> values) {
            addCriterion("invoice_no in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotIn(List<String> values) {
            addCriterion("invoice_no not in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoBetween(String value1, String value2) {
            addCriterion("invoice_no between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotBetween(String value1, String value2) {
            addCriterion("invoice_no not between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andProductOwnersIsNull() {
            addCriterion("product_owners is null");
            return (Criteria) this;
        }

        public Criteria andProductOwnersIsNotNull() {
            addCriterion("product_owners is not null");
            return (Criteria) this;
        }

        public Criteria andProductOwnersEqualTo(String value) {
            addCriterion("product_owners =", value, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersNotEqualTo(String value) {
            addCriterion("product_owners <>", value, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersGreaterThan(String value) {
            addCriterion("product_owners >", value, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersGreaterThanOrEqualTo(String value) {
            addCriterion("product_owners >=", value, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersLessThan(String value) {
            addCriterion("product_owners <", value, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersLessThanOrEqualTo(String value) {
            addCriterion("product_owners <=", value, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersLike(String value) {
            addCriterion("product_owners like", value, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersNotLike(String value) {
            addCriterion("product_owners not like", value, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersIn(List<String> values) {
            addCriterion("product_owners in", values, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersNotIn(List<String> values) {
            addCriterion("product_owners not in", values, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersBetween(String value1, String value2) {
            addCriterion("product_owners between", value1, value2, "productOwners");
            return (Criteria) this;
        }

        public Criteria andProductOwnersNotBetween(String value1, String value2) {
            addCriterion("product_owners not between", value1, value2, "productOwners");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoIsNull() {
            addCriterion("taxpayer_no is null");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoIsNotNull() {
            addCriterion("taxpayer_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoEqualTo(String value) {
            addCriterion("taxpayer_no =", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoNotEqualTo(String value) {
            addCriterion("taxpayer_no <>", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoGreaterThan(String value) {
            addCriterion("taxpayer_no >", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoGreaterThanOrEqualTo(String value) {
            addCriterion("taxpayer_no >=", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoLessThan(String value) {
            addCriterion("taxpayer_no <", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoLessThanOrEqualTo(String value) {
            addCriterion("taxpayer_no <=", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoLike(String value) {
            addCriterion("taxpayer_no like", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoNotLike(String value) {
            addCriterion("taxpayer_no not like", value, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoIn(List<String> values) {
            addCriterion("taxpayer_no in", values, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoNotIn(List<String> values) {
            addCriterion("taxpayer_no not in", values, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoBetween(String value1, String value2) {
            addCriterion("taxpayer_no between", value1, value2, "taxpayerNo");
            return (Criteria) this;
        }

        public Criteria andTaxpayerNoNotBetween(String value1, String value2) {
            addCriterion("taxpayer_no not between", value1, value2, "taxpayerNo");
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

        public Criteria andCompanyManagerIsNull() {
            addCriterion("company_manager is null");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerIsNotNull() {
            addCriterion("company_manager is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerEqualTo(String value) {
            addCriterion("company_manager =", value, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerNotEqualTo(String value) {
            addCriterion("company_manager <>", value, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerGreaterThan(String value) {
            addCriterion("company_manager >", value, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerGreaterThanOrEqualTo(String value) {
            addCriterion("company_manager >=", value, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerLessThan(String value) {
            addCriterion("company_manager <", value, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerLessThanOrEqualTo(String value) {
            addCriterion("company_manager <=", value, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerLike(String value) {
            addCriterion("company_manager like", value, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerNotLike(String value) {
            addCriterion("company_manager not like", value, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerIn(List<String> values) {
            addCriterion("company_manager in", values, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerNotIn(List<String> values) {
            addCriterion("company_manager not in", values, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerBetween(String value1, String value2) {
            addCriterion("company_manager between", value1, value2, "companyManager");
            return (Criteria) this;
        }

        public Criteria andCompanyManagerNotBetween(String value1, String value2) {
            addCriterion("company_manager not between", value1, value2, "companyManager");
            return (Criteria) this;
        }

        public Criteria andTicketDateIsNull() {
            addCriterion("ticket_date is null");
            return (Criteria) this;
        }

        public Criteria andTicketDateIsNotNull() {
            addCriterion("ticket_date is not null");
            return (Criteria) this;
        }

        public Criteria andTicketDateEqualTo(String value) {
            addCriterion("ticket_date =", value, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateNotEqualTo(String value) {
            addCriterion("ticket_date <>", value, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateGreaterThan(String value) {
            addCriterion("ticket_date >", value, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_date >=", value, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateLessThan(String value) {
            addCriterion("ticket_date <", value, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateLessThanOrEqualTo(String value) {
            addCriterion("ticket_date <=", value, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateLike(String value) {
            addCriterion("ticket_date like", value, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateNotLike(String value) {
            addCriterion("ticket_date not like", value, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateIn(List<String> values) {
            addCriterion("ticket_date in", values, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateNotIn(List<String> values) {
            addCriterion("ticket_date not in", values, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateBetween(String value1, String value2) {
            addCriterion("ticket_date between", value1, value2, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andTicketDateNotBetween(String value1, String value2) {
            addCriterion("ticket_date not between", value1, value2, "ticketDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignIsNull() {
            addCriterion("Invoice_sign is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignIsNotNull() {
            addCriterion("Invoice_sign is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignEqualTo(String value) {
            addCriterion("Invoice_sign =", value, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignNotEqualTo(String value) {
            addCriterion("Invoice_sign <>", value, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignGreaterThan(String value) {
            addCriterion("Invoice_sign >", value, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignGreaterThanOrEqualTo(String value) {
            addCriterion("Invoice_sign >=", value, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignLessThan(String value) {
            addCriterion("Invoice_sign <", value, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignLessThanOrEqualTo(String value) {
            addCriterion("Invoice_sign <=", value, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignLike(String value) {
            addCriterion("Invoice_sign like", value, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignNotLike(String value) {
            addCriterion("Invoice_sign not like", value, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignIn(List<String> values) {
            addCriterion("Invoice_sign in", values, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignNotIn(List<String> values) {
            addCriterion("Invoice_sign not in", values, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignBetween(String value1, String value2) {
            addCriterion("Invoice_sign between", value1, value2, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andInvoiceSignNotBetween(String value1, String value2) {
            addCriterion("Invoice_sign not between", value1, value2, "invoiceSign");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNull() {
            addCriterion("sign_date is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(String value) {
            addCriterion("sign_date =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(String value) {
            addCriterion("sign_date <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(String value) {
            addCriterion("sign_date >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(String value) {
            addCriterion("sign_date >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(String value) {
            addCriterion("sign_date <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(String value) {
            addCriterion("sign_date <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLike(String value) {
            addCriterion("sign_date like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotLike(String value) {
            addCriterion("sign_date not like", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<String> values) {
            addCriterion("sign_date in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<String> values) {
            addCriterion("sign_date not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(String value1, String value2) {
            addCriterion("sign_date between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(String value1, String value2) {
            addCriterion("sign_date not between", value1, value2, "signDate");
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