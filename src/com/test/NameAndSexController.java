package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nameAndSexController")
public class NameAndSexController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String gender = req.getParameter("gender");

    resp.setContentType("text/html;charset=utf-8");

    PrintWriter out = resp.getWriter();
    out.print("이름 : " + name + "<br>");
    out.print("성별 : " + ("man".equals(gender) ? "남성" : "여성") + "<br>");
  }
}
