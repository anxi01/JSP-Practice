        <%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: anxi
  Date: 24. 11. 6.
  Time: 오전 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getUserList</title>
</head>
<body>
    <%
        StringBuilder sb = new StringBuilder();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from member");
            ResultSet resultSet = preparedStatement.executeQuery();

//            Statement statement = connection.createStatement();
//            statement.execute("select * from member");
//            ResultSet resultSet = statement.executeQuery("select * from member");

            while (resultSet.next()) {
                sb.append(resultSet.getString("name")).append(" ").append(resultSet.getString("email")).append("<br>");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    %>
    <%= sb.toString()%>
</body>
</html>
