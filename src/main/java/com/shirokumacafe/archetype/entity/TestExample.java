package com.shirokumacafe.archetype.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestExample() {
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

        public Criteria andTestIdIsNull() {
            addCriterion("test_id is null");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNotNull() {
            addCriterion("test_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestIdEqualTo(Integer value) {
            addCriterion("test_id =", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotEqualTo(Integer value) {
            addCriterion("test_id <>", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThan(Integer value) {
            addCriterion("test_id >", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_id >=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThan(Integer value) {
            addCriterion("test_id <", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_id <=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdIn(List<Integer> values) {
            addCriterion("test_id in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotIn(List<Integer> values) {
            addCriterion("test_id not in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdBetween(Integer value1, Integer value2) {
            addCriterion("test_id between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_id not between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestTitleIsNull() {
            addCriterion("test_title is null");
            return (Criteria) this;
        }

        public Criteria andTestTitleIsNotNull() {
            addCriterion("test_title is not null");
            return (Criteria) this;
        }

        public Criteria andTestTitleEqualTo(String value) {
            addCriterion("test_title =", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleNotEqualTo(String value) {
            addCriterion("test_title <>", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleGreaterThan(String value) {
            addCriterion("test_title >", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleGreaterThanOrEqualTo(String value) {
            addCriterion("test_title >=", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleLessThan(String value) {
            addCriterion("test_title <", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleLessThanOrEqualTo(String value) {
            addCriterion("test_title <=", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleLike(String value) {
            addCriterion("test_title like", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleNotLike(String value) {
            addCriterion("test_title not like", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleIn(List<String> values) {
            addCriterion("test_title in", values, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleNotIn(List<String> values) {
            addCriterion("test_title not in", values, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleBetween(String value1, String value2) {
            addCriterion("test_title between", value1, value2, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleNotBetween(String value1, String value2) {
            addCriterion("test_title not between", value1, value2, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestOptionAIsNull() {
            addCriterion("test_option_a is null");
            return (Criteria) this;
        }

        public Criteria andTestOptionAIsNotNull() {
            addCriterion("test_option_a is not null");
            return (Criteria) this;
        }

        public Criteria andTestOptionAEqualTo(String value) {
            addCriterion("test_option_a =", value, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionANotEqualTo(String value) {
            addCriterion("test_option_a <>", value, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionAGreaterThan(String value) {
            addCriterion("test_option_a >", value, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionAGreaterThanOrEqualTo(String value) {
            addCriterion("test_option_a >=", value, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionALessThan(String value) {
            addCriterion("test_option_a <", value, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionALessThanOrEqualTo(String value) {
            addCriterion("test_option_a <=", value, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionALike(String value) {
            addCriterion("test_option_a like", value, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionANotLike(String value) {
            addCriterion("test_option_a not like", value, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionAIn(List<String> values) {
            addCriterion("test_option_a in", values, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionANotIn(List<String> values) {
            addCriterion("test_option_a not in", values, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionABetween(String value1, String value2) {
            addCriterion("test_option_a between", value1, value2, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionANotBetween(String value1, String value2) {
            addCriterion("test_option_a not between", value1, value2, "testOptionA");
            return (Criteria) this;
        }

        public Criteria andTestOptionBIsNull() {
            addCriterion("test_option_b is null");
            return (Criteria) this;
        }

        public Criteria andTestOptionBIsNotNull() {
            addCriterion("test_option_b is not null");
            return (Criteria) this;
        }

        public Criteria andTestOptionBEqualTo(String value) {
            addCriterion("test_option_b =", value, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBNotEqualTo(String value) {
            addCriterion("test_option_b <>", value, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBGreaterThan(String value) {
            addCriterion("test_option_b >", value, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBGreaterThanOrEqualTo(String value) {
            addCriterion("test_option_b >=", value, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBLessThan(String value) {
            addCriterion("test_option_b <", value, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBLessThanOrEqualTo(String value) {
            addCriterion("test_option_b <=", value, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBLike(String value) {
            addCriterion("test_option_b like", value, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBNotLike(String value) {
            addCriterion("test_option_b not like", value, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBIn(List<String> values) {
            addCriterion("test_option_b in", values, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBNotIn(List<String> values) {
            addCriterion("test_option_b not in", values, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBBetween(String value1, String value2) {
            addCriterion("test_option_b between", value1, value2, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionBNotBetween(String value1, String value2) {
            addCriterion("test_option_b not between", value1, value2, "testOptionB");
            return (Criteria) this;
        }

        public Criteria andTestOptionCIsNull() {
            addCriterion("test_option_c is null");
            return (Criteria) this;
        }

        public Criteria andTestOptionCIsNotNull() {
            addCriterion("test_option_c is not null");
            return (Criteria) this;
        }

        public Criteria andTestOptionCEqualTo(String value) {
            addCriterion("test_option_c =", value, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCNotEqualTo(String value) {
            addCriterion("test_option_c <>", value, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCGreaterThan(String value) {
            addCriterion("test_option_c >", value, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCGreaterThanOrEqualTo(String value) {
            addCriterion("test_option_c >=", value, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCLessThan(String value) {
            addCriterion("test_option_c <", value, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCLessThanOrEqualTo(String value) {
            addCriterion("test_option_c <=", value, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCLike(String value) {
            addCriterion("test_option_c like", value, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCNotLike(String value) {
            addCriterion("test_option_c not like", value, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCIn(List<String> values) {
            addCriterion("test_option_c in", values, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCNotIn(List<String> values) {
            addCriterion("test_option_c not in", values, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCBetween(String value1, String value2) {
            addCriterion("test_option_c between", value1, value2, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionCNotBetween(String value1, String value2) {
            addCriterion("test_option_c not between", value1, value2, "testOptionC");
            return (Criteria) this;
        }

        public Criteria andTestOptionDIsNull() {
            addCriterion("test_option_d is null");
            return (Criteria) this;
        }

        public Criteria andTestOptionDIsNotNull() {
            addCriterion("test_option_d is not null");
            return (Criteria) this;
        }

        public Criteria andTestOptionDEqualTo(String value) {
            addCriterion("test_option_d =", value, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDNotEqualTo(String value) {
            addCriterion("test_option_d <>", value, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDGreaterThan(String value) {
            addCriterion("test_option_d >", value, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDGreaterThanOrEqualTo(String value) {
            addCriterion("test_option_d >=", value, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDLessThan(String value) {
            addCriterion("test_option_d <", value, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDLessThanOrEqualTo(String value) {
            addCriterion("test_option_d <=", value, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDLike(String value) {
            addCriterion("test_option_d like", value, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDNotLike(String value) {
            addCriterion("test_option_d not like", value, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDIn(List<String> values) {
            addCriterion("test_option_d in", values, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDNotIn(List<String> values) {
            addCriterion("test_option_d not in", values, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDBetween(String value1, String value2) {
            addCriterion("test_option_d between", value1, value2, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestOptionDNotBetween(String value1, String value2) {
            addCriterion("test_option_d not between", value1, value2, "testOptionD");
            return (Criteria) this;
        }

        public Criteria andTestAnswerIsNull() {
            addCriterion("test_answer is null");
            return (Criteria) this;
        }

        public Criteria andTestAnswerIsNotNull() {
            addCriterion("test_answer is not null");
            return (Criteria) this;
        }

        public Criteria andTestAnswerEqualTo(Integer value) {
            addCriterion("test_answer =", value, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerNotEqualTo(Integer value) {
            addCriterion("test_answer <>", value, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerGreaterThan(Integer value) {
            addCriterion("test_answer >", value, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_answer >=", value, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerLessThan(Integer value) {
            addCriterion("test_answer <", value, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerLessThanOrEqualTo(Integer value) {
            addCriterion("test_answer <=", value, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerIn(List<Integer> values) {
            addCriterion("test_answer in", values, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerNotIn(List<Integer> values) {
            addCriterion("test_answer not in", values, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerBetween(Integer value1, Integer value2) {
            addCriterion("test_answer between", value1, value2, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andTestAnswerNotBetween(Integer value1, Integer value2) {
            addCriterion("test_answer not between", value1, value2, "testAnswer");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
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