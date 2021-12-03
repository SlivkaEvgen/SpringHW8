<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name='DC.Language' scheme='rfc1766' content='ru'/>

    <title>Update User</title>
    <jsp:include page="user.jsp"></jsp:include>
</head>

<body>

<form class="w3-container w3-small w3-center w3-round-xlarge" method="POST"
      action="${pageContext.request.contextPath}update">
    <nav style="width:30%"
         class="w3-light-grey w3-small w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
        <h5 style="color:steelblue" class="w3-text w3-center w3-animate-fading w3-round-xlarge">Update User</h5>

        <table class="w3-table-all w3-small w3-centered "
               class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"
               id="myTable">
            <tr>
                <td>ID</td>
                <td>
                    <label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="text" name="id" placeholder=" Enter ID " value="${user.id}"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="text" name="name" placeholder=" Enter Name  " value="${user.name}"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>
                    <label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="text" name="lastName" placeholder=" Enter Last Name  "
                               value="${user.lastName}"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <label>
                        <select class="w3-select" name="gender">
                            <option value="" disabled selected>Choose Gender</option>
                            <option value="SEX_MALE">Male</option>
                            <option value="SEX_FEMALE">Female</option>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="email" name="email" placeholder=" Enter Email " value="${user.email}"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <label>
                        <input class="w3-input w3-center w3-border w3-high-small w3-round-xlarge w3-hover-light-blue"
                               type="password" name="password" placeholder=" Enter Password  "
                               value="${user.password}"/>
                    </label>
                </td>
            </tr>
                        <tr>
                            <td>Role</td>
                            <td>
                                <label>
                                    <select class="w3-select w3-round-xlarge" name="role">
                                        <option value="" disabled selected> Choose Role</option>
                                        <option value="1">Admin</option>
                                        <option value="2">User</option>
                                        <option value="3">Moderator</option>
                                        <option value="4">Owner</option>
                                    </select>
                                </label>
                            </td>
                        </tr>
            <tr>
                <th>
                    <a href="${pageContext.request.contextPath}/user"
                       class="w3-btn w3-high-small w3-hover-red w3-round-xlarge">CANCEL</a>
                </th>
                <td>
                    <input type="submit"
                           class="w3-input w3-high-small w3-border w3-hover-green w3-round-xlarge w3-light-blue"
                           value="UPDATE"/>
                </td>
            </tr>
        </table>
        <h6 style="color:steelblue" class="text w3-round-xlarge w3-animate-bottom">UPDATE USER</h6>
    </nav>
</form>

</body>

<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">
    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>

</div>

<div class="w3-container w3-center w3-rodoto w3-text-dark-gray">
    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>
    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>
</div>

</html>