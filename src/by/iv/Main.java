package by.iv;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread mThread = Thread.currentThread();
        System.out.println(mThread.getName());

        /*
        Thread 15 45 23 16
        System.out 25 18 20
        currentThread 6 8 2
        25  Pi 48
        Runnable 6 8 2
        23 6 7 2 8

        wait 16 notify 32 17
        synchronized 22 37 15
        run 13 22 98
        start 15 73 9 7 2 8
        */

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


       /* System.out.println("Main thread started");
        CustomerThread customerThread = new CustomerThread();
        new Thread(customerThread, "CustomerThread").start();
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName());
        customerThread.disable();
        Thread.sleep(1000);
        System.out.println("Main thread finished");*/

        // создаем товар
        Goods goods1 = new Goods("g1",250);
        Goods goods2 = new Goods("g2",270);
        Goods goods3 = new Goods("g3",280);
        Goods goods4 = new Goods("g4",200);

        new Thread(goods1,"Good #1").start();
        new Thread(goods2,"Good #2").start();
        new Thread(goods3,"Good #3").start();
        new Thread(goods4,"Good #4").start();

        Storage storage=new Storage(goods1,goods2,goods3,goods4);
        new Thread(storage,"Storage").start();

        Basket basket=new Basket(goods1,goods2,goods3,goods4);
        Thread basketThread=new  Thread(basket,"Basket");
             basketThread.start();

        try {
            Thread.sleep((long)(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basket.disable();
      //  basketThread.join();
        goods1.disable();
        goods2.disable();
        goods3.disable();
        goods4.disable();

        storage.disable();




















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
