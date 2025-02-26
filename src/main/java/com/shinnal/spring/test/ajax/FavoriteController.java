package com.shinnal.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnal.spring.test.ajax.domain.Favorite;
import com.shinnal.spring.test.ajax.service.FavoriteService;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;
	
	// 사이트 이름과 URL을 전달받고 저장하는 API
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		
		int count = favoriteService.addFavorite(name, url);
		
		// 성공 {"result":"success"} ;  실패 {"result":"fail"}
		
		Map<String, String> favoriteMap = new HashMap<>();
		if(count == 1) {
			favoriteMap.put("result", "success");
		} else {
			favoriteMap.put("result", "fail");
		}
		
		return favoriteMap;
		
//		return "redirect:/ajax/favorite/info"; 	
		
	}
	
	@GetMapping("/input")
	public String favoriteInput() {
		return "ajax/FavoriteInput";		
	}
	
	@GetMapping("/info")
	public String favoriteInfo(Model model) {
		
		List<Favorite> favorite = favoriteService.getFavorite();
		
		model.addAttribute("favorite", favorite);
		
		return "ajax/FavoriteInfo";
	}
	
	
	// 중복체크
	
	@ResponseBody
	@GetMapping("/duplicate-url")
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		boolean isDuplicate = favoriteService.isDuplicateUrl(url);
		
		Map<String, Boolean> duplicateMap = new HashMap<>();
		
		if(isDuplicate) { // 중복됨
			duplicateMap.put("isDuplicate", true);
		} else { // 중복안됨
			duplicateMap.put("isDuplicate", false);
		}
		
		return duplicateMap;	
		
	}
	
	
	
}
