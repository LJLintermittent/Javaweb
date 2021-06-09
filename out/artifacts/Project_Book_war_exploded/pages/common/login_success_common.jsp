<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User:
  Date:
  Time:
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临小李攻城狮书城</span>

    <c:if test="${ sessionScope.user.username.equals('admin')}">
    <a href="orderServlet?action=showAllOrders">订单管理</a>
    </c:if>

    <c:if test="${not sessionScope.user.username.equals('admin')}">
        <a href="orderServlet?action=showAllOrders">我的订单</a>
    </c:if>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>