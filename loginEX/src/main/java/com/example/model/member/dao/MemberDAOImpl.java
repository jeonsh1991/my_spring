package com.example.model.member.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.model.member.dto.MemberVO;

@Repository //���� Ŭ������ ���������� �����ϴ� dao bean���� ���
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession; //SqlSession��ü�� ���������� �����Ͽ� ����. mybatis���ఴü
	
	@Override
	public boolean loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		String name = sqlSession.selectOne("member.loginCheck", vo);
		return (name == null) ? false : true; //������ ���̸� �޽��� ��ȯ ������ Ʈ�縦 ��ȯ
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
