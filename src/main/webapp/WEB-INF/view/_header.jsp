<%@ page import="java.util.Date" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>

<html>
<sec:authorize access="!isAuthenticated()">
    <a href="${pageContext.request.contextPath}logout"
       class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Logout</a>
</sec:authorize>
<header class="w3-container w3-center w3-padding w3-animate w3-ios-grey">

    <h1><b>Web Market</b></h1>
    <p>This Web Application using <span class="w3-tag">SPRING</span></p>

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-ios.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name='DC.Language' scheme='rfc1766' content='ru'/>

<%--    <span style="float: right">--%>
<%--        <a href="?lang=en">en</a>--%>
<%--    |--%>
<%--        <a href="?lang=ru">ru</a></span>--%>

    <a class="w3-display-buttommiddle w3-center w3-round-xlarge w3-ios-light-grey">
        <h6 class="date-cell w3-center w3-round-xlarge"
            style="color: darkslateblue; animation-iteration-count: revert; animation-timing-function: ease-in-out">
            <% out.println(new Date().toString()); %></h6>
    </a>

</header>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>

</html>

