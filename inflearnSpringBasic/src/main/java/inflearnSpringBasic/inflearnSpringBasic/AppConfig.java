package inflearnSpringBasic.inflearnSpringBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import inflearnSpringBasic.inflearnSpringBasic.discount.DiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.discount.RateDiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemoryMemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;
import inflearnSpringBasic.inflearnSpringBasic.member.service.impl.MemberServiceImpl;
import inflearnSpringBasic.inflearnSpringBasic.order.service.OrderService;
import inflearnSpringBasic.inflearnSpringBasic.order.service.impl.OrderServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(
				memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(
				memberRepository(),
				discountPolicy());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
