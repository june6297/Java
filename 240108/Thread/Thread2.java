public class Thread2 extends Thread{
    public void run(){
        try{
            for(int i=11;i<=20;i++){
                System.out.println("Thread2에서 출력합니다 =>"+i);
                sleep(200);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}