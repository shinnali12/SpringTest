package com.shinnal.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinnal.spring.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	// insert, select, delect 등의 기본적인 기능들만 미리 만들어서 불러올수 있게 함.

}
