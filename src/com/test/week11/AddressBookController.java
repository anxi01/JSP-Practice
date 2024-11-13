package com.test.week11;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addressBookController")
public class AddressBookController extends HttpServlet {

    private final AddressBookDAO addressBookDAO = new AddressBookDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fPage = null;
        try {
            String action = req.getParameter("action");
            switch (action) {
                case "list":
                    fPage = list_all(req, resp);
                    break;
                case "del":
                    fPage = del(req, resp);
                    break;
                case "add":
                    fPage = add(req, resp);
                    break;
                case "modify":
                    fPage = modify(req, resp);
                    break;
                case "search":
                    fPage = search(req, resp);
                    break;
                case "detail":
                    fPage = detail(req, resp);
                    break;
            }
            getServletContext().getRequestDispatcher(fPage).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String list_all(HttpServletRequest request, HttpServletResponse response) {
        List<AddressBookDTO> list = addressBookDAO.listAll();
        ServletContext app = request.getServletContext();
        app.setAttribute("list_all", list);
        return "/listView.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        int rs = addressBookDAO.add(request, response);
        if (rs != 0) {
            return "/success.jsp";
        } else {
            return "/error.jsp";
        }
    }

    private String del(HttpServletRequest request, HttpServletResponse response) {
        int rs = addressBookDAO.delete(request, response);
        if (rs != 0) {
            return "/success.jsp";
        } else {
            return "/error.jsp";
        }
    }

    private String modify(HttpServletRequest request, HttpServletResponse response) {
        int rs = addressBookDAO.modify(request, response);
        if (rs != 0) {
            return "/success.jsp";
        } else {
            return "/error.jsp";
        }
    }

    private String search(HttpServletRequest request, HttpServletResponse response) {
        AddressBookDTO addressBookDTO = addressBookDAO.search(request, response);
        ServletContext app = request.getServletContext();
        app.setAttribute("search", addressBookDTO);
        return "/searchView.jsp";
    }

    private String detail(HttpServletRequest request, HttpServletResponse response) {
        AddressBookDTO addressBookDTO = addressBookDAO.detail(request, response);
        ServletContext app = request.getServletContext();
        app.setAttribute("detail", addressBookDTO);
        return "/detail.jsp";
    }
}
