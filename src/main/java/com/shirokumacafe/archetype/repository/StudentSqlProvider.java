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

import com.shirokumacafe.archetype.entity.Student;
import com.shirokumacafe.archetype.entity.StudentExample.Criteria;
import com.shirokumacafe.archetype.entity.StudentExample.Criterion;
import com.shirokumacafe.archetype.entity.StudentExample;
import java.util.List;
import java.util.Map;

public class StudentSqlProvider {

    public String countByExample(StudentExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_student");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(StudentExample example) {
        BEGIN();
        DELETE_FROM("t_student");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Student record) {
        BEGIN();
        INSERT_INTO("t_student");
        
        if (record.getsNo() != null) {
            VALUES("s_no", "#{sNo,jdbcType=VARCHAR}");
        }
        
        if (record.getsName() != null) {
            VALUES("s_name", "#{sName,jdbcType=VARCHAR}");
        }
        
        if (record.getsPassword() != null) {
            VALUES("s_password", "#{sPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            VALUES("salt", "#{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRole() != null) {
            VALUES("user_role", "#{userRole,jdbcType=INTEGER}");
        }
        
        if (record.getsSex() != null) {
            VALUES("s_sex", "#{sSex,jdbcType=BIT}");
        }
        
        if (record.getdId() != null) {
            VALUES("d_id", "#{dId,jdbcType=INTEGER}");
        }
        
        if (record.getGrade() != null) {
            VALUES("grade", "#{grade,jdbcType=VARCHAR}");
        }
        
        if (record.getsClass() != null) {
            VALUES("s_class", "#{sClass,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(StudentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("s_id");
        } else {
            SELECT("s_id");
        }
        SELECT("s_no");
        SELECT("s_name");
        SELECT("s_password");
        SELECT("salt");
        SELECT("user_role");
        SELECT("s_sex");
        SELECT("d_id");
        SELECT("grade");
        SELECT("s_class");
        FROM("t_student");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Student record = (Student) parameter.get("record");
        StudentExample example = (StudentExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_student");
        
        if (record.getsId() != null) {
            SET("s_id = #{record.sId,jdbcType=INTEGER}");
        }
        
        if (record.getsNo() != null) {
            SET("s_no = #{record.sNo,jdbcType=VARCHAR}");
        }
        
        if (record.getsName() != null) {
            SET("s_name = #{record.sName,jdbcType=VARCHAR}");
        }
        
        if (record.getsPassword() != null) {
            SET("s_password = #{record.sPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            SET("salt = #{record.salt,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRole() != null) {
            SET("user_role = #{record.userRole,jdbcType=INTEGER}");
        }
        
        if (record.getsSex() != null) {
            SET("s_sex = #{record.sSex,jdbcType=BIT}");
        }
        
        if (record.getdId() != null) {
            SET("d_id = #{record.dId,jdbcType=INTEGER}");
        }
        
        if (record.getGrade() != null) {
            SET("grade = #{record.grade,jdbcType=VARCHAR}");
        }
        
        if (record.getsClass() != null) {
            SET("s_class = #{record.sClass,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_student");
        
        SET("s_id = #{record.sId,jdbcType=INTEGER}");
        SET("s_no = #{record.sNo,jdbcType=VARCHAR}");
        SET("s_name = #{record.sName,jdbcType=VARCHAR}");
        SET("s_password = #{record.sPassword,jdbcType=VARCHAR}");
        SET("salt = #{record.salt,jdbcType=VARCHAR}");
        SET("user_role = #{record.userRole,jdbcType=INTEGER}");
        SET("s_sex = #{record.sSex,jdbcType=BIT}");
        SET("d_id = #{record.dId,jdbcType=INTEGER}");
        SET("grade = #{record.grade,jdbcType=VARCHAR}");
        SET("s_class = #{record.sClass,jdbcType=VARCHAR}");
        
        StudentExample example = (StudentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Student record) {
        BEGIN();
        UPDATE("t_student");
        
        if (record.getsNo() != null) {
            SET("s_no = #{sNo,jdbcType=VARCHAR}");
        }
        
        if (record.getsName() != null) {
            SET("s_name = #{sName,jdbcType=VARCHAR}");
        }
        
        if (record.getsPassword() != null) {
            SET("s_password = #{sPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            SET("salt = #{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRole() != null) {
            SET("user_role = #{userRole,jdbcType=INTEGER}");
        }
        
        if (record.getsSex() != null) {
            SET("s_sex = #{sSex,jdbcType=BIT}");
        }
        
        if (record.getdId() != null) {
            SET("d_id = #{dId,jdbcType=INTEGER}");
        }
        
        if (record.getGrade() != null) {
            SET("grade = #{grade,jdbcType=VARCHAR}");
        }
        
        if (record.getsClass() != null) {
            SET("s_class = #{sClass,jdbcType=VARCHAR}");
        }
        
        WHERE("s_id = #{sId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(StudentExample example, boolean includeExamplePhrase) {
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