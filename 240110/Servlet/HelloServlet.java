import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/HelloWorld")
public class HelloServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("안녕하세요 Servlet에서 보내는 Hello World 입니다.");
    }
}