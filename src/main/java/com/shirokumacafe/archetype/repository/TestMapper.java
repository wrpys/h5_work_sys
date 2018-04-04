package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Test;
import com.shirokumacafe.archetype.entity.TestExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface TestMapper {
    @SelectProvider(type=TestSqlProvider.class, method="countByExample")
    int countByExample(TestExample example);

    @DeleteProvider(type=TestSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestExample example);

    @Delete({
        "delete from t_test",
        "where test_id = #{testId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer testId);

    @Insert({
        "insert into t_test (test_title, test_option_a, ",
        "test_option_b, test_option_c, ",
        "test_option_d, test_answer, ",
        "add_time)",
        "values (#{testTitle,jdbcType=VARCHAR}, #{testOptionA,jdbcType=VARCHAR}, ",
        "#{testOptionB,jdbcType=VARCHAR}, #{testOptionC,jdbcType=VARCHAR}, ",
        "#{testOptionD,jdbcType=VARCHAR}, #{testAnswer,jdbcType=INTEGER}, ",
        "#{addTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="testId", before=false, resultType=Integer.class)
    int insert(Test record);

    @InsertProvider(type=TestSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="testId", before=false, resultType=Integer.class)
    int insertSelective(Test record);

    @SelectProvider(type=TestSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="test_id", property="testId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="test_title", property="testTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_a", property="testOptionA", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_b", property="testOptionB", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_c", property="testOptionC", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_d", property="testOptionD", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_answer", property="testAnswer", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Test> selectByExampleWithRowbounds(TestExample example, RowBounds rowBounds);

    @SelectProvider(type=TestSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="test_id", property="testId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="test_title", property="testTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_a", property="testOptionA", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_b", property="testOptionB", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_c", property="testOptionC", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_d", property="testOptionD", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_answer", property="testAnswer", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Test> selectByExample(TestExample example);

    @Select({
        "select",
        "test_id, test_title, test_option_a, test_option_b, test_option_c, test_option_d, ",
        "test_answer, add_time",
        "from t_test",
        "where test_id = #{testId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="test_id", property="testId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="test_title", property="testTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_a", property="testOptionA", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_b", property="testOptionB", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_c", property="testOptionC", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_option_d", property="testOptionD", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_answer", property="testAnswer", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Test selectByPrimaryKey(Integer testId);

    @UpdateProvider(type=TestSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    @UpdateProvider(type=TestSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    @UpdateProvider(type=TestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Test record);

    @Update({
        "update t_test",
        "set test_title = #{testTitle,jdbcType=VARCHAR},",
          "test_option_a = #{testOptionA,jdbcType=VARCHAR},",
          "test_option_b = #{testOptionB,jdbcType=VARCHAR},",
          "test_option_c = #{testOptionC,jdbcType=VARCHAR},",
          "test_option_d = #{testOptionD,jdbcType=VARCHAR},",
          "test_answer = #{testAnswer,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=TIMESTAMP}",
        "where test_id = #{testId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Test record);
}