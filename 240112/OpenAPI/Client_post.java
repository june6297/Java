import java.net.*;
import java.io.*;

public class Client_post{
    public static void main(String[] args)throws Exception{
        String queryString="?confmKey=devU01TX0FVVEgyMDI0MDExMjE2NTAwMjExNDQyNjY="+
        "&currentPage=1"+
        "&countPerPage=10"+
        "&keyword="+URLEncoder.encode("인제로", "utf-8")+
        // "&keyword=인제로"+
        "&resultType=json";
        URL url = new URL("https://business.juso.go.kr/addrlink/addrLinkApi.do");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

        OutputStream out = conn.getOutputStream();
        out.write(queryString.getBytes("utf-8"));
        out.flush();

        InputStream in = conn.getInputStream();
        byte[] data = new byte[1024*8];
        int size;

        while((size=in.read(data))!=-1){
            System.out.println(new String(data,0,size,"utf-8"));
        }
    }
}