import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("192.168.54.71",2000);

        DataInputStream fileIn = new DataInputStream(socket.getInputStream());
        FileOutputStream out = new FileOutputStream("2.zip");

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