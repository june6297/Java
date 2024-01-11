import java.io.*;
import java.net.*;

public class TextThread extends Thread{
    private Socket socket;

    public TextThread(Socket socket){
        this.socket = socket;
    }


    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(System.out);
            PrintStream out2 = new PrintStream(socket.getOutputStream());
        

            String message;
            while(!(message= in.readLine()).equals("quit")){
                out.println(message);
                out2.println(message+" : From Server");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}