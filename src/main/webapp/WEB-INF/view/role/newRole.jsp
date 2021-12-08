<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<style>
    html, body, h1, h2, h3, h4, h5, h6 {
        font-family: "Roboto", sans-serif;
    }

    .w3-display-bottommiddle {
        z-index: 2;
        width: 450px;
        line-height: initial;
    }
</style>

<head>

    <title>New Role</title>
    <jsp:include page="role.jsp"></jsp:include>

</head>

<body>
<div class="w3-container w3-center w3-round-xlarge">
    <form class="container m3-center w3-round-xlarge" method="POST" action="${pageContext.request.contextPath}new">
        <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
            <h5 style="color:steelblue" class="text w3-animate-fading">New Role</h5>
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
                   id="myTable">
                <tr>
                    <td>ID</td>
                    <td><label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="text" name="id" placeholder=" Enter ID " value="${role.id}"/>
                    </label></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <label>
                            <select class="w3-select" name="name">
                                <option value="" disabled selected>Choose Role</option>
                                <option value="ROLE_ADMIN">ADMIN</option>
                                <option value="ROLE_USER">USER</option>
                                <option value="ROLE_MODERATOR">MODERATOR</option>
                                <option value="ROLE_DEVELOPER">DEVELOPER</option>
                                <option value="ROLE_PRODUCTION">PRODUCTION</option>
                                <option value="ROLE_OWNER">OWNER</option>
                                <option value="ROLE_MY">MY</option>
                            </select>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/role"
                           class="w3-btn w3-hover-red w3-round-xlarge">CANCEL</a></td>
                    <td colspan="1">
                        <input type="submit"
                               class="w3-input w3-border w3-hover-green w3-round-xlarge w3-light-blue"
                               value="SUBMIT"/>
                    </td>
                </tr>
            </table>
            <h5 style="color:steelblue" class="text w3-round-xlarge w3-animate-bottom">ADD NEW ROLE</h5>
        </nav>
    </form>
</div>

</body>

<jsp:include page="/WEB-INF/view/catchPhrase.jsp"></jsp:include>
<jsp:include page="../error.jsp"></jsp:include>

</html>
