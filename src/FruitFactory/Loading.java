package FruitFactory;

import java.util.concurrent.Semaphore;

public class Loading extends Thread{
    Semaphore s10,s11;
    int box=0;
    
    public Loading (Semaphore s10,Semaphore s11)
    {
        this.s10=s10;
        this.s11=s11;
    }
    
    public void run()
    {
        while(true)
        {
            try
            { 
                    while(s10.availablePermits()==12);
                    s10.release(1);
                    box++;
                    
                    s11.acquire(1);
                    System.out.println("Box "+box+" placed, waiting forklift...");
                    synchronized(this)
                    {
                        this.notify();
                    }
                    
                        
            }catch(Exception e){}
        }
    }
    
}
