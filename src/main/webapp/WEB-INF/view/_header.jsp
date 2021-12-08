<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page import="java.util.Date" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>

<html>

<style>
    .w3-tangerine {
        font-family: "Tangerine", serif;
    }
</style>

<header class="w3-container w3-center w3-padding w3-animate w3-ios-grey">

    <h1><b>Web Market</b></h1>
    <p>This Web Application using <span class="w3-tag">SPRING</span></p>

    <%--<div class="w3-container w3-center w3-round-xlarge w3-ios">
            <a href="${pageContext.request.contextPath}home"
               class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>
        </div>--%>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-ios.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name='DC.Language' scheme='rfc1766' content='ru'/>

    <a class="w3-display-buttommiddle w3-center w3-round-xlarge w3-ios-grey">
        <h6 class="date-cell w3-center w3-round-xlarge" style="color: darkslateblue; animation-iteration-count: revert; animation-timing-function: ease-in-out"><% out.println(new Date().toString()); %></h6>
    </a>

<%--    <sec:authorize access="isAuthenticated()">--%>
<%--        <p class="w3-center w3-ios-light-blue"></p>--%>
<%--        <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.name}!</h3>--%>
<%--    </sec:authorize>--%>

    <div class="w3-container w3-center w3-round-xlarge w3-padding-50">
        <div class="w3-container w3-center w3-round-xlarge w3-ios">
            <a href="${pageContext.request.contextPath}/home"
               class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>
            <p></p>

            <%--            <sec:authorize access="!isAuthenticated()">--%>
            <a href="${pageContext.request.contextPath}role"
               class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>
            <a href="${pageContext.request.contextPath}user"
               class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>
            <a href="${pageContext.request.contextPath}product"
               class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>
            <a href="${pageContext.request.contextPath}manufacturer"
               class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>
            <%--            </sec:authorize>--%>
</header>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>

</html>
