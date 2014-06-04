<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>

<title>Login</title>

</head>

<body>

<form:form method="post" commandName="login">

<table>
<tr><td><form:input id="username" path="username" /></td></tr>
<tr><td><form:input id="pwd" path="pwd" /></td></tr>
<tr><td><input type="submit" id="submitId" value="Login" /></td></tr>
</table>
</form:form>

</body>

</html>