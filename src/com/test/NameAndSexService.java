package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nameAndSexService")
public class NameAndSexService extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    if (id == null || id.isEmpty()) {
      return;
    }

    // 1. charAt 이용
    char sexSeparator = id.charAt(0);

    // 2. substring(0,1) 사용
    // String sexSeparator = id.substring(0, 1);

    boolean isMan = sexSeparator == '1' || sexSeparator == '3';
    boolean isWoman = sexSeparator == '2' || sexSeparator == '4';

    String name = req.getParameter("name");
    if (name == null || name.isEmpty()) {
      return;
    }
    // 한글 사용시 인코딩 해줘야함
    String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);

    if (isMan) {
      resp.sendRedirect("nameAndSexController?name=" + encodedName + "&gender=man");
    } else if (isWoman) {
      resp.sendRedirect("nameAndSexController?name=" + encodedName + "&gender=woman");
    } else {
      resp.setContentType("text/html;charset=UTF-8");
      PrintWriter out = resp.getWriter();
      out.print("올바르지 않은 주민번호 뒷자리입니다.");
    }
  }
}
