<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/11/13
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager</title>
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

<div class="container" style="margin-top:80px">
    <h1>
        Hi,
        <%
            String name =(String) session.getAttribute("signin");
            out.print(name+"  ");
        %>
        : )
    </h1>

</div>

</body>
</html>