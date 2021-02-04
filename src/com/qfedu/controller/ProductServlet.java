package com.qfedu.controller;


import com.qfedu.entity.PageBean;
import com.qfedu.entity.Product;
import com.qfedu.service.ProductService;
import com.qfedu.service.impl.ProductServiceImpl;
import com.qfedu.utils.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void prByCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String cid=request.getParameter("cid");
		String currentPage=request.getParameter("currentPage");
		ProductService service=new ProductServiceImpl();
		try {
			PageBean<Product> pageBean= service.findByCategoryProduct(cid,currentPage);
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("cid", cid);
			
			//获得用户携带过来的cookie关于浏览记录的
			Cookie[] cookies = request.getCookies();
			//创建一个集合用来放商品集合
			List<Product> historyPro=new ArrayList<Product>();
			
			if(cookies!=null){
				for (Cookie cookie : cookies) {
					if("pids".equals(cookie.getName())){
						String value = cookie.getValue();
						String[] pids=value.split("-");
						for(int i=0;i<pids.length;i++){
							Product hisPro = service.findProInfoById(pids[i]);
							historyPro.add(hisPro);						}
					}
				}
			}
			//将浏览记录的信息存放到request中
			request.setAttribute("historyPro", historyPro);
			
			
			
			if(currentPage==null){
				request.setAttribute("currentPage", 1);	
			}else{
				request.setAttribute("currentPage", currentPage);		
			}
			
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void findProInfoById(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		// TODO Auto-generated method stub
		String pid=request.getParameter("pid");
		String cid=request.getParameter("cid");
		String currentPage=request.getParameter("currentPage");
		ProductService service=new ProductServiceImpl();
		try {
			Product productInfo = service.findProInfoById(pid);
			request.setAttribute("productInfo", productInfo);
			request.setAttribute("cid", cid);
			request.setAttribute("currentPage", currentPage);
			//获取客户端传过来的coockies是否包含pids
			String pids=pid;
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
				for (Cookie cookie : cookies) {
					if("pids".equals(cookie.getName())){
						//获得用户传过来的pidscook的值
						pids=cookie.getValue();
						//1-3-2 本次访问的是8-----》8-1-3-2
						//1-3-2 本次访问的是2-----》2-1-3
						//1-3-2 本次访问的是3-----》3-1-2
						String[] split = pids.split("-");
//						for (String str : split) {
//							System.out.println(str);
//						}
						List<String> asList = Arrays.asList(split);
						LinkedList<String> linkedList=new LinkedList<String>(asList);
						//判断本次访问的pid是否包含在以前的访问记录中
						if(linkedList.contains(pid)){
							//如果包含的话把它删除
							linkedList.remove(pid);
						}
						//把访问的pid加在头部
						linkedList.addFirst(pid);
						
						//然后把linkedList在还原成以前的1-2-3的模式
						StringBuffer sb=new StringBuffer();
						for(int i=0;i<linkedList.size()&&i<7;i++){
							sb.append(linkedList.get(i));
//							System.out.println(linkedList.get(i));
							sb.append("-");
						}
//						System.out.println(sb);
						//得到的是1-2-3- 去掉后面的-
						pids=sb.substring(0, sb.length()-1);
//						System.out.println(pids);
					}
				}
			}
			Cookie cook_pids=new Cookie("pids", pids);
			response.addCookie(cook_pids);
			
			//页面跳转
			request.getRequestDispatcher("product_info.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
