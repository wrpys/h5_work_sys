package com.shirokumacafe.archetype.entity;

import java.util.ArrayList;
import java.util.List;

public class AttendAddrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendAddrExample() {
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

        public Criteria andAaIdIsNull() {
            addCriterion("aa_id is null");
            return (Criteria) this;
        }

        public Criteria andAaIdIsNotNull() {
            addCriterion("aa_id is not null");
            return (Criteria) this;
        }

        public Criteria andAaIdEqualTo(Integer value) {
            addCriterion("aa_id =", value, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdNotEqualTo(Integer value) {
            addCriterion("aa_id <>", value, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdGreaterThan(Integer value) {
            addCriterion("aa_id >", value, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("aa_id >=", value, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdLessThan(Integer value) {
            addCriterion("aa_id <", value, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdLessThanOrEqualTo(Integer value) {
            addCriterion("aa_id <=", value, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdIn(List<Integer> values) {
            addCriterion("aa_id in", values, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdNotIn(List<Integer> values) {
            addCriterion("aa_id not in", values, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdBetween(Integer value1, Integer value2) {
            addCriterion("aa_id between", value1, value2, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("aa_id not between", value1, value2, "aaId");
            return (Criteria) this;
        }

        public Criteria andAaNameIsNull() {
            addCriterion("aa_name is null");
            return (Criteria) this;
        }

        public Criteria andAaNameIsNotNull() {
            addCriterion("aa_name is not null");
            return (Criteria) this;
        }

        public Criteria andAaNameEqualTo(String value) {
            addCriterion("aa_name =", value, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameNotEqualTo(String value) {
            addCriterion("aa_name <>", value, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameGreaterThan(String value) {
            addCriterion("aa_name >", value, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameGreaterThanOrEqualTo(String value) {
            addCriterion("aa_name >=", value, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameLessThan(String value) {
            addCriterion("aa_name <", value, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameLessThanOrEqualTo(String value) {
            addCriterion("aa_name <=", value, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameLike(String value) {
            addCriterion("aa_name like", value, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameNotLike(String value) {
            addCriterion("aa_name not like", value, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameIn(List<String> values) {
            addCriterion("aa_name in", values, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameNotIn(List<String> values) {
            addCriterion("aa_name not in", values, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameBetween(String value1, String value2) {
            addCriterion("aa_name between", value1, value2, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaNameNotBetween(String value1, String value2) {
            addCriterion("aa_name not between", value1, value2, "aaName");
            return (Criteria) this;
        }

        public Criteria andAaPidIsNull() {
            addCriterion("aa_pid is null");
            return (Criteria) this;
        }

        public Criteria andAaPidIsNotNull() {
            addCriterion("aa_pid is not null");
            return (Criteria) this;
        }

        public Criteria andAaPidEqualTo(Integer value) {
            addCriterion("aa_pid =", value, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidNotEqualTo(Integer value) {
            addCriterion("aa_pid <>", value, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidGreaterThan(Integer value) {
            addCriterion("aa_pid >", value, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aa_pid >=", value, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidLessThan(Integer value) {
            addCriterion("aa_pid <", value, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidLessThanOrEqualTo(Integer value) {
            addCriterion("aa_pid <=", value, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidIn(List<Integer> values) {
            addCriterion("aa_pid in", values, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidNotIn(List<Integer> values) {
            addCriterion("aa_pid not in", values, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidBetween(Integer value1, Integer value2) {
            addCriterion("aa_pid between", value1, value2, "aaPid");
            return (Criteria) this;
        }

        public Criteria andAaPidNotBetween(Integer value1, Integer value2) {
            addCriterion("aa_pid not between", value1, value2, "aaPid");
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