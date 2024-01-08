public class Thread1 extends Thread{
    public void run(){
        try{
            for(int i=1;i<=10;i++){
                System.out.println("Thread1에서 출력합니다 =>"+i);
                sleep(200);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}