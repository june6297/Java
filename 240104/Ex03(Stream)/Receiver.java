import java.io.*;
import java.util.*;

public class Receiver{
    public static void main(String[] args)throws Exception{
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("persons"));
        HashMap persons = (HashMap)in.readObject();
        in.close();

        Set<String> keySet = persons.keySet();
        //Collection<HashMap<String,Object>> value = persons.values();

        // int a=0;
        // for(HashMap p : value){
        //     int age = (int)p.get("age");
        //     System.out.println(p.get("name")+" : "+age);
        //     a+=age;
        // }

        int a=0;
        for(String key : keySet){
            HashMap p = (HashMap)persons.get(key);    //가독성을 높이기 위해
            int age = (int)p.get("age");
            System.out.println((String)p.get("name")+" : "+age);
            a+=age;
        }

        System.out.printf("평균 나이(set) : %.2f",a/(double)persons.size());
        System.out.println();

    }
}