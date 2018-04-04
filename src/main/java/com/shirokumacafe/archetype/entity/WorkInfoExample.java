package com.shirokumacafe.archetype.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkInfoExample() {
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

        public Criteria andWiIdIsNull() {
            addCriterion("wi_id is null");
            return (Criteria) this;
        }

        public Criteria andWiIdIsNotNull() {
            addCriterion("wi_id is not null");
            return (Criteria) this;
        }

        public Criteria andWiIdEqualTo(Integer value) {
            addCriterion("wi_id =", value, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdNotEqualTo(Integer value) {
            addCriterion("wi_id <>", value, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdGreaterThan(Integer value) {
            addCriterion("wi_id >", value, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wi_id >=", value, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdLessThan(Integer value) {
            addCriterion("wi_id <", value, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdLessThanOrEqualTo(Integer value) {
            addCriterion("wi_id <=", value, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdIn(List<Integer> values) {
            addCriterion("wi_id in", values, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdNotIn(List<Integer> values) {
            addCriterion("wi_id not in", values, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdBetween(Integer value1, Integer value2) {
            addCriterion("wi_id between", value1, value2, "wiId");
            return (Criteria) this;
        }

        public Criteria andWiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wi_id not between", value1, value2, "wiId");
            return (Criteria) this;
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

        public Criteria andWiAddTimeIsNull() {
            addCriterion("wi_add_time is null");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeIsNotNull() {
            addCriterion("wi_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeEqualTo(Date value) {
            addCriterion("wi_add_time =", value, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeNotEqualTo(Date value) {
            addCriterion("wi_add_time <>", value, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeGreaterThan(Date value) {
            addCriterion("wi_add_time >", value, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wi_add_time >=", value, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeLessThan(Date value) {
            addCriterion("wi_add_time <", value, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("wi_add_time <=", value, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeIn(List<Date> values) {
            addCriterion("wi_add_time in", values, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeNotIn(List<Date> values) {
            addCriterion("wi_add_time not in", values, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeBetween(Date value1, Date value2) {
            addCriterion("wi_add_time between", value1, value2, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("wi_add_time not between", value1, value2, "wiAddTime");
            return (Criteria) this;
        }

        public Criteria andWiFileNameIsNull() {
            addCriterion("wi_file_name is null");
            return (Criteria) this;
        }

        public Criteria andWiFileNameIsNotNull() {
            addCriterion("wi_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andWiFileNameEqualTo(String value) {
            addCriterion("wi_file_name =", value, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameNotEqualTo(String value) {
            addCriterion("wi_file_name <>", value, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameGreaterThan(String value) {
            addCriterion("wi_file_name >", value, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("wi_file_name >=", value, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameLessThan(String value) {
            addCriterion("wi_file_name <", value, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameLessThanOrEqualTo(String value) {
            addCriterion("wi_file_name <=", value, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameLike(String value) {
            addCriterion("wi_file_name like", value, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameNotLike(String value) {
            addCriterion("wi_file_name not like", value, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameIn(List<String> values) {
            addCriterion("wi_file_name in", values, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameNotIn(List<String> values) {
            addCriterion("wi_file_name not in", values, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameBetween(String value1, String value2) {
            addCriterion("wi_file_name between", value1, value2, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileNameNotBetween(String value1, String value2) {
            addCriterion("wi_file_name not between", value1, value2, "wiFileName");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrIsNull() {
            addCriterion("wi_file_addr is null");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrIsNotNull() {
            addCriterion("wi_file_addr is not null");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrEqualTo(String value) {
            addCriterion("wi_file_addr =", value, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrNotEqualTo(String value) {
            addCriterion("wi_file_addr <>", value, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrGreaterThan(String value) {
            addCriterion("wi_file_addr >", value, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrGreaterThanOrEqualTo(String value) {
            addCriterion("wi_file_addr >=", value, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrLessThan(String value) {
            addCriterion("wi_file_addr <", value, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrLessThanOrEqualTo(String value) {
            addCriterion("wi_file_addr <=", value, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrLike(String value) {
            addCriterion("wi_file_addr like", value, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrNotLike(String value) {
            addCriterion("wi_file_addr not like", value, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrIn(List<String> values) {
            addCriterion("wi_file_addr in", values, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrNotIn(List<String> values) {
            addCriterion("wi_file_addr not in", values, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrBetween(String value1, String value2) {
            addCriterion("wi_file_addr between", value1, value2, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileAddrNotBetween(String value1, String value2) {
            addCriterion("wi_file_addr not between", value1, value2, "wiFileAddr");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeIsNull() {
            addCriterion("wi_file_size is null");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeIsNotNull() {
            addCriterion("wi_file_size is not null");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeEqualTo(Integer value) {
            addCriterion("wi_file_size =", value, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeNotEqualTo(Integer value) {
            addCriterion("wi_file_size <>", value, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeGreaterThan(Integer value) {
            addCriterion("wi_file_size >", value, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wi_file_size >=", value, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeLessThan(Integer value) {
            addCriterion("wi_file_size <", value, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeLessThanOrEqualTo(Integer value) {
            addCriterion("wi_file_size <=", value, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeIn(List<Integer> values) {
            addCriterion("wi_file_size in", values, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeNotIn(List<Integer> values) {
            addCriterion("wi_file_size not in", values, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeBetween(Integer value1, Integer value2) {
            addCriterion("wi_file_size between", value1, value2, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWiFileSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("wi_file_size not between", value1, value2, "wiFileSize");
            return (Criteria) this;
        }

        public Criteria andWIDescIsNull() {
            addCriterion("w_i_desc is null");
            return (Criteria) this;
        }

        public Criteria andWIDescIsNotNull() {
            addCriterion("w_i_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWIDescEqualTo(String value) {
            addCriterion("w_i_desc =", value, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescNotEqualTo(String value) {
            addCriterion("w_i_desc <>", value, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescGreaterThan(String value) {
            addCriterion("w_i_desc >", value, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescGreaterThanOrEqualTo(String value) {
            addCriterion("w_i_desc >=", value, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescLessThan(String value) {
            addCriterion("w_i_desc <", value, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescLessThanOrEqualTo(String value) {
            addCriterion("w_i_desc <=", value, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescLike(String value) {
            addCriterion("w_i_desc like", value, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescNotLike(String value) {
            addCriterion("w_i_desc not like", value, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescIn(List<String> values) {
            addCriterion("w_i_desc in", values, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescNotIn(List<String> values) {
            addCriterion("w_i_desc not in", values, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescBetween(String value1, String value2) {
            addCriterion("w_i_desc between", value1, value2, "wIDesc");
            return (Criteria) this;
        }

        public Criteria andWIDescNotBetween(String value1, String value2) {
            addCriterion("w_i_desc not between", value1, value2, "wIDesc");
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