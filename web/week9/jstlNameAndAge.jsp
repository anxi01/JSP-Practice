<%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 10. 30.
  Time: 오전 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>NameAndAge</title>
</head>
<body>
    <c:set var="name" value="${param.name}" />
    <c:set var="age" value="${param.age}" />

    <c:choose>
<%--        <c:when test="${''.equals(name)}">--%>
        <c:when test="${empty name}">
            로그인하세요.
        </c:when>
        <c:otherwise>
            환영합니다. <br>
            당신의 이름은 ${name}이고 나이는 ${age}세 입니다.
        </c:otherwise>
    </c:choose>
</body>
</html>
