package com.test.week10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/practice";
    private final String USER = "root";
    private final String PASSWORD = "";

    public List<MemberDTO> select() throws SQLException {
        List<MemberDTO> members = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("select * from member");

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                members.add(new MemberDTO(id, name, email));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return members;
    }
}
