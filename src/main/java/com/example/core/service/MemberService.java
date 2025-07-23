package com.example.core.service;

import com.example.core.entity.Member;

public interface MemberService {
    void join(Member member);
    Member findById(Long memberId);
}
