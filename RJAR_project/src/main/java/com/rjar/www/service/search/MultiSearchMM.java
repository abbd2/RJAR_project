package com.rjar.www.service.search;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
// 롬복을 이용한 생성자 주입 사용
@Service
@RequiredArgsConstructor
public class MultiSearchMM {

//	private final SummonerSearchMM sm;

	public ModelAndView multiSearch(String summoners) throws IOException {

		String replaceVal = "님이 방에 참가하셨습니다.";

		log.info("jsp에서 넘어온 값" + summoners);
		String[] summonerName = summoners.split(replaceVal); // reqplaceVal에 값을 기준으로 자르기
		log.info("replace한 값" + Arrays.toString(summonerName)); // 배열의 값들 한번에 출력

		String api_key = "RGAPI-4843ae9e-7ede-4140-8341-164bbda24a7b";
		String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key="
				+ api_key;

		URL url1 = new URL(url);
		// URL에서 URLConnection 객체 얻기(프로토콜이 http://인 경우 아래 객체로 캐스팅 가능)
		HttpURLConnection urlconnection = (HttpURLConnection) url1.openConnection();

		ModelAndView mav = new ModelAndView();

		mav.setViewName("multiSearch");

		return mav;
	}

}