package com.andy.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.andy.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {
	public Seller selectSellerUser(); 
}
