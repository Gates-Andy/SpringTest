package com.andy.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.test.database.domain.Store;
import com.andy.test.database.service.StoreService;

@Controller
public class StoreController {
	// 여기서도 서비스 기능을 직접 관리하면 좋지만 의존성주입을 하여 리포지터리에서부터 객체를 가져올수있다 실제로는 싱글턴패턴
	@Autowired
	private StoreService storeService;

	// #1 가게 정보를 모두 response에 담는다
	@RequestMapping("/db/store/list") 
	@ResponseBody
	public List<Store> storeList() {
		// 가게 정보 목록 얻어 오기
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
	}
}
