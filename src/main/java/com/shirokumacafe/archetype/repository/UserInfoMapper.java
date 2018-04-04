package com.shirokumacafe.archetype.repository;

import com.shirokumacafe.archetype.entity.UserInfo;
import com.shirokumacafe.archetype.entity.UserInfoExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserInfoMapper {
    @SelectProvider(type=UserInfoSqlProvider.class, method="countByExample")
    int countByExample(UserInfoExample example);

    @DeleteProvider(type=UserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserInfoExample example);

    @Delete({
        "delete from t_user_info",
        "where user_info_id = #{userInfoId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userInfoId);

    @Insert({
        "insert into t_user_info (user_info_id, user_id, ",
        "user_code, user_name, ",
        "user_dept, sex, idcard_address, ",
        "idcard, home_address, ",
        "tel, contact_tel, ",
        "contact_name, bank_dict, ",
        "bank_account, birthday, ",
        "postion_level_dict, salary, ",
        "postion_state, join_date, ",
        "leave_date, regular_date, ",
        "nation_dict, photo, ",
        "remark, postion_dict, ",
        "major_dict, education_dict, ",
        "graduate, polity, ",
        "qq, email, state)",
        "values (#{userInfoId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{userCode,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userDept,jdbcType=INTEGER}, #{sex,jdbcType=INTEGER}, #{idcardAddress,jdbcType=VARCHAR}, ",
        "#{idcard,jdbcType=VARCHAR}, #{homeAddress,jdbcType=VARCHAR}, ",
        "#{tel,jdbcType=VARCHAR}, #{contactTel,jdbcType=VARCHAR}, ",
        "#{contactName,jdbcType=VARCHAR}, #{bankDict,jdbcType=VARCHAR}, ",
        "#{bankAccount,jdbcType=VARCHAR}, #{birthday,jdbcType=VARCHAR}, ",
        "#{postionLevelDict,jdbcType=VARCHAR}, #{salary,jdbcType=DECIMAL}, ",
        "#{postionState,jdbcType=INTEGER}, #{joinDate,jdbcType=VARCHAR}, ",
        "#{leaveDate,jdbcType=VARCHAR}, #{regularDate,jdbcType=VARCHAR}, ",
        "#{nationDict,jdbcType=VARCHAR}, #{photo,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{postionDict,jdbcType=VARCHAR}, ",
        "#{majorDict,jdbcType=VARCHAR}, #{educationDict,jdbcType=VARCHAR}, ",
        "#{graduate,jdbcType=VARCHAR}, #{polity,jdbcType=VARCHAR}, ",
        "#{qq,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{state,jdbcType=INTEGER})"
    })
    int insert(UserInfo record);

    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(UserInfo record);

    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_info_id", property="userInfoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_dept", property="userDept", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="idcard_address", property="idcardAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="home_address", property="homeAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_tel", property="contactTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contactName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_dict", property="bankDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_level_dict", property="postionLevelDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.DECIMAL),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="nation_dict", property="nationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_dict", property="postionDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="major_dict", property="majorDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="education_dict", property="educationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    List<UserInfo> selectByExampleWithRowbounds(UserInfoExample example, RowBounds rowBounds);

    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_info_id", property="userInfoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_dept", property="userDept", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="idcard_address", property="idcardAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="home_address", property="homeAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_tel", property="contactTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contactName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_dict", property="bankDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_level_dict", property="postionLevelDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.DECIMAL),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="nation_dict", property="nationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_dict", property="postionDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="major_dict", property="majorDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="education_dict", property="educationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    List<UserInfo> selectByExample(UserInfoExample example);

    @Select({
        "select",
        "user_info_id, user_id, user_code, user_name, user_dept, sex, idcard_address, ",
        "idcard, home_address, tel, contact_tel, contact_name, bank_dict, bank_account, ",
        "birthday, postion_level_dict, salary, postion_state, join_date, leave_date, ",
        "regular_date, nation_dict, photo, remark, postion_dict, major_dict, education_dict, ",
        "graduate, polity, qq, email, state",
        "from t_user_info",
        "where user_info_id = #{userInfoId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_info_id", property="userInfoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_dept", property="userDept", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="idcard_address", property="idcardAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="home_address", property="homeAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_tel", property="contactTel", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contactName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_dict", property="bankDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_level_dict", property="postionLevelDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.DECIMAL),
        @Result(column="postion_state", property="postionState", jdbcType=JdbcType.INTEGER),
        @Result(column="join_date", property="joinDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="leave_date", property="leaveDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="regular_date", property="regularDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="nation_dict", property="nationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="postion_dict", property="postionDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="major_dict", property="majorDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="education_dict", property="educationDict", jdbcType=JdbcType.VARCHAR),
        @Result(column="graduate", property="graduate", jdbcType=JdbcType.VARCHAR),
        @Result(column="polity", property="polity", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    UserInfo selectByPrimaryKey(Integer userInfoId);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update t_user_info",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "user_code = #{userCode,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_dept = #{userDept,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=INTEGER},",
          "idcard_address = #{idcardAddress,jdbcType=VARCHAR},",
          "idcard = #{idcard,jdbcType=VARCHAR},",
          "home_address = #{homeAddress,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "contact_tel = #{contactTel,jdbcType=VARCHAR},",
          "contact_name = #{contactName,jdbcType=VARCHAR},",
          "bank_dict = #{bankDict,jdbcType=VARCHAR},",
          "bank_account = #{bankAccount,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=VARCHAR},",
          "postion_level_dict = #{postionLevelDict,jdbcType=VARCHAR},",
          "salary = #{salary,jdbcType=DECIMAL},",
          "postion_state = #{postionState,jdbcType=INTEGER},",
          "join_date = #{joinDate,jdbcType=VARCHAR},",
          "leave_date = #{leaveDate,jdbcType=VARCHAR},",
          "regular_date = #{regularDate,jdbcType=VARCHAR},",
          "nation_dict = #{nationDict,jdbcType=VARCHAR},",
          "photo = #{photo,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "postion_dict = #{postionDict,jdbcType=VARCHAR},",
          "major_dict = #{majorDict,jdbcType=VARCHAR},",
          "education_dict = #{educationDict,jdbcType=VARCHAR},",
          "graduate = #{graduate,jdbcType=VARCHAR},",
          "polity = #{polity,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER}",
        "where user_info_id = #{userInfoId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserInfo record);
}