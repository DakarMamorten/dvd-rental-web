<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Address</title>
</head>
<body>
<p>List of address</p>
<form action="${pageContext.request.contextPath}/address/delete" method="post">
    <table border="1">
        <thead>
        <th></th>
        <th>AddressId</th>
        <th>Address</th>
        <th>Address2</th>
        <th>District</th>
        <th>CityId</th>
        <th>PostalCode</th>
        <th>Phone</th>
        <th>LocalDateTime</th>
        </thead>
        <tbody>

        <c:forEach items="${requestScope.address}" var="item">
            <tr>
                <td><input type="radio" id="radioButton" name="addressId" value="${item.addressId}"/></td>
                <td>${item.addressId}</td>
                <td>${item.address}</td>
                <td>${item.address2}</td>
                <td>${item.district}</td>
                <td>${item.cityId}</td>
                <td>${item.postelCode}</td>
                <td>${item.phone}</td>
                <td>${item.lastUpdate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="submit">Delete</button>
</form>
<div>

    <form action="${pageContext.request.contextPath}/address" method="post">
        <label for="address">Address:</label>
        <input type="text" id="address" name="address"><br><br>
        <label for="address2">Address2:</label>
        <input type="text" id="address2" name="address2"><br><br>
        <label for="district">District:</label>
        <input type="text" id="district" name="district"><br><br>
        <label for="cityId">CityId:</label>
        <input type="text" id="cityId" name="cityId"><br><br>
        <label for="postalCode">PostalCode:</label>
        <input type="text" id="postalCode" name="postalCode"><br><br>
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone"><br><br>
        <button type="submit">Add</button>
    </form>

</div>
</body>
</html>
