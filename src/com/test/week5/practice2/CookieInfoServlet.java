package com.test.week5.practice2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieInfo")
public class CookieInfoServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();

    Cookie[] cookies = req.getCookies();
    if (cookies == null) {
      out.print("로그인이 되지 않았습니다.");
      resp.sendRedirect("/cookieLogin");
    } else {
      for (Cookie cookie : cookies) {
        if ("id".equals(cookie.getName()) && cookie.getValue() != null) {
          out.print("welcome1 " + cookie.getValue() + "<br>");
          out.print("welcome <a href='/twoDepthCookie'>go Another Page</a>");
        }
      }
    }
  }
}
