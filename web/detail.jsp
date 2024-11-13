<%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 11. 13.
  Time: 오전 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.test.week11.AddressBookDTO" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
    <h3>Address Book Details</h3>
    <c:if test="${not empty detail}">
        <table border="1">
            <tr><th>Name</th><td>${detail.name}</td></tr>
            <tr><th>Email</th><td>${detail.email}</td></tr>
            <tr><th>Address</th><td>${detail.address}</td></tr>
            <tr><th>Phone Number</th><td>${detail.phone}</td></tr>
        </table>
    </c:if>
    <c:if test="${empty detail}">
        <p>No details available for this record.</p>
    </c:if>
    <a href="home.jsp">Go back to Home</a>
</body>
</html>

