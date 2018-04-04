package com.shirokumacafe.archetype.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseTimeExample() {
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

        public Criteria andCtTimeIsNull() {
            addCriterion("ct_time is null");
            return (Criteria) this;
        }

        public Criteria andCtTimeIsNotNull() {
            addCriterion("ct_time is not null");
            return (Criteria) this;
        }

        public Criteria andCtTimeEqualTo(Date value) {
            addCriterion("ct_time =", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotEqualTo(Date value) {
            addCriterion("ct_time <>", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeGreaterThan(Date value) {
            addCriterion("ct_time >", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ct_time >=", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeLessThan(Date value) {
            addCriterion("ct_time <", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeLessThanOrEqualTo(Date value) {
            addCriterion("ct_time <=", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeIn(List<Date> values) {
            addCriterion("ct_time in", values, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotIn(List<Date> values) {
            addCriterion("ct_time not in", values, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeBetween(Date value1, Date value2) {
            addCriterion("ct_time between", value1, value2, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotBetween(Date value1, Date value2) {
            addCriterion("ct_time not between", value1, value2, "ctTime");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceIsNull() {
            addCriterion("is_attendance is null");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceIsNotNull() {
            addCriterion("is_attendance is not null");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceEqualTo(Integer value) {
            addCriterion("is_attendance =", value, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceNotEqualTo(Integer value) {
            addCriterion("is_attendance <>", value, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceGreaterThan(Integer value) {
            addCriterion("is_attendance >", value, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_attendance >=", value, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceLessThan(Integer value) {
            addCriterion("is_attendance <", value, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceLessThanOrEqualTo(Integer value) {
            addCriterion("is_attendance <=", value, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceIn(List<Integer> values) {
            addCriterion("is_attendance in", values, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceNotIn(List<Integer> values) {
            addCriterion("is_attendance not in", values, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceBetween(Integer value1, Integer value2) {
            addCriterion("is_attendance between", value1, value2, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsAttendanceNotBetween(Integer value1, Integer value2) {
            addCriterion("is_attendance not between", value1, value2, "isAttendance");
            return (Criteria) this;
        }

        public Criteria andIsWorkIsNull() {
            addCriterion("is_work is null");
            return (Criteria) this;
        }

        public Criteria andIsWorkIsNotNull() {
            addCriterion("is_work is not null");
            return (Criteria) this;
        }

        public Criteria andIsWorkEqualTo(Integer value) {
            addCriterion("is_work =", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkNotEqualTo(Integer value) {
            addCriterion("is_work <>", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkGreaterThan(Integer value) {
            addCriterion("is_work >", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_work >=", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkLessThan(Integer value) {
            addCriterion("is_work <", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkLessThanOrEqualTo(Integer value) {
            addCriterion("is_work <=", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkIn(List<Integer> values) {
            addCriterion("is_work in", values, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkNotIn(List<Integer> values) {
            addCriterion("is_work not in", values, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkBetween(Integer value1, Integer value2) {
            addCriterion("is_work between", value1, value2, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkNotBetween(Integer value1, Integer value2) {
            addCriterion("is_work not between", value1, value2, "isWork");
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