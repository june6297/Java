import java.net.*;
import java.io.*;

public class Server{
    public static void main(String[]args)throws Exception{

        ServerSocket fileServerSocket = new ServerSocket(2000);
        ServerSocket chatServerSocket = new ServerSocket(1000);
        
        while(true){
            Socket fileSocket = fileServerSocket.accept();
            Socket chatSocket = chatServerSocket.accept();

            System.out.println(chatSocket.getInetAddress().toString()+"가 접속함");

            FileTransferThread fileThread = new FileTransferThread(fileSocket);
            ChatThread chatThread = new ChatThread(chatSocket);

            fileThread.start();
            chatThread.start();

        }
        
    }
}