package com.douzone.container.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.user.User;

import config.user.AppConfig01;

public class JavaConfig {
	public static void main(String[] args) {
		testJavaConfig01();
		testJavaConfig02();
	}
	
	//Java Config
	// 직접 자바 설정 클래스 전달
	// 설정 클래스에 @Configuration이 필요없다.
	public static void testJavaConfig01() {
		System.out.println("testJavaConfig01()");
		//xml과 다른건 xml 파일 대신 class 파일이 들어간다.
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig01.class);
		
		User user =  appContext.getBean(User.class);
		System.out.println(user);
		
		
		//자원 정리
		((ConfigurableApplicationContext)appContext).close();
		
	}
	
	//Java Config
	// 직접 자바 설정 클래스가 있는 베이스 패키지 전달
	// 설정 클래스에 @Configuration 반드시 필요
	public static void testJavaConfig02() {
		System.out.println("testJavaConfig02()");
		ApplicationContext appContext = new AnnotationConfigApplicationContext("config.user");
		//패키지 가서 찾는데 클래스가 10개가 있으면? 어떤게 설정파일인지 모르기 때문에 설정작업 필요
		User user =  appContext.getBean(User.class);
		System.out.println(user);
		
		
		//자원 정리
		((ConfigurableApplicationContext)appContext).close();
		
	}
	
}
