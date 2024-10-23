<%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 10. 23.
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward</title>
</head>
<body>
    <p> 아이디 :  <%= request.getParameter("id")%> </>
    <p> 이름 :  <%= request.getParameter("name")%> </>
</body>
</html>
