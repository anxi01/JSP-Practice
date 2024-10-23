<%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 10. 23.
  Time: 오전 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getPerson</title>
</head>
<body>
    <jsp:useBean id="person" class="com.test.week8.Person" />
    <jsp:setProperty name="person" property="id" />
    <jsp:setProperty name="person" property="name" />
    <p> 이름 : <jsp:getProperty name="person" property="name"/></p>
    <p> 아이디 : <jsp:getProperty name="person" property="id"/></p>
</body>
</html>
