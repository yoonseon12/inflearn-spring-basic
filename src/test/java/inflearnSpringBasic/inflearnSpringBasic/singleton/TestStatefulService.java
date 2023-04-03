package inflearnSpringBasic.inflearnSpringBasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class TestStatefulService {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		// Thread A : A 사용자가 10000원 주문
		statefulService1.order("userA", 10000);
        
		// Thread B : B 사용자가 20000원 주문
		statefulService1.order("userA", 20000);
		
		// Thread A : A 사용자가 주문금액 조회
		int price = statefulService1.getPrice();
        
        //ThreadA: 사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력
		System.out.println("price : "+price);
		
		Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
		
	}
	
	static class TestConfig {
		
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}

}
