<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<%--    <title>Error2</title>--%>
</head>
<body>

<div>
    <h4 style="text-align-all: center" class="text w3-red w3-round-xlarge w3-margin-top w3-center">
        <c:out value="${error}" default=""></c:out>
    </h4>
</div>
<div>
    <h4 style="text-align-all: center; background-color:skyblue"
        class="text w3-blue w3-round-xlarge w3-margin-top w3-center">
        <c:out value="${error2}" default=""></c:out>
    </h4>
</div>


</body>
</html>
