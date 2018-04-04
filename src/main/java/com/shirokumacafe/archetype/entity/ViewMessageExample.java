package com.shirokumacafe.archetype.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewMessageExample() {
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

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(Integer value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(Integer value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(Integer value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(Integer value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<Integer> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<Integer> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgPidIsNull() {
            addCriterion("msg_pid is null");
            return (Criteria) this;
        }

        public Criteria andMsgPidIsNotNull() {
            addCriterion("msg_pid is not null");
            return (Criteria) this;
        }

        public Criteria andMsgPidEqualTo(Integer value) {
            addCriterion("msg_pid =", value, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidNotEqualTo(Integer value) {
            addCriterion("msg_pid <>", value, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidGreaterThan(Integer value) {
            addCriterion("msg_pid >", value, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_pid >=", value, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidLessThan(Integer value) {
            addCriterion("msg_pid <", value, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidLessThanOrEqualTo(Integer value) {
            addCriterion("msg_pid <=", value, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidIn(List<Integer> values) {
            addCriterion("msg_pid in", values, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidNotIn(List<Integer> values) {
            addCriterion("msg_pid not in", values, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidBetween(Integer value1, Integer value2) {
            addCriterion("msg_pid between", value1, value2, "msgPid");
            return (Criteria) this;
        }

        public Criteria andMsgPidNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_pid not between", value1, value2, "msgPid");
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andSendRoleIsNull() {
            addCriterion("send__role is null");
            return (Criteria) this;
        }

        public Criteria andSendRoleIsNotNull() {
            addCriterion("send__role is not null");
            return (Criteria) this;
        }

        public Criteria andSendRoleEqualTo(Integer value) {
            addCriterion("send__role =", value, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleNotEqualTo(Integer value) {
            addCriterion("send__role <>", value, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleGreaterThan(Integer value) {
            addCriterion("send__role >", value, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("send__role >=", value, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleLessThan(Integer value) {
            addCriterion("send__role <", value, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleLessThanOrEqualTo(Integer value) {
            addCriterion("send__role <=", value, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleIn(List<Integer> values) {
            addCriterion("send__role in", values, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleNotIn(List<Integer> values) {
            addCriterion("send__role not in", values, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleBetween(Integer value1, Integer value2) {
            addCriterion("send__role between", value1, value2, "sendRole");
            return (Criteria) this;
        }

        public Criteria andSendRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("send__role not between", value1, value2, "sendRole");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNull() {
            addCriterion("msg_content is null");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNotNull() {
            addCriterion("msg_content is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContentEqualTo(String value) {
            addCriterion("msg_content =", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotEqualTo(String value) {
            addCriterion("msg_content <>", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThan(String value) {
            addCriterion("msg_content >", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThanOrEqualTo(String value) {
            addCriterion("msg_content >=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThan(String value) {
            addCriterion("msg_content <", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThanOrEqualTo(String value) {
            addCriterion("msg_content <=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLike(String value) {
            addCriterion("msg_content like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotLike(String value) {
            addCriterion("msg_content not like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentIn(List<String> values) {
            addCriterion("msg_content in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotIn(List<String> values) {
            addCriterion("msg_content not in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentBetween(String value1, String value2) {
            addCriterion("msg_content between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotBetween(String value1, String value2) {
            addCriterion("msg_content not between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeIsNull() {
            addCriterion("msg_add_time is null");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeIsNotNull() {
            addCriterion("msg_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeEqualTo(Date value) {
            addCriterion("msg_add_time =", value, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeNotEqualTo(Date value) {
            addCriterion("msg_add_time <>", value, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeGreaterThan(Date value) {
            addCriterion("msg_add_time >", value, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("msg_add_time >=", value, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeLessThan(Date value) {
            addCriterion("msg_add_time <", value, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("msg_add_time <=", value, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeIn(List<Date> values) {
            addCriterion("msg_add_time in", values, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeNotIn(List<Date> values) {
            addCriterion("msg_add_time not in", values, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeBetween(Date value1, Date value2) {
            addCriterion("msg_add_time between", value1, value2, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("msg_add_time not between", value1, value2, "msgAddTime");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadIsNull() {
            addCriterion("msg_is_read is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadIsNotNull() {
            addCriterion("msg_is_read is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadEqualTo(Integer value) {
            addCriterion("msg_is_read =", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadNotEqualTo(Integer value) {
            addCriterion("msg_is_read <>", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadGreaterThan(Integer value) {
            addCriterion("msg_is_read >", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_is_read >=", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadLessThan(Integer value) {
            addCriterion("msg_is_read <", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("msg_is_read <=", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadIn(List<Integer> values) {
            addCriterion("msg_is_read in", values, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadNotIn(List<Integer> values) {
            addCriterion("msg_is_read not in", values, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadBetween(Integer value1, Integer value2) {
            addCriterion("msg_is_read between", value1, value2, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_is_read not between", value1, value2, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyIsNull() {
            addCriterion("msg_is_reply is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyIsNotNull() {
            addCriterion("msg_is_reply is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyEqualTo(Integer value) {
            addCriterion("msg_is_reply =", value, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyNotEqualTo(Integer value) {
            addCriterion("msg_is_reply <>", value, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyGreaterThan(Integer value) {
            addCriterion("msg_is_reply >", value, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_is_reply >=", value, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyLessThan(Integer value) {
            addCriterion("msg_is_reply <", value, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyLessThanOrEqualTo(Integer value) {
            addCriterion("msg_is_reply <=", value, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyIn(List<Integer> values) {
            addCriterion("msg_is_reply in", values, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyNotIn(List<Integer> values) {
            addCriterion("msg_is_reply not in", values, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyBetween(Integer value1, Integer value2) {
            addCriterion("msg_is_reply between", value1, value2, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andMsgIsReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_is_reply not between", value1, value2, "msgIsReply");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
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