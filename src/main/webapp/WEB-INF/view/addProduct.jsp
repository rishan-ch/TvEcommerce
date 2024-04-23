<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/addProduct" method="post" enctype="multipart/form-data">

<input type="text" placeholder="productName" name = "productName">
<input type="text" placeholder="productDescription" name = "productDescription">
<input type="text" placeholder="screenSize" name = "screenSize">
<input type="text" placeholder="quantity" name = "quantity">
<input type="text" placeholder="brand" name = "brand">
<input type="text" placeholder="price" name = "price">
<input type="file" name="image" accept="image/*">
<input type="submit">

</form>

</body>
</html>