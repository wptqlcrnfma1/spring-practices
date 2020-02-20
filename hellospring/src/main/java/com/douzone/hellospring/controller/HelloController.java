package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello") //contextpath가 알아서 잡힌다. 기술필요 x
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
}
