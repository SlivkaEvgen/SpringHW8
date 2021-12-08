<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>Manufacturer</title>

    <jsp:include page="../_header.jsp"></jsp:include>
    <jsp:include page="../function.jsp"></jsp:include>
    <jsp:include page="../error2.jsp"></jsp:include>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge w3-padding-50">
    <div class="w3-container w3-center w3-round-xlarge w3-ios">
        <a href="${pageContext.request.contextPath}/manufacturer/list"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Manufacturers List</a>
        <a href="${pageContext.request.contextPath}/manufacturer/id"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By ID</a>
        <a href="${pageContext.request.contextPath}/manufacturer/name"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By Name</a>
        <%--        <sec:authorize access="hasRole('ROLE_ADMIN')">--%>
        <a href="${pageContext.request.contextPath}/manufacturer/new"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Add New</a>
        <a href="${pageContext.request.contextPath}/manufacturer/update"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Update</a>
        <a href="${pageContext.request.contextPath}/manufacturer/delete"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Delete</a>
        <%--        </sec:authorize>--%>
        <p></p>
    </div>
</div>

</body>

</html>
