<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<h3>Admin</h3>--%>

<%--<head>--%>
<%--    <meta name='DC.Language' scheme='rfc1766' content='ru'/>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">--%>
<%--    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>

<%--    <title>Admin</title>--%>
<%--    <jsp:include page="_menu.jsp"></jsp:include>--%>
<%--</head>--%>

<%--<body>--%>
<%--<div>--%>
<%--    <table>--%>
<%--        <thead>--%>
<%--        <th>ID</th>--%>
<%--        <th>UserName</th>--%>
<%--        <th>Password</th>--%>
<%--        <th>Roles</th>--%>
<%--        </thead>--%>
<%--        <c:forEach items="${allUsers}" var="user">--%>
<%--            <tr>--%>
<%--                <td>${user.id}</td>--%>
<%--                <td>${user.username}</td>--%>
<%--                <td>${user.password}</td>--%>
<%--                <td>--%>
<%--                    <c:forEach items="${user.role}" var="role">${role.name}; </c:forEach>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <form action="${pageContext.request.contextPath}admin" method="post">--%>
<%--                        <input type="hidden" name="userId" value="${user.id}"/>--%>
<%--                        <input type="hidden" name="action" value="delete"/>--%>
<%--                        <button type="submit">Delete</button>--%>
<%--                    </form>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--    <a href="/">Home</a>--%>
<%--</div>--%>

<%--&lt;%&ndash;<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>&ndash;%&gt;--%>
<%--<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>--%>

<%--</body>--%>

<%--</html>--%>