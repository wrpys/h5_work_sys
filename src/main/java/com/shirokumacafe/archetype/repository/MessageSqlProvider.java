package com.shirokumacafe.archetype.repository;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.shirokumacafe.archetype.entity.Message;
import com.shirokumacafe.archetype.entity.MessageExample.Criteria;
import com.shirokumacafe.archetype.entity.MessageExample.Criterion;
import com.shirokumacafe.archetype.entity.MessageExample;
import java.util.List;
import java.util.Map;

public class MessageSqlProvider {

    public String countByExample(MessageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_message");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(MessageExample example) {
        BEGIN();
        DELETE_FROM("t_message");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Message record) {
        BEGIN();
        INSERT_INTO("t_message");
        
        if (record.getMsgId() != null) {
            VALUES("msg_id", "#{msgId,jdbcType=INTEGER}");
        }
        
        if (record.getMsgPid() != null) {
            VALUES("msg_pid", "#{msgPid,jdbcType=INTEGER}");
        }
        
        if (record.getSendRole() != null) {
            VALUES("send__role", "#{sendRole,jdbcType=INTEGER}");
        }
        
        if (record.getStudentId() != null) {
            VALUES("student_id", "#{studentId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getMsgContent() != null) {
            VALUES("msg_content", "#{msgContent,jdbcType=VARCHAR}");
        }
        
        if (record.getMsgAddTime() != null) {
            VALUES("msg_add_time", "#{msgAddTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMsgIsReply() != null) {
            VALUES("msg_is_reply", "#{msgIsReply,jdbcType=INTEGER}");
        }
        
        if (record.getMsgIsRead() != null) {
            VALUES("msg_is_read", "#{msgIsRead,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(MessageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("msg_id");
        } else {
            SELECT("msg_id");
        }
        SELECT("msg_pid");
        SELECT("send__role");
        SELECT("student_id");
        SELECT("user_id");
        SELECT("msg_content");
        SELECT("msg_add_time");
        SELECT("msg_is_reply");
        SELECT("msg_is_read");
        FROM("t_message");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Message record = (Message) parameter.get("record");
        MessageExample example = (MessageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_message");
        
        if (record.getMsgId() != null) {
            SET("msg_id = #{record.msgId,jdbcType=INTEGER}");
        }
        
        if (record.getMsgPid() != null) {
            SET("msg_pid = #{record.msgPid,jdbcType=INTEGER}");
        }
        
        if (record.getSendRole() != null) {
            SET("send__role = #{record.sendRole,jdbcType=INTEGER}");
        }
        
        if (record.getStudentId() != null) {
            SET("student_id = #{record.studentId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getMsgContent() != null) {
            SET("msg_content = #{record.msgContent,jdbcType=VARCHAR}");
        }
        
        if (record.getMsgAddTime() != null) {
            SET("msg_add_time = #{record.msgAddTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMsgIsReply() != null) {
            SET("msg_is_reply = #{record.msgIsReply,jdbcType=INTEGER}");
        }
        
        if (record.getMsgIsRead() != null) {
            SET("msg_is_read = #{record.msgIsRead,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_message");
        
        SET("msg_id = #{record.msgId,jdbcType=INTEGER}");
        SET("msg_pid = #{record.msgPid,jdbcType=INTEGER}");
        SET("send__role = #{record.sendRole,jdbcType=INTEGER}");
        SET("student_id = #{record.studentId,jdbcType=INTEGER}");
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("msg_content = #{record.msgContent,jdbcType=VARCHAR}");
        SET("msg_add_time = #{record.msgAddTime,jdbcType=TIMESTAMP}");
        SET("msg_is_reply = #{record.msgIsReply,jdbcType=INTEGER}");
        SET("msg_is_read = #{record.msgIsRead,jdbcType=INTEGER}");
        
        MessageExample example = (MessageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Message record) {
        BEGIN();
        UPDATE("t_message");
        
        if (record.getMsgPid() != null) {
            SET("msg_pid = #{msgPid,jdbcType=INTEGER}");
        }
        
        if (record.getSendRole() != null) {
            SET("send__role = #{sendRole,jdbcType=INTEGER}");
        }
        
        if (record.getStudentId() != null) {
            SET("student_id = #{studentId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getMsgContent() != null) {
            SET("msg_content = #{msgContent,jdbcType=VARCHAR}");
        }
        
        if (record.getMsgAddTime() != null) {
            SET("msg_add_time = #{msgAddTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMsgIsReply() != null) {
            SET("msg_is_reply = #{msgIsReply,jdbcType=INTEGER}");
        }
        
        if (record.getMsgIsRead() != null) {
            SET("msg_is_read = #{msgIsRead,jdbcType=INTEGER}");
        }
        
        WHERE("msg_id = #{msgId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(MessageExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}