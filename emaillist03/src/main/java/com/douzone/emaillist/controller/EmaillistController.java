package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {

	@Autowired // 이거 안쓰면 null 에러
	private EmaillistRepository emaillistRespository;

	@RequestMapping("") // () 안에 비워두면 안된다.
	public String index(Model model) {
		// new EmaillistRepository().findAll(); 이거 이제 쓰면x 컨트롤러 만든 의미가 없다.

		List<EmaillistVo> list = emaillistRespository.findAll();
		model.addAttribute("list", list);
		return "index";
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		
		emaillistRespository.insert(vo);
		return "redirect:/";
	}
}
