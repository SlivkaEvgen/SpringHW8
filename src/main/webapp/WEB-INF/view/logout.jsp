<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Logout</title>

<%--    <sec:authorize access="isAuthenticated()">--%>
        <%-- добавит вариант
        <%--    <span style="float: right">--%>
        <%--        <a href="?lang=en">en</a>--%>
        <%--    |--%>
        <%--        <a href="?lang=ru">ru</a></span>--%>
        <%--&ndash;%&gt;--%>
        <a class="w3-text w3-round-xlarge w3-display-topleft">${pageContext.request.userPrincipal.name}</a>
        <a href="${pageContext.request.contextPath}/logout" class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Logout</a>

<%--    </sec:authorize>--%>

</head>

<body>

</body>

</html>
