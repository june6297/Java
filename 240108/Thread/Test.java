public class Test{
    public static void main(String[] args) throws Exception{
        Thread thread1 = new MyThread("Thread1",1, new MyEventListener());
        MyThread thread2 = new MyThread(11,new MyEventListener());
        MyThread thread3 = new MyThread("Thread3",new MyEventListener());
        MyThread thread4 = new MyThread(new MyEventListener());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
    }
}

class MyEventListener implements MyEvent{                           //타입을 MYEvent로 설정하기위해 Interface가져옴 
    public void half(String name){                                //절반이 실행된 객체를 알기 위해 String name을 추가
        System.out.println(name+"이 절반이 실행되었습니다.");           //동기화가 하고싶다면 void 앞에 synchronized를 붙여보자
    }
    public void complete(String name){
        System.out.println(name+"이 완료되었습니다.");
    }
}
