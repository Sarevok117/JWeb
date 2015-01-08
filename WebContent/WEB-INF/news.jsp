<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News</title>
</head>
<body>
	<a href="/Jwebb">Home Page</a><br />
	<form method="post" action="news" id="form">
            <fieldset>
                <legend>News</legend>

                <label for="news">news <span class="required">*</span></label>
                <br />
                <textarea name="news" rows=5 cols=100>Enter text here...</textarea>
                <br />
                <span class="error">${form.errors['news']}</span>
                <br />


                <input type="submit" value="News" class="labelLess" />
                <br />
                
                <p>${form.result}</p>
            </fieldset>
	</form>
	<c:forEach items="${list}" var="item">
		<br/>
		<h2><c:out value="${item.userEmail}" /></h2>
		<p><c:out value="${item.date}" /></p>
		<p><c:out value="${item.content}" /></p>
		<br/>
	</c:forEach>
</body>
</html>