package com.test.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setMaxInactiveInterval")
public class SetMaxInactiveInterval extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        int time = session.getMaxInactiveInterval() / 60; // 분으로 환산 (기본값 : 1800 (30분))
        out.println("세션 유효 시간 : " + time + "분<br>");

        session.setMaxInactiveInterval(60 * 60); // 1시간
        time = session.getMaxInactiveInterval() / 60;
        out.println("세션 유효 시간 : " + time + "분<br>");
    }
}
