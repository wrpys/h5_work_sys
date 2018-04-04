package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.StudentJsp;
import com.shirokumacafe.archetype.entity.StudentJspExample;
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

public interface StudentJspMapper {
    @SelectProvider(type=StudentJspSqlProvider.class, method="countByExample")
    int countByExample(StudentJspExample example);

    @DeleteProvider(type=StudentJspSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentJspExample example);

    @Delete({
        "delete from t_student_jsp",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sId);

    @Insert({
        "insert into t_student_jsp (s_no, s_name, ",
        "s_sex)",
        "values (#{sNo,jdbcType=VARCHAR}, #{sName,jdbcType=VARCHAR}, ",
        "#{sSex,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="sId", before=false, resultType=Integer.class)
    int insert(StudentJsp record);

    @InsertProvider(type=StudentJspSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="sId", before=false, resultType=Integer.class)
    int insertSelective(StudentJsp record);

    @SelectProvider(type=StudentJspSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_sex", property="sSex", jdbcType=JdbcType.BIT)
    })
    List<StudentJsp> selectByExampleWithRowbounds(StudentJspExample example, RowBounds rowBounds);

    @SelectProvider(type=StudentJspSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_sex", property="sSex", jdbcType=JdbcType.BIT)
    })
    List<StudentJsp> selectByExample(StudentJspExample example);

    @Select({
        "select",
        "s_id, s_no, s_name, s_sex",
        "from t_student_jsp",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_no", property="sNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="s_sex", property="sSex", jdbcType=JdbcType.BIT)
    })
    StudentJsp selectByPrimaryKey(Integer sId);

    @UpdateProvider(type=StudentJspSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentJsp record, @Param("example") StudentJspExample example);

    @UpdateProvider(type=StudentJspSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudentJsp record, @Param("example") StudentJspExample example);

    @UpdateProvider(type=StudentJspSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudentJsp record);

    @Update({
        "update t_student_jsp",
        "set s_no = #{sNo,jdbcType=VARCHAR},",
          "s_name = #{sName,jdbcType=VARCHAR},",
          "s_sex = #{sSex,jdbcType=BIT}",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentJsp record);
}