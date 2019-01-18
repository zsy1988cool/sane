package com.sane.partake.dao.user;

import com.sane.partake.entity.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    private EntityManager entityManage;

    public User getUserByUserNo(String userNo) throws Exception{
        return entityManage.find(User.class, userNo);
    }

    public String getUserNameByUserNo(String userNo) throws Exception {
        User user = getUserByUserNo(userNo);
        return user.getUserName();
    }
}
