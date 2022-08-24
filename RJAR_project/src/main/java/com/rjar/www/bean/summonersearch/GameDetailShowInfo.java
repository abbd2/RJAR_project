package com.rjar.www.bean.summonersearch;

import lombok.Data;


import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameDetailShowInfo {
	
	// 사용하지 않는 것들은 지울 예정
	
	// ---------------- 게임 내용에 필요한 데이터 ----------------
		private String ChampionName; // 검색한 소환사의 챔피언 이름
		private String summonerName; // 소환사 이름
		private int champId;
        private int champLevel;
        private String win; // 경기 결과
        
        private int summoner1Id; // D 스펠
        private int summoner2Id; // F 스펠
        private int ssMain_rune; // 매 인룬
        private int ssSub_rune;// 서브 룬

        private int kills; // 킬
        private int deaths; // 데스
        private int assists; // 어시스트
        private double kda;
        private double killParticipation; // 해당 게임의 킬 관여율
        private int totalDamageDealtToChampions; // 챔피언 딜량
        private int totalDamageTaken; // 챔피언 받은 피해량
        
        private int visionWardsBoughtIngame;
		private int wardsKilled;
		private int wardsPlaced;
        private int totalMinionsKilled; // cs

        private int item0; // 0번 아이템 슬롯
        private int item1; // 1번 아이템 슬롯
        private int item2; // 2번 아이템 슬롯
        private int item3; // 3번 아이템 슬롯
        private int item4; // 4번 아이템 슬롯
        private int item5; // 5번 아이템 슬롯 
        private int item6; // 6번 아이템 슬롯

}
