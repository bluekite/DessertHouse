<%--
  Created by IntelliJ IDEA.
  User: Kite
  Date: 3/11/13
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Sign in</title>

    <link href="../css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">



</head>
<body>

<div class="navbar  navbar-fixed-top navbar-inverse">
    <div class="navbar-inner">
        <div class="container">

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="">
                        <a href="<%=request.getContextPath() +"/manage/Signin.jsp"%>">Sign in</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="span5">
<form style="margin-top:120px" align="center" class="form-horizontal" action="<%=request.getContextPath()+"/Signin"%>" method=post>
    <fieldset>
        <legend>Staff Sign in</legend>
        <div class="control-group">
            <label class="control-label" for="staffid">Your Identification</label>
            <div class="controls">
                <input type="text" class="input-xlarge" name="staffid"  id="staffid">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="staffpasswd">Your Password</label>
            <div class="controls">
                <input type="text" class="input-xlarge" name="staffpasswd" id="staffpasswd">
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input height="30px" class="btn " type="submit" style="float:right" value="Sign in">
            </div>
        </div>
    </fieldset>
</form>
</div>



</body>
</html>