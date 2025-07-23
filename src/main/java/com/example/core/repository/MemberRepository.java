package com.example.core.repository;

import com.example.core.entity.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
