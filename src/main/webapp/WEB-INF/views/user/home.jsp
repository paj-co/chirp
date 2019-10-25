<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chirp | Dashboard</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="<c:url value="/js/app.js"/> "></script
    <sec:csrfMetaTags />
    <%--https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/csrf.html--%>
    <meta name="_csrf" content="${_csrf.token}"/>
</head>
<body>

<div class="flex">

    <div id="left-panel">
        <div id="left-panel-inside">

                <span id="chirp-logo">
                    <a href="<c:url value="/" />">Chirp</a>
                </span>

            <sec:authorize access="isAuthenticated()" >
                    <span class="nick">
                        @<sec:authentication property="principal.user.nick" />
                    </span>
            </sec:authorize>

            <div id="left-panel-menu">
                <ul>
                    <li>Home</li>
                    <li>Profile</li>
                    <li>Messages</li>
                    <li>Settings</li>
                    <li>
                        <form action="<c:url value="/logout" />" method="post">
                            <input class="logoutButton" type="submit" value="Logout" />
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </form>
                    </li>
                </ul>
            </div>

        </div>
    </div>

    <div id="main-panel">

        <div id="form">
            <form id="chirp-form">
                <textarea id="new-chirp-text" type="text" name="chirp" placeholder=" What's happening?" ></textarea>
                <input id="new-chirp-submit" type="button" value="Chirp">
            </form>
        </div>
        <div id="chirpFeed">

            <%--jQuery AJAX chirps--%>

        </div>
    </div>

    <div id="right-panel">
        <div id="right-panel-inside">
            <p>Right Sidebar</p>
        </div>
    </div>
</div>

</body>
</html>