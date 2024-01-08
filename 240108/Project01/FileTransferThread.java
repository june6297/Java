import java.net.*;
import java.io.*;

public class FileTransferThread extends Thread{
    private Socket socket;

    public FileTransferThread(Socket socket){
        this.socket=socket;
        System.out.println(socket.getInetAddress().toString()+"다운로드 시작");
    }

    public void run(){
        try{
            FileInputStream file = new FileInputStream("source.exe");
            OutputStream out = socket.getOutputStream();

            byte[] data = new byte[1024*8];
            int size;

            while((size=file.read(data))!=-1){
                out.write(data, 0, size);
                out.flush();
            }
            a++;
            file.close();
            socket.close();
            System.out.println(socket.getInetAddress().toString()+"다운로드 완료");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}