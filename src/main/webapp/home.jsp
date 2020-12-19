<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="jsp-templates/head.jsp"/>
</head>
<body>
    <div class="container-fluid">
        <c:import url="jsp-templates/navbar.jsp"/>
        <h2 class="text-center text-white mt-5">Products Inventory</h2>
        <hr style="width: 50%"/>
        <h4 class="font-italic text-center text-white ">
           Check our products or add your own product!
        </h4>
        <br/>
        <div class="text-center">
            <a class="btn btn-secondary text-center mr-4" href="/products/create"
            >Upload Product</a
            >
            <a class="btn btn-secondary text-center ml-4" href="/products/all">All Products</a>
        </div>
    </div>
</body>
</html>
