import java.io.*;
import java.net.*;


public class Client{
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("192.168.18.1",2000);
        Socket socket2 = new Socket("192.168.18.1",1000);

        Rec r = new Rec(socket);

        r.start();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream pout = new PrintStream(socket2.getOutputStream());

        BufferedReader br2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        PrintStream pout2 = new PrintStream(br2.readLine());
        
        String message;
        String out2;
        while(!(message=br.readLine()).equals("quit")){
            pout.println(message);
            out2 = br2.readLine();
            pout2.println(out2);
        }
        pout.println(message);



    }
}