package com.shirokumacafe.archetype.common;

import com.shirokumacafe.archetype.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 保存登录用户
 */
@Component
public class Users {

    public static final String SESSION_USER = "user_info";

    @Autowired
    private HttpSession session;

    public User getCurrentUser() {
        return (User) session.getAttribute(SESSION_USER);
    }

    public void setUser(User user) {
        session.setAttribute(SESSION_USER, user);
    }

    public void removeUser() {
        session.removeAttribute(SESSION_USER);
    }

}
