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
    <%
        person.setName("한성민");
        person.setId("2022");
    %>
    <p> 이름 : <%=person.getName()%></p>
    <p> ID : <%=person.getId()%></p>
</body>
</html>
