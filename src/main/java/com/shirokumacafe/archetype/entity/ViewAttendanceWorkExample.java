package com.shirokumacafe.archetype.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewAttendanceWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewAttendanceWorkExample() {
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

        public Criteria andAttendanceIsNull() {
            addCriterion("attendance is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceIsNotNull() {
            addCriterion("attendance is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceEqualTo(Integer value) {
            addCriterion("attendance =", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotEqualTo(Integer value) {
            addCriterion("attendance <>", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceGreaterThan(Integer value) {
            addCriterion("attendance >", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendance >=", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLessThan(Integer value) {
            addCriterion("attendance <", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLessThanOrEqualTo(Integer value) {
            addCriterion("attendance <=", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceIn(List<Integer> values) {
            addCriterion("attendance in", values, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotIn(List<Integer> values) {
            addCriterion("attendance not in", values, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceBetween(Integer value1, Integer value2) {
            addCriterion("attendance between", value1, value2, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotBetween(Integer value1, Integer value2) {
            addCriterion("attendance not between", value1, value2, "attendance");
            return (Criteria) this;
        }

        public Criteria andWorkIsNull() {
            addCriterion("work is null");
            return (Criteria) this;
        }

        public Criteria andWorkIsNotNull() {
            addCriterion("work is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEqualTo(Integer value) {
            addCriterion("work =", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotEqualTo(Integer value) {
            addCriterion("work <>", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkGreaterThan(Integer value) {
            addCriterion("work >", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkGreaterThanOrEqualTo(Integer value) {
            addCriterion("work >=", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLessThan(Integer value) {
            addCriterion("work <", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLessThanOrEqualTo(Integer value) {
            addCriterion("work <=", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkIn(List<Integer> values) {
            addCriterion("work in", values, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotIn(List<Integer> values) {
            addCriterion("work not in", values, "work");
            return (Criteria) this;
        }

        public Criteria andWorkBetween(Integer value1, Integer value2) {
            addCriterion("work between", value1, value2, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotBetween(Integer value1, Integer value2) {
            addCriterion("work not between", value1, value2, "work");
            return (Criteria) this;
        }

        public Criteria andSNoIsNull() {
            addCriterion("s_no is null");
            return (Criteria) this;
        }

        public Criteria andSNoIsNotNull() {
            addCriterion("s_no is not null");
            return (Criteria) this;
        }

        public Criteria andSNoEqualTo(String value) {
            addCriterion("s_no =", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoNotEqualTo(String value) {
            addCriterion("s_no <>", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoGreaterThan(String value) {
            addCriterion("s_no >", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoGreaterThanOrEqualTo(String value) {
            addCriterion("s_no >=", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoLessThan(String value) {
            addCriterion("s_no <", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoLessThanOrEqualTo(String value) {
            addCriterion("s_no <=", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoLike(String value) {
            addCriterion("s_no like", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoNotLike(String value) {
            addCriterion("s_no not like", value, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoIn(List<String> values) {
            addCriterion("s_no in", values, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoNotIn(List<String> values) {
            addCriterion("s_no not in", values, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoBetween(String value1, String value2) {
            addCriterion("s_no between", value1, value2, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNoNotBetween(String value1, String value2) {
            addCriterion("s_no not between", value1, value2, "sNo");
            return (Criteria) this;
        }

        public Criteria andSNameIsNull() {
            addCriterion("s_name is null");
            return (Criteria) this;
        }

        public Criteria andSNameIsNotNull() {
            addCriterion("s_name is not null");
            return (Criteria) this;
        }

        public Criteria andSNameEqualTo(String value) {
            addCriterion("s_name =", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotEqualTo(String value) {
            addCriterion("s_name <>", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThan(String value) {
            addCriterion("s_name >", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThanOrEqualTo(String value) {
            addCriterion("s_name >=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThan(String value) {
            addCriterion("s_name <", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThanOrEqualTo(String value) {
            addCriterion("s_name <=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLike(String value) {
            addCriterion("s_name like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotLike(String value) {
            addCriterion("s_name not like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameIn(List<String> values) {
            addCriterion("s_name in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotIn(List<String> values) {
            addCriterion("s_name not in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameBetween(String value1, String value2) {
            addCriterion("s_name between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotBetween(String value1, String value2) {
            addCriterion("s_name not between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeIsNull() {
            addCriterion("c_attend_time is null");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeIsNotNull() {
            addCriterion("c_attend_time is not null");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeEqualTo(Date value) {
            addCriterion("c_attend_time =", value, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeNotEqualTo(Date value) {
            addCriterion("c_attend_time <>", value, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeGreaterThan(Date value) {
            addCriterion("c_attend_time >", value, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_attend_time >=", value, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeLessThan(Date value) {
            addCriterion("c_attend_time <", value, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeLessThanOrEqualTo(Date value) {
            addCriterion("c_attend_time <=", value, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeIn(List<Date> values) {
            addCriterion("c_attend_time in", values, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeNotIn(List<Date> values) {
            addCriterion("c_attend_time not in", values, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeBetween(Date value1, Date value2) {
            addCriterion("c_attend_time between", value1, value2, "cAttendTime");
            return (Criteria) this;
        }

        public Criteria andCAttendTimeNotBetween(Date value1, Date value2) {
            addCriterion("c_attend_time not between", value1, value2, "cAttendTime");
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