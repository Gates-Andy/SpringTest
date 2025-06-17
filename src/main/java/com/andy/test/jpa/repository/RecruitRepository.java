package com.andy.test.jpa.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andy.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	// 1
	public Optional<Recruit> findById(int id);

	// 2
	public List<Recruit> findByRecruitId(int recruitId);

	// 3 SELECT count(*) FROM `recruit` WHERE `position` = '웹 back-end 개발자' AND
	// `type` = '정규직';
	public List<Recruit> findByPositionAndType(String position, String type);

	// 4
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);

	// 5 FROM `recruit` WHERE `Type` = '계약직' ORDER BY `Salary` DESC LIMIT 3;
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);

	// 6 Where `region` = #{} AND salary >= #{} AND salary <= #{}
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);

	// 7 쿼리문으로 작성 mybatis xml 을 사용하는게 아니라.. 공백도 중요
	@Query(value = "SELECT * FROM `recruit_information` " 
			+ "WHERE `deadline` > :deadline " 
			+ "AND `salary` >= :salary "
			+ "AND `type` = :type " 
			+ "ORDER BY `salary` DESC", nativeQuery = true)
	List<Recruit> selectByQuery(
			@Param("deadline") LocalDateTime deadline
			, @Param("salary") int salary,
			@Param("type") String type);
}
