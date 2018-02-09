package com.hebaohua.netease.service;

import com.hebaohua.netease.entity.Product;

import java.util.List;

public interface ProductService {
    int insertProd(Product product);

    Product selectProdById(int prodId);

    List<Product> listProducts();

    int deleteByProdId(int prodId);

    int updateProduct(Product product);
}
