<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<sec:authorize access="isAuthenticated()">
    <a href="${pageContext.request.contextPath}/admin"
       class="w3-btn w3-hover-text-light-gray w3-round-xlarge w3-ios-background w3-display-topleft">
        <i class="fa fa-user-circle"></i>
            ${pageContext.request.userPrincipal.name}</a>

    <a href="${pageContext.request.contextPath}/logout"
       class="w3-btn w3-hover-text-light-gray w3-round-xlarge w3-ios-background w3-display-topright">
        <i class="fa fa-sign-out"></i>
        Logout</a>

</sec:authorize>

</html>