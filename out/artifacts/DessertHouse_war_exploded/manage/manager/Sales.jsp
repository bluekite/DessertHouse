<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Order" %>
<%@ page import="model.Dessert" %>
<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/20/13
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sale Analysis</title>
    <link href="../../css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../../css/bootstrap.css" rel="stylesheet">
</head>
<body>

<div class="navbar  navbar-fixed-top navbar-inverse">
    <div class="navbar-inner">
        <div class="container">

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active">
                        <a href="<%=request.getContextPath() +"/manage/Manager.jsp"%>">Home</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() +"/manage/manager/Sales.jsp"%>">Sale Analysis</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() +"/manage/manager/Members.jsp"%>">Member Analysis</a>
                    </li>

                </ul>
                <a class="brand pull-right" style="float: right" href="<%=request.getContextPath() + "/Signout"%>">Sign out</a>
            </div>
        </div>
    </div>
</div>

<%
    ArrayList<Order> olist = (ArrayList<Order> )session.getAttribute("allorders");
    int allorder = olist.size();
    int big = (Integer)session.getAttribute("big");
    int x=0 ,g=0,p= 0;
    for(int i=0;i<allorder;i++){

        if(olist.get(i).getShop().equals("XIANLIN")){
            x++;
        }else if(olist.get(i).getShop().equals("GULOU")){
            g++;
        }else {
            p++;
        }
    }


%>



<div class="container" style="margin-top: 80px;position: relative;">
    <section id="shop">
    <div class="span12">

        <table class="table table-striped">
            <legend>各门店订单统计</legend>
            <thead>
            <tr>
                <th>XIANLIN</th>
                <th>GULOU</th>
                <th>PUKOU</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td><%=x%></td>
                <td><%=g%></td>
                <td><%=p%></td>
            </tr>


            </tbody>
        </table>
    </div>
    </section>

    <section id="bigdes">
        <legend>热卖商品</legend>
        <div class="span12">
            <img src="<%=request.getContextPath() + "/desserts/"+big+".jpg"%>">
        </div>

    </section>

</div>



</body>
</html>