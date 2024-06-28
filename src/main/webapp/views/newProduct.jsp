<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 28/06/2024
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productController/create" method="post">
    <label for="productId">Product Id</label>
    <input type="text" id="productId" name="productId" value="${productNew.productId}"/>
    <span style="color: red"><c:if test="${productId}"/>${productId}</span><br>
    <label for="productName">Product Name</label>
    <input type="text" id="productName" name="productName" value="${productNew.productName}"/>
    <span style="color: red"><c:if test="${productName}"/>${productName}</span><br>
    <label for="price">Price</label>
    <input type="number" id="price" name="price" value="${productNew.price}"/>
    <span style="color: red"><c:if test="${price}"/>${price}</span><br>
    <label for="title">Title</label>
    <input type="text" id="title" name="title" value="${productNew.title}"/><br>
    <label for="catalogId">Chose Catalog</label>
    <select id="catalogId" name="catalogId">
        <c:forEach items="${listCategories}" var="catalog">
            <option value="${catalog.catalogId}" ${catalog.catalogId==productNew.catalogId?'selected':''}>${catalog.catalogName}</option>
        </c:forEach>
    </select><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" ${productNew.status?'checked':''}/><label for="active">Active</label>
    <input type="radio" id="inActive" name="status" value="false" ${productNew.status?'':'checked'}/><label
        for="inActive">Inactive</label><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
