<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Page</title>
	</head>
	<body>
		<form method = "post" action = "login.do">
		<input type = "hidden" name = "action" value = "login">
			Username: <input type ="text" name ="uname">
			Password: <input type ="password" name ="upass">
			
			<input type = "submit" value ="login">
		</form>
	</body>
</html>