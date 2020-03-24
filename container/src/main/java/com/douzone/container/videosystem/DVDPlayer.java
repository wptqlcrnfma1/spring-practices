package com.douzone.container.videosystem;

public class DVDPlayer {

	//DigitalVideoDisc(인터페이스) 주입 > 인터페이스를 구현한 모든 클래스도 상속되므로 확장성이 좋아진다. @autowired로 주입받으면 되지만 scanning말고 생성자로 하는거로 해본거
	private DigitalVideoDisc dvd;
	
	public DVDPlayer() {
		
	}
	
	
	//dvdplayerconfig가서 dvdplayer() 만들고 테스트하고 여기와서 생성자 넣는 순서가 맞다.
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd=dvd;
	}
	
	public void play() {
		dvd.play();
	}
	
}
