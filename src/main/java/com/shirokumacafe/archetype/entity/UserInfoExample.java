package com.shirokumacafe.archetype.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUserInfoIdIsNull() {
            addCriterion("user_info_id is null");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdIsNotNull() {
            addCriterion("user_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdEqualTo(Integer value) {
            addCriterion("user_info_id =", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotEqualTo(Integer value) {
            addCriterion("user_info_id <>", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdGreaterThan(Integer value) {
            addCriterion("user_info_id >", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_info_id >=", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdLessThan(Integer value) {
            addCriterion("user_info_id <", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_info_id <=", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdIn(List<Integer> values) {
            addCriterion("user_info_id in", values, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotIn(List<Integer> values) {
            addCriterion("user_info_id not in", values, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("user_info_id between", value1, value2, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_info_id not between", value1, value2, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNull() {
            addCriterion("user_code is null");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNotNull() {
            addCriterion("user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserCodeEqualTo(String value) {
            addCriterion("user_code =", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotEqualTo(String value) {
            addCriterion("user_code <>", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThan(String value) {
            addCriterion("user_code >", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_code >=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThan(String value) {
            addCriterion("user_code <", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("user_code <=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLike(String value) {
            addCriterion("user_code like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotLike(String value) {
            addCriterion("user_code not like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeIn(List<String> values) {
            addCriterion("user_code in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotIn(List<String> values) {
            addCriterion("user_code not in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeBetween(String value1, String value2) {
            addCriterion("user_code between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("user_code not between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserDeptIsNull() {
            addCriterion("user_dept is null");
            return (Criteria) this;
        }

        public Criteria andUserDeptIsNotNull() {
            addCriterion("user_dept is not null");
            return (Criteria) this;
        }

        public Criteria andUserDeptEqualTo(Integer value) {
            addCriterion("user_dept =", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptNotEqualTo(Integer value) {
            addCriterion("user_dept <>", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptGreaterThan(Integer value) {
            addCriterion("user_dept >", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_dept >=", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptLessThan(Integer value) {
            addCriterion("user_dept <", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptLessThanOrEqualTo(Integer value) {
            addCriterion("user_dept <=", value, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptIn(List<Integer> values) {
            addCriterion("user_dept in", values, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptNotIn(List<Integer> values) {
            addCriterion("user_dept not in", values, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptBetween(Integer value1, Integer value2) {
            addCriterion("user_dept between", value1, value2, "userDept");
            return (Criteria) this;
        }

        public Criteria andUserDeptNotBetween(Integer value1, Integer value2) {
            addCriterion("user_dept not between", value1, value2, "userDept");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressIsNull() {
            addCriterion("idcard_address is null");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressIsNotNull() {
            addCriterion("idcard_address is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressEqualTo(String value) {
            addCriterion("idcard_address =", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressNotEqualTo(String value) {
            addCriterion("idcard_address <>", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressGreaterThan(String value) {
            addCriterion("idcard_address >", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_address >=", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressLessThan(String value) {
            addCriterion("idcard_address <", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressLessThanOrEqualTo(String value) {
            addCriterion("idcard_address <=", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressLike(String value) {
            addCriterion("idcard_address like", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressNotLike(String value) {
            addCriterion("idcard_address not like", value, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressIn(List<String> values) {
            addCriterion("idcard_address in", values, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressNotIn(List<String> values) {
            addCriterion("idcard_address not in", values, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressBetween(String value1, String value2) {
            addCriterion("idcard_address between", value1, value2, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardAddressNotBetween(String value1, String value2) {
            addCriterion("idcard_address not between", value1, value2, "idcardAddress");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNull() {
            addCriterion("home_address is null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNotNull() {
            addCriterion("home_address is not null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressEqualTo(String value) {
            addCriterion("home_address =", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotEqualTo(String value) {
            addCriterion("home_address <>", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThan(String value) {
            addCriterion("home_address >", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("home_address >=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThan(String value) {
            addCriterion("home_address <", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("home_address <=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLike(String value) {
            addCriterion("home_address like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotLike(String value) {
            addCriterion("home_address not like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIn(List<String> values) {
            addCriterion("home_address in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotIn(List<String> values) {
            addCriterion("home_address not in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressBetween(String value1, String value2) {
            addCriterion("home_address between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotBetween(String value1, String value2) {
            addCriterion("home_address not between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNull() {
            addCriterion("contact_tel is null");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNotNull() {
            addCriterion("contact_tel is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelEqualTo(String value) {
            addCriterion("contact_tel =", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotEqualTo(String value) {
            addCriterion("contact_tel <>", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThan(String value) {
            addCriterion("contact_tel >", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("contact_tel >=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThan(String value) {
            addCriterion("contact_tel <", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThanOrEqualTo(String value) {
            addCriterion("contact_tel <=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLike(String value) {
            addCriterion("contact_tel like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotLike(String value) {
            addCriterion("contact_tel not like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelIn(List<String> values) {
            addCriterion("contact_tel in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotIn(List<String> values) {
            addCriterion("contact_tel not in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelBetween(String value1, String value2) {
            addCriterion("contact_tel between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotBetween(String value1, String value2) {
            addCriterion("contact_tel not between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andBankDictIsNull() {
            addCriterion("bank_dict is null");
            return (Criteria) this;
        }

        public Criteria andBankDictIsNotNull() {
            addCriterion("bank_dict is not null");
            return (Criteria) this;
        }

        public Criteria andBankDictEqualTo(String value) {
            addCriterion("bank_dict =", value, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictNotEqualTo(String value) {
            addCriterion("bank_dict <>", value, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictGreaterThan(String value) {
            addCriterion("bank_dict >", value, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictGreaterThanOrEqualTo(String value) {
            addCriterion("bank_dict >=", value, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictLessThan(String value) {
            addCriterion("bank_dict <", value, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictLessThanOrEqualTo(String value) {
            addCriterion("bank_dict <=", value, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictLike(String value) {
            addCriterion("bank_dict like", value, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictNotLike(String value) {
            addCriterion("bank_dict not like", value, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictIn(List<String> values) {
            addCriterion("bank_dict in", values, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictNotIn(List<String> values) {
            addCriterion("bank_dict not in", values, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictBetween(String value1, String value2) {
            addCriterion("bank_dict between", value1, value2, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankDictNotBetween(String value1, String value2) {
            addCriterion("bank_dict not between", value1, value2, "bankDict");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictIsNull() {
            addCriterion("postion_level_dict is null");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictIsNotNull() {
            addCriterion("postion_level_dict is not null");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictEqualTo(String value) {
            addCriterion("postion_level_dict =", value, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictNotEqualTo(String value) {
            addCriterion("postion_level_dict <>", value, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictGreaterThan(String value) {
            addCriterion("postion_level_dict >", value, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictGreaterThanOrEqualTo(String value) {
            addCriterion("postion_level_dict >=", value, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictLessThan(String value) {
            addCriterion("postion_level_dict <", value, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictLessThanOrEqualTo(String value) {
            addCriterion("postion_level_dict <=", value, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictLike(String value) {
            addCriterion("postion_level_dict like", value, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictNotLike(String value) {
            addCriterion("postion_level_dict not like", value, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictIn(List<String> values) {
            addCriterion("postion_level_dict in", values, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictNotIn(List<String> values) {
            addCriterion("postion_level_dict not in", values, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictBetween(String value1, String value2) {
            addCriterion("postion_level_dict between", value1, value2, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andPostionLevelDictNotBetween(String value1, String value2) {
            addCriterion("postion_level_dict not between", value1, value2, "postionLevelDict");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(BigDecimal value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(BigDecimal value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(BigDecimal value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(BigDecimal value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<BigDecimal> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<BigDecimal> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andPostionStateIsNull() {
            addCriterion("postion_state is null");
            return (Criteria) this;
        }

        public Criteria andPostionStateIsNotNull() {
            addCriterion("postion_state is not null");
            return (Criteria) this;
        }

        public Criteria andPostionStateEqualTo(Integer value) {
            addCriterion("postion_state =", value, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateNotEqualTo(Integer value) {
            addCriterion("postion_state <>", value, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateGreaterThan(Integer value) {
            addCriterion("postion_state >", value, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("postion_state >=", value, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateLessThan(Integer value) {
            addCriterion("postion_state <", value, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateLessThanOrEqualTo(Integer value) {
            addCriterion("postion_state <=", value, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateIn(List<Integer> values) {
            addCriterion("postion_state in", values, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateNotIn(List<Integer> values) {
            addCriterion("postion_state not in", values, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateBetween(Integer value1, Integer value2) {
            addCriterion("postion_state between", value1, value2, "postionState");
            return (Criteria) this;
        }

        public Criteria andPostionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("postion_state not between", value1, value2, "postionState");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNull() {
            addCriterion("join_date is null");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNotNull() {
            addCriterion("join_date is not null");
            return (Criteria) this;
        }

        public Criteria andJoinDateEqualTo(String value) {
            addCriterion("join_date =", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotEqualTo(String value) {
            addCriterion("join_date <>", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThan(String value) {
            addCriterion("join_date >", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThanOrEqualTo(String value) {
            addCriterion("join_date >=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThan(String value) {
            addCriterion("join_date <", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThanOrEqualTo(String value) {
            addCriterion("join_date <=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLike(String value) {
            addCriterion("join_date like", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotLike(String value) {
            addCriterion("join_date not like", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateIn(List<String> values) {
            addCriterion("join_date in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotIn(List<String> values) {
            addCriterion("join_date not in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateBetween(String value1, String value2) {
            addCriterion("join_date between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotBetween(String value1, String value2) {
            addCriterion("join_date not between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateIsNull() {
            addCriterion("leave_date is null");
            return (Criteria) this;
        }

        public Criteria andLeaveDateIsNotNull() {
            addCriterion("leave_date is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveDateEqualTo(String value) {
            addCriterion("leave_date =", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateNotEqualTo(String value) {
            addCriterion("leave_date <>", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateGreaterThan(String value) {
            addCriterion("leave_date >", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateGreaterThanOrEqualTo(String value) {
            addCriterion("leave_date >=", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateLessThan(String value) {
            addCriterion("leave_date <", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateLessThanOrEqualTo(String value) {
            addCriterion("leave_date <=", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateLike(String value) {
            addCriterion("leave_date like", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateNotLike(String value) {
            addCriterion("leave_date not like", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateIn(List<String> values) {
            addCriterion("leave_date in", values, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateNotIn(List<String> values) {
            addCriterion("leave_date not in", values, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateBetween(String value1, String value2) {
            addCriterion("leave_date between", value1, value2, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateNotBetween(String value1, String value2) {
            addCriterion("leave_date not between", value1, value2, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateIsNull() {
            addCriterion("regular_date is null");
            return (Criteria) this;
        }

        public Criteria andRegularDateIsNotNull() {
            addCriterion("regular_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegularDateEqualTo(String value) {
            addCriterion("regular_date =", value, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateNotEqualTo(String value) {
            addCriterion("regular_date <>", value, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateGreaterThan(String value) {
            addCriterion("regular_date >", value, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateGreaterThanOrEqualTo(String value) {
            addCriterion("regular_date >=", value, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateLessThan(String value) {
            addCriterion("regular_date <", value, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateLessThanOrEqualTo(String value) {
            addCriterion("regular_date <=", value, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateLike(String value) {
            addCriterion("regular_date like", value, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateNotLike(String value) {
            addCriterion("regular_date not like", value, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateIn(List<String> values) {
            addCriterion("regular_date in", values, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateNotIn(List<String> values) {
            addCriterion("regular_date not in", values, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateBetween(String value1, String value2) {
            addCriterion("regular_date between", value1, value2, "regularDate");
            return (Criteria) this;
        }

        public Criteria andRegularDateNotBetween(String value1, String value2) {
            addCriterion("regular_date not between", value1, value2, "regularDate");
            return (Criteria) this;
        }

        public Criteria andNationDictIsNull() {
            addCriterion("nation_dict is null");
            return (Criteria) this;
        }

        public Criteria andNationDictIsNotNull() {
            addCriterion("nation_dict is not null");
            return (Criteria) this;
        }

        public Criteria andNationDictEqualTo(String value) {
            addCriterion("nation_dict =", value, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictNotEqualTo(String value) {
            addCriterion("nation_dict <>", value, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictGreaterThan(String value) {
            addCriterion("nation_dict >", value, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictGreaterThanOrEqualTo(String value) {
            addCriterion("nation_dict >=", value, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictLessThan(String value) {
            addCriterion("nation_dict <", value, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictLessThanOrEqualTo(String value) {
            addCriterion("nation_dict <=", value, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictLike(String value) {
            addCriterion("nation_dict like", value, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictNotLike(String value) {
            addCriterion("nation_dict not like", value, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictIn(List<String> values) {
            addCriterion("nation_dict in", values, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictNotIn(List<String> values) {
            addCriterion("nation_dict not in", values, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictBetween(String value1, String value2) {
            addCriterion("nation_dict between", value1, value2, "nationDict");
            return (Criteria) this;
        }

        public Criteria andNationDictNotBetween(String value1, String value2) {
            addCriterion("nation_dict not between", value1, value2, "nationDict");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPostionDictIsNull() {
            addCriterion("postion_dict is null");
            return (Criteria) this;
        }

        public Criteria andPostionDictIsNotNull() {
            addCriterion("postion_dict is not null");
            return (Criteria) this;
        }

        public Criteria andPostionDictEqualTo(String value) {
            addCriterion("postion_dict =", value, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictNotEqualTo(String value) {
            addCriterion("postion_dict <>", value, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictGreaterThan(String value) {
            addCriterion("postion_dict >", value, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictGreaterThanOrEqualTo(String value) {
            addCriterion("postion_dict >=", value, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictLessThan(String value) {
            addCriterion("postion_dict <", value, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictLessThanOrEqualTo(String value) {
            addCriterion("postion_dict <=", value, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictLike(String value) {
            addCriterion("postion_dict like", value, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictNotLike(String value) {
            addCriterion("postion_dict not like", value, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictIn(List<String> values) {
            addCriterion("postion_dict in", values, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictNotIn(List<String> values) {
            addCriterion("postion_dict not in", values, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictBetween(String value1, String value2) {
            addCriterion("postion_dict between", value1, value2, "postionDict");
            return (Criteria) this;
        }

        public Criteria andPostionDictNotBetween(String value1, String value2) {
            addCriterion("postion_dict not between", value1, value2, "postionDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictIsNull() {
            addCriterion("major_dict is null");
            return (Criteria) this;
        }

        public Criteria andMajorDictIsNotNull() {
            addCriterion("major_dict is not null");
            return (Criteria) this;
        }

        public Criteria andMajorDictEqualTo(String value) {
            addCriterion("major_dict =", value, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictNotEqualTo(String value) {
            addCriterion("major_dict <>", value, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictGreaterThan(String value) {
            addCriterion("major_dict >", value, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictGreaterThanOrEqualTo(String value) {
            addCriterion("major_dict >=", value, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictLessThan(String value) {
            addCriterion("major_dict <", value, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictLessThanOrEqualTo(String value) {
            addCriterion("major_dict <=", value, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictLike(String value) {
            addCriterion("major_dict like", value, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictNotLike(String value) {
            addCriterion("major_dict not like", value, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictIn(List<String> values) {
            addCriterion("major_dict in", values, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictNotIn(List<String> values) {
            addCriterion("major_dict not in", values, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictBetween(String value1, String value2) {
            addCriterion("major_dict between", value1, value2, "majorDict");
            return (Criteria) this;
        }

        public Criteria andMajorDictNotBetween(String value1, String value2) {
            addCriterion("major_dict not between", value1, value2, "majorDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictIsNull() {
            addCriterion("education_dict is null");
            return (Criteria) this;
        }

        public Criteria andEducationDictIsNotNull() {
            addCriterion("education_dict is not null");
            return (Criteria) this;
        }

        public Criteria andEducationDictEqualTo(String value) {
            addCriterion("education_dict =", value, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictNotEqualTo(String value) {
            addCriterion("education_dict <>", value, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictGreaterThan(String value) {
            addCriterion("education_dict >", value, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictGreaterThanOrEqualTo(String value) {
            addCriterion("education_dict >=", value, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictLessThan(String value) {
            addCriterion("education_dict <", value, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictLessThanOrEqualTo(String value) {
            addCriterion("education_dict <=", value, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictLike(String value) {
            addCriterion("education_dict like", value, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictNotLike(String value) {
            addCriterion("education_dict not like", value, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictIn(List<String> values) {
            addCriterion("education_dict in", values, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictNotIn(List<String> values) {
            addCriterion("education_dict not in", values, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictBetween(String value1, String value2) {
            addCriterion("education_dict between", value1, value2, "educationDict");
            return (Criteria) this;
        }

        public Criteria andEducationDictNotBetween(String value1, String value2) {
            addCriterion("education_dict not between", value1, value2, "educationDict");
            return (Criteria) this;
        }

        public Criteria andGraduateIsNull() {
            addCriterion("graduate is null");
            return (Criteria) this;
        }

        public Criteria andGraduateIsNotNull() {
            addCriterion("graduate is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateEqualTo(String value) {
            addCriterion("graduate =", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateNotEqualTo(String value) {
            addCriterion("graduate <>", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateGreaterThan(String value) {
            addCriterion("graduate >", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateGreaterThanOrEqualTo(String value) {
            addCriterion("graduate >=", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateLessThan(String value) {
            addCriterion("graduate <", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateLessThanOrEqualTo(String value) {
            addCriterion("graduate <=", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateLike(String value) {
            addCriterion("graduate like", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateNotLike(String value) {
            addCriterion("graduate not like", value, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateIn(List<String> values) {
            addCriterion("graduate in", values, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateNotIn(List<String> values) {
            addCriterion("graduate not in", values, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateBetween(String value1, String value2) {
            addCriterion("graduate between", value1, value2, "graduate");
            return (Criteria) this;
        }

        public Criteria andGraduateNotBetween(String value1, String value2) {
            addCriterion("graduate not between", value1, value2, "graduate");
            return (Criteria) this;
        }

        public Criteria andPolityIsNull() {
            addCriterion("polity is null");
            return (Criteria) this;
        }

        public Criteria andPolityIsNotNull() {
            addCriterion("polity is not null");
            return (Criteria) this;
        }

        public Criteria andPolityEqualTo(String value) {
            addCriterion("polity =", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityNotEqualTo(String value) {
            addCriterion("polity <>", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityGreaterThan(String value) {
            addCriterion("polity >", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityGreaterThanOrEqualTo(String value) {
            addCriterion("polity >=", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityLessThan(String value) {
            addCriterion("polity <", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityLessThanOrEqualTo(String value) {
            addCriterion("polity <=", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityLike(String value) {
            addCriterion("polity like", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityNotLike(String value) {
            addCriterion("polity not like", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityIn(List<String> values) {
            addCriterion("polity in", values, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityNotIn(List<String> values) {
            addCriterion("polity not in", values, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityBetween(String value1, String value2) {
            addCriterion("polity between", value1, value2, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityNotBetween(String value1, String value2) {
            addCriterion("polity not between", value1, value2, "polity");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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