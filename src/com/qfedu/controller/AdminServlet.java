package com.qfedu.controller;

import com.qfedu.dao.AdminDao;
import com.qfedu.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应的编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");//获取用户名
        String password = request.getParameter("password");//获取密码
//        System.out.println(username);
//        System.out.println(password);
        AdminDao admin1 = new AdminDao();
        try {
            Admin currentAdmin = admin1.login(username, password);

            //登录
            if(currentAdmin != null) {
                HttpSession session = request.getSession();
                //session.setAttribute("login",currentAdmin);
               // response.sendRedirect("web/welcome.jsp");
                request.getRequestDispatcher("admin/home.jsp").forward(request,response);
            } else {
                request.setAttribute("error","错误");
                request.getRequestDispatcher("admin").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
