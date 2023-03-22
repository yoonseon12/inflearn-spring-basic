package inflearnSpringBasic.inflearnSpringBasic.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inflearnSpringBasic.inflearnSpringBasic.member.object.Member;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.member.repository.MemoryMemberRepository;
import inflearnSpringBasic.inflearnSpringBasic.member.service.MemberService;

@Component
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		this.memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return this.memberRepository.findById(memberId);
	}
	
	// 테스트용
	public MemberRepository getMemberRepository() {
		return this.memberRepository;
	}
	
}
