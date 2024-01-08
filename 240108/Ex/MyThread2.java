public class MyThread2 extends Thread{
    private String name;
    private int start;

    public MyThread2(String name, int start){
        this.name = name;
        this.start = start;
    }

    public void run(){
        try{
            for(int i=this.start;i<=this.start+10;i++){
                System.out.println(this.name+"에서 출력합니다."+i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}