<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<!DOCTYPE html>

<html>
<head>
    <title>Sign In</title>
    <link type="text/css" href="<spring:url value="/resources/css/pages/home.css"/>" rel="stylesheet" />
</head>
<body>
<h1>Spring Security - Sign In</h1>

<form class="login-form" action="j_spring_security_check" method="post">
    <input id="j_username" name="j_username" size="20" maxlength="50" type="text" />

    <input id="j_password" name="j_password" size="20" maxlength="50" type="password" />

    <input type="submit" value="Login" />
</form>
</body>
</html>