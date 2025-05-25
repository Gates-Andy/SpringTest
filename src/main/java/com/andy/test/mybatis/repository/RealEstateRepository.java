package com.andy.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
// select
	public RealEstate selectRealEstate(@Param("id") int id);
	// mybatis기반 xml기반으로 조회를 하게 되면 한 행을 조회하고 저장하게되는 객체를 리턴타입으로 지정하려는데 그렇다면 entity가 좋겠다

	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);

	public List<RealEstate> selectRealEstateByAreaAndPrice(@Param("area") int area, @Param("price") int price);
	// parametertype이 2개 이상일시 xml에 int 가 아닌 map이라고 적는다
// insert 
	public int insertRealEstateByObject(RealEstate realEstate);

	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	public int updateRealEstate(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price
			);
	
	public int deleteRealEstate(
			@Param("id") int id
			);
}

//import com.andy.test.mybatis.domain.RealEstate;
//이 라인을 보면 RealEstate는 com.andy.test.mybatis.domain 패키지에 있는 클래스입니다.
//보통 이 클래스는 **DB 테이블 구조와 매핑되는 자바 객체(Entity or DTO)**입니다.
