package inflearnSpringBasic.inflearnSpringBasic.web.service;

import org.springframework.stereotype.Service;

import inflearnSpringBasic.inflearnSpringBasic.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {
	
	private final MyLogger myLogger;
	
	
	public void logic(String id) {
		myLogger.log("Service id : "+id);
	}
}
