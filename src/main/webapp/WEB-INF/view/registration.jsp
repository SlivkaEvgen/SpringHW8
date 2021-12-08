<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <title>Регистрация</title>--%>

<%--    <jsp:include page="_header.jsp"></jsp:include>--%>
<%--</head>--%>

<%--<body>--%>

<%--<div>--%>
<%--    <form:form method="POST" modelAttribute="userForm">--%>
<%--&lt;%&ndash;<jsp:include page="user/newUser.jsp"></jsp:include>&ndash;%&gt;--%>
<%--        <div class="w3-container w3-center w3-round-large">--%>
<%--            <form class="container m3-center w3-round-xlarge" method="POST" action="${pageContext.request.contextPath}registration">--%>
<%--                <nav style="width:30%"--%>
<%--                     class="w3-block  w3-light-grey w3-animate-top w3-card w3-round-xlarge w3-display-bottommiddle">--%>
<%--                    <h5 style="color:steelblue" class="text w3-center w3-animate-fading w3-round-xlarge">New User</h5>--%>
<%--                    <table class="w3-table-all w3-small w3-centered "--%>
<%--                           class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"--%>
<%--                           id="myTable">--%>
<%--&lt;%&ndash;                        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td>ID</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                           type="text" name="id" placeholder=" Enter ID " value="${user.id}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </tr>&ndash;%&gt;--%>
<%--                        <tr>--%>
<%--                            <td>Name</td>--%>
<%--                            <td>--%>
<%--                                <label>--%>
<%--                                    <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"--%>
<%--                                           type="text" name="name" placeholder=" Enter  Name  " value="${user.name}"/>--%>
<%--                                </label>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Last Name</td>--%>
<%--                            <td>--%>
<%--                                <label>--%>
<%--                                    <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"--%>
<%--                                           type="text" name="lastName" placeholder=" Enter Last Name  "--%>
<%--                                           value="${user.lastName}"/>--%>
<%--                                </label>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Gender</td>--%>
<%--                            <td>--%>
<%--                                <label>--%>
<%--                                    <select class="w3-select w3-round-xlarge" name="gender">--%>
<%--                                        <option value="" disabled selected>Choose Gender</option>--%>
<%--                                        <option value="SEX_MALE">Male</option>--%>
<%--                                        <option value="SEX_FEMALE">Female</option>--%>
<%--                                    </select>--%>
<%--                                </label>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Email</td>--%>
<%--                            <td>--%>
<%--                                <label>--%>
<%--                                    <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"--%>
<%--                                           type="email" name="email" placeholder=" Enter email " value="${user.email}"/>--%>
<%--                                </label>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Password</td>--%>
<%--                            <td>--%>
<%--                                <label>--%>
<%--                                    <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"--%>
<%--                                           type="password" name="password" placeholder=" Enter password "--%>
<%--                                           value="${user.password}"/>--%>
<%--                                </label>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--&lt;%&ndash;                        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td>Role</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <input class="w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                           type="role" name="role" placeholder=" Enter password "&ndash;%&gt;--%>
<%--&lt;%&ndash;                                           value="ROLE_USER"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </tr>&ndash;%&gt;--%>
<%--                        <tr>--%>
<%--                            <th>--%>
<%--                                <a href="${pageContext.request.contextPath}/home"--%>
<%--                                   class="w3-btn w3-hover-red w3-round-xlarge">CANCEL</a>--%>
<%--                            </th>--%>
<%--                            <td>--%>
<%--                                <input type="submit" class="w3-input w3-border w3-hover-green w3-round-xlarge w3-light-blue"--%>
<%--                                       value="SUBMIT"/>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>
<%--                    <h6 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">NEW USER</h6>--%>
<%--                </nav>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--&lt;%&ndash;        <button type="submit">Зарегистрироваться</button>&ndash;%&gt;--%>
<%--    </form:form>--%>
<%--&lt;%&ndash;    <a href="${pageContext.request.contextPath}/">Home</a>&ndash;%&gt;--%>
<%--</div>--%>

<%--</body>--%>

<%--&lt;%&ndash;    <div class="w3-container w3-center w3-round-xlarge w3-padding-48">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <h2>Sign Up</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:input type="text" path="name" placeholder="name" autofocus="true"></form:input>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:errors path="name"></form:errors>${usernameError}&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:input type="text" path="lastName" placeholder="lastName" autofocus="true"></form:input>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:errors path="lastName"></form:errors>${lastNameError}&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:input type="text" path="gender" placeholder="gender" autofocus="true"></form:input>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:errors path="gender"></form:errors>${genderError}&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:input type="email" path="email" placeholder="email" autofocus="true"></form:input>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:errors path="email"></form:errors>${genderError}&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:input type="password" path="password" placeholder="Password"></form:input>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"></form:input>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <form:errors path="password"></form:errors>${passwordError}&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>


<%--&lt;%&ndash;<jsp:include page="catchPhrase.jsp"></jsp:include>&ndash;%&gt;--%>

<%--&lt;%&ndash;&lt;%&ndash;  Фраза &ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;</footer>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;  Фраза &ndash;%&gt;&ndash;%&gt;--%>

<%--</html>--%>





<!DOCTYPE html>
<html>
<%--AUTORISATION OK--%>

<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <c:redirect url="/"></c:redirect>--%>
<%--</sec:authorize>--%>

<style>
    .w3-tangerine {
        font-family: "Tangerine", serif;
    }
</style>

<head>

    <title>Registration</title>
    <jsp:include page="_header.jsp"></jsp:include>

</head>


<sec:authorize access="isAuthenticated()">
<%--<a href="${pageContext.request.contextPath}login"--%>
<%--   class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Login</a>--%>

<%--<body>--%>

<sec:authorize access="!isAuthenticated()">
<%--<a href="${pageContext.request.contextPath}login" class="w3-btn w3-hover-red w3-circle w3-round-xlarge">Login</a>--%>

</sec:authorize>
<%--<sec:authorize access="isAuthenticated()">--%>

<div class="w3-container w3-center w3-round-xlarge w3-padding-48">
<%--    <a href="${pageContext.request.contextPath}home"--%>
<%--       class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>--%>
<%--    <p></p>--%>
    <div onclick="document.getElementById('id01').style.display='block'"
         class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge " style="text-align-all: center ">Registration
    </div>
<%--<sec:authorize access="!isAuthenticated()">--%>

<%--    <p></p>--%>
<%--    <div class="w3-container w3-center w3-round-xlarge " style="color:indianred">--%>
<%--        <a href="${pageContext.request.contextPath}role"--%>
<%--           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>--%>
<%--        <a href="${pageContext.request.contextPath}user"--%>
<%--           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>--%>
<%--        <a href="${pageContext.request.contextPath}product"--%>
<%--           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>--%>
<%--        <a href="${pageContext.request.contextPath}manufacturer"--%>
<%--           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>--%>

<%--        </sec:authorize>--%>
        <div id="id01" class="w3-modal">
            <div class="w3-modal-content w3-round-xlarge w3-card-4 w3-animate-zoom" style="max-width:500px">

                <div class="w3-center w3-round-xlarge"><br>
                    <span onclick="document.getElementById('id01').style.display='none'"
                          class="w3-btn w3-round-xlarge w3-small w3-hover-red w3-display-topright"
                          title="Close Modal">&times;</span>
                    <form class="w3-container w3-round-xlarge" method="GET"
                          action="${pageContext.request.contextPath}registration">
                        <div class="w3-section w3-round">
                            <label><b>Username</b></label>
                            <label>
                                <input class="w3-input w3-small w3-border w3-margin-bottom w3-round-xlarge" type="text"
                                       placeholder="Enter Username"
                                       name="name" required>
                            </label>

                            <label><b>Last Name</b></label>
                            <label>
                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="text"
                                       placeholder="Enter Last Name"
                                       name="lastName" required>
                            </label>
                            <label><b>Gender</b></label>
                            <label>
                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="text"
                                       placeholder="Enter Gender"
                                       name="gender" required>
                            </label>
                            <label><b>Email</b></label>
                            <label>
                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="email"
                                       placeholder="Enter Email"
                                       name="email" required>
                            </label>
                            <label><b>Password</b></label>
                            <label>
                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="password"
                                       placeholder="Enter Password"
                                       name="password" required>
                            </label>
                            <button class="w3-btn w3-block w3-blue w3-hover-light-blue w3-section w3-padding w3-round-xlarge"
                                    type="submit">Sign Up
                            </button>

                            <label>
                                <input class="w3-check w3-margin-top w3-round-xlarge" type="checkbox" checked="checked">
                            </label> Remember me

                        </div>
                    </form>

                    <div class="w3-container w3-border-top w3-padding-16 w3-light-grey w3-round-xlarge w3-large">
                        <button onclick="document.getElementById('id01').style.display='none'" type="button"
                                class="w3-btn w3-red w3-hover-red w3-round-xlarge w3-left">Cancel
                        </button>
                        <span class="w3-btn w3-right w3-padding w3-high-small w3-round-xlarge">Forgot <a href="#">password?</a></span>
                    </div>

                </div>
            </div>
        </div>
    </div>

<jsp:include page="catchPhrase.jsp"></jsp:include>
<%--&lt;%&ndash;        <button type="submit">Зарегистрироваться</button>&ndash;%&gt;--%>
<%--    </form:form>--%>
<%--&lt;%&ndash;    <a href="${pageContext.request.contextPath}/">Home</a>&ndash;%&gt;--%>
<%--</div>--%>
<%--<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">--%>
<%--    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>--%>
<%--</div>--%>

<%--<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">--%>
<%--    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>--%>
<%--    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>--%>
<%--</footer>--%>

</sec:authorize>
</html>