package com.andy.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	public RealEstate selectRealEstate(@Param("id") int id);
	// mybatis기반 xml기반으로 조회를 하게 되면 한행을 조회하고 저장하게되는 객체를 리턴타입으로 지정 entity가 좋겠다

	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);

	public List<RealEstate> selectRealEstateByAreaAndPrice(@Param("area") int area, @Param("price") int price);
	
	public int insertRealEstateByObject(RealEstate realEstate);

}

//import com.andy.test.mybatis.domain.RealEstate;
//이 라인을 보면 RealEstate는 com.andy.test.mybatis.domain 패키지에 있는 클래스입니다.
//보통 이 클래스는 **DB 테이블 구조와 매핑되는 자바 객체(Entity or DTO)**입니다.
