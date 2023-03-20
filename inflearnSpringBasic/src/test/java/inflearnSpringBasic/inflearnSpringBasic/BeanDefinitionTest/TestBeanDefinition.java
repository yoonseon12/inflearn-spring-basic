package inflearnSpringBasic.inflearnSpringBasic.BeanDefinitionTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import inflearnSpringBasic.inflearnSpringBasic.AppConfig;

public class TestBeanDefinition {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
//	GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
	
	@Test
	@DisplayName("빈 설정 메타정보 확인")
	void findApplictionBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String key : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(key);
			
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinitionName = "+ key + " beanDefinition = "+beanDefinition);
			}
		}
	}
}
