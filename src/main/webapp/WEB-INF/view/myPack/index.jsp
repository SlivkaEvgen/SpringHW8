<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>--%>

<%--<!DOCTYPE HTML>--%>
<%--<html>--%>
<%--<h3>Index</h3>--%>

<%--<style>--%>
<%--    .w3-tangerine {--%>
<%--        font-family: "Tangerine", serif;--%>
<%--    }--%>
<%--</style>--%>

<%--<head>--%>
<%--    <meta name='DC.Language' scheme='rfc1766' content='ru'/>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">--%>
<%--    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">--%>

<%--    <title>Index Home</title>--%>
<%--    <h3>Index Home</h3>--%>

<%--    <jsp:include page="_menu.jsp"></jsp:include>--%>

<%--    <sec:authorize access="isAuthenticated()">--%>
<%--    <a href="${pageContext.request.contextPath}logout"--%>
<%--       class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Logout</a>--%>
<%--    </sec:authorize>--%>

<%--</head>--%>

<%--&lt;%&ndash;<h2>Index Home JSP</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<p class="w3-center"><a href="${pageContext.request.contextPath}login"&ndash;%&gt;--%>
<%--&lt;%&ndash;      class="w3-btn-xlarge w3-hover-red w3-center w3-round-xlarge w3-ios-background">Login</a></p>&ndash;%&gt;--%>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.name}!</h3>--%>
<%--    <p class="w3-center w3-ios-light-blue">Login OK</p>--%>

<%--    <div class="w3-container w3-center w3-round-xlarge w3-padding-48">--%>
<%--                <a href="${pageContext.request.contextPath}home"--%>
<%--                   class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">Home</a>--%>

<%--        <h3>Index Home</h3>--%>

<%--&lt;%&ndash;    <a href="${pageContext.request.contextPath}logout"&ndash;%&gt;--%>
<%--&lt;%&ndash;       class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background">Logout</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <a href="${pageContext.request.contextPath}registration"&ndash;%&gt;--%>
<%--&lt;%&ndash;       class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background">Registration</a>&ndash;%&gt;--%>
<%--    <p></p>--%>

<%--    <div class="w3-container w3-center w3-round-xlarge " style="color:indianred">--%>
<%--        <a href="${pageContext.request.contextPath}role" class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>--%>
<%--        <a href="${pageContext.request.contextPath}user" class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>--%>
<%--        <a href="${pageContext.request.contextPath}product"--%>
<%--           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>--%>
<%--        <a href="${pageContext.request.contextPath}manufacturer" class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</sec:authorize>--%>


<%--<sec:authorize access="!isAuthenticated()">--%>
<%--&lt;%&ndash;    <div class="w3-container w3-center w3-round-xlarge " style="color:indianred">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="${pageContext.request.contextPath}admin" class="w3-btn w3-hover-light-blue w3-round-xlarge">Admin</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--    <p></p>--%>
<%--    <div class="w3-container w3-center w3-round-large w3-ios-light-grey">--%>
<%--&lt;%&ndash;        <a href="${pageContext.request.contextPath}home" class="w3-btn w3-hover-light-blue w3-round-xlarge">Home</a>&ndash;%&gt;--%>
<%--        <a href="${pageContext.request.contextPath}news" class="w3-btn w3-hover-light-blue w3-round-xlarge">News</a>--%>
<%--<p></p>--%>
<%--        <a href="${pageContext.request.contextPath}login"--%>
<%--           class="w3-btn w3-hover-light-blue w3-round-xlarge w3-ios-background">Login</a>--%>
<%--    <p></p>--%>
<%--    <a href="${pageContext.request.contextPath}registration"--%>
<%--           class="w3-btn w3-hover-light-blue w3-round-xlarge w3-ios-background">Registration</a>--%>
<%--    <p></p>--%>

<%--    </div>--%>
<%--</sec:authorize>--%>

<%--    &lt;%&ndash;<sec:authorize>&ndash;%&gt;--%>

<%--    &lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
<%--    &lt;%&ndash;<sec:authorize>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="w3-hover-border-block w3-center w3-center" style="background-color: lightcoral">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <h4 class="w3-btn w3-center">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a class="w3-btn w3-center w3-ios-yellow" href="/login">Login</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <h4 class="w3-btn w3-center">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a class="w3-btn w3-center w3-ios-yellow" href="/registration">Registration</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <p></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p></p>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <p></p>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <div class="w3-hover-border-block w3-center w3-center" style="background-color: lightcoral">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <h4 class="w3-btn w3-center"><a class="w3-btn w3-center w3-ios-red" href="/logout">Выйти</a></h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <h4 class="w3-btn w3-center"><a class="w3-btn w3-center w3-ios-deep-blue" href="/registration">Зарегистрироваться</a></h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </sec:authorize>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="w3-container w3-center" style="background-color: lightcoral">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <h4><a class="w3-btn w3-center w3-ios-orange" href="/news">Новости (только пользователь)</a></h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <h4><a class="w3-btn w3-center w3-ios-light-blue" href="/admin">Пользователи (только админ)</a></h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <h4><a class="w3-btn w3-center w3-ios-light-blue" href="/home">Home</a></h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">--%>
<%--    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>--%>
<%--    &lt;%&ndash;    <p class="w3-xxlarge w3-rodoto"> &copy;Copyright <a href="https://github.com/SlivkaEvgen/JpaServletsMVChw6" target="_blank">Slivka</a>&ndash;%&gt;--%>
<%--</div>--%>

<%--<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">--%>
<%--    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/JpaServletsMVChw6" target="_blank">Slivka</a>--%>
<%--    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>--%>
<%--</footer>--%>

<%--<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>--%>

<%--</html>--%>


<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>--%>
<%--<spring:message code=""/>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--    <title><spring:message code="app.title"/> </title>--%>

<%--    <spring:theme code="stylesheet" var="themeName" />--%>
<%--    <link href='<spring:url value="/resources/css/${themeName}"/>' rel="stylesheet" />--%>

<%--</head>--%>
<%--<body>--%>
<%--<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">--%>
<%--    <a class="navbar-brand" href="#"><spring:message code="app.title"/></a>--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"--%>
<%--            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--        <span class="navbar-toggler-icon"></span>--%>
<%--    </button>--%>
<%--    <div class="collapse navbar-collapse" id="navbarCollapse">--%>
<%--        <ul class="navbar-nav mr-auto">--%>
<%--            <li class="nav-item active"><a class="nav-link" href="#"><spring:message code="app.nav.home"/> <span class="sr-only"></span></a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</nav>--%>

<%--<div role="main" class="container">--%>
<%--    <div class="jumbotron">--%>
<%--        <h1><spring:message code="app.page.header"/></h1>--%>
<%--        <p class="lead"><spring:message code="app.page.body"/></p>--%>


<%--        <div class="dropdown">--%>
<%--            <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton"--%>
<%--                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="app.theme.title"/></button>--%>
<%--            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">--%>
<%--                <a class="dropdown-item" href="?theme=pulse"><spring:message code="app.theme.pulse"/></a>--%>
<%--                <a class="dropdown-item" href="?theme=cerulean"><spring:message code="app.theme.cerulean"/></a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <hr/>--%>
<%--        <!-- Dropdown for selecting language -->--%>
<%--        <div class="dropdown">--%>
<%--            <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton"--%>
<%--                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="app.lang.title"/></button>--%>
<%--            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">--%>
<%--                <a class="dropdown-item" href="?lang=en"><spring:message code="app.lang.english"/></a>--%>
<%--                <a class="dropdown-item" href="?lang=hi"><spring:message code="app.lang.hindi"/></a>--%>
<%--                <a class="dropdown-item" href="?lang=cn"><spring:message code="app.lang.chinese"/></a>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--</div>--%>
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>