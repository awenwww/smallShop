package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserLoginService;
import com.qfedu.service.impl.UserLoginServiceImpl;
import com.qfedu.utils.MyBeanUtils;
import com.qfedu.utils.UUIDUtils;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String methodName = request.getParameter("method");
        HttpSession session = request.getSession();
        UserLoginService userLoginService = new UserLoginServiceImpl();
        if(methodName.equals("userLogin")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            List<User> login = userLoginService.login(user);
            if(login!=null && login.size()>0){
                session.setAttribute("user",login.get(0));
                response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("index1.jsp");
            }
        }else if(methodName.equals("userRegist")){
            Map<String, String[]> map = request.getParameterMap();
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            User user=new User();
            Class class1 = user.getClass();
            MyBeanUtils.populate(user, map);
            user.setUid(UUIDUtils.getId());
            user.setCode(UUIDUtils.getCode());
            int r = userLoginService.register(user);
            if(r>0){
                response.sendRedirect("index1.jsp");
                System.out.println("注册成功");
            }else {
                response.sendRedirect("register.jsp");
            }

        } else  if(methodName.equals("checkUserLogin")){
            User user = (User) session.getAttribute("user");
            if(user!=null){
                response.getWriter().write("1");
                request.setAttribute("user", user);
//			System.out.println("有session");
            }else{
//			System.out.println("没有session");
                response.getWriter().write("0");

            }
        }else  if(methodName.equals("checkUser")){
            String username=request.getParameter("username");
            /*System.out.println(username);*/
                User user = null;
                user = userLoginService.checkUser(username);

            if(user!=null){
                    response.getWriter().write("0");
            }else{
                    response.getWriter().write("1");
            }
        }
    }
}
