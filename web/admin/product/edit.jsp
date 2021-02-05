<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.qfedu.service.ProductService" %>
<%@ page import="com.qfedu.service.impl.ProductServiceImpl" %>
<%@ page import="com.qfedu.entity.Product" %>
<%@ page import="com.qfedu.entity.Category" %>
<%@ page import="com.qfedu.service.CategoryService" %>
<%@ page import="com.qfedu.service.impl.CategoryServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>

	<%
		//获取商品
		String pid = request.getParameter("pid");
		request.setAttribute("pid",pid);
		ProductService service=new ProductServiceImpl();
		Product proInfoById = service.findProInfoById(pid);
		request.setAttribute("pro",proInfoById);
		CategoryService categoryService=new CategoryServiceImpl();
		List<Category> allCategory = categoryService.findAllCategory();
		request.setAttribute("clist",allCategory);
	%>
	<body>
		<!--  -->
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/editProductServlet" method="post" >
			<input type="hidden" name="pid" value="${pro.pid}">
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<c:if test="${pid!=null}">
							<strong><STRONG>编辑商品</STRONG>
							</strong>
						</c:if>
						<c:if test="${pid==null}">
							<strong><STRONG>添加商品</STRONG>
							</strong>
						</c:if>

					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="pname" value="${pro.pname}" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						
						<select name="is_hot">
							<c:if test="${pro.is_hot==1}">
								<option value="1">是</option>
							</c:if>
							<c:if test="${pro.is_hot==0}">
								<option value="0">否</option>
							</c:if>
							<c:if test="${pro==null}">
								<option value="1" selected>是</option>
								<option value="0">否</option>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						市场价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="market_price" value="${pro.market_price}" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商城价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="shop_price" value="${pro.shop_price}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="cid">
							<c:forEach items="${clist}" var="list">
								<c:if test="${pro.category.cid==list.cid}">
									<option value="${list.cid}" selected>${list.cname}</option>
								</c:if>
								<c:if test="${pro.category.cid!=list.cid}">
									<option value="${list.cid}">${list.cname}</option>
								</c:if>


							</c:forEach>

						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="pdesc" rows="5" cols="30">${pro.pdesc}</textarea>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>