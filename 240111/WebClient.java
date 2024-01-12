import java.io.*;
import java.net.*;

public class WebClient{
    public static void main(String[] args)throws Exception{
        URL url = new URL("http://192.168.18.1/attach/GetImage?kind=1");
        InputStream in = url.openStream();

        byte[] data = new byte[1024*8];
        int size;

        while((size=in.read(data))!=-1){
            System.out.println(new String(data,0,size,"utf-8"));
        }

    }
}