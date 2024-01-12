import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/Multipart")
@MultipartConfig            // 중요!! 이게 없으면 밑에 내용들을 읽을 수 없음
public class ServiceServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=utf-8");

        String path = request.getServletContext().getRealPath("/")+"images/";
        String log = request.getServletContext().getRealPath("/")+"logs/";
        String message = "파일전송 실패";

        Collection<Part> parts = request.getParts();        // 배열로 옴
        for(Part part : parts){                             // 요런 형식의 반복문을 사용하도록 해보자
            System.out.println("part name = "+part.getName()+"=>"+getString(part.getInputStream()));
            if(part.getName().equals("file1")){
                FileOutputStream fileOut = new FileOutputStream(path+UUID.randomUUID().toString()+".jpg");
                InputStream in = part.getInputStream();
                byte[] data = new byte[1024*8];
                int size;

                while((size=in.read(data))!=-1){
                    fileOut.write(data,0,size);
                    fileOut.flush();
                }

                fileOut.close();
                message="파일전송 성공";
            }
            FileOutputStream fileOut = new FileOutputStream(log+"log.txt",true);

            InputStream in = part.getInputStream();
            byte[] data = new byte[1024*8];
                int size;

                while((size=in.read(data))!=-1){
                    fileOut.write(data,0,size);
                    fileOut.flush();
                }
                fileOut.close();
        }
        


        OutputStream out = response.getOutputStream();
        out.write(message.getBytes("utf-8"));
        out.close();
    }
    private String getString(InputStream in){
        byte[] data = new byte[1024*8];
        int size;
        StringBuilder strBuilder = new StringBuilder();

        try{
            while((size=in.read(data))!=-1){
                strBuilder.append(new String(data,0,size,"utf-8"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return strBuilder.toString();
    }
}