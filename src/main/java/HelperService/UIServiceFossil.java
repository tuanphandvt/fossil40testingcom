package HelperService;

public class UIServiceFossil {
    public void sleepIn(int sleepIn) {
        try {
            Thread.sleep(sleepIn*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
