package com.andy.test.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.ajax.domain.Favorite;
import com.andy.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public int addFavorite(Favorite favorite) {
    	
        return favoriteRepository.insertFavorite(favorite); 
        
    }
    
}