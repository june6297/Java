import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args)throws Exception,IOException{
        Socket socket = new Socket("192.168.18.1",1000);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(socket.getOutputStream());

        BufferedReader inn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream outt = new PrintStream(System.out);

        // String message = in.readLine();
        // out.println(message);

        String message;
        String out2;
        while(!(message=in.readLine()).equals("quit")){
            out.println(message);
            out2 = inn.readLine();
            outt.println(out2);
            //out2 = inn.readLine();
            //outt.println(message);
        }
        out.println(message);




        socket.close();
    }
}