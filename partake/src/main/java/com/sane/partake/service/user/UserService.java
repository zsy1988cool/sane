package com.sane.partake.service.user;

import com.sane.partake.dao.user.UserDao;
import com.sane.partake.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUserByNo(String userNo) throws Exception{
        return userDao.getUserByUserNo(userNo);
    }
}
