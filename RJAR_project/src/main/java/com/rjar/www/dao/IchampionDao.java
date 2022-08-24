package com.rjar.www.dao;

import java.util.List;

import com.rjar.www.service.bean.championDetail.Champion;

public interface IchampionDao {

	List<Champion> getChampionList(String tier);

	List<Champion> getwinRate(String champId, String tier);

}
