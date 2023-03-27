package inflearnSpringBasic.inflearnSpringBasic.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;

public class TestAutowired {

	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
		
	}
	
	static class TestBean {
		
		// 호출 안됨
		@Autowired(required = false)
		public void setNoBean1(Member noBean1) {
			System.out.println("noBean1 : "+noBean1);
		}
		
		// null 호출
		@Autowired
		public void setNoBean2(@Nullable Member noBean2) {
			System.out.println("noBean2 : "+noBean2);
		}
		
		// Optional.empty 호출
		@Autowired
		public void setNoBean1(Optional<Member> noBean3) {
			System.out.println("noBean3 : "+noBean3);
		}
	}
	
}
