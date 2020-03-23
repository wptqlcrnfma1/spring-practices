package com.douzone.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douzone.aoptest.service.ProductService;
import com.douzone.aoptest.vo.ProductVo;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml"); // 스프링 컨테이너 설정(xml 파일에 어노테이션 찾는거)
		
		ProductService ps = ac.getBean(ProductService.class); // 서비스 달라
		
		ProductVo vo = ps.find("TV"); //잘 돌아가면 서비스 만들어져서 FIND하고 찾는다.
		
		System.out.println("[MAIN]" + vo);
		
	}

}
