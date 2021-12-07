<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style>
    html, body, h1, h2, h3, h4, h5, h6 {
        font-family: "Roboto", sans-serif;
    }
    .w3-display-bottommiddle {
        z-index: 2;
        width: 1000px;
        line-height: initial;
    }
</style>

<!DOCTYPE html>
<html>
<head>

    <title>Admin</title>
    <jsp:include page="_header.jsp"></jsp:include>

</head>

<body>

<div>
    <div class="w3-container w3-center w3-round-xlarge">
        <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
            <h5 style="color:steelblue" class="text w3-animate">All Users</h5>
            <label for="myInput"></label>
            <input class="w3-input w3-center w3-border w3-tiny w3-round-xxlarge w3-hover-light-blue"
                   type="text" placeholder="Search for id..." id="myInput" onkeyup="myFunction()">
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
                   id="myTable">
                <%--    <table>--%>
                <thead>
                <th>ID</th>
                <th>UserName</th>
                <th>Password</th>
                <th>Roles</th>
                </thead>
                <c:forEach items="${allUsers}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>
                            <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/admin" method="post">
                                <input type="hidden" name="userId" value="${user.id}"/>
                                <input type="hidden" name="action" value="update"/>
                                <button type="submit">Update</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/admin" method="post">
                                <input type="hidden" name="userId" value="${user.id}"/>
                                <input type="hidden" name="action" value="delete"/>
                                <button type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="${pageContext.request.contextPath}/">Главная</a>
        </nav>
    </div>
</div>

</body>

</html>