package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.AttendAddr;
import com.shirokumacafe.archetype.entity.AttendAddrExample;
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

public interface AttendAddrMapper {
    @SelectProvider(type=AttendAddrSqlProvider.class, method="countByExample")
    int countByExample(AttendAddrExample example);

    @DeleteProvider(type=AttendAddrSqlProvider.class, method="deleteByExample")
    int deleteByExample(AttendAddrExample example);

    @Delete({
        "delete from t_attend_addr",
        "where aa_id = #{aaId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer aaId);

    @Insert({
        "insert into t_attend_addr (aa_name, aa_pid)",
        "values (#{aaName,jdbcType=VARCHAR}, #{aaPid,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="aaId", before=false, resultType=Integer.class)
    int insert(AttendAddr record);

    @InsertProvider(type=AttendAddrSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT @@IDENTITY", keyProperty="aaId", before=false, resultType=Integer.class)
    int insertSelective(AttendAddr record);

    @SelectProvider(type=AttendAddrSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="aa_id", property="aaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="aa_name", property="aaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="aa_pid", property="aaPid", jdbcType=JdbcType.INTEGER)
    })
    List<AttendAddr> selectByExampleWithRowbounds(AttendAddrExample example, RowBounds rowBounds);

    @SelectProvider(type=AttendAddrSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="aa_id", property="aaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="aa_name", property="aaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="aa_pid", property="aaPid", jdbcType=JdbcType.INTEGER)
    })
    List<AttendAddr> selectByExample(AttendAddrExample example);

    @Select({
        "select",
        "aa_id, aa_name, aa_pid",
        "from t_attend_addr",
        "where aa_id = #{aaId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="aa_id", property="aaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="aa_name", property="aaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="aa_pid", property="aaPid", jdbcType=JdbcType.INTEGER)
    })
    AttendAddr selectByPrimaryKey(Integer aaId);

    @UpdateProvider(type=AttendAddrSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AttendAddr record, @Param("example") AttendAddrExample example);

    @UpdateProvider(type=AttendAddrSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AttendAddr record, @Param("example") AttendAddrExample example);

    @UpdateProvider(type=AttendAddrSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AttendAddr record);

    @Update({
        "update t_attend_addr",
        "set aa_name = #{aaName,jdbcType=VARCHAR},",
          "aa_pid = #{aaPid,jdbcType=INTEGER}",
        "where aa_id = #{aaId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AttendAddr record);
}