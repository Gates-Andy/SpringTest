package com.andy.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {
	// 1
	public List<Favorite> selectFavoriteList();

	// 2
	public int insertFavoriteList(@Param("name")String name, @Param("url")String url);
	
	// 3
	public int selectCountByUrl(@Param("url") String url);

}