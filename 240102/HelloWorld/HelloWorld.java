import java.io.*;

public class HelloWorld{
    public static void main(String[] args)throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        String data = in.readLine();
        byte [] byteData = data.getBytes("utf-8");

        PrintStream out = new PrintStream(System.out);
        //PrintStream out2 = new PrintStream("test3.txt");
        out.write(byteData);
        //out2.println(data);
    }
}