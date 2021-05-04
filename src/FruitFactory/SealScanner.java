package FruitFactory;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SealScanner extends Thread{
   
    Semaphore s6,s7;
    int num=0,cannum=0;
    public static boolean RandomBoolean() {
        return Math.random() < 0.01;
    }
    
    public SealScanner (Semaphore s6,Semaphore s7)
    {
        this.s6=s6;
        this.s7=s7;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                while(s6.availablePermits()>0);
                //Thread.sleep(new Random().nextInt(2)*100);
                s6.release(1);
                num++;
                cannum++;
                System.out.println("Sealing scanned: "+num);
                
                if(RandomBoolean()==true)
                {
                    System.err.println("Can "+cannum+" sealed wrongly and removed.");     
                }
                else
                {
                    s7.acquire(1);
                    System.out.println("Can "+cannum+" proceed to labelling..."); 
                }                
            }catch(Exception e){}
        }
    }
}
