<%@ page import="model.Order" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/20/13
  Time: 2:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Orders of Customer</title>
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
                    <li class="">
                        <a href="<%=request.getContextPath() + "/customer/Recharge.jsp"%>">Recharge</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() + "/customer/PIM.jsp"%>">Personal Info</a>
                    </li>
                    <li class="active">
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


<div class="container" style="margin-top: 80px;position: relative;">
<div class="span12">
    <%
        ArrayList<Order> orlist = (ArrayList<Order>)session.getAttribute("orders");
    %>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Dessert</th>
            <th>Number</th>
            <th>TotalPrice</th>
            <th>Time Orders</th>
            <th>Time Sends</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <%
        for(int i=0;i<orlist.size();i++){
         %>
        <tr>
            <td><%=orlist.get(i).getId()%></td>
            <td><%=orlist.get(i).getDessertid()%></td>
            <td><%=orlist.get(i).getNumber()%></td>
            <td><%=orlist.get(i).getTotalprice()%></td>
            <td><%=orlist.get(i).getOrdertime()%></td>
            <td><%=orlist.get(i).getSendtime()%></td>
            <%
                if(orlist.get(i).getStatus()==0){
            %>
            <td>等待配货</td>
            <%
                }
            %>
            <%
                if(orlist.get(i).getStatus()==1){
            %>
            <td>已送货</td>
            <%
                }
            %>

        </tr>
        <%
        }
        %>

        </tbody>
    </table>
</div>
</div>



    <%
    }
    %>

</body>
</html>