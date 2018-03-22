package com.hebaohua.netease.controller;

import com.hebaohua.netease.entity.Order;
import com.hebaohua.netease.entity.Product;
import com.hebaohua.netease.entity.User;
import com.hebaohua.netease.service.OrderService;
import com.hebaohua.netease.service.ProductService;
import com.hebaohua.netease.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Hebh
 * @date 2018/2/8
 * @description:
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/public")
    public String publicProduct(ModelMap map){
        return "public";
    }

    @RequestMapping("/publicSubmit")
    public String publicSubmit(@RequestParam(value = "imgFile", required = false) MultipartFile file, HttpServletRequest request, ModelMap map){
        Product product = new Product();

        if(file == null || file.isEmpty() || file.getSize() < 1){
            product.setProdImgUrl(request.getParameter("image"));
        }else{
            String path = FileUploadUtil.getFileInfo(request, file);
            product.setProdImgUrl(path);

        }


        product.setProdTitle(request.getParameter("title"));
        product.setProdSummary(request.getParameter("summary"));

        product.setProdDetail(request.getParameter("detail"));
        product.setProdPrice(Double.valueOf(request.getParameter("price")));
        productService.insertProd(product);

        List<Product> products= productService.listProducts();
        map.addAttribute("productList", products);
        return "index";
    }

    @RequestMapping("/show")
    public String showProduct(@RequestParam("id") int prodId, HttpSession session, ModelMap map){
        Product product = productService.selectProdById(prodId);
        map.put("product", product);

        User user = (User)session.getAttribute("user");
        if( user!=null) {
            List<Order> orders = orderService.listOrdersByUserId(user.getUserId());
            for (Order order : orders){
                if(order.getProdId() == prodId){
                    map.put("productBuyPrice", order.getProdPrice());
                }
            }
        }

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
                                    @RequestParam(value = "imgFile", required = false) MultipartFile file,
                                    HttpServletRequest request,
                                    ModelMap map){
        Product product = new Product();
        product.setProdId(prodId);

        if(file == null || file.isEmpty() || file.getSize() < 1){
            product.setProdImgUrl(request.getParameter("image"));
        }else{
            String path = FileUploadUtil.getFileInfo(request, file);
            product.setProdImgUrl(path);

        }

        product.setProdTitle(request.getParameter("title"));
        product.setProdSummary(request.getParameter("summary"));
        product.setProdDetail(request.getParameter("detail"));
        product.setProdPrice(Double.valueOf(request.getParameter("price")));
        productService.updateProduct(product);
        map.put("product", product);
        return "editSubmit";
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id, ModelMap map){
        productService.deleteByProdId(id);
        map.addAttribute("result", true);
        map.addAttribute("code", 200);
    }
}
