package multithreading;

import java.util.Queue;

public class ConsumerThread extends Thread {
    private int maxSize;
    private Queue<Integer> q;
    public ConsumerThread(Queue<Integer> q, int size){
        this.maxSize = size;
        this.q = q;
    }

    public void run(){
        while(true){
            synchronized (q){
                while (q.isEmpty()){
                    System.out.println("Queue is empty");
                    try {
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Removing element "+q.remove());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                q.notify();
            }
        }
    }
}
