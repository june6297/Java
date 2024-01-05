import java.io.*;
import java.util.*;

public class Ex02{
    public static void main(String[] args){
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

        Set<String> keySet = persons.keySet();
        //String[] keys = keySet.toArray(new String[0]); // (new String[0])는 타입을 적은 것 만약 int라면 (new int[0])

        //System.out.println(keys[0]); // 키 값은 순서가 중요하지 않다.

        System.out.println("Set 이용(Key 값)");

        int a=0;
        for(String key : keySet){
            HashMap p = persons.get(key);    //가독성을 높이기 위해
            int age = (int)p.get("age");
            System.out.println((String)p.get("name")+" : "+age);
            a+=age;
        }
        System.out.printf("평균 나이(set) : %.2f",a/(double)persons.size());
        System.out.println();

        // int a=0;
        // for(int i=0;i<persons.size();i++){
        //     HashMap p = persons.get(keys[i]);    //가독성을 높이기 위해
        //     int age = (int)p.get("age");
        //     System.out.println((String)p.get("name")+" : "+age);
        //     a+=age;
        //     //System.out.println((String)persons.get(keys[i]).get("name")+" : "+(int)persons.get(keys[i]).get("age"));
        // }
        // System.out.printf("평균 나이(set) : %.2f",a/(double)persons.size());
        // System.out.println();

        

        System.out.println("=============================================================================");

        System.out.println("Collection 이용(Value 값)");

        Collection<HashMap<String,Object>> c = persons.values();
        HashMap[] cs = c.toArray(new HashMap[0]);
        
        int b=0;
        for(HashMap p : c){
            b+=(int)p.get("age");
            int age2= (int)p.get("age");
            System.out.println((String)p.get("name")+" : "+age2);
        }
        System.out.printf("평균 나이 : %.2f",b/(double)persons.size());


        //System.out.println(c);
        //System.out.println(cs.length);

        // int b=0;
        // for(int i=0;i<cs.length;i++){
        //     b+=(int)cs[i].get("age");
        //     System.out.println((String)cs[i].get("name")+" : "+(int)cs[i].get("age"));
        // }
        // System.out.printf("평균 나이 : %.2f",b/(double)persons.size());

    }
}