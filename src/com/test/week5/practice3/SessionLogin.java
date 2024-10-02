package com.test.week5.practice3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin")
public class SessionLogin extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();

    String id = req.getParameter("id");
    String name = req.getParameter("name");

    resp.addCookie(new Cookie("id", id));

    Cookie[] cookies = req.getCookies();
    int visitCount = 0;

    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("count".equals(cookie.getName())) {
          visitCount = Integer.parseInt(cookie.getValue());
        }
      }
    }

    Cookie visitCountCookie = new Cookie("count", String.valueOf(++visitCount));
    resp.addCookie(visitCountCookie);

    HttpSession session = req.getSession();
    session.setAttribute("name", name);

    out.print("로그인 성공<br>");
    out.print(visitCount + "번째 방문입니다.<br>");
    out.print(name + "님 환영합니다.<br>");
  }
}
