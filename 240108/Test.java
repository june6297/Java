import java.io.IOException;

public class Test{
    public static void main(String[] args) throws Exception{
        for(int i=1;i<=10;i++){
            System.out.println("블럭 1에서 실행되는 코드 =>"+i);
            Thread.sleep(500);
        }

        for(int i=11;i<=20;i++){
            System.out.println("블럭 2에서 실행되는 코드 =>"+i);
            Thread.sleep(400);
        }  
        for(int i=21;i<=30;i++){
            System.out.println("블럭 3에서 실행되는 코드 =>"+i);
            Thread.sleep(300);
        }
    }
}