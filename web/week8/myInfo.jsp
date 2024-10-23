<%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 10. 23.
  Time: 오전 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String nickname = request.getParameter("nickname");
    String year = request.getParameter("year");
    String gender = request.getParameter("gender");
    String[] subjects = request.getParameterValues("subject");
%>

<h2>정보 확인</h2>
<p>이름: <%= name %></p>
<p>별명: <%= nickname %></p>
<p>학년: <%= year %> 학년</p>.
<p>성별: <%= gender %></p>
<p>수강과목: <%= String.join(", ", subjects) %></p>
</body>
</html>
