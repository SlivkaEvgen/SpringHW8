<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>

<html>

<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <jsp:include page="_header.jsp"></jsp:include>
</head>

<body>

<div>
    <sec:authorize access="isAuthenticated()">
    <p class="w3-center w3-ios-light-blue"></p>
    <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.name}!</h3>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <div class="w3-container w3-center w3-round-xlarge w3-padding-50">
        <h4><a href="${pageContext.request.contextPath}login" class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Log In</a></h4>
        <h4><a href="${pageContext.request.contextPath}registration" class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Sign Up</a></h4>
    </sec:authorize>

            <sec:authorize access="isAuthenticated()">

        <div class="w3-container w3-center w3-round-xlarge w3-padding-50">
            <div class="w3-container w3-center w3-round-xlarge w3-ios">
                <a href="${pageContext.request.contextPath}/home"
                   class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>
                <p></p>

                <p></p>
                <div class="w3-container w3-center w3-round-xlarge " style="color:indianred">

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="${pageContext.request.contextPath}role"
                       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>
                    <a href="${pageContext.request.contextPath}user"
                       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>
                    </sec:authorize>

                    <a href="${pageContext.request.contextPath}product"
                       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>
                    <a href="${pageContext.request.contextPath}manufacturer"
                       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>
                </div>
            </div>
            </sec:authorize>

</div>

</div>

</body>

<%--  Фраза --%>
<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">
    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>
</div>

<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">
    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>
    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>
</footer>
<%--  Фраза --%>

</html>