package config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.User;

@Configuration //설정파일이라는 의미 : 베이스 패키지 전달할 때 설정작업
public class AppConfig02 {
	
	@Bean
	public User user() {
		System.out.println("@Configuration Called");
		return new User();
		
	}
}
