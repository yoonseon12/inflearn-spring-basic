package inflearnSpringBasic.inflearnSpringBasic.discount;

import inflearnSpringBasic.inflearnSpringBasic.member.object.Grade;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;

public class FixDiscountPolicy implements DiscountPolicy {
	
	private final int discountFixAmount = 1000; // 할인금액
	
	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return this.discountFixAmount;
		}
		return 0;
	}

}
