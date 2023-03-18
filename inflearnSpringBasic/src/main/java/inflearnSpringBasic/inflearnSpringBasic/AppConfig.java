package inflearnSpringBasic.inflearnSpringBasic;

import inflearnSpringBasic.inflearnSpringBasic.order.service.impl.OrderServiceImpl;
import inflearnSpringBasic.inflearnSpringBasic.order.service.OrderService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import inflearnSpringBasic.inflearnSpringBasic.discount.DiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.discount.RateDiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemoryMemberReposirory;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;
import inflearnSpringBasic.inflearnSpringBasic.member.service.impl.MemberServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(
				memoryMemberReposirory());
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(
				memoryMemberReposirory(),
				discountPolicy());
	}
	
	@Bean
	public MemoryMemberReposirory memoryMemberReposirory() {
		return new MemoryMemberReposirory();
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
