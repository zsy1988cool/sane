package com.sane.partake.service.user;

import com.sane.partake.dao.user.UserDao;
import com.sane.partake.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired(required = false)
    StringRedisTemplate redisTemplate;

    public User getUserByNo(String userNo) throws Exception{
        User user = userDao.findUserByUserNo(userNo);
        return user;
    }

    public String getUserNameByNo(String userNo) throws Exception{
        Map<Object, Object> userInfoMap = redisTemplate.opsForHash().entries("userInfo");
        if(userInfoMap.containsKey(userNo)) {
            return (String)userInfoMap.get(userNo);
        }

        User user = userDao.findUserByUserNo(userNo);
        String userName = user.getUserName();
        redisTemplate.opsForHash().put("userInfo", userNo, userName);
        return userName;
    }
}
