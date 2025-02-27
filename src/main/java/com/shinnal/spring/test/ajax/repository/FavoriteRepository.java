package com.shinnal.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shinnal.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {

	public int insertFavorite(@Param("name") String name
			, @Param("url") String url);
	
	public List<Favorite> selectFavorite();
	
	
	// 중복체크- 파라미터로 전달 -> 일치 갯수 조회
	
	public int selectCountUrl(@Param("url") String url);
	
	// 테이블 내용 삭제
	
	public int deleteFavorite(@Param("id") int id);
	
}
