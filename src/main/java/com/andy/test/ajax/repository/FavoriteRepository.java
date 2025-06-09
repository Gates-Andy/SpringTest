package com.andy.test.ajax.repository;

import org.apache.ibatis.annotations.Mapper;

import com.andy.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {

	int insertFavorite(Favorite favorite);

}