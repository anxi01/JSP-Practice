package com.test.week11;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDAO {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/practice";
    private final String USER = "root";
    private final String PASSWORD = "";

    public List<AddressBookDTO> listAll(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<AddressBookDTO> list = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM practice.address_book";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int num = resultSet.getInt("num");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String addr = resultSet.getString("address");
                String tel = resultSet.getString("phone");
                AddressBookDTO addrbookDTO = new AddressBookDTO(num, name, email, addr, tel);
                list.add(addrbookDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }

    public int add(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int res = 0;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String addr = request.getParameter("addr");
            String tel = request.getParameter("tel");
            String sql = "INSERT INTO practice.address_book (name,email,address,phone) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, addr);
            preparedStatement.setString(4, tel);
            res = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return res;
    }

    public int delete(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int res =0;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String name = request.getParameter("name");
            String sql = "DELETE FROM practice.address_book WHERE (`name` = ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            res = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return res;
    }

    public int modify(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int res = 0;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String addr = request.getParameter("addr");
            String tel = request.getParameter("tel");

            String sql = "UPDATE practice.address_book SET name = ?, email = ?, address = ?, phone = ? WHERE name = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, addr);
            preparedStatement.setString(4, tel);
            preparedStatement.setString(5, name);

            res = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return res;
    }

    public AddressBookDTO search(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        AddressBookDTO addressBookDTO = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String name = request.getParameter("name");
            String sql = "SELECT * FROM practice.address_book WHERE name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                addressBookDTO = new AddressBookDTO(
                        resultSet.getInt("num"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return addressBookDTO;
    }

    public AddressBookDTO detail(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        AddressBookDTO addressBookDTO = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String num = request.getParameter("num");
            String sql = "SELECT * FROM practice.address_book WHERE num = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(num));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                addressBookDTO = new AddressBookDTO(
                        resultSet.getInt("num"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return addressBookDTO;
    }
}
