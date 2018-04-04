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

import com.shirokumacafe.archetype.entity.News;
import com.shirokumacafe.archetype.entity.NewsExample.Criteria;
import com.shirokumacafe.archetype.entity.NewsExample.Criterion;
import com.shirokumacafe.archetype.entity.NewsExample;
import java.util.List;
import java.util.Map;

public class NewsSqlProvider {

    public String countByExample(NewsExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_news");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(NewsExample example) {
        BEGIN();
        DELETE_FROM("t_news");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(News record) {
        BEGIN();
        INSERT_INTO("t_news");
        
        if (record.getNewsTitle() != null) {
            VALUES("news_title", "#{newsTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getAddUser() != null) {
            VALUES("add_user", "#{addUser,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            VALUES("add_time", "#{addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNewsContent() != null) {
            VALUES("news_content", "#{newsContent,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(NewsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("news_id");
        } else {
            SELECT("news_id");
        }
        SELECT("news_title");
        SELECT("add_user");
        SELECT("add_time");
        SELECT("news_content");
        FROM("t_news");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(NewsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("news_id");
        } else {
            SELECT("news_id");
        }
        SELECT("news_title");
        SELECT("add_user");
        SELECT("add_time");
        FROM("t_news");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        News record = (News) parameter.get("record");
        NewsExample example = (NewsExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_news");
        
        if (record.getNewsId() != null) {
            SET("news_id = #{record.newsId,jdbcType=INTEGER}");
        }
        
        if (record.getNewsTitle() != null) {
            SET("news_title = #{record.newsTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getAddUser() != null) {
            SET("add_user = #{record.addUser,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNewsContent() != null) {
            SET("news_content = #{record.newsContent,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_news");
        
        SET("news_id = #{record.newsId,jdbcType=INTEGER}");
        SET("news_title = #{record.newsTitle,jdbcType=VARCHAR}");
        SET("add_user = #{record.addUser,jdbcType=INTEGER}");
        SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        SET("news_content = #{record.newsContent,jdbcType=LONGVARCHAR}");
        
        NewsExample example = (NewsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_news");
        
        SET("news_id = #{record.newsId,jdbcType=INTEGER}");
        SET("news_title = #{record.newsTitle,jdbcType=VARCHAR}");
        SET("add_user = #{record.addUser,jdbcType=INTEGER}");
        SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        
        NewsExample example = (NewsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(News record) {
        BEGIN();
        UPDATE("t_news");
        
        if (record.getNewsTitle() != null) {
            SET("news_title = #{newsTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getAddUser() != null) {
            SET("add_user = #{addUser,jdbcType=INTEGER}");
        }
        
        if (record.getAddTime() != null) {
            SET("add_time = #{addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNewsContent() != null) {
            SET("news_content = #{newsContent,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("news_id = #{newsId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(NewsExample example, boolean includeExamplePhrase) {
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