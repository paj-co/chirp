<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chirp | Dashboard</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet" />
</head>
<body>

    <div class="flex">
        <div id="left-panel">
            <span id="chirp-logo">
                <a href="<c:url value="/" />">Chirp</a>
            </span>

            <sec:authorize access="isAuthenticated()" >
                <span>
                    @<sec:authentication property="principal.user.nick" />
                </span>
            </sec:authorize>

            <p>
                Left Sidebar
            </p>
            <p>Profile</p>
            <p>Messages</p>
            <p>Settings</p>

            <form action="<c:url value="/logout" />" method="post">
                <input type="submit" value="Logout" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
        <div id="main-panel">
            <div>
                <p>
                    Main Sidebar
                </p>
            </div>
        </div>
        <div id="right-panel">
            <p>Right Sidebar</p>
        </div>
    </div>

</body>
</html>