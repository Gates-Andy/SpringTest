package com.andy.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.andy.test.database.domain.Store;

@Mapper //	이 인터페이스는 MyBatis Mapper입니다. 즉, 이 안의 메서드는 SQL 쿼리와 연결되어 실제 데이터베이스에서 값을 가져오거나 조작할 때 사용됩니다.
public interface StoreRepository {
	// #3 store 테이블 모든 행 조회
	public List<Store> selectStoreList(); // mybatis의 도움을 받을거다
	// 이 쿼리는 행이 여러 개 나올 수 있어요.
	//	그러니까 Java에서는 결과를 여러 개 담을 수 있는 컬렉션(List) 으로 받아야 합니다.
}
