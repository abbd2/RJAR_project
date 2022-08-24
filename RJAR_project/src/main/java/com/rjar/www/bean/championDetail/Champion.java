package com.rjar.www.bean.championDetail;

import java.util.List;

import lombok.Data;

@Data
public class Champion {
	private String eg_champName;
	private String kr_champName;
	private int champId;
	private String lane;
	private double winRate;
	private double pickRate;
	private double banRate;
	private int champTier;
	private List<Champion> counter_champName;
}