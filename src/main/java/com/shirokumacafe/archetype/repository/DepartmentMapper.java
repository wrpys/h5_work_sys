package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Department;
import com.shirokumacafe.archetype.entity.DepartmentExample;
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

public interface DepartmentMapper {
    @SelectProvider(type=DepartmentSqlProvider.class, method="countByExample")
    int countByExample(DepartmentExample example);

    @DeleteProvider(type=DepartmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(DepartmentExample example);

    @Delete({
        "delete from t_department",
        "where d_id = #{dId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer dId);

    @Insert({
        "insert into t_department (leaf, d_name, ",
        "d_pid)",
        "values (#{leaf,jdbcType=BIT}, #{dName,jdbcType=VARCHAR}, ",
        "#{dPid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="dId", before=false, resultType=Integer.class)
    int insert(Department record);

    @InsertProvider(type=DepartmentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="dId", before=false, resultType=Integer.class)
    int insertSelective(Department record);

    @SelectProvider(type=DepartmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="d_id", property="dId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="leaf", property="leaf", jdbcType=JdbcType.BIT),
        @Result(column="d_name", property="dName", jdbcType=JdbcType.VARCHAR),
        @Result(column="d_pid", property="dPid", jdbcType=JdbcType.INTEGER)
    })
    List<Department> selectByExampleWithRowbounds(DepartmentExample example, RowBounds rowBounds);

    @SelectProvider(type=DepartmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="d_id", property="dId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="leaf", property="leaf", jdbcType=JdbcType.BIT),
        @Result(column="d_name", property="dName", jdbcType=JdbcType.VARCHAR),
        @Result(column="d_pid", property="dPid", jdbcType=JdbcType.INTEGER)
    })
    List<Department> selectByExample(DepartmentExample example);

    @Select({
        "select",
        "d_id, leaf, d_name, d_pid",
        "from t_department",
        "where d_id = #{dId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="d_id", property="dId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="leaf", property="leaf", jdbcType=JdbcType.BIT),
        @Result(column="d_name", property="dName", jdbcType=JdbcType.VARCHAR),
        @Result(column="d_pid", property="dPid", jdbcType=JdbcType.INTEGER)
    })
    Department selectByPrimaryKey(Integer dId);

    @UpdateProvider(type=DepartmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    @UpdateProvider(type=DepartmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    @UpdateProvider(type=DepartmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Department record);

    @Update({
        "update t_department",
        "set leaf = #{leaf,jdbcType=BIT},",
          "d_name = #{dName,jdbcType=VARCHAR},",
          "d_pid = #{dPid,jdbcType=INTEGER}",
        "where d_id = #{dId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Department record);
}