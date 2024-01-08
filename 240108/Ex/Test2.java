public class Test2{
    public static void main(String[] args) throws Exception{
        MyThread2 thread1 = new MyThread2("thread1",20);

        thread1.start();
    }
}

class MyEventListener{
    public void half(){
        System.out.println("절반이 완료되었습니다.");
    }
}