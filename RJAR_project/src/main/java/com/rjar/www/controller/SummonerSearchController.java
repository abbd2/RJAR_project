package com.rjar.www.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
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
		mav = ssm.sSummonerSearch(summonerName);
		
		mav.addObject("summonerName", summonerName); // mav 객체에 소환사 이름 add
		mav.setViewName("summonerSearch"); // mav 객체에 이동할 뷰 이름 set
		
		return mav;
	}

}
