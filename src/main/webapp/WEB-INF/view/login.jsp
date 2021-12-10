<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="_header.jsp"%>
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
    <title>Login</title>
</head>


<%--<span style="flood-color: crimson; text-decoration-style: solid; ">--%>
<%--        <a href="/registration">Sign Up</a>--%>
<%--    |--%>
<%--        <a href="/login">Log In </a></span>--%>


<%--  <div class="w3-display-bottomleft">
            <h2>Displaying Rounded Signs</h2>
            <span class="w3-tag w3-padding w3-round-large w3-red w3-center">
  DO NOT<br>
  BREATHE<br>
  UNDER WATER
  </span>
        </div>
        <div class="w3-tag w3-round w3-green" style="padding:3px">
            <div class="w3-tag w3-round w3-green w3-border w3-border-white">
                Falcon Ridge Parkway
            </div>
        </div>--%>

<body>

<div class="w3-container w3-center w3-round-large w3-small">
    <span style="flood-color: crimson; text-decoration-style: solid; ">
        <a href="/registration">Sign Up</a>
    |
        <a href="/login">Log In </a></span>
    <nav class="w3-bar-block  w3-light-grey w3-small w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:crimson" class="text w3-wide w3-center w3-animate-fading w3-round-large">LOGIN</h5>
        <form class="container m3-center w3-small w3-round-xlarge" method="POST"
              action="${pageContext.request.contextPath}/login">
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
                   id="myTable1">
                <tr>
                    <td>Username</td>
                    <td>
                        <label>
                            <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                                   type="text" name="username" placeholder=" Enter Username " value="${user.name}"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <label>
                            <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                                   type="text" name="password" placeholder=" Enter Password " value="${user.password}"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>
                        <a href="${pageContext.request.contextPath}/home"
                           class="w3-btn w3-hover-red w3-small w3-round-xlarge">CANCEL</a>
                    </th>
                    <td>
                        <input type="submit"
                               class="w3-input w3-border w3-hover-green w3-round-xlarge w3-light-blue w3-small"
                               value="Log In"/>
                    </td>
                </tr>
            </table>
            <h6 style="color:steelblue" class="text w3-round-xlarge w3-animate-bottom">LOGIN</h6>
        </form>
    </nav>
</div>
</body>

<%@include file="catchPhrase.jsp" %>

</html>