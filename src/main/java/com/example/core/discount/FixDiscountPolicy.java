package com.example.core.discount;

import com.example.core.entity.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.isVIP()) {
            return price - discountFixAmount;
        }

        return 0;
    }
}
