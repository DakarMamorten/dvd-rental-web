<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Address</title>
</head>
<body>
<p>List of address</p>
    <table border="1">
        <thead>
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
                <td>${item.addressID}</td>
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
<div>

    <form action="${pageContext.request.contextPath}/address" method="post">
        <label for="addressId">Name:</label>
        <input type="text" id="addressId" name="addressId"><br><br>
        <button type="submit">Add</button>
    </form>

</div>
</body>
</html>
