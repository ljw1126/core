package com.example.core.discount;

import static org.assertj.core.api.Assertions.*;

import com.example.core.entity.Grade;
import com.example.core.entity.Member;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void discountWhenVip() {
        Member member = new Member(1L ,"member1", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void discountWhenNotVip() {
        Member member = new Member(2L ,"member2", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}
