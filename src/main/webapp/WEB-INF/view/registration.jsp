<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>--%>

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

<%--    <div class="w3-container w3-center w3-round-xlarge w3-padding-48">--%>
<%--        <h2>Sign Up</h2>--%>
<%--        <div>--%>
<%--            <form:input type="text" path="name" placeholder="name" autofocus="true"></form:input>--%>
<%--            <form:errors path="name"></form:errors>${usernameError}--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <form:input type="text" path="lastName" placeholder="lastName" autofocus="true"></form:input>--%>
<%--            <form:errors path="lastName"></form:errors>${lastNameError}--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <form:input type="text" path="gender" placeholder="gender" autofocus="true"></form:input>--%>
<%--            <form:errors path="gender"></form:errors>${genderError}--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <form:input type="email" path="email" placeholder="email" autofocus="true"></form:input>--%>
<%--            <form:errors path="email"></form:errors>${genderError}--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <form:input type="password" path="password" placeholder="Password"></form:input>--%>
<%--        </div>--%>

<%--        <div>--%>
<%--            <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"></form:input>--%>
<%--            <form:errors path="password"></form:errors>${passwordError}--%>
<%--        </div>--%>
<%--        <button type="submit">Зарегистрироваться</button>--%>
<%--        </form:form>--%>
<%--        <a href="${pageContext.request.contextPath}/">Home</a>--%>
<%--    </div>--%>

<%--</body>--%>
<%--<jsp:include page="frase.jsp"></jsp:include>--%>

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





<%--&lt;%&ndash;<!DOCTYPE html>&ndash;%&gt;--%>
<%--&lt;%&ndash;<html>&ndash;%&gt;--%>

<%--&lt;%&ndash;<style>&ndash;%&gt;--%>
<%--&lt;%&ndash;    .w3-tangerine {&ndash;%&gt;--%>
<%--&lt;%&ndash;        font-family: "Tangerine", serif;&ndash;%&gt;--%>
<%--&lt;%&ndash;    }&ndash;%&gt;--%>
<%--&lt;%&ndash;</style>&ndash;%&gt;--%>

<%--&lt;%&ndash;<head>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <title>Registration</title>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <jsp:include page="_header.jsp"></jsp:include>&ndash;%&gt;--%>

<%--&lt;%&ndash;</head>&ndash;%&gt;--%>

<%--&lt;%&ndash;<a href="${pageContext.request.contextPath}login"&ndash;%&gt;--%>
<%--&lt;%&ndash;   class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Login</a>&ndash;%&gt;--%>

<%--&lt;%&ndash;<body>&ndash;%&gt;--%>

<%--&lt;%&ndash;<sec:authorize access="!isAuthenticated()">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<a href="${pageContext.request.contextPath}login" class="w3-btn w3-hover-red w3-circle w3-round-xlarge">Login</a>&ndash;%&gt;&ndash;%&gt;--%>

<%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<sec:authorize access="isAuthenticated()">&ndash;%&gt;&ndash;%&gt;--%>

<%--&lt;%&ndash;<div class="w3-container w3-center w3-round-xlarge w3-padding-48">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <a href="${pageContext.request.contextPath}home"&ndash;%&gt;--%>
<%--&lt;%&ndash;       class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div onclick="document.getElementById('id01').style.display='block'"&ndash;%&gt;--%>
<%--&lt;%&ndash;         class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge " style="text-align-all: center ">Registration&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<sec:authorize access="isAuthenticated()">&ndash;%&gt;--%>

<%--&lt;%&ndash;    <p></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="w3-container w3-center w3-round-xlarge " style="color:indianred">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="${pageContext.request.contextPath}role"&ndash;%&gt;--%>
<%--&lt;%&ndash;           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="${pageContext.request.contextPath}user"&ndash;%&gt;--%>
<%--&lt;%&ndash;           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="${pageContext.request.contextPath}product"&ndash;%&gt;--%>
<%--&lt;%&ndash;           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="${pageContext.request.contextPath}manufacturer"&ndash;%&gt;--%>
<%--&lt;%&ndash;           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>&ndash;%&gt;--%>

<%--&lt;%&ndash;        </sec:authorize>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div id="id01" class="w3-modal">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <div class="w3-modal-content w3-round-xlarge w3-card-4 w3-animate-zoom" style="max-width:500px">&ndash;%&gt;--%>

<%--&lt;%&ndash;                <div class="w3-center w3-round-xlarge"><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <span onclick="document.getElementById('id01').style.display='none'"&ndash;%&gt;--%>
<%--&lt;%&ndash;                          class="w3-btn w3-round-xlarge w3-small w3-hover-red w3-display-topright"&ndash;%&gt;--%>
<%--&lt;%&ndash;                          title="Close Modal">&times;</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <form class="w3-container w3-round-xlarge" method="GET"&ndash;%&gt;--%>
<%--&lt;%&ndash;                          action="${pageContext.request.contextPath}/registration">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="w3-section w3-round">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label><b>Username</b></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <input class="w3-input w3-small w3-border w3-margin-bottom w3-round-xlarge" type="text"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       placeholder="Enter Username"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       name="name" required>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </label>&ndash;%&gt;--%>

<%--&lt;%&ndash;                            <label><b>Last Name</b></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="text"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       placeholder="Enter Last Name"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       name="lastName" required>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label><b>Gender</b></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="text"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       placeholder="Enter Gender"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       name="gender" required>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label><b>Email</b></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="email"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       placeholder="Enter Email"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       name="email" required>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label><b>Password</b></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <input class="w3-input w3-small w3-border w3-round-xlarge" type="password"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       placeholder="Enter Password"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                       name="password" required>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <button class="w3-btn w3-block w3-blue w3-hover-light-blue w3-section w3-padding w3-round-xlarge"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    type="submit">Login&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </button>&ndash;%&gt;--%>

<%--&lt;%&ndash;                            <label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <input class="w3-check w3-margin-top w3-round-xlarge" type="checkbox" checked="checked">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </label> Remember me&ndash;%&gt;--%>

<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </form>&ndash;%&gt;--%>

<%--&lt;%&ndash;                    <div class="w3-container w3-border-top w3-padding-16 w3-light-grey w3-round-xlarge w3-large">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <button onclick="document.getElementById('id01').style.display='none'" type="button"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                class="w3-btn w3-red w3-hover-red w3-round-xlarge w3-left">Cancel&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </button>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <span class="w3-btn w3-right w3-padding w3-high-small w3-round-xlarge">Forgot <a href="#">password?</a></span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;</footer>&ndash;%&gt;--%>


<%--&lt;%&ndash;</html>&ndash;%&gt;--%>