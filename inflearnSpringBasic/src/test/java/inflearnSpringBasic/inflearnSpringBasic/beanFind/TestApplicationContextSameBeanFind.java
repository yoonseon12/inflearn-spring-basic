package inflearnSpringBasic.inflearnSpringBasic.beanFind;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemoryMemberRepository;

public class TestApplicationContextSameBeanFind {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
	
	@Test
	@DisplayName("같은 타입으로 Bean 조회 시 중복오류가 발생한다.")
	void findBeanByTypeDupl() {
		MemberRepository bean = ac.getBean(MemberRepository.class);
		
		Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
				() -> ac.getBean(MemberRepository.class));
	}
	
	@Test
	@DisplayName("같은 타입으로 Bean 조회 시 중복이 있으면 빈 이름을 지정하면 된다.")
	void findBeanByName() {
		MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
		assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	}
	
	@Test
	@DisplayName("같은 타입으로 Bean 모두 조회하기.")
	void findAllBeanByType() {
		Map<String, MemberRepository> m = ac.getBeansOfType(MemberRepository.class);
		for (String key : m.keySet()) {
			System.out.println("key = " + key + " value = "+m.get(key));
		}
		System.out.println("m = " + m);
		assertThat(m.size()).isEqualTo(2);
	}
	
	@Configuration
	static class SameBeanConfig {
		
		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}
		
		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}
	}
}
