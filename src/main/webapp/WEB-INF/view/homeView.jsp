<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>

<head>

    <title>Home</title>
    <jsp:include page="_header.jsp"></jsp:include>

</head>

<sec:authorize access="!isAuthenticated()">
    <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.name} !</h3>
</sec:authorize>

<div class="w3-container w3-center w3-round-xlarge w3-padding-50">
    <div class="w3-container w3-center w3-round-xlarge w3-ios">
        <a href="${pageContext.request.contextPath}home"
           class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>
        <p></p>

        <p></p>
        <div class="w3-container w3-center w3-round-xlarge " style="color:indianred">

<%--            <sec:authorize access="hasAuthority('ROLE_ADMIN')">--%>
                <a href="${pageContext.request.contextPath}role"
                   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>
                <a href="${pageContext.request.contextPath}user"
                   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>
<%--            </sec:authorize>--%>

            <a href="${pageContext.request.contextPath}product"
               class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>
            <a href="${pageContext.request.contextPath}manufacturer"
               class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>
        </div>
    </div>

    <%--  Фраза --%>
</div>
<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">
    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>
</div>

<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">
    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>
    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>
</footer>
<%--  Фраза --%>

</html>