<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chirp | Dashboard</title>
    <style>
        .inlineBlock{
            display: inline-block;
        }
    </style>
</head>
<body>

    <div id="top-panel">
        Chirp | Top pannel | <%--TODO display user name--%>

        <sec:authorize access="isAuthenticated()" >
            <span>
                <sec:authentication property="principal.user.nick" />
            </span>
        </sec:authorize>

        <form action="<c:url value="/logout" />" method="post">
            <input type="submit" value="Logout" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>

    </div>
    <div id="left-panel" class="inlineBlock">Left Sidebar</div>
    <div id="main-panel" class="inlineBlock">Main Sidebar</div>
    <div id="right-panel" class="inlineBlock">Right Sidebar</div>

</body>
</html>
