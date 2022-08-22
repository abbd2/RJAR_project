package com.rjar.www.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
		
		BufferedReader br = null;
		mav = new ModelAndView();
		String api_key = "RGAPI-4843ae9e-7ede-4140-8341-164bbda24a7b";
		String proFileUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName.replaceAll("\\s", "")
				+ "?api_key=" + api_key;
		
		String id = null;
		String puuid = null;
		String name = null;
		int profileIconId = 0;
		int summonerLevel = 0;
		
		try {
			// URL 객체 생성
			URL url = new URL(proFileUrl);
			// URL에서 URLConnection 객체 얻기(프로토콜이 http://인 경우 아래 객체로 캐스팅 가능)
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection(); // openConnection() 메서드는
																							// IOException 발생
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			System.out.println(br);

			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println(result);
			//json object를 추출하기 위해 json형태로 parser한다.
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			profileIconId = k.get("profileIconId").getAsInt();
			puuid = k.get("puuid").getAsString();
			summonerLevel = k.get("summonerLevel").getAsInt();
			id = k.get("id").getAsString();
			name = k.get("name").getAsString();
			
			System.out.println("puuid=" + puuid);
			System.out.println("LV=" + summonerLevel);		
				

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ssm = new SummonerSearchMM();
		mav = ssm.sSummonerSearch(id); //이름에 공백이 들어간경우 검색이되지 않아, 공백을 제거한 형태이다.
		mav.addObject("summonerName",name);
		mav.addObject("profileIconId",profileIconId);
		mav.addObject("LV", summonerLevel);		

		
		mav.setViewName("summonerSearch"); // mav 객체에 이동할 뷰 이름 set
		
		return mav;
	}

}
