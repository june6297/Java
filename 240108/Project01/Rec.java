import java.io.*;
import java.net.*;

public class Rec extends Thread{
    private Socket socket;

    public Rec(Socket socket){
        this.socket = socket;
        System.out.println("다운로드 시작");
    }
    
    public void run(){
        try{
            DataInputStream fileIn = new DataInputStream(2000);
            FileOutputStream out = new FileOutputStream("2.exe");

            byte[] data = new byte[1024*8];
            int size;

            while((size = fileIn.read(data))!=-1){
                out.write(data,0,size);
                out.flush();
            }
            System.out.println("다운로드 완료");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}