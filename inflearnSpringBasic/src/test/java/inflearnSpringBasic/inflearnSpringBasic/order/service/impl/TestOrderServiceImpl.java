package inflearnSpringBasic.inflearnSpringBasic.order.service.impl;

import org.junit.jupiter.api.Test;

import inflearnSpringBasic.inflearnSpringBasic.discount.RateDiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Grade;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemoryMemberRepository;

class TestOrderServiceImpl {

	@Test 
	void createOrder() {
		
		MemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L,"memberA",Grade.VIP));
		
		
		OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
		orderService.createOrder(1L, "itemA", 1000);
	}
	
}
