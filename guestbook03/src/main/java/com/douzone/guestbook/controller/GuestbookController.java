package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.GuestBookRepository;
import com.douzone.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController {

	@Autowired 
	private GuestBookRepository guestbookRespository;

	@RequestMapping("") 
	public String index(Model model) {

		List<GuestBookVo> list = guestbookRespository.findAll();
		model.addAttribute("list", list);
		return "index";
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(GuestBookVo vo) {
		
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
	public String delete(@PathVariable("no") Long no, @RequestParam(value = "password", required=true, defaultValue="" ) String password) {
		guestbookRespository.delete(no,password);
		
		return "redirect:/";
	}
	
//	@RequestMapping(value="/delete/{no}",method=RequestMethod.POST) //위와 동일 과제의도인 pathVariable과 RequestParam의 차이 인지
//	public String delete(@PathVariable("no") Long no, GuestbookVo vo) {
//		guestbookRespository.delete(vo.getNo(),vo.getPassword());
//
//		return "redirect:/";
//	}
}
