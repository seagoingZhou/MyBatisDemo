package com.github.zhou;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        UserService userService = new UserService();
        String schoolName = "Sunny School";
        // 调用接口展开数据库操作
        List<User> userList =  userService.queryUserBySchoolName(schoolName);
        // 打印查询结果
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }


}
