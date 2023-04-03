package inflearnSpringBasic.inflearnSpringBasic.discount;

import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;

public interface DiscountPolicy {
	
	/**
	 * 
	 * @param  member
	 * @param  price
	 * @return 할인 대상 금액
	 */
	int discount(Member member, int price);
}
