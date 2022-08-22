package com.rjar.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	
	@Autowired
	private B b;
	
	public void print() {
		b.pirnt();
	}

}
