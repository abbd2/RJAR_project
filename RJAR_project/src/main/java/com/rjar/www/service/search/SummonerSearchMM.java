package com.rjar.www.service.search;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class SummonerSearchMM {
	// 전적 검색에 필요한 데이터를 API로 받아오기

	ModelAndView mav;
	String api_key = "RGAPI-4843ae9e-7ede-4140-8341-164bbda24a7b";
	BufferedReader br = null;

	public ModelAndView sSummonerSearch(String summonerName) {

		log.info("소환사 이름: " + summonerName);
		mav = new ModelAndView();
		String proFileUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName
				+ "?api_key=" + api_key;
		// 개인 권한 API
		try {
			// URL 객체 생성
			URL url1 = new URL(proFileUrl);
			// URL에서 URLConnection 객체 얻기(프로토콜이 http://인 경우 아래 객체로 캐스팅 가능)
			HttpURLConnection urlconnection = (HttpURLConnection) url1.openConnection(); // openConnection() 메서드는
																							// IOException 발생
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			System.out.println(br);

			String result = "";
			String line1;
			while ((line1 = br.readLine()) != null) {
				result += line1;
			}
			// json object를 추출하기 위해 json형태로 parser한다.
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			int profileIconId = k.get("profileIconId").getAsInt();
			String puuid = k.get("puuid").getAsString();
			long summonerLevel = k.get("summonerLevel").getAsLong();
			String id = k.get("id").getAsString();
			String name = k.get("name").getAsString();

			// 위에서 받은 id로 url에 넣어 tier관련 정보 추출
			String tierInfoUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + id + "?api_key="
					+ api_key;
			URL url2 = new URL(tierInfoUrl);
			urlconnection = (HttpURLConnection) url2.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

			String result1 = br.readLine();
			// 해당형태는 jsonArray형태라 jsonArray로 먼저 parser하여 json object를 구해야한다.
			JsonArray jsonArray = (JsonArray) jsonParser.parse(result1);

			String freeTier;
			int freeLeaguePoint = 0;
			int freeWins = 0;
			int freeLosses = 0;
			double freeWinRate = 0;

			String soloTier;
			int soloLeaguePoint = 0;
			int soloWins = 0;
			int soloLosses = 0;
			double soloWinRate = 0;
			// 위에 jsonArray를 parser하고난 후에 json object를 구하기 위한 과정이다.
			// solo rank와 free rank가 추출되는데, 둘다, 둘중 하나 혹은 하나도 출력되지 않는 경우도 있기에 아래와 같이 수식을
			// 작성하였다.
			if (jsonArray.size() == 2) {
				JsonObject p = (JsonObject) jsonArray.get(0);
				JsonObject p1 = (JsonObject) jsonArray.get(1);
				if (p.get("queueType").getAsString() == "RANKED_FLEX_SR") {
					freeTier = p.get("tier").getAsString();
					freeLeaguePoint = p.get("leaguePoints").getAsInt();
					freeWins = p.get("wins").getAsInt();
					freeLosses = p.get("losses").getAsInt();
					freeWinRate = Math.round(((double) freeWins / (freeWins + freeLosses)) * 100) / 100.0;
					soloTier = p1.get("tier").getAsString();
					soloLeaguePoint = p1.get("leaguePoints").getAsInt();
					soloWins = p1.get("wins").getAsInt();
					soloLosses = p1.get("losses").getAsInt();
					soloWinRate = Math.round(((double) soloWins / (soloWins + soloLosses)) * 100) / 100.0;
				} else {
					freeTier = p1.get("tier").getAsString();
					freeLeaguePoint = p1.get("leaguePoints").getAsInt();
					freeWins = p1.get("wins").getAsInt();
					freeLosses = p1.get("losses").getAsInt();
					freeWinRate = Math.round(((double) freeWins / (freeWins + freeLosses)) * 100) / 100.0;
					soloTier = p.get("tier").getAsString();
					soloLeaguePoint = p.get("leaguePoints").getAsInt();
					soloWins = p.get("wins").getAsInt();
					soloLosses = p.get("losses").getAsInt();
					soloWinRate = Math.round(((double) soloWins / (soloWins + soloLosses)) * 100) / 100.0;

				}
			} else if (jsonArray.size() == 1) {
				JsonObject p = (JsonObject) jsonArray.get(0);
				if (p.get("queueType").getAsString() == "RANKED_FLEX_SR") {
					freeTier = p.get("tier").getAsString();
					freeLeaguePoint = p.get("leaguePoints").getAsInt();
					freeWins = p.get("wins").getAsInt();
					freeLosses = p.get("losses").getAsInt();
					freeWinRate = Math.round(((double) freeWins / (freeWins + freeLosses)) * 100) / 100.0;
					soloTier = "unranked";
				} else {
					soloTier = p.get("tier").getAsString();
					soloLeaguePoint = p.get("leaguePoints").getAsInt();
					soloWins = p.get("wins").getAsInt();
					soloLosses = p.get("losses").getAsInt();
					soloWinRate = Math.round(((double) soloWins / (soloWins + soloLosses)) * 100) / 100.0;
					freeTier = "unranked";
				}
			} else {
				soloTier = "unranked";
				freeTier = "unranked";
			}

			mav.setViewName("summonerSearch");
			mav.addObject("summonerName", name);
			mav.addObject("profileIconId", profileIconId);
			mav.addObject("LV", summonerLevel);
			mav.addObject("freeTier", freeTier);
			mav.addObject("freeLeaguePoint", freeLeaguePoint);
			mav.addObject("freeWins", freeWins);
			mav.addObject("freeLosses", freeLosses);
			mav.addObject("freeWinRate", (int) (freeWinRate * 100));
			mav.addObject("soloTier", soloTier);
			mav.addObject("soloLeaguePoint", soloLeaguePoint);
			mav.addObject("soloWins", soloWins);
			mav.addObject("soloLosses", soloLosses);
			mav.addObject("soloWinRate", (int) (soloWinRate * 100));
			
			mav = summonerMatchDetail(puuid);
		    

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mav;

	}

	private ModelAndView summonerMatchDetail(String puuid) {
		
		mav = new ModelAndView();
		String summonerMatch = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/"+puuid+"/ids?start=0&count=10&api_key="
				+api_key;
		try {
			URL url = new URL(summonerMatch);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			
			String result = br.readLine();
			JsonParser jsonParser = new JsonParser();
			JsonArray jsonArray = (JsonArray) jsonParser.parse(result);
			System.out.println(jsonArray);
			jsonArray.get(0).toString();
			

			for(int i=0; i<jsonArray.size(); i++) {
				JsonObject p = (JsonObject) jsonArray.get(i);				
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

}
