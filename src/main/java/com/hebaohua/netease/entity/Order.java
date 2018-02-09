package com.hebaohua.netease.entity;

import java.util.Date;

/**
 * @author Hebh
 * @date 2018/2/9
 * @description:
 */
public class Order {
    private int orderId;
    private int userId;
    private int prodId;
    private String prodTitle;
    private String prodImgUrl;
    private Double prodPrice;
    private Date date;

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public int getProdId() {
        return prodId;
    }

    public String getProdTitle() {
        return prodTitle;
    }

    public String getProdImgUrl() {
        return prodImgUrl;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public void setProdImgUrl(String prodImgUrl) {
        this.prodImgUrl = prodImgUrl;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
