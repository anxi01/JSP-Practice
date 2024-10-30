<%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 10. 30.
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL PRACTICE</title>
</head>
<body>
    <c:set var="name" value="Han"/>
    <c:set var="age" value="24"/>

    이름 : ${name} <br>
    나이 : ${age} <br>

    <c:if test="${name == 'Han'}">
        이름이 동일합니다. (동등성) <br>
    </c:if>

    <c:if test="${'Han'.equals(name)}">
        이름이 동일합니다. (동일성) <br>
    </c:if>

    <c:choose>
        <c:when test="${age > 20}">
            성인입니다. <br>
        </c:when>
        <c:otherwise>
            미성년자입니다. <br>
        </c:otherwise>
    </c:choose>
</body>
</html>
