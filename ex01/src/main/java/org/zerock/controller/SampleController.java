package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*") //������ �Ͽ� �ּҸ� �����ߴ�. ���� ��Ʈ�ѷ��� �۵��Ǵ� ��� �������� �ּҰ� localhost:8080/sample/ �� ���۵ȴ�. ���� ��������  sample�̴�.
@Log4j
public class SampleController {
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false)); //���������� http://localhost:8080/sample/ex03?title=test$dueDate=2018-01-01 �� ���� ȣ���ߴٸ� ���������� ���������� �Ķ���͸� �����ؼ� ó���ϰԲ� ����.
	}*/

	@RequestMapping("") //localhost:8080/sample/ �������� ������ ����ǰ� �� �޼ҵ带 �����ߴ�.`
	public void basic() {
		log.info("basic...........");
	}
	
	@RequestMapping(value = "/basic", method= {RequestMethod.GET, RequestMethod.POST}) //���� ������ ���ؼ� ������ �ʾҴ�. ���� ���� ����ϸ� get����� �������̰� post�� ���Ҿ� �ֱٿ� put, delete��ĵ� ���� ��� �󵵰� �þ���ִ�.
	public void basicGet() {
		
		log.info("basic get.................");
		
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get.................");
	}
	
	@GetMapping("/ex01") ////localhost:8080/sample/ex01 �� �����߰� �޼ҵ� Get������� ó��.
	public String ex01(SampleDTO dto) { //�ش� �޼ҵ�� SampleDTO��ü�� �̿��Ѵ�. �� �ش� ��ο� SampleDTO�� �������� �Ѱ� ���� �� �ִ�. ��)localhost:8080/sample/ex01?name=AAA&age=10
		log.info(""+dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name:"+name);
		log.info("age:"+age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids:"+ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		
		log.info("array ids:" +Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean") // http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B2%5D.name=bbb       -> [ = %5B , ] = %5D �� ���.
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos: " + list);
		
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : "+ todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) { //모델어트리뷰트("페이지")를 해줌으로써 int page값이 넘어갈 수 있게된다.
		
		log.info("dto:"+dto);
		log.info("page:"+page);
		
		return "/sample/ex04";
		
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06..............");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07..........");
		
		String msg = "{\"name\" : \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
		
	}
	
}
