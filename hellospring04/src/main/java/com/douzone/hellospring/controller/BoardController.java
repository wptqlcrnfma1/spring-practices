package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 * 메소드 단독 매핑
 * 이런게 있구나 하고 넘기고 추천방법 쓰기
 */
@Controller
public class BoardController {

	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController:write"; //jsp 매핑
	}
	
	@ResponseBody
	@RequestMapping("/board/view/{no}") //{no} 랑 밑에 @pathvariable("no")랑 맞추기
	public String view(@PathVariable("no") Long no) {
		System.out.println("no:" + no);
		return "BoardController:view"; //jsp 매핑
	}
	
	
	/*
	 * Restful
	 * 
	 * 스프링 많이쓰는 주요기술
	 * Spring MVC
	 * Spring DATA(Spring DAO -> Spring JPA, Spring Mongo)
	 * Spring Security
	 * Spring Restful
	 * Spring Boot
	 * 
	 * 대기업에서 많이 하는 일
	 * Spring Batch : 단순한 일인데 파이프로 만들어서...
	 */
}
