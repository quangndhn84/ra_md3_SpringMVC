<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 28/06/2024
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Title</th>
        <th>Catalog ID</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.title}</td>
            <td>${product.catalogId}</td>
            <td>${product.status?"Active":"Inactive"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/productController/initCreate">Create New Product</a>
</body>
</html>
