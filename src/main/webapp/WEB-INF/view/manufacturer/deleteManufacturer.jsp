<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
    <title>Delete Manufacturer</title>
    <jsp:include page="manufacturer.jsp"></jsp:include>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <form class="container m3-center w3-round-xlarge" method="GET" action="${pageContext.request.contextPath}delete">
        <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
            <h5 style="color:steelblue" class="text w3-animate-fading">Delete Manufacturer</h5>
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
                   id="myTable">
                <tr>
                    <td>ID</td>
                    <td><label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="text" name="id" placeholder=" Enter Manufacturer ID " value="${manufacturer.id}"/>
                    </label></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}manufacturer"
                           class="w3-btn w3-hover-red w3-round-xlarge">CANCEL</a></td>
                    <td colspan="1">
                        <input type="submit"
                               class="w3-input w3-border w3-hover-green w3-round-xlarge w3-light-blue"
                               value="DELETE"/>
                    </td>
                </tr>
            </table>
            <h5 style="color:steelblue" class="text w3-round-xlarge w3-animate-bottom">DELETE MANUFACTURER</h5>
        </nav>
    </form>
</div>

</body>

<jsp:include page="/WEB-INF/view/frase.jsp"></jsp:include>

</html>
