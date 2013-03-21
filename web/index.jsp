<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 13-3-8
  Time: 下午7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>DessertHouse</title>

      <link href="css/bootstrap-responsive.css" rel="stylesheet">
      <link href="css/bootstrap.css" rel="stylesheet">


  </head>


  <body >
  <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
          <div class="container">
              <div class="nav-collapse collapse">
                  <ul class="nav">
                      <li class="active">
                          <a href="<%=request.getContextPath() +"/index.jsp"%>">Home</a>
                      </li>
                      <%
                          if(session.getAttribute("login")!=null)  {
                      %>
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
                      <li class="">
                          <a href="<%=request.getContextPath() + "/customer/Orders.jsp"%>">Orders</a>
                      </li>
                      <%
                          }
                      %>
                  </ul>
              </div>



              <%
                  if (session.getAttribute("login") == null) {
              %> <a class="brand pull-right" style="float: right" href="<%=request.getContextPath() + "/Login.jsp"%>">Login</a>
              <%
              } else {
              %> <a class="brand pull-right" style="float: right" href="<%=request.getContextPath() + "/Logout"%>">Logout</a>
              <%
                  }
              %>
          </div>
      </div>
  </div>

  <div class="container" style="margin-top:80px">
      <h1>
          Welcome
          <%
              String name =(String) session.getAttribute("login");
              if (name != null) {
                  out.print(name+"  ");
              }else{
                  out.print(" new vistor ~  ");
              }
          %>
          : )
      </h1>

  </div>





  </body>
</html>