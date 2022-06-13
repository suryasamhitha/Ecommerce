package com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.furniture.bean.AppUser;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	@Modifying(clearAutomatically=true)
	@Query("update AppUser u set u.password= :givenPassword where u.id= :givenId")
	int updatePassword(@Param("givenId")long Id, @Param("givenPassword")String newPassword);
	
}
