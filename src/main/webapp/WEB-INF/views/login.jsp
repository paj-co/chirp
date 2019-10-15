<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chirp | Login</title>
</head>
<body>

    <div>
        <h3>Welcome to our site!</h3>
        <h3>Wanna see what is going on?</h3>
        <h3>Log in!</h3>
    </div>
    <div>
        Log in!
        <form:form method="post" modelAttribute="userDTO">

        </form:form>
    </div>

</body>
</html>