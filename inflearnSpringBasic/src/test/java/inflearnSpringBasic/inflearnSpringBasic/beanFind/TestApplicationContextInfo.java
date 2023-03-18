package inflearnSpringBasic.inflearnSpringBasic.beanFind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import inflearnSpringBasic.inflearnSpringBasic.AppConfig;

public class TestApplicationContextInfo {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("모든 빈 확인")
	void findAllBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String str : beanDefinitionNames) {
			Object bean = ac.getBean(str);
			System.out.println("name : "+str+ " bean : "+bean);
		}
	}
	
	@Test
	@DisplayName("애플리케이션 빈 확인")
	void findApplicationBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String str : beanDefinitionNames) {
			BeanDefinition bd = ac.getBeanDefinition(str);
			
			// BeanDefinition.ROLE_APPLICATION		: 직접 등록한 애플리케이션 빈
			// BeanDefinition.ROLE_INFRASTRUCTURE	: 스프링이 내부에서 사용하는 빈
			if (bd.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				Object bean = ac.getBean(str);
				System.out.println("name : "+str+ " bean : "+bean);
			}
		}
	}
}
