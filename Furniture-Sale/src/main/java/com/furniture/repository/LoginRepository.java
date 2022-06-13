package com.furniture.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.furniture.bean.User;


@Repository
public interface LoginRepository extends JpaRepository<User,Integer> {

 @Modifying(clearAutomatically=true)
 
//@Query("update User u set u.password= :givenPassword where u.loginId= :givenId")
//void updatePassword(@Param("givenId")String LoginId, @Param("givenPassword")String newPassword);
User findById(long id);
}
