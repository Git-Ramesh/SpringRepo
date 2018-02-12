<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
	<body>
		<h1 style="color: blue;text-align:center;">Login App</h1>
		<hr />
		<form:form method="POST" commandName="loginCmd">
			Username: <form:input path="username" /><form:errors cssStyle="color:red;" path="username"/><br />
			Password: <form:password path="password" /><form:errors cssStyle="color:red;" path="username"/><br/>
			<input type="submit" value="Login"/>
		</form:form>
	</body>
</html>