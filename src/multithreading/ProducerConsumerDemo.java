package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public final class ProducerConsumerDemo {
    public static void main(String[] args) {
        ProducerConsumerDemo producerConsumerDemo = new ProducerConsumerDemo();
        int maxSize = 10;
        Queue<Integer> queue = new LinkedList<>();
        queue = new LinkedList<>();
        ProducerThread producerThread = new ProducerThread(queue, maxSize);
        ConsumerThread consumerThread = new ConsumerThread(queue,maxSize);
        producerThread.start();
        consumerThread.start();
    }
}
