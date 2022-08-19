package com.rjar.www.service.search;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

	public ModelAndView sSummonerSearch(String summonerName) {

		log.info("소환사 이름: " + summonerName);
		BufferedReader br = null;
		String view = null;
		mav = new ModelAndView();
		String api_key = "RGAPI-4843ae9e-7ede-4140-8341-164bbda24a7b";
		String proFileUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName
				+ "?api_key=" + api_key;
		System.out.println(proFileUrl);

		// 개인 권한 API
		try {
			// URL 객체 생성
			URL url1 = new URL(proFileUrl);
			// URL에서 URLConnection 객체 얻기(프로토콜이 http://인 경우 아래 객체로 캐스팅 가능)
			HttpURLConnection urlconnection = (HttpURLConnection) url1.openConnection(); // openConnection() 메서드는
																							// IOException 발생
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result += line;
			}

			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			int profileIconId = k.get("profileIconId").getAsInt();
			String name = k.get("name").getAsString();
			String puuid = k.get("puuid").getAsString();
			long summonerLevel = k.get("summonerLevel").getAsLong();
			// long revisionDate = k.get("revisionDate").getAsLong();
			String id = k.get("id").getAsString();
			// String accountId = k.get("accountId").getAsString();
			System.out.println("name=" + name);
			System.out.println("puuid=" + puuid);
			System.out.println("LV=" + summonerLevel);
			System.out.println("id=" + id);
			mav.setViewName("summonerSearch");
			mav.addObject("id", id);
			mav.addObject("name", name);
			mav.addObject("puuid", puuid);
			mav.addObject("LV", summonerLevel);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mav;

//		String tierUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+s_id+"?api_key="+api_key;

	}

	public void getRawData() {

	}

	// 계산이 필요한 데이터 처리
	public ModelAndView sSummonerSearchCal() {

		mav = new ModelAndView();

		return mav;
	}

}
