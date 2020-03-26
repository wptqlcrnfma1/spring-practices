package com.douzone.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc //핸들러매핑, 뷰리졸버, 메세지컨버터 등
@ComponentScan({"com.douzone.hellospring.controller"}) //컨트롤러 스캐닝 , ({""})안에 컨트롤러 패키지 넣는다.
public class WebConfig {
	
	@Bean
	public ViewResolver viewResolver() {
		//메소드를 부르려면 인터페이스보다 클래스 타입으로 ref하는게 좋다
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);//주입하는 용도로 쓸것이냐?, 컨테이너를 관리하는 용도로 만들 것이냐?
		
		return resolver;
	}

}
