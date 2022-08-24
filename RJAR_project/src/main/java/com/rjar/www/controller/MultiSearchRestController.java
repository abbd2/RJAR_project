package com.rjar.www.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController // @ResponseBody 생략
public class MultiSearchRestController {

	private String api_key = "RGAPI-08c7da92-9810-4c40-8560-b6af5f2443ac";

	@GetMapping(value = "/executeMultiSearch")
	public String multiSearch(String summoners) throws IOException {

		log.info("검색창에서 넘어온 값 : " + summoners);
		log.info(getSummonersInfo(summoners));

		return "multiSearch";
	}

	public String getSummonersInfo(String summoners) throws IOException {

		// 나중에 summoners 유무 체크
		String replaceVal = "님이 방에 참가했습니다.";

		log.info("jsp에서 넘어온 값" + summoners);
		String summoners1 = summoners.replace(replaceVal, ""); // replaceVal 제거
		log.info("replaceval 제거 : " + summoners1);
		String summoners2 = summoners.replaceAll("\\p{Z}", ""); // 공백 완전히 제거
		log.info("공백 완전히 제거 : " + summoners2);
		String[] summonerName = summoners2.split("\\R|,"); // 개행과 쉼표 문자를 기준으로 나누어서 저장

		// 소환사 이름 출력
		for (String name : summonerName) {
			System.out.println("소환사 이름 : " + name);
		}
		// 검색한 소환사들의 puuid 저장
		String[] puuid = new String[summonerName.length];

		for (int i = 0; i < summonerName.length; i++) {
			System.out.println(summonerName[i] + "의 puuid 받아오는중...");
			puuid[i] = getPuuid(summonerName[i]); // puuid 받아오기
			System.out.println();
		}

//		getGameId(puuid[0]);

		// 한 행 당 10게임씩 저장
//		String[][] gameId = new String[summonerName.length][10];
//		for (int i = 0; i < puuid.length; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.println(summonerName[i] + "의 GameId 받아오는중...");
//				gameId[j][i] = getGameId(puuid[i]);
//			}
//		}

		return "";
	}

	// url 커넥션
	public String connectURL(String getUrl) throws IOException {
		URL url = new URL(getUrl);
		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

		String brRead = "";
		String result = "";

		// br,readLine() 한 줄 이상이 있다면
		while ((brRead = br.readLine()) != null) {
			result += brRead;
			System.out.println("while : " + result);
		} // while end

		return result;
	}

	// 문자열 -> JsonNode
	public JsonNode parseStringToJson(String getUrl, String result) throws IOException {

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode jsonNode = objMapper.readTree(result); // String을 JsonNode로 변환
		System.out.println("jsonNode : " + jsonNode);

		return jsonNode;
	}

	// 소환사 이름으로 puuid 받아오기
	public String getPuuid(String summonerName) throws IOException {

		String proFileUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName
				+ "?api_key=" + api_key;

		String result = connectURL(proFileUrl); // url connect
		JsonNode json = parseStringToJson(proFileUrl, result); // String(json모양) -> JsonNode

		JsonNode jsonId = json.get("id"); // JsonNode에서 id 저장
		JsonNode jsonPuuid = json.get("puuid"); // JsonNode에서 puuid 저장

		String id = jsonId.toString().replace("\"", ""); // 큰따옴표 제거한 값 저장
		String puuid = jsonPuuid.toString().replace("\"", ""); // 큰따옴표 제거한 값 저장

		System.out.println("id : " + id);
		System.out.println("puuid : " + puuid);

		// 리그 정보 가져오기
		leagueInfo(id);

		return puuid;
	}

	public void leagueInfo(String id) throws IOException {

		String leagueUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + id + "?api_key="
				+ api_key;

		String result = connectURL(leagueUrl);
		System.out.println("result : " + result);
		result = result.replace("[", ""); // 대괄호 제거
		result = result.replace("]", ""); // 대괄호 제거
		JsonNode json = parseStringToJson(leagueUrl, result);

		JsonNode jsonTier = json.get("tier"); // JsonNode에서 tier 저장
		System.out.println("jsonTier : " + jsonTier);
		String tier = jsonTier.toString().replace("\"", ""); // 큰따옴표 제거한 값 저장

		System.out.println("Tier : " + tier);
	}

	// puuid로 gameid 10개씩 받기
//	public String getGameId(String puuid) throws IOException {
//
//		String matchUrl = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid
//				+ "/ids?start=0&count=10&api_key=" + api_key;
//		URL url = new URL(matchUrl);
//		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//		urlconnection.setRequestMethod("GET");
//		BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
//		System.out.println("gameid : " + br.read());
//
//		return "";
//	}

}
