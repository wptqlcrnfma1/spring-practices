package com.douzone.hellospirng.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.hellospring.config.WebConfig;

public class HellospringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() { //appConfig 
		//Root Application Context 설정 클래스
		// 필터, 리스너 자동 설정이 된다.
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//Web Application Context 설정 클래스
		//web.xml의 init param들
		return new Class<?>[] {WebConfig.class}; //<?> : 와일드카드 / 어떤 타입이 와도 된다. = ex)new Object[] {Book.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
