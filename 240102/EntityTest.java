import java.util.HashMap;
import java.io.*;

public class EntityTest{
    public static void main(String[] args) throws Exception{

        Person person = new Person();
        Person person2 = new Person();

        person.name = "Choi";
        person.tel = "01012345678";
        person.address = "masan";
        person.birth = "001109";
        
        HashMap<String, String> person3 = new HashMap<>();
        person3.put("name","Lee");
        person3.put("tel","01000000000");
        person3.put("adress","busan");
        person3.put("birth","010101");

        //PrintStream out = new PrintStream("object.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.txt"));
        out.writeObject(person);
        out.close();
        
        ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream("object.txt"));
        Person p = (Person)fileIn.readObject();
        System.out.println(p.name);

        fileIn.close();
        

        //System.out.println(person.name);
        //System.out.println(person3.get("name"));


    }
}