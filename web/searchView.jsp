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
    <title>Search Result</title>
</head>
<body>
    <h3>Search Result</h3>
    <c:if test="${not empty search}">
        <table border="1">
            <tr>
                <th>NAME</th><th>EMAIL</th><th>ADDRESS</th><th>PHONE NUMBER</th>
            </tr>
            <tr>
                <td>${search.name}</td>
                <td>${search.email}</td>
                <td>${search.address}</td>
                <td>${search.phone}</td>
            </tr>
        </table>
    </c:if>
    <c:if test="${empty search}">
        <p>No results found for the given name.</p>
    </c:if>
    <a href="home.jsp">Go back to Home</a>
</body>
</html>

