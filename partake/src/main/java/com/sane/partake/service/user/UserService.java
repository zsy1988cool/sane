package com.sane.partake.service.user;

import com.sane.partake.dao.user.UserDao;
import com.sane.partake.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUserByNo(String userNo) throws Exception{
        User user = userDao.findUserByUserNo(userNo);
        return user;
    }

    @Cacheable(value = "userInfo")
    public String getUserNameByNo(String userNo) throws Exception{
        User user = userDao.findUserByUserNo(userNo);
        return user.getUserName();
    }

    public List<User> findUserListByUserNameLike(String userName){
        List<User> users = userDao.findUserListByUserNameLike("%" + userName + "%");
        return users;
    }
}
