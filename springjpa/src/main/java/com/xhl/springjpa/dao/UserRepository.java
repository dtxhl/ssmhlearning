package com.xhl.springjpa.dao;

import com.xhl.springjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);

    User findByAge(Integer age);

    User findByNameAndAge(String name,Integer age);

    List<User> findByNameLike(String name);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
