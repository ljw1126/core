package com.example.core.discount;

import com.example.core.entity.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
