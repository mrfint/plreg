<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<!DOCTYPE html>

<html>
<head>
    <title>Sign In</title>
</head>
<body>
<div class="container no-overflow" id="loginForm">
    <div class="form rounded">
        <div class="banner" style="text-align:center;"></div>
        <form action="j_spring_security_check" method="post">
            <input type="text" name="j_username" class="input-block-level" placeholder="username" required />
            <input type="password" name="j_password" class="input-block-level" placeholder="password" required />
            <button class="btn" value="Login">Login</button>
            <div class="hide error">Invalid user name or password</div>
        </form>
    </div>
    <div class="footer">
        &copy; 2001-2012 HealthTech Holding Inc.<br />
        Build 113, built at 03:07 on 03/26/2013<br />
        1<br />2
    </div>
</div>
</body>
</html>