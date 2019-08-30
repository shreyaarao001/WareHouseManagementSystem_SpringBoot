package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.CustomerInfo;


public interface CustomerInterface extends CrudRepository<CustomerInfo,Integer>{

}
