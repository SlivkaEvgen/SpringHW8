<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="role.jsp" %>

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
    <title>Role By ID</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="text w3-animate-fading w3-center">Role By ID</h5>
        <form class="container m3-center w3-round-xlarge" method="GET"
              action="${pageContext.request.contextPath}id">
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
                   id="myTable1">
                <tr>
                    <td>
                        <label>
                            <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                                   type="text" name="id" placeholder=" Enter Role ID " value="${role.id}"/>
                        </label>
                    </td>
                    <td colspan="1">
                        <input class="w3-input w3-btn w3-border  w3-hover-green w3-round-xlarge w3-light-blue"
                               type="submit" value="Search"/>
                    </td>
                </tr>
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
                    <c:forEach items="${list}" var="role">
                        <tr>
                            <td>${role.id}</td>
                            <td>${role.name}</td>
                            <sec:authorize access="hasRole('ROLE_ADMIN') and hasAuthority('ROLE_ADMIN')">
                                <td>
                                    <a href="${pageContext.request.contextPath}update/?id=${role.id}"
                                       class="w3-btn w3-hover-light-blue w3-round-xlarge">Update</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}delete/?id=${role.id}"
                                       class="w3-btn w3-hover-red w3-round-xlarge">Delete</a>
                                </td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </table>
            </table>
            <h5 style="color:steelblue" class="text w3-round-xlarge w3-animate-bottom">ROLE BY ID</h5>
        </form>
    </nav>
</div>
</body>

<%@include file="/WEB-INF/view/catchPhrase.jsp" %>

</html>