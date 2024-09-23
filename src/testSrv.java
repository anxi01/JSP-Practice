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
    // 응답의 컨텐트 타입을 명시적으로 지정한다.
    resp.setContentType("text/html");

    PrintWriter out = resp.getWriter();
    out.println("<html><head></head><body>");
    for (int i = 0; i < 5; i++) {
      out.println("Hello" + i + "<br>");
    }
    out.println("</body></html>");
  }
}
