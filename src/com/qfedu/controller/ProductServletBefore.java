package com.qfedu.controller;


import com.qfedu.entity.*;
import com.qfedu.service.ProductService;
import com.qfedu.service.impl.ProductServiceImpl;
import com.qfedu.utils.BaseServlet;
import com.qfedu.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/ProductServletBefore")
public class ProductServletBefore extends BaseServlet {
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

			//����û�Я��������cookie���������¼��
			Cookie[] cookies = request.getCookies();
			//����һ��������������Ʒ����
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
			//�������¼����Ϣ��ŵ�request��
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
			//��ȡ�ͻ��˴�������coockies�Ƿ����pids
			String pids=pid;
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
				for (Cookie cookie : cookies) {
					if("pids".equals(cookie.getName())){
						//����û���������pidscook��ֵ
						pids=cookie.getValue();
						//1-3-2 ���η��ʵ���8-----��8-1-3-2
						//1-3-2 ���η��ʵ���2-----��2-1-3
						//1-3-2 ���η��ʵ���3-----��3-1-2
						String[] split = pids.split("-");
//						for (String str : split) {
//							System.out.println(str);
//						}
						List<String> asList = Arrays.asList(split);
						LinkedList<String> linkedList=new LinkedList<String>(asList);
						//�жϱ��η��ʵ�pid�Ƿ��������ǰ�ķ��ʼ�¼��
						if(linkedList.contains(pid)){
							//��������Ļ�����ɾ��
							linkedList.remove(pid);
						}
						//�ѷ��ʵ�pid����ͷ��
						linkedList.addFirst(pid);

						//Ȼ���linkedList�ڻ�ԭ����ǰ��1-2-3��ģʽ
						StringBuffer sb=new StringBuffer();
						for(int i=0;i<linkedList.size()&&i<7;i++){
							sb.append(linkedList.get(i));
//							System.out.println(linkedList.get(i));
							sb.append("-");
						}
//						System.out.println(sb);
						//�õ�����1-2-3- ȥ�������-
						pids=sb.substring(0, sb.length()-1);
//						System.out.println(pids);
					}
				}
			}
			Cookie cook_pids=new Cookie("pids", pids);
			response.addCookie(cook_pids);

			//ҳ����ת
			request.getRequestDispatcher("product_info.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
