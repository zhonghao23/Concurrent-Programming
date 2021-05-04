package FruitFactory;

import java.util.concurrent.Semaphore;

public class Sealing extends Thread{
    Semaphore s5,s6;
    int num=0,i=0;
    
    public Sealing (Semaphore s5,Semaphore s6)
    {
        this.s5=s5;
        this.s6=s6;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                while(s5.availablePermits()>0);
                s5.release(12);
                num+=12;
                System.out.println("Sealed: "+num);
                
               for(i=0;i<12;i++) {
                   //while(s6.availablePermits()==0);
                   s6.acquire(1);      
               }
                
            }catch(Exception e){}
        }
    }
}
