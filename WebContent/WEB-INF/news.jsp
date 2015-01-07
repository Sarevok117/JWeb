<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>