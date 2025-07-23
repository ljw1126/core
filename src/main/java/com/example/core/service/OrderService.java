package com.example.core.service;

import com.example.core.entity.Order;

public interface OrderService {
    Order create(Long memberId, String itemName, int itemPrice);
}
