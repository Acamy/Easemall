package com.hebaohua.netease.service;

import com.hebaohua.netease.entity.Order;

import java.util.List;

public interface OrderService {
    int addOrder(Order order);

    int getSoldNumByProdId(int prodId);

    List<Order> listOrdersByUserId(int userId);
}
