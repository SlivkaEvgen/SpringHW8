<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="logout.jsp" %>
<%@include file="metaLink.jsp" %>
<%--<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>--%>

<!DOCTYPE HTML>
<html>

<%--НЕ УДАЛЯТЬ--%>
<style>
    .w3-tangerine {
        font-family: "Tangerine", serif;
    }
</style>

<header>
</header>

<body>
<div class="w3-container w3-center w3-padding w3-animate w3-ios-grey">
    <h1><b>Web Market</b></h1>
    <p>This Web Application using <span class="w3-tag">SPRING</span></p>

    <a class="w3-display-buttommiddle w3-center w3-round-xlarge w3-ios-grey">
        <h6 class="date-cell w3-center w3-round-xlarge"
            style="color: darkslateblue; animation-timing-function: ease-in-out">
            <%
                Date dNow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                out.print("<h5 align=\"center\">" + ft.format(dNow) + "</h5>");
            %>
        </h6>
    </a>
    <div class="w3-container w3-center w3-round-xlarge w3-padding-50">
        <div class="w3-container w3-center w3-round-xlarge w3-ios">
            <a href="${pageContext.request.contextPath}/home"
               class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>
        </div>
    </div>
    <p></p>
    <%--    <a href="${pageContext.request.contextPath}/role"--%>
    <%--       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>--%>
    <a href="${pageContext.request.contextPath}/user"
       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>
    <a href="${pageContext.request.contextPath}/product"
       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>
    <a href="${pageContext.request.contextPath}/manufacturer"
       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>
</div>

</body>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>

</html>
