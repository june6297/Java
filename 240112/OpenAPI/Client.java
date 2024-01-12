import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args)throws Exception{
        String queryString="?confmKey=devU01TX0FVVEgyMDI0MDExMjE2NTAwMjExNDQyNjY="+
        "&currentPage=1"+
        "&countPerPage=10"+
        "&keyword="+URLEncoder.encode("인제로", "utf-8")+
        "&resultType=json";
        URL url = new URL("https://business.juso.go.kr/addrlink/addrLinkApi.do"+queryString);

        InputStream in = url.openStream();
        byte[] data = new byte[1024*8];
        int size;

        while((size=in.read(data))!=-1){
            System.out.println(new String(data,0,size,"utf-8"));
        }
    }
}