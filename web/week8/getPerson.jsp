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
    <jsp:useBean id="person" class="com.test.week8.Person" scope="request"/>
    <jsp:setProperty name="person" property="*" />
    <jsp:forward page="printPerson.jsp" />
</body>
</html>
