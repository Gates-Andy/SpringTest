package com.andy.test.mybatis.domain;

import java.time.LocalDateTime;

public class RealEstate {
	private int id;
	private int realtorId;
	private String address;
	private int area;
	private String type;
	private int price;
	private int rentPrice;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRealtorId() {
		return realtorId;
	}

	public void setRealtorId(int realtorId) {
		this.realtorId = realtorId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	// 우리가 사용하는 프레임워크에서 필요로하는 라이브러리니까 사용하는거다 라는걸 이해해야함
}
//⚙ 왜 이런 클래스가 필요한가?
//Spring + MyBatis 구조에서는 다음과 같은 이유로 필요합니다:
//
//쿼리 결과를 담을 객체가 필요 → MyBatis는 SQL 결과를 어떤 객체에 매핑할지 알아야 함
//
//비즈니스 로직 처리에 데이터 구조가 필요 → 서비스 계층에서 이 객체를 이용해 로직 구현
//
//클라이언트에 JSON으로 반환 → Controller에서 객체를 JSON으로 바꿔서 응답