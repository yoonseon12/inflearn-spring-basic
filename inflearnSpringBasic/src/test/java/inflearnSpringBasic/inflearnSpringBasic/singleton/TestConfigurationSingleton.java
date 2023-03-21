package inflearnSpringBasic.inflearnSpringBasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import inflearnSpringBasic.inflearnSpringBasic.AppConfig;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.member.service.impl.MemberServiceImpl;
import inflearnSpringBasic.inflearnSpringBasic.order.service.impl.OrderServiceImpl;

public class TestConfigurationSingleton {
	
	@Test
	void configurationTest() {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
		
		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();
		
		// 모두 같은 인스턴스를 참고하고 있다.
		System.out.println("memberService -> memberRepository = " + memberRepository1);
		System.out.println("orderService -> memberRepository = " + memberRepository2);
		System.out.println("memberRepository = " + memberRepository);

		// 모두 같은 인스턴스를 참고하고 있다.
		Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
		
	}
	
	@Test
	void configurationDeep() { 
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// AppConfig도 스프링 빈으로 등록된다.
		AppConfig bean = ac.getBean(AppConfig.class);
		
		System.out.println("bean = "+bean.getClass());
	}
}
