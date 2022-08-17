package com.rjar.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjar.www.bean.Member;
import com.rjar.www.dao.IMemberDao;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {

	@Autowired
	private IMemberDao mDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		Member mm = mDao.showMember();
		log.info(mm);
		
		System.out.println("id: " + mm.getId());
		System.out.println("pw: " + mm.getPw());

		return "home";
	}

}
