package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.WorkInfo;
import com.shirokumacafe.archetype.entity.WorkInfoExample;
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

public interface WorkInfoMapper {
    @SelectProvider(type=WorkInfoSqlProvider.class, method="countByExample")
    int countByExample(WorkInfoExample example);

    @DeleteProvider(type=WorkInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(WorkInfoExample example);

    @Delete({
        "delete from t_work_info",
        "where wi_id = #{wiId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer wiId);

    @Insert({
        "insert into t_work_info (w_id, s_id, ",
        "wi_add_time, wi_file_name, ",
        "wi_file_addr, wi_file_size, ",
        "w_i_desc)",
        "values (#{wId,jdbcType=INTEGER}, #{sId,jdbcType=INTEGER}, ",
        "#{wiAddTime,jdbcType=TIMESTAMP}, #{wiFileName,jdbcType=VARCHAR}, ",
        "#{wiFileAddr,jdbcType=VARCHAR}, #{wiFileSize,jdbcType=INTEGER}, ",
        "#{wIDesc,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="wiId", before=false, resultType=Integer.class)
    int insert(WorkInfo record);

    @InsertProvider(type=WorkInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="wiId", before=false, resultType=Integer.class)
    int insertSelective(WorkInfo record);

    @SelectProvider(type=WorkInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="wi_id", property="wiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="w_id", property="wId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="wi_add_time", property="wiAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="wi_file_name", property="wiFileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="wi_file_addr", property="wiFileAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="wi_file_size", property="wiFileSize", jdbcType=JdbcType.INTEGER),
        @Result(column="w_i_desc", property="wIDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<WorkInfo> selectByExampleWithRowbounds(WorkInfoExample example, RowBounds rowBounds);

    @SelectProvider(type=WorkInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="wi_id", property="wiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="w_id", property="wId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="wi_add_time", property="wiAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="wi_file_name", property="wiFileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="wi_file_addr", property="wiFileAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="wi_file_size", property="wiFileSize", jdbcType=JdbcType.INTEGER),
        @Result(column="w_i_desc", property="wIDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<WorkInfo> selectByExample(WorkInfoExample example);

    @Select({
        "select",
        "wi_id, w_id, s_id, wi_add_time, wi_file_name, wi_file_addr, wi_file_size, w_i_desc",
        "from t_work_info",
        "where wi_id = #{wiId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="wi_id", property="wiId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="w_id", property="wId", jdbcType=JdbcType.INTEGER),
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER),
        @Result(column="wi_add_time", property="wiAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="wi_file_name", property="wiFileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="wi_file_addr", property="wiFileAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="wi_file_size", property="wiFileSize", jdbcType=JdbcType.INTEGER),
        @Result(column="w_i_desc", property="wIDesc", jdbcType=JdbcType.VARCHAR)
    })
    WorkInfo selectByPrimaryKey(Integer wiId);

    @UpdateProvider(type=WorkInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    @UpdateProvider(type=WorkInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WorkInfo record, @Param("example") WorkInfoExample example);

    @UpdateProvider(type=WorkInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WorkInfo record);

    @Update({
        "update t_work_info",
        "set w_id = #{wId,jdbcType=INTEGER},",
          "s_id = #{sId,jdbcType=INTEGER},",
          "wi_add_time = #{wiAddTime,jdbcType=TIMESTAMP},",
          "wi_file_name = #{wiFileName,jdbcType=VARCHAR},",
          "wi_file_addr = #{wiFileAddr,jdbcType=VARCHAR},",
          "wi_file_size = #{wiFileSize,jdbcType=INTEGER},",
          "w_i_desc = #{wIDesc,jdbcType=VARCHAR}",
        "where wi_id = #{wiId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WorkInfo record);
}