<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="_header.jsp" %>
<%@include file="error2.jsp" %>

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
    <title>REGISTRATION</title>
</head>

<body>
<div class="w3-container w3-center w3-round-large">
    <form class="container m3-center w3-round-xlarge" method="POST"
          action="${pageContext.request.contextPath}registration">
        <nav style="width:30%"
             class="w3-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">
            <h5 style="color:crimson" class="text w3-wide w3-center w3-animate-fading w3-round-xlarge">REGISTRATION</h5>
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
                                   type="text" name="name" placeholder=" Enter  Name  " value="${user.name}"/>
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
                            <select class="w3-select w3-round-xlarge" name="gender">
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
                                   type="email" name="email" placeholder=" Enter email " value="${user.email}"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <label>
                            <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                                   type="password" name="password" placeholder=" Enter password "
                                   value="${user.password}"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td>
                        <label>
                            <select class="w3-select w3-round-xlarge" name="roles">
                                <option value="2" disabled selected></option>
                                <option value="2">ROLE_USER</option>
                            </select>
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>
                        <a href="${pageContext.request.contextPath}/login"
                           class="w3-btn w3-hover-red w3-round-xlarge">CANCEL</a>
                    </th>
                    <td>
                        <input type="submit" class="w3-input w3-border w3-hover-green w3-round-xlarge w3-light-blue"
                               value="Sing Up"/>
                    </td>
                </tr>
            </table>
            <h6 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">REGISTRATION</h6>
        </nav>
    </form>
</div>
</body>

<%@include file="catchPhrase.jsp" %>

</html>
