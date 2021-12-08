<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML>
<html>

<head>
    <style>
        html, body, h1, h2, h3, h4, h5, h6 {
            font-family: "Tangerine", "Roboto", sans-serif;
        }
    </style>
    <title>Role</title>

    <jsp:include page="../_header.jsp"></jsp:include>
    <jsp:include page="../error.jsp"></jsp:include>
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
        <a href="${pageContext.request.contextPath}/role/new"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Add New</a>
        <a href="${pageContext.request.contextPath}/role/update"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Update</a>
        <a href="${pageContext.request.contextPath}/role/delete"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Delete</a>
    </div>
</div>

</body>

</html>
