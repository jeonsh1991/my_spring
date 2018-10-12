package com.spring.pp.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.pp.user.domain.UserVO;
import com.spring.pp.user.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	private final UserDAO userDAO;
	
	@Inject
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void register(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userDAO.register(userVO);
		
		
	}

}
