import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args)throws Exception{
        URL url = new URL("http://192.168.18.1/attach/SendImage");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/octet-stream");
        
        
        OutputStream out = conn.getOutputStream();
        FileInputStream in = new FileInputStream("C.png");

        byte[] data = new byte[1024*8];
        int size;

        while((size = in.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }
        in.close();
        InputStream in2 = conn.getInputStream();
        while((size=in2.read(data))!=-1){
            System.out.println(new String(data, 0, size,"utf-8"));
        }
        
        // URL url = new URL("http://192.168.18.1/attach/SendJSON");
        // HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        // conn.setDoInput(true);
        // conn.setDoOutput(true);
        // conn.setRequestMethod("POST");
        // conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        
        // OutputStream out = conn.getOutputStream();                      //Post로 했기 때문에 OutputStream이 필요
        // String jsonString = "{\"name\":\"이방원\",\"address\":\"여수시\",\"age\":20}";
        // out.write(jsonString.getBytes("utf-8"));
        // out.flush();
        
        // InputStream in = conn.getInputStream();
        // byte[] data = new byte[1024*8];
        // int size;

        // while((size=in.read(data))!=-1){
        //     System.out.println(new String(data, 0, size,"utf-8"));
        // }
    }
}