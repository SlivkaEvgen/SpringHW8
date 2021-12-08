<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Log In</title>

    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="metaLink.jsp"></jsp:include>
    <jsp:include page="welcome.jsp"></jsp:include>
    <jsp:include page="logout.jsp"></jsp:include>
</head>

<body>
<div>
    <div style="animation-duration: initial" class="w3-container w3-center w3-round-xlarge w3-padding-50">
        <div class="w3-container w3-center w3-round-xlarge w3-ios">
            <form method="POST" action="${pageContext.request.contextPath}/login">
                <div>
                    <label>
                        <input name="username" type="text" placeholder="Username" autofocus="true"/>
                    </label>
                    <p></p>
                    <label>
                        <input name="password" type="password" placeholder="Password"/>
                    </label>
                    <p></p>
                    <button type="submit" class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background">Sign In</button>
                    <h4>
                        <a href="${pageContext.request.contextPath}/registration"
                           class="w3-btn  w3-hover-red w3-round-xlarge w3-ios-background">Sign Up</a></h4>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

<jsp:include page="catchPhrase.jsp"></jsp:include>

</html>
