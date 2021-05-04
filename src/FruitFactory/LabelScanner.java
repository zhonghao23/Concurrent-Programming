package FruitFactory;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class LabelScanner extends Thread{
   
    Semaphore s8,s9;
    int num=0;
    public static boolean RandomBoolean() {
        return Math.random() < 0.01;
    }
    
    public LabelScanner (Semaphore s8,Semaphore s9)
    {
        this.s8=s8;
        this.s9=s9;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                while(s8.availablePermits()>0);
                //Thread.sleep(new Random().nextInt(2)*100);
                s8.release(1);
                num++;
                System.out.println("Label scanned: "+num);
                
                if(RandomBoolean()==true)
                {
                    System.err.println("Can "+num+" sealed wrongly and removed.");     
                }
                else
                {
                    s9.acquire(1);
                    System.out.println("Approved can "+num+" proceed to packing..."); 
                }                
            }catch(Exception e){}
        }
    }
}
