package com.hebaohua.netease.service.impl;

import com.hebaohua.netease.entity.Cart;
import com.hebaohua.netease.entity.Order;
import com.hebaohua.netease.mapper.CartMapper;
import com.hebaohua.netease.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hebh
 * @date 2018/2/9
 * @description:
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public int addCart(Cart cart) {
        return cartMapper.addCart(cart);
    }

    @Override
    public List<Cart> listCartsByUser(int userId) {
        return cartMapper.listCartsByUser(userId);
    }

    @Override
    public int updateCart(Cart cart){
        return cartMapper.updateCart(cart);
    }

    @Override
    public Cart selectCartById(int cartId){
        return cartMapper.selectCartById(cartId);
    }
}
