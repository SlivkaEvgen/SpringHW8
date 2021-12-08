<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<style>
    /*html, body, h1, h2, h3, h4, h5, h6 {*/
    /*    font-family: "Roboto", sans-serif;*/
    /*}*/

    .w3-display-bottommiddle {
        z-index: 2;
        width: 550px;
        line-height: initial;
    }
</style>

<head>
<%--    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <meta name='DC.Language' scheme='rfc1766' content='ru'/>--%>

    <title>Update Product</title>
    <jsp:include page="product.jsp"></jsp:include>
</head>

<div class="w3-container w3-center  w3-round-xlarge">
    <form class="w3-container m3-center  w3-round-xlarge" method="Post" action="${pageContext.request.contextPath}update">
        <nav class="w3-bar-block  w3-light-grey w3-animate-top w3-card  w3-round-xlarge w3-display-bottommiddle">
            <h5 style="color:steelblue" class="text w3-center w3-animate-fading  w3-round-xlarge">Update Product</h5>
<%--            <table class="w3-table-all w3-small w3-centered w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity"--%>
<%--                   id="myTable">--%>
            <table class="w3-table-all w3-small w3-centered "
                   class="w3-hoverable w3-center w3-padding w3-table-all w3-card-4 w3-small w3-margin-top w3-round-xlarge w3-centered w3-animate-opacity">
                <tr>
                    <td>ID</td>
                    <td><label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="text" name="id" placeholder=" Enter ID " value="${product.id}"/>
                    </label></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="text" name="name" placeholder=" Enter Name  " value="${product.name}"/>
                    </label></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><label>
                        <input class="w3-input w3-center w3-border w3-small w3-round-xlarge w3-hover-light-blue"
                               type="text" name="price" placeholder=" Enter price  " value="${product.price}"/>
                    </label></td>
                </tr>
                <tr>
                    <td>Manufacturer</td>
                    <td><label>
                        <select class="w3-select w3-center w3-round-xlarge" name="manufacturer">
                            <option value="" disabled selected>Choose Manufacturer</option>
                            <option value="1">APPLE</option>
                            <option value="2">SAMSUNG</option>
                            <option value="3">LG</option>
                            <option value="4">MOTOROLA</option>
                        </select>
                    </label></td>
                </tr>
                <tr>
                    <th><a href="${pageContext.request.contextPath}/product"
                           class="w3-btn w3-hover-red w3-round-xlarge">CANCEL</a>
                    </th>
                    <td colspan="1">
                        <input type="submit" class="w3-input w3-border w3-hover-green w3-round-xlarge w3-light-blue"
                               value="UPDATE"/>
                    </td>
                </tr>
            </table>
            <h5 style="color:steelblue" class="text w3-round-xlarge w3-animate-bottom">UPDATE PRODUCT</h5>
        </nav>
    </form>
</div>

<%--</body>--%>

<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">
    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>

</div>

<div class="w3-container w3-center w3-rodoto w3-text-dark-gray">
    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/SpringHW8" target="_blank">Slivka</a>
    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>
</div>

</html>
<%--                </tr>--%>
<%--                <h5 style="color:steelblue" class="text w3-center w3-round-xlarge w3-animate-bottom">UPDATE PRODUCT</h5>--%>
<%--            </table>--%>
<%--        </nav>--%>

<%--    </form>--%>
<%--</div>--%>

<%--<div class="w3-container w3-center w3-tangerine w3-text-dark-gray ">--%>
<%--    <p class="w3-xxlarge">"Make it as simple as possible, but not simpler."</p>--%>
<%--</div>--%>

<%--<footer class="w3-container w3-center w3-rodoto w3-text-dark-gray w3-display-bottommiddle">--%>
<%--    <p> &copy;Copyright <a href="https://github.com/SlivkaEvgen/JpaServletsMVChw6" target="_blank">Slivka</a>--%>
<%--    <p><a class="font-menu-button w3-center w3-red w3-round-xlarge">GO-IT</a></p>--%>
<%--</footer>--%>

<%--</html>--%>