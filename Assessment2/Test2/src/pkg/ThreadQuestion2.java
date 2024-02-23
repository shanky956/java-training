package pkg;

public class ThreadQuestion2 {
	
	static int CONST = 6;
	
	public static void main(String args[]) throws InterruptedException {
		  // Create runnable objects for each task
        Runnable task1 = new MultiplicationTask(2, "SlowThread");
        Runnable task2 = new MultiplicationTask(3, "MediumThread");
        Runnable task3 = new MultiplicationTask(4, "FastThread");

        // Create threads for each task
        Thread slowThread = new Thread(task1);
        Thread mediumThread = new Thread(task2);
        Thread fastThread = new Thread(task3);
        
        // Set priorities
        slowThread.setPriority(Thread.MIN_PRIORITY); // Low priority
        mediumThread.setPriority(Thread.NORM_PRIORITY); // Medium priority
        fastThread.setPriority(Thread.MAX_PRIORITY); // High priority

        // Start threads
        slowThread.start();
        mediumThread.start();
        fastThread.start();

        try {
            // Wait for threads to finish
            slowThread.join();
            mediumThread.join();
            fastThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed.");
		
	}

}
