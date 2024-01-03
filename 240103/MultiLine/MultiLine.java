import java.io.*;

public class MultiLine{
    public static void main(String[] args)throws Exception,IOException{
        
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(new File("Ex02.txt"));
        PrintStream out2 = new PrintStream(System.out);

        //int a=0;
        String data="";
        while(!(data=keyIn.readLine()).equals("quit")){
            out2.println(data);
            out.println(data);
        //    a++;
        }

        out.close();
        System.out.println("----------------------------");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Ex02.txt")));

        while((data=br.readLine())!=null){
            out2.println(data);
        }

        //for(int i=0;i<a;i++){
        //    String b = br.readLine();
        //    out2.println(b);
        //}
        
        
        //FileInputStream fileIn = new FileInputStream("Ex02.txt");

        //byte[] data2 = new byte[1024*8];
        //int size;

        //while((size = fileIn.read(data2))!= -1){
        //    out2.write(data2,0,size);
        //    out2.flush();
        //}
        
        //fileIn.close();

        out.close();
        out2.close();
    }
}