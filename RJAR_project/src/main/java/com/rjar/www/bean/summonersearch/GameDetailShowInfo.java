package com.rjar.www.bean.summonersearch;

import lombok.Data;

import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameDetailShowInfo {
	
	// 사용하지 않는 것들은 지울 예정
	
	// ---------------- 게임 내용에 필요한 데이터 ----------------
		private String ssChampionName; // 검색한 소환사의 챔피언 이름
	
		private String ssBlue_top_summonerName; // 블루팀 탑 소환사 이름
		private String ssBlue_jungle_summonerName; // 블루팀 정글 소환사 이름
		private String ssBlue_mid_summonerName; // 블루팀 미드 소환사 이름
		private String ssBlue_bot_summonerName; // 블루팀 봇 소환사 이름
		private String ssBlue_suppot_summonerName; // 블루팀 서폿 소환사 이름
		
		private String ssRed_top_summonerName; // 레드팀 탑 소환사 이름
		private String ssRed_jungle_summonerName; // 레드팀 정글 소환사 이름
		private String ssRed_mid_summonerName; // 레드팀 미드 소환사 이름
		private String ssRed_bot_summonerName; // 레드팀 봇 소환사 이름
		
		private String ssBlue_top_championName; // 블루팀 탑 챔피언 이름
		private String ssBlue_jungle_championName; // 블루팀 정글 챔피언 이름
		private String ssBlue_mid_championName; // 블루팀 미드 챔피언 이름
		private String ssBlue_bot_championName; // 블루팀 봇 챔피언 이름
		private String ssBlue_suppot_championName; // 블루팀 서폿 챔피언 이름
		
		private String ssRed_top_championName; // 레드팀 탑 챔피언 이름
		private String ssRed_jungle_championName; // 레드팀 정글 챔피언 이름
		private String ssRed_mid_championName; // 레드팀 미드 챔피언 이름
		private String ssRed_bot_championName; // 레드팀 원딜 챔피언 이름
		private String ssRed_suppot_championName; // 레드팀 서폿 챔피언 이름
		
		private String ssGameRealTime; // 해당 게임을 플레이 했던 시간(날자 포함)		
		private String ssWin; // 경기 결과
		private String sstier; // 티어
		private String ssContinuousKill; // 연속킬
		private String ssOPScore; // OP Score
		
		private int ssD_spell; // D 스펠
		private int ssF_spell; // F 스펠
		
		private int ssMain_rune; // 매 인룬
		private int ssSub_rune;// 서브 룬
		
		private int ssKills; // 킬
		private int ssDeaths; // 데스
		private int ssAssists; // 어시스트
		private int ssCS; // cs
		
		private int ssItem0; // 0번 아이템 슬롯
		private int ssItem1; // 1번 아이템 슬롯
		private int ssItem2; // 2번 아이템 슬롯
		private int ssItem3; // 3번 아이템 슬롯
		private int ssItem4; // 4번 아이템 슬롯
		private int ssItem5; // 5번 아이템 슬롯
		private int ssItem6; // 6번 아이템 슬롯
		
		private int ssGameDuration; // 게임 시간
		private int ssTotalPerKill; // 해당 게임의 킬 관여율
		
		private double ssGameKDA; // 해당 게임의 KDA
		
		// 게임 세부정보에서 추가로 필요한 정보들
		private double ssChampionDamageDealt; // 챔피언 딜량
		private double ssChampionDamageTaken; // 챔피언 받은 피해량
		private double ssMinPerCS; // 해당 게임의 분당 CS
		
		private int ssBlueBaron; // 해당 게임의 블루팀 바론
		private int ssBlueDragon; // 해당 게임의 블루팀 용
		private int ssBlueTower; // 해당 게임의 블루팀 타워
		
		private int ssRedBaron; // 해당 게임의 레드팀 바론
		private int ssRedDragon; // 해당 게임의 레드팀 용
		private int ssRedTower; // 해당 게임의 레드팀 타워
		
		private int ssBlueTotalKills; // 해당 게임의 블루팀 종합 킬 수
		private int ssBlueTotalGolds; // 해당 게임의 블루팀 종합 골드
		
		private int ssRedTotalKills; // 해당 게임의 레드팀 종합 킬 수
		private int ssRedTotalGold; // 해당 게임의 레드팀 종합 골드

}
