<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="user.jsp" %>

<!DOCTYPE HTML>
<html>

<style>
    .w3-display-bottommiddle {
        z-index: 2;
        width: 1200px;
        line-height: initial;
    }
</style>

<head>
    <title>List Users</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="text w3-animate">All Users</h5>
        <label for="myInput"></label>
        <input class="w3-input w3-center w3-border w3-tiny w3-round-xxlarge w3-hover-light-blue"
               type="text" placeholder="Search for id..." id="myInput" onkeyup="myFunction()">
        <table class="w3-table-all w3-small w3-centered "
               class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
               id="myTable">
            <tr class="w3-hover-light-blue">
                <th>ID</th>
                <th>FIRST NAME</th>
                <th>LAST NAME</th>
                <th>GENDER</th>
                <th>EMAIL</th>
                <th>PASSWORD</th>
                <th>ROLE</th>
                <th>ACTIVE</th>
                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.lastName}</td>
                    <td>${user.gender}</td>
                    <td>${user.email}</td>
                    <td>${user.password.hashCode()}</td>
                    <td>${user.roles.parallelStream().findAny().get().name}</td>
                    <td>${user.active}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}update/?id=${user.id}"
                           class="w3-btn w3-hover-light-blue w3-round-xlarge">Update</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}delete/?id=${user.id}"
                           class="w3-btn w3-hover-red w3-round-xlarge">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h5 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">USERS LIST</h5>
    </nav>
</div>
</body>

<%@include file="/WEB-INF/view/catchPhrase.jsp" %>

</html>