package com.sane.partake.dao.user;

import com.sane.partake.entity.user.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, String> {
    User findUserByUserNo(String userNo);

    List<User> findUserListByUserNameLike(String userName);
}
