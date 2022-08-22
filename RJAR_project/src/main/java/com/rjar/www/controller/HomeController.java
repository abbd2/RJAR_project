package com.rjar.www.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rjar.www.service.search.MultiSearchMM;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequiredArgsConstructor // 롬복을 이용한 생성자 주입 사용
public class HomeController {

	private final MultiSearchMM ms;

	ModelAndView mav;

	// servlet-context.xml에서 해당 패키지 스캔
	@GetMapping(value = "/")
	public String home() {
		return "home";
	}

	@GetMapping(value = "/home")
	public String main() {

		return "home";
	}

	@GetMapping(value = "/championDetail")
	public String championDetail() {

		return "championDetail";
	}

	@GetMapping(value = "/laboratory")
	public String laboratory() {

		return "laboratory";
	}

	@GetMapping(value = "/multiSearch")
	public String multiSearch(String summoners) throws IOException {
		
		return "multiSearch";
	}

	@GetMapping(value = "/community")
	public String community() {

		return "community";
	}

	@GetMapping(value = "/lck")
	public String lck() {

		return "lck";
	}

}
