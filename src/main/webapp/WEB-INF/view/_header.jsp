<%@ page import="java.util.Date" %>

<!DOCTYPE HTML>
<html>

<style>
    .w3-tangerine {
        font-family: "Tangerine", serif;
    }
</style>

<header>

    <jsp:include page="metaLink.jsp"></jsp:include>
    <jsp:include page="logout.jsp"></jsp:include>
    <jsp:include page="metaLink.jsp"></jsp:include>
</header>

<body>
<div class="w3-container w3-center w3-padding w3-animate w3-ios-grey">
    <h1><b>Web Market</b></h1>
    <p>This Web Application using <span class="w3-tag">SPRING</span></p>

    <a class="w3-display-buttommiddle w3-center w3-round-xlarge w3-ios-grey">
        <h6 class="date-cell w3-center w3-round-xlarge"
            style="color: darkslateblue; animation-iteration-count: revert; animation-timing-function: ease-in-out"><% out.println(new Date().toString()); %></h6>
    </a>
    <div class="w3-container w3-center w3-round-xlarge w3-padding-50">
        <div class="w3-container w3-center w3-round-xlarge w3-ios">
            <a href="${pageContext.request.contextPath}/home"
               class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>
        </div>
    </div>
    <p></p>

    <a href="${pageContext.request.contextPath}role"
       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Role</a>
    <a href="${pageContext.request.contextPath}user"
       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">User</a>
    <a href="${pageContext.request.contextPath}product"
       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Product</a>
    <a href="${pageContext.request.contextPath}manufacturer"
       class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge">Manufacturer</a>

</div>

</body>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>

</html>
