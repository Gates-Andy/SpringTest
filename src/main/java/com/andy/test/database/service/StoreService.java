package com.andy.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.database.domain.Store;
import com.andy.test.database.repository.StoreRepository;

@Service
public class StoreService {

	// 직접관리하면 좋지만 의존성주입을 하여 리포지터리에서부터 객체를 가져올수있다 실제로는 싱글턴패턴
	@Autowired
	private StoreRepository storeRepository;

	// #2 가게 정보 목록 얻어 오기
	public List<Store> getStoreList() {
		// 기능
		List<Store> storeList = storeRepository.selectStoreList();
		// 여기서 한번 끊고!무조건 레퍼지토리를 하는게 아니라 목적이 명확하니 리턴된걸 그대로 리턴
		return storeList;
	}
}
