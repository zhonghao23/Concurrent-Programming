package FruitFactory;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DentScanner extends Thread{
    Entry e;
    Semaphore s1,s2;
    int num=0;
    public static boolean RandomBoolean() {
        return Math.random() < 0.01;
    }
    
    public DentScanner (Entry e,Semaphore s1,Semaphore s2)
    {
        this.e=e;
        this.s1=s1;
        this.s2=s2;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {   
                synchronized(e){
                e.wait();}
                //while(s1.availablePermits()>0);
                //Thread.sleep(new Random().nextInt(2)*200);
                //s1.release(1);
                num++;
                System.out.println("Dent scanned: "+num);      
                if(RandomBoolean()==true)
                {
                    System.err.println("Can "+num+" dented and removed.");     
                }
                else
                {               
                    s2.acquire(1);
                    System.out.println("Can "+num+" proceed to sterilisation..."); 
                    
                }               
                
            }catch(Exception e){}
        }
    }
}
