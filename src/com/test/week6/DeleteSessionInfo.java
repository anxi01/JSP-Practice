package com.test.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteSessionInfo")
public class DeleteSessionInfo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        session.setAttribute("key1", "value1");
        session.setAttribute("key2", "value2");

        PrintWriter out = resp.getWriter();
        // 단일 세션 정보 제거
        session.removeAttribute("key1");
        out.print(session.getAttribute("key1"));

        // 다중 세션 삭제
        session.invalidate();
        out.print(session.getAttribute("key2"));

        // 세션 유효한지 확인
        out.print(req.isRequestedSessionIdValid());
    }
}
