package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.hellospring.vo.UserVo;

/*
 * 추천방법!
 * RequestMapping
 * Class + Method
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = { "/join", "/j" }, method = RequestMethod.GET) // get방식으로만
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

//	@ResponseBody // 지금 내가 return하는 것을 body에 붙힌다 = 메세지로 생각 / object면 convert해서 변경해야한다.
//	@RequestMapping(value = "/join", method = RequestMethod.POST)
//	public String join(String name, String email) {
//		System.out.println(name + ":" + email);
//		return "UserController:joinform";
//	}
	
	/*위 파라미터가 10개라면? 10개 다 쓰지 않고
	 * 
	 * 파라미터를 UserVo userVo
	 */
	
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/"; //MainController에 main 탄다
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(@RequestParam("n") String name) { 
		/*
		 *@RequestParam 안써도 되는데 파라미터와 변수의 이름을 달리할때는 꼭 써야한다. 파라미터값은 n으로 오고 걔를 name으로 쓰겠다.
		 * 만약 n이라는 이름으로 파라미터가 없는 경우 400 bad request 오류 발생
		 */
		System.out.println(name);
		return "UserController:update";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update2")
	public String update2(@RequestParam(value = "n", required = true, defaultValue = "") String name,
			@RequestParam(value = "a", required = true, defaultValue = "0")int age) {
		/*
		 * 파라미터안들어와도 괜찮게끔 + age 자동 변환							
		 */
		System.out.println("---" + name + "---");
		System.out.println("---" + age + "---");
		return "UserController:update2";
	}
	
	/*
	 *mysite02/board?a=view&no=10
	 * > mysite03/board/view/10 이렇게 하는거 BoardController ㄱㄱㄱ
	 * 
	 * mysite03/guestbook/delete/10 (get) -> form
	 * mysite03/guestbook/delete/10 (post)
	 */
			 
	
}
