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

import com.shirokumacafe.archetype.entity.Test;
import com.shirokumacafe.archetype.entity.TestExample.Criteria;
import com.shirokumacafe.archetype.entity.TestExample.Criterion;
import com.shirokumacafe.archetype.entity.TestExample;
import java.util.List;
import java.util.Map;

public class TestSqlProvider {

    public String countByExample(TestExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_test");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TestExample example) {
        BEGIN();
        DELETE_FROM("t_test");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Test record) {
        BEGIN();
        INSERT_INTO("t_test");
        
        if (record.getTestTitle() != null) {
            VALUES("test_title", "#{testTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionA() != null) {
            VALUES("test_option_a", "#{testOptionA,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionB() != null) {
            VALUES("test_option_b", "#{testOptionB,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionC() != null) {
            VALUES("test_option_c", "#{testOptionC,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionD() != null) {
            VALUES("test_option_d", "#{testOptionD,jdbcType=VARCHAR}");
        }
        
        if (record.getTestAnswer() != null) {
            VALUES("test_answer", "#{testAnswer,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            VALUES("add_time", "#{addTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(TestExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("test_id");
        } else {
            SELECT("test_id");
        }
        SELECT("test_title");
        SELECT("test_option_a");
        SELECT("test_option_b");
        SELECT("test_option_c");
        SELECT("test_option_d");
        SELECT("test_answer");
        SELECT("add_time");
        FROM("t_test");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Test record = (Test) parameter.get("record");
        TestExample example = (TestExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_test");
        
        if (record.getTestId() != null) {
            SET("test_id = #{record.testId,jdbcType=INTEGER}");
        }
        
        if (record.getTestTitle() != null) {
            SET("test_title = #{record.testTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionA() != null) {
            SET("test_option_a = #{record.testOptionA,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionB() != null) {
            SET("test_option_b = #{record.testOptionB,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionC() != null) {
            SET("test_option_c = #{record.testOptionC,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionD() != null) {
            SET("test_option_d = #{record.testOptionD,jdbcType=VARCHAR}");
        }
        
        if (record.getTestAnswer() != null) {
            SET("test_answer = #{record.testAnswer,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_test");
        
        SET("test_id = #{record.testId,jdbcType=INTEGER}");
        SET("test_title = #{record.testTitle,jdbcType=VARCHAR}");
        SET("test_option_a = #{record.testOptionA,jdbcType=VARCHAR}");
        SET("test_option_b = #{record.testOptionB,jdbcType=VARCHAR}");
        SET("test_option_c = #{record.testOptionC,jdbcType=VARCHAR}");
        SET("test_option_d = #{record.testOptionD,jdbcType=VARCHAR}");
        SET("test_answer = #{record.testAnswer,jdbcType=INTEGER}");
        SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        
        TestExample example = (TestExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Test record) {
        BEGIN();
        UPDATE("t_test");
        
        if (record.getTestTitle() != null) {
            SET("test_title = #{testTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionA() != null) {
            SET("test_option_a = #{testOptionA,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionB() != null) {
            SET("test_option_b = #{testOptionB,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionC() != null) {
            SET("test_option_c = #{testOptionC,jdbcType=VARCHAR}");
        }
        
        if (record.getTestOptionD() != null) {
            SET("test_option_d = #{testOptionD,jdbcType=VARCHAR}");
        }
        
        if (record.getTestAnswer() != null) {
            SET("test_answer = #{testAnswer,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            SET("add_time = #{addTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("test_id = #{testId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(TestExample example, boolean includeExamplePhrase) {
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