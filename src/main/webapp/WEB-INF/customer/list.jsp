<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><html>
<head>
    <title>Customer</title>
</head>
<body>
<p>List of Customer</p>
<form action="${pageContext.request.contextPath}/customer/delete" method="post">
    <table border=1>
        <thead>
        <th></th>
        <th>CustomerId</th>
        <th>StoreId</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
        <th>AddressId</th>
        <th>Activebool</th>
        <th>CreateDate</th>
        <th>LocalDateTime</th>
        <th>Active</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.customer}" var="item">
            <tr>
                <td><input type="radioButtom" name="customerId" value="${item.customerId}"></td>
                <td>${item.customerId}</td>
                <td>${item.storeId}</td>
                <td>${item.firstName}</td>
                <td>${item.lastName}</td>
                <td>${item.email}</td>
                <td>${item.addressId}</td>
                <td>${item.activebool}</td>
                <td>${item.createDate}</td>
                <td>${item.lastUpdate}</td>
                <td>${item.active}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="submit">Delete</button>
</form>
<div>

    <form action="${pageContext.request.contextPath}/customer" method="post">
        <label for="storeID">StoreId</label>
        <input type="text" id="storeID" name="store"><br><br>
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName"><br><br>
        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName"><br><br>
        <label for="email">Email</label>
        <input type="text" id="email" name="email"><br><br>
        <label for="addressId">Address id:</label>
        <input type="text" id="addressId" name="addressId"><br><br>
        <label for="activebool">Activebool:</label>
        <input type="text" id="activebool" name="activebool"><br><br>
        <label for="active">Active:</label>
        <input type="text" id="active" name="active"><br><br>
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>
