package com.example.model.member.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.model.member.dto.MemberVO;

@Repository //현재 클래스를 스프링에서 관리하는 dao bean으로 등록
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession; //SqlSession객체를 스프링에서 새성하여 주입. mybatis실행객체
	
	@Override
	public boolean loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		String name = sqlSession.selectOne("member.loginCheck", vo);
		return (name == null) ? false : true; //네임이 널이면 펄스를 반환 있으면 트루를 반환
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember", vo);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub

	}

}
