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
	
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		Map<String, String> favoriteMap = new HashMap<>();
		int count = favoriteService.addFavorite(name, url);
		
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
	
}
