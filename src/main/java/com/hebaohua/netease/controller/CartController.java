package com.hebaohua.netease.controller;

import com.hebaohua.netease.entity.Cart;
import com.hebaohua.netease.entity.Product;
import com.hebaohua.netease.entity.User;
import com.hebaohua.netease.service.CartService;
import com.hebaohua.netease.service.ProductService;
import com.hebaohua.netease.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.*;
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
            List<Cart> carts = cartService.listCartsByUser(user.getUserId());

            Cart cart = new Cart();
            // 判断用户的购物车中是否有该产品
            boolean isProdInCart = false;
            for(Cart c : carts){
                if(c.getProdId() == prodId){
                    isProdInCart = true;
                    cart = c;
                }
            }

            if(!isProdInCart){
                // 如果没有则添加进去
                cart.setUserId(user.getUserId());
                cart.setProdId(prodId);
                cart.setNum(num);
                cartService.addCart(cart);
            }else{
                //如果有则update add num
                cart.setNum(cart.getNum() + num);
                cartService.updateCart(cart);
            }

        }
        map.addAttribute("result", true);
        map.addAttribute("code", 200);
    }

    @RequestMapping("/listCart")
    public String listCart(HttpServletResponse response, HttpSession session, ModelMap modelMap){
        User user = (User)session.getAttribute("user");
        List<Map<String, Object>> cartList = new ArrayList<Map<String, Object>>();
        if( user!=null){
            List<Cart> carts = cartService.listCartsByUser(user.getUserId());
            for(Cart cart : carts){
                Product product = productService.selectProdById(cart.getProdId());
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("cartId", cart.getCartId());
                map.put("prodId", product.getProdId());
                map.put("prodTitle",product.getProdTitle());
                map.put("prodPrice", product.getProdPrice());
                map.put("prodNum", cart.getNum());
                cartList.add(map);

            }
        }
        modelMap.put("cartList", cartList);
        response.addCookie(new Cookie("products", JsonUtil.write2JsonStr(cartList)));
        return "cart";
    }


}
