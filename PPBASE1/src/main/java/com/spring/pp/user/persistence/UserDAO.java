package com.spring.pp.user.persistence;

import com.spring.pp.user.domain.UserVO;

public interface UserDAO {

	void register(UserVO userVO) throws Exception;
	
}
