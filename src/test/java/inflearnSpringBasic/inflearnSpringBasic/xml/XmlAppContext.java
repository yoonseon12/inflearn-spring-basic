package inflearnSpringBasic.inflearnSpringBasic.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;

public class XmlAppContext {

	@Test
	@DisplayName("xml 기반의 스프링 빈 설정")
	void xmlAppContext() {
		ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml"); 
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
}