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

    // 한글을 사용할 경우 UTF-8로 지정한다. (출력 형태 변경)
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=utf-8");

    PrintWriter out = resp.getWriter();
    out.println("<html><head></head><body>");
    for (int i = 0; i < 5; i++) {
      out.println("Hello" + i + "안녕" + "<br>");
    }
    out.println("</body></html>");
  }
}
