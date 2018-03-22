package com.hebaohua.netease.mapper;

import com.hebaohua.netease.entity.Cart;
import com.hebaohua.netease.entity.Order;

import java.util.List;

public interface OrderMapper {
    int addOrder(Order order);

    int getSoldNumByProdId(int prodId);

    List<Order> listOrdersByUserId(int userId);
}
