package com.andy.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.database.domain.Store;
import com.andy.test.database.repository.StoreRepository;

@Service
public class StoreService {

	// 직접관리하면 좋지만 의존성주입을 하여 리포지터리에서부터 객체를 가져올수있다 
	// 실제로는 싱글턴(Singleton)패턴
	// 싱글턴 패턴이란? 1. 애플리케이션이 실행될 때 2. 하나의 인스턴스만 생성해서 계속 공유하는 패턴
	
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
//✅ 질문 1: "애플리케이션이 실행된다"는 건 무슨 뜻?
//우리가 만든 Java 프로그램(Spring Boot 웹 애플리케이션 등)이 실행되면, JVM(Java 가상 머신) 위에서 돌아갑니다.

//그때 클래스가 로딩되고, 빈(bean)들이 만들어지고, 서버가 켜지고, 요청을 받을 준비가 되는 상태를 말합니다.

//예를 들어 Spring Boot를 실행하면:

//Tomcat started on port(s): 8080
//Started MyApplication in 2.345 seconds → 이게 **"애플리케이션이 실행되었다"**는 상태예요.

//✅ 질문 2: "하나의 인스턴스만 생성해서 공유"는 무슨 뜻?

//보통 new 키워드를 사용하면 객체를 여러 번 만들 수 있어요:

//Store s1 = new Store();
//Store s2 = new Store();
//→ 이건 서로 다른 객체 (다른 메모리 주소) 에요.

//하지만 싱글턴 패턴은 이렇게 합니다:
//Store store1 = Store.getInstance();
//Store store2 = Store.getInstance();
//→ 이건 항상 같은 객체를 반환합니다.
//즉, store1 == store2는 true가 됩니다!