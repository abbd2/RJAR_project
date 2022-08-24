package com.rjar.www.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjar.www.bean.summonersearch.MultiSearchBean;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController // @ResponseBody 생략
@AllArgsConstructor
public class MultiSearchRestController {

	private final MultiSearchBean msb;

	private final static String api_key = "RGAPI-08c7da92-9810-4c40-8560-b6af5f2443ac";

	@GetMapping(value = "/executeMultiSearch")
	public String multiSearch(String summoners) throws IOException {

		long beforeTime = System.currentTimeMillis(); // 코드 실행 전의 시간

		log.info(getSummonersInfo(summoners)); // 멀티서치에 뿌릴 정보 받아오기

		long afterTime = System.currentTimeMillis(); // 코드 실행 후의 시간
		double secDiffTime = ((double) afterTime - beforeTime) / 1000;
		System.out.println("총 걸린 시간 : " + secDiffTime);

		return "multiSearch";
	}

	public String getSummonersInfo(String summoners) throws IOException {

		// 나중에 summoners 유무 체크
		String replaceVal = "님이 방에 참가했습니다.";

		log.info("검색창에서 넘어온 값 : " + summoners);
		String summoners1 = summoners.replace(replaceVal, ""); // replaceVal 제거
		log.info("replaceval 제거 : " + summoners1);
		String summoners2 = summoners1.replaceAll("\\p{Z}", ""); // 공백 완전히 제거
		log.info("공백 완전히 제거 : " + summoners2);
		String[] summonerName = summoners2.split("\\R|,"); // 개행과 쉼표 문자를 기준으로 나누어서 저장

		// 소환사 이름 출력
		for (String name : summonerName) {
			System.out.println("소환사 이름 : " + name);
		}
		// 검색한 소환사들의 프로필 정보를 저장
		MultiSearchBean[] msbArr = new MultiSearchBean[summonerName.length];

		for (int i = 0; i < summonerName.length; i++) {
			System.out.println(summonerName[i] + "의 puuid 받아오는중...");
			msbArr[i] = getPuuid(summonerName[i]); // 정보 받아오기
			System.out.println("tier[i] : " + msbArr[i].getTier());
			System.out.println("totalWinRate[i] : " + msbArr[i].getTotalWinRate());

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
	public static String connectURL(String getUrl) throws IOException {
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

		// url에서 긁어온 값을 String으로 반환
		return result;
	}

	// 문자열 -> JsonNode
	public static JsonNode parseStringToJson(String getUrl, String result) throws IOException {

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode jsonNode = objMapper.readTree(result); // String을 JsonNode로 변환
		System.out.println("jsonNode : " + jsonNode);

		return jsonNode;
	}

	// 소환사 이름으로 puuid 받아오기
	public MultiSearchBean getPuuid(String summonerName) throws IOException {

		String proFileUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName
				+ "?api_key=" + api_key;

		String result = connectURL(proFileUrl); // url connect
		JsonNode json = parseStringToJson(proFileUrl, result); // String(json모양) -> JsonNode

		JsonNode jsonId = json.get("id"); // JsonNode에서 id 저장
		JsonNode jsonPuuid = json.get("puuid"); // JsonNode에서 puuid 저장

		String id = stringFormating1(jsonId.toString()); // 큰따옴표 제거한 값 저장
		String puuid = stringFormating1(jsonPuuid.toString()); // 큰따옴표 제거한 값 저장

		System.out.println("id : " + id);
		System.out.println("puuid : " + puuid);

		getGameId(puuid);

		// 리그 정보 가져오고 리턴
		return leagueInfo(id);
	}

	public MultiSearchBean leagueInfo(String id) throws IOException {

		String leagueUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + id + "?api_key="
				+ api_key;

		String result = connectURL(leagueUrl);
		System.out.println("result : " + result);
		result = result.replace("[", ""); // 대괄호 제거
		result = result.replace("]", ""); // 대괄호 제거
		System.out.println("result replace : " + result);
		JsonNode json = parseStringToJson(leagueUrl, result);

		// tier 저장
		System.out.println("티어");
		JsonNode jsonTier = json.get("tier"); // JsonNode에서 tier 저장
		System.out.println("jsonTier : " + jsonTier);
		msb.setTier(jsonTier.toString().replace("\"", "")); // 큰따옴표 제거한 값 저장
		System.out.println("Tier : " + msb.getTier());

		// 랭크 저장
		System.out.println("랭크");
		JsonNode jsonRank = json.get("rank"); // JsonNode에서 tier 저장
		System.out.println("jsonRank : " + jsonRank);
		msb.setRank(jsonRank.toString().replace("\"", "")); // 큰따옴표 제거한 값 저장
		System.out.println("rank : " + msb.getRank());

		// LP 저장
		System.out.println("LP");
		JsonNode jsonLeaguePoints = json.get("leaguePoints"); // JsonNode에서 tier 저장
		System.out.println("jsonLeaguePoints : " + jsonLeaguePoints);
		msb.setLp(jsonLeaguePoints.toString().replace("\"", "")); // 큰따옴표 제거한 값 저장
		System.out.println("leaguePoints : " + msb.getLp());

		// 전체 경기 승리 수 저장
		System.out.println("전체 경기 승리 수");
		JsonNode jsonWins = json.get("wins"); // JsonNode에서 tier 저장
		System.out.println("jsonWins : " + jsonWins);
		msb.setTotalWins(Integer.parseInt(jsonWins.toString().replace("\"", ""))); // 큰따옴표 제거한 값 저장
		System.out.println("wins : " + msb.getTotalWins());

		// 전체 경기 패배 수 저장
		System.out.println("전체 패배 수");
		JsonNode jsonLosses = json.get("losses"); // JsonNode에서 tier 저장
		System.out.println("jsonLosses : " + jsonLosses);
		msb.setTotalLosses(Integer.parseInt(jsonLosses.toString().replace("\"", ""))); // 큰따옴표 제거한 값 저장
		System.out.println("losses : " + msb.getTotalLosses());

		// 전체 경기의 승률 저장
		System.out.println("승률");
		if (msb.getTotalLosses() > 0) {
			double winRate = 0;
			winRate = (double) msb.getTotalWins() / (msb.getTotalWins() + msb.getTotalLosses()) * 100;
			msb.setTotalWinRate(Math.round((int) winRate));
		} else {
			msb.setTotalLosses(-1);
		}
		System.out.println("totalWinRate : " + msb.getTotalWinRate());

		return msb;
	}

	// puuid로 gameid 10개씩 받기
	public static void getGameId(String puuid) throws IOException {

		System.out.println("gmaeID 가져오는 중...");
		String matchUrl = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid
				+ "/ids?start=0&count=10&api_key=" + api_key;
		String result = connectURL(matchUrl); // url connect
		String gameId = stringFormating2(result); // 대괄호 제거한 값 저장
		gameId = stringFormating1(gameId); // 큰따옴표 제거한 값 저장

		// 쉼표를 기준으로 나누기
		StringTokenizer st = new StringTokenizer(gameId, ",");

		// 게임이아디에서 데이터 가져오기
		while (st.hasMoreTokens()) {
			System.out.println("검색할 게임 아이디 : " + st.hasMoreTokens());
			getGameData(st.nextToken());
		}

	}

	// 게임아이디로 데이터 가져오기
	private static void getGameData(String gameId) throws IOException {

		String gameUrl = "https://asia.api.riotgames.com/lol/match/v5/matches/" + gameId + "?api_key=" + api_key;
		String result = connectURL(gameUrl);
		System.out.println("gameid result : " + result);
	}

	// 큰따옴표 제거 메소드
	public static String stringFormating1(String str) {
		System.out.println("큰따옴표 제거 전 : " + str);
		str = str.replace("\"", ""); // 큰따옴표 제거
		System.out.println("큰따옴표 제거 후 : " + str);
		return str;
	}

	// 대괄호 제거 메소드
	public static String stringFormating2(String str) {
		System.out.println("대괄호 제거 전 : " + str);
		str = str.replace("[", ""); // 대괄호 제거
		str = str.replace("]", ""); // 대괄호 제거
		System.out.println("대괄호 제거 후 : " + str);
		return str;
	}

}
