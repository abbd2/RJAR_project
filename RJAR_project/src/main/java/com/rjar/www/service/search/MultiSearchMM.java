package com.rjar.www.service.search;

import org.springframework.beans.factory.annotation.Autowired;

public class MultiSearchMM {

	private SummonerSearchMM sm;

	// 생성자 주입(@Autowired를 사용하는 필드주입보다 생성자 주입을 권장함)

	@Autowired
	public MultiSearchMM(SummonerSearchMM sm) {
		this.sm = sm;
	}
//	
	

}