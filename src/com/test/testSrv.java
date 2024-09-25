package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testSrv")
public class testSrv extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();

    // 1. HTML 설정 없이 HTML 태그를 붙이는 경우
    out.print("1. HTML 설정 X" + "<br>");

    // 2. HTML 태그를 전부 붙이는 경우
    out.print("<html><title></title><body>");
    out.print("2. HTML 태그 전부 붙이는 경우" + "<br>");
    out.print("</body></html>");

    // 3, contentType만 지정할 경우
    resp.setContentType("text/html");
    out.print("3. contentType만 지정할 경우" + "<br>");
  }
}
