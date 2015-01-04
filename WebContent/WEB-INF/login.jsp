<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="post" action="login">
            <fieldset>
                <legend>Login</legend>

                <label for="name">Email address <span class="required">*</span></label>
                <input type="text" id="email" name="email" value="" />
                <span class="error">${form.errors['email']}</span>
                <br />

                <label for="password">Password <span class="required">*</span></label>
                <input type="password" id="password" name="password" value="" />
                <span class="error">${form.errors['password']}</span>
                <br />

                <input type="submit" value="Login" class="labelLess" />
                <br />
                
                <p>${form.result}</p>
                <c:if test="${!empty sessionScope.session}">
                    <p>You are connected with address : ${sessionScope.session.email}</p>
                </c:if>
            </fieldset>
	</form>
</body>
</html>