package inflearnSpringBasic.inflearnSpringBasic.singleton;

public class SingletonService {
	
	// 1. static 영역에 객체를 딱 1개만 생성해둔다.
	private static final SingletonService instance = new SingletonService();
	
	// 2. public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드만을 통해서 조회하도록 허용한다. 
	public static SingletonService getInstace() {
		return instance;
	}
	
	// 3. 생성자를 private 으로 생성해서 외부에서 new 키워드를 사용하여 생성하지 못하도록 막는다.
	private SingletonService() {}
	
	public void logic() {
		System.out.println("싱글톤 로직 객체 호출");
	}
}
