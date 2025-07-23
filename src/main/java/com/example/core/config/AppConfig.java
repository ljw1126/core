package com.example.core.config;

import com.example.core.discount.FixDiscountPolicy;
import com.example.core.repository.MemoryMemberRepository;
import com.example.core.service.MemberService;
import com.example.core.service.MemberServiceImpl;
import com.example.core.service.OrderService;
import com.example.core.service.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
