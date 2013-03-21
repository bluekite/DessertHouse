<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/19/13
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recharge</title>
    <link href="../css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>

<div class="navbar  navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="">
                        <a href="<%=request.getContextPath() +"/index.jsp"%>">Home</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() + "/desserts.jsp"%>">Desserts</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() + "/ShoppingCart.jsp"%>">ShoppingCart</a>
                    </li>
                    <li class="active">
                        <a href="<%=request.getContextPath() + "/customer/Recharge.jsp"%>">Recharge</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() + "/customer/PIM.jsp"%>">Personal Info</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() + "/customer/Orders.jsp"%>">Orders</a>
                    </li>
                </ul>
            </div>

            <%
                if (session.getAttribute("login") == null) {
            %> <a class="brand" style="float: right" href="<%=request.getContextPath() + "/Login.jsp"%>">Login</a>

        </div>
    </div>
</div>

<div class="container" style="margin-top: 80px;position: relative;">
    <h1>Sorry, your haven't signed in......</h1>
</div>

            <%
            } else {
            %> <a class="brand" style="float: right" href="<%=request.getContextPath() + "/Logout"%>">Logout</a>

        </div>
    </div>
</div>


<div class="container" >
<div class="span5" >
    <form style="margin-top:120px" align="center" class="form-horizontal" action="<%=request.getContextPath()+"/Recharge"%>" method=post>
        <fieldset>
            <legend>Recharge</legend>
            <div class="control-group">
                <label class="control-label" for="money">Amount of Money:</label>
                <div class="controls">
                    <input type="text" class="input-xlarge" name="money" id="money">
                </div>
            </div>

            <%
                int status = (Integer)session.getAttribute("custatus");
                if (status!=2)      {
            %>
            <div class="control-group">
                <div class="controls">
                    <input style="float: right" class="btn " type="submit" value="Recharge">
                </div>
            </div>
            <%
                }
            %>

            <legend></legend>

            <div class="control-group" >
                <%
                    if (status==0){
                %>
                    <h1>您的账户未激活或暂停中</h1>
                <%
                    }else if(status==1){
                %>
                    <h1>您的账户已激活</h1>
                <%
                    }else{
                %>
                    <h1>您的账户已停止</h1>
                <%
                    }
                %>

            </div>
        </fieldset>
    </form>
</div>
</div>
<%
    }
%>

</body>
</html>