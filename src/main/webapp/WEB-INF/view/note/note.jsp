<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<%@include file="../function.jsp" %>
<%@include file="../error2.jsp" %>

<html>
<head>
    <title>Note</title>
</head>
<body>
<div class="w3-container w3-center w3-round-xlarge w3-padding-50">
    <div class="w3-container w3-center w3-round-xlarge w3-ios">
        <a href="/notes/list"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Notes List</a>
        <%--                <a href="${pageContext.request.contextPath}/product/manufacturerId"--%>
        <%--                   class="w3-btn  w3-hover-light-blue w3-round-xlarge">Product By Manufacturer ID</a>--%>
        <%--        <a href="/product/list2"--%>
        <%--           class="w3-btn  w3-hover-light-blue w3-round-xlarge"> Manufacturers</a>--%>
            <a href="/notes/new"
               class="w3-btn w3-hover-light-blue w3-round-xlarge">Add New Note</a>
        <a href="/notes/id"
           class="w3-btn w3-hover-light-blue w3-round-xlarge">Find Note By ID</a>
        <a href="/notes/update"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge">Update Note</a>
            <a href="/notes/delete"
               class="w3-btn  w3-hover-light-blue w3-round-xlarge"> <i class="fa fa-trash"></i> Delete Note</a>
        <p></p>
    </div>
</div>

<%--<div class="w3-panel w3-border w3-light-grey w3-round-large">--%>
<%--    <p>London is the most populous city in the United Kingdom,--%>
<%--        with a metropolitan area of over 9 million inhabitants.</p>--%>
<%--</div>--%>

</body>
</html>
