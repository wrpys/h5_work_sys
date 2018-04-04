package com.shirokumacafe.archetype.entity;

import java.util.ArrayList;
import java.util.List;

public class CourseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseInfoExample() {
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

        public Criteria andCiIdIsNull() {
            addCriterion("ci_id is null");
            return (Criteria) this;
        }

        public Criteria andCiIdIsNotNull() {
            addCriterion("ci_id is not null");
            return (Criteria) this;
        }

        public Criteria andCiIdEqualTo(Integer value) {
            addCriterion("ci_id =", value, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdNotEqualTo(Integer value) {
            addCriterion("ci_id <>", value, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdGreaterThan(Integer value) {
            addCriterion("ci_id >", value, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ci_id >=", value, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdLessThan(Integer value) {
            addCriterion("ci_id <", value, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdLessThanOrEqualTo(Integer value) {
            addCriterion("ci_id <=", value, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdIn(List<Integer> values) {
            addCriterion("ci_id in", values, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdNotIn(List<Integer> values) {
            addCriterion("ci_id not in", values, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdBetween(Integer value1, Integer value2) {
            addCriterion("ci_id between", value1, value2, "ciId");
            return (Criteria) this;
        }

        public Criteria andCiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ci_id not between", value1, value2, "ciId");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCtIdIsNull() {
            addCriterion("ct_id is null");
            return (Criteria) this;
        }

        public Criteria andCtIdIsNotNull() {
            addCriterion("ct_id is not null");
            return (Criteria) this;
        }

        public Criteria andCtIdEqualTo(Integer value) {
            addCriterion("ct_id =", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotEqualTo(Integer value) {
            addCriterion("ct_id <>", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdGreaterThan(Integer value) {
            addCriterion("ct_id >", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ct_id >=", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLessThan(Integer value) {
            addCriterion("ct_id <", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLessThanOrEqualTo(Integer value) {
            addCriterion("ct_id <=", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdIn(List<Integer> values) {
            addCriterion("ct_id in", values, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotIn(List<Integer> values) {
            addCriterion("ct_id not in", values, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdBetween(Integer value1, Integer value2) {
            addCriterion("ct_id between", value1, value2, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ct_id not between", value1, value2, "ctId");
            return (Criteria) this;
        }

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoIsNull() {
            addCriterion("attendance_info is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoIsNotNull() {
            addCriterion("attendance_info is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoEqualTo(Integer value) {
            addCriterion("attendance_info =", value, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoNotEqualTo(Integer value) {
            addCriterion("attendance_info <>", value, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoGreaterThan(Integer value) {
            addCriterion("attendance_info >", value, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendance_info >=", value, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoLessThan(Integer value) {
            addCriterion("attendance_info <", value, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoLessThanOrEqualTo(Integer value) {
            addCriterion("attendance_info <=", value, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoIn(List<Integer> values) {
            addCriterion("attendance_info in", values, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoNotIn(List<Integer> values) {
            addCriterion("attendance_info not in", values, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoBetween(Integer value1, Integer value2) {
            addCriterion("attendance_info between", value1, value2, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andAttendanceInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("attendance_info not between", value1, value2, "attendanceInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoIsNull() {
            addCriterion("work_info is null");
            return (Criteria) this;
        }

        public Criteria andWorkInfoIsNotNull() {
            addCriterion("work_info is not null");
            return (Criteria) this;
        }

        public Criteria andWorkInfoEqualTo(Integer value) {
            addCriterion("work_info =", value, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoNotEqualTo(Integer value) {
            addCriterion("work_info <>", value, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoGreaterThan(Integer value) {
            addCriterion("work_info >", value, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_info >=", value, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoLessThan(Integer value) {
            addCriterion("work_info <", value, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoLessThanOrEqualTo(Integer value) {
            addCriterion("work_info <=", value, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoIn(List<Integer> values) {
            addCriterion("work_info in", values, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoNotIn(List<Integer> values) {
            addCriterion("work_info not in", values, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoBetween(Integer value1, Integer value2) {
            addCriterion("work_info between", value1, value2, "workInfo");
            return (Criteria) this;
        }

        public Criteria andWorkInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("work_info not between", value1, value2, "workInfo");
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