package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserLoginService;
import com.qfedu.service.impl.UserLoginServiceImpl;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        HttpSession session = request.getSession();
        user.setUsername(username);
        user.setPassword(password);
        UserLoginService userLoginService = new UserLoginServiceImpl();
        List<User> login = userLoginService.login(user);
        if(login!=null && login.size()>0){
            session.setAttribute("user",login.get(0));
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("index1.jsp");
        }
    }
}
