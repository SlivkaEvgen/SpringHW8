<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <title>User By ID</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <nav class="w3-bar-block w3-center w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="text w3-center w3-high-small w3-animate-fading">User By ID</h5>
        <form class="container w3-center w3-round-xlarge" method="GET"
              action="${pageContext.request.contextPath}id">
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity">
                <tr>
                    <td>
                        <label>
                            <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                                   type="text" name="id" placeholder=" Enter User ID " value="${user.id}"/>
                        </label>
                    </td>
                    <td colspan="1">
                        <input type="submit"
                               class="w3-input w3-center w3-high-small w3-btn w3-border w3-hover-green w3-round-xlarge w3-light-blue"
                               value="SEARCH"/>
                    </td>
                </tr>
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
                                   class="w3-btn w3-hover-light-blue w3-round-xlarge">UPDATE</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}delete/?id=${user.id}"
                                   class="w3-btn w3-hover-red w3-round-xlarge">DELETE</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </table>
            <h5 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">USER BY ID</h5>
        </form>
    </nav>
</div>
</body>

<%@include file="/WEB-INF/view/catchPhrase.jsp" %>

</html>
