package com.qfedu.controller;

import com.qfedu.entity.Cart;
import com.qfedu.entity.CartItem;
import com.qfedu.entity.Product;
import com.qfedu.service.ProductService;
import com.qfedu.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/addProToCartServlet")
public class addProToCartServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service=new ProductServiceImpl();
        HttpSession session = request.getSession();
        //获取要加入购物车的商品ID
        String pid=request.getParameter("pid");
        //获取要购买的数量
        String buyNum=request.getParameter("buyNum");
        //得到该商品
        try {
            Product product = service.findProInfoById(pid);
            //算一下钱数
            double subTotal=product.getShop_price()*Integer.parseInt(buyNum);
            CartItem item=new CartItem();
            item.setBuyNum(Integer.parseInt(buyNum));
            item.setProduct(product);
            item.setSubTotal(subTotal);
            //判断购物车中是否已经存在session
            Cart cart=(Cart) session.getAttribute("cart");
            if(cart==null){
                cart=new Cart();
            }
            //判断该购物项以前是否加入过购物车
            HashMap<String, CartItem> cartItems = cart.getCartItems();
            CartItem cartItem = cartItems.get(pid);
            if(cartItem!=null){
                int newBuyNum=cartItem.getBuyNum()+item.getBuyNum();
                double newSubTotal=cartItem.getSubTotal()+item.getSubTotal();
                cartItem.setBuyNum(newBuyNum);
                cartItem.setSubTotal(newSubTotal);


            }else{
                //将购物项放到购物车中
                cart.getCartItems().put(pid, item);
            }
            cart.setTotal(cart.getTotal()+item.getSubTotal());



            session.setAttribute("cart", cart);

            response.sendRedirect("cart.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
