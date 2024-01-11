import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[]args) throws Exception{

        Socket socket = new Socket("localhost",1000);
        System.out.println("채팅을 시작합니다.");

        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));        
        ReceiverThread rt = new ReceiverThread(socket);
        rt.start();
        
        PrintStream out = new PrintStream(socket.getOutputStream());

        String message="";
        while(!(message=keyIn.readLine()).equals("quit")){
            out.println(message);
        }
        out.println(message);
        socket.close();
    }
}