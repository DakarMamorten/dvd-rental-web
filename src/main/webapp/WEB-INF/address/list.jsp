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

    <!--DOCTYPE html-->
    <html>

    <head>
        <meta charset="utf-8">
        <link href='//fonts.googleapis.com/css?family=PT+Sans:400,700&subset=cyrillic' rel='stylesheet' type='text/css'>
    </head>

    <body>
    <div class="paginator">
        <a class="prev disabled" href="/dvd-rental/address">Предыдущая</a>
        <a class="current" href="/dvd-rental/address">1</a>
        <a class="current" href="/dvd-rental/address">2</a>
        <a class="current" href="/dvd-rental/address">3</a>
        <a href="/dvd-rental/address">4</a>
        <a class="next" href="/dvd-rental/address">Следующая</a>
    </div>
    </body>

    </html>
</form>
</body>
</html>
