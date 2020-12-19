<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="jsp-templates/head.jsp"/>
</head>
<body>
    <div class="container-fluid">
        <c:import url="jsp-templates/navbar.jsp"/>
        <form class="mx-auto w-15" method="post">
            <div class="row">
                <div class="col col-md-3"></div>
                <div class="col col-md-3">
                    <div class="form-group">
                        <div class="label-holder d-flex justify-content-center">
                            <label class="text-center text-white font-weight-bold" for="product-name">Product Name
                                <input type="text" class="form-control" name="product-name" id="product-name" placeholder="Product-Name">
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col col-md-3">
                    <div class="form-group">
                        <div class="label-holder d-flex justify-content-center">
                            <label class="text-center text-white font-weight-bold" for="user">User
                                <input type="text" class="form-control" name="user" id="user" placeholder="User">
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col col-md-3"></div>
                <div class="col col-md-3">
                    <div class="form-group">
                        <div class="label-holder d-flex justify-content-center">
                            <label class="text-center text-white font-weight-bold" for="user">Quantity
                                <input type="number" class="form-control" placeholder="Quantity" name="quantity" id="quantity">
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col col-md-3">
                    <div class="form-group ">
                        <div class="label-holder d-flex justify-content-center">
                            <label class="text-center text-white font-weight-bold" for="type">Type
                                <select id="type" name="type" class="form-control">
                                    <option value="food">Food</option>
                                    <option value="drink">Drink</option>
                                </select>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col col-md-4"></div>
                <div class="col col-md-4">
                    <div class="button-holder d-flex justify-content-center">
                        <input type="submit" class="btn btn-secondary" value="Upload Product"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
