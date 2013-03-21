<%@ page import="model.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/20/13
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member Analysis</title>
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
    ArrayList<Customer> clist = (ArrayList<Customer> )session.getAttribute("customers");
    int all = clist.size();
    int zero=0 ,one=0,two= 0;
    for(int i=0;i<all;i++){
        if(clist.get(i).getStatus()==0){
              zero++;
        }else if(clist.get(i).getStatus()==1){
              one++;
        }else {
            two++;
        }
    }
    double zerop=(double)zero/(double)all;
    double onep=(double)one/(double)all;
    double twop=(double)two/(double)all;
%>

<div class="container" style="margin-top: 80px;position: relative;">
    <div class="span12">

        <table class="table table-striped">
            <legend>各种会员所占比</legend>
            <thead>
            <tr>
                <th>暂停</th>
                <th>激活</th>
                <th>停用</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td><%=zerop%></td>
                <td><%=onep%></td>
                <td><%=twop%></td>
            </tr>


            </tbody>
        </table>
    </div>
</div>



</body>
</html>