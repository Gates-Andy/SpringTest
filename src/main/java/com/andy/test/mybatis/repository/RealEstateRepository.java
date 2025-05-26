package com.andy.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
// select (xml parameterType int or map , resultType -> 엔티티클래스)
	//1
	public RealEstate selectRealEstate(@Param("id") int id);
	// mybatis기반 xml기반으로 조회를 하게 되면 한 행을 조회하고 저장하게되는 객체를 리턴타입으로 지정하려는데 그렇다면 entity가 좋겠다
	
	//2
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);
	
	//3
	public List<RealEstate> selectRealEstateByAreaAndPrice(@Param("area") int area, @Param("price") int price);
	// parametertype이 2개 이상일시 xml에 int 가 아닌 map이라고 적는다
	
// insert (xml parameterType -> 엔티티클래스, resultType이 없음)
	//4
	public int insertRealEstateByObject(RealEstate realEstate);
	
	//5
	public int insertRealEstate(@Param("realtorId") int realtorId, @Param("address") String address, @Param("area") int area, @Param("type") String type, @Param("price") int price, @Param("rentPrice") int rentPrice);
	
//update
	//6
	public int updateRealEstate(@Param("id") int id, @Param("type") String type, @Param("price") int price);
	
//delete
	//7
	public int deleteRealEstate(@Param("id") int id);
}