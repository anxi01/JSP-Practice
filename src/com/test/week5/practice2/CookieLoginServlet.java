package com.test.week5.practice2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLogin")
public class CookieLoginServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*
    원래는 cookie == null일 경우의 조건만 넣으면 되는데
    현재 localhost 의 다른 쿠키들이 존재해서 id를 비교하는 조건으로 변경함
     */
    resp.setContentType("text/html;charset=utf-8");
    try (PrintWriter out = resp.getWriter()) {
      Cookie[] cookies = req.getCookies();

      if (cookies != null) {
        boolean idFound = false;

        for (Cookie cookie : cookies) {
          if ("id".equals(cookie.getName())) {
            out.print("Welcome " + cookie.getValue() + "!");
            idFound = true;
            break;
          }
        }

        if (!idFound) {
          out.print("Welcome <a href='/cookieLogin.html'>Login</a>");
        }
      } else {
        out.print("Welcome <a href='/cookieLogin.html'>Login</a>");
      }
    }
  }
}
