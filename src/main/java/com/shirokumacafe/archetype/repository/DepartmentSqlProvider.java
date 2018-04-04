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

import com.shirokumacafe.archetype.entity.Department;
import com.shirokumacafe.archetype.entity.DepartmentExample.Criteria;
import com.shirokumacafe.archetype.entity.DepartmentExample.Criterion;
import com.shirokumacafe.archetype.entity.DepartmentExample;
import java.util.List;
import java.util.Map;

public class DepartmentSqlProvider {

    public String countByExample(DepartmentExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_department");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(DepartmentExample example) {
        BEGIN();
        DELETE_FROM("t_department");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Department record) {
        BEGIN();
        INSERT_INTO("t_department");
        
        if (record.getLeaf() != null) {
            VALUES("leaf", "#{leaf,jdbcType=BIT}");
        }
        
        if (record.getdName() != null) {
            VALUES("d_name", "#{dName,jdbcType=VARCHAR}");
        }
        
        if (record.getdPid() != null) {
            VALUES("d_pid", "#{dPid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(DepartmentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("d_id");
        } else {
            SELECT("d_id");
        }
        SELECT("leaf");
        SELECT("d_name");
        SELECT("d_pid");
        FROM("t_department");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Department record = (Department) parameter.get("record");
        DepartmentExample example = (DepartmentExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_department");
        
        if (record.getdId() != null) {
            SET("d_id = #{record.dId,jdbcType=INTEGER}");
        }
        
        if (record.getLeaf() != null) {
            SET("leaf = #{record.leaf,jdbcType=BIT}");
        }
        
        if (record.getdName() != null) {
            SET("d_name = #{record.dName,jdbcType=VARCHAR}");
        }
        
        if (record.getdPid() != null) {
            SET("d_pid = #{record.dPid,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_department");
        
        SET("d_id = #{record.dId,jdbcType=INTEGER}");
        SET("leaf = #{record.leaf,jdbcType=BIT}");
        SET("d_name = #{record.dName,jdbcType=VARCHAR}");
        SET("d_pid = #{record.dPid,jdbcType=INTEGER}");
        
        DepartmentExample example = (DepartmentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Department record) {
        BEGIN();
        UPDATE("t_department");
        
        if (record.getLeaf() != null) {
            SET("leaf = #{leaf,jdbcType=BIT}");
        }
        
        if (record.getdName() != null) {
            SET("d_name = #{dName,jdbcType=VARCHAR}");
        }
        
        if (record.getdPid() != null) {
            SET("d_pid = #{dPid,jdbcType=INTEGER}");
        }
        
        WHERE("d_id = #{dId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(DepartmentExample example, boolean includeExamplePhrase) {
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