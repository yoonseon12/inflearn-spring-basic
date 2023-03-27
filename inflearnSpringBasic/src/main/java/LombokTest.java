import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LombokTest {

	private String test1;
	private String test2;
	
	public static void main(String[] args) {
		
		LombokTest lombokTest = new LombokTest();
		
		lombokTest.setTest1("test");
		
		String name = lombokTest.getTest1();
		System.out.println(name);
		System.out.println(lombokTest);

	}

}
