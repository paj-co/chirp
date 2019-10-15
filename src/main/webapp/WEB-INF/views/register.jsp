<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chirp | Register</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

    <h1>Register!</h1>

    <form:form method="post" modelAttribute="userDTO">
        <p>
            First name:
            <form:input path="firstName" />
            <form:errors path="firstName" cssClass="error" element="p" />
        </p>
        <p>
            Last name:
            <form:input path="lastName" />
            <form:errors path="lastName" cssClass="error" element="p" />
        </p>
        <p>
            Nick:
            <form:input path="nick" />
            <form:errors path="nick" cssClass="error" element="p" />
        </p>
        <p>
            Email:
            <form:input path="email" />
            <form:errors path="email" cssClass="error" element="p" />
        </p>
        <p>
            Password:
            <form:password path="password" />
            <form:errors path="password" cssClass="error" element="p" />
        </p>
        <p>
            Re-enter password:
            <form:password path="matchingPassword" />
            <form:errors cssClass="error" element="p" />
        </p>
        <input type="submit" value="Register" />
    </form:form>

</body>
</html>