package com.rjar.www.service.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.rjar.www.bean.summonersearch.GameDetailShowInfo;
import com.rjar.www.bean.summonersearch.LeftPageChampionDetails;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class SummonerSearchMM {
	// 전적 검색에 필요한 데이터를 API로 받아오기

	@Autowired
	private LeftPageChampionDetails cd;

	@Autowired
	private GameDetailShowInfo gd;

	ModelAndView mav;

	public void sSummonerSearch(String summonerName) {

		log.info("소환사 이름: " + summonerName);

		// 개인 권한 API
		String api_key = "RGAPI-4843ae9e-7ede-4140-8341-164bbda24a7b";

		// 하나의 전적 div 생성
//		showGameInfo

//		return
	}
	
	public void getRawData() {
		
	}

	// 계산이 필요한 데이터 처리
	public ModelAndView sSummonerSearchCal() {

		mav = new ModelAndView();

		return mav;
	}

}
