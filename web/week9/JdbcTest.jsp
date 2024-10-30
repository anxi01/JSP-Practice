<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 10. 30.
  Time: 오전 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JdbcTest</title>
</head>
<body>
<%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "");
        response.getWriter().print("success");
    } catch (SQLException e) {
        response.getWriter().println("SQLException" + e);
        e.printStackTrace();
    } catch (Exception e) {
        response.getWriter().println("Exception:" + e);
        e.printStackTrace();
    }
%>
</body>
</html>
