<%@ page import="domain.view.ViewModel" %>
<%@ page import="domain.service.ProductServiceModel" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="jsp-templates/head.jsp"/>
</head>
<body>
<div class="container-fluid">
    <c:import url="jsp-templates/navbar.jsp"/>
    <h2 class="text-center text-white mt-5">West Compass Offers</h2>
    <hr style="width: 50%"/>
    <% ViewModel<List<ProductServiceModel>> model = (ViewModel<List<ProductServiceModel>>) request.getAttribute("model");%>
    <div class='row mb-4 d-flex justify-content-around'>
        <% for (ProductServiceModel product : model.getObject()) {%>
        <div class="col-md-4 d-flex flex-column bg-text mb-3">
            <h2>Owner: <%=product.getUser()%>
            </h2>
            <h2>Product Name: <%=product.getName()%>
            </h2>
            <h4>Quantity: <%=product.getQuantity()%>
            </h4>
            <h4>Product Type: <%=product.getType().name()%>
            </h4>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>
