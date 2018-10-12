package com.example.model.member.dao;

import javax.servlet.http.HttpSession;

import com.example.model.member.dto.MemberVO;

public interface MemberDAO {
	
	public boolean loginCheck(MemberVO vo);
	public MemberVO viewMember(MemberVO vo);
	public void logout(HttpSession session);

}
