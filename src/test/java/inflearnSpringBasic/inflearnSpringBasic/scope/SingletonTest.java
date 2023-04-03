package inflearnSpringBasic.inflearnSpringBasic.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

	@Test
	void singtonBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingtonBean.class);
		
		SingtonBean singtonBean1 = ac.getBean(SingtonBean.class);
		SingtonBean singtonBean2 = ac.getBean(SingtonBean.class);
		
		System.out.println("singtonBean1 : "+singtonBean1);
		System.out.println("singtonBean2 : "+singtonBean2);
		
		assertThat(singtonBean1).isSameAs(singtonBean2);
		
		ac.close();
	}
	
	@Scope("singleton")
	static class SingtonBean {
		@PostConstruct
		public void init() {
			System.out.println("SingtonBean.init()");
		}
		
		@PreDestroy
		public void destroy() {
			System.out.println("SingtonBean.destroy()");
		}
	}
}
