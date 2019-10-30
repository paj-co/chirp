<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chirp | Login</title>
    <style>
        .inlineBlock{
            display: inline-block;
            width: 40%;
            min-width: 200px;
        }
    </style>
</head>
<body>

    <div class="inlineBlock" style=" margin-left: 10px">
        <h1 style="color: darkblue;">
            <a style="text-decoration: none" href="<c:url value="/home" />">Chirp</a>
        </h1>
        <h3>Welcome to our site!</h3>
        <h3>Wanna see what is going on?</h3>
        <h3>Log in!</h3>
    </div>


    <%--TODO error message display with unsuccessful login--%>
    <div class="inlineBlock">
        <h3>Log in!</h3>
        <form method="post">
            <div>
                <label>
                    <input type="email" name="username" placeholder="Email"/>
                </label>
                <label>

                    <input type="password" name="password" placeholder="Password"/>
                </label>
                <label>
                    <input type="submit" value="Log in" />
                </label>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        or <a href="<c:url value="/register" />">register</a>!
    </div>

</body>
</html>