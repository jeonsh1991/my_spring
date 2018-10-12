package com.example.controller;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.member.dto.MemberVO;
import com.example.service.member.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		boolean result = memberService.loginCheck(vo, session); //불런으로 넘어오는값 트루/펄스(이프 2가지가능)
		ModelAndView mav = new ModelAndView();
		if(result == true) {
			mav.setViewName("home");
			mav.addObject("msg","success");
		}else {
			mav.setViewName("member/login");
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	
	//로그아웃처리
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg","logout");
		return mav;
	}
	
}
