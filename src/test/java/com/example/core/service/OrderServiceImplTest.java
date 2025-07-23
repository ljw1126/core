package com.example.core.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.core.entity.Grade;
import com.example.core.entity.Member;
import com.example.core.entity.Order;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void create() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.create(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(9000);
    }

}
