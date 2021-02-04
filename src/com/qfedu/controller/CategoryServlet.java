package com.qfedu.controller;


import com.qfedu.entity.Category;
import com.qfedu.service.CategoryService;
import com.qfedu.service.impl.CategoryServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		CategoryService service=new CategoryServiceImpl();
		try {
		/*	//从reids中获取连接
			Jedis jedis = JedisUtils.getJedis();
			//读取redis数据库中数据
			String str= jedis.get("category");
			if(str==null||"".equals(str)){
				List<com.itheima.domain.Category> categorys = service.findAllCategory();
				String cate = JSONArray.fromObject(categorys).toString();
				//将转化以后的json数据存放到redis
				jedis.set("category", cate);
//				System.out.println("走的是查询。。。");
				response.getWriter().write(cate);
			}else{
				response.getWriter().write(str);
//				System.out.println("走的是缓存。。。");
			}*/
			List<Category> categorys = service.findAllCategory();
			String cate = JSONArray.fromObject(categorys).toString();
//			System.out.println("走的是查询。。。");
			response.getWriter().write(cate);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
