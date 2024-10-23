<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 10. 23.
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    <jsp:forward page="forward.jsp">
        <jsp:param name="id" value="admin"/>
        <jsp:param name="name" value='<%= URLEncoder.encode("관리자", StandardCharsets.UTF_8)%>'/>
    </jsp:forward>
</body>
</html>
