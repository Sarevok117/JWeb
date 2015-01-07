<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>