package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

  public LoginServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.println("<html><head></head><body>");
    out.println("Login Serv " + "<br>");
    out.println("id : " + req.getParameter("id") + "<br>");
    out.println("pw : " + req.getParameter("pw") + "<br>");
    out.println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
