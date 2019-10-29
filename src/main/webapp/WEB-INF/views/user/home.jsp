<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chirp | Dashboard</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="<c:url value="/js/app.js"/> "></script>
    <%--https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/csrf.html--%>
    <meta name="_csrf" content="${_csrf.token}"/>
</head>
<body>

<div class="flex">

    <%@include file="leftPanel.jspf"%>
    
    <div id="main-panel">

        <div id="form">
            <form id="chirp-form">
                <textarea id="new-chirp-text" class="form-style" type="text" name="chirp" placeholder=" What's happening?" ></textarea>
                <input id="new-chirp-submit" type="button" value="Chirp">
                <div>
                    <span id="char-count">0/280</span>
                </div>
            </form>
            <hr>
        </div>
        <div id="chirpFeed">

            <%--jQuery AJAX chirps--%>

        </div>
    </div>

    <%@include file="rightPanel.jspf"%>

</div>

</body>
</html>