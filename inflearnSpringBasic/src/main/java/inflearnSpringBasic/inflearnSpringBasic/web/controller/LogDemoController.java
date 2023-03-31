package inflearnSpringBasic.inflearnSpringBasic.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import inflearnSpringBasic.inflearnSpringBasic.common.MyLogger;
import inflearnSpringBasic.inflearnSpringBasic.web.service.LogDemoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	
	private final LogDemoService logDemoService;
	private final MyLogger myLogger;
	
	@RequestMapping("/log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestURL = request.getRequestURI();
		
		System.out.println("myLogger : " + myLogger.getClass());
		myLogger.setRequestURL(requestURL);
		
		myLogger.log("controller test");
		logDemoService.logic("testId");
		
		return "OK";
	}
}
