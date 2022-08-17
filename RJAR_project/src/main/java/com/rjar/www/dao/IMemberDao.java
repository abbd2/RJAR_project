package com.rjar.www.dao;

import com.rjar.www.bean.Member;

public interface IMemberDao {
	
	// MemberMapper.xml에서 함수명을 기반으로 찾는다
	Member showMember();

}
