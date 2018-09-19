package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class PrjEndExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrjEndExample() {
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

        public Criteria andPelIdIsNull() {
            addCriterion("pel_id is null");
            return (Criteria) this;
        }

        public Criteria andPelIdIsNotNull() {
            addCriterion("pel_id is not null");
            return (Criteria) this;
        }

        public Criteria andPelIdEqualTo(String value) {
            addCriterion("pel_id =", value, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdNotEqualTo(String value) {
            addCriterion("pel_id <>", value, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdGreaterThan(String value) {
            addCriterion("pel_id >", value, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdGreaterThanOrEqualTo(String value) {
            addCriterion("pel_id >=", value, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdLessThan(String value) {
            addCriterion("pel_id <", value, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdLessThanOrEqualTo(String value) {
            addCriterion("pel_id <=", value, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdLike(String value) {
            addCriterion("pel_id like", value, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdNotLike(String value) {
            addCriterion("pel_id not like", value, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdIn(List<String> values) {
            addCriterion("pel_id in", values, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdNotIn(List<String> values) {
            addCriterion("pel_id not in", values, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdBetween(String value1, String value2) {
            addCriterion("pel_id between", value1, value2, "pelId");
            return (Criteria) this;
        }

        public Criteria andPelIdNotBetween(String value1, String value2) {
            addCriterion("pel_id not between", value1, value2, "pelId");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeIsNull() {
            addCriterion("task_list_code is null");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeIsNotNull() {
            addCriterion("task_list_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeEqualTo(String value) {
            addCriterion("task_list_code =", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeNotEqualTo(String value) {
            addCriterion("task_list_code <>", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeGreaterThan(String value) {
            addCriterion("task_list_code >", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeGreaterThanOrEqualTo(String value) {
            addCriterion("task_list_code >=", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeLessThan(String value) {
            addCriterion("task_list_code <", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeLessThanOrEqualTo(String value) {
            addCriterion("task_list_code <=", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeLike(String value) {
            addCriterion("task_list_code like", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeNotLike(String value) {
            addCriterion("task_list_code not like", value, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeIn(List<String> values) {
            addCriterion("task_list_code in", values, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeNotIn(List<String> values) {
            addCriterion("task_list_code not in", values, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeBetween(String value1, String value2) {
            addCriterion("task_list_code between", value1, value2, "taskListCode");
            return (Criteria) this;
        }

        public Criteria andTaskListCodeNotBetween(String value1, String value2) {
            addCriterion("task_list_code not between", value1, value2, "taskListCode");
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

        public Criteria andEndTypeIsNull() {
            addCriterion("end_type is null");
            return (Criteria) this;
        }

        public Criteria andEndTypeIsNotNull() {
            addCriterion("end_type is not null");
            return (Criteria) this;
        }

        public Criteria andEndTypeEqualTo(String value) {
            addCriterion("end_type =", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeNotEqualTo(String value) {
            addCriterion("end_type <>", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeGreaterThan(String value) {
            addCriterion("end_type >", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeGreaterThanOrEqualTo(String value) {
            addCriterion("end_type >=", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeLessThan(String value) {
            addCriterion("end_type <", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeLessThanOrEqualTo(String value) {
            addCriterion("end_type <=", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeLike(String value) {
            addCriterion("end_type like", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeNotLike(String value) {
            addCriterion("end_type not like", value, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeIn(List<String> values) {
            addCriterion("end_type in", values, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeNotIn(List<String> values) {
            addCriterion("end_type not in", values, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeBetween(String value1, String value2) {
            addCriterion("end_type between", value1, value2, "endType");
            return (Criteria) this;
        }

        public Criteria andEndTypeNotBetween(String value1, String value2) {
            addCriterion("end_type not between", value1, value2, "endType");
            return (Criteria) this;
        }

        public Criteria andPelTimeIsNull() {
            addCriterion("pel_time is null");
            return (Criteria) this;
        }

        public Criteria andPelTimeIsNotNull() {
            addCriterion("pel_time is not null");
            return (Criteria) this;
        }

        public Criteria andPelTimeEqualTo(String value) {
            addCriterion("pel_time =", value, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeNotEqualTo(String value) {
            addCriterion("pel_time <>", value, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeGreaterThan(String value) {
            addCriterion("pel_time >", value, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pel_time >=", value, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeLessThan(String value) {
            addCriterion("pel_time <", value, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeLessThanOrEqualTo(String value) {
            addCriterion("pel_time <=", value, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeLike(String value) {
            addCriterion("pel_time like", value, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeNotLike(String value) {
            addCriterion("pel_time not like", value, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeIn(List<String> values) {
            addCriterion("pel_time in", values, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeNotIn(List<String> values) {
            addCriterion("pel_time not in", values, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeBetween(String value1, String value2) {
            addCriterion("pel_time between", value1, value2, "pelTime");
            return (Criteria) this;
        }

        public Criteria andPelTimeNotBetween(String value1, String value2) {
            addCriterion("pel_time not between", value1, value2, "pelTime");
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

        public Criteria andOtherfilePathIsNull() {
            addCriterion("otherfile_path is null");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathIsNotNull() {
            addCriterion("otherfile_path is not null");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathEqualTo(String value) {
            addCriterion("otherfile_path =", value, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathNotEqualTo(String value) {
            addCriterion("otherfile_path <>", value, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathGreaterThan(String value) {
            addCriterion("otherfile_path >", value, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathGreaterThanOrEqualTo(String value) {
            addCriterion("otherfile_path >=", value, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathLessThan(String value) {
            addCriterion("otherfile_path <", value, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathLessThanOrEqualTo(String value) {
            addCriterion("otherfile_path <=", value, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathLike(String value) {
            addCriterion("otherfile_path like", value, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathNotLike(String value) {
            addCriterion("otherfile_path not like", value, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathIn(List<String> values) {
            addCriterion("otherfile_path in", values, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathNotIn(List<String> values) {
            addCriterion("otherfile_path not in", values, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathBetween(String value1, String value2) {
            addCriterion("otherfile_path between", value1, value2, "otherfilePath");
            return (Criteria) this;
        }

        public Criteria andOtherfilePathNotBetween(String value1, String value2) {
            addCriterion("otherfile_path not between", value1, value2, "otherfilePath");
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