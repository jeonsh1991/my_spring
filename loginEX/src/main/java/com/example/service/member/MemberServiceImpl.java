package com.example.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.model.member.dao.MemberDAO;
import com.example.model.member.dto.MemberVO;

@Service //현재 클래스를 스프링에서 관리하는 service bean으로 등록
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;

	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		// TODO Auto-generated method stub
		boolean result = memberDao.loginCheck(vo);
		if(result) {
			MemberVO vo2 = viewMember(vo);
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getUserName());
		}
		return result;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDao.viewMember(vo);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate(); //세션에 있는거 다 초기화
		
	}

}
