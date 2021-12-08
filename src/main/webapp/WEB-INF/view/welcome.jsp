<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<%--    <jsp:useBean id="role" type="org.goit.springhw8.model.Role" beanName="role"></jsp:useBean>--%>
    <title>Welcome</title>

    <sec:authorize access="isAuthenticated()">
        <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.name} !</h3>
    </sec:authorize>

<%--    <sec:authorize access="isAuthenticated()">--%>
<%--        <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.implies('ADMIN')} !</h3>--%>
<%--    </sec:authorize>--%>

</head>

</html>
