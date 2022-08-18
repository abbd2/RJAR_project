package com.rjar.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rjar.www.bean.Member;
import com.rjar.www.dao.IMemberDao;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {

	@Autowired
	private IMemberDao mDao;

	ModelAndView mav;

	// servlet-context.xml에서 해당 패키지 스캔
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String main(Model model) {

		return "home";
	}

	@GetMapping(value = "/championDetail")
	public String championDetail() {

		return "championDetail";
	}

	@GetMapping(value = "/summonerSearch")
	public ModelAndView summonerSearch(String summonerName) {

		System.out.println("검색한 소환사의 이름: " + summonerName);
		
		mav = new ModelAndView();
		mav.addObject("summonerName", summonerName);
		mav.setViewName("summonerSearch");

		return mav;
	}

	@GetMapping(value = "/laboratory")
	public String laboratory() {

		return "laboratory";
	}

	@GetMapping(value = "/multiSearch")
	public String multiSearch() {

		return "multiSearch";
	}

	@GetMapping(value = "/community")
	public String community() {

		return "community";
	}

	@GetMapping(value = "/lck")
	public String lck() {

		return "lck";
	}

}
