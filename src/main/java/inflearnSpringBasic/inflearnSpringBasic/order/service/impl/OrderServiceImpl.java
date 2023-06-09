package inflearnSpringBasic.inflearnSpringBasic.order.service.impl;

import org.springframework.stereotype.Component;

import inflearnSpringBasic.inflearnSpringBasic.annotation.MainDiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.discount.DiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.order.object.Order;
import inflearnSpringBasic.inflearnSpringBasic.order.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {
	 
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = this.memberRepository.findById(memberId);
		int discountPrice = this.discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	} 
	

	// 테스트용
	public MemberRepository getMemberRepository() {
		return this.memberRepository;
	}

}
