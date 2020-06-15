package cn.cjz.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author: Kam-Chou
 * @date: 2020/6/15 23:15
 * @description: 用户实体类
 * @version: 1.0
 */
@Data
@ToString
@Builder
public class User {

    private Integer id;

    private String username;

    private String password;

}
