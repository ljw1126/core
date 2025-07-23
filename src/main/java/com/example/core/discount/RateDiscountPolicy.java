package com.example.core.discount;

import com.example.core.entity.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private final int discountPercentage = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.isVIP()) {
            return price * discountPercentage / 100;
        }

        return 0;
    }
}
