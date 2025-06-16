package com.andy.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andy.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer>{ // 해당하는 테이블에 프라이머리 키

}
