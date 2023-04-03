package inflearnSpringBasic.inflearnSpringBasic.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import inflearnSpringBasic.inflearnSpringBasic.AppConfig;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Grade;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;

public class TestMemberService {
	
	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	MemberService memberService = ac.getBean("memberService", MemberService.class);
	
	@BeforeEach
	public void beforeEach() {
//		AppConfig appConfig = new AppConfig();
//		memberService = appConfig.memberService();
	}
	
	@Test
	@DisplayName("회원가입 한다.")
	void join() {
		// given
		Member member = new Member(1L, "memeber1", Grade.VIP);
		
		// when
		this.memberService.join(member);
		Member findMember = this.memberService.findMember(1L);
		
		// then
		Assertions.assertThat(member).isEqualTo(findMember);
	}
}
