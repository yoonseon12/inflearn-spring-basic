package inflearnSpringBasic.inflearnSpringBasic.order;
	
import static org.assertj.core.api.Assertions.assertThat;	

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import inflearnSpringBasic.inflearnSpringBasic.AppConfig;
import inflearnSpringBasic.inflearnSpringBasic.order.object.Order;
import inflearnSpringBasic.inflearnSpringBasic.order.service.OrderService;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Grade;
import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;

public class TestOrderService {
	
	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	MemberService memberService = ac.getBean("memberService", MemberService.class);
	OrderService  orderService	= ac.getBean("orderService" , OrderService.class);
	
	@BeforeEach
	public void beforeEach() {
//		AppConfig appConfig = new AppConfig();
//		memberService = appConfig.memberService();
//		orderService = appConfig.orderService();
	}
	
	@Test
	@DisplayName("주문한다.")
	void createOrder() {
		this.memberService.join(new Member(1L, "member1", Grade.BASIC));
		this.memberService.join(new Member(2L, "member2", Grade.VIP));
		
		Order result1 = this.orderService.createOrder(1L, "상품1", 30000);
		Order result2 = this.orderService.createOrder(2L, "상품1", 30000);
		
		assertThat(result1.getDiscountPrice()).isEqualTo(0);
		assertThat(result2.getDiscountPrice()).isEqualTo(3000);
	
		System.out.println(result1);
		System.out.println(result2);
	}
}
