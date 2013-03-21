<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Order" %>
<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/20/13
  Time: 6:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sell Desserts</title>
    <link href="../../css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../../css/bootstrap.css" rel="stylesheet">
</head>
<body>

<div class="navbar  navbar-fixed-top navbar-inverse">
    <div class="navbar-inner">
        <div class="container">
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="">
                        <a href="<%=request.getContextPath() +"/manage/Personnel.jsp"%>">Home</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() +"/manage/personnel/desInfo.jsp"%>">Dessert Info</a>
                    </li>
                    <li class="active">
                        <a href="<%=request.getContextPath() +"/manage/personnel/Sell.jsp"%>">Sell Dessert</a>
                    </li>
                </ul>
                <a class="brand pull-right" style="float: right" href="<%=request.getContextPath() + "/Signout"%>">Sign out</a>
            </div>
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
                <th>Customer</th>
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
            <form action="<%=request.getContextPath()+"/SellDes"%>" method=post>
            <tr>
                <td><input class="input-mini uneditable-input" name="desid" id="desid" value="<%=orlist.get(i).getId()%>" ></td>
                <td><%=orlist.get(i).getCustomerid()%></td>
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
                <td> <input  class="btn " type="submit" value="Sell"></td>
            </tr>
            </form>
            <%
                }
            %>

            </tbody>
        </table>
    </div>
</div>


</body>
</html>