package org.zerock.domain;

import lombok.Data;

@Data //@Data 어노테이션을 이용하면 getter/setter, equals(), toString() 등의 메서드를 자동 생성하기 때문에 편리하다.
public class SampleDTO {

	private String name;
	private int age;
	
}
