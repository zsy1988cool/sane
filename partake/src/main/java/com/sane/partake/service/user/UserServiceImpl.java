package com.sane.partake.service.user;

import com.sane.partake.dao.user.UserDao;
import com.sane.partake.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getUserByNo(String userNo) {
        User user = userDao.findUserByUserNo(userNo);
        return user;
    }

    @Override
    @Cacheable(value = "userInfo")
    public String getUserNameByNo(String userNo) {
        User user = userDao.findUserByUserNo(userNo);
        return user.getUserName();
    }

    @Override
    public List<User> findUserListByUserNameLike(String userName){
        List<User> users = userDao.findUserListByUserNameLike("%" + userName + "%");
        return users;
    }
}
