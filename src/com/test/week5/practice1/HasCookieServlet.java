package com.test.week5.practice1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hasCookie")
public class HasCookieServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");

    try (PrintWriter out = resp.getWriter()) {
      Cookie[] cookies = req.getCookies();
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if ("name".equals(cookie.getName()) && cookie.getValue() != null) {
            out.print(cookie.getValue() + " 회원님, 로그인하세요.");
            return;
          }
        }
      }
      out.print("회원가입하세요.");
    }
  }
}
