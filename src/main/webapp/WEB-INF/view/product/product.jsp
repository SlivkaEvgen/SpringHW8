<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<%@include file="../function.jsp" %>
<%@include file="../error2.jsp" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>Product</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge w3-padding-50">
    <div class="w3-container w3-center w3-round-xlarge w3-ios">
        <a href="/product/list"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Products List</a>
        <a href="/product/id"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By ID</a>
        <a href="/product/name"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Find By Name</a>
        <%--                <a href="${pageContext.request.contextPath}/product/manufacturerId"--%>
        <%--                   class="w3-btn  w3-hover-light-blue w3-round-xlarge">Product By Manufacturer ID</a>--%>
        <%--        <a href="/product/list2"--%>
        <%--           class="w3-btn  w3-hover-light-blue w3-round-xlarge"> Manufacturers</a>--%>
        <sec:authorize access="hasRole('ROLE_ADMIN') and hasAuthority('ROLE_ADMIN')">
            <a href="/product/new"
               class="w3-btn w3-hover-light-blue w3-round-xlarge">Add New</a>
            <a href="/product/update"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge">Update</a>
            <a href="/product/delete"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge">Delete</a>
        </sec:authorize>
        <p></p>
    </div>
</div>
</body>
</html>

