<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<center>
	<h1>Spring Boot Security</h1>
		<form action="/login">
			<table>
				<tr><td>Username : </td><td><input type="text" name="username"/></tr>
				<tr><td>Password : </td><td><input type="password" name="password"/></tr>
				<tr><td>&nbsp;</td><td><input type="submit" name="submit" value="Submit"></td></tr>
			</table>
		</form>
	</center>
</body>
</html>