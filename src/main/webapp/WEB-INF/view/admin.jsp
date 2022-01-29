<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<html>
<head>
    <style>
        .w3-tangerine {
            font-family: "Tangerine", serif;
        }
    </style>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <title>Admin</title>

</head>
<body>

<a class="w3-display-buttommiddle w3-center w3-round-xlarge w3-ios-grey">
    <h2 class="date-cell w3-center w3-round-xlarge"
        style="color: darkslateblue; animation-timing-function: ease-in-out">
    </h2>
    <div class="w3-container w3-center w3-round-xlarge w3-padding-50">
        <div class="w3-container w3-center w3-round-xlarge w3-ios">
            <%--        <a href="${pageContext.request.contextPath}/home"--%>
            <%--           class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>--%>
            <%--    </div>--%>
            <%--</div>--%>
            <p></p>
            <a href="${pageContext.request.contextPath}/note"
               class="w3-btn w3-hover-light-blue w3-round-xlarge"><i class="fa fa-envelope"></i> Note  <span class="w3-tag w3-round w3-red">New!Coming soon </span></a>

            <a href="${pageContext.request.contextPath}/weather"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge"><i class="fa fa-globe"></i> Weather  <span class="w3-tag w3-round w3-red">New!Coming soon </span></a>
            <%--<a href="${pageContext.request.contextPath}/product"--%>
            <%--   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>--%>
            <%--<a href="${pageContext.request.contextPath}/manufacturer"--%>
            <%--   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>--%>
            <%--<a href="${pageContext.request.contextPath}/note"--%>
            <%--   class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Notes</a>--%>

            <%--</a>--%>
        </div>
    </div>
    <p></p>
    <p></p>
    <p></p>

</a>
</body>
<a class="w3-centered w3-round-xlarge w3-ios-grey">
    <h2 class="date-cell w3-center w3-round-xlarge"
        style="color: darkslateblue; animation-timing-function: ease-in-out">Soon here will be Notes

    </h2>
    <h2 class="date-cell w3-center w3-round-xlarge"
        style="color: darkslateblue; animation-timing-function: ease-in-out">Soon here will be Weather

    </h2>
</a>
<%@include file="catchPhrase.jsp" %>

</html>
