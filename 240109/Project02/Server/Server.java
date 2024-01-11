import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
    public static void main(String[] args)throws Exception{
        ServerSocket chatServerSocket = new ServerSocket(1000);
        ArrayList<PrintStream> clientList = new ArrayList<>();

        while(true){
            Socket chatSocket = chatServerSocket.accept();

            //System.out.println(logSocket.getInetAddress().toString()+"가 접속함");
            ChatThread chatThread = new ChatThread(chatSocket,clientList);
            chatThread.start();


        }
    }
}