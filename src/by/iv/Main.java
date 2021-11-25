package by.iv;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread mThread = Thread.currentThread();
        System.out.println(mThread.getName());

//        Runnable child1= () -> {
//            for (int i = 0; i <100 ; i++) {
//                System.out.println("i'm a child");
//                }
//            };
//        for (int i = 0; i <5 ; i++) {
//            child1.run();
//        }
//
//
//
//
//        System.out.println("i'am parent");
//        System.out.println("-------next one--------");
//
//        for (int i = 0; i <5 ; i++) {
//            Egg egg1=new Egg(i);
//            egg1.start();
//        }
//        Hen hen1=new Hen(1);
//        hen1.start();
//        hen1.join();


        System.out.println("Main thread started");
        CustomerThread customerThread = new CustomerThread();
        new Thread(customerThread, "CustomerThread").start();
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName());
        customerThread.disable();
        Thread.sleep(1000);
        System.out.println("Main thread finished");







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

class CustomerThread implements Runnable {
    private boolean isActive;

    void disable() {
        isActive = false;
    }

    CustomerThread() {
        isActive = true;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        int iteration = 1;
        while (isActive) {
            iteration++;
            System.out.println("Customer thread is working " + iteration);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " finished");
    }
}
