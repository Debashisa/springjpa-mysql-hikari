package com.deba.jpahibernatemysql.springjpahibernatemysql.repository;

import com.deba.jpahibernatemysql.springjpahibernatemysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.id= ?1")
    User findUserByID(long id);

}
