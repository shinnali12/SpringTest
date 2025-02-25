package com.shinnal.spring.test.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createFavorite(@RequestParam("name") String name
			, @RequestParam("url") String url) {
			
				
		int count = favoriteService.addFavorite(name, url);
		
		Map<String, String> favoriteMap = new HashMap<>();
		
		if(count == 1) {
			favoriteMap.put("result", "success");
		} else {
			favoriteMap.put("result", "fail");
		}
		
		return favoriteMap;
	}
	
	@GetMapping("/input")
	public String favoriteInput() {
		return "ajax/FavoriteInput";		
	}
	
}
