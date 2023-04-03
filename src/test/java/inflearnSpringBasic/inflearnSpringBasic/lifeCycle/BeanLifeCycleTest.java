package inflearnSpringBasic.inflearnSpringBasic.lifeCycle;

import org.junit.jupiter.api.Test;	
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
	
	@Test
	void lifeCycleTest() {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		System.out.println("생성끝");
		NetworkClient client = ac.getBean(NetworkClient.class);
		ac.close();
	}
	
	@Configuration
	static class LifeCycleConfig {
//		@Bean(initMethod = "init", destroyMethod = "close")
		@Bean
		public NetworkClient networkClient() {
			NetworkClient nc = new NetworkClient();
			nc.setUrl("http://dev.co.kr");
			return nc;
		}
	}
}
