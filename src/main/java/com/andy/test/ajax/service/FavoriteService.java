package com.andy.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.ajax.domain.Favorite;
import com.andy.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;

	// 1
	public List<Favorite> getFavoriteList() {

		List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();

		return favoriteList;

	}
	// 2
	public int addFavorite(String name, String url) {
		
		int count = favoriteRepository.insertFavoriteList(name, url);
		
		return count;
	}
	
	

}