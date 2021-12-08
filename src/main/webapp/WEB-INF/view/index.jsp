<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>Index</title>

    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="welcome.jsp"></jsp:include>
</head>

<body>

<sec:authorize access="!isAuthenticated()">
<div>
    <div class="w3-container w3-center w3-round-xlarge w3-padding-50">
        <h4>
            <a href="${pageContext.request.contextPath}/login"
               class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Log In</a>
        </h4>
        <h4>
            <a href="${pageContext.request.contextPath}/registration"
               class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Sign Up</a>
        </h4>
    </div>
</div>
</sec:authorize>

</body>

<jsp:include page="catchPhrase.jsp"></jsp:include>

</html>