package com.example.core.config;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import com.example.core.repository.MemberRepository;
import com.example.core.repository.MemoryMemberRepository;
import com.example.core.service.MemberService;
import com.example.core.service.MemberServiceImpl;
import com.example.core.service.OrderService;
import com.example.core.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
