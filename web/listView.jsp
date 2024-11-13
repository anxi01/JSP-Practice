<%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 11. 13.
  Time: 오전 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.test.week11.AddressBookDTO" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Address Book List</h3>
    <table border="1">
        <tr>
            <th>NAME</th><th>EMAIL</th>
            <th>ADDRESS</th><th>PHONE NUMBER</th>
        </tr>
        <c:forEach items="${list_all}" var="ab" >
            <tr>
                <td><a href="addressBookController?action=detail&num=${ab.num}" >${ab.name}</a></td>
                <td>${ab.email}</td><td>${ab.address}</td>
                <td>${ab.phone}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
