package com.douzone.container.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.videosystem.DVDPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DVDPlayerConfig.class)
public class DVDPlayerJavaConfigTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DigitalVideoDisc dvd; //주입 받기위해 autowired
	
	@Autowired
	// @Qualifier("dvdPlayer03") // 설정 클래스 Bean 메소드 이름 > DVDPlayerConfig 참고 
	@Qualifier("dvdPlayer04") // @Bean의 name 값 , 쿼리파이어 안쓰면 타입으로 받는다
	private DVDPlayer player;
	
	@Test
	public void testDVDNotNull() {	
		assertNotNull(dvd);
	}
	
	@Test
	public void testPlayerNotNull() {	
		assertNotNull(player);
	}
	
	@Test
	public void testPlay() {
		player.play();
		assertEquals("Playing Movie MARVEL's Avengers", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
}
