<%@ page import="java.util.ArrayList" %>
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
    <title>Scan Desserts</title>


    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="js/kissy.js"></script>
    <style>
        .ks-waterfall {
            position: absolute;
            width: 192px;
            overflow: hidden;
            padding: 15px;
            border: 2px solid #ddd;
            margin-bottom: 20px;
            text-align: center;
            left:-9999px;
            top:-9999px;
        }
    </style>

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
                    <li class="active">
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

                </ul>
            </div>

            <%
                if (session.getAttribute("login") == null) {
            %> <a class="brand" style="float: right" href="<%=request.getContextPath() + "/Login.jsp"%>">Login</a>
            <%
            } else {
            %> <a class="brand" style="float: right" href="<%=request.getContextPath() + "/Logout"%>">Logout</a>
            <%
                }
            %>

        </div>
    </div>
</div>


<div id="imgtpl" style="margin-top: 80px;position:relative">
   <%
       ArrayList<Integer> idList= new ArrayList<Integer>();
       for(int i = 1;i<=15;i++){
          idList.add(i);
    %>
    <form name="<%="order"+i%>" action="<%=request.getContextPath()+"/OrderDes"%>" method=post >
    <div class="ks-waterfall" >
    <img src="<%=request.getContextPath() + "/desserts/"+i+".jpg"%>">
    <div class="title">
        </br>
        <table>
            <tr>
                <td style=display:none><input type="text" name="dessertId" id="<%=i+""%>" value="<%=i+""%>"></td>

                <td > <input class="btn btn-info" type="submit" value="Order"></td>

            </tr>
        </table>
    </div>
    </div>
    </form>
    <%
       }
       request.setAttribute("idList",idList);
   %>

</div>

<script src="js/seed.js"></script>
<script src="js/kissy.js"></script>
<script src="js/waterfall.js"></script>

<script>
    KISSY.use("waterfall", function (S, Waterfall) {
        new Waterfall({
            container: "#imgtpl",    //节点容器
            minColCount: 2,          //最小列数
            colWidth: 235            //每列的宽度
        });
    });

</script>




</body>
</html>