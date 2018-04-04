package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.CourseInfo;
import com.shirokumacafe.archetype.entity.CourseInfoExample;
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

public interface CourseInfoMapper {
    @SelectProvider(type=CourseInfoSqlProvider.class, method="countByExample")
    int countByExample(CourseInfoExample example);

    @DeleteProvider(type=CourseInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(CourseInfoExample example);

    @Delete({
        "delete from t_course_info",
        "where ci_id = #{ciId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ciId);

    @Insert({
        "insert into t_course_info (ci_id, c_id, ",
        "ct_id, s_id, attendance_info, ",
        "work_info)",
        "values (#{ciId,jdbcType=INTEGER}, #{cId,jdbcType=INTEGER}, ",
        "#{ctId,jdbcType=INTEGER}, #{sId,jdbcType=INTEGER}, #{attendanceInfo,jdbcType=INTEGER}, ",
        "#{workInfo,jdbcType=INTEGER})"
    })
    int insert(CourseInfo record);

    @InsertProvider(type=CourseInfoSqlProvider.class, method="insertSelective")
    int insertSelective(CourseInfo record);

    @SelectProvider(type=CourseInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ci_id", property="ciId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="attendance_info", property="attendanceInfo", jdbcType=JdbcType.INTEGER),
        @Result(column="work_info", property="workInfo", jdbcType=JdbcType.INTEGER)
    })
    List<CourseInfo> selectByExampleWithRowbounds(CourseInfoExample example, RowBounds rowBounds);

    @SelectProvider(type=CourseInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ci_id", property="ciId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="attendance_info", property="attendanceInfo", jdbcType=JdbcType.INTEGER),
        @Result(column="work_info", property="workInfo", jdbcType=JdbcType.INTEGER)
    })
    List<CourseInfo> selectByExample(CourseInfoExample example);

    @Select({
        "select",
        "ci_id, c_id, ct_id, s_id, attendance_info, work_info",
        "from t_course_info",
        "where ci_id = #{ciId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ci_id", property="ciId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="attendance_info", property="attendanceInfo", jdbcType=JdbcType.INTEGER),
        @Result(column="work_info", property="workInfo", jdbcType=JdbcType.INTEGER)
    })
    CourseInfo selectByPrimaryKey(Integer ciId);

    @UpdateProvider(type=CourseInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CourseInfo record, @Param("example") CourseInfoExample example);

    @UpdateProvider(type=CourseInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CourseInfo record, @Param("example") CourseInfoExample example);

    @UpdateProvider(type=CourseInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CourseInfo record);

    @Update({
        "update t_course_info",
        "set c_id = #{cId,jdbcType=INTEGER},",
          "ct_id = #{ctId,jdbcType=INTEGER},",
          "s_id = #{sId,jdbcType=INTEGER},",
          "attendance_info = #{attendanceInfo,jdbcType=INTEGER},",
          "work_info = #{workInfo,jdbcType=INTEGER}",
        "where ci_id = #{ciId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseInfo record);
}