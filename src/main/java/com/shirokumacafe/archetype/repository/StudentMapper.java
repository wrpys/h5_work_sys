package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Student;
import com.shirokumacafe.archetype.entity.StudentExample;
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

public interface StudentMapper {
    @SelectProvider(type=StudentSqlProvider.class, method="countByExample")
    int countByExample(StudentExample example);

    @DeleteProvider(type=StudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentExample example);

    @Delete({
        "delete from t_student",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sId);

    @Insert({
        "insert into t_student (s_no, s_name, ",
        "s_password, salt, ",
        "user_role, s_sex, d_id, ",
        "clzss_id, grade, ",
        "s_class)",
        "values (#{sNo,jdbcType=VARCHAR}, #{sName,jdbcType=VARCHAR}, ",
        "#{sPassword,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
        "#{userRole,jdbcType=INTEGER}, #{sSex,jdbcType=BIT}, #{dId,jdbcType=INTEGER}, ",
        "#{clzssId,jdbcType=INTEGER}, #{grade,jdbcType=INTEGER}, ",
        "#{sClass,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="sId", before=false, resultType=Integer.class)
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="sId", before=false, resultType=Integer.class)
    int insertSelective(Student record);

    @SelectProvider(type=StudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_password", property="sPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="s_sex", property="sSex", jdbcType=JdbcType.BIT),
        @Result(column="d_id", property="dId", jdbcType=JdbcType.INTEGER),
        @Result(column="clzss_id", property="clzssId", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="s_class", property="sClass", jdbcType=JdbcType.VARCHAR)
    })
    List<Student> selectByExampleWithRowbounds(StudentExample example, RowBounds rowBounds);

    @SelectProvider(type=StudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_password", property="sPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="s_sex", property="sSex", jdbcType=JdbcType.BIT),
        @Result(column="d_id", property="dId", jdbcType=JdbcType.INTEGER),
        @Result(column="clzss_id", property="clzssId", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="s_class", property="sClass", jdbcType=JdbcType.VARCHAR)
    })
    List<Student> selectByExample(StudentExample example);

    @Select({
        "select",
        "s_id, s_no, s_name, s_password, salt, user_role, s_sex, d_id, clzss_id, grade, ",
        "s_class",
        "from t_student",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_password", property="sPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.INTEGER),
        @Result(column="s_sex", property="sSex", jdbcType=JdbcType.BIT),
        @Result(column="d_id", property="dId", jdbcType=JdbcType.INTEGER),
        @Result(column="clzss_id", property="clzssId", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="s_class", property="sClass", jdbcType=JdbcType.VARCHAR)
    })
    Student selectByPrimaryKey(Integer sId);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update t_student",
        "set s_no = #{sNo,jdbcType=VARCHAR},",
          "s_name = #{sName,jdbcType=VARCHAR},",
          "s_password = #{sPassword,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "user_role = #{userRole,jdbcType=INTEGER},",
          "s_sex = #{sSex,jdbcType=BIT},",
          "d_id = #{dId,jdbcType=INTEGER},",
          "clzss_id = #{clzssId,jdbcType=INTEGER},",
          "grade = #{grade,jdbcType=INTEGER},",
          "s_class = #{sClass,jdbcType=VARCHAR}",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}