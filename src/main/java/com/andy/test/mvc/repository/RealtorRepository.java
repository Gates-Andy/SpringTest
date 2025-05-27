package com.andy.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.andy.test.mvc.domain.Realtor;

@Mapper
public interface RealtorRepository {
	
	public int insertRealtor(Realtor realtor);
	
}
