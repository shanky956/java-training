package pkg;

public class MultiplicationTask implements Runnable {
    private int number;
    private String threadName;

    public MultiplicationTask(int number, String threadName) {
        this.number = number;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " started.");
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + ": " + number + " * " + i + " = " + (number * i));
            // Adding delays
            try {
                Thread.sleep(500); // 500 miliseconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " completed.");
    }
}