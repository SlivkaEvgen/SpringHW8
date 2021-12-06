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
            <a href="${pageContext.request.contextPath}/user"
               class="w3-btn  w3-wide w3-hover-light-blue w3-round-xlarge " style="text-align-all: center ">USER
                PAGE</a>
        </div>
        <p></p>
        <a href="${pageContext.request.contextPath}/user/list"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Users List</a>
        <a href="${pageContext.request.contextPath}/user/id"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By ID</a>
        <a href="${pageContext.request.contextPath}/user/name"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Find By Name</a>
        <a href="${pageContext.request.contextPath}/user/new"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Add New</a>
        <a href="${pageContext.request.contextPath}/user/update"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Update</a>
        <a href="${pageContext.request.contextPath}/user/delete"
           class="w3-btn  w3-hover-light-blue w3-round-xlarge">Delete</a>
        <p></p>
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



