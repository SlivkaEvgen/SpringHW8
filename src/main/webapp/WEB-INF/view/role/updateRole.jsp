<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="role.jsp" %>

<!DOCTYPE HTML>
<html>

<style>
    .w3-display-bottommiddle {
        z-index: 2;
        width: 450px;
        line-height: initial;
    }
</style>

<head>
    <title>Update Role</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <form class="container m3-center w3-round-xlarge" method="POST" action="${pageContext.request.contextPath}update">
        <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
            <h5 style="color:steelblue" class="text w3-animate-fading w3-round-xlarge">Update Role</h5>
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity">
                <tr>
                    <td>ID</td>
                    <td>
                        <label>
                            <input
                                    class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                                    type="text" name="id" placeholder=" Enter Role ID " value="${role.id}"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td><label>
                        <select class="w3-select w3-center w3-round-xlarge" name="role">
                            <c:forEach var="role" items="${list}" begin="1">
                                <option value="${role.name}">${role.name}</option>
                            </c:forEach>
                        </select>
                    </label></td>
                </tr>
                <tr>
                    <th><a href="${pageContext.request.contextPath}/role"
                           class="w3-btn w3-hover-red w3-round-xlarge">CANCEL</a>
                    </th>
                    <td colspan="1">
                        <input type="submit" class="w3-input w3-border w3-hover-green w3-round-xlarge w3-light-blue"
                               value="UPDATE"/>
                    </td>
                </tr>
            </table>
            <h5 style="color:steelblue" class="text w3-round-xlarge w3-animate-bottom">UPDATE ROLE</h5>
        </nav>
    </form>
</div>
</body>

<%@include file="/WEB-INF/view/catchPhrase.jsp" %>

</html>