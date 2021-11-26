package by.iv;

public class Goods implements Runnable {

    // товар good со скоростью производства speed
    private String good;
    private double speed;
    private int storage;
    private boolean isActive;

    public Goods(String good, double speed) {
        this.good = good;
        this.speed = speed;
        this.storage = 0;
        isActive = true;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public synchronized int getStorage() {
        return storage;
    }                                  //  get

    public synchronized void setStorage(int storage) {
        this.storage = storage;
    }              // set

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    void disable() {
        isActive = false;
    }

    Goods() {
        isActive = true;
    }


    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        System.out.println(good + " manufacturing is started");

        while (isActive) {

            if (storage > 50) {
                try {
                    Thread.sleep((long) (speed * 5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            setStorage(getStorage() + 1);
            //  System.out.println(good + "  in storage " + this.storage);
            try {
                Thread.sleep((long) (speed));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println(good + " finished");

    }
}
