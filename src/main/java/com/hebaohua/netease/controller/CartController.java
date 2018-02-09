package com.hebaohua.netease.controller;

import com.hebaohua.netease.entity.Cart;
import com.hebaohua.netease.entity.Product;
import com.hebaohua.netease.entity.User;
import com.hebaohua.netease.service.CartService;
import com.hebaohua.netease.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hebh
 * @date 2018/2/9
 * @description:
 */
@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/addCart")
    public void addCart(@RequestParam("id") int prodId,
                          @RequestParam("num") int num,
                          HttpSession session,
                          ModelMap map){
        User user = (User)session.getAttribute("user");
        if( user!=null){
            Cart cart = new Cart();
            cart.setUserId(user.getUserId());
            cart.setProdId(prodId);
            cart.setNum(num);
            cartService.addCart(cart);
        }
        map.addAttribute("result", true);
        map.addAttribute("code", 200);
    }

    @RequestMapping("/listCart")
    public String listCart(HttpSession session,ModelMap modelMap){
        User user = (User)session.getAttribute("user");
        List<Map<String, Object>> cartList = new ArrayList<Map<String, Object>>();
        if( user!=null){
            List<Cart> carts = cartService.listCartsByUser(user.getUserId());
            for(Cart cart : carts){
                Product product = productService.selectProdById(cart.getProdId());
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("prodId", product.getProdId());
                map.put("prodTitle",product.getProdTitle());
                map.put("prodPrice", product.getProdPrice());
                map.put("prodNum", cart.getNum());
                cartList.add(map);
            }
        }
        modelMap.put("cartList", cartList);
        return "cart";
    }
}
