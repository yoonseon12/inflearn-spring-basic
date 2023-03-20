package inflearnSpringBasic.inflearnSpringBasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import inflearnSpringBasic.inflearnSpringBasic.discount.DiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.discount.RateDiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemoryMemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;
import inflearnSpringBasic.inflearnSpringBasic.member.service.impl.MemberServiceImpl;
import inflearnSpringBasic.inflearnSpringBasic.order.service.OrderService;
import inflearnSpringBasic.inflearnSpringBasic.order.service.impl.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(
				memoryMemberRepository());
	}
	
	@Bean
	public MemoryMemberRepository memoryMemberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(
				memoryMemberRepository(),
				discountPolicy());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
