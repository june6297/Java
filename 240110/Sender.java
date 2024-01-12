import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.Gson;

public class Sender{
    public static void main(String[] args)throws Exception{

        HashMap<String,Object> person = new HashMap<>();
        HashMap<String,HashMap<String,Object>> persons = new HashMap<>();
        
        person.put("name","이순신");
        person.put("address","여수시");
        person.put("age",20);
        persons.put((String)person.get("name"),person);

        person = new HashMap<>();
        person.put("name","이방원");
        person.put("address","한양시");
        person.put("age",30);
        persons.put((String)person.get("name"),person);

        person = new HashMap<>();
        person.put("name","이도");
        person.put("address","서울시");
        person.put("age",42);
        persons.put((String)person.get("name"),person);

        Gson gson = new Gson();
        String jsonString = gson.toJson(persons);
        // System.out.println(jsonString);


        ServerSocket serverSocket = new ServerSocket(1000);
        Socket socket = serverSocket.accept();  
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println(jsonString);
        // out.writeObject(persons);
        // out.close();
    }
}