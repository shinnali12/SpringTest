package com.shinnal.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shinnal.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
	
//	public List<Recruit> findAllByOrderByIdDesc();

	// 1.
//	public List<Recruit> findById(int id);
	
	// 2. WHERE `companyId` = #{}
	public List<Recruit> findByCompanyId(int companyId);
	
	// 3. WHERE `position` = #{} AND `type` = #{}
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// 4.  WHERE `type` = #{} OR `salary` >= #{}
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 5. WHERE `type` = #{} ORDER BY `salary` DESC
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 6. WHERE `region` = #{} AND `salary` BETWEEN #{} AND #{}
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	// 7.
	
	@Query(value="SELECT * FROM `recruit` WHERE `deadline` > :deadline AND `salary` >= :salary AND `type`= :type ORDER BY `salary` DESC", nativeQuery=true) // ":파라미터키" 입력하여 매칭되도록 하기!!!
	public List<Recruit> selectByNativeQuery(
			@Param("deadline") LocalDate deadline
			, @Param("salary") int salary
			, @Param("type") String type);
	
	
	
}
