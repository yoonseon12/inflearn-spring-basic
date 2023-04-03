package inflearnSpringBasic.inflearnSpringBasic.discount;

import org.springframework.stereotype.Component;

import inflearnSpringBasic.inflearnSpringBasic.annotation.MainDiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Grade;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
	
	private int discountPersent = 10; // 할인 퍼센
	
	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPersent / 100;
		}
		return 0;
	}

}
