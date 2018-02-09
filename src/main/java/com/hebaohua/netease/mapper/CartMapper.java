package com.hebaohua.netease.mapper;

import com.hebaohua.netease.entity.Cart;
import com.hebaohua.netease.entity.Product;

import java.util.List;

public interface CartMapper {
    int addCart(Cart cart);

    List<Cart> listCartsByUser(int userId);
}
