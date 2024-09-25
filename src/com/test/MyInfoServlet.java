package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/myInfoServlet")
public class MyInfoServlet extends HttpServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    res.setCharacterEncoding("UTF-8");
    res.setContentType("text/html;charset=UTF-8");

    PrintWriter out = res.getWriter();
    out.print("정보 확인" + "<br><br>");
    out.print("이름 : " + req.getParameter("name") + "<br>");
    out.print("별명 : " + req.getParameter("nickname") + "<br>");
    out.print("학년 : " + req.getParameter("year") + " 학년" + "<br>");
    out.print("성별 : " + req.getParameter("gender") + "<br>");
    out.print("수강과목 : " + String.join(", ", req.getParameterValues("subject")) + "<br>");
  }
}
