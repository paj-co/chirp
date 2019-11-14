<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Single chirp | Chirp</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="<c:url value="/js/app.js"/> " rel="script" type="text/javascript"></script>
    <script src="<c:url value="/js/singleChirp.js"/> " rel="script" type="text/javascript"></script>
</head>
<body>
    <div class="flex">
        <%@include file="leftPanel.jspf"%>

        <div id="main-panel">

            <div id="singleChirp">

                <%--jQuery AJAX chirp--%>

            </div>
        </div>

        <%@include file="rightPanel.jspf"%>
    </div>
</body>
</html>
