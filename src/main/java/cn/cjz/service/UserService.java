package cn.cjz.service;

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

    public User findUserById(Integer userId) {
        return User
                .builder()
                .id(userId)
                .username("username of id:" + userId)
                .password("password of id: " + userId)
                .build();
    }

}
