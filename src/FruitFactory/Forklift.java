package FruitFactory;

import static FruitFactory.LabelScanner.RandomBoolean;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Forklift extends Thread{
   Loading l;
   
   Semaphore s11,s12;
    int box=0;
    public static boolean RandomBoolean() {
        return Math.random() > 0.5; //Forklift prone to break down
    }
    public Forklift (Semaphore s11,Loading l)
    {
        this.s11=s11;
        //this.s12=s12;
        this.l=l;
    }
   
    public void run()
    {
        while(true)
        {   
            
            try
            {   
                synchronized(l){
                    l.wait();
                }
                if(RandomBoolean()==true)
                {
                    s11.release(1);
                    box++;
                    System.out.println("Transferred to Van: "+box);
                }
                else
                {
                    System.err.println("Forklift breakdown");
                    s11.release(1);
                }
                
            }catch(Exception e){}
        }
    }
}
