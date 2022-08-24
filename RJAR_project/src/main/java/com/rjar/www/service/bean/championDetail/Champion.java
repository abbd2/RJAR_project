package com.rjar.www.service.bean.championDetail;

import java.util.List;

import lombok.Data;

@Data
public class Champion {
	
	private String tier;
	private String lane;
	
	private String eg_champName;
	private String kr_champName;
	private String champId;
	private String champTier;
	private Double winRate;
	private Double pickRate;
	private Double banRate;
	private List<String> counter_champName;
	
	
	
}
