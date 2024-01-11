import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args)throws Exception{

        FileReceiverThread fileThread = new FileReceiverThread();
        fileThread.start();

        Socket socket = new Socket("localhost",1000);
        System.out.println("채팅을 시작함");

        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());

        String message="";
        while(!(message=keyIn.readLine()).equals("quit")){
            out.println(message);
            System.out.println(in.readLine());
        }

        out.println(message);
        socket.close();

    }
}