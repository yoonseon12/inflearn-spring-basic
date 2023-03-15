package inflearnSpringBasic.inflearnSpringBasic.member.repository;

import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;

public interface MemberRepository {
	
	void save(Member member);
	Member findById(Long memberId);
	
}
