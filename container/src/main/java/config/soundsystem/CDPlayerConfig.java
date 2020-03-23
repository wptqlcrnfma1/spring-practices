package config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//암시적

@Configuration //Test.java 파일의 @ContextConfiguration(classes=CDPlayerConfig.class)때문에 지금은 필요없지만 붙혀주는게 좋다
@ComponentScan(basePackages={"com.douzone.container.soundsystem"}) //@Component가 타겟이므로
public class CDPlayerConfig {
//스캐닝 되도록 설정해야한다.
}
