package inflearnSpringBasic.inflearnSpringBasic.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import inflearnSpringBasic.inflearnSpringBasic.member.object.Grade;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;

class TestRateDiscountPolicy {
	
	RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용")
	void vip_o() {
		// given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		
		// when
		int discount = this.rateDiscountPolicy.discount(member, 10000);
		
		// then
		Assertions.assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP가 아니면 할인 적용X")
	void vip_x() {
		// given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);
		
		// when
		int discount = this.rateDiscountPolicy.discount(member, 10000);
		
		// then
		assertThat(discount).isEqualTo(0);
	}
}
