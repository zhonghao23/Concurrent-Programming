package FruitFactory;

import java.util.concurrent.Semaphore;

public class Steriliser extends Thread{
    Semaphore s2,s3;
    int num=0,i=0;
    
    public Steriliser (Semaphore s2,Semaphore s3)
    {
        this.s2=s2;
        this.s3=s3;
    }
    
    public void run()
    {
        while(true)
        {
            try 
            {
                while(s2.availablePermits()>0);
                s2.release(4);
                num+=4;
                
                
                System.out.println("Sterilised: "+num);        
                for(i=0;i<4;i++) {
                    //while(s3.availablePermits()==0);
                    s3.acquire(1);    
                }
                
                                
            }catch(Exception e){}
        }
    }

}
