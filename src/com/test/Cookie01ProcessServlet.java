package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie01_process")
public class Cookie01ProcessServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");

    String id = req.getParameter("id");
    String passwd = req.getParameter("passwd");

    PrintWriter out = resp.getWriter();
    if ("admin".equals(id) && "1234".equals(passwd)) {
      resp.addCookie(new Cookie("id", id));
      resp.addCookie(new Cookie("passwd", passwd));
      out.print("쿠키 생성이 완료되었습니다<br>");
      out.print("admin님 환영합니다.");
    } else {
      out.print("쿠키 생성이 실패되었습니다.");
    }
  }
}
