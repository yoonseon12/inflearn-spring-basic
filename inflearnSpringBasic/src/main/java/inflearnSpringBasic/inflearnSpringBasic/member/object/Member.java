package inflearnSpringBasic.inflearnSpringBasic.member.object;

/**
 * 회원 Object
 *
 */
public class Member {
	// 회원 ID
	private Long id;
	// 회원 명
	private String name;
	// 회원 권한
	private Grade grade;
	
	public Member(Long id, String name, Grade grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
}
