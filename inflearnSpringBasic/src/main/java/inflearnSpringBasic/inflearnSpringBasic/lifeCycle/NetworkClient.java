package inflearnSpringBasic.inflearnSpringBasic.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient { // implements InitializingBean, DisposableBean {
	private String url;

	public NetworkClient() {
		System.out.println("생성자 호출, url : "+url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	// 서비스 시작 시 호출
	public void connect() {
		System.out.println("connect : "+url);
	}
	
	public void call(String msg) {
		System.out.println("call : "+url+"\n msg : "+msg);
	}
	
	// 서비스 종료 시 호출
	public void disconnect() {
		System.out.println("close: "+url);
	}
	
	@PostConstruct
	public void init() throws Exception {
		System.out.println("NetworkClient.afterPropertiesSet");
		connect();
		call("초기화 연결 메시지");
		
	}
	
	@PreDestroy
	public void close() throws Exception {
		System.out.println("NetworkClient.destroy");
		disconnect();
	}
	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// InitializingBean 인터페이스 사용 시 의존관계 주입이 끝나면 호출 됨
//		System.out.println("NetworkClient.afterPropertiesSet");
//		connect();
//		call("초기화 연결 메시지");
//		
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		// DisposableBean 사용 시 스프링 컨테이너 내려갈 때 호출 됨
//		System.out.println("NetworkClient.destroy");
//		disconnect();
//	}
	

}
