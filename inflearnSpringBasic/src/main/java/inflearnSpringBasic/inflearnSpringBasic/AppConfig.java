package inflearnSpringBasic.inflearnSpringBasic;

import inflearnSpringBasic.inflearnSpringBasic.order.service.impl.OrderServiceImpl;
import inflearnSpringBasic.inflearnSpringBasic.order.service.OrderService;
import inflearnSpringBasic.inflearnSpringBasic.discount.DiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.discount.RateDiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemoryMemberReposirory;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;
import inflearnSpringBasic.inflearnSpringBasic.member.service.impl.MemberServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(memoryMemberReposirory());
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memoryMemberReposirory(), discountPolicy());
	}
	
	private MemoryMemberReposirory memoryMemberReposirory() {
		return new MemoryMemberReposirory();
	}
	
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
