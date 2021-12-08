<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Logout</title>

    <sec:authorize access="isAuthenticated()">
        <a class="w3-text w3-round-xlarge w3-display-topleft">${pageContext.request.userPrincipal.name}</a>
        <a href="${pageContext.request.contextPath}/logout"
           class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Logout</a>
    </sec:authorize>
</head>

</html>