<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="manufacturer.jsp" %>

<!DOCTYPE HTML>
<html>

<style>
    .w3-display-bottommiddle {
        z-index: 2;
        width: 550px;
        line-height: initial;
    }
</style>

<head>
    <title>Manufacturers List</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="text w3-animate-fading">All Manufacturers</h5>
        <label for="myInput"></label>
        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue" type="text"
               placeholder="Search for ID..." id="myInput" onkeyup="myFunction()">
        <table class="w3-table-all w3-small w3-centered "
               class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
               id="myTable">
            <tr class="w3-hover-light-blue">
                <th>ID</th>
                <th>NAME</th>
                <sec:authorize access="hasRole('ROLE_ADMIN') and hasAuthority('ROLE_ADMIN')">
                    <th>UPDATE</th>
                    <th>DELETE</th>
                </sec:authorize>
            </tr>
            <c:forEach items="${list}" var="manufacturer">
                <tr>
                    <td>${manufacturer.id}</td>
                    <td>${manufacturer.name}</td>
                    <sec:authorize access="hasRole('ROLE_ADMIN') and hasAuthority('ROLE_ADMIN')">
                        <td>
                            <a href="${pageContext.request.contextPath}update/?id=${manufacturer.id}"
                               class="w3-btn w3-hover-light-blue w3-round-xlarge">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}delete/?id=${manufacturer.id}"
                               class="w3-btn w3-hover-red w3-round-xlarge">Delete</a>
                        </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
        <h5 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">MANUFACTURER LIST</h5>
    </nav>
</div>

</body>

<%@include file="/WEB-INF/view/catchPhrase.jsp" %>

</html>
