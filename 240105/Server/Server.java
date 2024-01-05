import java.net.*;
import java.io.*;

public class Server{
    public static void main(String[] args) throws Exception,IOException{
        ServerSocket serverSocket = new ServerSocket(1000);    //포트번호가 꼭 필요함
        Socket socket = serverSocket.accept();                      // Client의 요청을 대기하는 상태

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));     //어디에서 읽어오는지만 선택하면 됨
        PrintStream out = new PrintStream(System.out);

        //BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
        PrintStream outt = new PrintStream(socket.getOutputStream());

        String message;
        String out2;
        while(!(message=in.readLine()).equals("quit")){
            out.println(message);
            outt.println(message + " : From Server");
            //outt.println();

            //out2 = in.readLine();
            //outt.println(out2 + ": From Server");
        }




        socket.close();

    }
}