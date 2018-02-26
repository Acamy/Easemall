package com.hebaohua.netease.service;

import com.hebaohua.netease.entity.Cart;
import com.hebaohua.netease.entity.Order;

import java.util.List;

public interface CartService {
    int addCart(Cart cart);

    List<Cart> listCartsByUser(int userId);

    int updateCart(Cart cart);

    public Cart selectCartById(int cartId);
}
