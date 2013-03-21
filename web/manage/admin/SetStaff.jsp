<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Staff" %>
<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/20/13
  Time: 6:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Set Staff</title>
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
                    <li class="">
                        <a href="<%=request.getContextPath() +"/manage/admin/SetCustomer.jsp"%>">Set Customer</a>
                    </li>
                    <li class="active">
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
            ArrayList<Staff> slist = (ArrayList<Staff>)session.getAttribute("staffs");
        %>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#ID</th>
                <th>Name</th>
                <th>Retail Shop</th>
            </tr>
            </thead>
            <tbody>
            <%
                for(int i=0;i<slist.size();i++){
            %>
            <form action="<%=request.getContextPath()+"/SetStaffshop"%>" method=post>
                <tr>
                    <td><input class="input-mini uneditable-input" name="stid" id="stid" value="<%=slist.get(i).getWorkid()%>"></td>
                    <td><%=slist.get(i).getName()%></td>
                    <td>
                        <select  name="shop" id="shop" >
                            <%
                                if (slist.get(i).getWorkshop().equals("XIANLIN")){
                            %>
                            <option  selected="selected" value="XIANLIN">XIANLIN</option>
                            <option  value="GULOU">GULOU</option>
                            <option  value="PUKOU">PUKOU</option>
                            <%
                            }else if(slist.get(i).getWorkshop().equals("GULOU")){
                            %>
                            <option   value="XIANLIN">XIANLIN</option>
                            <option  selected="selected" value="GULOU">GULOU</option>
                            <option  value="PUKOU">PUKOU</option>
                            <%
                            }else{
                            %>
                            <option   value="XIANLIN">XIANLIN</option>
                            <option   value="GULOU">GULOU</option>
                            <option selected="selected" value="PUKOU">PUKOU</option>
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