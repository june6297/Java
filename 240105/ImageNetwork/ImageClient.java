import java.io.*;
import java.net.*;

public class ImageClient{
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("192.168.18.1",1000);

        DataInputStream fileIn = new DataInputStream(socket.getInputStream());
        FileOutputStream out = new FileOutputStream("2.png");

        byte[] data = new byte[1024*8];
        int size;

        while((size = fileIn.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }

        fileIn.close();
        out.close();
        socket.close();
    }
}