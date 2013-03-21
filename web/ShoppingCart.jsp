<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 13-3-9
  Time: 上午3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">


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
                    <li class="active">
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
<div class="container-fluid" >

    <div class="row-fluid">
        <%
            String href = (String) session.getAttribute("desHref");
            if(href==null){
         %>
            <h1>You have ordered nothing.</h1>
        <%
            }else{
        %>
        <div class="span6">
            <img src="<%=request.getContextPath() + "/desserts/"+href%>">
        </div>
        <div class="span3">
            <%
                String name =(String) session.getAttribute("desName");
                double price =(Double) session.getAttribute("desPrice");
                int number = (Integer) session.getAttribute("desNumber");
                double discount = (Double) session.getAttribute("discount");
                int status = (Integer) session.getAttribute("custatus");
            %>
        <form style="margin-top:20px" align="center" class="form-horizontal" action="<%=request.getContextPath()+"/OrderGen"%>" method=post>
            <fieldset>
                <legend>Dessert : <%= name%></legend>
                <div class="control-group">
                    <label class="control-label" for="price">Price:</label>
                    <div class="controls">
                        <label id="price"><%= price%> 元</label>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="diccount">Discount:</label>
                    <div class="controls">
                        <label  id="diccount"><%=discount%></label>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="rnumber">Remaining Number:</label>
                    <div class="controls">
                        <label id="rnumber"><%= number%> 个</label>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="quantity">Quantity:</label>
                    <div class="controls">
                        <input type="text" class="input-mini" name="quantity" id="quantity">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="shop">Choose retail store : </label>
                    <div class="controls">
                        <select name="shop" id="shop">
                            <option value="XIANLIN">XIANLIN</option>
                            <option value="GULOU">GULOU</option>
                            <option value="PUKOU">PUKOU</option>
                        </select>
                    </div>
                </div>
                <legend></legend>
                <%
                if (status!=2)      {
                %>
                <div class="control-group">
                    <div class="controls">
                        <input height="30px" class="btn btn-primary" type="submit" style="float:right" value="Confirm Order">
                    </div>
                </div>
                <%
                }
                %>


            </fieldset>
        </form>
        </div>
        <%
            }
        %>
    </div>

</div>
</div>
   <%
         }
   %>


</body>
</html>