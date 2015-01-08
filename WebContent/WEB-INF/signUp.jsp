<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up</title>
</head>
<body>
	<a href="/Jwebb">Home Page</a><br />
	<form method="post" action="signup">
            <fieldset>
                <legend>Sign up</legend>

                <label for="email">Email <span class="required">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <span class="error">${form.errors['email']}</span>
                <br />

                <label for="password">Password <span class="required">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <span class="error">${form.errors['password']}</span>
                <br />

                <label for="confirmation">Password confirmation <span class="required">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="error">${form.errors['confirmation']}</span>
                <br />

                <label for="name">User name</label>
                <input type="text" id="name" name="name" value="" size="20" maxlength="20" />
                <span class="error">${form.errors['name']}</span>
                <br />

				<input type="checkbox" name="news" value="news" /> 
				<label for="news">Subscribe to our newsletter</label>
				<br />
								
                <input type="submit" value="SignUp" class="labelLess" />
                <p>${form.result}</p>
                <br />
            </fieldset>
        </form></body>
</html>