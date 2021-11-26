package by.iv;

public class Basket implements Runnable{
    int byGood1;
    int byGood2;
    int byGood3;
    int byGood4;
    Goods goods1;
    Goods goods2;
    Goods goods3;
    Goods goods4;
    private boolean isActive;

    public Basket(Goods goods1, Goods goods2, Goods goods3, Goods goods4) {

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
        System.out.println(" Buyer has begin to buy");



        while (isActive) {
            byGood1=(int)(Math.random()*2);
            byGood2=(int)(Math.random()*2);
            byGood3=(int)(Math.random()*2);
            byGood4=(int)(Math.random()*2);

            System.out.println();
            System.out.print("            Wanna buy :");
            System.out.print(goods1.getGood() + ": " + byGood1 + " units." );
            System.out.print(goods2.getGood() + ": " + byGood2 + " units." );
            System.out.print(goods3.getGood() + ": " + byGood3 + " units." );
            System.out.print(goods4.getGood() + ": " + byGood4 + " units." );
            boolean check = byGood1>goods1.getStorage() || byGood2>goods2.getStorage() || byGood3>goods3.getStorage() ||
                    byGood4>goods4.getStorage();

            if (check ) {

                try {
                    Thread.sleep((long) (100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {

            goods1.setStorage(goods1.getStorage()-byGood1);
            goods2.setStorage(goods2.getStorage()-byGood2);
            goods3.setStorage(goods3.getStorage()-byGood3);
            goods4.setStorage(goods4.getStorage()-byGood4);
            }

            try {
                Thread.sleep((long) (100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Buyer has go home");


    }


}
