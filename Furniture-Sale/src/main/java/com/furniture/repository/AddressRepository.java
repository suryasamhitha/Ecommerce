package com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.bean.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
