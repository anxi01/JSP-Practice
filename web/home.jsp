<%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 11. 13.
  Time: 오전 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>AddressBook</title>
</head>
<body>
<a href="addressBookController?action=list">View Address Book List</a>
&nbsp;&nbsp;&nbsp;

<form action="addressBookController" method="get">
    name <input type="text" name="name"><br>
    email <input type="text" name="email"><br>
    address <input type="text" name="addr"><br>
    phone <input type="text" name="tel">
    <input type="submit" value="Add">
    <input type="hidden" name="action" value="add">
</form>
<br><br>

<form action="addressBookController" method="get">
    name <input type="text" name="name">
    <input type="submit" value="Delete">
    <input type="hidden" name="action" value="del">
</form>
<br><br>

<form action="addressBookController" method="get">
    name <input type="text" name="name">
    <input type="submit" value="Search">
    <input type="hidden" name="action" value="search">
</form>
<br><br>

<form action="addressBookController" method="get">
    name <input type="text" name="name" required><br>
    email <input type="text" name="email"><br>
    address <input type="text" name="addr"><br>
    phone <input type="text" name="tel"><br>
    <input type="submit" value="Modify">
    <input type="hidden" name="action" value="modify">
</form>
<br><br>
</body>
</html>
