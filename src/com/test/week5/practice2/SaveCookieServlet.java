package com.test.week5.practice2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveCookie")
public class SaveCookieServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    String passwd = req.getParameter("passwd");

    Cookie idCookie = new Cookie("id", id);
    Cookie passwdCookie = new Cookie("passwd", passwd);
    idCookie.setMaxAge(60 * 10);
    passwdCookie.setMaxAge(60 * 10);

    resp.addCookie(idCookie);
    resp.addCookie(passwdCookie);

    resp.sendRedirect("/cookieInfo");
  }
}
