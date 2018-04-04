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

import com.shirokumacafe.archetype.entity.CourseInfo;
import com.shirokumacafe.archetype.entity.CourseInfoExample.Criteria;
import com.shirokumacafe.archetype.entity.CourseInfoExample.Criterion;
import com.shirokumacafe.archetype.entity.CourseInfoExample;
import java.util.List;
import java.util.Map;

public class CourseInfoSqlProvider {

    public String countByExample(CourseInfoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_course_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CourseInfoExample example) {
        BEGIN();
        DELETE_FROM("t_course_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CourseInfo record) {
        BEGIN();
        INSERT_INTO("t_course_info");
        
        if (record.getCiId() != null) {
            VALUES("ci_id", "#{ciId,jdbcType=INTEGER}");
        }
        
        if (record.getcId() != null) {
            VALUES("c_id", "#{cId,jdbcType=INTEGER}");
        }
        
        if (record.getCtId() != null) {
            VALUES("ct_id", "#{ctId,jdbcType=INTEGER}");
        }
        
        if (record.getsId() != null) {
            VALUES("s_id", "#{sId,jdbcType=INTEGER}");
        }
        
        if (record.getAttendanceInfo() != null) {
            VALUES("attendance_info", "#{attendanceInfo,jdbcType=INTEGER}");
        }
        
        if (record.getWorkInfo() != null) {
            VALUES("work_info", "#{workInfo,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(CourseInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ci_id");
        } else {
            SELECT("ci_id");
        }
        SELECT("c_id");
        SELECT("ct_id");
        SELECT("s_id");
        SELECT("attendance_info");
        SELECT("work_info");
        FROM("t_course_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CourseInfo record = (CourseInfo) parameter.get("record");
        CourseInfoExample example = (CourseInfoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_course_info");
        
        if (record.getCiId() != null) {
            SET("ci_id = #{record.ciId,jdbcType=INTEGER}");
        }
        
        if (record.getcId() != null) {
            SET("c_id = #{record.cId,jdbcType=INTEGER}");
        }
        
        if (record.getCtId() != null) {
            SET("ct_id = #{record.ctId,jdbcType=INTEGER}");
        }
        
        if (record.getsId() != null) {
            SET("s_id = #{record.sId,jdbcType=INTEGER}");
        }
        
        if (record.getAttendanceInfo() != null) {
            SET("attendance_info = #{record.attendanceInfo,jdbcType=INTEGER}");
        }
        
        if (record.getWorkInfo() != null) {
            SET("work_info = #{record.workInfo,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_course_info");
        
        SET("ci_id = #{record.ciId,jdbcType=INTEGER}");
        SET("c_id = #{record.cId,jdbcType=INTEGER}");
        SET("ct_id = #{record.ctId,jdbcType=INTEGER}");
        SET("s_id = #{record.sId,jdbcType=INTEGER}");
        SET("attendance_info = #{record.attendanceInfo,jdbcType=INTEGER}");
        SET("work_info = #{record.workInfo,jdbcType=INTEGER}");
        
        CourseInfoExample example = (CourseInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CourseInfo record) {
        BEGIN();
        UPDATE("t_course_info");
        
        if (record.getcId() != null) {
            SET("c_id = #{cId,jdbcType=INTEGER}");
        }
        
        if (record.getCtId() != null) {
            SET("ct_id = #{ctId,jdbcType=INTEGER}");
        }
        
        if (record.getsId() != null) {
            SET("s_id = #{sId,jdbcType=INTEGER}");
        }
        
        if (record.getAttendanceInfo() != null) {
            SET("attendance_info = #{attendanceInfo,jdbcType=INTEGER}");
        }
        
        if (record.getWorkInfo() != null) {
            SET("work_info = #{workInfo,jdbcType=INTEGER}");
        }
        
        WHERE("ci_id = #{ciId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(CourseInfoExample example, boolean includeExamplePhrase) {
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