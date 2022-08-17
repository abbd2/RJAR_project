package com.rjar.www.bean;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
// mybatis-config.xml에 올려놓음
public class Member {

	private String id;
	private String pw;

}
