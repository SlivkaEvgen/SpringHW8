<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>

<head>

    <style>
        html, body, h1, h2, h3, h4, h5, h6 {
            font-family: "Tangerine", "Roboto", sans-serif;
        }

        .w3-display-bottommiddle {
            z-index: 4;
            width: 450px;
            line-height: initial;
        }
    </style>

    <title>Role</title>
    <jsp:include page="../_header.jsp"></jsp:include>

</head>

<body>

<div class="w3-container w3-center w3-round-xlarge w3-padding-50">
    <div class="w3-container w3-center w3-round-xlarge w3-ios">
<%--        <a href="${pageContext.request.contextPath}/home"--%>
<%--           class="w3-btn w3-wide w3-hover-red w3-round-xlarge w3-ios-background">HOME</a>--%>
<%--        <p></p>--%>

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
        <%----%>
        <%--        --%>

        <%--        --%>
        <%--        "w3-display-position w3-padding w3-red" style="top:100px;left:100px"--%>
        <%--        <div class="w3-container w3-round-xlarge w3-hover-amber w3-hover-orange w3-hide-small w3-ios"--%>
        <div class="w3-display-position w3-round-xlarge w3-padding w3-hover-amber w3-red" style="top:350px;left:75px"
             style="bottom:15%;opacity:0.8;width:45% ; left: 75%">
            <h2><c:out value="${error}" default=""></c:out>
                <b><br></b></h2>
        </div>

        <%--        <div class="w3-display-right w3-container w3-round-xlarge w3-hover-amber w3-hover-orange w3-hide-small w3-ios"--%>
        <div class="w3-display-position w3-padding w3-round-xlarge w3-hover-amber w3-hover-orange w3-hide-small"
             style="top:350px;right:75px"
             style="bottom:7%;opacity:0.9;width:35% ; left: 80%">
            <h2><c:out value="${error2}" default=""></c:out>
                <b><br></b></h2>
        </div>



        <%----%>
        <%--        --%>
        <%--        --%>
        <%--        <div class="w3-display-center " style="margin-bottom:50px">--%>
        <%--            <div class="w3-display w3-container-centered w3-hover-amber w3-hover-orange w3-hide-small"--%>
        <%--                 style="bottom:3%;opacity:0.7;width:20% ; left: auto">--%>
        <%--                <h2><c:out value="${error}" default=""></c:out>--%>
        <%--                    <b>ERROR<br></b></h2>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <%--    </div>--%>
        <%--    <div class="w3-container w3-round-xlarge w3-hover-amber w3-hover-orange w3-hide-small w3-ios"--%>
        <%--                --%>
        <%--&lt;%&ndash;                 style="margin-bottom:150px" class="w3-display-right w3-container-centered w3-amber w3-hover-orange w3-hide-small"&ndash;%&gt;--%>
        <%--&lt;%&ndash;                     style="bottom:15%;opacity:0.9;width:45%">&ndash;%&gt;--%>
        <%--&lt;%&ndash;                    <h2><c:out value="${error2}" default=""></c:out>&ndash;%&gt;--%>
        <%--&lt;%&ndash;                        <b>...<br></b>ERROR-2</h2>&ndash;%&gt;--%>
        <%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
        <%--    </div>--%>
        <%----%>

        <%--        <div class="w3-display-container-centered " style="margin-bottom:30px">--%>
        <%--            <div class="w3-display-bottommiddle-top w3-container w3-hover-amber w3-hover-orange w3-hide-small"--%>
        <%--                 style="bottom:0%;opacity:0.9;width:35%">--%>
        <%--                <h2><c:out value="${error}" default=""></c:out>--%>
        <%--                    <b>ERROR<br></b></h2>--%>
        <%--            </div>--%>


        <%--        <div class="w3-button w3-round-xlarge  w3-centered">--%>
        <%--            <h4 style="text-align-all: center;  background-color:crimson"--%>
        <%--                class="w3-display-middle-centered w3-red w3-round w3-margin-top w3-center">--%>
        <%--&lt;%&ndash;                <c:out value="${error}" default=""></c:out>&ndash;%&gt;--%>
        <%--            </h4>--%>
        <%--        </div>--%>
        <%--        <div class="w3-button w3-round-xlarge  w3-centered">--%>
        <%--            <h4 style="text-align-all: center;  background-color:skyblue; width: initial; text-decoration-style: solid"--%>
        <%--                class="w3-display-middle-centered w3-round-xlarge large w3-blue w3-round w3-margin-top w3-center">--%>
        <%--                <c:out value="${error2}" default=""></c:out>--%>
        <%--            </h4>--%>
        <%--        </div>--%>
        <%--    </div>--%>

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
</div>
</body>

</html>