<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<style>
    h6 {
        color: white;
        text-shadow: 2px 2px 4px #000000;
    }
</style>
    <sec:authorize access="isAuthenticated()">
        <h6 class="w3-btn w3-hover-text-light-gray w3-round-xlarge w3-ios-background w3-display-topleft"><a href="${pageContext.request.contextPath}admin">${pageContext.request.userPrincipal.name}</a></h6>
<%--        <a--%>
<%--                style="border-left-width: medium" class="w3-hover-border-teal w3-round-xlarge w3-display-topleft">${pageContext.request.userPrincipal.name}--%>
<%--        </a>--%>
        <h6 href="${pageContext.request.contextPath}/logout"
           class="w3-btn w3-hover-text-light-gray w3-round-xlarge w3-ios-background w3-display-topright">Logout</h6>
    </sec:authorize>

</html>