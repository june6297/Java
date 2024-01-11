import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[]args)throws Exception{
        ServerSocket serverSocket = new ServerSocket(2000);
        ServerSocket serverSocket2 = new ServerSocket(1000);

        while(true){
            Socket socket = serverSocket.accept();
            FileTransferThread thread = new FileTransferThread(socket);
            thread.start();

            
        }
        
            Socket socket2 = serverSocket2.accept();
            TextThread textThread = new TextThread(socket2);
            textThread.start();
        


        // Socket socket2 = serverSocket2.accept();
        // BufferedReader in = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        // PrintStream out = new PrintStream(System.out);
        // PrintStream out2 = new PrintStream(socket2.getOutputStream());

        // String message;
        // while(!(message= in.readLine()).equals("quit")){
        //     out.println(message);
        //     out2.println(message+" : From Server");
        // }


        
    }
}