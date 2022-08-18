package com.rjar.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rjar.www.bean.Member;
import com.rjar.www.dao.IMemberDao;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {

	@Autowired
	private IMemberDao mDao;

	ModelAndView mav;

	// servlet-context.xml에서 해당 패키지 스캔
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Model model) {

		// 인터페이스로 선언된 mDao의 showMember 호출
		Member mm = mDao.showMember();
		// log4j를 활용하여 값 출력
		log.info(mm);

		System.out.println("id: " + mm.getId());
		System.out.println("pw: " + mm.getPw());

		mav = new ModelAndView();
		// 사용할 값 설정
		mav.addObject("id", mm.getId());
		mav.addObject("pw", mm.getPw());

		// 이동할 뷰페이지 설정
		mav.setViewName("home");

		return mav;
	}

	@GetMapping(value = "/championDetail")
	public ModelAndView championDetail() {
		
		mav.setViewName("championDetail");

		return mav;
	}
	
	@GetMapping(value = "/laboratory")
	public ModelAndView laboratory() {
		
		mav.setViewName("laboratory");

		return mav;
	}
	
	@GetMapping(value = "/multiSearch")
	public ModelAndView multiSearch() {
		
		mav.setViewName("multiSearch");
		//asd
		return mav;
	}
	
	@GetMapping(value = "/community")
	public ModelAndView community() {
		
		mav.setViewName("community");

		return mav;
	}
	
	@GetMapping(value = "/lck")
	public ModelAndView lck() {
		
		mav.setViewName("lck");

		return mav;
	}

}
