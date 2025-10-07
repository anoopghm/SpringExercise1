<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
 <form:form action="/form1/login" method="POST" modelAttribute="userObj">
   <h1>Login</h1>
   <br>
    Username : <form:input path="username" />
    <br>
    Password:<form:input path="userpass" type="password"/><br>
    <br>
    <input type="submit" value="Login"><br>
 </form:form>
 <form action="${pageContext.request.contextPath}/form1/register" method="GET">
    <input type="submit" value="Register">
</form>
 