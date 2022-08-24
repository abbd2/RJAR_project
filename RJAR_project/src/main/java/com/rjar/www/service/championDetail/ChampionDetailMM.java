package com.rjar.www.service.championDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.rjar.www.dao.IchampionDao;
import com.rjar.www.service.bean.championDetail.Champion;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ChampionDetailMM {
	
	@Autowired
	private IchampionDao champDao;
	
	ModelAndView mav;

	public ModelAndView getChampionInfo(String tier, String lane) {
		log.info("tier="+tier);
		log.info("lane="+lane);
		
		//챔피언이름(영어,한글) , 챔피언ID 받아오는 부분
		List<Champion> NameIdList = champDao.getChampionList(tier);
		
		List<Champion> winRate = null;
		List<Champion> pickRate = null;
		List<Champion> banRate = null;
		for (Champion champion: NameIdList) {
			winRate = champDao.getwinRate(champion.getChampId(), tier);
		}
		
		
		mav.addObject("NameIdList", NameIdList);
		return mav;
	}
	
	
	
	
}
