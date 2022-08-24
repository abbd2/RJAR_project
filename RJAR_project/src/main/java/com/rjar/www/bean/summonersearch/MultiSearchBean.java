package com.rjar.www.bean.summonersearch;

import org.springframework.stereotype.Repository;

import lombok.Data;

// 다시커밋
@Data
@Repository
public class MultiSearchBean {
	
	private String summonerName;
	private String mainLane;
	private String tier;
	private String rank;
	private String lp;
	private int totalWins;
	private int totalLosses;
	private int totalWinRate;
	
	private String[] lanes;
	private int[] kilss;
	private int[] deaths;
	private int[] assists;
	private boolean[] wins; // 10게임 경경기 결과
	private int[] realTimeDate;
	
	private String[] mostChampionNames;
	private double[] mostChampionKDA;
	private int[] mostChampionWins; // 모스트 챔피언들의 경기 수
	private int[] mostChampionWinRate; // 모스트 챔피언들의 경기 수
	
}
