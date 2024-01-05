import java.util.ArrayList;
import java.util.HashMap;

public class Ex01{
    public static void main(String[] args){
        HashMap<String,Object> person = new HashMap<>();
        ArrayList<HashMap<String,Object>> persons = new ArrayList<>();

        person.put("name", "이순신");
        person.put("address","여수시");
        person.put("age",20);
        persons.add(person);

        person=new HashMap<>();
        person.put("name","이방원");
        person.put("address","한양시");
        person.put("age",30);
        persons.add(person);

        person=new HashMap<>();
        person.put("name","이도");
        person.put("address","서울시");
        person.put("age",42);
        persons.add(person);
        
        int a=0;
        for(int i=0;i<persons.size();i++){
            System.out.println(((Integer)persons.get(i).get("age")).intValue());
            a+=(int)persons.get(i).get("age");
        }
        System.out.printf("평균 나이 : %.2f",a/(double)persons.size());
        
    }
}