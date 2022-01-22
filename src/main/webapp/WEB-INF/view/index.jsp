<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>Home</title>
</head>
<%@include file="welcome.jsp" %>
<body>
<sec:authorize access="!isAuthenticated()">
    <div>
        <div class="w3-container w3-center w3-round-xlarge w3-padding-64">
            <h4>
                <a href="${pageContext.request.contextPath}/login"
                   class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Log In</a>
            </h4>
            <div>OR</div>
            <h4>
                <a href="${pageContext.request.contextPath}/registration"
                   class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Sign Up</a>
            </h4>
        </div>
    </div>
</sec:authorize>

</body>

<%@include file="catchPhrase.jsp" %>

</html>