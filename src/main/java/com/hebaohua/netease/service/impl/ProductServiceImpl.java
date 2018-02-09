package com.hebaohua.netease.service.impl;

import com.hebaohua.netease.entity.Product;
import com.hebaohua.netease.mapper.ProductMapper;
import com.hebaohua.netease.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hebh
 * @date 2018/2/8
 * @description:
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int insertProd(Product product) {
        return productMapper.insertProd(product);
    }

    @Override
    public Product selectProdById(int prodId) {
        return productMapper.selectProdById(prodId);
    }

    @Override
    public List<Product> listProducts() {
        return productMapper.listProducts();
    }

    @Override
    public int deleteByProdId(int prodId) {
        return productMapper.deleteByProdId(prodId);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }
}
