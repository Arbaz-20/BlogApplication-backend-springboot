package com.arbaz.blog.Repository;

import com.arbaz.blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value = "select * from user where name=?",nativeQuery = true)
    User findByUserName(@Param("") String name);
}
