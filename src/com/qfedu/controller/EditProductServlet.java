package com.qfedu.controller;

import com.qfedu.entity.Category;
import com.qfedu.entity.Product;
import com.qfedu.service.ProductService;
import com.qfedu.service.impl.ProductServiceImpl;
import com.qfedu.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/editProductServlet")
public class EditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String pid = request.getParameter("pid");
        System.out.println(pid);
        Product product=new Product();
        product.setPname(request.getParameter("pname"));
        product.setMarket_price(Double.parseDouble(request.getParameter("market_price")));
        product.setIs_hot(Integer.parseInt(request.getParameter("is_hot")));
        product.setPdesc(request.getParameter("pdesc"));
        product.setShop_price(Double.parseDouble(request.getParameter("shop_price")));
       // product.setPflag(Integer.parseInt(request.getParameter("pflag")));
        Category category=new Category();
        category.setCid(request.getParameter("cid"));

        try {

            product.setCategory(category);
            System.out.println(product);
            ProductService service=new ProductServiceImpl();
            if(pid==null || "".equals(pid)){
                product.setPid(UUIDUtils.getCode());
                service.addPro(product);
            }else{
                product.setPid(pid);
                service.update(product);
            }
            response.sendRedirect(request.getContextPath()+"/FuzzySelectProducts");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
