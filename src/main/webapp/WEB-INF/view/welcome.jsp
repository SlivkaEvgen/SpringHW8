<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <title>Welcome</title>

    <sec:authorize access="isAuthenticated()">
        <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.name} !</h3>
    </sec:authorize>
</head>

</html>
