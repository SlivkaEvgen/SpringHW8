<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Welcome</title>
    <h5>
        <div>

        </div>
    </h5>
    <sec:authorize access="isAuthenticated()">
        <h5 class="w3-center w3-text-indigo w3-padding-58 current-new-color-grid w3-animate-opacity w3-hover-text-red w3-xxlarge">
            Welcome, Dear</h5>
        <h3 class="w3-center  w3-text-yellow w3-wide w3-blue-grey w3-animate-zoom w3-display w3-xxlarge"> ${pageContext.request.userPrincipal.name} </h3>
    </sec:authorize>
</head>

</html>
