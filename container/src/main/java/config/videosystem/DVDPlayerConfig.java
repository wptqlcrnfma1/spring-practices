package config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;

@Configuration
public class DVDPlayerConfig {

	//컨테이너가 얘를 읽는데 스캐닝할대 bean이 달렷네?
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	
	// 주입하기(DI) 1번
	@Bean //컨테이너가 bean 붙어있어서 실행시킴
	public DVDPlayer dvdPlayer() {
		return new DVDPlayer(avengers());
	}
}
