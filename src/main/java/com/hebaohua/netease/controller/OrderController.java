package com.hebaohua.netease.controller;
import com.hebaohua.netease.entity.Cart;
import com.hebaohua.netease.entity.Order;
import com.hebaohua.netease.entity.Product;
import com.hebaohua.netease.entity.User;
import com.hebaohua.netease.service.CartService;
import com.hebaohua.netease.service.OrderService;
import com.hebaohua.netease.service.ProductService;
import com.hebaohua.netease.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Hebh
 * @date 2018/2/9
 * @description:
 */
@Controller
public class OrderController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;


    // 已进行事务管理
    @RequestMapping("/api/buy")
    public void buy(@RequestBody String data, HttpSession session, ModelMap mapp){
        List<Map<String, Object>> list = JsonUtil.jsonArray2List(data);
        User user = (User)session.getAttribute("user");
        if( user!=null){
            for(Map<String , Object> map : list){
                Integer cartId = (Integer)map.get("cartId");
                Integer prodId = (Integer)map.get("id");
                Integer prodNum = (Integer)map.get("number");

                // 更新购物车中商品的状态
                Cart cart = cartService.selectCartById(cartId);
                cart.setIsBuy(1);
                cartService.updateCart(cart);

                // 更新商品自身的状态
                Product product = productService.selectProdById(prodId);
                product.setIsBuy(true);
                product.setIsSell(true);
                productService.updateProduct(product);

                Order order = new Order();
                order.setUserId(user.getUserId());
                order.setProdId(prodId);
                order.setProdTitle(product.getProdTitle());
                order.setProdPrice(product.getProdPrice());
                order.setProdImgUrl(product.getProdImgUrl());
                order.setProdNum(prodNum);
                order.setBuyTime(new Date());

                orderService.addOrder(order);
            }
        }
        mapp.addAttribute("mesage","Buy success");
        mapp.addAttribute("result", true);
        mapp.addAttribute("code", 200);


    }

    @RequestMapping("/listOrders")
    public String listOrders(HttpSession session, ModelMap map){
        User user = (User)session.getAttribute("user");
        if( user!=null) {
            List<Order> list = orderService.listOrdersByUserId(user.getUserId());
            map.put("buyList",list);
        }


        return "account";
    }

}
