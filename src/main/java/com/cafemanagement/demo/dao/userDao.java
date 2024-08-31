package com.cafemanagement.demo.dao;

import com.cafemanagement.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDao extends JpaRepository<User,Integer> {
 User findByEmail(String email);

}
