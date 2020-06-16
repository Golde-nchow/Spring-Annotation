package cn.cjz.service;

import cn.cjz.annotation.ComplexLog;
import cn.cjz.annotation.Log;
import cn.cjz.model.User;
import org.springframework.stereotype.Service;

/**
 * @author: Kam-Chou
 * @date: 2020/6/15 23:14
 * @description: 用户业务类
 * @version: 1.0
 */
@Service
public class UserService {

    @Log("用户信息查询-2")
    public User findUserById(Integer userId) {
        return User
                .builder()
                .id(userId)
                .username("username of id:" + userId)
                .password("password of id: " + userId)
                .build();
    }

    @ComplexLog("用户查询信息-2")
    public User findUserById2(Integer userId) {
        return User
                .builder()
                .id(userId)
                .build();
    }

}
