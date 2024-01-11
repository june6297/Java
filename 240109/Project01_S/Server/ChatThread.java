import java.net.*;
import java.io.*;

public class ChatThread extends Thread{
    private Socket socket;

    public ChatThread(Socket socket){
        this.socket = socket;
        System.out.println("채팅 스레드가 실행됨"+socket.getInetAddress().toString());
    }
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());

            String message="";
            while(!(message=in.readLine()).equals("quit")){
                out.println(message +" from Server");
            }
            socket.close();        
            System.out.println(socket.getInetAddress().toString()+"가 나감");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}