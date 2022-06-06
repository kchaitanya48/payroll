package com.yasisv.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yasisv.payroll.entity.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer>{

}
