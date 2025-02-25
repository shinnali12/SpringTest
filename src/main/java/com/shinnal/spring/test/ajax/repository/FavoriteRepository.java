package com.shinnal.spring.test.ajax.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoriteRepository {

	public int insertFavorite(@Param("name") String name
			, @Param("url") String url);
	
}
