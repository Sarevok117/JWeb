<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment</title>
</head>
<body>
	<a href="/JWebb/">Home Page</a><br />
	<form method="post" action="comment" id="form">
            <fieldset>
                <legend>Comment</legend>

                <label for="comment">Comment <span class="required">*</span></label>
                <br />
                <textarea name="comment" rows=5 cols=100>Enter text here...</textarea>
                <br />
                <span class="error">${form.errors['comment']}</span>
                <br />


                <input type="submit" value="Comment" class="labelLess" />
                <br />
                
                <p>${form.result}</p>
            </fieldset>
	</form>
	<c:forEach items="${list}" var="item">
		<br/>
		<strong><c:out value="${item.user}" /></strong>
		<p><c:out value="${item.date}" /></p>
		<p><c:out value="${item.content}" /></p>
		<br/>
	</c:forEach>
</body>
</html>