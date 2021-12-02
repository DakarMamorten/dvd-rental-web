<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Category</title>
</head>
<body>
<p>List of category</p>
<table border="1">
    <thead>
    <th>CategoryId</th>
    <th>Name</th>
    <th>LocalDateTime</th>
    </thead>
    <tbody>


    <c:forEach items="${requestScope.category}" var="item">
        <tr>
            <td>${item.categoryID}</td>
            <td>${item.name}</td>
            <td>${item.lastUpdate}</td>
<%--            <td>${item.localDateTime}</td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <form action="${pageContext.request.contextPath}/category" method="post">
        <label for="categoryName">Name:</label>
        <input type="text" id="categoryName" name="categoryName"><br><br>
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>
