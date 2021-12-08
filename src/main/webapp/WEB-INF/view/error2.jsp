<%--
  Created by IntelliJ IDEA.
  User: mymac
  Date: 08.12.2021
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error2</title>
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
