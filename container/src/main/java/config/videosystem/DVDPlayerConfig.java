package config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {

	//컨테이너가 얘를 읽는데 스캐닝할대 bean이 달렷네?
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	
	// 주입하기(DI) 1번 : 생성 메소드 직접 호출
	@Bean //컨테이너가 bean 붙어있어서 실행시킴
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}
	
	//주입하기(DI) 2번 : 진짜 DI, 파라미터로 Bean 전달하기(생성자 주입), 제일 괜찮은 방법
	@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	
	// 주입하기(DI) 3번 : 파라미터로 Bean 전달하기 : setter 주입
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		
		return dvdPlayer;
	}
	
	// 주입하기(DI) 4번 : 같은 타입이 생성된 경우
		@Bean(name="dvdPlayer04") //여기서는 메소드 이름이 다르니까 name을 안써도 되는데 예제로 참고, name을 지정하면 test파일에서 쿼리파이어쓸때 메소드 이름으로 못쓴다.
		public DVDPlayer dvdPlayer04(DigitalVideoDisc dvd) {
			DVDPlayer dvdPlayer = new DVDPlayer();
			dvdPlayer.setDvd(dvd);
			
			return dvdPlayer;
		}
}
