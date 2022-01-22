<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../_header.jsp" %>
<%@include file="../function.jsp" %>
<%@include file="../error2.jsp" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>Role</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge w3-padding-50">
    <div class="w3-container w3-center w3-round-xlarge w3-ios">
        <div class="w3-container w3-center w3-large" style="color:steelblue">
        </div>
        <a href="${pageContext.request.contextPath}/role/list"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Roles List</a>
        <a href="${pageContext.request.contextPath}/role/id"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Find By ID</a>
        <a href="${pageContext.request.contextPath}/role/name"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By Name</a>
        <sec:authorize access="hasRole('ROLE_ADMIN') and hasAuthority('ROLE_ADMIN')">
            <a href="${pageContext.request.contextPath}/role/new"
               class="w3-btn w3-hover-light-blue w3-round-xlarge">Add New</a>
            <a href="${pageContext.request.contextPath}/role/update"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge">Update</a>
            <a href="${pageContext.request.contextPath}/role/delete"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge">Delete</a>
        </sec:authorize>
    </div>
</div>

</body>

</html>
