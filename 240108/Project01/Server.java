import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.*;

public class Server{
    public static void main(String[]args)throws Exception{
        ServerSocket serverSocket = new ServerSocket(2000);
        ServerSocket serverSocket2 = new ServerSocket(1000);

        BufferedReader br = new BufferedReader(socket.getInputStream);
        PrintStream out = new PrintStream(System.in);

        PrintStream out2 = new PrintStream(socket.getOutputStream);

        while(true){
            Socket socket = serverSocket.accept();
            FileTransferThread thread = new FileTransferThread(socket);
            thread.start();
        }
        
        String message;
        while(!(message=br.readLine()).equals("quit")){
                out.println(message);
                out2.println(message + " : From Server");
        }
        
    }
}