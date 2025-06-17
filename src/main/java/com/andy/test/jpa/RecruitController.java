package com.andy.test.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.test.jpa.domain.Recruit;
import com.andy.test.jpa.repository.RecruitRepository;

@Controller
@RequestMapping("/jpa")
public class RecruitController {
	@Autowired
	private RecruitRepository recruitRepository;

	// 1. id 가 8인 행 조회
	@ResponseBody
	@GetMapping("/find1")
	public Recruit find1() {
		
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);

		Recruit recruit = optionalRecruit.get();
		
		return recruit;
	}

	// 2. company id parameter 조회
	@ResponseBody
	@GetMapping("/find2")
	public List<Recruit> find2(@RequestParam("recruitId") int recruitId) {

		List<Recruit> recruitList = recruitRepository.findByRecruitId(recruitId);

		return recruitList;
	}

	// 3.웹 back-end 개발자 이고(AND) 정규직인 공고를 조회하고 아래와 같이 출력하세요.
	@ResponseBody
	@GetMapping("/find3")
	public List<Recruit> find3() {

		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");

	}

	// 4.정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
	@ResponseBody
	@GetMapping("/find4")
	public List<Recruit> find4() {

		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);

	}

	// 5. 정렬 제한 조건 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
	@ResponseBody
	@GetMapping("/find5")
	public List<Recruit> find5() {

		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");

	}
	
	// 6. 범위 조회 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
	@ResponseBody
	@GetMapping("/find6")
	public List<Recruit> find6(){
		
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	//7. 쿼리
	@ResponseBody
	@GetMapping("find7")
	public List<Recruit> find7(){
		
		return recruitRepository.selectByQuery(LocalDateTime.of(2026, 4, 10, 0, 0), 8100, "정규직");
	}
}
