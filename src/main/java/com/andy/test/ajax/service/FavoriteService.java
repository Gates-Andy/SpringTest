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

	// 3
	public boolean isDuplicateUrl(String url) {

		int count = favoriteRepository.selectCountByUrl(url); // 리포지터리에서 그 이메일이 검색이되면 1이 뜰거고 0이면 없다는 뜻일것

		if (count == 0) { // 0이라는 count는 이메일이 사용가능하다는 뜻

			return false;

		} else {

			return true;

		}
	}

	// 4
	public int deleteFavoriteById(int id) {
		
		return favoriteRepository.deleteFavoriteById(id);
		
	}
}