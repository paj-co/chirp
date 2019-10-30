<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chirp | Register</title>
    <style>
        .error{
            color: red;
        }
         .inlineBlock{
             display: inline-block;
             width: 40%;
             min-width: 200px;
         }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>

    <div class="inlineBlock" style="vertical-align: top; margin-left: 10px">
        <h1 style="color: darkblue;">
            <a href="<c:url value="/home"/>">Chirp</a>
        </h1>
        <h4>Register and join our social network!</h4>
    </div>

    <div class="inlineBlock">
        <h3>Register!</h3>

        <form:form method="post" modelAttribute="userDTO">
            <p>
                <form:input path="firstName" placeholder="First name"/>
                <form:errors path="firstName" cssClass="error" element="p" />
            </p>
            <p>
                <form:input path="lastName" placeholder="Last name"/>
                <form:errors path="lastName" cssClass="error" element="p" />
            </p>
            <p>
                <form:input path="nick" placeholder="Nick" />
                <form:errors path="nick" cssClass="error" element="p" />
            </p>
            <p>
                <form:input path="email" placeholder="Email"/>
                <form:errors path="email" cssClass="error" element="p" />
            </p>
            <p>
                <form:password path="password" placeholder="Password"/>
                <form:errors path="password" cssClass="error" element="p" />
            </p>
            <p>
                <form:password path="matchingPassword" placeholder="Re-enter password" />
                <form:errors cssClass="error" element="p" />
            </p>
            <input type="submit" value="Register" />
        </form:form>
        or <a href="<c:url value="/login"/>">log in</a>!
    </div>

</body>
</html>