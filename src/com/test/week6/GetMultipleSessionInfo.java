package com.test.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/getMultipleSessionInfo")
public class GetMultipleSessionInfo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("name", "Han");
        session.setAttribute("age", 24);
        session.setAttribute("hobby", "youtube");

        Enumeration enumeration = session.getAttributeNames();
        PrintWriter out = resp.getWriter();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            Object value = session.getAttribute(key);
            out.print(key + "=" + value + "\n");
        }
    }
}
