package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("select id from test_member")
	public String getMember();
	
	public String getMember2();

}
