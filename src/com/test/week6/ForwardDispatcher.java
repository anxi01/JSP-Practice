package com.test.week6;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forwardDP")
public class ForwardDispatcher extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // /forwardDP -> /dispatcher 로 전송
        RequestDispatcher dispatcher = req.getRequestDispatcher("dispatcher");
        dispatcher.forward(req, resp);
    }
}
