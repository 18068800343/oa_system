package org.ldxx.bean;

import java.util.ArrayList;
import java.util.List;

public class PrjStaffAttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrjStaffAttendanceExample() {
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

        public Criteria andPsaIdIsNull() {
            addCriterion("psa_id is null");
            return (Criteria) this;
        }

        public Criteria andPsaIdIsNotNull() {
            addCriterion("psa_id is not null");
            return (Criteria) this;
        }

        public Criteria andPsaIdEqualTo(String value) {
            addCriterion("psa_id =", value, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdNotEqualTo(String value) {
            addCriterion("psa_id <>", value, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdGreaterThan(String value) {
            addCriterion("psa_id >", value, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdGreaterThanOrEqualTo(String value) {
            addCriterion("psa_id >=", value, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdLessThan(String value) {
            addCriterion("psa_id <", value, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdLessThanOrEqualTo(String value) {
            addCriterion("psa_id <=", value, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdLike(String value) {
            addCriterion("psa_id like", value, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdNotLike(String value) {
            addCriterion("psa_id not like", value, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdIn(List<String> values) {
            addCriterion("psa_id in", values, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdNotIn(List<String> values) {
            addCriterion("psa_id not in", values, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdBetween(String value1, String value2) {
            addCriterion("psa_id between", value1, value2, "psaId");
            return (Criteria) this;
        }

        public Criteria andPsaIdNotBetween(String value1, String value2) {
            addCriterion("psa_id not between", value1, value2, "psaId");
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

        public Criteria andAttendanceMonthIsNull() {
            addCriterion("attendance_month is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthIsNotNull() {
            addCriterion("attendance_month is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthEqualTo(String value) {
            addCriterion("attendance_month =", value, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthNotEqualTo(String value) {
            addCriterion("attendance_month <>", value, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthGreaterThan(String value) {
            addCriterion("attendance_month >", value, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_month >=", value, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthLessThan(String value) {
            addCriterion("attendance_month <", value, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthLessThanOrEqualTo(String value) {
            addCriterion("attendance_month <=", value, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthLike(String value) {
            addCriterion("attendance_month like", value, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthNotLike(String value) {
            addCriterion("attendance_month not like", value, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthIn(List<String> values) {
            addCriterion("attendance_month in", values, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthNotIn(List<String> values) {
            addCriterion("attendance_month not in", values, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthBetween(String value1, String value2) {
            addCriterion("attendance_month between", value1, value2, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andAttendanceMonthNotBetween(String value1, String value2) {
            addCriterion("attendance_month not between", value1, value2, "attendanceMonth");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonDoingIsNull() {
            addCriterion("person_doing is null");
            return (Criteria) this;
        }

        public Criteria andPersonDoingIsNotNull() {
            addCriterion("person_doing is not null");
            return (Criteria) this;
        }

        public Criteria andPersonDoingEqualTo(String value) {
            addCriterion("person_doing =", value, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingNotEqualTo(String value) {
            addCriterion("person_doing <>", value, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingGreaterThan(String value) {
            addCriterion("person_doing >", value, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingGreaterThanOrEqualTo(String value) {
            addCriterion("person_doing >=", value, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingLessThan(String value) {
            addCriterion("person_doing <", value, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingLessThanOrEqualTo(String value) {
            addCriterion("person_doing <=", value, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingLike(String value) {
            addCriterion("person_doing like", value, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingNotLike(String value) {
            addCriterion("person_doing not like", value, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingIn(List<String> values) {
            addCriterion("person_doing in", values, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingNotIn(List<String> values) {
            addCriterion("person_doing not in", values, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingBetween(String value1, String value2) {
            addCriterion("person_doing between", value1, value2, "personDoing");
            return (Criteria) this;
        }

        public Criteria andPersonDoingNotBetween(String value1, String value2) {
            addCriterion("person_doing not between", value1, value2, "personDoing");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextIsNull() {
            addCriterion("attendance_probably_text is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextIsNotNull() {
            addCriterion("attendance_probably_text is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextEqualTo(String value) {
            addCriterion("attendance_probably_text =", value, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextNotEqualTo(String value) {
            addCriterion("attendance_probably_text <>", value, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextGreaterThan(String value) {
            addCriterion("attendance_probably_text >", value, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_probably_text >=", value, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextLessThan(String value) {
            addCriterion("attendance_probably_text <", value, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextLessThanOrEqualTo(String value) {
            addCriterion("attendance_probably_text <=", value, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextLike(String value) {
            addCriterion("attendance_probably_text like", value, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextNotLike(String value) {
            addCriterion("attendance_probably_text not like", value, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextIn(List<String> values) {
            addCriterion("attendance_probably_text in", values, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextNotIn(List<String> values) {
            addCriterion("attendance_probably_text not in", values, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextBetween(String value1, String value2) {
            addCriterion("attendance_probably_text between", value1, value2, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAttendanceProbablyTextNotBetween(String value1, String value2) {
            addCriterion("attendance_probably_text not between", value1, value2, "attendanceProbablyText");
            return (Criteria) this;
        }

        public Criteria andAptSignNameIsNull() {
            addCriterion("apt_sign_name is null");
            return (Criteria) this;
        }

        public Criteria andAptSignNameIsNotNull() {
            addCriterion("apt_sign_name is not null");
            return (Criteria) this;
        }

        public Criteria andAptSignNameEqualTo(String value) {
            addCriterion("apt_sign_name =", value, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameNotEqualTo(String value) {
            addCriterion("apt_sign_name <>", value, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameGreaterThan(String value) {
            addCriterion("apt_sign_name >", value, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameGreaterThanOrEqualTo(String value) {
            addCriterion("apt_sign_name >=", value, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameLessThan(String value) {
            addCriterion("apt_sign_name <", value, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameLessThanOrEqualTo(String value) {
            addCriterion("apt_sign_name <=", value, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameLike(String value) {
            addCriterion("apt_sign_name like", value, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameNotLike(String value) {
            addCriterion("apt_sign_name not like", value, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameIn(List<String> values) {
            addCriterion("apt_sign_name in", values, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameNotIn(List<String> values) {
            addCriterion("apt_sign_name not in", values, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameBetween(String value1, String value2) {
            addCriterion("apt_sign_name between", value1, value2, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignNameNotBetween(String value1, String value2) {
            addCriterion("apt_sign_name not between", value1, value2, "aptSignName");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeIsNull() {
            addCriterion("apt_sign_time is null");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeIsNotNull() {
            addCriterion("apt_sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeEqualTo(String value) {
            addCriterion("apt_sign_time =", value, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeNotEqualTo(String value) {
            addCriterion("apt_sign_time <>", value, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeGreaterThan(String value) {
            addCriterion("apt_sign_time >", value, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeGreaterThanOrEqualTo(String value) {
            addCriterion("apt_sign_time >=", value, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeLessThan(String value) {
            addCriterion("apt_sign_time <", value, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeLessThanOrEqualTo(String value) {
            addCriterion("apt_sign_time <=", value, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeLike(String value) {
            addCriterion("apt_sign_time like", value, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeNotLike(String value) {
            addCriterion("apt_sign_time not like", value, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeIn(List<String> values) {
            addCriterion("apt_sign_time in", values, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeNotIn(List<String> values) {
            addCriterion("apt_sign_time not in", values, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeBetween(String value1, String value2) {
            addCriterion("apt_sign_time between", value1, value2, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAptSignTimeNotBetween(String value1, String value2) {
            addCriterion("apt_sign_time not between", value1, value2, "aptSignTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameIsNull() {
            addCriterion("attendance_other_file_name is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameIsNotNull() {
            addCriterion("attendance_other_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameEqualTo(String value) {
            addCriterion("attendance_other_file_name =", value, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameNotEqualTo(String value) {
            addCriterion("attendance_other_file_name <>", value, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameGreaterThan(String value) {
            addCriterion("attendance_other_file_name >", value, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_other_file_name >=", value, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameLessThan(String value) {
            addCriterion("attendance_other_file_name <", value, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameLessThanOrEqualTo(String value) {
            addCriterion("attendance_other_file_name <=", value, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameLike(String value) {
            addCriterion("attendance_other_file_name like", value, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameNotLike(String value) {
            addCriterion("attendance_other_file_name not like", value, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameIn(List<String> values) {
            addCriterion("attendance_other_file_name in", values, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameNotIn(List<String> values) {
            addCriterion("attendance_other_file_name not in", values, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameBetween(String value1, String value2) {
            addCriterion("attendance_other_file_name between", value1, value2, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileNameNotBetween(String value1, String value2) {
            addCriterion("attendance_other_file_name not between", value1, value2, "attendanceOtherFileName");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathIsNull() {
            addCriterion("attendance_other_file_path is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathIsNotNull() {
            addCriterion("attendance_other_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathEqualTo(String value) {
            addCriterion("attendance_other_file_path =", value, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathNotEqualTo(String value) {
            addCriterion("attendance_other_file_path <>", value, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathGreaterThan(String value) {
            addCriterion("attendance_other_file_path >", value, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_other_file_path >=", value, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathLessThan(String value) {
            addCriterion("attendance_other_file_path <", value, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathLessThanOrEqualTo(String value) {
            addCriterion("attendance_other_file_path <=", value, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathLike(String value) {
            addCriterion("attendance_other_file_path like", value, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathNotLike(String value) {
            addCriterion("attendance_other_file_path not like", value, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathIn(List<String> values) {
            addCriterion("attendance_other_file_path in", values, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathNotIn(List<String> values) {
            addCriterion("attendance_other_file_path not in", values, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathBetween(String value1, String value2) {
            addCriterion("attendance_other_file_path between", value1, value2, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFilePathNotBetween(String value1, String value2) {
            addCriterion("attendance_other_file_path not between", value1, value2, "attendanceOtherFilePath");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeIsNull() {
            addCriterion("attendance_other_file_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeIsNotNull() {
            addCriterion("attendance_other_file_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeEqualTo(String value) {
            addCriterion("attendance_other_file_time =", value, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeNotEqualTo(String value) {
            addCriterion("attendance_other_file_time <>", value, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeGreaterThan(String value) {
            addCriterion("attendance_other_file_time >", value, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_other_file_time >=", value, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeLessThan(String value) {
            addCriterion("attendance_other_file_time <", value, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeLessThanOrEqualTo(String value) {
            addCriterion("attendance_other_file_time <=", value, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeLike(String value) {
            addCriterion("attendance_other_file_time like", value, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeNotLike(String value) {
            addCriterion("attendance_other_file_time not like", value, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeIn(List<String> values) {
            addCriterion("attendance_other_file_time in", values, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeNotIn(List<String> values) {
            addCriterion("attendance_other_file_time not in", values, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeBetween(String value1, String value2) {
            addCriterion("attendance_other_file_time between", value1, value2, "attendanceOtherFileTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceOtherFileTimeNotBetween(String value1, String value2) {
            addCriterion("attendance_other_file_time not between", value1, value2, "attendanceOtherFileTime");
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