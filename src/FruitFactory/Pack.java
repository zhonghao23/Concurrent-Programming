package FruitFactory;

import java.util.concurrent.Semaphore;

public class Pack extends Thread{
    Semaphore s9,s10;
    int pack=0,i=0;
    
    public Pack (Semaphore s9,Semaphore s10)
    {
        this.s9=s9;
        this.s10=s10;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                while(s9.availablePermits()>0);
                s9.release(6);
                pack++;
                System.out.println("Packaged: "+pack);
                //while(s10.availablePermits()==0);  //Pause if loading bay is full
                if(pack%27==0){   
                    s10.acquire(1);      
                    System.out.println("Boxed: "+pack/27);
                }
             
            }catch(Exception e){}
        }
    }
}
