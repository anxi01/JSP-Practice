package com.test.week5.practice3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcomeSession")
public class WelcomeSessionServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");

    String idValue = "";

    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("id".equals(cookie.getName()) && cookie.getValue() != null) {
          idValue = cookie.getValue();
          break;
        }
      }
    }

    try (PrintWriter out = resp.getWriter()) {
      out.print("<!DOCTYPE html>");
      out.print("<html lang='en'>");
      out.print("<head><meta charset='UTF-8'><title>Login</title></head>");
      out.print("<body>");
      out.print("<form action='sessionLogin' method='post'>");
      out.print("<p>아이디 : <input type='text' name='id' value='" + idValue + "'></p>");
      out.print("<p>이름 : <input type='text' name='name'></p>");
      out.print("<p><input type='submit' value='전송'></p>");
      out.print("</form>");
      out.print("</body></html>");
    }
  }
}
