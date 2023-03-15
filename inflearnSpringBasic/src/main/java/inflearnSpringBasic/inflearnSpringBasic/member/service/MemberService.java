package inflearnSpringBasic.inflearnSpringBasic.member.service;

import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;

public interface MemberService {
	
	void join(Member member);
	
	Member findMember(Long memberId);
	
}
