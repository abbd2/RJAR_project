package com.rjar.www.bean;

import lombok.Data;

@Data
public class SummonerSearch {

	// TODO
	// ------- 전적 검색의 헤드 페이지에 필요한 데이터 -------
	private String summonerImage; // 롤 프로필 사진
	private String stdSummonerName; // 검색한 소환사 이름
	private int summonerLevel; // 검색한 소환사 레벨
	
	// ---------------- 게임 내용에 필요한 데이터 ----------------
	private String blue_top_summonerName; // 블루팀 탑 소환사 이름
	private String blue_jungle_summonerName; // 블루팀 정글 소환사 이름
	private String blue_mid_summonerName; // 블루팀 미드 소환사 이름
	private String blue_bot_summonerName; // 블루팀 봇 소환사 이름
	private String blue_suppot_summonerName; // 블루팀 서폿 소환사 이름
	
	private String red_top_summonerName; // 레드팀 탑 소환사 이름
	private String red_jungle_summonerName; // 레드팀 정글 소환사 이름
	private String red_mid_summonerName; // 레드팀 미드 소환사 이름
	private String red_bot_summonerName; // 레드팀 봇 소환사 이름
	private String red_suppot_summonerName; // 레드팀 서폿 소환사 이름
	
	private String stdChampionName; // 검색한 소환사의 챔피언 이름
	
	private String blue_top_championName; // 블루팀 탑 챔피언 이름
	private String blue_jungle_championName; // 블루팀 정글 챔피언 이름
	private String blue_mid_championName; // 블루팀 미드 챔피언 이름
	private String blue_bot_championName; // 블루팀 봇 챔피언 이름
	private String blue_suppot_championName; // 블루팀 서폿 챔피언 이름
	
	private String red_top_championName; // 레드팀 탑 챔피언 이름
	private String red_jungle_championName; // 레드팀 정글 챔피언 이름
	private String red_mid_championName; // 레드팀 미드 챔피언 이름
	private String red_bot_championName; // 레드팀 원딜 챔피언 이름
	private String red_suppot_championName; // 레드팀 서폿 챔피언 이름
	
	private String win; // 경기 결과
	
	private int d_spell; // D 스펠
	private int f_spell; // F 스펠
	
	private int main_rune; // 매 인룬
	private int sub_rune;// 서브 룬
	
	private int kills; // 킬
	private int deaths; // 데스
	private int assists; // 어시스트
	private int cs; // cs
	
	private int item0; // 0번 아이템 슬롯
	private int item1; // 1번 아이템 슬롯
	private int item2; // 2번 아이템 슬롯
	private int item3; // 3번 아이템 슬롯
	private int item4; // 4번 아이템 슬롯
	private int item5; // 5번 아이템 슬롯
	private int item6; // 6번 아이템 슬롯
	
	private int gameDuration; // 게임 시간
	
}
