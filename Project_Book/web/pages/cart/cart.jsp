<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--	静态包含头 base标签，css样式，jqery文件--%>
    <%@include file="/pages/common/header.jsp" %>

    <script type="text/javascript">
        $(function () {
            //给【删除】绑定单击事件
            $("a.deleteItem").click(function () {
               return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？")
            });

            //给清空购物车绑定单击事件。
            $("#clearCart").click(function () {
                return confirm("你确定要清空购物车吗？")
            });

            //给购物车中商品修改数量绑定onChange内容发生事件。
            $(".updateCount").change(function () {
                //获取商品名称
                var name = $(this).parent().parent().find("td:first").text();
                //获取自定义的bookId属性的值。
                var bookId= $(this).attr("bookId");
                //获取商品数量
                var count = this.value;
                if(confirm("你确定要将【" + name + "】商品修改数量为："+count+"吗？")) {
                    //发起请求，给服务器保存修改
                    location.href = "http://localhost:8080/Project_Book/cartServlet?action=updateCount&count="+count+"&id="+bookId;
                }else{
                    //defaultValue属性是表单项dom对象的属性，它表示默认的value属性值
                    this.value = this.defaultValue;
                }
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png">
    <span class="wel_word">购物车</span>
    <div>
        <%--<span class="um_span">${requestScope.user.username}</span> --%>
        <span>欢迎光临小李攻城狮书城</span>
<%--        <a href="pages/order/order.jsp">我的订单</a>--%>

        <a href="index.jsp">返回</a>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <%--购物车，没有东西的情况下--%>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">亲，没得东西撒，去首页看看喽！</a></td>
            </tr>
        </c:if>

        <%--购物车，有东西的情况下--%>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount"
                               bookId = "${entry.value.id}"
                               type="text" style="width: 80px;" value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <%--		如果购物车非空，就显示下面的总金额信息。--%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clearItem">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>