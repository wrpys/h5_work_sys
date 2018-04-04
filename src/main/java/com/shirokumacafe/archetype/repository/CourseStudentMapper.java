package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.CourseStudent;
import com.shirokumacafe.archetype.entity.CourseStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface CourseStudentMapper {
    @SelectProvider(type=CourseStudentSqlProvider.class, method="countByExample")
    int countByExample(CourseStudentExample example);

    @DeleteProvider(type=CourseStudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(CourseStudentExample example);

    @Delete({
        "delete from t_course_student",
        "where cs_id = #{csId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer csId);

    @Insert({
        "insert into t_course_student (cs_id, c_id, ",
        "s_id)",
        "values (#{csId,jdbcType=INTEGER}, #{cId,jdbcType=INTEGER}, ",
        "#{sId,jdbcType=INTEGER})"
    })
    int insert(CourseStudent record);

    @InsertProvider(type=CourseStudentSqlProvider.class, method="insertSelective")
    int insertSelective(CourseStudent record);

    @SelectProvider(type=CourseStudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="cs_id", property="csId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER)
    })
    List<CourseStudent> selectByExampleWithRowbounds(CourseStudentExample example, RowBounds rowBounds);

    @SelectProvider(type=CourseStudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="cs_id", property="csId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER)
    })
    List<CourseStudent> selectByExample(CourseStudentExample example);

    @Select({
        "select",
        "cs_id, c_id, s_id",
        "from t_course_student",
        "where cs_id = #{csId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="cs_id", property="csId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER)
    })
    CourseStudent selectByPrimaryKey(Integer csId);

    @UpdateProvider(type=CourseStudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CourseStudent record, @Param("example") CourseStudentExample example);

    @UpdateProvider(type=CourseStudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CourseStudent record, @Param("example") CourseStudentExample example);

    @UpdateProvider(type=CourseStudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CourseStudent record);

    @Update({
        "update t_course_student",
        "set c_id = #{cId,jdbcType=INTEGER},",
          "s_id = #{sId,jdbcType=INTEGER}",
        "where cs_id = #{csId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseStudent record);
}