package com.github.zhou;

import java.util.List;

public interface UserMapper {
    List<User> queryUserBySchoolName(User user);

    List<User> queryUserById(User user);
}
