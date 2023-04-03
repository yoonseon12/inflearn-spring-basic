package inflearnSpringBasic.inflearnSpringBasic.beanFind;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import inflearnSpringBasic.inflearnSpringBasic.AppConfig;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;
import inflearnSpringBasic.inflearnSpringBasic.member.service.impl.MemberServiceImpl;

public class TestApplicationContextBasicFind {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("Bean 이름으로 조회")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("Bean 타입으로만 조회")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("구현체 타입으로 조회")
	void findBeanByName2() {
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("Bean 이름으로 조회 X")
	void findBeanByNamX() {
//		ac.getBean("xxxxxxx", MemberService.class);
//		MemberService memberService = ac.getBean("xxxxxxx", MemberService.class);
//		assertThat(memberService).isInstanceOf(MemberService.class);
		
		Assertions.assertThrows(NoSuchBeanDefinitionException.class,
				() -> ac.getBean("xxxxxxx", MemberService.class));
	}
	
}
