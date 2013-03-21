<%@ page import="model.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/20/13
  Time: 6:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Set Customer</title>
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
                        <a href="<%=request.getContextPath() +"/manage/Administrator.jsp"%>">Home</a>
                    </li>
                    <li class="active">
                        <a href="<%=request.getContextPath() +"/manage/admin/SetCustomer.jsp"%>">Set Customer</a>
                    </li>
                    <li class="">
                        <a href="<%=request.getContextPath() +"/manage/admin/SetStaff.jsp"%>">Set Staff</a>
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
            ArrayList<Customer> clist = (ArrayList<Customer>)session.getAttribute("customers");
        %>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#ID</th>
                <th>Status</th>
                <th>Level</th>
            </tr>
            </thead>
            <tbody>
            <%
                for(int i=0;i<clist.size();i++){
            %>
            <form action="<%=request.getContextPath()+"/SetCuslevel"%>" method=post>
            <tr>
                <td><input class="input-mini uneditable-input" name="cusid" id="cusid" value="<%=clist.get(i).getUserid()%>"></td>
                <%
                    if(clist.get(i).getStatus()==0){
                %>
                <td>未激活或暂停</td>
                <%
                    }
                %>
                <%
                    if(clist.get(i).getStatus()==1){
                %>
                <td>已激活</td>
                <%
                    }
                %>
                <%
                    if(clist.get(i).getStatus()==2){
                %>
                <td>已停止</td>
                <%
                    }
                %>
                <td>
                    <select  name="level" id="level" >
                        <%
                            if (clist.get(i).getLevel()==0){
                        %>
                        <option  selected="selected" value="0">0</option>
                        <option  value="1">1</option>
                        <option  value="2">2</option>
                        <%
                        }else if(clist.get(i).getLevel()==1){
                        %>
                        <option  value="0">0</option>
                        <option selected="selected"  value="1">1</option>
                        <option  value="2">2</option>
                        <%
                            }else{
                        %>
                        <option  value="0">0</option>
                        <option  value="1">1</option>
                        <option selected="selected"  value="2">2</option>
                        <%
                            }
                        %>
                    </select>
                </td>
                <td> <input  class="btn " type="submit" value="Confirm"></td>
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