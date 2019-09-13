public class UIServiceFossil {
    public void sleepIn(int sleepIn) {
        try {
            Thread.sleep(sleepIn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
