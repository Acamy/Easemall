package com.hebaohua.netease.service.impl;

import com.hebaohua.netease.entity.Order;
import com.hebaohua.netease.mapper.OrderMapper;
import com.hebaohua.netease.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addOrder(Order order){
        return orderMapper.addOrder(order);
    }

    @Override
    public int getSoldNumByProdId(int prodId){
        return orderMapper.getSoldNumByProdId(prodId);
    }

    @Override
    public List<Order> listOrdersByUserId(int userId){
        return orderMapper.listOrdersByUserId(userId);
    }
}
