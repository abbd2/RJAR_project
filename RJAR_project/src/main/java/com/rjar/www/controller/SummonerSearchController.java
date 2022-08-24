package com.rjar.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rjar.www.service.search.SummonerSearchMM;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SummonerSearchController {

	private SummonerSearchMM ssm;
	ModelAndView mav;

	@GetMapping(value = "/summonerSearch")
	public ModelAndView summonerSearch(String summonerName) {

		mav = new ModelAndView(); // mav 객체 생성
		log.info(summonerName); // 검색한 소환사 이름 콘솔에 출력
		ssm = new SummonerSearchMM();
		mav = ssm.sSummonerSearch(summonerName.replaceAll("\\s", "")); // 이름에 공백이 들어간경우 검색이되지 않아, 공백을 제거한 형태이다.

		mav.setViewName("summonerSearch"); // mav 객체에 이동할 뷰 이름 set

		return mav;
	}

}
