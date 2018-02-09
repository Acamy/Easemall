package com.hebaohua.netease.controller;

import com.hebaohua.netease.entity.Product;
import com.hebaohua.netease.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Hebh
 * @date 2018/2/8
 * @description:
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/public")
    public String publicProduct(ModelMap map){
        return "public";
    }

    @RequestMapping("/publicSubmit")
    public String publicSubmit(HttpServletRequest request, ModelMap map){
        Product product = new Product();
        product.setProdTitle(request.getParameter("title"));
        product.setProdSummary(request.getParameter("summary"));
        product.setProdImgUrl(request.getParameter("image"));
        product.setProdDetail(request.getParameter("detail"));
        product.setProdPrice(Double.valueOf(request.getParameter("price")));
        productService.insertProd(product);
        return "index";
    }

    @RequestMapping("/show")
    public String showProduct(@RequestParam("id") int prodId, ModelMap map){
        Product product = productService.selectProdById(prodId);
        map.put("product", product);
        return "show";
    }

    @RequestMapping("/edit")
    public String editProduct(@RequestParam("id") int prodId, ModelMap map){
        Product product = productService.selectProdById(prodId);
        map.put("product", product);
        return "edit";
    }

    @RequestMapping("/editSubmit")
    public String editSubmitProduct(@RequestParam("id") int prodId,
                                    HttpServletRequest request,
                                    ModelMap map){
        Product product = new Product();
        product.setProdId(prodId);
        product.setProdTitle(request.getParameter("title"));
        product.setProdSummary(request.getParameter("summary"));
        product.setProdImgUrl(request.getParameter("image"));
        product.setProdDetail(request.getParameter("detail"));
        product.setProdPrice(Double.valueOf(request.getParameter("price")));
        productService.updateProduct(product);
        map.put("product", product);
        return "editSubmit";
    }
}
