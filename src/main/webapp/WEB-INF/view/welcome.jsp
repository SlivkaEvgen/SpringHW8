<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Welcome</title>
    <h5>
<%--        <div>--%>

<%--        </div>--%>
    </h5>
    <sec:authorize access="isAuthenticated()">
        <h4 class="w3-center w3-text-indigo w3-padding-58 current-new-color-grid w3-animate-opacity w3-hover-text-red w3-xxlarge">
            Welcome , ${pageContext.request.userPrincipal.name}!</h4>
<%--        <h3 class="w3-center w3-animate-zoom w3-display w3-xxlarge"> </h3>--%>
    </sec:authorize>
</head>

</html>
