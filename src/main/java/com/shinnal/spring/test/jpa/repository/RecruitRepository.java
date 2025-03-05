package com.shinnal.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shinnal.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	
//	public List<Recruit> findAllByOrderByIdDesc();

	// 1.
	public List<Recruit> findById(int id);
	
	// 2.
	public List<Recruit> findByCompanyId(int companyId);
	
	// 3.
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// 4. 
	public List<Recruit> findByTypeOrSalaryGreaterThan(String type, int salary);
	
	// 5.
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 6. 
	
	public List<Recruit> findByRegionAndSalaryBetween(String region, int Start, int end);
	
	// 7.
	
	@Query(value="SELECT * FROM `recruit` "
			+ "WHERE `deadline` > '2026-04-10' AND `salary` >= 8100 AND `type` = '정규직' ORDER BY `salary` DESC =:deadline, salary, type", nativeQuery=true)
	public List<Recruit> selectByDeadlineAndSalaryAndType(
			@Param("deadline") String deadline
			, @Param("salary")String salary
			, @Param("type")String type);
	
	
	
}
