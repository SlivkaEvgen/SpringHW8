<%@ page import="java.util.Date" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>
<html>

<head>
        <meta charset = "ISO-8859-1"/>
        <title>Internationalization</title>
    <meta name='DC.Language' scheme='rfc1766' content='ru'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

    <title>Home</title>
    <jsp:include page="_menu.jsp"></jsp:include>

</head>
<sec:authorize access="isAuthenticated()">
    <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.name} !</h3>
</sec:authorize>



        <a href="${pageContext.request.contextPath}logout"

           class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Logout</a>

<%--<div lang="ru" autocapitalize="on" style="language: RU"></div>--%>

<%--Select Language : <a href="?lang=en">English</a> | <a href="?lang=de">German</a> | <a href="?lang=it">Italian</a>--%>

    <div class="w3-container w3-center w3-round-xlarge w3-padding-48">
        <div class="w3-container w3-center w3-round-xlarge w3-ios">
            <a href="${pageContext.request.contextPath}home"
               class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>
            <p></p>

            <p></p>
            <div class="w3-container w3-center w3-round-xlarge " style="color:indianred">
                <a href="${pageContext.request.contextPath}role"
                   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>
                <a href="${pageContext.request.contextPath}user"
                   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>
                <a href="${pageContext.request.contextPath}product"
                   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>
                <a href="${pageContext.request.contextPath}manufacturer"
                   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>


            </div>
        </div>

        <p></p>
                <p>

                </p>

    </div>
    <div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">
        <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>
    </div>

    <footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">
        <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/JpaServletsMVChw6" target="_blank">Slivka</a>
        <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>
    </footer>

    <jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>

</html>

