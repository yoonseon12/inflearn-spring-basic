package inflearnSpringBasic.inflearnSpringBasic.autowired;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import inflearnSpringBasic.inflearnSpringBasic.AutoAppConfig;
import inflearnSpringBasic.inflearnSpringBasic.discount.DiscountPolicy;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Grade;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;

public class AllBeanTest {
	
	@Test
	void findAllBean() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
		
		DiscountService discountService = ac.getBean(DiscountService.class);
		Member member = new Member(1L, "member", Grade.VIP);
		
		int fixDiscountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
		
		assertThat(fixDiscountPrice).isEqualTo(1000);
		
		int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
		
		assertThat(rateDiscountPrice).isEqualTo(2000);
	}
	
	static class DiscountService {
		private final Map<String, DiscountPolicy> policyMap;
		private final List<DiscountPolicy> policyList;
		
		public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
			this.policyMap  = policyMap;
			this.policyList = policyList;
			
			System.out.println("policyMap  : "+policyMap);
			System.out.println("policyList : "+policyList);
		}

		public int discount(Member member, int price, String discountCode) {
			DiscountPolicy discountPolicy = policyMap.get(discountCode);
			return discountPolicy.discount(member, price);
			
		}
	}
}
