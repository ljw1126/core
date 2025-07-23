package com.example.core.service;

import static org.assertj.core.api.Assertions.*;

import com.example.core.config.AppConfig;
import com.example.core.entity.Grade;
import com.example.core.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
    }

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findById(1L);

        assertThat(member).isEqualTo(findMember);
    }
    
}
