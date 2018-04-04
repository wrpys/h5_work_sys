package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.Work;
import com.shirokumacafe.archetype.entity.WorkExample;
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

public interface WorkMapper {
    @SelectProvider(type=WorkSqlProvider.class, method="countByExample")
    int countByExample(WorkExample example);

    @DeleteProvider(type=WorkSqlProvider.class, method="deleteByExample")
    int deleteByExample(WorkExample example);

    @Delete({
        "delete from t_work",
        "where w_id = #{wId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer wId);

    @Insert({
        "insert into t_work (c_id, c_name, ",
        "w_add_time, w_desc)",
        "values (#{cId,jdbcType=INTEGER}, #{cName,jdbcType=VARCHAR}, ",
        "#{wAddTime,jdbcType=TIMESTAMP}, #{wDesc,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="wId", before=false, resultType=Integer.class)
    int insert(Work record);

    @InsertProvider(type=WorkSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="wId", before=false, resultType=Integer.class)
    int insertSelective(Work record);

    @SelectProvider(type=WorkSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="w_id", property="wId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="w_add_time", property="wAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="w_desc", property="wDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<Work> selectByExampleWithRowbounds(WorkExample example, RowBounds rowBounds);

    @SelectProvider(type=WorkSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="w_id", property="wId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="w_add_time", property="wAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="w_desc", property="wDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<Work> selectByExample(WorkExample example);

    @Select({
        "select",
        "w_id, c_id, c_name, w_add_time, w_desc",
        "from t_work",
        "where w_id = #{wId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="w_id", property="wId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="w_add_time", property="wAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="w_desc", property="wDesc", jdbcType=JdbcType.VARCHAR)
    })
    Work selectByPrimaryKey(Integer wId);

    @UpdateProvider(type=WorkSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    @UpdateProvider(type=WorkSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    @UpdateProvider(type=WorkSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Work record);

    @Update({
        "update t_work",
        "set c_id = #{cId,jdbcType=INTEGER},",
          "c_name = #{cName,jdbcType=VARCHAR},",
          "w_add_time = #{wAddTime,jdbcType=TIMESTAMP},",
          "w_desc = #{wDesc,jdbcType=VARCHAR}",
        "where w_id = #{wId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Work record);
}