
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<nav class="navbar navbar-expand-lg navbar-background">
    <a class="nav-link text-white active h5" href="/index">Home</a>
    <div class="collapse navbar-collapse d-flex justify-content-end">
        <ul class="navbar-nav row">
            <% if(request.getSession().getAttribute("username") == null) {%>
            <li class="nav-item col-md-4">
                <a class="nav-link text-white active font-weight-bold" href="/users/login">Login</a>
            </li>
            <li class="nav-item col-md-4">
                <a class="nav-link text-white active font-weight-bold" href="/users/register">Register</a>
            </li>
            <%} else {%>
            <li class="nav-item col-md-4">
                <a class="nav-link text-white active font-weight-bold"
                   href="/products/create">Upload Product</a>
            </li>
            <li class="nav-item col-md-4">
                <a class="nav-link text-white active font-weight-bold" href="/products/all">All Products</a>
            </li>
            <li class="nav-item col-md-4">
                <a class="nav-link text-white active font-weight-bold" href="/logout">Logout</a>
            </li>
            <%}%>
        </ul>
    </div>
</nav>

</html>
