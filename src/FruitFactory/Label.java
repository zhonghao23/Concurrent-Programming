package FruitFactory;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Label extends Thread{
   
    Semaphore s7,s8;
    int num=0;
    public static boolean RandomBoolean() {
        return Math.random() < 0.1;
    }
    
    public Label (Semaphore s7,Semaphore s8)
    {
        this.s7=s7;
        this.s8=s8;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                while(s7.availablePermits()>0);
                s7.release(1);
                num++;
                System.out.println("Labelled: "+num);
                
                s8.acquire(1);               
            }catch(Exception e){}
        }
    }
}
