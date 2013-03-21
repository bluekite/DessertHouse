<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Dessert" %>
<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/20/13
  Time: 4:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<Script Language="JavaScript">
    function del()
    {
        document.twotwo.action="";
        document.twotwo.submit();
        alert("del");
    }

    function edi()
    {
        document.twotwo.action="<%=request.getContextPath()+"/EditDes"%>";
        document.twotwo.submit();
        alert("edit");
    }
</Script>

<html>
<head>
    <title>Dessert Info</title>
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
                    <li class="active">
                        <a href="<%=request.getContextPath() +"/manage/personnel/desInfo.jsp"%>">Dessert Info</a>
                    </li>
                    <li class="">
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
            ArrayList<Dessert> delist = (ArrayList<Dessert>)session.getAttribute("desserts");
        %>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Price</th>
                <th>Number</th>
                <th>Href</th>
            </tr>
            </thead>
            <tbody>
            <%
                for(int i=0;i<delist.size();i++){
            %>
            <form name="twotwo"method="post" action="<%=request.getContextPath()+"/EditDes"%>">
            <tr>
                <td><input class="input-mini uneditable-input" name="desid" id="desid" value="<%=delist.get(i).getId()%>"></td>
                <td><input type="text" class="input-mini" name="desname" id="desname" value="<%=delist.get(i).getName()%>"></td>
                <td><input type="text" class="input-mini" name="desprice" id="desprice" value="<%=delist.get(i).getPrice()%>"></td>
                <td><input type="text" class="input-mini" name="desnumber" id="desnumber" value="<%=delist.get(i).getNumber()%>"></td>
                <td><input type="text" class="input-mini" name="deshref" id="deshref" value="<%=delist.get(i).getHref()%>"></td>
                <td> <input  class="btn " type="submit" name="function" value="edit" ></td>
                <td> <input  class="btn " type="submit" name="function" value="delete" ></td>

            </tr>
            </form>
            <%
                }
            %>

            <form name = "one" action="<%=request.getContextPath()+"/AddDes"%>" method=post>
            <tr>
                <td></td>
                <td><input type="text" class="input-mini" name="newname" id="newname" ></td>
                <td><input type="text" class="input-mini" name="newprice" id="newprice" ></td>
                <td><input type="text" class="input-mini" name="newnumber" id="newnumber" ></td>
                <td><input type="text" class="input-mini" name="newhref" id="newhref"></td>
                <td> <input  class="btn " type="submit" value="add"></td>
            </tr>
            </form>

            </tbody>
        </table>
    </div>
</div>

</body>
</html>