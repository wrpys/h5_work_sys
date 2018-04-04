package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.entity.UserInfo;
import com.shirokumacafe.archetype.entity.UserInfoExample;
import com.shirokumacafe.archetype.repository.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 员工管理Service
 * @author lim
 */
@Component
@Transactional
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public Page<UserInfo> findUserInfoForPage(UserInfo userInfo,Page page){
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();

        List<UserInfo> rows = userInfoMapper.selectByExampleWithRowbounds(example,page.createRowBounds());
        Integer results = userInfoMapper.countByExample(example);
        page.setRows(rows);
        page.setResults(results);

        return page;
    }

    public void add(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    public void update(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    public void delete(List<Integer> ids) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserInfoIdIn(ids);
        userInfoMapper.deleteByExample(example);

    }

}
