public class Talkative implements Runnable {
    private int value;

    //constructors
    public Talkative(int value) {
        this.value = value;
    }
    // getters and setters
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    // implementing run
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Value: " + value);
        }
    }

}
