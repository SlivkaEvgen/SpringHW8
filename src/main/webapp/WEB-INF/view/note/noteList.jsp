<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="note.jsp" %>

<!DOCTYPE HTML>
<html>

<style>
    .w3-display-bottommiddle {
        z-index: 2;
        width: 600px;
        line-height: inherit;
    }

</style>

<head>
    <title>Note List</title>
</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="text w3-animate">All Notes</h5>
        <%--        <label for="myInput"></label>--%>
        <input class="w3-input w3-center w3-border w3-tiny w3-round-xxlarge w3-hover-light-blue"
               type="text" placeholder="Search for id..." id="myInput" onkeyup="myFunction()">
        <table class="w3-table-all w3-small w3-centered "
               class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
               id="myTable">
            <tr class="w3-hover-light-blue">
                <th>ID</th>
                <th>NAME</th>
                <%--                <th>MESSAGE</th>--%>
                <th>AUTHOR</th>
                <th>ACCESS TYPE</th>
                <th>UPDATE</th>
                <th>DELETE</th>
                <%--                <th>LINK</th>--%>
            </tr>
            <c:forEach items="${list}" var="note">
                <tr>
                        <%--                    <a href="${pageContext.request.contextPath}/notes/id?id=${note.id}">${note.id}</a>--%>
                    <td>${note.id}</td>
                        <%--                    <td class="link w3-btn" id="myInput"><a href="${pageContext.request.contextPath}/notes/id?id=${note.id}">${note.id}</a></td>--%>
                    <td class="link" id="myInput"><a
                            href="${pageContext.request.contextPath}/notes/id?id=${note.id}">${note.name}</a></td>
                        <%--                    <td>${note.name}</td>--%>
                        <%--                    <td>${note.message}</td>--%>
                    <td>${note.author.name}</td>
                    <td>${note.accessType}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/notes/update/?id=${note.id}"
                           class="w3-btn w3-hover-light-blue w3-round-xlarge">Update</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/notes/delete/?id=${note.id}"
                           class="w3-btn w3-hover-red w3-round-xlarge"><i class="fa fa-trash"></i>Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h5 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">NOTE LIST</h5>
    </nav>
</div>
</body>

<%@include file="/WEB-INF/view/catchPhrase.jsp" %>

</html>
