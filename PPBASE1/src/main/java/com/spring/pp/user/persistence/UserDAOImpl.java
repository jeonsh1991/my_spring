package com.spring.pp.user.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.pp.user.domain.UserVO;


@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final String NAMESPACE = "com.spring.pp.user.UserMapper";
	private final SqlSession sqlSession;
	
	@Inject
	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void register(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".register", userVO);

	}

}
