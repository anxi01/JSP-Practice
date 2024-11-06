package com.test.week10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/insertMember")
public class InsertMember extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into member (name, email)" +
                    " values (?,?)");
            preparedStatement.setString(1, req.getParameter("name"));
            preparedStatement.setString(2, req.getParameter("email"));
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                System.out.println("success");
            }
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
