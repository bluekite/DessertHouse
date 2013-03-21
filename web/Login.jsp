<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 13-3-9
  Time: 上午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">

</head>
<body>

<div class="navbar navbar-fixed-top ">
    <div class="navbar-inner">
        <div class="container">
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="">
                        <a href="<%=request.getContextPath() +"/index.jsp"%>">Home</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>


<div class="span5">
    <form style="margin-top:120px" align="center" class="form-horizontal" action="<%=request.getContextPath()+"/Login"%>" method=post>
        <fieldset>
            <legend>Customer Sign in</legend>
            <div class="control-group">
                <label class="control-label" for="userid">Your Identification</label>
                <div class="controls">
                    <input type="text" class="input-xlarge" name="userid" id="userid">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="passwd">Your Password</label>
                <div class="controls">
                    <input type="text" class="input-xlarge" name="passwd" id="passwd">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input height="30px" class="btn " type="submit" value="Log in">
                </div>
            </div>
            <legend></legend>
            <div class="control-group">
                <div class="controls">
                    <a  href="register.jsp" style="float: right" >New Customer Register</a>
                </div>
            </div>
        </fieldset>
    </form>
</div>







</body>
</html>