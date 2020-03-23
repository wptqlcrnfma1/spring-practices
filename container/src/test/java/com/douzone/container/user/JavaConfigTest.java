package com.douzone.container.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.user.AppConfig01;

public class JavaConfigTest {

	@Test
	public void testJavaConfig01() {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig01.class);
		User user = appContext.getBean(User.class);

		assertNotNull(user); // static 관련으로 빼주는거
		assertEquals("김정석", user.getName());
	}

	@Test
	public void testJavaConfig02() {

		ApplicationContext appContext = new AnnotationConfigApplicationContext("config.user");

		User user = appContext.getBean(User.class);
		assertNotNull(user); // static 관련으로 빼주는거
		assertEquals("마이콜", user.getName());

	}

}
