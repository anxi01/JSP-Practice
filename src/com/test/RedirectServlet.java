package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String site = req.getParameter("site");
    switch (site) {
      case "naver":
        resp.sendRedirect("https://www.naver.com/");
        break;
      case "daum":
        resp.sendRedirect("https://www.daum.net/");
        break;
      case "google":
        resp.sendRedirect("https://www.google.com/");
    }
  }
}
