package ProducerConsumerProblem.blockingQueu;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable
{
    protected BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    public void run()
    {
        try
        {
            while (true)
            {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Produced resource - Queue size now = "  + queue.size());
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("Producer INTERRUPTED");
        }
    }

    Object getResource()
    {
        try
        {
            Thread.sleep(100); // simulate time passing during read
        }
        catch (InterruptedException ex)
        {
            System.out.println("Producer Read INTERRUPTED");
        }
        return new Object();
    }
}
