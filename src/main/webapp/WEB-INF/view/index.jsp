<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>

<html>

<head>

    <title>Index</title>
<%--    <h2>Index</h2>--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <jsp:include page="_header.jsp"></jsp:include>

<%--    <sec:authorize access="isAuthenticated()">--%>
<%--        &lt;%&ndash;        <c:redirect url="/"></c:redirect>&ndash;%&gt;--%>
<%--    </sec:authorize>--%>

</head>

<body>

<div>
<%--    <sec:authorize access="!isAuthenticated()">--%>

        <div class="w3-container w3-center w3-round-xlarge w3-padding-50">
            <h4>
                <a href="${pageContext.request.contextPath}login"
                   class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Log In</a>
            </h4>
            <h4>
                <a href="${pageContext.request.contextPath}registration"
                   class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Sign Up</a>
            </h4>
        </div>

<%--    </sec:authorize>--%>
</div>

</body>

<jsp:include page="frase.jsp"></jsp:include>

</html>