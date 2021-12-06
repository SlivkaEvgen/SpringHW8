<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
    <jsp:include page="_header.jsp"></jsp:include>
</head>

<body>

<div>
    <form:form method="POST" modelAttribute="userForm">

    <div class="w3-container w3-center w3-round-xlarge w3-padding-48">
        <h2>Sign Up</h2>
        <div>
            <form:input type="text" path="name" placeholder="name" autofocus="true"></form:input>
            <form:errors path="name"></form:errors>${usernameError}
        </div>

        <div>
            <form:input type="text" path="lastName" placeholder="lastName" autofocus="true"></form:input>
            <form:errors path="lastName"></form:errors>${lastNameError}
        </div>

        <div>
            <form:input type="text" path="gender" placeholder="gender" autofocus="true"></form:input>
            <form:errors path="gender"></form:errors>${genderError}
        </div>

        <div>
            <form:input type="email" path="email" placeholder="email" autofocus="true"></form:input>
            <form:errors path="email"></form:errors>${genderError}
        </div>

        <div>
            <form:input type="password" path="password" placeholder="Password"></form:input>
        </div>

        <div>
            <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"></form:input>
            <form:errors path="password"></form:errors>${passwordError}
        </div>
        <button type="submit">Зарегистрироваться</button>
        </form:form>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </div>

</body>

<%--  Фраза --%>
<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">
    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>
</div>

<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">
    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>
    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>
</footer>
<%--  Фраза --%>

</html>





<%--<!DOCTYPE html>--%>
<%--<html>--%>

<%--<style>--%>
<%--    .w3-tangerine {--%>
<%--        font-family: "Tangerine", serif;--%>
<%--    }--%>
<%--</style>--%>

<%--<head>--%>

<%--    <title>Registration</title>--%>
<%--    <jsp:include page="_header.jsp"></jsp:include>--%>

<%--</head>--%>

<%--<a href="${pageContext.request.contextPath}login"--%>
<%--   class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Login</a>--%>

<%--<body>--%>

<%--<sec:authorize access="!isAuthenticated()">--%>
<%--&lt;%&ndash;<a href="${pageContext.request.contextPath}login" class="w3-btn w3-hover-red w3-circle w3-round-xlarge">Login</a>&ndash;%&gt;--%>

<%--</sec:authorize>--%>
<%--&lt;%&ndash;<sec:authorize access="isAuthenticated()">&ndash;%&gt;--%>

<%--<div class="w3-container w3-center w3-round-xlarge w3-padding-48">--%>
<%--    <a href="${pageContext.request.contextPath}home"--%>
<%--       class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>--%>
<%--    <p></p>--%>
<%--    <div onclick="document.getElementById('id01').style.display='block'"--%>
<%--         class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge " style="text-align-all: center ">Registration--%>
<%--    </div>--%>
<%--<sec:authorize access="isAuthenticated()">--%>

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
<%--        <div id="id01" class="w3-modal">--%>
<%--            <div class="w3-modal-content w3-round-xlarge w3-card-4 w3-animate-zoom" style="max-width:500px">--%>

<%--                <div class="w3-center w3-round-xlarge"><br>--%>
<%--                    <span onclick="document.getElementById('id01').style.display='none'"--%>
<%--                          class="w3-btn w3-round-xlarge w3-small w3-hover-red w3-display-topright"--%>
<%--                          title="Close Modal">&times;</span>--%>
<%--                    <form class="w3-container w3-round-xlarge" method="GET"--%>
<%--                          action="${pageContext.request.contextPath}/registration">--%>
<%--                        <div class="w3-section w3-round">--%>
<%--                            <label><b>Username</b></label>--%>
<%--                            <label>--%>
<%--                                <input class="w3-input w3-small w3-border w3-margin-bottom w3-round-xlarge" type="text"--%>
<%--                                       placeholder="Enter Username"--%>
<%--                                       name="name" required>--%>
<%--                            </label>--%>

<%--                            <label><b>Last Name</b></label>--%>
<%--                            <label>--%>
<%--                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="text"--%>
<%--                                       placeholder="Enter Last Name"--%>
<%--                                       name="lastName" required>--%>
<%--                            </label>--%>
<%--                            <label><b>Gender</b></label>--%>
<%--                            <label>--%>
<%--                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="text"--%>
<%--                                       placeholder="Enter Gender"--%>
<%--                                       name="gender" required>--%>
<%--                            </label>--%>
<%--                            <label><b>Email</b></label>--%>
<%--                            <label>--%>
<%--                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="email"--%>
<%--                                       placeholder="Enter Email"--%>
<%--                                       name="email" required>--%>
<%--                            </label>--%>
<%--                            <label><b>Password</b></label>--%>
<%--                            <label>--%>
<%--                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="password"--%>
<%--                                       placeholder="Enter Password"--%>
<%--                                       name="password" required>--%>
<%--                            </label>--%>
<%--                            <button class="w3-btn w3-block w3-blue w3-hover-light-blue w3-section w3-padding w3-round-xlarge"--%>
<%--                                    type="submit">Login--%>
<%--                            </button>--%>

<%--                            <label>--%>
<%--                                <input class="w3-check w3-margin-top w3-round-xlarge" type="checkbox" checked="checked">--%>
<%--                            </label> Remember me--%>

<%--                        </div>--%>
<%--                    </form>--%>

<%--                    <div class="w3-container w3-border-top w3-padding-16 w3-light-grey w3-round-xlarge w3-large">--%>
<%--                        <button onclick="document.getElementById('id01').style.display='none'" type="button"--%>
<%--                                class="w3-btn w3-red w3-hover-red w3-round-xlarge w3-left">Cancel--%>
<%--                        </button>--%>
<%--                        <span class="w3-btn w3-right w3-padding w3-high-small w3-round-xlarge">Forgot <a href="#">password?</a></span>--%>
<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">--%>
<%--    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>--%>
<%--</div>--%>

<%--<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">--%>
<%--    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>--%>
<%--    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>--%>
<%--</footer>--%>


<%--</html>--%>
