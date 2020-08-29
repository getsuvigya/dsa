package multithreading;

import java.util.Queue;
import java.util.Random;

public class ProducerThread extends Thread {
    private Queue<Integer> q;
    private int maxSize;
    public ProducerThread(Queue queue, int maxSize){
        this.q = queue;
        this.maxSize = maxSize;
    }
    public void run(){
        while(true){
            synchronized (q){
                while (q.size()==maxSize){
                    try {
                        System.out.println("Queue is full. Waiting for element to be removed");
                        q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int range = 50000;
                int next = random.nextInt(range)+0;
                System.out.println("Adding element "+next);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                q.add(next);
                q.notify();

            }
        }
    }
}
