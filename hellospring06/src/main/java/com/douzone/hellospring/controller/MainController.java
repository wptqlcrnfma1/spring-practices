package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@ResponseBody
	@RequestMapping({"", "/main"}) //비워두면 hellospring만 써도 들어옴
	public String main() {
		return "MainController:MAIN";
	}
	
}
