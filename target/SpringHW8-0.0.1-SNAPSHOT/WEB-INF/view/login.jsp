<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="utf-8">

    <title>Log in with your account</title>
    <jsp:include page="_header.jsp"></jsp:include>

</head>

<body>

<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>

<div>
    <div style="animation-duration: initial" class="w3-container w3-center w3-round-xlarge w3-padding-50">
        <div class="w3-container w3-center w3-round-xlarge w3-ios">
            <h2>Log In</h2>
            <%--                <a href="${pageContext.request.contextPath}home"--%>
            <%--            <sec:authorize access="isAuthenticated()">--%>
            <%--                   class="w3-btn w3-wide w3-hover-red w3-round-xlarge">HOME</a>--%>
            <%--            </sec:authorize>--%>
            <p></p>
            <p></p>
            <p></p>

            <form method="POST" action="${pageContext.request.contextPath}/login">

                <%--        <h2>Вход в систему</h2>--%>

                <div>

                    <input name="username" type="text" placeholder="Username" autofocus="true"/>
                    <p></p>

                    <input name="password" type="password" placeholder="Password"/>
                    <p></p>

                    <button type="submit" class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background">Sign In</button>


                    <h4><a href="${pageContext.request.contextPath}/registration" class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Sign
                        Up</a></h4>
                </div>

            </form>

        </div>
    </div>
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


<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<%--<!DOCTYPE HTML>--%>
<%--<html>--%>

<%--<head>--%>

<%--    <title>Login</title>--%>
<%--    <jsp:include page="_header.jsp"></jsp:include>--%>

<%--</head>--%>

<%--<body>--%>

<%--&lt;%&ndash;<sec:authorize access="isAuthenticated()">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p class="w3-center w3-ios-light-blue">Login OK</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <h3 class="w3-center">Welcome, ${pageContext.request.userPrincipal.name}!</h3>&ndash;%&gt;--%>
<%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
<%--    <div style="animation-duration: initial" class="w3-container w3-center w3-round-xlarge w3-padding-50">--%>
<%--        <div class="w3-container w3-center w3-round-xlarge w3-ios">--%>
<%--            <a href="${pageContext.request.contextPath}home"--%>
<%--&lt;%&ndash;            <sec:authorize access="isAuthenticated()">&ndash;%&gt;--%>
<%--               class="w3-btn w3-wide w3-hover-red w3-round-xlarge">HOME</a>--%>
<%--&lt;%&ndash;            </sec:authorize>&ndash;%&gt;--%>
<%--            <p></p>--%>
<%--        <p></p>--%>
<%--        <p></p>--%>

<%--        &lt;%&ndash;  o1-login      &ndash;%&gt;--%>
<%--        <div onclick="document.getElementById('id02').style.display='block'"--%>
<%--             class="w3-btn  w3-wide w3-hover-light-blue  w3-round-xlarge " style="text-align-all: right "> Login </div><?</a>--%>
<%--        </div>--%>
<%--&lt;%&ndash;        <div onclick="document.getElementById('id03').style.display='block'"&ndash;%&gt;--%>
<%--&lt;%&ndash;             class="w3-btn  w3-wide w3-hover-light-blue  w3-round-xlarge " style="text-align-all: right "> Login 3</div><?</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>

<%--        <p></p>--%>
<%--        <p> </p>--%>
<%--&lt;%&ndash;     w3-ios-light-grey       &ndash;%&gt;--%>
<%--&lt;%&ndash;                <a href="${pageContext.request.contextPath}registration" class="w3-btn w3-hover-red w3-round-xlarge w3-ios">Registration</a>&ndash;%&gt;--%>
<%--        <div onclick="document.getElementById('id01').style.display='block'"--%>
<%--             class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge " style="text-align-all: center ">Sign Up</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--<p></p>--%>
<%--&lt;%&ndash; 02-registr   &ndash;%&gt;--%>
<%--        <div id="id01" class="w3-modal">--%>
<%--            <div class="w3-modal-content w3-round-xlarge w3-card-4 w3-animate-zoom" style="max-width:500px">--%>
<%--                <div class="w3-center w3-round-xlarge"><br>--%>
<%--                    <span onclick="document.getElementById('id01').style.display='none'"--%>
<%--                          class="w3-btn w3-round-xlarge w3-small w3-hover-red w3-display-topright"--%>
<%--                          title="Close Modal">&times;</span>--%>
<%--                    <form class="w3-container w3-round-xlarge" method="POST"--%>
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
<%--                                    type="submit">Sign Up--%>
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
<%--&lt;%&ndash;         придумать форму забытого пароля               &ndash;%&gt;--%>
<%--                        <span class="w3-btn w3-right w3-padding w3-high-small w3-round-xlarge">Forgot <a href="#">password?</a></span>--%>
<%--                    </div>--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>


<%--    &lt;%&ndash;   02     &ndash;%&gt;--%>

<%--    <div id="id02" class="w3-modal">--%>
<%--        <div class="w3-modal-content w3-round-xlarge w3-card-4 w3-animate-zoom" style="max-width:500px">--%>
<%--            <div class="w3-center w3-round-xlarge"><br>--%>
<%--                <span onclick="document.getElementById('id02').style.display='none'"--%>
<%--                      class="w3-btn w3-round-xlarge w3-small w3-hover-red w3-display-topright"--%>
<%--                      title="Close Modal">&times;</span>--%>
<%--                <form class="w3-container w3-round-xlarge" method="POST"--%>
<%--                      action="${pageContext.request.contextPath}login">--%>
<%--                    <div class="w3-section w3-round">--%>
<%--                        <label><b>Username</b></label>--%>
<%--                        <label>--%>
<%--                            <input class="w3-input w3-small w3-border w3-margin-bottom w3-round-xlarge" type="text"--%>
<%--                                   placeholder="Enter Username"--%>
<%--                                   name="name" required>--%>
<%--                        </label>--%>
<%--                        <label><b>Password</b></label>--%>
<%--                        <label>--%>
<%--                            <input class="w3-input w3-small w3-border w3-round-xlarge" type="password"--%>
<%--                                   placeholder="Enter Password"--%>
<%--                                   name="password" required>--%>
<%--                        </label>--%>
<%--                        <button class="w3-btn w3-block w3-blue w3-hover-light-blue w3-section w3-padding w3-round-xlarge"--%>
<%--                                type="submit">Login--%>
<%--                        </button>--%>
<%--                        <label>--%>
<%--                            <input class="w3-check w3-margin-top w3-round-xlarge" type="checkbox" checked="checked">--%>
<%--                        </label> Remember me--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--                <div class="w3-container w3-border-top w3-padding-16 w3-light-grey w3-round-xlarge w3-large">--%>
<%--                    <button onclick="document.getElementById('id02').style.display='none'" type="button"--%>
<%--                            class="w3-btn w3-red w3-hover-red w3-round-xlarge w3-left">Cancel--%>
<%--                    </button>--%>
<%--                    <span class="w3-btn w3-right w3-padding w3-high-small w3-round-xlarge">Forgot <a--%>
<%--                            href="#">password?</a></span>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--&lt;%&ndash;    &ndash;%&gt;--%>
<%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>

<%--&lt;%&ndash;AUTORISATION OK&ndash;%&gt;--%>

<%--<sec:authorize access="isAuthenticated()">--%>

<%--<a href="${pageContext.request.contextPath}logout"--%>
<%--   class="w3-btn w3-hover-red w3-circle w3-round-xlarge w3-display-topright">Logout</a>--%>

<%--<div class="w3-container w3-center w3-round-xlarge w3-padding-48">--%>
<%--&lt;%&ndash;    <a href="${pageContext.request.contextPath}home"&ndash;%&gt;--%>
<%--&lt;%&ndash;       class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios">Home</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <a href="${pageContext.request.contextPath}login"&ndash;%&gt;--%>
<%--&lt;%&ndash;       class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios">LOGIN PAGE</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p></p>&ndash;%&gt;--%>

<%--    <p></p>--%>
<%--    <div id="id02" class="w3-modal">--%>
<%--        <div class="w3-modal-content w3-round-xlarge w3-card-4 w3-animate-zoom" style="max-width:500px">--%>
<%--            <div class="w3-center w3-round-xlarge"><br>--%>
<%--                <span onclick="document.getElementById('id02').style.display='none'"--%>
<%--                      class="w3-btn w3-round-xlarge w3-small w3-hover-red w3-display-topright"--%>
<%--                      title="Close Modal">&times;</span>--%>
<%--                <form class="w3-container w3-round-xlarge" method="POST"--%>
<%--                      action="${pageContext.request.contextPath}login">--%>
<%--                    <div class="w3-section w3-round">--%>
<%--                        <label><b>Username</b></label>--%>
<%--                        <label>--%>
<%--                            <input class="w3-input w3-small w3-border w3-margin-bottom w3-round-xlarge" type="text"--%>
<%--                                   placeholder="Enter Username"--%>
<%--                                   name="name" required>--%>
<%--                        </label>--%>
<%--                        <label><b>Password</b></label>--%>
<%--                        <label>--%>
<%--                            <input class="w3-input w3-small w3-border w3-round-xlarge" type="password"--%>
<%--                                   placeholder="Enter Password"--%>
<%--                                   name="password" required>--%>
<%--                        </label>--%>
<%--                        <button class="w3-btn w3-block w3-blue w3-hover-light-blue w3-section w3-padding w3-round-xlarge"--%>
<%--                                type="submit">Login--%>
<%--                        </button>--%>

<%--                        <label>--%>
<%--                            <input class="w3-check w3-margin-top w3-round-xlarge" type="checkbox" checked="checked">--%>
<%--                        </label> Remember me--%>

<%--                    </div>--%>
<%--                </form>--%>

<%--                <div class="w3-container w3-border-top w3-padding-16 w3-light-grey w3-round-xlarge w3-large">--%>
<%--                    <button onclick="document.getElementById('id02').style.display='none'" type="button"--%>
<%--                            class="w3-btn w3-red w3-hover-red w3-round-xlarge w3-left">Cancel--%>
<%--                    </button>--%>
<%--                    <span class="w3-btn w3-right w3-padding w3-high-small w3-round-xlarge">Forgot <a--%>
<%--                            href="#">password?</a></span>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</sec:authorize>--%>
<%--</body>--%>

<%--<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">--%>
<%--    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>--%>
<%--</div>--%>

<%--<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">--%>
<%--    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>--%>
<%--    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>--%>
<%--</footer>--%>

<%--</html>--%>