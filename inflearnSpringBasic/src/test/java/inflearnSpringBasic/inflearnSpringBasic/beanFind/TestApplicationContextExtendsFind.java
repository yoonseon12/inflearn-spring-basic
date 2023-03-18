package inflearnSpringBasic.inflearnSpringBasic.beanFind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import inflearnSpringBasic.inflearnSpringBasic.discount.DiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.discount.FixDiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.discount.RateDiscountPolicy;

public class TestApplicationContextExtendsFind {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	
	@Test
	@DisplayName("부모타입으로 bean 조회 시 자식이 둘 이상 있으면 중복 오류 발생")
	void findBeanByParentTypeDupl() {
		//DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
		assertThrows(NoUniqueBeanDefinitionException.class,
				() -> ac.getBean(DiscountPolicy.class));
	}
	
	@Test
	@DisplayName("부모타입으로 bean 조회 시 자식이 둘 이상 있으면 Bean 이름을 지정하면 된다.")
	void findBeanByParentTypeBeanName() {
		DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
		assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy.class);
	}
	
	@Test
	@DisplayName("특정 하위 타입으로 조회")
	void findBeanBySubType() {
		RateDiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
		assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("부모타입으로 모두 조회")
	void findAllBeanByParentType() {
		Map<String, DiscountPolicy> m = ac.getBeansOfType(DiscountPolicy.class);
		assertThat(m.size()).isEqualTo(2);
		for (String key : m.keySet()) {
			System.out.println("key = " + key + " value = "+m.get(key));
		}
		//RateDiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
		//assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("부모타입으로 모두 조회 - Object")
	void findAllBeanByObjectType() {
		Map<String, Object> m = ac.getBeansOfType(Object.class);
		for (String key : m.keySet()) {
			System.out.println("key = " + key + " value = "+m.get(key));
		}
		// Spring Bean에 등록된 모든 객체 출력되겠지
	}
	
	
	@Configuration
	static class TestConfig {
		
		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}
		
		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixDiscountPolicy();
		}
		
	}
	
	
}
