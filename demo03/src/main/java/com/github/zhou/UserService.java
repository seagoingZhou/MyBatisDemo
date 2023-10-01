package com.github.zhou;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class UserService {

    private final String resource = "mybatis-config.xml";

    public List<User> queryUserBySchoolName(String schoolName) {
        // 组建查询参数
        User userParam = new User();
        userParam.setSchoolName(schoolName);
        return queryUser(userParam);
    }

    private List<User> queryUser(User userParam) {
        List<User> userList = Collections.EMPTY_LIST;
        // 第一阶段：MyBatis的初始化阶段
        // 得到配置文件的输入流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return userList;
        }
        // 得到SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // 第二阶段：数据读写阶段
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 找到接口对应的实现
            UserMapper userMapper = session.getMapper(UserMapper.class);
            // 调用接口展开数据库操作
            userList =  userMapper.queryUserBySchoolName(userParam);
        }
        return userList;
    }
}
