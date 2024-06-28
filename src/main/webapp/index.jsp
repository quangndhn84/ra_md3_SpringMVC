<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%response.sendRedirect("CategoriesController/findAll");%>--%>
<%--localhost:8080/categoriesController/findAll--%>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<ul>
    <li><a href="<%=request.getContextPath()%>/CategoriesController/findAll">Quản lý danh mục</a></li>
    <li><a href="<%=request.getContextPath()%>/productController/findAll">Quản lý sản phẩm</a></li>
</ul>
</body>
</html>