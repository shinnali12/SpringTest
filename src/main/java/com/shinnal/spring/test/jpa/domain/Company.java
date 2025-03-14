package com.shinnal.spring.test.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor // 모든 데이터의 생성자
@Getter
@Table(name="`company`")
@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String business;
	private String scale;
	private int headcount;
	
	@Column(name="createdAt") // '-' 가 들어가있는 데이터에!!
	@CreationTimestamp
	LocalDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	LocalDateTime updatedAt;


}
