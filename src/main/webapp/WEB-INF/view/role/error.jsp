<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>Error</title>
</head>

<body>
<div class="w3-display-position w3-round-xlarge w3-padding w3-hover-amber w3-red" style="top:350px;left:75px"
     style="bottom:15%;opacity:0.8;width:45% ; left: 75%">
    <h2><c:out value="${error}" default=""></c:out><b><br></b></h2>
</div>

<div class="w3-display-position w3-padding w3-round-xlarge w3-hover-amber w3-hover-orange w3-hide-small"
     style="top:350px;right:75px" style="bottom:7%;opacity:0.9;width:35% ; left: 80%">
    <h2><c:out value="${error2}" default=""></c:out><b><br></b></h2>
</div>
</body>

</html>
