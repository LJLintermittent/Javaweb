<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城会员登录页面</title>
    <%--	静态包含头 base标签，css样式，jqery文件--%>
    <%@include file="/pages/common/header.jsp" %>
    <script type="text/javascript">


        $(function () {

            $("#sub_btn").click(function () {

                //正则表达式，判断用户和密码的格式是否正确
                var Patt = /^\w{5,12}$/;


                //1.验证用户账号输入格式
                var usernameText = $("input[name='username']").val();

                if (!Patt.test(usernameText)) {
                    $("span.errorMsg").text("用户名输入错误");
                    return false;
                }

                //2.验证用户账号输入格式
                var passwordText = $("input[name='password']").val();

                if (!Patt.test(passwordText)) {

                    $("span.errorMsg").text("密码输入错误");
                    return false;
                }

                $("#errorMsg").text("");
            });

        });
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.png">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>小李攻城狮书城</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        <%--<%=request.getAttribute("msg")==null? "请输入用户名或密码":request.getAttribute("msg")%>--%>
						${ empty requestScope.msg ? "请输入用户名或密码":requestScope.msg }
					</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login">

                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" value="${requestScope.username}" />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>