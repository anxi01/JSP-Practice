package com.test.week10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/getUserList")
public class GetUserList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        MemberDAO memberDAO = new MemberDAO();
        PrintWriter out = response.getWriter();
        try {
            List<MemberDTO> members = memberDAO.select();
            for (MemberDTO memberDTO : members) {
                out.println(memberDTO + "<br>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
