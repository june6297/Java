import java.io.*;
import java.net.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;


@WebServlet (urlPatterns = {"/SendImage","/GetImage"})

public class ServiceServlet extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=utf-8");
        InputStream in = request.getInputStream();
        FileOutputStream out = new FileOutputStream("C.png");

        byte[] data = new byte[1024*8];
        int size;

        while((size=in.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }
        in.close();
        out.close();

        PrintWriter out2 = response.getWriter();
        out2.println("성공");
        out2.close();

    }


    // public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    //     response.setContentType("text/html; charset=utf-8");
    //     response.setCharacterEncoding("utf-8");

    //     InputStream in = request.getInputStream();
    //     OutputStream out = response.getOutputStream();
    //     byte[] data = new byte[1024*8];
    //     int size;

    //     while((size=in.read(data))!=-1){
    //         System.out.println(new String(data,0,size,"utf-8"));
    //     }
    //     out.write("안녕하세요 서블릿에서 보내는 HelloWorld 입니다".getBytes("utf-8"));

    //     out.flush();
    //     out.close();
    // }


    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("image/jpeg");

        String kind = request.getParameter("kind");
        // String level = request.getParameter("level");

        FileInputStream fileIn = new FileInputStream(kind+".png");
        OutputStream out = response.getOutputStream();

        byte[] data = new byte[1024*8];
        int size;

        while((size=fileIn.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }
        fileIn.close();
        out.close();
        
    }
}

