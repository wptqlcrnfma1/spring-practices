package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired 
	private GuestbookRepository guestbookRespository;

	@RequestMapping("") 
	public String index(Model model) {

		List<GuestbookVo> list = guestbookRespository.findAll();
		model.addAttribute("list", list);
		return "index";
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		
		guestbookRespository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, 
			Model model) {
		model.addAttribute("no", no);
		return "delete";
	}
	
	@RequestMapping(value="/delete/{no}",method=RequestMethod.POST)
	public String delete(@PathVariable("no") Long no , GuestbookVo vo) {
		guestbookRespository.delete(no,vo.getPassword());

		return "redirect:/";
	}
}
