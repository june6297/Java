public class MyThread extends Thread{
    private String name;
    private int start;
    private MyEvent listener;                   // EventListener를 호출하기 위해 선언
                                                // 모든 경우에서 호출
    public MyThread(MyEvent listener){
        this.name = "default";
        this.start = 100;
        this.listener = listener;
    }

    public MyThread(String name,MyEvent listener){
        this.name=name;
        this.start = 100;
        this.listener = listener;
    }

    public MyThread(int start,MyEvent listener){
        this.name="default";
        this.start = start;
        this.listener = listener;
    }

    public MyThread(String name, int start, MyEvent listener){
        this.name=name;
        this.start=start;
        this.listener = listener;
    }

    public void run(){
        try{
            for(int i=this.start;i<this.start+10;i++){
                System.out.println(this.name+"에서 출력합니다."+i);
                sleep(200);
                if(i==this.start+4){
                    this.listener.half(this.name);
                }
            }
            this.listener.complete(this.name);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}