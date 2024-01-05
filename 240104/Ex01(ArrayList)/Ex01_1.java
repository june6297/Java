import java.util.ArrayList;
import java.util.HashMap;

// 발생할 수 있는 오류

public class Ex01_1{
    public static void main(String args[]){
        HashMap<String,Object> person = new HashMap<>();
        ArrayList<HashMap<String,Object>> persons = new ArrayList<>();

        person.put("name", "이순신");
        person.put("address","여수시");
        person.put("age",20);
        persons.add(person);

        person.put("name","이방원");
        person.put("address","한양시");
        person.put("age",30);
        persons.add(person);


        double a = 0;
        for(int i=0;i<persons.size();i++){
            a+=(double)persons.get(i).get("age");
        }
        System.out.println(a/persons.size());
    }
}