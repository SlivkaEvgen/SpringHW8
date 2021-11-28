<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>

<style>
    html, body, h1, h2, h3, h4, h5, h6 {
        font-family: "Tangerine", "Roboto", sans-serif;
    }

    .w3-display-bottommiddle {
        z-index: 2;
        width: 550px;
        line-height: initial;
    }
</style>

<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name='DC.Language' scheme='rfc1766' content='ru'/>

    <title>Products List</title>
    <jsp:include page="product.jsp"></jsp:include>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="text w3-animate">All Products</h5>
        <label for="myInput"></label>
        <input class="w3-input w3-center w3-border w3-tiny w3-round-xxlarge w3-hover-light-blue"
               type="text" placeholder="Search for id..." id="myInput" onkeyup="myFunction()">
        <table class="w3-table-all w3-small w3-centered "
               class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
               id="myTable">
            <tr class="w3-hover-light-blue">
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>MANUFACTURER</th>
                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            <c:forEach items="${list}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.manufacturer}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}update/?id=${product.id}"
                           class="w3-btn w3-hover-light-blue w3-round-xlarge">Update</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}delete/?id=${product.id}"
                           class="w3-btn w3-hover-red w3-round-xlarge">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h5 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">PRODUCT LIST</h5>
    </nav>
</div>

</body>

<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">
    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>

</div>

<div class="w3-container w3-center w3-rodoto w3-text-dark-gray">
    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/JpaServletsMVChw6" target="_blank">Slivka</a>
    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>
</div>

</html>
