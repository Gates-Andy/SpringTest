package com.andy.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.andy.test.database.domain.Store;

@Mapper
public interface StoreRepository {

		// #3 store 테이블 모든 행 조회
	public List<Store> selectStoreList(); // mybatis의 도움을 받을거다
	
}
