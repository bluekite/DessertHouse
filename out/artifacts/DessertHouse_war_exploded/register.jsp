<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 13-3-9
  Time: 上午10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>

<script language="javascript">
    function judgeNull(){
        $(".alert").alert("You must input userid !");
        if (document.getElementById("userid").value==""){
            alert("You must input userid !");
            return false;
        }else if(document.getElementById("passwd").value==""){
            alert("You must input password !");
            return false;
        }else if(document.getElementById("name").value==""){
            alert("You must input name !");
            return false;
        }else{
            return true;
        }
        return true;
    }
</script>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li class="">
                            <a href="<%=request.getContextPath() +"/index.jsp"%>">Home</a>
                        </li>
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



        <div class="container" style="margin-top:120px;margin-left: auto;margin-right: auto" align="center">
            <form name="LoginForm" action="<%=request.getContextPath()+"/Register"%>" method=post onsubmit="return judgeNull();">
                <table class="table-striped">
                    <tr>
                        <td align="cneter"><h1>Sign up</h1></td>
                    </tr>
                    <tr>
                        <td>Identification:</td>
                        <td><input type="text" name="userid" id="userid"></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" id="name"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="passwd" id="passwd"></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>
                        <td>
                            <select name="gender" id="gender" >
                                <option value="Men">Men</option>
                                <option value="Women">Women</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="address" id="address"></td>
                    </tr>

                   <tr>
                       <td><input class="btn btn-primary btn-large" style="float:right" type="submit" value="Submit"></td>
                   </tr>
                </table>
            </form>
        </div>


</body>
</html>