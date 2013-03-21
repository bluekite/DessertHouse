<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/20/13
  Time: 1:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Personal Info</title>
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
                    <li class="active">
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
        <form style="margin-top:80px" align="center" class="form-horizontal" action="<%=request.getContextPath()+"/AlterCustomer"%>" method=post>
            <fieldset>
                <legend>Edit Personal Infomation</legend>
                <%
                    String name = (String)session.getAttribute("login");
                    String id = (String)session.getAttribute("loginid");
                    String password = (String)session.getAttribute("cupasswd");
                    String gender = (String)session.getAttribute("cugender");
                    double account = (Double)session.getAttribute("cuaccount");
                    String address = (String)session.getAttribute("cuaddress");
                    int level = (Integer)session.getAttribute("culevel");
                %>
                <div class="control-group">
                    <label class="control-label" for="userid">Identification</label>
                    <div class="controls">
                        <span class="input-medium uneditable-input" name="userid" id="userid" ><%=id%>  </span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="name">Name</label>
                    <div class="controls">
                        <input type="text" class="input-xlarge" name="name" id="name" value="<%=name%>">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="passwd">Password</label>
                    <div class="controls">
                        <input type="text" class="input-xlarge" name="passwd" id="passwd" value="<%=password%>">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="gender">Gender</label>
                    <div class="controls">
                        <select  name="gender" id="gender" value="<%=gender%>">
                            <%
                                if (gender.equals("Men")){
                             %>
                                    <option value="Men" selected="selected">Men</option>
                                    <option value="Women">Women</option>
                            <%
                                }else{
                             %>
                                    <option value="Men" >Men</option>
                                    <option value="Women" selected="selected">Women</option>
                            <%
                                }
                            %>

                        </select>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="address">Address</label>
                    <div class="controls">
                        <input type="text" class="input-xlarge" name="address" id="address" value="<%=address%>">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="account">Aaccount Balance</label>
                    <div class="controls">
                        <span  class="input-medium uneditable-input" name="account" id="account" >  <%=account%> </span>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="level">Member Level</label>
                    <div class="controls">
                        <span class="input-medium uneditable-input" name="level" id="level" > <%=level%>  </span>
                    </div>
                </div>


                <div class="control-group">
                    <div class="controls">
                        <input style="float: right" class="btn " type="submit" value="Perform Change">
                    </div>
                </div>
                <legend></legend>

                <div class="control-group" >

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