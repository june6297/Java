import java.io.*;
import java.net.*;

public class ReceiverThread extends Thread{
    private Socket socket;

    public ReceiverThread(Socket socket){
        this.socket=socket;
        System.out.println(socket.getInetAddress().toString()+" 가 접속함");
    }

    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                System.out.println(in.readLine());
            }

            // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // PrintStream out = new PrintStream(System.out);

            // String message="";
            // while(!(message=in.readLine()).equals("quit")){
            //     out.println(message);
            // }
            
            // System.out.println(socket.getInetAddress().toString()+"가 나감");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}