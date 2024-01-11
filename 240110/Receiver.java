import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.reflect.*;
import com.google.gson.Gson;
import com.google.gson.reflect.*;


public class Receiver{
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("localhost",1000);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        
        String jsonString = in.readLine();
        System.out.println(jsonString);
        socket.close();

        Gson gson = new Gson();
        Type type = new TypeToken<HashMap<String,HashMap<String,Object>>>(){}.getType();
        HashMap<String,HashMap<String,Object>> persons = gson.fromJson(jsonString, type);

        Collection<HashMap<String,Object>> value = persons.values();

        int a=0;
        for(HashMap<String,Object> p : value){
            int age = (int)((Double)p.get("age")).intValue();
            System.out.println(p.get("name")+" : "+age);
            a+=age;
        }

        System.out.printf("평균 나이(set) : %.2f",a/(double)persons.size());
        // System.out.println();

    }
}