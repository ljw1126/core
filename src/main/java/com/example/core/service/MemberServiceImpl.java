package com.example.core.service;

import com.example.core.entity.Member;
import com.example.core.repository.MemberRepository;
import com.example.core.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
