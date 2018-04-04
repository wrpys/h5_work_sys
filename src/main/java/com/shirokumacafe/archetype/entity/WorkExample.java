package com.shirokumacafe.archetype.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkExample() {
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

        public Criteria andWIdIsNull() {
            addCriterion("w_id is null");
            return (Criteria) this;
        }

        public Criteria andWIdIsNotNull() {
            addCriterion("w_id is not null");
            return (Criteria) this;
        }

        public Criteria andWIdEqualTo(Integer value) {
            addCriterion("w_id =", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotEqualTo(Integer value) {
            addCriterion("w_id <>", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdGreaterThan(Integer value) {
            addCriterion("w_id >", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_id >=", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdLessThan(Integer value) {
            addCriterion("w_id <", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdLessThanOrEqualTo(Integer value) {
            addCriterion("w_id <=", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdIn(List<Integer> values) {
            addCriterion("w_id in", values, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotIn(List<Integer> values) {
            addCriterion("w_id not in", values, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdBetween(Integer value1, Integer value2) {
            addCriterion("w_id between", value1, value2, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotBetween(Integer value1, Integer value2) {
            addCriterion("w_id not between", value1, value2, "wId");
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

        public Criteria andWAddTimeIsNull() {
            addCriterion("w_add_time is null");
            return (Criteria) this;
        }

        public Criteria andWAddTimeIsNotNull() {
            addCriterion("w_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andWAddTimeEqualTo(Date value) {
            addCriterion("w_add_time =", value, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeNotEqualTo(Date value) {
            addCriterion("w_add_time <>", value, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeGreaterThan(Date value) {
            addCriterion("w_add_time >", value, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("w_add_time >=", value, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeLessThan(Date value) {
            addCriterion("w_add_time <", value, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("w_add_time <=", value, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeIn(List<Date> values) {
            addCriterion("w_add_time in", values, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeNotIn(List<Date> values) {
            addCriterion("w_add_time not in", values, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeBetween(Date value1, Date value2) {
            addCriterion("w_add_time between", value1, value2, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("w_add_time not between", value1, value2, "wAddTime");
            return (Criteria) this;
        }

        public Criteria andWDescIsNull() {
            addCriterion("w_desc is null");
            return (Criteria) this;
        }

        public Criteria andWDescIsNotNull() {
            addCriterion("w_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWDescEqualTo(String value) {
            addCriterion("w_desc =", value, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescNotEqualTo(String value) {
            addCriterion("w_desc <>", value, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescGreaterThan(String value) {
            addCriterion("w_desc >", value, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescGreaterThanOrEqualTo(String value) {
            addCriterion("w_desc >=", value, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescLessThan(String value) {
            addCriterion("w_desc <", value, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescLessThanOrEqualTo(String value) {
            addCriterion("w_desc <=", value, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescLike(String value) {
            addCriterion("w_desc like", value, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescNotLike(String value) {
            addCriterion("w_desc not like", value, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescIn(List<String> values) {
            addCriterion("w_desc in", values, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescNotIn(List<String> values) {
            addCriterion("w_desc not in", values, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescBetween(String value1, String value2) {
            addCriterion("w_desc between", value1, value2, "wDesc");
            return (Criteria) this;
        }

        public Criteria andWDescNotBetween(String value1, String value2) {
            addCriterion("w_desc not between", value1, value2, "wDesc");
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