package inflearnSpringBasic.inflearnSpringBasic.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inflearnSpringBasic.inflearnSpringBasic.AppConfig;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Grade;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;

public class TestMemberService {
	
	private MemberService memberService;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	
	@Test
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
