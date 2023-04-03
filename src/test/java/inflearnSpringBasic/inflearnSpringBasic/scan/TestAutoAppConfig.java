package inflearnSpringBasic.inflearnSpringBasic.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import inflearnSpringBasic.inflearnSpringBasic.AutoAppConfig;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;

public class TestAutoAppConfig {

	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		
		MemberService memberService = ac.getBean(MemberService.class);
		
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
