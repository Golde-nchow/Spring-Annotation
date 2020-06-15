package cn.cjz.web;

import cn.cjz.annotation.Log;
import cn.cjz.model.User;
import cn.cjz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kam-Chou
 * @date: 2020/6/15 22:57
 * @description: 注解控制器
 * @version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 通过ID获取对应的用户信息
     * @param id 用户的ID信息
     * @return   用户信息字符串
     */
    @Log("用户信息查询-1")
    @PostMapping("{id}")
    public User selectById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

}
