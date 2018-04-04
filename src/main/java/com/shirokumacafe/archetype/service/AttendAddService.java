package com.shirokumacafe.archetype.service;

import com.shirokumacafe.archetype.entity.AttendAddr;
import com.shirokumacafe.archetype.entity.AttendAddrExample;
import com.shirokumacafe.archetype.repository.AttendAddrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * User: wrp
 * Date: 14-12-16
 * Time: 下午10:07
 * 上课地址
 */
@Service
@Transactional
public class AttendAddService {

    @Autowired
    private AttendAddrMapper attendAddrMapper;

    /**
     * 获取全部地址
     * @return
     */
    public List<AttendAddr> findAllAttendAddr(){
        return attendAddrMapper.selectByExample(null);
    }

    /**
     * 添加教学楼或教室
     * @param attendAddr
     */
    public void addAttendAddr(AttendAddr attendAddr){
        attendAddrMapper.insert(attendAddr);
    }

    /**
     *修改教学楼或教室
     * @param attendAddr
     */
    public void updateAttendAddr(AttendAddr attendAddr){
        attendAddrMapper.updateByPrimaryKeySelective(attendAddr);
    }

    /**
     *删除教学楼或教室
     * @param aaId
     */
    public AttendAddr deleteAttendAddr(Integer aaId){
        AttendAddr attendAddr = attendAddrMapper.selectByPrimaryKey(aaId);
        attendAddrMapper.deleteByPrimaryKey(aaId);
        return attendAddr;
    }

    /**
     * 根据父类ID找教室或教学楼
     * @param aaPid
     * @return
     */
    public List<AttendAddr> getAttendAddrByAaPid(Integer aaPid){
        AttendAddrExample example = new AttendAddrExample();
        AttendAddrExample.Criteria criteria = example.createCriteria();
        criteria.andAaPidEqualTo(aaPid);
        return attendAddrMapper.selectByExample(example);
    }

}
