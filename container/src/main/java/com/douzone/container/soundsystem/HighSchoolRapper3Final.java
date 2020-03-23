package com.douzone.container.soundsystem;

import org.springframework.stereotype.Component;


// @Named("highSchoolRapper3Final") //component와 같은거 그냥 표준
@Component //암시적
public class HighSchoolRapper3Final implements CompactDisc {

	private String title = "붕붕";
	private String artist = "김하온";
	
	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
