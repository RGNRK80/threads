package by.iv;

public class Storage implements Runnable {
    Goods goods1;
    Goods goods2;
    Goods goods3;
    Goods goods4;
    private boolean isActive;

    public Storage(Goods goods1, Goods goods2, Goods goods3, Goods goods4) {
        this.goods1 = goods1;
        this.goods2 = goods2;
        this.goods3 = goods3;
        this.goods4 = goods4;
        isActive = true;
    }

    void disable() {
        isActive = false;
    }


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started!!");
        System.out.println(" storage is working");

        while (isActive) {
            System.out.println();
            System.out.print("Storage: ");
            System.out.print(goods1.getGood() + ": " + goods1.getStorage() + " units.");
            System.out.print(goods2.getGood() + ": " + goods2.getStorage() + " units.");
            System.out.print(goods2.getGood() + ": " + goods3.getStorage() + " units.");
            System.out.print(goods2.getGood() + ": " + goods4.getStorage() + " units.");

            try {
                Thread.sleep((long) (1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("storage is closed");
        System.out.println("leftovers in the warehouse:");
        System.out.print(goods1.getGood() + ": " + goods1.getStorage() + " units.");
        System.out.print(goods2.getGood() + ": " + goods2.getStorage() + " units.");
        System.out.print(goods2.getGood() + ": " + goods3.getStorage() + " units.");
        System.out.print(goods2.getGood() + ": " + goods4.getStorage() + " units.");

    }
}
