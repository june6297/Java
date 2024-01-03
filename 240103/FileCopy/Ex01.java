import java.io.*;
public class Ex01{
    public static void main(String[] args)throws Exception{
        
        DataInputStream fileIn = new DataInputStream(new FileInputStream("1.png"));
        DataOutputStream out =  new DataOutputStream(new FileOutputStream("2.png"));
        
        //FileInputStream fileIn = new FileInputStream("1.png");
        //FileOutputStream out = new FileOutputStream("2.png");

        //FileInputStream fileIn = new FileInputStream("1.png");
        //PrintStream out = new PrintStream("2.png");

        byte[] data = new byte[1024*8];
        int size;

        while((size = fileIn.read(data))!=-1){
            out.write(data,0,size);
            out.flush();
        }
        
        fileIn.close();
        out.close();
    }
}