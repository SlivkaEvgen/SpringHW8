<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>

    <title>Role</title>
    <jsp:include page="../_header.jsp"></jsp:include>

</head>

<body>

<div class="w3-container w3-center w3-round-xlarge w3-padding-50">
    <div class="w3-container w3-center w3-round-xlarge w3-ios">
        <a href="${pageContext.request.contextPath}/home"
           class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>
        <p></p>

        <div class="w3-container w3-center w3-large" style="color:steelblue">
            <a href="${pageContext.request.contextPath}/role"
               class="w3-btn  w3-wide w3-hover-light-blue w3-round-xlarge " style="text-align-all: center ">ROLE
                PAGE</a>
        </div>
        <p></p>

        <a href="${pageContext.request.contextPath}/role/list"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Roles List</a>
        <a href="${pageContext.request.contextPath}/role/id"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Find By ID</a>
        <a href="${pageContext.request.contextPath}/role/name"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By Name</a>
        <a href="${pageContext.request.contextPath}/role/new"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Add New</a>
        <a href="${pageContext.request.contextPath}/role/update"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Update</a>
        <a href="${pageContext.request.contextPath}/role/delete"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Delete</a>

        <div>
            <h4 style="text-align-all: center" class="text w3-red w3-round w3-margin-top w3-center">
                <c:out value="${error}" default=""></c:out>
            </h4>
        </div>
        <div>
            <h4 style="text-align-all: center; background-color:skyblue"
                class="text w3-blue w3-round w3-margin-top w3-center">
                <c:out value="${error2}" default=""></c:out>
            </h4>
        </div>
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

</div>

</body>

</html>