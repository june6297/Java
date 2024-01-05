import java.io.*;
import java.net.*;

public class ImageServer{
    public static void main(String[] args)throws Exception{
        ServerSocket serverSocket = new ServerSocket(1000);
        Socket socket = serverSocket.accept(); 

        FileInputStream fileIn = new FileInputStream("1.png");
        PrintStream out = new PrintStream(socket.getOutputStream());


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