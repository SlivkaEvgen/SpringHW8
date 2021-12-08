<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>User</title>

    <jsp:include page="../_header.jsp"></jsp:include>
    <jsp:include page="../function.jsp"></jsp:include>
    <jsp:include page="../metaLink.jsp"></jsp:include>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge w3-padding-50">
    <div class="w3-container w3-center w3-round-xlarge w3-ios">
        <a href="${pageContext.request.contextPath}/user/list"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Users List</a>
        <a href="${pageContext.request.contextPath}/user/id"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By ID</a>
        <a href="${pageContext.request.contextPath}/user/name"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By Name</a>

<%--        <sec:authorize access="hasRole('ROLE_ADMIN')">--%>
            <a href="${pageContext.request.contextPath}/user/new"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge">Add New</a>
            <a href="${pageContext.request.contextPath}/user/update"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge">Update</a>
            <a href="${pageContext.request.contextPath}/user/delete"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge">Delete</a>
<%--        </sec:authorize>--%>
    </div>
</div>
</body>

</html>



