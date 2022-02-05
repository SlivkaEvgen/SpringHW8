<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="note.jsp" %>

<!DOCTYPE HTML>
<html>

<style>
    .w3-display-bottommiddle {
        z-index: 2;
        width: 600px;
        line-height: initial;
    }
</style>

<head>
    <title>Note By ID</title>
</head>
<body>
<div class="w3-container w3-center w3-round-xlarge">
    <nav class="w3-bar-block w3-center w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="text w3-center w3-high-small w3-animate-fading">Note By ID</h5>
        <form class="container w3-center w3-round-xlarge" method="GET"
              action="${pageContext.request.contextPath}id">
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity">
                <tr>
                    <td>
                        <label>
                            <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                                   type="text" name="id" placeholder=" Enter Product ID " value="${note.id}"/>
                        </label>
                    </td>
                    <td colspan="1">
                        <input type="submit"
                               class="w3-input w3-center w3-high-small w3-btn w3-border w3-hover-green w3-round-xlarge w3-light-blue"
                               value="SEARCH"/>
                    </td>
                    <table class="w3-table-all w3-small w3-centered "
                           class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
                           id="myTable">
                        <div class="w3-panel w3-border w3-ios-grey w3-round-large">
                            <c:forEach items="${list}" var="note">
                                <p></p>
                                <a class="w3-text-black w3-left">Name: ${note.name} </a>
                                <p></p>
                                <a class="w3-text-black w3-right">${note.accessType}</a>
                                <p>***</p>
                                <p></p>
<%--                                <p class="w3-text w3-left">&copy; ${note.author.name} </p>--%>
                                <p class="w3-text-sand w3-left"> MESSAGE: ${note.message}</p>
                                <p></p>
                                <a href="${pageContext.request.contextPath}/notes/update/?id=${note.id}"
                                   class="w3-btn w3-hover-light-blue w3-round-xlarge w3-right">UPDATE</a>
                                <a href="${pageContext.request.contextPath}/notes/delete/?id=${note.id}"
                                   class="w3-btn w3-hover-red w3-round-xlarge w3-right">DELETE</a>
                            </c:forEach>
                        </div>
                    </table>
            </table>
            <h5 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">NOTE BY ID</h5>
        </form>
    </nav>
</div>
</body>

<%@include file="/WEB-INF/view/catchPhrase.jsp" %>

</html>
