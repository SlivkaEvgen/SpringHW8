<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>

<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name='DC.Language' scheme='rfc1766' content='ru'/>

    <title>Manufacturer</title>
    <jsp:include page="../_menu.jsp"></jsp:include>
</head>

<sec:authorize access="!isAuthenticated()">
    <a href="${pageContext.request.contextPath}logout"
       class="w3-btn w3-hover-red w3-round-xlarge w3-ios-background w3-display-topright">Logout</a>
</sec:authorize>

<body>

<div class="w3-container w3-center w3-round-xlarge">
    <div class="w3-container w3-center w3-large" style="color:indianred">
        <a href="${pageContext.request.contextPath}/home"
           class="w3-btn w3-wide w3-hover-light-blue w3-round-xlarge " style="text-align-all: center ">Home</a>
    </div>
    <div class="w3-container w3-center w3-round-xlarge" style="color:steelblue">
        <a href="${pageContext.request.contextPath}/manufacturer"
           class="w3-btn w3-hover-light-blue w3-round-xlarge w3-wide" style="text-align-all: center ">MANUFACTURER
            PAGE</a>
    </div>

    <a href="${pageContext.request.contextPath}/manufacturer/list"
       class="w3-btn  w3-hover-light-blue w3-round-xlarge">Manufacturers List</a>
    <a href="${pageContext.request.contextPath}/manufacturer/id"
       class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By ID</a>
    <a href="${pageContext.request.contextPath}/manufacturer/name"
       class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By Name</a>
    <a href="${pageContext.request.contextPath}/manufacturer/new"
       class="w3-btn  w3-hover-light-blue w3-round-xlarge">Add New</a>
    <a href="${pageContext.request.contextPath}/manufacturer/update"
       class="w3-btn w3-hover-light-blue w3-round-xlarge">Update</a>
    <a href="${pageContext.request.contextPath}/manufacturer/delete"
       class="w3-btn  w3-hover-light-blue w3-round-xlarge">Delete</a>
    <p></p>
</div>

<div>
    <h4 style="text-align-all: center" class="text w3-blue w3-round-xlarge w3-margin-top w3-center">
        <c:out value="${error}" default=""></c:out>
    </h4>
</div>
<div>
    <h4 style="text-align-all: center; background-color:skyblue"
        class="text w3-blue w3-round-xlarge w3-margin-top w3-center">
        <c:out value="${error2}" default=""></c:out>
    </h4>
</div>

<script>
    function myFunction() {
        var input, filter, table, tr, td, i;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>

</body>


</html>

