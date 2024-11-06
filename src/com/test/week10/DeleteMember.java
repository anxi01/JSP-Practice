package com.test.week10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/deleteMember")
public class DeleteMember extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        MemberDAO memberDAO = new MemberDAO();
        try {
            int cnt = memberDAO.deleteByName(req.getParameter("name"));
            if (cnt == 1) {
                out.print("Delete Successful");
            } else {
                out.print("Delete Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
