<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 10. 23.
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getAge</title>
</head>
<body>
<jsp:useBean id="age" class="com.test.week8.Age" />
<%
    String year = request.getParameter("birthYear");
    age.setAge(Integer.parseInt(year));
%>
<p> 당신의 나이는 <%=age.getAge()%>세 입니다.</p>
</body>
</html>
