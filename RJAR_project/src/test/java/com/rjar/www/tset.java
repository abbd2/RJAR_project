package com.rjar.www;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class tset {

	@Autowired
	private A a;

	@Test
	public void print() {
		a.print();
	}

}
