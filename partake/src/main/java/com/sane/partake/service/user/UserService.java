package com.sane.partake.service.user;

import com.sane.partake.entity.user.User;
import java.util.List;

public interface UserService {

    public User getUserByNo(String userNo);

    public String getUserNameByNo(String userNo);

    public List<User> findUserListByUserNameLike(String userName);
}
