package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd") //이런식으로 해주면 컨트롤러에서 @InitBinder를 구현해줄 필요없음. 즉, 스트링으로 들어오는 날짜를 알아서 date값으로 바꿔줌.
	private Date dueDate;
	
}
