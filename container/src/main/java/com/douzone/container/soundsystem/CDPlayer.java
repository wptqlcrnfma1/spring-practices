package com.douzone.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	
	
	// Wiring01: 바이너리 주입(CGLib) 
		// @Inject (자바 표준 Wiring 어노테이션)
		@Autowired //(스프링 Wiring 어노테이션)
		@Qualifier("highSchoolRapper3Final")
		private CompactDisc cd;

		public CDPlayer() {
		}
		
		// Wiring02: 생성자 주입
		// @Autowired
		public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
			this.cd = cd;
		}
		
		// Wiring03: setter 사용
		// @Autowired
		public void setCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
			this.cd = cd;
		}

		// Wiring04: 일반 메소드 사용
		// @Autowired
		public void insertCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
			this.cd = cd;
		}
		
		public void play() {
			cd.play();
		}
	
	
	
	
	/*
	// Wiring 01: 바이너리 주입(CGLib) / 필드에 바로 주입, 가장 최근 기술, 가장 깔끔
	//변수하나 찍고 @Autowired 쓰는거
	
	//@Autowired // (스프링)제일 좋은 방법 = @Inject(자바 표준 WIRING 어노테이션)와 동일
	@Qualifier("highSchoolRapper3Final") //2개 final.java 중에서 지정해서 잡는거, 제일 앞 소문자로
	private CompactDisc cd;
	
	
	public CDPlayer() {}
	
	// Wiring 02 : 생성자주입
	// 기본생성자가 없으니 밑에 생성자 가지고 호출, @Autowired 필요없음, 그래도 붙히는게 좋다 기본생성자가 있으면 못 찾으니까
	
	//@Autowired
	public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	
	// Wiring 03 : setter 사용
	
	//@Autowired
	public void setCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	// Wiring 04 : 일반 메소드 사용, 가능하면 setter 사용 권장
	
	@Autowired
	public void insertCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}
	
	
	public void play() {
		cd.play();
	}
	
	
	//그래도 가장 좋은건 제일 위 @Autowired
	 */
}
