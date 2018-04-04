
package com.shirokumacafe.archetype.web;


import com.shirokumacafe.archetype.common.mybatis.Page;
import com.shirokumacafe.archetype.common.utilities.Responses;
import com.shirokumacafe.archetype.entity.UserInfo;
import com.shirokumacafe.archetype.service.UserInfoService;
import com.shirokumacafe.archetype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用户管理Controller
 *
 * 员工即是没有LoginName与PassWord的UserInfo(employee)，允许未来跟User联动登录系统
 * @author Lim
 */
@Controller
@RequestMapping(value = "/userInfo")
class UserInfoController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping
    public String to(Model model){
//        List<Role> roles = roleService.findRoleForList();
//        model.addAttribute("roles", Responses.writeJson(roles));
        return "userInfo";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public String list(UserInfo userInfo,Page page){
        Page<UserInfo> userInfos = userInfoService.findUserInfoForPage(userInfo, page);
        return Responses.writeJson(userInfos);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(UserInfo userInfo){
        userInfoService.add(userInfo);
     return Responses.writeSuccess();
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map update(UserInfo userInfo){
        userInfoService.update(userInfo);
        return Responses.writeSuccess();
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map delete(@RequestParam(value = "ids") List<Integer> ids){
        userInfoService.delete(ids);
        return Responses.writeSuccess();
    }


}



