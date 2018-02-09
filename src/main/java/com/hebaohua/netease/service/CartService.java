package com.hebaohua.netease.service;

import com.hebaohua.netease.entity.Cart;

import java.util.List;

public interface CartService {
    int addCart(Cart cart);

    List<Cart> listCartsByUser(int userId);
}
