import java.io.*;
import java.net.*;
 
public class WebClient{
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("192.168.18.1",80);
        
        PrintStream out = new PrintStream(socket.getOutputStream());  // 열기 전에 보내야 하니깐
        out.println("GET /hello/HelloWorld HTTP/1.1");
        out.println("host: 192.168.18.1");
        out.println("Connection: close");
        
        out.println();
 
        InputStream in = socket.getInputStream();
 
        // FileOutputStream fileOut = new FileOutputStream("google.html");
 
 
        byte[] data = new byte[1024*8];
        int size;
 
        while((size=in.read(data))!=-1){
            System.out.println(new String(data,0,size,"utf-8"));
            // fileOut.write(data,0,size);
            // fileOut.flush();
        }
        // fileOut.close();
    }
}