package com.hebaohua.netease.entity;

/**
 * @author Hebh
 * @date 2018/2/8
 * @description:
 */
public class Product {
    private int prodId;
    private String prodTitle;
    private String prodSummary;
    private String prodImgUrl;
    private String prodDetail;
    private Double prodPrice;
    private Boolean isBuy;
    private Boolean isSell;

    public int getProdId() {
        return prodId;
    }

    public String getProdTitle() {
        return prodTitle;
    }

    public String getProdSummary() {
        return prodSummary;
    }

    public String getProdImgUrl() {
        return prodImgUrl;
    }

    public String getProdDetail() {
        return prodDetail;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public void setProdSummary(String prodSummary) {
        this.prodSummary = prodSummary;
    }

    public void setProdImgUrl(String prodImgUrl) {
        this.prodImgUrl = prodImgUrl;
    }

    public void setProdDetail(String prodDetail) {
        this.prodDetail = prodDetail;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Boolean getIsBuy() {
        return isBuy;
    }

    public Boolean getIsSell() {
        return isSell;
    }

    public void setIsBuy(Boolean isBuy) {
        this.isBuy = isBuy;
    }

    public void setIsSell(Boolean isSell) {
        this.isSell = isSell;
    }
}
