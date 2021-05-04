package FruitFactory;

import java.util.concurrent.Semaphore;

public class Entry extends Thread{
   
    Semaphore s1;
    int num=0;
    public Entry (Semaphore s1)
    {
        this.s1=s1;
    }
    
    public void run()
    {

            for(int i=0; i<5000; i++){
                synchronized(this){
                this.notify();}
                try 
                {
                    //Thread.sleep(500);
                    //s1.acquire(1);
                    num++;
                    System.out.println("Entry Can: "+num);     
                }catch(Exception e){}
            }
            
            System.err.println("All cans have entered the factory!");   
    }
}

