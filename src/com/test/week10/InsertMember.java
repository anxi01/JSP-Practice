package com.test.week10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/insertMember")
public class InsertMember extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        MemberDAO memberDAO = new MemberDAO();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        try {
            int cnt = memberDAO.insert(new MemberDTO(null, name, email));
            if (cnt == 1) {
                out.print("Save Successful");
            } else {
                out.print("Save Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
