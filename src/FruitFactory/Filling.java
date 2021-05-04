package FruitFactory;

import java.util.concurrent.Semaphore;

public class Filling extends Thread{
    Semaphore s3,s4;
    int num=0;
    
    public Filling (Semaphore s3,Semaphore s4)
    {
        this.s3=s3;
        this.s4=s4;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                while(s3.availablePermits()>0);
                s3.release(1);
                System.err.println("\filling "+num+" s4 before: "+s4.availablePermits());
                num++;
                System.out.println("Filled: "+num);
                while(s4.availablePermits()==0);
                s4.acquire(1);   
                System.err.println("\filling "+num+" s4 after: "+s4.availablePermits());
            }catch(Exception e){}
        }
    }
}
