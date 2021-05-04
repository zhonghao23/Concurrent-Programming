package FruitFactory;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class FillScanner extends Thread{
   
    Semaphore s4,s5;
    int num=0;
    public static boolean RandomBoolean() {
        return Math.random() < 0.01;
    }
    
    public FillScanner (Semaphore s4,Semaphore s5)
    {
        this.s4=s4;
        this.s5=s5;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                while(s4.availablePermits()>0);
                System.err.println("\nfillsscanner "+num+" s4 before: "+s4.availablePermits());
                //Thread.sleep(new Random().nextInt(2)*100);
                s4.release(1);
                System.err.println("\nfillsscanner "+num+" s4 after: "+s4.availablePermits());
                num++;
                System.out.println("Fill Scanned: "+num);
                if(RandomBoolean()==true)
                {
                    System.err.println("Can "+num+" filled wrongly and removed.");     
                }
                else
                {
                    //while(s5.availablePermits()==0);
                    s5.acquire(1);                     
                    System.out.println("Can "+num+" proceed to sealing..."); 
                }                              
            }catch(Exception e){}
        }
    }
}
