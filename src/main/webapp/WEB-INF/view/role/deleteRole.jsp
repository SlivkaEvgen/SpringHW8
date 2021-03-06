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
    <title>Delete Role</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge w3-small">
    <nav class="w3-bar-block  w3-light-grey w3-small w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="text w3-center w3-animate-fading w3-round-xlarge">Delete Role</h5>
        <form class="container m3-center w3-small w3-round-xlarge" method="GET"
              action="${pageContext.request.contextPath}delete">
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
                   id="myTable1">
                <tr>
                    <td>ID</td>
                    <td>
                        <label>
                            <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                                   type="text" name="id" placeholder=" Enter Role ID " value="${role.id}"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>
                        <a href="${pageContext.request.contextPath}/role"
                           class="w3-btn w3-hover-red w3-small w3-round-xlarge">CANCEL</a>
                    </th>
                    <td>
                        <input type="submit"
                               class="w3-input w3-border w3-hover-green w3-round-xlarge w3-light-blue w3-small"
                               value="DELETE"/>
                    </td>
                </tr>
            </table>
            <h6 style="color:steelblue" class="text w3-round-xlarge w3-animate-bottom">DELETE ROLE</h6>
        </form>
    </nav>
</div>
</body>

<%@include file="/WEB-INF/view/catchPhrase.jsp" %>

</html>