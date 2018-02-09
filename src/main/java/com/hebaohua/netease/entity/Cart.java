package com.hebaohua.netease.entity;

/**
 * @author Hebh
 * @date 2018/2/9
 * @description:
 */
public class Cart {
    private int cartId;
    private int prodId;
    private int userId;
    private int num;

    public int getCartId() {
        return cartId;
    }

    public int getProdId() {
        return prodId;
    }

    public int getUserId() {
        return userId;
    }

    public int getNum() {
        return num;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
