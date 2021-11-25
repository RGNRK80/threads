package by.iv;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread mThread = Thread.currentThread();
        System.out.println(mThread.getName());

        Runnable child1= () -> {
            for (int i = 0; i <100 ; i++) {
                System.out.println("i'm a child");
                }
            };
        for (int i = 0; i <5 ; i++) {
            child1.run();
        }




        System.out.println("i'am parent");
        System.out.println("-------next one--------");

        for (int i = 0; i <5 ; i++) {
            Egg egg1=new Egg(i);
            egg1.start();
        }
        Hen hen1=new Hen(1);
        hen1.start();
        hen1.join();








    } //psvm
} //main

class Hen extends Thread{
    int id;
    public Hen(int id) {
         this.id = id;
    }
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("Hen thread: " + id + " is running-" + i);}
    }
}

class Egg extends Thread{
    int id;
    public Egg(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("Egg thread: " + id + " is running-" + i);}
    }
}
