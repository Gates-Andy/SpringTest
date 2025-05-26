package com.andy.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {
	//1
	public int insertSellerUser(
			@Param("nickname")String nickname, 
			@Param("temperature") double temperature, 
			@Param("profileImage") String profileImage); 
	//2
	public Seller selectLastSeller();
	//3
	public Seller selectSeller(@Param("id") int id);
	
}
